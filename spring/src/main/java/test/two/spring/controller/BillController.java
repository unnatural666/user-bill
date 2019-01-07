package test.two.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import test.two.spring.bean.billInfo;
import test.two.spring.service.BillService;

@RestController
public class BillController {

    @Autowired
    private BillService billService;
    // 传入的参数file是我们指定的文件
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, billInfo bill) {
        return billService.Upload(file,bill);
    }

    @RequestMapping("/show")
    public String show(){
        return billService.show();
    }
}
