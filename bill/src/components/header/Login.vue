<template>
  <div id="Login" >
    <el-form :model="loginForm" ref="loginForm" :rules="rules">
      <el-form-item prop="tel">
        <el-input v-model="loginForm.tel" placeholder="请输入电话号">
        </el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input v-model="loginForm.password" type="password" placeholder="请输入密码">
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" round @click="login('loginForm')">登陆</el-button>
        <el-button round @click="reset('loginForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  import bus from '../../../config/bus.js'
  export default {
    name: "Login",
    data() {
      return {
        loginForm: {
          tel: '',
          password: '',
        },
        rules: {
          tel: [{required: true, message: '请输入账号', trigger: 'blur'}],
          password: [{required: true, message: '请输入密码', trigger: 'blur'}]
        },
        props: ['jump']
      }
    },
    methods: {
      login(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$axios.post('http://localhost:8081/login',
              this.loginForm
            )
              .then(res => {
                if (res.data === '000') {
                  this.$message({message: '登陆成功', type: 'success'})
                  sessionStorage.setItem('user', JSON.stringify(this.loginForm))
                  this.$router.push({name: 'home'})
                  this.commit()

                } else if (res.data === '001') {
                  this.$alert('密码错误')
                } else if (res.data === '002') {
                  this.$alert('账号不存在')
                }
              })
              .catch(error => {

              })
          } else {
            return false;
          }
        });
      },
      reset(formName) {
        this.$refs[formName].resetFields();
      },
      commit(){
        bus.$emit('sendMsg',{
          vinish:false,
          vinish1:true
        })
      }
    }
  }
</script>

<style scoped>
  #Login{
    margin-top: 18px;
    opacity: 0.9;
    background-color: transparent;
  }
</style>
