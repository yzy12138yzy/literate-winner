import tkinter as tk
from tkinter import filedialog
import cv2
import torch
from PIL import Image, ImageTk
from model.ResNet import *
import os
import numpy as np
import threading


def select_image():
    # 打开文件对话框，选择图像文件
    file_path = filedialog.askopenfilename()
    threading.Thread(target=predict, args=(file_path, device)).start()

    # 检查用户是否选择了文件
    if file_path:
        # 使用PIL加载图像
        image = Image.open(file_path)

        # 使用Tkinter PhotoImage将图像转换为Tkinter可用的格式
        photo = ImageTk.PhotoImage(image)

        # 在标签上显示图像
        image_label.config(image=photo)
        image_label.image = photo  # 保持引用，否则图像可能无法显示


def predict(image_path, device):
    if os.path.exists(image_path):
        image_ = cv2.resize(cv2.imread(image_path), (224, 224))
        image_ = np.transpose(image_, (2, 0, 1))
        image_ = np.expand_dims(image_, axis=0)
        image_ = torch.tensor(image_).to(torch.float32).to(device)
        _, result = torch.max(net(image_), dim=1)
        result = "猫" if result else "狗"
        result_label.config(text=f"预测结果:{result}")
    else:
        print("path is not exist")


model_parameter_dir = "./model_parameter"
# 创建主窗口
root = tk.Tk()
root.title("选择图片并展示")
net = ResNet()
net_parameter = torch.load(os.path.join(model_parameter_dir, f"{net_name}.pt"))
net.load_state_dict(net_parameter)
net.eval()
device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
net.to(device=device)

width = 400
height = 400
screen_width = root.winfo_screenwidth()
screen_height = root.winfo_screenheight()

# 计算窗口的 x 和 y 坐标使其处于屏幕中央
x = (screen_width - width) // 2
y = (screen_height - height) // 2

# 设置窗口的几何参数
root.geometry(f"{width}x{height}+{x}+{y}")

# 创建选择按钮
select_button = tk.Button(root, text="选择图片", command=select_image)
select_button.place(x=100, y=10)

result_label = tk.Label(root, text="待识别....", fg='red')
result_label.place(x=220, y=10)

# 创建用于显示图像的标签
image_label = tk.Label(root)
image_label.place(x=5, y=50)

# 运行主事件循环
root.mainloop()
