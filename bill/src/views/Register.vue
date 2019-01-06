<!--<template>-->
  <!--<div style="width: 100%;height: 600px;" class="beijing">-->
<!--<div id="register">-->
	<!--&lt;!&ndash;<video preload="auto" class="me-video-player" autoplay="autoplay" loop="loop">-->
		<!--<source src="../../static/vedio/sea.mp4" type="video/mp4">-->
	<!--</video>&ndash;&gt;-->
		    	<!---->
  <!--<div class="me-login-box me-login-box-radius">-->
		<!--<h1>Welcome 注册</h1>-->
		<!---->
		<!--<el-form ref="userForm" :model="userForm" :rules="rules">-->
		  <!--<el-form-item prop="account">-->
		    <!--<el-input placeholder="用户名" v-model="userForm.account"></el-input>-->
		  <!--</el-form-item>-->
		  <!---->
		  <!--<el-form-item prop="nickname">-->
		    <!--<el-input placeholder="验证码" v-model="userForm.nickname" style="width: 150px;float: left"></el-input>-->
        <!--<el-button type="primary" style="float: left" @click="getting()" >输入验证码</el-button>-->
		  <!--</el-form-item>-->
		  <!---->
		  <!--<el-form-item prop="password">-->
		    <!--<el-input placeholder="密码" v-model="userForm.password"></el-input>-->
		  <!--</el-form-item>-->
		  <!---->
		  <!--<el-form-item size="small" class="me-login-button">-->
		    <!--<el-button type="primary" @click="regi()">注册</el-button>-->
		  <!--</el-form-item>-->
		<!--</el-form>-->
		<!---->
		<!--<div class="me-login-design">-->
			<!--<p>Designed by -->
			<!--<strong><router-link to="/" class="me-login-design-color">ForFun</router-link></strong>-->
			<!--</p>-->
		<!--</div>-->
		<!---->
	<!--</div>-->
<!--</div>-->
  <!--</div>-->
<!--</template>-->

<!--<script>-->
<!--import {register} from '@/api/login'	-->
<!--export default {-->
  <!--name: 'Register',-->
  <!--data () {-->
    <!--return {-->
    	<!--userForm: {-->
	      	<!--account: '',-->
	      	<!--nickname: '',-->
	      	<!--password: ''-->
	      <!--},-->
      	<!--rules: {-->
	    	<!--account: [-->
	        	<!--{ required: true, message: '请输入用户名', trigger: 'blur' },-->
	        	<!--{ max: 10, message: '不能大于10个字符', trigger: 'blur' }-->
	      	<!--],-->
	      	<!--nickname: [-->
	      		<!--{ required: true, message: '请输入验证码', trigger: 'blur' },-->
	      		<!--{ max: 10, message: '不能大于10个字符', trigger: 'blur' }-->
	      	<!--],-->
	      	<!--password: [-->
	        	<!--{ required: true, message: '请输入密码', trigger: 'blur' },-->
	        	<!--{ max: 10, message: '不能大于10个字符', trigger: 'blur' }-->
	      	<!--]-->
	    <!--}-->
      <!---->
    <!--}-->
  <!--},-->
  <!--methods: {-->
    <!--getting() {-->
      <!--this.$axios.post('http://localhost:8081/gettel',-->
        <!--this.json-->
      <!--)-->
        <!--.then(res => {-->
          <!--if (res.data == '002') {-->
            <!--this.$message({message: '该用户已被注册', type: 'warn'});-->
          <!--}-->
          <!--if (res.data == '000') {-->
            <!--this.$message({message: '验证码已发送，请注意查收', type: 'success'});-->
          <!--}-->
        <!--})-->
        <!--.catch(error => {-->
          <!--console.log(error);-->
        <!--});-->
    <!--},-->

    <!--regi(){-->
      <!--this.$axios.post('http://localhost:8081/register',-->
        <!--this.json-->
      <!--)-->
        <!--.then(res=>{-->
          <!--if(res.data=='000'){-->
            <!--this.$message({message: '注册成功', type: 'success'});-->
          <!--}-->
          <!--if(res.data=='002'){-->
            <!--this.$message({message: '验证码不正确', type: 'warn'});-->

          <!--}-->
        <!--})-->
        <!--.catch(error=> {-->
          <!--console.log(error);-->
        <!--});-->
    <!--}-->
  	<!---->
  <!--}-->
<!--}-->
<!--</script>-->

<!--<style scoped>-->
  <!--.beijing{-->
    <!--background: url("../assets/img/timg.jpg");-->
  <!--}-->
<!--#login{-->
	<!--min-width: 100%;-->
	<!--min-height: 100%;-->
