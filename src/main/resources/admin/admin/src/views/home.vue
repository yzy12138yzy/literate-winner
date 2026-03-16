<template>
	<div class="home-content">
		<!-- title -->
		<div id="home-title" class="home-title animate__animated">
			<div class="titles" >
				<span>欢迎使用</span>
				{{this.$project.projectName}}
			</div>
		</div>
		<div id="user-box" class="user-box animate__animated">
			<div class="user-top-box">
				<el-image class="avatar" :src="avatar?this.$base.url + avatar : require('@/assets/img/avator.png')"></el-image>
				<div class="user-top-item">
					<div class="nickname">
						<span>用户名</span>
						{{this.$storage.get('adminName')}}
					</div>
					<div class="role">
						<span>角色</span>
						{{this.$storage.get('role')}}
					</div>
				</div>
			</div>
			<div class="user-bottom-box">
				<div class="ip">
					<span>上次登录地址：</span>
					<span>{{locationIp?locationIp:'首次登录'}}</span>
				</div>
				<div class="time">
					<span>上次登录时间：</span>
					<span>{{locationTime?locationTime:'首次登录'}}</span>
				</div>
			</div>
		</div>
		<div id="news-box" class="news-box animate__animated">
			<div class="news-title">
				公告资讯
			</div>
			<div class="news-list">
				<div class="news-item" v-for="(item,index) in newsList" :index="index" @click="newsDetailClick(item)">
					<div class="news-text">
						{{item.title}}
					</div>
					<div class="news-time">
						{{item.addtime}}
					</div>
				</div>
			</div>
		</div>
		<el-dialog :visible.sync="newsVisible" title="公告资讯" :append-to-body="true" width="60%">
			<div style="width: 100%;text-align: center;font-size: 20px;color: #000;padding: 0 0 20px;font-weight: bold;">{{newsDetail.title}}</div>
			<div style="width: 100%;">
				<div class="ql-snow ql-editor" v-html="newsDetail.content"></div>
			</div>
		</el-dialog>
	
		<!-- echarts -->
	</div>
