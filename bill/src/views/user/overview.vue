<template>
    <div style="width: 950px;height: 410px;border: 0.3px solid gray">
    <div style="width: 50%;height: 200px;float:left ;">
      <div class="head" style="width:70px;height:70px; border-radius: 50%;margin:55px 20px">
        <div style="height: 70px;border: 1px solid gray;margin-left: 90px"></div>
        <div style="height: 200px;position: absolute ;margin: -73px 110px">
          <table style="font-size: 23px;margin-top: -2px">
            <tr><th>用户号码:</th><td>{{moneyinfo.account}}</td></tr>
            <tr><th>企业名称:</th><td>{{moneyinfo.eename}}</td></tr>

          </table>
        </div>
      </div>

    </div>
    <div style="width: 50%;height: 200px;float:right ; ">
      <div class="head1" style="width:80px;height:80px; border-radius: 50%;margin:55px 20px">
        <div style="height: 70px;border: 1px solid gray;margin-left: 90px">

        </div>
        <div style="height: 200px;position: absolute ;margin: -73px 110px">
          <table style="font-size: 23px;margin-top: 15px">
            <tr><th>  </th><td></td></tr>
            <tr><th>账户总资金：</th><td>{{moneyinfo.money}}</td></tr>
            <tr><th></th><td></td></tr>

          </table>
        </div>
      </div>
    </div>
      <div style="width:950px ;margin-top: 200px;border: 0.5px solid gray"></div>

      <div >
        <h1 style="margin: 80px 100px;float: left">充值次数：{{moneyinfo.time}}</h1>
        <h1 style="margin: 80px 170px;float: left">消费金额:{{moneyinfo.expend}}</h1>

        <div style="position: absolute;margin:78px 750px">  <el-button type="success"  icon="el-icon-edit" round @click="dialogFormVisible = true">充值</el-button></div>
      </div>


      <div class="repair">
        <el-dialog title="充值金额" :visible.sync="dialogFormVisible">
          <el-form :model="form">
            <el-form-item label="输入充值金额：" :label-width="formLabelWidth">
              <el-input v-model="form.money" autocomplete="off"></el-input>
            </el-form-item>
          </el-form>
          <span slot="footer" class="dialog-footer">
    <el-button @click="dialogFormVisible = false">取消</el-button>
    <el-button type="primary" @click="repair">确认</el-button>
  </span>
        </el-dialog>
      </div>
    </div>
</template>

<script>
    export default {
        name: "overview",
      data(){
        return{
          moneyinfo:'',
          dialogTableVisible: false,
          dialogFormVisible: false,

          form: {
           money:'',
          },
          formLabelWidth: '120px'
        }

      },
      created() {
        this.axios.post('http://localhost:8081/showmoney')
          .then(res => {
            this.moneyinfo=res.data
          })
          .catch(error => {

          })
      },
      methods:{
        repair(){
          this.axios.post(
            'http://localhost:8081/charge',
            this.form,
          )
            .then(res => {
              this.$message({message: '恭喜你充值成功', type: 'success'})
              this.$router.push({path:'/'})

            })
            .catch(error => {

            })
        }
      }
    }
</script>

<style scoped>
  .head{
    background: url("/static/user/head.jpeg");
    background-size: 100%;
  }
  .head1{
    background: url("/static/user/money.png") no-repeat;
    background-size: 100% ;
  }
</style>
