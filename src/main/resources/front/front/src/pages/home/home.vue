<template>
	<div class="home-preview">




		<!-- 新闻资讯 -->
		<div id="animate_newsnews" class="news animate__animated">
			<div class="news_title_box">
				<span class="news_title">公告资讯</span>
				<span class="news_subhead">{{'news'.toUpperCase()}}</span>
			</div>
			<div v-if="newsList.length" class="list list20 index-pv1">
				<div v-for="(item,index) in newsList" :key="index"  @click="toDetail('newsDetail', item)" class="list-item animation-box">
					<div class="img-box">
						<img :src="baseUrl + item.picture" class="image">
					</div>
					<div class="infoBox">
						<div class="infoBox-left">
							<div class="name">{{item.title}}</div>
							<div class="time_item">
								<span class="icon iconfont icon-shijian21"></span>
								<span class="label">发布时间：</span>
								<span class="text">{{item.addtime.split(' ')[0]}}</span>
							</div>
							<div class="publisher_item">
								<span class="icon iconfont icon-touxiang18"></span>
								<span class="label">发布人：</span>
								<span class="text">{{item.name}}</span>
							</div>
							<div class="like_item">
								<span class="icon iconfont icon-zan10"></span>
								<span class="label">点赞：</span>
								<span class="text">{{item.thumbsupnum}}</span>
							</div>
							<div class="collect_item">
								<span class="icon iconfont icon-shoucang10"></span>
								<span class="label">收藏：</span>
								<span class="text">{{item.storeupnum}}</span>
							</div>
							<div class="view_item">
								<span class="icon iconfont icon-liulan13"></span>
								<span class="label">浏览次数：</span>
								<span class="text">{{item.clicknum}}</span>
							</div>
						</div>
						<div class="desc">{{item.introduction}}</div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('news')">
				<span class="text">更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
		</div>
		<!-- 新闻资讯 -->
		<!-- 商品推荐 -->
		<div id="animate_recommendjiazhengfuwu" class="recommend animate__animated">
			<div class="recommend_title_box">
				<span class="recommend_title">家政服务推荐</span>
				<span class="recommend_subhead">{{'jiazhengfuwu'.toUpperCase()}} RECOMMEND</span>
			</div>
			<!-- 样式一 -->
			<div class="list list1 index-pv1">
				<div v-for="(item,index) in jiazhengfuwuRecommend" :key="index" @click="toDetail('jiazhengfuwuDetail', item)" class="list-item animation-box">
					<img v-if="preHttp(item.fuwutupian)" :src="item.fuwutupian.split(',')[0]" alt="" />
					<img v-else :src="baseUrl + (item.fuwutupian?item.fuwutupian.split(',')[0]:'')" alt="" />
					<div class="name line1">{{item.fuwumingcheng}}</div>
					<div class="name line1">{{item.fuwuleixing}}</div>
					<div class="name line1">服务价格:{{item.fuwujiage}}</div>
				
					<div class="time_item">
						<span class="icon iconfont icon-shijian21"></span>
						<span class="label">发布时间：</span>
						<span class="text">{{item.addtime.split(' ')[0]}}</span>
					</div>
					<div class="publisher_item">
						<span class="icon iconfont icon-touxiang18"></span>
						<span class="label">发布人：</span>
						<span class="text">{{item.dianpumingcheng}}</span>
					</div>
					<div class="collect_item">
						<span class="icon iconfont icon-shoucang10"></span>
						<span class="label">收藏：</span>
						<span class="text">{{item.storeupnum}}</span>
					</div>
					<div class="view_item">
						<span class="icon iconfont icon-liulan04"></span>
						<span class="label">浏览次数：</span>
						<span class="text">{{item.clicknum}}</span>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('jiazhengfuwu')">
				<span class="text">更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
		</div>
		<!-- 商品推荐 -->
	</div>
</template>

