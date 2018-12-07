<template>
  <el-container id="HomePage" >
    <div class="change">
      <div class="lr">
        <el-button type="text" @click="changeView('登录')" >登录</el-button>
        <el-button type="text" @click="changeView('注册')">注册</el-button>
      </div>
      <Login v-if="showLogin"></Login>
      <Register v-if="showRegister"></Register>
    </div>
  </el-container>
</template>

<script>
  import Login from '@/components/header/Login'
  import Register from '@/components/header/Register'

  export default {
    name: "HomePage",
    components: {Login, Register},
    data() {
      return {
        showLogin: true,
        showRegister: false,
      }
    },
    methods: {
      changeView(btnName) {
        if (btnName === '登录') {
          this.showLogin = true
          this.showRegister = false
        } else {
          this.showLogin = false
          this.showRegister = true
        }
      },



    }
  }
</script>

<style scoped>
  #HomePage {
    position: fixed;
    top: 10px;
    left: 0;
    right: 0;
    bottom: 0;
    height: 600px;
    /*background-color: #81f128;*/
    background: url("../../assets/bgc1.jpg") no-repeat 0px -40px;
    background-size: 100%;
  }

  .change {
    opacity: 0.9;
    margin-top: 70px;
    background-color: transparent;
    -webkit-border-radius: 24px;
    -moz-border-radius: 24px;
    border-radius: 26px;
    border:1px solid #e4e4e4;
    margin-left: 650px;
    text-align: center;
    width: 260px;
    height: 280px;
  }

  #Login {
    font-size: 12px;
    margin: 60px 50px 40px 42px;
    background-color: transparent;
  }

  #Register {
    margin: 5px 30px 30px 30px;
    background-color: transparent;
  }
  .lr{
    margin-top:5px;
    font-size: 10px;
  }
</style>
