<template>
  <div class="safeset">
<div class="card" style="width: 600px;height: 400px;margin: -10px auto;box-shadow:-4px 0px 8px #ff4a0d,0px -4px 8px #000,0px 4px 8px #9e038a,4px 0px 8px #0f0;
text-align: center">
  <div style="width: 300px;height: 400px;font-size: 15px;background-color:#eeeeee;float: left;box-shadow: inset 0px 0px 30px red;" >
    <div class="head" style="width: 80px;height:80px; border-radius: 50%;border: 1px solid #fffd1e;margin:110px auto">
    </div>
    <h4 style="margin-top: -93px;"><span >Welcome you:{{userinfo.account}} </span></h4>
  </div>
  <div style="width: 300px;height: 400px;font-size: 15px;background-color:#f9f9f9;float: left;box-shadow: inset 0px 0px 30px deeppink;">
    <div style="width: 300px;height: 200px;text-align: left;margin:80px 50px; ">
      <table >
        <tr><th>公司全称:</th><td>{{userinfo.eename}}</td><td> <el-button type="primary" icon="el-icon-edit" circle @click="dialogFormVisible = true"></el-button></td></tr>
        <tr><th>公司电话:</th><td>{{userinfo.account}}</td><td> <el-button type="primary" icon="el-icon-edit" circle @click="dialogFormVisible = true"></el-button></td></tr>
        <tr><th>公司邮箱:</th><td>{{userinfo.email}}</td><td>  <el-button type="primary" icon="el-icon-edit" circle @click="dialogFormVisible = true"></el-button></td></tr>
        <tr><th>公司地址:</th><td>{{userinfo.address}}</td><td>  <el-button type="primary" icon="el-icon-edit" circle @click="dialogFormVisible = true"></el-button></td></tr>
        <tr><th>法人姓名:</th><td>{{userinfo.lgname}}</td><td>  <el-button type="primary" icon="el-icon-edit" circle @click="dialogFormVisible = true"></el-button></td></tr>
        <tr><th>身份证号:</th><td>{{userinfo.idcard}}</td><td>  <el-button type="primary" icon="el-icon-edit" circle @click="dialogFormVisible = true"></el-button></td></tr>
      </table>


      </div>
    </div>
  </div>

    <div class="repair">
      <el-dialog title="修改信息" :visible.sync="dialogFormVisible">
        <el-form :model="form">
          <el-form-item label="公司全称：" :label-width="formLabelWidth">
            <el-input v-model="form.eename" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="公司电话：" :label-width="formLabelWidth">
            <el-input v-model="form.account" autocomplete="off"></el-input>
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
           account: '',
           email:'',
           address:'',
           lgname:'',
           idcard:'',

           date1: '',
           date2: '',
           delivery: false,
           type: [],
           resource: '',
           desc: ''
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
       }
                }
        }


</script>

<style scoped>
.head{
  background: url("/static/user/head.jpeg");
  background-size: 100%;
}
</style>
