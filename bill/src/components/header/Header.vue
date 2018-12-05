<template xmlns:margin="http://www.w3.org/1999/xhtml">
    <div id="Header">
      <div style="text-align: center"><h4>欢迎您:{{ userName }}</h4></div>
      <!--<div><span>公司地址:{{ address }}</span></div>-->
    </div>
</template>

<script>
    export default {
        name: "Header",
        data() {
          return {
          }
        },
      props: [
        'userName','address'
      ]
    }
</script>

<style scoped>
  #Header {
    background-color: darkblue;
    color: white;
  }
</style>
