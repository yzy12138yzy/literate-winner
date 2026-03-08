import requests
from bs4 import BeautifulSoup
import re
import concurrent.futures


def replace_multiple_chars_with_regex(input_string, chars_to_replace, replacement):
    pattern = "[" + re.escape("".join(chars_to_replace)) + "]"
    return re.sub(pattern, replacement, input_string)


def get_data(detail_args):
    title, url = detail_args
    response = requests.post(url, headers=headers)

    with open(f"{title}.txt", 'w', encoding='utf-8') as f:
        count = 0
        for item in response.json()["data"]["question"]:
            count += 1
            print(f"{title} ----- 题目{count} 爬取成功!")
            question_id = item["question_id"]
            exam_type = item["exam_type"]
            problem = item["topic_name"]
            problem = replace_multiple_chars_with_regex(problem, ["<p>", "</p>", "\n"], " ")

            f.write(f"{count}.\n考试类型:{exam_type}\n{problem}\n")
            options = item["options"]
            for option in options:
                option_name = option["option_name"]
                option_content = option["option_content"]
                f.write(f"{option_name} : {option_content} \n")
            answer = item["answer"]
            legal = str(item["legal_basis"])
            legal = replace_multiple_chars_with_regex(legal, ["<p>", "</p>", "\n"], " ")

            solution_one = item["solutions_give"]
            solution_two = item["solutions"]
            solutions = solution_two + solution_one
            solutions = replace_multiple_chars_with_regex(solutions, ["<p>", "</p>", "\n"], "")
            f.write(f"法条来源: {legal}\n答案:{answer}\n题目解析:{solutions}\n\n\n\n")

            page = 1
            comment_save_string = ""
            while True:
                url = f"https://www.xueipr.com/exam/comment?examId={question_id}&page={page}&pageSize=5"
                comment_data = requests.get(url, headers=headers).json()["data"]["comments"]
                if comment_data:
                    comment_save_string += f"第{page}页---回答" + "\n"
                    for item in comment_data:
                        comment_save_string += "昵称:" + item["user"]["username"] + ":" + item["content"] + "\n"
                        for j in item["reply"]:
                            comment_save_string += "    回复:" + "昵称:" + j["replyUsername"] + ":" + j['content']
                else:
                    break
                page += 1
                comment_save_string += "\n" * 2
            f.write(comment_save_string)


def simple_web_crawler(url):
    try:
        response = requests.get(url, headers=headers)
        # 检查响应状态码
        if response.status_code == 200:
            # 使用BeautifulSoup解析HTML内容
            soup = BeautifulSoup(response.content, 'html.parser')

            # 查找具有特定属性的标签
            title_tag = soup.find_all("li", attrs={"title": True})

            result = {}
            for tag in title_tag:
                title = tag.get_text()
                id = tag.attrs["data-id"]
                data_type = tag.attrs["data-type"]
                result[title] = [id, data_type]
            return result

        else:
            print(f"Failed to retrieve content. Status code: {response.status_code}")

    except Exception as e:
        print(f"An error occurred: {str(e)}")


# 测试爬虫程序
url = "https://www.xueipr.com/exam/examBrowse/list?type=1"

"""https://www.xueipr.com/exam/examBrowse/details?examType=2&type=chapter&examId=100"""

headers = {
    "Cookie" : "Hm_lvt_8eb7a07786a167d06b5469b28c3dd412=1712465664; PHPSESSID=huqva4d1b3i3n1vn2ijvfcveqi; remember_web_59ba36addc2b2f9401580f014c7f58ea4e30989d=eyJpdiI6IlFBS0NPb1RvSnhyZTBod2NrS3VTaVE9PSIsInZhbHVlIjoiYzZqU0FKZFFZdzlHbXYya0RJQ1lFMTFHa2xnZVBMeHc4a0ZIbmxBYnU2NEx0YnFNMmNhQ3RBS2VLelVEdVRDYStnbkxyU2s4RFFGZFFSMlZSSU5IcUkzM09Gb0RPWFlyXC9DMjF4dVRIcDZSdWtWVVQ4bFVsU1l1Ynh0UTVaanNTWTdKdE1YOVpac1M3Q25ScEd6M0F6Zz09IiwibWFjIjoiYTU3ZjEwY2FhMjRkOTFjZWNlZTY2Mzc2ZWUyNjIxOTk1OGQxMTU0YWU4YmU5ZjA5ODlkMWY0MDAwMGU3ZmY4YiJ9; tokenv2=288d50bc53a35a5535fbae79ff183ddf; Hm_lpvt_8eb7a07786a167d06b5469b28c3dd412=1712565411; laravel_session=eyJpdiI6InhQTzdjRnRIME9CRWdsOTJBU09SVEE9PSIsInZhbHVlIjoidFBrbHNmTmN1VFh5VGJ3TTlVRHZtc05FWmVOdVRyNmNDNDhFczZDSGo2Vk40VlhlMzhGZHhMMXRUanFJZERraEdvd0ZGeUw2ZGhYY2tFd0FESWttdWc9PSIsIm1hYyI6ImNmMWMyOGI1N2UyZDUyZTNhMWY2NDFhMjNlMjQ0MjQ0OWM1MTNmZmIwYzNmZjM4MGRmNjcxMWY5N2RkMDZhMjgifQ%3D%3D",
    'Host': 'www.xueipr.com',
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.57'
}
# 指定要爬取的网页URL
result = simple_web_crawler(url)
print(result)

detail_list = []
for title, detail in result.items():
    id_, data_type = detail
    url = f"""https://www.xueipr.com/exam/examBrowse/question?examType={data_type}&type=chapter&examId={id_}"""
    print(f"{title} 获取成功！ id: {id_}")
    detail_list.append([title, url])

# 使用ThreadPoolExecutor创建线程池
with concurrent.futures.ThreadPoolExecutor(max_workers=12) as executor:
    # 提交任务并获取Future对象列表
    future_to_url = {executor.submit(get_data, args): args for args in detail_list}

    # 遍历Future对象，获取爬取结果
    for future in concurrent.futures.as_completed(future_to_url):
        title, url = future_to_url[future]
        try:
            future.result()  # 获取爬取结果
        except Exception as e:
            print(f"爬取 {url} 失败: {e}")



