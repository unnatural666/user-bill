<template>
  <div id="Register">
    <el-form :model="json" ref="form" :rules="rules">
      <el-form-item prop="name">
        <el-input v-model="json.tel" class="form-control" placeholder="请输入电话号码"></el-input>
      </el-form-item>

      <el-form-item prop="level">
          <el-input v-model="json.level" class="form-control" placeholder="请输入验证码">
            <el-button type="success" slot="append" @click="getting()">获取验证码</el-button>
        </el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input type="password" v-model="json.password" class="form-control" placeholder="密码"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="regi()">注册</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  export default {
    name: "Register",
    data() {
      return {
        rules: {
          tel: [{required: true, message: '请输入用户名', trigger: 'blur'}],
          level: [{required: true, message: '请输入验证码', trigger: 'blur'}],
          password: [{required: true, message: '请输入密码', trigger: 'blur'}],
        },
        json: {
          tel:'',
          level:'',
          password:''
        }
      }
    },
    methods: {
        getting() {
              this.$axios.post('http://localhost:8080/login',
                this.json
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
      regi(){
        this.$axios.post('http://localhost:8080/register',
          this.json
        )
          .then(res=>{
            if(res.data=='000'){
              this.$message({message: '注册成功', type: 'success'});
            }
            if(res.data=='002'){
              this.$message({message: '验证码不正确', type: 'warn'});

            }
          })
          .catch(error=> {
            console.log(error);
          });
      }
    }
     /* register(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$axios.post(
              '/user/register',
              this.registerForm
            )
              .then(res => {
                if (res.data === 's0000') {
                  this.$message({message: '注册成功', type: 'success'});
                  this.$router.push({name: 'basic'})
                } else if (res.data === 'e1002') {
                  this.$message({message: '该用户已被注册', type: 'warn'});
                }
                this.$refs['registerForm'].resetFields();
              })
              .catch(error => {

              })
          }
        })
      }*/
  }
</script>

<style scoped>

</style>
