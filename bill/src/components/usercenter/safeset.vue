<template>
   <div class="safeset">
   <div class="login" style="height: 30px;width: 100%;margin-top: 10px">
     <table style="width: 100%;height: 20px">
       <tr>
         <td> <span><i class="el-icon-edit"></i></span></td>
         <td> <span>登录密码</span></td>
         <td> <h4>已经设置登录密码</h4></td>
         <td> <div style="border-radius: 40% ;width: 40px;height: 15px;background-color:orange; text-align: center;font-size: 10px">已设置</div></td>
         <td><div style="border-radius: 40% ;width:40px;height: 15px;background-color:orange;text-align: center;font-size: 10px">修改</div></td>
       </tr>
     </table>
   </div>
     <hr>
     <div class="login" style="height: 30px;width: 100%;margin-top: 10px">
       <table style="width: 100%;height: 20px">
         <tr>
           <td> <span><i class="el-icon-view"></i></span></td>
           <td> <span>操作指引</span></td>
           <td> <h4>已经开启操作指引</h4></td>
           <td> <div style="border-radius: 40% ;width: 40px;height: 15px;background-color:orange; text-align: center;font-size: 10px">已开启</div></td>
           <td><div style="border-radius: 40% ;width:40px;height: 15px;background-color:orange;text-align: center;font-size: 10px">关闭</div></td>
         </tr>
       </table>
     </div>
     <hr>
     <div class="login" style="height: 60px;width: 100%;margin-top: 10px">
       <table style="width: 100%;height: 20px">
         <tr>
           <td> <span><i class="el-icon-view"></i></span></td>
           <td> <span>用户头像</span></td>&nbsp;&nbsp;&nbsp;
           <td> <h4>设置用户头像</h4></td>
           <td> <div style="margin-top: 40px;height: 30px" ><el-upload
             action="https://jsonplaceholder.typicode.com/posts/"
             list-type="picture-card"
             :on-preview="handlePictureCardPreview"
             :on-remove="handleRemove">
             <i class="el-icon-plus"></i>
           </el-upload>
             <el-dialog :visible.sync="dialogVisible">
               <img width="100%" :src="dialogImageUrl" alt="">
             </el-dialog></div></td>
         </tr>
       </table>
     </div>
   </div>
</template>

<script>
    export default {
        name: "safeset"
    }
</script>

<style scoped>

</style>
