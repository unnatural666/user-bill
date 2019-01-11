import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/Home'
/*import Index from '@/views/Index'
import Login from '@/views/Login'
import Register from '@/views/Register'
import Log from '@/views/Log'
import MessageBoard from '@/views/MessageBoard'
import BlogWrite from '@/views/user/BlogWrite'
import BlogView from '@/views/user/BlogView'
import BlogAllCategoryTag from '@/views/user/BlogAllCategoryTag'
import BlogCategoryTag from '@/views/user/BlogCategoryTag'*/

import { Message } from 'element-ui';


import store from '@/store'

import { getToken } from '@/request/token'

Vue.use(Router)

const router = new Router({
  routes: [
    {
      path: '',
      name: 'Home',
      component: Home,
      children: [
        {
          path: '/',
          component: r => require.ensure([], () => r(require('@/views/Home')), 'home')
        },
	    	{
	    	 path: '/lobby',
	    	 component: r => require.ensure([], () => r(require('@/views/Lobby')), 'lobby'),
          meta: {
            requireLogin: true
          }
	    	},
        {
          path: '/buy',
          component: r => require.ensure([], () => r(require('@/views/Buy')), 'buy'),
          meta: {
            requireLogin: true
          },
        },
        {
          path: '/sale',
          component: r => require.ensure([], () => r(require('@/views/Sale')), 'sale'),
          meta: {
            requireLogin: true
          },
        },
        {
          path: '/user',
          component: r => require.ensure([], () => r(require('@/views/User')), 'user')
        },
      ]
    },
    {
    	 path: '/login',
    	 component: r => require.ensure([], () => r(require('@/views/Login')), 'login')
    },
    {
    	 path: '/register',
    	 component: r => require.ensure([], () => r(require('@/views/Register')), 'register'),
    },
    {
    	path: '/write',
    	component: r => require.ensure([], () => r(require('@/views/user/usercenter')), 'usercenter'),
      children: [
        {path:'/',redirect:'/safeset',},
        {path: '/basic',component: r => require.ensure([], () => r(require('@/views/user/basic')), 'basic'),},
        {path: '/safeset',component: r => require.ensure([], () => r(require('@/views/user/safeset')), 'safeset'),},
        {path: '/salled',component: r => require.ensure([], () => r(require('@/views/user/salled')), 'salled'),},
        {path: '/bought',component: r => require.ensure([], () => r(require('@/views/user/bought')), 'bought'),},
      ],

    	meta: {
        requireLogin: true
      },

    }
  ],
  scrollBehavior (to, from, savedPosition) {
	  return { x: 0, y: 0 }
	}
})

router.beforeEach((to, from, next) => {
	
  if (getToken()) { 
    
    if (to.path === '/login') {
      next({ path: '/' })
    } else {
      if (store.state.account.length === 0) { 
        store.dispatch('getUserInfo').then(data => { //获取用户信息
          next()
        }).catch(() => {
            next({ path: '/' })
        })
      }else{
      	next()
      }
    }
  } else {
    if (to.matched.some(r => r.meta.requireLogin)) {
    	Message({
    		type: 'warning',
    		showClose: true,
      	message: '请先登录哦'
    	})
    	
    }
    else {
        next();
    }
  }
})


export default router
