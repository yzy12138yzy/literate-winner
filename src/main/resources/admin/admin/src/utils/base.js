const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootmwrnnvi8/",
            name: "springbootmwrnnvi8",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootmwrnnvi8/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "家政保洁预约系统"
        } 
    }
}
export default base
