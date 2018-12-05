<template>
  <el-container>
    <el-header>
      <Header :userName="name" :address="address"></Header>
    </el-header>
    <el-container style="justify-content: center;">
      <el-form :inline="true" :model="searchForm" ref="searchForm">
        <el-form-item>
          <el-select v-model="searchForm.address" clearable placeholder="请选择地址">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-input v-model="searchForm.name" clearable placeholder="请输入姓名"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="subForm">查看</el-button>
          <el-button @click="openDialog">新增</el-button>
        </el-form-item>
      </el-form>
    </el-container>
    <el-container style="justify-content: center;">
      <div style="width: 800px;">
        <el-table :data="userList" border>
          <el-table-column prop="name" label="姓名" align="center">
          </el-table-column>
          <el-table-column prop="age" label="年龄" align="center">
          </el-table-column>
          <el-table-column prop="address" label="公司地址" align="center">
          </el-table-column>
          <el-table-column label="操作" align="center">
            <template slot-scope="scope">
              <el-button type="text" @click="showDetail(scope.row)">修改</el-button>
              <el-button type="text" @click="deleteUser(scope.row)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </el-container>
    <el-dialog title="添加用户" :visible.sync="dialogVisible" center width="400px">
      <Register style="text-align: center;">
      </Register>
    </el-dialog>
    <el-dialog title="修改用户" :visible.sync="dialogVisible1" center width="400px">
      <AlterUser :alterUserForm="userForm" style="text-align: center;"></AlterUser>
    </el-dialog>
  </el-container>
</template>

<script>
  import Header from '@/components/header/Header'
  import Register from '@/components/header/Register'
  import AlterUser from '@/components/header/AlterUser'

  export default {
    name: "MainPage",
    data() {
      return {
        name: '',
        address: '',
        searchForm: {
          address: '',
          name: ''
        },
        userForm: {
          name: '',
          password: '',
          age: '',
         address: '',
          level: ''
        },
        userList: [],
        options: [{
          label: '中原工学院',
          value: '中原工学院'
        }, {
          label: '升达大学',
          value: '升达大学'
        }],
        dialogVisible: false,
        dialogVisible1: false
      }
    },
    created() {
      let user = JSON.parse(sessionStorage.getItem('user'))
      this.name = user.name
      this.address = user.address

    },
    methods: {
      subForm() {
        let user = this.searchForm
        this.$axios.post(
          '/user/findUser',
          user
        )
          .then(res => {
            this.userList = res.data
          })
          .catch(error => {

          })
      },
      openDialog() {
        this.dialogVisible = true
      },
      showDetail(rowData) {
        this.userForm = rowData
        this.dialogVisible1 = true
      },
      deleteUser(rowData) {
        this.$axios.post(
          '/user/alterUser',
          {user: rowData, operations: 'delete'}
        )
          .then(res => {
            alert(res.data)
          })
          .catch(error => {

          })
      }
    },
    components: {Header, Register, AlterUser}
  }
</script>

<style scoped>

</style>
