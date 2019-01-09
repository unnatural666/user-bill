<template>
  <div id="app">
    <router-view/>
    <go-top></go-top>

    <div class="foot">
      <!--<div class="tip" style="width: 100%;height: 120px;background-color:#8bff33;">-->

      </div>

    </div>
    <!--<div style="width: 100%;height: 390px; margin-top: auto">-->

      <!--<div style="width: 100%;height:180px;" class="bottom1">-->
        <!--&lt;!&ndash;条幅&ndash;&gt;-->
      <!--</div>-->

      <!--<div style="width: 100%;height: 300px;background-color:#323232;margin-top: -78px" class="bottom2">-->

        <!--<table style=" width: 900px;height: 200px;margin: -15px auto;color: white;text-align: center">-->
          <!--<tr>-->
            <!--<th>关于我们</th>-->
            <!--<th>规则协议</th>-->
            <!--<th></th>-->

            <!--<th>联系我们</th>-->
          <!--</tr>-->
          <!--<tr>-->
            <!--<td>平台简介</td>-->
            <!--<td>平台服务协议</td>-->
            <!--<td></td>-->
            <!--<td>客服热线：110</td>-->
          <!--</tr>-->
          <!--<tr>-->
            <!--<td>公司信息</td>-->
            <!--<td>票据中心服务协议</td>-->
            <!--<td></td>-->

            <!--<td>手机:13781599146</td>-->
            <!--<td></td>-->
          <!--</tr>-->
          <!--<tr>-->
            <!--<td>企业文化</td>-->
            <!--<td>平台规则</td>-->
            <!--<td>意见反馈</td>-->

            <!--<td>邮箱:767743430@qq.com</td>-->
            <!--<td></td>-->
          <!--</tr>-->

        <!--</table>-->
      <!--</div>-->
      <!--<div class="bottom3" style="width: 150px;height: 140px;position: absolute;margin-top: -280px;margin-left: 540px">-->
        <!--&lt;!&ndash;劝劝二维码&ndash;&gt;-->
      <!--</div>-->
      <!--<div class="bottom4" style="width: 100%;height: 50px ;position: absolute;margin-top: -70px;margin-left: 420px;color: white">-->
        <!--<span>Copyright © 2018河南省中原工学院科技有限公司 </span>-->
      <!--</div>-->
    <!--</div>-->
</template>

<script>
import GoTop from '@/components/gotop/GoTop'
export default {
  name: 'App',
  components: { GoTop }
}
</script>

<style>
* { margin: 0; padding: 0; }

body {
	background-color: #ffffff;
	font-weight: 400;
	font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
	line-height: 1.5;
}
a {
    cursor: pointer;
    text-decoration: none;
    transition: none 86ms ease-out;
}
a:hover {
	color: #5FB878;
}
.me-area{
	background-color: #fff;
}
html{height:100%;}
body{min-height:100%;}
body{position:relative;}

.me-pull-right {
	float: right;
}

.bottom1{
  background: url("../src/assets/img/bottom1.png") no-repeat 0px -5px;
  background-size: 100%;
}
.bottom3{
  background: url("../src/assets/img/wechat.png") no-repeat 0px -5px;
  background-size: 100%;
}
</style>
