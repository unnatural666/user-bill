<template>

<div style="width: 100% ;height: auto;margin-top:80px ">
  <div>
    <table style=" line-height: 35px;width: 900px; margin-left: -10px">
      <tr>
        <th style="padding-left: 0px ;font-size: 16px"><i class="el-icon-star-on"></i> 承兑对象</th>
        <td>商票</td>
        <td>银票</td>
        <td>国股</td>
        <td>三农</td>
        <td>财票</td>
        <td width="120px"><el-input
          type="textarea"
          autosize
          placeholder="请输入承兑人"
          resize='none'

        >
        </el-input></td>
      </tr>
      <tr>
        <th style="padding-left: 0px ;font-size: 16px"><i class="el-icon-goods"></i> 票面金额</th>
        <td>10万以下</td>
        <td>10-100万</td>
        <td>100万以上</td>
        <td>500万以上</td>
        <td>财票</td>
        <td width="150px"><el-input
          type="textarea"
          resize='none'
          autosize
          placeholder="最低金额"
          >
        </el-input></td>---
        <td width="150px"><el-input
          type="textarea"
          autosize
          resize='none'
          placeholder="最高金额"
         >
        </el-input></td>

      </tr>
      <tr>
        <th style="padding-left: 0px ;font-size: 16px" ><i class="el-icon-loading"></i> 剩余天数</th>
        <td>30天内</td>
        <td>60-90天</td>
        <td>190-180天</td>
        <td>180-360天</td>
        <td>180-360天</td>

        <td width="150px"><el-input
          type="textarea"
          autosize
          resize='none'
          placeholder="输入天数"
         >
        </el-input></td>
      </tr>
      <tr >
        <th style="padding-left: 0px ;font-size: 16px"><i class="el-icon-document"></i> 有无瑕疵</th>
        <td>有瑕疵</td>
        <td>无瑕疵</td>

      </tr>
      <tr >
        <th style="padding-left: 0px ;font-size: 16px"><i class="el-icon-view"></i> 成交信用</th>
        <td>良好</td>
        <td>一般</td>
        <td>优秀</td>

      </tr>
      <tr>
        <th style="padding-left: 0px ;font-size: 16px"><i class="el-icon-zoom-out"></i> 最低票价</th>


        <td width="80px"><el-input
          type="textarea"
          autosize
          resize='none'
          placeholder="年利率"
         >
        </el-input></td>
        <td width="80px"><el-input
          type="textarea"
          autosize
          resize='none'
          placeholder="手续费"
         >
        </el-input></td>
      </tr>
    </table>
  </div>
 <div style="height: 800px;width: 100%; ">  <el-table
   :data="tableData"
   style="width: 100%">
   <el-table-column
     label="票据类型"
     width="180">
     <template slot-scope="scope">
       <span style="margin-left: 10px">商票</span>
     </template>
   </el-table-column>
   <el-table-column
     label="承兑人"
     width="180" >
     <template slot-scope="scope">

       <span style="margin-left: 10px">{{ scope.row.eename }}</span>
     </template>
   </el-table-column>
   <el-table-column
     label="金额"
     width="180">
     <template slot-scope="scope">

       <span style="margin-left: 10px">{{ scope.row.money }}</span>
     </template>
   </el-table-column>
   <el-table-column
     label="到期日"
     width="180">
     <template slot-scope="scope">

       <span style="margin-left: 10px">{{ scope.row.billtime }}</span>
     </template>
   </el-table-column>
   <el-table-column
     label="期望价"
     width="180">
     <template slot-scope="scope">

       <span style="margin-left: 10px">{{ scope.row.want }}</span>
     </template>
   </el-table-column>

   <el-table-column label="操作">
     <template slot-scope="scope">

       <el-button
         size="mini"
         type="danger"

       @click="bill(scope.$index, scope.row)">去报价</el-button>
     </template>
     <!--handleDelete(scope.$index, scope.row);-->
   </el-table-column>
 </el-table>

   <div class="repair">
     <el-dialog title="报价" :visible.sync="dialogFormVisible">
      <div style="width: 560px;height: 400px;">

         <div style="text-align: center"> <img :src="billinfo.path" alt="" style="width: 350px;height: 200px;margin-top: -20px;margin-left: -22px"></div>
        <div>
          <table class="gridtable">
            <tr><td ><h3>承兑对象:{{billinfo.eename}}</h3></td><td ></td></tr>
            <tr><td >票据金额:{{billinfo.money}}</td><td >票据账号:{{billinfo.billname}}</td></tr>
            <tr><td>票据瑕疵:{{billinfo.flaw}}</td><td>期望价格:{{billinfo.want}}</td></tr>
            <tr><td>背书次数:{{billinfo.endorse}}</td><td>到期时间:{{billinfo.billtime}}</td></tr>

          </table>
        </div>
      </div>
       <span slot="footer" class="dialog-footer">
    <el-button @click="checked = false;dialogFormVisible = false">关闭</el-button>
    <el-button type="primary"  @click="dialogFormVisible = false;checked=true">确认</el-button>
  </span>
     </el-dialog>
   </div>

 </div>

  <!--分页-->
  <div style="height: 100px ;position: absolute;margin-top: -450px;margin-left: 450px" class="block ;">
    <el-pagination
      :page-sizes="[100, 200, 300, 400]"
      :page-size="100"
      layout="total, sizes, prev, pager, next, jumper"
      :total="400">
    </el-pagination>
  </div>

