<template>
<div class="all">
<div style="width: 20%;height: 600px;float: left">

</div>
<div style="width: 80%;height: 800px;float:right; ">
<div style="width: 70%;height: 80px; margin:0 20px">  <el-steps :active="1">
<el-step title="Step 1" description="完善企业信息"></el-step>
<el-step title="Step 2" description="绑定银行账户"></el-step>
<el-step title="Step 3" description="设置支付密码"></el-step>
</el-steps></div>
<div style="width: 60%;height: 400px;  margin:0 0px">
<form action="">
<fieldset>
<legend>用户档案</legend>
<label for="userName" id="">企业名：</label>
<input type="text" id="userName" name="userName" placeholder="请输入用户名" autofocus>
<label for="telNumber">手机号码：</label>
<input type="tel" placeholder="请输入手机号码" name="telNumber"
id="telNumber" pattern="^1\d{10}&">
<label for="email">邮箱地址：</label>
<input type="email" required name="email" id="email" placeholder="请输入邮箱地址">
<label for="mycollage" >公司地址:</label>
<input type="text" list="datalist" id="mycollage" placeholder="请填入你的地址">
<datalist id="datalist" >
<option value="上海" label="浦东新区"></option>
<option value="北京" label="三里屯"></option>
<option value="广州" label="陇海路中山路"></option>
<option value="河南" label="中原工学院"></option>
</datalist>
<label for="score">统一社会信用代码：</label>
<input type="number" id="score" max="10000000000" min="0" value="476200">
<label for="meter"></label>
<meter id="meter" max="100" min="0" low="60" high="90" value="60"></meter>
<label for="inTime">营业执照：</label>
<input type="data" id="inTime" name="inTime">
<label for="leTime">法人身份证：</label>
<input type="data" id="leTime" name="leTime">
<label for="leTime">提交</label>
<input type="submit" value="submit" name="提交" >
</fieldset>

</form>
</div>


</div>
</div>
</template>
<script>
export default {
data() {
return {
data: [
{
label: '我的订单',
children: [{
label: '我的买入',
children: [{
label: '订单状态'
}]
}, {
label: '我的卖出',
children: [{
label: '订单状态'
}]
}]
}, {
label: '我的钱包',
children: [{
label: '总览',
children: [{
label: '收入明细'
}]
}, {
label: '业务管理',
children: [{
label: '详细信息'
}]
}]
}, {
label: '经济商管理',
children: [{
label: '推荐链接',
children: [{
label: 'http://www.baidu.com'
}]
}, {
label: '经纪业务',
children: [{
label: '明细'
}]
}]
}, {
label: '设置',
children: [{
label: '基本设置',
children: [{
label: '风格'
}]
}, {
label: '通用设置',
children: [{
label: '语言'
}]
}]
}, {
label: '行业动态',
children: [{
label: '盈利显示',
children: [{
label: '总览'
}]
}, {
label: '市场分析',
children: [{
label: '总览'
}]
}]
}, {
label: '关于我们',
children: [{
label: '公司简介',
children: [{
label: '世界五百强'
}]
}, {
label: '公司位置',
children: [{
label: '中原工学院'
}]
}]
}, {
label: '联系我们',
children: [{
label: '邮箱',
children: [{
label: '767743430@qq.com'
}]
}, {
label: '电话',
children: [{
label: '110'
}]
}]
}],
defaultProps: {
children: 'children',
label: 'label'
}
};
},
methods: {
handleNodeClick(data) {
console.log(data);
}
}
};
</script>

<style scoped>

.el-header, .el-footer {
background-color: #B3C0D1;
color: #333;
text-align: center;
line-height: 60px;
}

.el-aside {
background-color: #D3DCE6;
color: #333;
text-align: center;
line-height: 200px;
}

.el-main {
background-color: #E9EEF3;
color: #333;
text-align: center;
line-height: 160px;
}

body > .el-container {
margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
line-height: 320px;
}
/*.el-steps{*/
/*width: 300px;*/
/*height: 150px;*/
/*}*/
form>fieldset{
padding: 10px ;
height: 540px;
}
form{
width: 450px;
margin: 20px auto;
}
form>fieldset>label{
font-size: 12px;
}
form>fieldset>meter,
form>fieldset>input{
width: 100%;
height: 20px;
line-height: 20;
margin: 10px 0;
border: none;
border: 1px #ccc solid;
border-radius: 5px;
font-size: 10px;
padding-left: 5px;
/* width = border + padding + 内容的  width，
height = border + padding + 内容的 height。*/
box-sizing: border-box;

}
form>fieldset>meter{
padding-left: 0px;
}
.all{
padding: 0;
margin: 0;
}
</style>
