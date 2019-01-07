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
        let that=this
       // event.preventDefault();
        if(that.userForm.account==''){
          return this.$message({message: '请填写手机号码 ',type: 'error',showClose: true})
        }
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
}
</style>