</div>

</template>

<script>
  export default {
    name: 'AboutUs',
    data() {
      return {
        dialogTableVisible: false,
        dialogFormVisible: false,
        formLabelWidth: '120px',
        billinfo:'',
        tableData: [{
          billname:'',
          eename: '',
          money: '',
          billtime: '',
          want: '',
          endorse:''
        }],

      }
    },
    created() {
      this.axios.post('http://localhost:8081/show')
        .then(res => {
          this.tableData=res.data
          // console.log(this.tableData);
        })
        .catch(error => {

        })
    },
    methods: {

      // handleDelete(index, row) {
      //   console.log(index, row);
      //   alert("hello")
      // },
      bill(index, row){

          let con=this.tableData
       // let connt=con[index].billname
        this.dialogFormVisible = true
        let config={
          headers: { "Content-Type": "application/json;charset=UTF-8" }
        };
        this.axios.post('http://localhost:8081/contend',con[index].billname,config)
          .then(res => {
            this.billinfo=res.data

          })
          .catch(error => {

          })

      },
    }

  }

</script>

<style scoped>
div{
  margin: 0;
}
  .el-table{
    text-align: center;
  }
  .el-table__header-wrapper{
    text-align: center;
  }

.el-dialog {
  position: relative;
  margin: 0 auto 50px;
  border-radius: 2px;
  -webkit-box-shadow: 0 1px 3px rgba(0,0,0,.3);
  box-shadow: 0 1px 3px rgba(0,0,0,.3);
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  width: 70%;
}

  /*.el-dialog__wrapper{*/
    /*width: 70%;*/
  /*}*/

table.gridtable {
  font-family: verdana,arial,sans-serif;
  font-size:14px;
  color:#333333;
  border-width: 1px;
  /*border-color: #666666;*/
  border-collapse: collapse;
  margin-left: 80px;
}
table.gridtable th {
  border-width: 1px;
  padding: 8px;
  /*border-style: solid;*/
  /*border-color: #666666;*/
  /*background-color: #dedede;*/

}
table.gridtable td {
  /*border-width: 1px;*/
  padding: 8px;
  /*border-style: solid;*/
  /*border-color: #666666;*/
  background-color: #ffffff;
  width: 180px;}



</style>

<style>
  .el-table th>.cell {
    position: relative;
    word-wrap: normal;
    text-overflow: ellipsis;
    vertical-align: middle;
    width: 100%;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    text-align: center;
  }
</style>
