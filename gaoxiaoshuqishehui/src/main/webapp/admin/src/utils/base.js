const base = {
    get() {
        return {
            url : "http://localhost:8080/gaoxiaoshuqishehui/",
            name: "gaoxiaoshuqishehui",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/gaoxiaoshuqishehui/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "高校暑期社会实践活动"
        } 
    }
}
export default base
