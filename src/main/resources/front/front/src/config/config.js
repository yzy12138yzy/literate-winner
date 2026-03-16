export default {
	baseUrl: 'http://localhost:8080/springbootmwrnnvi8/',
	name: '/springbootmwrnnvi8',
	indexNav: [
// frontMenu com.jlwl.entity.Menu@67204e20
		{
			name: '家政服务',
			url: '/index/jiazhengfuwu',
		},
		{
			name: '公告资讯',
			url: '/index/news'
		},
	],
	cateList: [
		{
			name: '公告资讯',
			refTable: 'newstype',
			refColumn: 'typename',
		},
	]
}
