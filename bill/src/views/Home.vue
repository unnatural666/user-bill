<template>

<div style="width: 100%;margin-top: 60px">
  <el-container>
    <el-main> <el-carousel :interval="5000" arrow="always">
      <el-carousel-item v-for="item in dataimg" :key="item.value">
        <div>
          <img :src="item.src">
        </div>
      </el-carousel-item>
    </el-carousel>

      <el-table
        :data="tableData3"
        style="width: 100%"
        height="250">
        <el-table-column
          fixed
          prop="date"
          label="成交时间"
          width="150">
        </el-table-column>
        <el-table-column
          prop="name"
          label="票据类型"
          width="120">
        </el-table-column>

        <el-table-column
          prop="address"
          label="承兑人"
          width="300">
        </el-table-column>
        <el-table-column
          prop="state"
          label="票据金额"
          width="120">
        </el-table-column>
        <el-table-column
          prop="city"
          label="到期日"
          width="120">
        </el-table-column>

        <el-table-column
          prop="zip"
          label="状态"
          width="120">
        </el-table-column>
      </el-table>
    </el-main>
    <el-footer>
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page.sync="currentPage4"
        :page-sizes="[100, 200, 300, 400]"
        :page-size="100"
        layout="total, sizes, prev, pager, next, jumper"
        :total="400">
      </el-pagination>
    </el-footer>
  </el-container>
</div>

</template>
<script>
  export default {
    methods: {
      handleSizeChange(val) {
        console.log(`${val} items per page`);
      },
      handleCurrentChange(val) {
        console.log(`current page: ${val}`);
      },
      formatter(row, column) {
        return row.address;
      }
    },
    data() {
      return {
        dataimg: [{
            src: require('../assets/img/3.jpg'),
        },
          {
            src: require('../assets/img/02.png'),
          },
          {
            src: require('../assets/img/4.png'),
          },
          {
            src: require('../assets/img/6.jpg'),
          }
        ],
        tableData3: [{
          date: '2018-11-11',
          name: '商票',
          state: '10000000000',
          city: '2019-11-11',
          address: '清华大学',
          zip: '成交'
        }, {
          date: '2018-11-11',
          name: '银票',
          state: '20000000000',
          city: '2019-11-11',
          address: '北京大学',
          zip: '成交'
        }, {
          date: '2018-11-11',
          name: '商票',
          state: '40000000000',
          city: '2019-11-11',
          address: '腾讯有限公司',
          zip: '成交'
        }, {
          date: '2018-11-11',
          name: '银票',
          state: '50000000000',
          city: '2019-11-11',
          address: '网易有限公司',
          zip: '成交'
        }, {
          date: '2018-11-11',
          name: '商票',
          state: '800000000',
          city: '2019-11-11',
          address: '阿里巴巴有限公司',
          zip: '成交'
        }, {
          date: '2018-12-12',
          name: '银票',
          state: '9000000000',
          city: '2019-12-12',
          address: '百度有限公司',
          zip: '成交'
        }, {
          date: '2018-12-12',
          name: '商票',
          state: '50000000000',
          city: '2019-12-12',
          address: '中原工学院',
          zip: '成交'
        }],
        currentPage1: 5,
        currentPage2: 5,
        currentPage3: 5,
        currentPage4: 4
      };
    }
  }
</script>

<style >
  .el-carousel__item h3 {
    color: #475669;
    font-size: 18px;
    opacity: 0.75;
    line-height: 300px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #7bff2a;
  }
  .el-header{
    padding: 0 0px;
  }
  .el-main{
    padding: 0px 0px;
  }
  .el-carousel,.el-carousel__container{
    height: 380px;
  }
  .el-table{
    width: 100%;
    height: 320px;
  }
</style>
