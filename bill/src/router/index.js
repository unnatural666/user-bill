import Vue from 'vue'
import Router from 'vue-router'

import Home from '@/components/header/Home.vue'
import Lobby from '@/components/header/Lobby.vue'
import HomePage from '@/components/header/HomePage.vue'
import HomePage1 from '@/components/header/HomePage1.vue'
import Sale from '@/components/header/Sale.vue'
import Buy from '@/components/header/Buy.vue'
import User from '@/components/header/User.vue'
import basic from '@/components/usercenter/basic.vue'
import safeset from '@/components/usercenter/safeset.vue'
import MainPage from '@/components/header/MainPage.vue'
import Register from '@/components/header/Register'
import Login from '@/components/header/Login.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {path:'/',redirect:'/Home',},
    {path:'/home', component:Home,name:'home',},
    {path:'/MainPage', component:MainPage,name:'MainPage'},

    {path:'/lobby',component:Lobby,name:'lobby'},
    {path:'/homepage',component:HomePage,name:'homepage'},
    {path:'/homepage1',component:HomePage1,name:'homepage1'},
    {path:'/sale',component:Sale,name:'sale'},
    {path:'/buy',component:Buy,name:'buy'},
    {path:'/user',component:User,name:'user',children: [
        {path:'/',redirect:'/basic',},
        {path: '/basic', component: basic},
        {path: '/safeset', component: safeset},

      ],}

  ]
})
