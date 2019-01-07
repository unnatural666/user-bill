<template>
  <div class="safeset">
<div class="card" style="width: 600px;height: 400px;margin: 50px auto;box-shadow:-4px 0px 8px #ff4a0d,0px -4px 8px #000,0px 4px 8px #9e038a,4px 0px 8px #0f0;
text-align: center">
  <div style="width: 300px;height: 400px;font-size: 15px;background-color:#eeeeee;float: left;box-shadow: inset 0px 0px 30px red;" >
    <div class="head" style="width: 80px;height:80px; border-radius: 50%;border: 1px solid #fffd1e;margin:110px auto">
    </div>
    <h4 style="margin-top: -93px;"><span >Welcome you:{{userinfo.account}} </span></h4>
  </div>
  <div style="width: 300px;height: 400px;font-size: 15px;background-color:#f9f9f9;float: left;box-shadow: inset 0px 0px 30px deeppink;">
    <div style="width: 300px;height: 200px;text-align: left;margin:100px 50px; ">
      <table >
        <tr><th>公司全称:</th><td>{{userinfo.eename}}</td></tr>
        <tr><th>公司邮箱:</th><td>{{userinfo.email}}</td></tr>
        <tr><th>公司地址:</th><td>{{userinfo.address}}</td></tr>
        <tr><th>法人姓名:</th><td>{{userinfo.lgname}}</td></tr>
        <tr><th>身份证号:</th><td>{{userinfo.idcard}}</td></tr>
      </table>
       <div style="position: absolute;margin:110px 100px">  <el-button type="success"  icon="el-icon-edit" round @click="dialogFormVisible = true">修改信息</el-button></div>

      </div>
    </div>
  </div>

    <div class="repair">
      <el-dialog title="修改信息" :visible.sync="dialogFormVisible">
        <el-form :model="form">
          <el-form-item label="公司全称：" :label-width="formLabelWidth">
            <el-input v-model="form.eename" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="公司邮箱：" :label-width="formLabelWidth">
            <el-input v-model="form.email" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="公司地址：" :label-width="formLabelWidth">
            <el-input v-model="form.address" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="法人姓名：" :label-width="formLabelWidth">
            <el-input v-model="form.lgname" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="身份证号：" :label-width="formLabelWidth">
            <el-input v-model="form.idcard" autocomplete="off"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
    <el-button @click="dialogFormVisible = false">取消</el-button>
    <el-button type="primary" @click="repair">确认</el-button>
  </span>
      </el-dialog>
    </div>
</div>



</template>

<script>
    export default {
     name: "safeset",
      data(){
       return{
         userinfo:'',

         dialogTableVisible: false,
         dialogFormVisible: false,
         form: {
           eename: '',
           email:'',
           address:'',
           lgname:'',
           idcard:'',
         },
         formLabelWidth: '120px'
       }

      },
     created() {
        this.axios.post('http://localhost:8081/getuserinfo')
          .then(res => {

            //console.log(res);
            this.userinfo=res.data
            console.log(this.userinfo);

          })
          .catch(error => {

          })
          },
        methods:{
       repair(){
         let that=this
         let index=0
         event.preventDefault();
         Object.keys(that.form).forEach(function(key){

           console.log(key,that.form[key]);

           if(that.form[key]==''){
             index+=1
             return ;
           }

         });
         if(index!=0){
           return this.$message({message: '请完善修改信息 ',type: 'error',showClose: true});
         }
         this.axios.post(
           'http://localhost:8081/update',
           this.form,
         )
           .then(res => {
             this.$message({message: '恭喜你修改信息成功', type: 'success'})
             this.$router.push({path:'/'})

           })
           .catch(error => {

           })
       }
                }
        }


</script>

<style scoped>
.head{
  background: url("/static/user/head.jpeg");
  background-size: 100%;
}

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
