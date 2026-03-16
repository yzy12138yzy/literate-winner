import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
	import news from '@/views/modules/news/list'
	import baojieayi from '@/views/modules/baojieayi/list'
	import fuwupingjia from '@/views/modules/fuwupingjia/list'
	import jiazhenggongsi from '@/views/modules/jiazhenggongsi/list'
	import fuwuleixing from '@/views/modules/fuwuleixing/list'
	import fuwujilu from '@/views/modules/fuwujilu/list'
	import fuwufenpei from '@/views/modules/fuwufenpei/list'
	import quxiaoyuyue from '@/views/modules/quxiaoyuyue/list'
	import yonghu from '@/views/modules/yonghu/list'
	import discussjiazhengfuwu from '@/views/modules/discussjiazhengfuwu/list'
	import jiazhengfuwu from '@/views/modules/jiazhengfuwu/list'
	import fuwuyuyue from '@/views/modules/fuwuyuyue/list'
	import config from '@/views/modules/config/list'
	import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: '系统首页',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: '系统首页',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
	}, {
		path: '/updatePassword',
		name: '修改密码',
		component: UpdatePassword,
		meta: {icon:'', title:'updatePassword'}
	}, {
		path: '/pay',
		name: '支付',
		component: pay,
		meta: {icon:'', title:'pay'}
	}, {
		path: '/center',
		name: '个人信息',
		component: center,
		meta: {icon:'', title:'center'}
	}
	,{
		path: '/news',
		name: '公告资讯',
		component: news
	}
	,{
		path: '/baojieayi',
		name: '保洁阿姨',
		component: baojieayi
	}
	,{
		path: '/fuwupingjia',
		name: '服务评价',
		component: fuwupingjia
	}
	,{
		path: '/jiazhenggongsi',
		name: '家政公司',
		component: jiazhenggongsi
	}
	,{
		path: '/fuwuleixing',
		name: '服务类型',
		component: fuwuleixing
	}
	,{
		path: '/fuwujilu',
		name: '服务记录',
		component: fuwujilu
	}
	,{
		path: '/fuwufenpei',
		name: '服务分配',
		component: fuwufenpei
	}
	,{
		path: '/quxiaoyuyue',
		name: '取消预约',
		component: quxiaoyuyue
	}
	,{
		path: '/yonghu',
		name: '用户',
		component: yonghu
	}
	,{
		path: '/discussjiazhengfuwu',
		name: '家政服务评论',
		component: discussjiazhengfuwu
	}
	,{
		path: '/jiazhengfuwu',
		name: '家政服务',
		component: jiazhengfuwu
	}
	,{
		path: '/fuwuyuyue',
		name: '服务预约',
		component: fuwuyuyue
	}
	,{
		path: '/config',
		name: '轮播图管理',
		component: config
	}
	,{
		path: '/newstype',
		name: '公告资讯分类',
		component: newstype
	}
	]
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {icon:'', title:'login'}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {icon:'', title:'register'}
	},
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;
