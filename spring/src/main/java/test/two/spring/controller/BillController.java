package test.two.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping("/contend")
    public billInfo contend(String billname){
        return billService.showBillInfo(billname);
    }
}
