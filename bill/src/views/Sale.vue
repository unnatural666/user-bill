<template>
  <div style="margin:80px auto;width: 90%;height: 730px;border: 1px solid #cecece">

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
    <div style="width: 100% ;float: left ;margin:30px 20px ">
      <h3>上传票面</h3>

      <!--<div style="width: 40% ;float: left;margin-left: 100px"><el-upload-->
        <!--class="upload-demo"-->
        <!--drag-->
        <!--action="https://jsonplaceholder.typicode.com/posts/"-->
        <!--:on-preview="handlePreview"-->
        <!--:on-remove="handleRemove"-->
        <!--:file-list="fileList"-->
        <!--multiple>-->
        <!--<i class="el-icon-upload"></i>-->
        <!--<div class="el-upload__text">上传票据正面<em>click to upload</em></div>-->
      <!--</el-upload></div>-->
      <!---->
      <!--<div style="width: 40% ;float: left"><el-upload-->
        <!--class="upload-demo"-->
        <!--drag-->
        <!--action="https://jsonplaceholder.typicode.com/posts/"-->
        <!--:on-preview="handlePreview"-->
        <!--:on-remove="handleRemove"-->
        <!--:file-list="fileList"-->
        <!--multiple>-->
        <!--<i class="el-icon-upload"></i>-->
        <!--<div class="el-upload__text">上传票据反面<em>click to upload</em></div>-->
      <!--</el-upload></div>-->

      <div class="upload" style="margin:0 auto;">
        <!-- 图片展示 -->
        <div class="cha" v-show="(imgUrl)">
          <!-- 删除icon -->
          <div class="del"><i class="el-icon-delete" @click="delImg"></i></div>
          <img :src="imgUrl">
          <!-- 放大icon -->
          <div class="layer"><i @click="isEnlargeImage = true" class="el-icon-view"></i></div>
        </div>
        <!-- 图片上传控件 -->
        <div class="load" v-show="(!imgUrl)">
          <i class="el-icon-upload"></i>
          <input type="file" name="" id="form" @change="uploadIMG">
        </div>

        <!-- 图片预览弹框 -->
        <el-dialog :visible.sync="isEnlargeImage" size="large"  :append-to-body="true" top="8%" width="60%">
          <img @click="isEnlargeImage = false" style="width:100%;" :src="imgUrl">
        </el-dialog>

      </div>

    </div>

    <div style="clear: left;margin:25px 20px "> <h3>票面信息</h3></div>

    <div style="margin-top: -30px;height: 300px;margin-left:35px;width: 400px">
      <div id="complete">
        <div class="me-login-box me-login-box-radius">
          <el-form ref="userForm" :model="userForm" :rules="rules">
            <el-form-item prop="billname">
              <el-input placeholder="请输入票据号码" v-model="userForm.billname"  ></el-input>
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
              <el-button type="primary"  @click="invest">一键融资</el-button>
            </el-form-item>
          </el-form>

          <!--<div class="me-login-design">-->
            <!--<p>Click me go back-->
              <!--<strong><router-link to="/" class="me-login-design-color">Home</router-link></strong>-->
            <!--</p>-->
          <!--</div>-->

        </div>
      </div>
    </div>
  </div>

</template>

