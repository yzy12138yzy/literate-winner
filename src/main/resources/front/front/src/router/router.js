import VueRouter from 'vue-router'
//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import jiazhenggongsiList from '../pages/jiazhenggongsi/list'
import jiazhenggongsiDetail from '../pages/jiazhenggongsi/detail'
import jiazhenggongsiAdd from '../pages/jiazhenggongsi/add'
import baojieayiList from '../pages/baojieayi/list'
import baojieayiDetail from '../pages/baojieayi/detail'
import baojieayiAdd from '../pages/baojieayi/add'
import fuwuleixingList from '../pages/fuwuleixing/list'
import fuwuleixingDetail from '../pages/fuwuleixing/detail'
import fuwuleixingAdd from '../pages/fuwuleixing/add'
import jiazhengfuwuList from '../pages/jiazhengfuwu/list'
import jiazhengfuwuDetail from '../pages/jiazhengfuwu/detail'
import jiazhengfuwuAdd from '../pages/jiazhengfuwu/add'
import fuwuyuyueList from '../pages/fuwuyuyue/list'
import fuwuyuyueDetail from '../pages/fuwuyuyue/detail'
import fuwuyuyueAdd from '../pages/fuwuyuyue/add'
import quxiaoyuyueList from '../pages/quxiaoyuyue/list'
import quxiaoyuyueDetail from '../pages/quxiaoyuyue/detail'
import quxiaoyuyueAdd from '../pages/quxiaoyuyue/add'
import fuwufenpeiList from '../pages/fuwufenpei/list'
import fuwufenpeiDetail from '../pages/fuwufenpei/detail'
import fuwufenpeiAdd from '../pages/fuwufenpei/add'
import fuwujiluList from '../pages/fuwujilu/list'
import fuwujiluDetail from '../pages/fuwujilu/detail'
import fuwujiluAdd from '../pages/fuwujilu/add'
import fuwupingjiaList from '../pages/fuwupingjia/list'
import fuwupingjiaDetail from '../pages/fuwupingjia/detail'
import fuwupingjiaAdd from '../pages/fuwupingjia/add'
import chatmessageList from '../pages/chatmessage/list'
import chatmessageDetail from '../pages/chatmessage/detail'
import chatmessageAdd from '../pages/chatmessage/add'
import friendList from '../pages/friend/list'
import friendDetail from '../pages/friend/detail'
import friendAdd from '../pages/friend/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import discussjiazhengfuwuList from '../pages/discussjiazhengfuwu/list'
import discussjiazhengfuwuDetail from '../pages/discussjiazhengfuwu/detail'
import discussjiazhengfuwuAdd from '../pages/discussjiazhengfuwu/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'jiazhenggongsi',
					component: jiazhenggongsiList
				},
				{
					path: 'jiazhenggongsiDetail',
					component: jiazhenggongsiDetail
				},
				{
					path: 'jiazhenggongsiAdd',
					component: jiazhenggongsiAdd
				},
				{
					path: 'baojieayi',
					component: baojieayiList
				},
				{
					path: 'baojieayiDetail',
					component: baojieayiDetail
				},
				{
					path: 'baojieayiAdd',
					component: baojieayiAdd
				},
				{
					path: 'fuwuleixing',
					component: fuwuleixingList
				},
				{
					path: 'fuwuleixingDetail',
					component: fuwuleixingDetail
				},
				{
					path: 'fuwuleixingAdd',
					component: fuwuleixingAdd
				},
				{
					path: 'jiazhengfuwu',
					component: jiazhengfuwuList
				},
				{
					path: 'jiazhengfuwuDetail',
					component: jiazhengfuwuDetail
				},
				{
					path: 'jiazhengfuwuAdd',
					component: jiazhengfuwuAdd
				},
				{
					path: 'fuwuyuyue',
					component: fuwuyuyueList
				},
				{
					path: 'fuwuyuyueDetail',
					component: fuwuyuyueDetail
				},
				{
					path: 'fuwuyuyueAdd',
					component: fuwuyuyueAdd
				},
				{
					path: 'quxiaoyuyue',
					component: quxiaoyuyueList
				},
				{
					path: 'quxiaoyuyueDetail',
					component: quxiaoyuyueDetail
				},
				{
					path: 'quxiaoyuyueAdd',
					component: quxiaoyuyueAdd
				},
				{
					path: 'fuwufenpei',
					component: fuwufenpeiList
				},
				{
					path: 'fuwufenpeiDetail',
					component: fuwufenpeiDetail
				},
				{
					path: 'fuwufenpeiAdd',
					component: fuwufenpeiAdd
				},
				{
					path: 'fuwujilu',
					component: fuwujiluList
				},
				{
					path: 'fuwujiluDetail',
					component: fuwujiluDetail
				},
				{
					path: 'fuwujiluAdd',
					component: fuwujiluAdd
				},
				{
					path: 'fuwupingjia',
					component: fuwupingjiaList
				},
				{
					path: 'fuwupingjiaDetail',
					component: fuwupingjiaDetail
				},
				{
					path: 'fuwupingjiaAdd',
					component: fuwupingjiaAdd
				},
				{
					path: 'chatmessage',
					component: chatmessageList
				},
				{
					path: 'chatmessageDetail',
					component: chatmessageDetail
				},
				{
					path: 'chatmessageAdd',
					component: chatmessageAdd
				},
				{
					path: 'friend',
					component: friendList
				},
				{
					path: 'friendDetail',
					component: friendDetail
				},
				{
					path: 'friendAdd',
					component: friendAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'discussjiazhengfuwu',
					component: discussjiazhengfuwuList
				},
				{
					path: 'discussjiazhengfuwuDetail',
					component: discussjiazhengfuwuDetail
				},
				{
					path: 'discussjiazhengfuwuAdd',
					component: discussjiazhengfuwuAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
