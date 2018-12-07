<template>
  <div class="div1">
    <el-container>
      <el-header >
        <div id="left-nav" style="position: fixed;width: 100%;">
          <div> <el-menu

            router mode="horizontal"
            active-text-color="#ffd04b"
            background-color="#545c64"
            text-color="#fff" style="margin: 0">
            <el-menu-item index="home" >我是主页</el-menu-item>
            <el-menu-item index="lobby">票据大厅</el-menu-item>
            <el-menu-item index="buy">我是买方</el-menu-item>
            <el-menu-item index="sale">我是票方</el-menu-item>
            <el-menu-item index="user" v-if="vinish1">用户中心</el-menu-item>

            <el-menu-item index="MainPage">用户管理</el-menu-item>
            <!--<el-menu-item index="homepage" v-if="vinish">登录注册</el-menu-item>-->


          </el-menu></div>

          <div style="width: 150px;height: 30px;position: absolute;margin:-45px 700px"  v-if="vinish">
            <router-link to="/HomePage"> <div style="width: 50px;height: 25px;border: #2b85e4 solid 1px;float: left;
            color: white;text-align: center;background-color:#3d93be;padding-top: 2px">登录</div></router-link>
            <router-link to="/HomePage"><div  style="width: 50px;height: 25px;border: #2b85e4 solid 1px;float: left;
            color: white;text-align: center;margin-left: 15px;background-color:#c10000;padding-top: 2px">注册</div></router-link>
          </div>
        </div>
      </el-header>
      <el-main><div style="width: 100%;height: 800px;z-index: -1;position: absolute"><transition>
        <router-view></router-view>
      </transition></div> </el-main>
    </el-container>
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
        // activeIndex2: '1',
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
  .el-menu--horizontal>.el-menu-item{
    left: 170px;
  }
</style>