<script>
  export default {
    data() {
      return {
        input3: '',
        input4: '',
        input5: '',
        select: '',
        userForm:{
          account:'',
          billname:'',
          eename: '',
          money:'',
          billtime: '',
          flaw:'',
          want:'',
          endorse:'',
        },
        rules: {
          billname: [
            { required: true, message: '请输入票据号码', trigger: 'blur' },
            { max: 20, message: '不能大于10个字符', trigger: 'blur' }
          ],
          money: [
            { required: true, message: '请输入票据金额', trigger: 'blur' },
            { max: 20, message: '不能大于10个字符', trigger: 'blur' }
          ],
          billtime: [
            { required: true, message: '请输入票据到期日', trigger: 'blur' },
            { max: 20, message: '不能大于10个字符', trigger: 'blur' }
          ],
          eename: [
            { required: true, message: '请输入承兑人全称', trigger: 'blur' },
            { max: 10, message: '不能大于10个字符', trigger: 'blur' }
          ],
          want: [
            { required: true, message: '请输入期望价格', trigger: 'blur' },
            { max: 20, message: '不能大于10个字符', trigger: 'blur' }
          ],
          endorse: [
            { required: true, message: '请输入背书次数', trigger: 'blur' },
            { max: 20, message: '不能大于10个字符', trigger: 'blur' }
          ],
          flaw: [
            { required: true, message: '请输入票据瑕疵', trigger: 'blur' },
            { max: 20, message: '不能大于10个字符', trigger: 'blur' }
          ],
        },


        picavalue: "",
        imgUrl: null,
        isEnlargeImage: false
      }
    },
    methods:{
      // complete() {
      //   this.axios.post(
      //     'http://localhost:8081/addinfo',
      //     this.userForm,
      //   )
      //     .then(res => {
      //       this.$message({message: '恭喜你完善信息成功', type: 'success'})
      //       this.$router.push({path:'/'})
      //
      //     })
      //     .catch(error => {
      //
      //     })
      //
      // },
      uploadIMG(e) {
        let files = e.target.files || e.dataTransfer.files;
        if (!files.length) return;
        this.picavalue = files[0];
        console.log(this.picavalue.size / 1024);
        if (this.picavalue.size / 1024 > 5000) {
          this.$message({
            message: "图片过大不支持上传",
            type: "warning"
          });
        } else {
          this.imgPreview(this.picavalue);
        }
      },
      //获取图片
      imgPreview(file, callback) {
        let self = this;
        //判断支不支持FileReader
        if (!file || !window.FileReader) return;
        if (/^image/.test(file.type)) {
          //创建一个reader
          let reader = new FileReader();

          //将图片转成base64格式
          reader.readAsDataURL(file);
          //读取成功后的回调
          reader.onloadend = function() {
            let result = this.result;
            let img = new Image();
            img.src = result;
            console.log("********未压缩前的图片大小********");
            console.log(result.length);
            img.onload = function() {
              let data = self.compress(img);
              self.imgUrl = result;

              let blob = self.dataURItoBlob(data);

              console.log("*******base64转blob对象******");
              console.log(blob);

              var formData = new FormData();
              formData.append("file", blob);
              formData.append("data", this.userForm);
              console.log("********将blob对象转成formData对象********");
              console.log(formData.get("file"));
              let config = {
                headers: { "Content-Type": "multipart/form-data" }
              };
              // 发送请求;


                // self.axios.post('http://localhost:8100/upload', formData, config).then(res => {
                //   // console.log(res);
                //   // console.log(res.data.data.resultftphost)
                //   // console.log(res.data.data.resulturl)
                //   // this.$emit('')
                //   if (res.data.code == 200) {
                //     self.$emit(
                //       "getImgsrc",
                //       res.data.data.resultftphost,
                //       res.data.data.resulturl
                //     );
                //   } else {
                //     self.$message({
                //       message: "图片上传失败，请重试",
                //       type: "warning"
                //     });
                //   }
                // });


            };
          };
        }
      },

      invest(){
       this.axios.post('http://localhost:8100/upload', formData, config).then(res => {
          // console.log(res);
          // console.log(res.data.data.resultftphost)
          // console.log(res.data.data.resulturl)
          // this.$emit('')
          if (res.data.code == 200) {
            self.$emit(
              "getImgsrc",
              res.data.data.resultftphost,
              res.data.data.resulturl
            );
          } else {
            self.$message({
              message: "图片上传失败，请重试",
              type: "warning"
            });
          }
        });
      },
      // 压缩图片
      compress(img) {
        let canvas = document.createElement("canvas");
        let ctx = canvas.getContext("2d");
        let initSize = img.src.length;
        let width = img.width;
        let height = img.height;
        canvas.width = width;
        canvas.height = height;
        // 铺底色
        ctx.fillStyle = "#fff";
        ctx.fillRect(0, 0, canvas.width, canvas.height);
        ctx.drawImage(img, 0, 0, width, height);

        //进行最小压缩
        let ndata = canvas.toDataURL("image/jpeg", 0.1);
        // console.log("*******压缩后的图片大小*******");
        // console.log(ndata)
        // console.log(ndata.length);
        return ndata;
      },
      // base64转成bolb对象
      dataURItoBlob(base64Data) {
        var byteString;
        if (base64Data.split(",")[0].indexOf("base64") >= 0)
          byteString = atob(base64Data.split(",")[1]);
        else byteString = unescape(base64Data.split(",")[1]);
        var mimeString = base64Data
          .split(",")[0]
          .split(":")[1]
          .split(";")[0];
        var ia = new Uint8Array(byteString.length);
        for (var i = 0; i < byteString.length; i++) {
          ia[i] = byteString.charCodeAt(i);
        }
        return new Blob([ia], { type: mimeString });
      },
      //删除事件
      delImg() {
        this.imgUrl = null;
      }


    }
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
    min-height: 100%;
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



  .upload {
    position: relative;
    width: 200px;
    height: 220px;
   margin: 0 auto;
  }
     .cha {
       position: absolute;
       top: 0;
       left: 0;
       width: 100%;
       height: 100%;
       border-radius: 6px;
       border: 1px dashed #cccccc;
       overflow: hidden;
       box-sizing: border-box;}
  .layer {
    position: absolute;
    top: 0;
    left: 0;
    z-index: 2;
    width: 100%;
    height: 200px;
    background-color: rgba(0, 0, 0, 0.3);
    text-align: center;
    line-height: 200px;
    opacity: 0;
    color: #ffffff;
    border: none;
  }
  .del {
    position: absolute;
    bottom: 0;
    right: 0;
    opacity: 0;
    z-index: 2;
    border: none;
  }
  img {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 200px;
    border: none;
  }

    .cha:hover .layer,
    .cha:hover .del {
      opacity: 1;
    }


    .load {
      position: absolute;
      top: 0;
      left: 0;
      width: 200px;
      height: 200px;
      border: 1px dashed #cccccc; }
  input {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    opacity: 0;
  }

  .load::before {
    content: "";
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translateY(-50%);
    width: 1px;
    height: 80%;
    border-right: 1px solid #cccccc;
  }

  .load:after {
    content: "";
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translateX(-50%);
    width: 80%;
    height: 1px;
    border-top: 1px solid #cccccc;
  }

</style>
