// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
// import App from './App'
import axios from 'axios'
import router from './router/index.js'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue';
import iView from 'iview';
import 'iview/dist/styles/iview.css';
import VueRouter from 'vue-router'
Vue.use(VueRouter)
import  VueResource from 'vue-resource'
Vue.use(VueResource)


Vue.use(iView);
Vue.use(ElementUI);
Vue.prototype.$axios = axios
//
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
