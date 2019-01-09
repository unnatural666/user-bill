<template>

<div style="width: 100% ;height: auto;margin:80px 120px">
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
 <div style="height: 800px;width: 1500px; "> <el-table
   ref="filterTable"
   :data="tableData"
   style="width: 1000px">
   <el-table-column
     prop="date"
     label="发布时间"
     sortable
     width="120"
     column-key="date"
     :filters="[{text: '2018-05-01', value: '2018-05-01'}, {text: '2018-05-02', value: '2018-05-02'}, {text: '2018-05-03', value: '2018-05-03'}, {text: '2018-05-04', value: '2018-05-04'}]"
     :filter-method="filterHandler"
   >
   </el-table-column>
   <el-table-column
     prop="name"
     label="票据类型"
     width="100">
   </el-table-column>
   <el-table-column
     prop="address"
     label="承兑人"
     width="250"
     :formatter="formatter">
   </el-table-column>
   <el-table-column
     prop="xiaci"
     label="瑕疵"
     width="100">
   </el-table-column>
   <el-table-column
     prop="money"
     label="金额"
     width="90">
   </el-table-column>
   <el-table-column
     prop="endTime"
     label="到期日"
     width="100">
   </el-table-column>
   <el-table-column
     prop="want"
     label="期望价格"
     width="80">
   </el-table-column>
   <el-table-column
     prop="xinyong"
     label="信用"
     width="60">
   </el-table-column>
   <el-table-column
     prop="tag"
     label="操作"
     width="80"
     :filters="[{ text: 'Home', value: 'Home' }, { text: 'Office', value: 'Office' }]"
     :filter-method="filterTag"
     filter-placement="bottom-end">
     <template slot-scope="scope">
       <el-tag
         :type="scope.row.tag === 'Home' ? 'primary' : 'success'"
         disable-transitions>{{scope.row.tag}}</el-tag>
     </template>
   </el-table-column>
 </el-table>

 </div>

  <div style="height: 100px ;position: absolute;margin-top: -250px;margin-left: 450px" class="block ;">
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

        tableData: [{
          date: '2018-05-03',
          name: '商票',
          address: '新郑市龙湖镇中原工学院',
          tag: '去报价',
          xiaci:'无',
          money:'10000000',
          endTime:'2019/11/11',
          want:'20%',
          xinyong:'优秀'
        }, {
          date: '2018-05-02',
          name: '银票',
          address: '郑州大学',
          tag: '去报价',
          xiaci:'无',
          money:'1000000',
          endTime:'2019/11/11',
          want:'40%',
          xinyong:'优秀'
        }, {
          date: '2018-05-04',
          name: '商票',
          address: '北京大学',
          tag: '去报价',
          xiaci:'无',
          money:'1000000',
          endTime:'2019/11/11',
          want:'60%',
          xinyong:'优秀'
        }, {
          date: '2018-05-01',
          name: '银票',
          address: '上海交通大学',
          tag: '去报价',
          xiaci:'无',
          money:'1000000',
          endTime:'2019/11/11',
          want:'70%',
          xinyong:'优秀'
        }, {
          date: '2018-05-01',
          name: '银票',
          address: '上海交通大学',
          tag: '去报价',
          xiaci:'无',
          money:'1000000',
          endTime:'2019/11/11',
          want:'70%',
          xinyong:'优秀'
        }]
      }
    },
    methods: {
      resetDateFilter() {
        this.$refs.filterTable.clearFilter('date');
      },
      clearFilter() {
        this.$refs.filterTable.clearFilter();
      },
      formatter(row, column) {
        return row.address;
      },
      filterTag(value, row) {
        return row.tag === value;
      },
      filterHandler(value, row, column) {
        const property = column['property'];
        return row[property] === value;
      }
    }

  }

</script>

<style scoped>
div{
  margin: 0;
}
</style>
