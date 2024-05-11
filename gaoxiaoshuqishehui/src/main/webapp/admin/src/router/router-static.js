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

         import users from '@/views/modules/users/list'
        import dictionary from '@/views/modules/dictionary/list'
        import forum from '@/views/modules/forum/list'
        import huodongbaoming from '@/views/modules/huodongbaoming/list'
        import huodongfabu from '@/views/modules/huodongfabu/list'
        import juanzheng from '@/views/modules/juanzheng/list'
        import news from '@/views/modules/news/list'
        import xuesheng from '@/views/modules/xuesheng/list'
        import youxiushiji from '@/views/modules/youxiushiji/list'
        import config from '@/views/modules/config/list'
        import dictionaryForumState from '@/views/modules/dictionaryForumState/list'
        import dictionaryHuodongbaomingYesno from '@/views/modules/dictionaryHuodongbaomingYesno/list'
        import dictionaryHuodongfabu from '@/views/modules/dictionaryHuodongfabu/list'
        import dictionaryJuanzheng from '@/views/modules/dictionaryJuanzheng/list'
        import dictionaryNews from '@/views/modules/dictionaryNews/list'
        import dictionarySex from '@/views/modules/dictionarySex/list'
        import dictionaryYouxiushiji from '@/views/modules/dictionaryYouxiushiji/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
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
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryForumState',
        name: '帖子状态',
        component: dictionaryForumState
    }
    ,{
        path: '/dictionaryHuodongbaomingYesno',
        name: '审核',
        component: dictionaryHuodongbaomingYesno
    }
    ,{
        path: '/dictionaryHuodongfabu',
        name: '活动类型名称',
        component: dictionaryHuodongfabu
    }
    ,{
        path: '/dictionaryJuanzheng',
        name: '物品类型名称',
        component: dictionaryJuanzheng
    }
    ,{
        path: '/dictionaryNews',
        name: '活动宣传类型名称',
        component: dictionaryNews
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryYouxiushiji',
        name: '事迹类型名称',
        component: dictionaryYouxiushiji
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/dictionary',
        name: '字典表',
        component: dictionary
      }
    ,{
        path: '/forum',
        name: '心得交流',
        component: forum
      }
    ,{
        path: '/huodongbaoming',
        name: '活动报名',
        component: huodongbaoming
      }
    ,{
        path: '/huodongfabu',
        name: '活动发布',
        component: huodongfabu
      }
    ,{
        path: '/juanzheng',
        name: '爱心捐物',
        component: juanzheng
      }
    ,{
        path: '/news',
        name: '活动宣传',
        component: news
      }
    ,{
        path: '/xuesheng',
        name: '学生',
        component: xuesheng
      }
    ,{
        path: '/youxiushiji',
        name: '优秀事迹栏目',
        component: youxiushiji
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
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
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

export default router;
