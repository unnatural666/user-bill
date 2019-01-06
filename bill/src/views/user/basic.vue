<template>
  <div style="width: 100%;height: 600px;" class="beijing">
    <div id="complete">
      <div class="me-login-box me-login-box-radius">
        <h1>Welcome 完善信息</h1>

        <el-form ref="userForm" :model="userForm" :rules="rules">
          <el-form-item prop="eename">
            <el-input placeholder="请输入企业全称" v-model="userForm.eename"  ></el-input>
          </el-form-item>

          <el-form-item prop="email">
            <el-input placeholder="请输入企业邮箱" v-model="userForm.email" ></el-input>
          </el-form-item>

          <el-form-item prop="address">
            <el-input placeholder="请输入公司地址" v-model="userForm.address" ></el-input>
          </el-form-item>

          <el-form-item prop="lgname">
            <el-input placeholder="请输入法人姓名" v-model="userForm.lgname" ></el-input>
          </el-form-item>

          <el-form-item prop="idcard">
            <el-input placeholder="请输入身份证号" v-model="userForm.idcard" ></el-input>
          </el-form-item>

          <el-form-item size="small" class="me-login-button">
            <el-button type="primary"  @click="complete">确认保存</el-button>
          </el-form-item>
        </el-form>

        <div class="me-login-design">
          <p>Click me go back
            <strong><router-link to="/" class="me-login-design-color">Home</router-link></strong>
          </p>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
  // import store from '../store/index'
  export default {
    name: 'Complete',
    data () {
      return {
        userForm:{
          account:'',
          eename: '',
          email:'',
          address: '',
          lgname:'',
          idcard:'',
        },
        rules: {
          eename: [
            { required: true, message: '请输入企业全称', trigger: 'blur' },
            { max: 20, message: '不能大于10个字符', trigger: 'blur' }
          ],
          email: [
            { required: true, message: '请输入企业邮箱', trigger: 'blur' },
            { max: 20, message: '不能大于10个字符', trigger: 'blur' }
          ],
          address: [
            { required: true, message: '请输入公司地址', trigger: 'blur' },
            { max: 20, message: '不能大于10个字符', trigger: 'blur' }
          ],
          lgname: [
            { required: true, message: '请输入法人姓名', trigger: 'blur' },
            { max: 10, message: '不能大于10个字符', trigger: 'blur' }
          ],
          idcard: [
            { required: true, message: '请输入身份证号', trigger: 'blur' },
            { max: 20, message: '不能大于10个字符', trigger: 'blur' }
          ],
        }
      }
    },
    methods:{
    complete() {
            this.axios.post(
              'http://localhost:8081/addinfo',
                this.userForm,
            )
              .then(res => {
                this.$message({message: '恭喜你完善信息成功', type: 'success'})
                  this.$router.push({path:'/'})

              })
              .catch(error => {

              })

      },
    },

  }
</script>

<style scoped>
  /*.beijing{*/
    /*background: url("../assets/img/timg.jpg");*/
  /*}*/
  #complete{
    min-width: 100%;
    min-height: 100%;
  }

  .me-video-player{
    background-color: transparent;
    width:100%;
    height: 100%;
    object-fit: fill;
    display: block;
    position: absolute;
    left:0;
    z-index: 0;
    top: 0;
  }
  .me-login-box{
    position: absolute;
    width: 300px;
    height: 420px;
    background-color: #ffffff;
    margin-top: -10px;
    margin-left: -180px;
    left:35%;
    padding: 30px;
  }
  .me-login-box-radius{
    border-radius: 10px;
    box-shadow: 0px 0px 1px 1px rgba(129, 241, 40, 0.1);
  }

  .me-login-box h1{
    text-align: center;
    font-size: 24px;
    margin-bottom: 20px;
    vertical-align: middle;
  }

  .me-login-design{
    text-align: center;
    font-family: 'Open Sans', sans-serif;
    font-size: 18px;
  }
  .me-login-design-color{
    color: #81f128 !important;
  }
  .me-login-button{
    text-align: center;
  }
  .me-login-button button{
    width: 100%;
  }

</style>
