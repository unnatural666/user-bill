<template>
  <div style="margin:80px auto;margin-bottom: 20px;width: 90%;height: 700px;border: 1px solid #cecece">

    <div style="margin:40px 20px ">
      <div style="width: 10% ;float: left; "><h3>步骤流程</h3></div>
      <div style="width: 80%; float: left;"><el-steps :active="0" >
      <el-step title="发布票据" icon="el-icon-message"></el-step>
      <el-step title="确认意向" icon="el-icon-tickets"></el-step>
      <el-step title="背书转让" icon="el-icon-edit"></el-step>
      <el-step title="完成订单" icon="el-icon-success"></el-step>
    </el-steps></div>
    </div>
    <br>
    <div style="width: 100% ;height: 200px;float: left ;margin:30px 20px ">
      <h3>上传票面</h3>

      <div style="margin-left: 230px">
        <el-upload
          action="https://jsonplaceholder.typicode.com/posts/"
          list-type="picture-card"
          :on-preview="handlePictureCardPreview"
          :on-remove="handleRemove"
          :on-change="pic"
          :before-upload="beforeUpload"

        >

          <i class="el-icon-plus"></i>
        </el-upload>
        <el-dialog :visible.sync="dialogVisible">
          <img width="100%" :src="dialogImageUrl" alt="" height="200px"  >
        </el-dialog>
      </div>
      <el-button type="success" round  @click="submit($event)" style="margin:5px 250px">检索票据</el-button>
      <span style="color: red;margin-left: -200px;font-size: 14px"> 提示: 自动识别结果可能有误, 请修改正确后再点 "一键融资" </span>

    </div>

    <div style="clear: left;margin:25px 20px "> <h3>票面信息</h3></div>

    <div style="margin-top: -30px;height: 300px;margin-left:35px;width: 400px">
      <div id="complete">
        <div class="me-login-box me-login-box-radius">
          <el-form ref="userForm" :model="userForm" :rules="rules">
            <el-form-item prop="billname">
              <el-input placeholder="请输入票据号码" v-model="userForm.billname" ></el-input>
            </el-form-item>

            <el-form-item prop="money">
              <el-input placeholder="请输入票据金额" v-model="userForm.money" ></el-input>
            </el-form-item>

            <el-form-item prop="billtime">
              <el-input placeholder="请输入票据到期日" v-model="userForm.billtime" ></el-input>
            </el-form-item>

            <el-form-item prop="eename">
              <el-input placeholder="请输入承兑人全称" v-model="userForm.eename" ></el-input>
            </el-form-item>

            <el-form-item prop="want">
              <el-input placeholder="请输入期望价格" v-model="userForm.want" ></el-input>
            </el-form-item>

            <el-form-item prop="endorse">
              <el-input placeholder="请输入背书次数" v-model="userForm.endorse" ></el-input>
            </el-form-item>
            <el-form-item prop="flaw">
              <el-input placeholder="请输入票据瑕疵" v-model="userForm.flaw" ></el-input>
            </el-form-item>
            <el-form-item size="small" class="me-login-button">
              <el-button type="primary"   @click="invest($event)" >一键融资</el-button>
            </el-form-item>
          </el-form>

        </div>
      </div>
    </div>
  </div>

</template>

