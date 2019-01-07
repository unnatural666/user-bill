<template>
<div id="write">
<el-container>
  	<base-header :simple=true>
		<el-col :span="4" :offset="2">
			<div class="me-write-info">用户中心</div>
		</el-col>
		<el-col :span="4" :offset="6">
			<div class="me-write-btn">
			</div>
		</el-col>
  	</base-header>

  <div class="page" style="width: 100%;height:650px;margin-top: 60px">
    <div class="left" style=" height:auto ;float: left;width: 400px">
      <el-col :span="12">
        <el-menu
          default-active="2"
          class="el-menu-vertical-demo"
        >
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>我的订单</span>
            </template>
            <el-menu-item index="1-1">我的卖出</el-menu-item>
            <el-menu-item index="1-1">我的买入</el-menu-item>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-goods"></i>
              <span>我的钱包</span>
            </template>
            <el-menu-item index="1-1">总览</el-menu-item>
            <el-menu-item index="1-1">收支明细</el-menu-item>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title">
              <i class="el-icon-tickets"></i>
              <span>业务管理</span>
            </template>
            <el-menu-item index="1-1">客户明细</el-menu-item>
            <el-menu-item index="1-1">业绩榜</el-menu-item>
            <el-menu-item index="1-1">员工业绩</el-menu-item>
            <el-menu-item index="1-1">汇总统计</el-menu-item>
          </el-submenu>
          <el-submenu index="4">
            <template slot="title">
              <i class="el-icon-setting"></i>
              <span>设置</span>
            </template>
            <router-link to="/safeset"> <el-menu-item index="1-1">用户中心</el-menu-item></router-link>
            <router-link to="/basic"><el-menu-item index="1-1" v-if="false">信息完善</el-menu-item></router-link>
            <el-menu-item index="1-1">通用设置</el-menu-item>
            <el-menu-item index="1-1">子账号设置</el-menu-item>
            <el-menu-item index="1-1">承兑人分组设置</el-menu-item>
            <el-menu-item index="1-1">服务管理</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-col>
    </div>
    <div class="right" style="width: 100%;height: 400px;margin-left: 215px; position: absolute">
      <div style="width: 60%;height: 800px; margin:10px 20px;">  <transition>
        <router-view></router-view>
      </transition>
      </div>
    </div>

  </div>

</el-container>
</div>
</template>

<script>
import BaseHeader from '@/views/BaseHeader'
export default {
  name: 'userCenter',
  data (){
  	return {
  	}
  },

  components:{
  	'base-header':BaseHeader,
  },
  // 组件内的守卫 调整body的背景色
  // beforeRouteEnter(to, from, next) {
  //   window.document.body.style.backgroundColor = '#fff';
  //   next();
  // },
  // beforeRouteLeave(to, from, next) {
  //   window.document.body.style.backgroundColor = '#f5f5f5';
  //   next();
  // }
}
</script>

<style>
.el-header {
	position: fixed;
	z-index: 1024;
	min-width: 100%;
	box-shadow: 0 2px 3px hsla(0,0%,7%,.1), 0 0 0 1px hsla(0,0%,7%,.1);
}
.me-write-info {
	line-height: 60px;
	font-size: 18px;
	font-weight: 600;
}
.me-write-btn {
	margin-top: 10px;
}
.me-write-box {
	max-width: 700px;
	margin: 80px auto 0;
}
.me-write-main {
	padding: 0;
}
.me-write-title {
}
.me-write-input textarea{
	font-size: 32px;
	font-weight: 600;
	height: 20px;
	border: none;
}
.me-write-editor {
	min-height: 650px!important;
}
.me-header-left{
	margin-top: 10px;
}
.me-title img{
	max-height: 2.4rem;
	max-width: 100%;
}
.me-write-toolbar-fixed {
	position: fixed;
    width: 700px !important;
    top: 60px;
}
.v-note-op {
    box-shadow: none !important;
}
.auto-textarea-input,.auto-textarea-block {
	font-size: 18px !important;
}
</style>
