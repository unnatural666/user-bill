<template>

<div style="width: 100% ;height: auto;margin-top:80px ">
  <div style="width: 800px;height: 260px;">
    <div class="dormitory">
      <!--<div class="searchWord">-->
        <!--<div style="display: inline-block"> 搜索：</div>-->
        <!--<el-input v-model="search" style="display: inline-block;width: 200px"-->
                  <!--placeholder="请输入搜索内容">-->
        <!--</el-input>-->
      <!--</div>-->
      <div>
    <table style=" line-height: 35px;width: 900px; margin-left: 40px">
      <tr>
        <th style="padding-left: 0px ;font-size: 16px"><i class="el-icon-star-on"></i> 承兑对象</th>
        <td>商票</td>
        <td>银票</td>
        <td>国股</td>
        <td>三农</td>
        <td>财票</td>

      </tr>
      <tr>
        <th style="padding-left: 0px ;font-size: 16px"><i class="el-icon-goods"></i> 票面金额</th>
        <td>10万以下</td>
        <td>10-100万</td>
        <td>100万以上</td>
        <td>500万以上</td>
        <td>财票</td>
        <td width="150px">

        </td>
        <!--<td width="150px"><el-input-->
          <!--type="textarea"-->
          <!--autosize-->
          <!--resize='none'-->
          <!--placeholder="最高金额"-->
         <!--&gt;-->
        <!--</el-input></td>-->

      </tr>
      <tr>
        <th style="padding-left: 0px ;font-size: 16px" ><i class="el-icon-loading"></i> 剩余天数</th>
        <td>30天内</td>
        <td>60-90天</td>
        <td>190-180天</td>
        <td>180-360天</td>
        <td>180-360天</td>
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
    </table>
      </div>
      <div style="margin-left: 60px">
        <el-input v-model="search" style="display: inline-block;width: 500px" placeholder="请输入票据金额或承兑人或到期时间">
        </el-input>
      </div>
  </div>
  </div>
 <div style="height: auto;width: 100%; " class="dormitoryData">

   <el-table
     :data="tables.slice((pageIndex-1)*pageSize,pageIndex*pageSize)"
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

       <span style="margin-left: 10px" v-html="format(scope.row.eename)"></span>
     </template>
   </el-table-column>
   <el-table-column
     label="金额"
     width="180">
     <template slot-scope="scope">

       <span style="margin-left: 10px" v-html="format(scope.row.money)"></span>
     </template>
   </el-table-column>
   <el-table-column
     label="到期日"
     width="180">
     <template slot-scope="scope">

       <span style="margin-left: 10px" v-html="format( scope.row.billtime )"></span>
     </template>
   </el-table-column>
   <el-table-column
     label="期望价"
     width="180">
     <template slot-scope="scope">

       <span style="margin-left: 10px"  v-html="format( scope.row.want )"></span>
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
   <el-pagination
     @size-change="handleSizeChange"
     @current-change="handleCurrentChange"
     :current-page="pageIndex"
     :page-sizes="[2, 3, 4, 5]"
     :page-size="pageSize"
     layout="total, sizes, prev, pager, next, jumper"
     :total="total">
   </el-pagination>

   <div class="repair">
     <el-dialog title="报价" :visible.sync="dialogFormVisible" >
      <div style="width: 560px;height: 400px;">

         <div style="text-align: center"> <img :src="billinfo.path" alt="" style="width: 350px;height: 200px;margin-top: -20px;margin-left: -22px"></div>
        <div >
          <h4 style="text-align: center">承兑对象:{{billinfo.eename}}</h4>
          <table class="gridtable">

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


</div>

</template>

<script>
  export default {
    name: 'AboutUs',
    data() {
      return {
        pageSize: 2,
        pageIndex: 1,
        search: '',
        dialogTableVisible: false,
        dialogFormVisible: false,
        formLabelWidth: '120px',
        billinfo: '',
        tableData: [{
          billname: '',
          eename: '',
          money: '',
          billtime: '',
          want: '',
          endorse: ''
        }],

      }
    },
    computed: {
      // 模糊搜索
      tables () {
        const search = this.search
        if (search) {
          return this.tableData.filter(dataNews => {
            return Object.keys(dataNews).some(key => {
              return String(dataNews[key]).toLowerCase().indexOf(search) > -1
            })
          })
        }
        return this.tableData
      },
      // 总条数
      total () {
        return this.tables.length
      }
    },


    created() {
      this.axios.post('http://localhost:8081/show')
        .then(res => {
          this.tableData = res.data
          // console.log(this.tableData);
        })
        .catch(error => {

        })
    },
    watch: {
      // 检测表格数据过滤变化，自动跳到第一页
      tables () {
        this.pageIndex = 1
      }
    },
    methods: {
      format (val) {
        val = val.toString()
        if (val.indexOf(this.search) !== -1 && this.search !== '') {
          return val.replace(this.search, '<font color="red">' + this.search + '</font>')
        } else {
          return val
        }
      },

      handleSizeChange (val) {
        this.pageSize = val
      },
      handleCurrentChange (val) {
        this.pageIndex = val
      },
        bill(index, row) {
          let con = this.dormitory
          // let connt=con[index].billname
          this.dialogFormVisible = true
          let config = {
            headers: {"Content-Type": "application/json;charset=UTF-8"}
          };
          this.axios.post('http://localhost:8081/contend', con[index].billname, config)
            .then(res => {
              this.billinfo = res.data

            })
            .catch(error => {

            })

        },

      },
      // handleDelete(index, row) {
      //   console.log(index, row);
      //   alert("hello")
      // },

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
