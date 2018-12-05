<template>
  <div style="margin:20px 20px">
    <div style="width: 10% ;float: left; "><h2>步骤流程>></h2></div>
    <div style="width: 80%; float: left"><el-steps :active="0" >
      <el-step title="发布票据" icon="el-icon-message"></el-step>
      <el-step title="确认意向" icon="el-icon-tickets"></el-step>
      <el-step title="背书转让" icon="el-icon-edit"></el-step>
      <el-step title="完成订单" icon="el-icon-success"></el-step>
    </el-steps></div>
    <br>
    <div style="width: 100% ;float: left">
      <h3>上传票面</h3>
      <div style="width: 40% ;float: left;margin-left: 100px"><el-upload
        class="upload-demo"
        drag
        action="https://jsonplaceholder.typicode.com/posts/"
        :on-preview="handlePreview"
        :on-remove="handleRemove"
        :file-list="fileList"
        multiple>
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">上传票据正面<em>click to upload</em></div>
      </el-upload></div>
      <div style="width: 40% ;float: left"><el-upload
        class="upload-demo"
        drag
        action="https://jsonplaceholder.typicode.com/posts/"
        :on-preview="handlePreview"
        :on-remove="handleRemove"
        :file-list="fileList"
        multiple>
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">上传票据反面<em>click to upload</em></div>
      </el-upload></div>

    </div>
    <div style="clear: left"> <h3>票面信息</h3></div>

    <div style="margin-top: 10px;height: 200px">
      <form action="" style="width: 300px;height: 400px; float: left">
        <label for="">票据号码：</label>
        <input type="text"><br><br>
        <label for="">期望价格：</label>
        <input type="text"><br><br>
        <label for="">票据金额：</label>
        <input type="text">  元<br><br>
        <label for="">票据到期：</label>
        <input type="text">    剩余日期？<br><br>
        <label for="">承兑人称：</label>
        <input type="text"><br><br>
      </form>
      <form action="" style="width: 300px;height: 400px; float: left">
        <label for="">买家的ID：</label>
        <input type="text"><br><br>
        <label for="">背书次数：</label>
        <input type="text"><br><br>
        <label for="">票据瑕疵：</label>
        <input type="text"><br><br><br>
        <el-button type="success">一键融资</el-button>
        <el-button type="primary">暂时保存</el-button>
      </form>

    </div>

    <hr>
    <div></div>

  </div>

</template>

<script>
  export default {
    data() {
      return {
        input3: '',
        input4: '',
        input5: '',
        select: ''
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
</style>
