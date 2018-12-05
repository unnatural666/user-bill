<template>
<div style="margin:20px 20px">
  <div style="width: 10% ;float: left; "><h2>步骤流程>></h2></div>
  <div style="width: 80%; float: left"><el-steps :active="0" >
    <el-step title="设置偏好" icon="el-icon-star-off"></el-step>
    <el-step title="支付票款" icon="el-icon-upload2"></el-step>
    <el-step title="签收票据" icon="el-icon-edit-outline"></el-step>
    <el-step title="完成订单" icon="el-icon-success"></el-step>
  </el-steps></div>
  <div style="margin-top: 15px; width: 89.9%;float: left">
    <el-input placeholder="输入搜索内容选择理想票据类型" v-model="input5" class="input-with-select">
      <el-select v-model="select" slot="prepend" placeholder="Select">
        <el-option label="商票" value="1"></el-option>
        <el-option label="银票" value="2"></el-option>
        <el-option label="销量" value="3"></el-option>
      </el-select>
      <el-button slot="append" icon="el-icon-search"></el-button>
    </el-input>
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
