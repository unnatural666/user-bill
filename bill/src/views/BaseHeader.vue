<template>
  <el-header class="me-area">
		<el-row class="me-header">
			
			  <el-col :span="4" class="me-header-left">
			  	 <router-link to="/" class="me-title">
			  	 	<img src="../assets/img/logg.jpg" style="width: 160px;height: 180px;background-size:100% 100%;  "/>
			  	</router-link>
			  </el-col>
			  
			  <el-col v-if="!simple" :span="16">
			  	<el-menu :router=true menu-trigger="click" active-text-color="#5FB878" :default-active="activeIndex" mode="horizontal" >
					  <el-menu-item index="/">首页</el-menu-item>
					  <el-menu-item index="/lobby">票据大厅</el-menu-item>
					  <el-menu-item index="/buy">我是买方</el-menu-item>
					  <el-menu-item index="/sale">我是卖方</el-menu-item>
					  <el-menu-item index="/user">我是小腊鸡</el-menu-item>

					  <el-col :span="4" :offset="4">
					  	<el-menu-item index="/write" ><i class="el-icon-edit"></i>用户中心</el-menu-item>
					  </el-col>
					  
					</el-menu>
			  </el-col>
			  
			  <template v-else>
			  	<slot></slot>
			  </template>
			  
			  <el-col :span="4">
				  <el-menu :router=true menu-trigger="click" mode="horizontal" active-text-color="#5FB878">
				  	
				  	<template v-if="!user.login">
					  	<el-menu-item index="/login"><el-button type="text">登录</el-button></el-menu-item>
							<el-menu-item index="/register"><el-button type="text">注册</el-button></el-menu-item>
						</template>
						
						<template v-else>	
						  <el-submenu index>
							    <template slot="title">
										<!--<img class="me-header-picture" :src="user.avatar" />						    	-->
										<img class="me-header-picture" src="/static/user/head.jpeg" />
							    </template>
							    <el-menu-item index @click="logout"><i class="el-icon-back"></i>退出</el-menu-item>
							</el-submenu>
						</template>
					</el-menu>	
				</el-col>
				
		</el-row>
	</el-header>
</template>

<script>
export default {
  name: 'BaseHeader',
  props:{
  	activeIndex:String,
  	simple:{
      type: Boolean,
      default: false
    }
  },
  data() {
  	return {
  	}
  },
  computed:{
  	user() {
  		let login = this.$store.state.account.length != 0
  		let avatar = this.$store.state.avatar
  		return {
  			login, avatar
  		}
  	}
  },
  methods:{
  	logout(){
  		let that = this
  		this.$store.dispatch('logout').then(() => {
				this.$router.push({ path: '/' })
        that.$message({message: '已退出 ',type: 'success',showClose: true});
			}).catch((error) => {
				if(error !== 'error'){
					that.$message({message: error,type: 'error',showClose: true});
				}
  		})
  	}
  }
}
</script>

<style>

.el-header {
  position: fixed;
  z-index: 1024;
  min-width: 100%;
  box-shadow: 0 2px 3px hsla(0,0%,7%,.1), 0 0 0 1px hsla(0,0%,7%,.1);
}
  
.me-title{
	margin-top: 10px;
	font-size: 24px ;
}

.me-header-left{
		/*margin-top: 10px;*/
}
.me-title img{
	/*max-height: 2.4rem;*/
	max-width: 100%;
	max-height: 60px;
}
.me-header-picture {
	width: 36px;
    height: 36px;
    border: 1px solid #ddd;
    border-radius: 50%;
    vertical-align: middle;
    background-color: #5fb878;
}

</style>