<script>
  export default {

    data() {
      return {
        dialogImageUrl: '',
        dialogVisible: false,
          file:'',
          back:'',
        userForm:{
          billname: '',
          eename: '',
          money: '',
          billtime: '',
          flaw: '',
          want: '',
          endorse: '',
        },



        rules: {
          file: [

            { required: true, message: '请上传图片' }

          ],


          billname: [
            {required: true, message: '请输入票据号码', trigger: 'blur'},
            {max: 20, message: '不能大于10个字符', trigger: 'blur'}
          ],
          money: [
            {required: true, message: '请输入票据金额', trigger: 'blur'},
            {max: 20, message: '不能大于10个字符', trigger: 'blur'}
          ],
          billtime: [
            {required: true, message: '请输入票据到期日', trigger: 'blur'},
            {max: 20, message: '不能大于10个字符', trigger: 'blur'}
          ],
          eename: [
            {required: true, message: '请输入承兑人全称', trigger: 'blur'},
            {max: 10, message: '不能大于10个字符', trigger: 'blur'}
          ],
          want: [
            {required: true, message: '请输入期望价格', trigger: 'blur'},
            {min:1,max: 20, message: '不能大于10个字符', trigger: 'blur'}
          ],
          endorse: [
            {required: true, message: '请输入背书次数', trigger: 'blur'},
            {max: 20, message: '不能大于10个字符', trigger: 'blur'}
          ],
          flaw: [
            {required: true, message: '请输入票据瑕疵', trigger: 'blur'},
            {max: 20, message: '不能大于10个字符', trigger: 'blur'}
          ],
        },

      }
    },

    methods: {

      pic(file){
        this.file=file
      },
      beforeUpload(){
        this.file=file
      },

      handleRemove(file, fileList) {
        console.log(file, fileList);
        this.file=file;
      },
      handlePictureCardPreview(file) {

       this.dialogImageUrl = file.url;
        this.dialogVisible = true;
        this.file=file;
        // console.log(this.file);
      },

      submit: function (event) {
        if(this.file==''){
          this.$message({message: '请上传票据 ',type: 'error',showClose: true})
          return
        }

        var config={
          headers: { "Content-Type": "multipart/form-data" }
        };
        let formData = new FormData();
        formData.append("file", this.file.raw);

        this.axios.post('http://localhost:8081/upload', formData,config)
          .then(res=> {
            // this.$router.push({path:'/'})
            // this.back=res.data
            this.userForm=res.data
            // console.log(this.back)
            this.$message({message: '票据检索成功 ',type: 'success',showClose: true})


          })
          .catch(error=> {
            alert("上传失败");
            console.log(error);
            window.location.reload();
          });
      },
      invest: function (event) {
        //阻止元素发生默认的行为

        // var that=this
        // var index=0
        // event.preventDefault();
        // Object.keys(that.userForm).forEach(function(key){
        //
        //   console.log(key,that.userForm[key]);
        //
        //   if(that.userForm[key]==''){
        //   index+=1
        //
        //     return ;
        //   }
        //
        // });
        // if(index!=0){
        //   return this.$message({message: '请完善票据票面信息 ',type: 'error',showClose: true});
        // }
        // if(that.file.raw==''){
        //   return this.$message({message: '请查看票据图片信息 ',type: 'error',showClose: true});
        // }
        // console.log(that.file.row);
        var config={
          headers: { "Content-Type": "multipart/form-data" }
        };
        let formData = new FormData();

        formData.append("billname", this.userForm.billname)
        formData.append("money", this.userForm.money)
        formData.append("eename", this.userForm.eename)
        formData.append("flaw", this.userForm.flaw)
        formData.append(" want", this.userForm.want)
        formData.append("endorse", this.userForm.endorse)
        formData.append("billtime", this.userForm.billtime)
        // console.log(this.userForm);
        console.log(formData.get('billname'))
        this.axios.post('http://localhost:8081/upbill', formData,config)
          .then(res=> {
            this.$router.push({path:'/'})
            // console.log(this.back)
            this.$message({message: '票据发布成功 ',type: 'success',showClose: true})

          })
          .catch(error=> {
            // alert("上传失败");
            console.log(error);
            // window.location.reload();
          });
      },


    },
    }

</script>

<style scoped>
  .el-select .el-input {
    width: 110px;
  }
  .input-with-select .el-input-group__prepend {
    background-color: #fff;
  }
  #complete{
    position: absolute;
    min-width: 100%;
    /*min-height: 100%;*/
    margin-left: -120px;
  }
  .el-form-item{
    width: 300px;
    float: left;
    margin-left: 60px;
  }

  .me-login-box{
    position: absolute;
    width: 800px;
    height: 220px;
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

  .rz-notice {
    padding: 0.2rem 0.3rem;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    background: #F0F5FB;
    color: #28D9EF;
  }

  .rz-notice img {
    height: 0.22rem;
    width: 0.22rem;
  }

  .rz-picter {
    height: 3rem;
    width: 6rem;
    margin: 0.3rem auto;
    border: 0.01rem solid #ededed;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }

  .uppic {
    height: 3rem;
    width: 6rem;
    margin: 0 auto;
    opacity: 0;
    z-index: 99999;
  }
  .img-avatar {
    position: absolute;
  }
  /*立即验证*/

  .yzbtn {
    width: 90%;
    height: 0.8rem;
    background: #FF6600;
    border-radius: 0.06rem;
    margin: 30px auto;
    text-align: center;
    line-height: 0.8rem;
    color: #FFFFFF
  }


  /*修改原有tab样式*/

  .van-tab {
    color: #A3A3A3!important;
  }

  .van-tab--active {
    color: #000!important;
  }

  .van-tabs__line {
    background-color: #FF6600!important;
    width: 0.7rem!important;
    text-align: center!important;
    align-items: center;
    margin-left: 1.5rem;
  }

  .van-toast {
    background-color: #FF6600;
    color: #FFFFFF
  }

  .my-content-list {
    padding: 0.3rem;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    border-bottom: 0.01rem solid #EDEDED;
  }


</style>
