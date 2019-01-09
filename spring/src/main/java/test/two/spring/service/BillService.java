package test.two.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import test.two.spring.bean.billInfo;
import test.two.spring.controller.CurrentUserController;
import test.two.spring.mapper.BillMapper;
import test.two.spring.util.FileUtil;

import java.io.IOException;

@Service
public class BillService {

    @Autowired
    private BillMapper billMapper;
    @Autowired
    CurrentUserController currentUserController;

    String billpath;

    public String Upload(@RequestParam("file") MultipartFile file) {
        if(!file.isEmpty()) {
            // 获取文件名称,包含后缀
            String fileName = file.getOriginalFilename();

            // 存放在这个路径下：该路径是该工程目录下的static文件下：(注：该文件可能需要自己创建)
            // 放在static下的原因是，存放的是静态文件资源，即通过浏览器输入本地服务器地址，加文件名时是可以访问到的
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/";
            try {
                // 该方法是对文件写入的封装，在util类中，导入该包即可使用，后面会给出方法
                FileUtil.fileupload(file.getBytes(), path, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 接着创建对应的实体类，将以下路径进行添加，然后通过数据库操作方法写入
            billInfo biaopath = new billInfo();
            biaopath.setPath("http://localhost:8081/"+fileName);
            String imagepath=biaopath.getPath();
            billpath=imagepath;
            billMapper.addPath(imagepath);
            return path+fileName;
        }else {
            return "error";
        }

    }

    public String show(){
        return null;
    }

    public int updateBill(billInfo bill) {
        return billMapper.updateBill(currentUserController.account,bill.getEename(),bill.getBillname(),bill.getMoney(),bill.getBilltime(),bill.getFlaw(),bill.getWant(),bill.getEndorse(),billpath);
    }
}