<script>
import 'animate.css'
import Swiper from "swiper";

	export default {
		//数据集合
		data() {
			return {
				baseUrl: '',
				newsList: [],
				jiazhengfuwuRecommend: [],





			}
		},
		created() {
			this.baseUrl = this.$config.baseUrl;
			this.getNewsList();
			this.getList();
		},
		mounted() {
			window.addEventListener('scroll', this.handleScroll)
			setTimeout(()=>{
				this.handleScroll()
			},100)
			
			this.swiperChanges()
		},
		beforeDestroy() {
			window.removeEventListener('scroll', this.handleScroll)
		},
		//方法集合
		methods: {
			swiperChanges() {
				setTimeout(()=>{
				},750)
			},

			listIndexClick11(index, name) {
				this['listIndex11' + name] = index[this['listColumn11' + name]]
				this.getList()
			},

			handleScroll() {
				let arr = [
					{id:'about',css:'animate__'},
					{id:'system',css:'animate__'},
					{id:'animate_recommendjiazhengfuwu',css:'animate__'},
					{id:'animate_newsnews',css:'animate__'},
				]
			
				for (let i in arr) {
					let doc = document.getElementById(arr[i].id)
					if (doc) {
						let top = doc.offsetTop
						let win_top = window.innerHeight + window.pageYOffset
						// console.log(top,win_top)
						if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
							// console.log(doc)
							doc.classList.add(arr[i].css)
						}
					}
				}
			},
			preHttp(str) {
				return str && str.substr(0,4)=='http';
			},
			preHttp2(str) {
				return str && str.split(',w').length>1;
			},
			getNewsList() {
				let data = {
					page: 1,
					limit: 6,
					sort: 'addtime',
					order: 'desc'
				}
				this.$http.get('news/list', {params: data}).then(res => {
					if (res.data.code == 0) {
						this.newsList = res.data.data.list;
					
					}
				});
			},
			getList() {
				let autoSortUrl = "";
				let data = {}
				autoSortUrl = "jiazhengfuwu/autoSort";
				if(localStorage.getItem('frontToken')) {
					autoSortUrl = "jiazhengfuwu/autoSort2";
				}
				data = {
					page: 1,
					limit: 6,
				}
				this.$http.get(autoSortUrl, {params: data}).then(res => {
					if (res.data.code == 0) {
						this.jiazhengfuwuRecommend = res.data.data.list;
					}
				});
			
			},
			toDetail(path, item) {
				this.$router.push({path: '/index/' + path, query: {id: item.id}});
			},
			moreBtn(path) {
				this.$router.push({path: '/index/' + path});
			}
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
		margin: 0px auto;
		flex-direction: column;
		background: #fff;
		display: flex;
		width: 100%;
		.news {
			padding: 0;
			margin: 15px 0;
			background: none;
			width: 100%;
			position: relative;
			order: 4;
			.news_title_box {
				padding: 0 0 5px;
				margin: 0 auto;
				background: none;
				width: 1200px;
				border-color: #3B5D9A;
				border-width: 0 0 2px;
				position: relative;
				border-style: solid;
				text-align: left;
				.news_title {
					margin: 0 10px 0 0;
					color: #3B5D9A;
					background: none;
					width: auto;
					font-size: 26px;
					line-height: 40px;
				}
				.news_subhead {
					margin: 0;
					color: #999;
					display: none;
					width: auto;
					font-size: 18px;
					line-height: 40px;
					text-align: center;
				}
			}
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
			.list20 {
				padding: 0;
				margin: 0 auto;
				background: #fff;
				display: flex;
				width: 1200px;
				border-color: #eaeaea;
				border-width: 0 0 0 1px;
				justify-content: space-between;
				border-style: solid;
				flex-wrap: wrap;
				height: auto;
				.list-item {
					cursor: pointer;
					padding: 10px;
					margin: 0;
					background: #fff;
					width: calc(33.33% - 0px);
					border-color: #eaeaea;
					border-width: 0 1px 1px 0;
					border-style: solid;
					height: auto;
					.img-box {
						border: 0px solid #eee;
						padding: 0;
						overflow: hidden;
						background: #fff;
						width: 160px;
						float: left;
						height: 120px;
						img {
							object-fit: cover;
							display: block;
							width: 100%;
							height: 100%;
						}
					}
					.infoBox {
						padding: 0;
						overflow: hidden;
						display: block;
						width: calc(100% - 180px);
						float: right;
						height: auto;
						.infoBox-left {
							padding: 0;
							margin: 0;
							color: #666;
							width: 100%;
							.name {
								padding: 0;
								overflow: hidden;
								color: #333;
								white-space: nowrap;
								font-weight: 600;
								width: 100%;
								font-size: 14px;
								line-height: 36px;
								text-overflow: ellipsis;
							}
							.time_item {
								padding: 0 10px;
								display: none;
								border-color: #ddd;
								border-width: 0 0 1px 0;
								border-style: dashed;
								.icon {
									margin: 0 2px 0 0;
									color: #666;
									font-size: 14px;
									line-height: 28px;
								}
								.label {
									color: #666;
									font-size: 14px;
									line-height: 1.5;
								}
								.text {
									color: #666;
									font-size: 14px;
									line-height: 1.5;
								}
							}
							.publisher_item {
								padding: 0 10px;
								display: none;
								border-color: #ddd;
								border-width: 0 0 1px 0;
								border-style: dashed;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									font-size: 14px;
									line-height: 28px;
								}
								.label {
									color: #666;
									font-size: 14px;
									line-height: 1.5;
								}
								.text {
									color: #666;
									font-size: 14px;
									line-height: 28px;
								}
							}
							.like_item {
								padding: 0 10px;
								display: none;
								border-color: #ddd;
								border-width: 0 0 1px 0;
								border-style: dashed;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									font-size: 14px;
									line-height: 28px;
								}
								.label {
									color: #666;
									font-size: 14px;
									line-height: 1.5;
								}
								.text {
									color: #666;
									font-size: 14px;
									line-height: 28px;
								}
							}
							.collect_item {
								padding: 0 10px;
								display: none;
								border-color: #ddd;
								border-width: 0 0 1px 0;
								border-style: dashed;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									font-size: 14px;
									line-height: 28px;
								}
								.label {
									color: #666;
									font-size: 14px;
									line-height: 1.5;
								}
								.text {
									color: #666;
									font-size: 14px;
									line-height: 28px;
								}
							}
							.view_item {
								padding: 0 10px;
								display: none;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									font-size: 14px;
									line-height: 28px;
								}
								.label {
									color: #666;
									font-size: 14px;
									line-height: 1.5;
								}
								.text {
									color: #666;
									font-size: 14px;
									line-height: 28px;
								}
							}
						}
						.desc {
							margin: 0;
							overflow: hidden;
							color: #666;
							display: flex;
							width: 100%;
							font-size: 14px;
							line-height: 24px;
							align-items: center;
							flex-wrap: wrap;
							height: 72px;
						}
					}
					
				}
				.list-item:hover {
					.infoBox {
						.infoBox-left {
							.name {
							}
							.time_item {
								.icon {
									color: #000;
								}
								.label {
									color: #000;
								}
								.text {
									color: #000;
								}
							}
							.publisher_item {
								.icon {
									color: #000;
								}
								.label {
									color: #000;
								}
								.text {
									color: #000;
								}
							}
							.like_item {
								.icon {
									color: #000;
								}
								.label {
									color: #000;
								}
								.text {
									color: #000;
								}
							}
							.collect_item {
								.icon {
									color: #000;
								}
								.label {
									color: #000;
								}
								.text {
									color: #000;
								}
							}
							.view_item {
								.icon {
									color: #000;
								}
								.label {
									color: #000;
								}
								.text {
									color: #000;
								}
							}
						}
						.desc {
						}
					}
				}
			}
			.moreBtn {
				border: 0px solid #999;
				cursor: pointer;
				padding: 0;
				margin: 0;
				display: inline-block;
				line-height: 32px;
				right: calc((100% - 1200px)/2);
				float: right;
				top: 5px;
				background: none;
				width: auto;
				position: absolute;
				text-align: right;
				.text {
					color: #999;
					font-size: 14px;
				}
				.icon {
					color: #999;
					font-size: 14px;
				}
			}
		}
		.recommend {
			padding: 0;
			margin: 15px 0;
			background: #fff;
			width: 100%;
			position: relative;
			.recommend_title_box {
				padding: 0px;
				margin: 0 auto 10px;
				background: none;
				width: 1200px;
				position: relative;
				text-align: left;
				.recommend_title {
					margin: 0;
					color: #000;
					background: none;
					width: auto;
					font-size: 24px;
					line-height: 36px;
				}
				.recommend_subhead {
					margin: 0;
					color: #999;
					display: none;
					width: auto;
					font-size: 18px;
					line-height: 40px;
					text-align: center;
				}
			}
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0s;
			}
			.list1 {
				padding: 0;
				margin: 0 auto;
				background: #fff;
				width: 1200px;
				border-color: #eaeaea;
				border-width: 0 0 0 1px;
				border-style: solid;
				height: auto;
				.list-item {
					cursor: pointer;
					padding: 10px;
					margin: 0;
					color: #888;
					display: inline-block;
					font-size: 14px;
					border-color: #eaeaea;
					background: #fff;
					width: calc(16.66% - 0px);
					border-width: 1px 1px 1px 0;
					position: relative;
					border-style: solid;
					height: auto;
					img {
						margin: 0 0 5px;
						object-fit: cover;
						display: block;
						width: 100%;
						height: 180px;
					}
					.name {
						padding: 0 10px;
						overflow: hidden;
						color: #333;
						white-space: nowrap;
						font-weight: 600;
						width: 100%;
						font-size: 14px;
						line-height: 30px;
						text-overflow: ellipsis;
					}
					.price {
						padding: 0 10px;
						color: #f00;
						font-size: 14px;
						line-height: 1.5;
					}
					.time_item {
						padding: 0 10px;
						display: none;
						.icon {
							margin: 0 2px 0 0;
							color: inherit;
							display: none;
							font-size: inherit;
							line-height: 1.5;
						}
						.label {
							color: inherit;
							font-size: inherit;
							line-height: 1.5;
						}
						.text {
							color: inherit;
							font-size: inherit;
							line-height: 1.5;
						}
					}
					.publisher_item {
						padding: 0 10px;
						display: none;
						.icon {
							margin: 0 2px 0 0;
							color: inherit;
							display: none;
							font-size: inherit;
							line-height: 1.5;
						}
						.label {
							color: inherit;
							font-size: inherit;
							line-height: 1.5;
						}
						.text {
							color: inherit;
							font-size: inherit;
							line-height: 1.5;
						}
					}
					.like_item {
						padding: 0 10px;
						display: none;
						.icon {
							margin: 0 2px 0 0;
							color: inherit;
							display: none;
							font-size: inherit;
							line-height: 1.5;
						}
						.label {
							color: inherit;
							font-size: inherit;
							line-height: 1.5;
						}
						.text {
							color: inherit;
							font-size: inherit;
							line-height: 1.5;
						}
					}
					.collect_item {
						padding: 0 10px;
						display: none;
						.icon {
							margin: 0 2px 0 0;
							color: inherit;
							display: none;
							font-size: inherit;
							line-height: 1.5;
						}
						.label {
							color: inherit;
							font-size: inherit;
							line-height: 1.5;
						}
						.text {
							color: inherit;
							font-size: inherit;
							line-height: 1.5;
						}
					}
					.view_item {
						padding: 0 10px;
						display: none;
						.icon {
							margin: 0 2px 0 0;
							color: inherit;
							display: none;
							font-size: inherit;
							line-height: 1.5;
						}
						.label {
							color: inherit;
							font-size: inherit;
							line-height: 1.5;
						}
						.text {
							color: inherit;
							font-size: inherit;
							line-height: 1.5;
						}
					}
				}
			}
			.moreBtn {
				border: 0px solid #999;
				cursor: pointer;
				padding: 0;
				margin: 0;
				display: inline-block;
				line-height: 32px;
				right: calc((100% - 1200px)/2);
				float: right;
				top: 5px;
				background: none;
				width: auto;
				position: absolute;
				text-align: right;
				.text {
					color: #999;
					font-size: 14px;
				}
				.icon {
					color: #999;
					font-size: 14px;
				}
			}
		}
	}
</style>
