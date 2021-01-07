package com.example.excelpoi;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author: yuanxianwei
 */
@RestController
public class ExcelController {

    @PostMapping("/getExcel")
    public void getExcel(MultipartFile myfile) {

        try {

            List<Object> userListByExcel = ExcelUtil.getUserListByExcel(myfile.getInputStream(), myfile.getOriginalFilename());
            for (int i = 0; i < userListByExcel.size(); i++) {
                Object objects = userListByExcel.get(i);
                System.out.println(objects.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