<!--}-->

<!--.me-video-player{-->
  	<!--background-color: transparent;-->
  	<!--width:100%;-->
  	<!--height: 100%; -->
  	<!--object-fit: fill; -->
	<!--display: block;-->
	<!--position: absolute;-->
	<!--left:0;-->
	<!--z-index: 0;-->
	<!--top: 0;-->
  <!--}-->
<!--.me-login-box{-->
	<!--position: absolute;-->
	<!--width: 300px;-->
	<!--height: 320px;-->
	<!--background-color: white;-->
	<!--margin-top: 150px;-->
	<!--margin-left: -180px;-->
	<!--left:50%;-->
	<!--padding: 30px;-->
<!--}-->
<!--.me-login-box-radius{-->
  	<!--border-radius: 10px;-->
    <!--box-shadow: 0px 0px 1px 1px rgba(161, 159, 159, 0.1);-->
<!--}-->
  	<!---->
<!--.me-login-box h1{-->
  	<!--text-align: center;-->
	<!--font-size: 24px;-->
	<!--margin-bottom: 20px;-->
	<!--vertical-align: middle;-->
<!--}-->
  <!---->
<!--.me-login-design{-->
  	<!--text-align: center;-->
  	<!--font-family: 'Open Sans', sans-serif;-->
  	<!--font-size: 18px;-->
<!--}-->
<!--.me-login-design-color{-->
  	<!--color: #5FB878 !important;-->
<!--}-->
<!--.me-login-button{-->
	<!--text-align: center;-->
<!--}-->
<!--.me-login-button button{-->
	<!--width: 100%;-->
<!--}-->

<!--</style>-->
<template>
  <div style="width: 100%;height: 600px;" class="beijing">
  <div id="Register">
    <el-form :model="userForm" ref="userForm" :rules="rules">
      <el-form-item prop="tel">
        <el-input v-model="userForm.account" class="form-control" placeholder="请输入电话号码"></el-input>
      </el-form-item>

      <el-form-item prop="auth">
        <el-input v-model="userForm.auth" class="form-control" placeholder="请输入验证码" style="width: 65%;"></el-input>
        <el-button type="primary" style="width: 90px;margin-left: 7px" @click="getting" >获取验证码</el-button>
      </el-form-item>
      <!---->
      <!--<el-form-item prop="auth">-->
        <!--<el-input v-model="userForm.auth" class="form-control" placeholder="请输入验证码" >-->
          <!--<el-button type="primary" slot="append" @click="getting()" style="width: 60px;font-size: 11px;text-align: -moz-center;position: relative">-->
            <!--<span style="position: absolute;margin-left: -28px;margin-top: -11px;color:blueviolet">获取验证码</span></el-button>-->
        <!--</el-input>-->
      <!--</el-form-item>-->
      <el-form-item prop="password">
        <el-input type="password" v-model="userForm.password" class="form-control" placeholder="密码"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" round @click=" register('userForm')" style="width: 100%">注册</el-button>
      </el-form-item>
    </el-form>
  </div>
  </div>
</template>

<script>
  export default {
    name: "Register",
    data() {
      return {
        rules: {
          account: [{required: true, message: '请输入电话号码', trigger: 'blur'}],
          auth: [{required: true, message: '请输入验证码', trigger: 'blur'}],
          password: [{required: true, message: '请输入密码', trigger: 'blur'}],
        },
        userForm: {
          account:'',
          auth:'',
          password:''
        }
      }
    },
    methods: {
      getting() {
        this.axios.post('http://localhost:8081/gettel',
          this.userForm
        )
          .then(res => {
            if (res.data == '002') {
              this.$message({message: '该用户已被注册', type: 'warn'});
            }
            if (res.data == '000') {
              this.$message({message: '验证码已发送，请注意查收', type: 'success'});
            }
          })
          .catch(error => {
            console.log(error);
          });
      },
      register(formName) {
        let that = this
        this.$refs[formName].validate((valid) => {
          if (valid) {
            that.$store.dispatch('register', that.userForm).then(() => {
              that.$message({message: '注册成功 快去完善信息吧',type: 'success',showClose: true});
              that.$router.push({ path: '/basic' })
            }).catch((error) => {
              if(error !== 'error'){
                that.$message({message: error,type: 'error',showClose: true});
              }
            })

          } else {
            return false;
          }
        });

      }
    }

  }
</script>

<style scoped>
  .beijing{
    background: url("../assets/img/timg.jpg");

  }
#Register{
  width: 300px;
  height: 250px;
  margin: 0 auto;
  padding-top: 150px;
  /*border: 1px gray solid;*/
}
</style>
