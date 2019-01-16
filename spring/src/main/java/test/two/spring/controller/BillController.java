package test.two.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import test.two.spring.bean.billInfo;
import test.two.spring.service.BillService;
import test.two.spring.util.ApiSelf;
import test.two.spring.util.JsonUtil;

import java.util.List;

@RestController
public class BillController {

    @Autowired
    private BillService billService;

    private ApiSelf apiSelf=new ApiSelf();
    // 传入的参数file是我们指定的文件
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        String filepath=billService.Upload(file);
        JsonUtil jsonUtil=new JsonUtil();
        String m=jsonUtil.json(String.valueOf(apiSelf.custom(filepath)));
        System.out.println(m);
        return m;
    }

    @RequestMapping("/upbill")
    public int upbill(billInfo bill){
        return billService.updateBill(bill);
    }

    @RequestMapping("/show")
    public List<billInfo> show(){
        return billService.showAll();
    }

    @RequestMapping(value = "/contend",produces = "application/json",consumes = "application/json")
    public billInfo contend(@RequestBody String billname){
        System.out.println(billname);
        return billService.showBillInfo(billname);
    }

   /* @RequestMapping(value = "/showsomebill",produces = "application/json",consumes = "application/json")
    public List<billInfo> showSomeBill(){
        return billService.showSomeBill();
    }*/
}
