<template>
    <div style="width: 950px;height: 800px;border: 0.3px solid gray">
    <div style="width: 50%;height: 200px;float:left ;">
      <div class="head" style="width:70px;height:70px; border-radius: 50%;margin:55px 20px">
        <div style="height: 70px;border: 1px solid gray;margin-left: 90px"></div>
        <div style="height: 200px;position: absolute ;margin: -73px 110px">
          <table style="font-size: 15px">
            <tr><th>充值次数:</th><td>{{userinfo.time}}</td></tr>
            <tr><th>消费金额:</th><td>{{userinfo.expend}}</td></tr>

          </table>
        </div>
      </div>

    </div>
    <div style="width: 50%;height: 200px;float:right ; ">
      <div class="head1" style="width:80px;height:80px; border-radius: 50%;margin:55px 20px">
        <div style="height: 70px;border: 1px solid gray;margin-left: 90px">

        </div>
        <div style="height: 200px;position: absolute ;margin: -73px 110px">
          <table style="font-size: 15px">
            <tr><th>账户总资金：</th><td>{{userinfo.money}}</td></tr>

          </table>
        </div>
      </div>
    </div>
      <div style="width:950px ;margin-top: 200px;border: 0.5px dashed gray"></div>

    </div>
</template>

<script>
    export default {
        name: "overview",
      data(){
        return{
          userinfo:'',

          dialogTableVisible: false,
          dialogFormVisible: false,
          form: {
            time: '',
            money:'',
            expend:''

          },
          formLabelWidth: '120px'
        }

      },
      created() {
        this.axios.post('http://localhost:8081/showmoney')
          .then(res => {

            //console.log(res);
            this.userinfo=res.data
            // console.log(this.userinfo);

          })
          .catch(error => {

          })
      },
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
