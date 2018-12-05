<template>
  <div class="div1">
    <el-container>
      <el-header >
        <div id="left-nav" style="position: fixed;width: 100%;margin: 0;">
        <el-menu
        :default-active='home' router mode="horizontal"
        active-text-color="#ffd04b"
        background-color="#545c64"
        text-color="#fff" style="margin: 0">
        <el-menu-item index="home" >主页</el-menu-item>
        <el-menu-item index="lobby">票据大厅</el-menu-item>
        <el-menu-item index="buy">我是买方</el-menu-item>
        <el-menu-item index="sale">我是票方</el-menu-item>
        <el-menu-item index="user" v-if="vinish1">用户中心</el-menu-item>
        <el-menu-item index="homepage" v-if="vinish">登录注册</el-menu-item>
        <el-menu-item index="MainPage">用户管理</el-menu-item>
        </el-menu>
        </div>
      </el-header>
      <el-main><div style="width: 100%;height: 800px;z-index: -1;position: absolute"><transition>
        <router-view></router-view>
      </transition></div> </el-main>
    </el-container>
    <div class="bottom" style="margin-top: 640px;position: absolute">
      <div style="width: 100%;position: relative">
        <div class="left" style="width: 400px ;height: 300px;position: absolute;border: 1px solid red" >

        </div>
        <div class="right" style="width: 400px ;height: 300px;position: absolute;;border: 1px solid red" >

        </div>
      </div>
    </div>
  </div>


</template>

<script>
 // import getActiveNav from '../config'
 //引入总是出现问题，应该是语法错误，放入config文件夹倒没有问题
 import  bus from '../config/bus.js'
  export default {
    data() {
      return {
        vinish:true,
        vinish1:false,
        activeIndex2: '1',
      };
    },
    mounted() {
     bus.$on('sendMsg',(data)=>{
       this.vinish=data.vinish
       this.vinish1=data.vinish1
     })
    },
  }
</script >
<style scoped>
  .el-header{
    padding: 0;
  }
</style>

