<template>

  <div style="width: 100% ;height: auto; ">
    <div style="height: auto;width: 1100px; ">  <el-table
      :data="tableData"
      style="width: 90%;margin:10px -33px;height: auto">
      <el-table-column
        label="票据类型"
        width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">商票</span>
        </template>
      </el-table-column>
      <el-table-column
        label="票据图片"
        width="180" >
        <template slot-scope="scope">

          <span style="margin-left: 10px"><img :src="scope.row.path" alt="" style="width: 300px;height:90px;margin-top: -20px;margin-left: -22px"></span>
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

            @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
        <!--handleDelete(scope.$index, scope.row);-->
      </el-table-column>
    </el-table>

    </div>


  </div>

</template>

<script>
  export default {
    name: 'AboutUs',
    data() {
      return {
        billinfo:'',
        tableData: [{
          billname:'',
          eename: '',
          money: '',
          billtime: '',
          want: '',
          endorse:'',
          path:''
        }],

      }
    },
    created() {
      // let config={
      //   headers: { "Content-Type": "application/json;charset=UTF-8" }
      // };
      this.axios.post('http://localhost:8081/showmybill')
        .then(res => {
          this.tableData=res.data
          console.log(this.tableData);
        })
        .catch(error => {

        })
    },
    methods: {

      // handleDelete(index, row) {
      //   console.log(index, row);
      //   alert("hello")
      // },
      handleDelete(index, row) {
        let con=this.tableData
        // let connt=con[index].billname

        let config={
          headers: { "Content-Type": "application/json;charset=UTF-8" }
        };
        this.axios.post('http://localhost:8081/delete',con[index].billname,config)
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