</template>
<script>
import 'animate.css'
//0
import router from '@/router/router-static'
import * as echarts from 'echarts'
export default {
	data() {
		return {
			newsList: [],
			newsDetail: {},
			newsVisible: false,
		};
	},
	mounted(){
		this.init();
		window.addEventListener('scroll', this.handleScroll)
		setTimeout(()=>{
			this.handleScroll()
		},100)
	},
	computed: {
		avatar(){
			return this.$storage.get('headportrait')?this.$storage.get('headportrait'):''
		},
		locationIp(){
			return this.$storage.get('beforeLocation')?this.$storage.get('beforeLocation'):''
		},
		locationTime(){
			return this.$storage.get('beforeTime')?this.$storage.get('beforeTime'):''
		},
	},
	methods:{
		handleScroll() {
			let arr = [
				{id:'home-title',css:'animate__bounceInUp'},
				{id:'user-box',css:'animate__bounceInUp'},
				{id:'news-box',css:'animate__bounceInUp'},
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
		init(){
			if(this.$storage.get('Token')){
				this.$http({
					url: `${this.$storage.get('sessionTable')}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code != 0) {
						router.push({ name: 'login' })
					}
				});
			}else{
				router.push({ name: 'login' })
			}
			this.getNewsList()
		},
		getNewsList(){
			let params = {
				page: 1,
				limit: 6,
				sort: 'addtime',
				order: 'desc',
			}
			this.$http({
				url: `news/list`,
				method: "get",
				params: params
			}).then(res => {
				if(res.data&&res.data.code==0){
					this.newsList = res.data.data.list
				}
			});
		},
		newsDetailClick(row){
			this.newsDetail = row
			this.newsVisible = true
		},
	}
};
</script>
<style lang="scss" scoped>
	.home-content {
		padding: 20px 30px;
		color: #666;
		display: flex;
		font-size: 16px;
		justify-content: flex-start;
		flex-wrap: wrap;
		.home-title {
			border-radius: 5px;
			padding: 10px 0;
			box-shadow: 0 0px 0px rgba(0,0,0,.3);
			margin: 10px 0;
			display: none;
			width: 100%;
			justify-content: center;
			align-items: center;
			transition: 0.3s;
			order: -2;
			.titles {
				padding: 0 0 0 12px;
				color: #333;
				font-size: 24px;
				line-height: 44px;
				span {
				}
			}
		}
		.home-title:hover {
			transform: translate3d(0, 0px, 0);
			z-index: 1;
			background: rgba(255,255,255,.12);
		}
		.user-box {
			border: 0px solid #ccc;
			padding: 10px 20px;
			margin: 10px;
			display: block;
			transition: 0.5s;
			border-radius: 20px;
			box-shadow: 0 0px 0px rgba(0,0,0,.3);
			flex-direction: column;
			background: #fff;
			flex: 1;
			width: calc(30% - 20px);
			justify-content: center;
			align-items: center;
			.user-top-box {
				padding: 20px 0 20px;
				margin: 0 0 10px;
				display: flex;
				border-color: #ccc;
				border-width:  0 0 1px;
				align-items: center;
				border-style: solid;
				.avatar {
					border-radius: 100%;
					object-fit: cover;
					width: 100px;
					min-width: 100px;
					height: 100px;
				}
				.user-top-item {
					width: 100%;
					.nickname {
						padding: 0;
						margin: 0 0 5px;
						color: inherit;
						font-size: inherit;
						line-height: 1.5;
						span {
							padding: 0;
							margin: 0 10px;
							color: #000;
							font-weight: 600;
							font-size: inherit;
							line-height: 1.5;
						}
					}
					.role {
						padding: 0;
						color: inherit;
						font-size: inherit;
						line-height: 1.5;
						span {
							padding: 0;
							margin: 0 10px;
							color: #000;
							font-weight: 600;
							font-size: inherit;
							line-height: 1.5;
						}
					}
				}
			}
			.user-bottom-box {
				flex-direction: column;
				display: flex;
				line-height: 2;
				align-items: flex-start;
				.ip {
					padding: 10px 0 0;
					display: flex;
					justify-content: center;
					span:nth-child(1) {
						color: #000;
					}
					span:nth-child(2) {
						color: #666;
					}
				}
				.time {
					display: flex;
					justify-content: center;
					span:nth-child(1) {
						color: #000;
					}
					span:nth-child(2) {
						color: #666;
					}
				}
			}
		}
		.user-box:hover {
			border: 0;
			transform: translate3d(0, -5px, 0);
		}
		.news-box {
			border: 0px solid #ccc;
			padding: 30px;
			margin: 10px;
			display: flex;
			transition: 0.5s;
			border-radius: 20px;
			box-shadow: 0 0px 0px rgba(0,0,0,.3);
			flex-direction: column;
			background: #fff;
			flex: 1;
			width: calc(30% - 20px);
			justify-content: center;
			align-items: center;
			.news-title {
				padding: 0 2px;
				margin: 0 0 20px;
				color: #000;
				font-weight: 600;
				font-size: 20px;
				border-color: #999;
				border-width: 0 0 2px;
				line-height: 44px;
				border-style: solid;
			}
			.news-list {
				flex-direction: column;
				display: flex;
				width: 100%;
				justify-content: space-between;
				align-items: center;
			}
			.news-item {
				border: 1px solid #99999950;
				padding: 10px 0;
				display: flex;
				width: 100%;
				border-width: 0 0 1px;
				justify-content: space-between;
				align-items: center;
				.news-text {
					overflow: hidden;
					color: #000;
					white-space: nowrap;
					background: none;
					font-weight: 500;
					display: block;
					width: calc(100% - 75px);
					font-size: 14px;
					text-overflow: ellipsis;
				}
				.news-time {
					overflow: hidden;
					color: #666;
					width: 85px;
					font-size: 14px;
					text-align: right;
					height: 20px;
				}
			}
		}
		.news-box:hover {
			transform: translate3d(0, -5px, 0);
		}
	}
	
	.echarts-flag-2 {
		display: flex;
		flex-wrap: wrap;
		justify-content: space-between;
		padding: 10px 20px;
		background: rebeccapurple;
	
		&>div {
			width: 32%;
			height: 300px;
			margin: 10px 0;
			background: rgba(255,255,255,.1);
			border-radius: 8px;
			padding: 10px 20px;
		}
	}
	.animate__animated {
		animation-fill-mode: none;
	}
</style>
