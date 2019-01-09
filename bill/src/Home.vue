<template>
  <div id="home">
  <div>
    <el-container>

      <base-header :activeIndex="activeIndex"></base-header>

      <router-view class="me-container"/>

      <base-footer v-show="footerShow"></base-footer>

    </el-container>
  </div>
    <div style="width: 100%;height: 420px; ">

      <div style="width: 100%;height:180px;" class="bottom1">
        <!--条幅-->
      </div>

      <div style="width: 100%;height: 300px;background-color:#323232;margin-top: -78px" class="bottom2">

        <table style=" width: 900px;height: 200px;margin: 23px auto;color: white;text-align: center">
          <tr>
            <th>关于我们</th>
            <th>规则协议</th>
            <th></th>

            <th>联系我们</th>
          </tr>
          <tr>
            <td>平台简介</td>
            <td>平台服务协议</td>
            <td></td>
            <td>客服热线：110</td>
          </tr>
          <tr>
            <td>公司信息</td>
            <td>票据中心服务协议</td>
            <td></td>

            <td>手机:13781599146</td>
            <td></td>
          </tr>
          <tr>
            <td>企业文化</td>
            <td>平台规则</td>
            <td>意见反馈</td>

            <td>邮箱:767743430@qq.com</td>
            <td></td>
          </tr>

        </table>
      </div>
      <div class="bottom3" style="width: 150px;height: 140px;position: absolute;margin-top: -280px;margin-left: 540px">
        <!--劝劝二维码-->
      </div>

    </div>
		
  </div>
  
</template>

<script>
import BaseFooter from '@/components/BaseFooter'
import BaseHeader from '@/views/BaseHeader'

export default {
  name: 'Home',
  data (){
  	return {
  			activeIndex: '/',
  			footerShow:true
  	}
  },
  components:{
  	'base-header':BaseHeader,
  	'base-footer':BaseFooter
  },
  beforeRouteEnter (to, from, next){
  	 next(vm => {
    	vm.activeIndex = to.path
  	})
  },
  beforeRouteUpdate (to, from, next) {
	  if(to.path == '/'){
	  	this.footerShow = true
	  }else{
	  	this.footerShow = false
	  }
	  this.activeIndex = to.path
	  next()
	}
}
</script>

<style>

.me-container{
  margin: 100px auto 140px;
}
  .icon{
    width: 100%;
    height: 120px;
    /*background-color: #ff2714;*/
    position: absolute;
    margin-top: -140px;
    text-align: center;
  }
.haha{
background: #c9c9c9;width: 40px;height: 40px;border-radius: 50%;margin:50px 130px;float: left;
}
</style>
