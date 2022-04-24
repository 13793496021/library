package com.libraryms.controller;


import com.libraryms.result.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UploadController {
    @RequestMapping("api/upload")
    public Map<String, Object> upload(MultipartFile file) throws IOException {
        Map<String, Object> map = new HashMap<>();
        if (file != null) {  //如果获取到的文件不为空
            String filename = file.getOriginalFilename();
            String pathname = "/F:/IdeaProjects/library/src/assets";
            File file_server = new File(pathname, filename);  //创建文件对象
            if (!file_server.getParentFile().exists()) {
                //如果文件父目录不存在，就创建这样一个目录
                file_server.getParentFile().mkdirs();
                System.out.println("创建目录" + file);
            } else {  //如果父文件夹已经存在

            }
            file.transferTo(file_server);
            map.put("status", true);
            map.put("msg", "上传文件成功");
        } else {   //如果获取到的文件为空
            map.put("status", false);
            map.put("msg", "上传文件失败");
            map.put("reason", "文件为空");
        }
        return map;
    }

}
