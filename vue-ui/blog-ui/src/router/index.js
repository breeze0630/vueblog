import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/login.vue'
import BlogDetail from '../views/blogDetail.vue'
import BlogEdit from '../views/blogEdit.vue'
Vue.use(VueRouter)

//带有meta：requireAuth: true说明是需要登录字后才能访问的受限资源，后面我们路由权限拦截时候会用到
const routers = [

    {
        path:'/',
        name:'Index',
        redirect:{name:"Blogs"}
    }
    , {
        path:'/login',
        name:'Login',
        component:Login
    }
    ,{
        path:'/blogs',
        name:'Blogs',
        component:() => import('../views/Blogs.vue')
    }
    ,{
        path:'/blogs/add',
        name:'BlogAdd',
        meta:{
            requireAuth:true
        },
        component:BlogEdit
    }
    , {
        path:'/blogs/:blogId',
        name:'BlogDetail',
        component:BlogDetail
    }
    ,{
        path:'/blogs/:blogId/edit',
        name:'BlogEdit',
        meta:{
            requireAuth:true
        },
        component:BlogEdit
    }
];

const router = new VueRouter({
    mode:'history',
    base:process.env.BASE_URL,
    routers
})

export default router;

