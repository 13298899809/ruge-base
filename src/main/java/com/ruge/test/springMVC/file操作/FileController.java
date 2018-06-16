package com.ruge.test.springMVC.file操作;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * @author 爱丽丝、如歌
 * @Description: TODO
 * @date 2018/5/11 13:15
 */
@Controller
@RequestMapping(value = "springmvc")
public class FileController {
    @RequestMapping(value = "fileInit.do")
    public String init(){
        return "file操作/fileInit";
    }

    /**
     * 文件单个上传
     * @return
     */
    @RequestMapping(value = "fileUpload.do")
    public String fileUpload(@RequestParam("name")String name,
                             @RequestParam("image") MultipartFile file) throws IOException {
        System.out.println("file.getBytes():"+file.getBytes());
        System.out.println("file.getName():"+file.getName());
        System.out.println("file.getContentType():"+file.getContentType());
        System.out.println("file.getInputStream():"+file.getInputStream());
        System.out.println("file.getOriginalFilename():"+file.getOriginalFilename());
        System.out.println("file.getSize():"+file.getSize());
        String path = "d:/"+file.getOriginalFilename();
        String filename = file.getOriginalFilename();
      //  file.transferTo(new File(path + File.separator + filename));
        File destFile = new File(path);
        FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);// 复制临时文件到指定目录下
        return "file操作/fileInit";
    }
    /**
     * 文件多个上传
     * @return
     */
    @RequestMapping(value = "fileUploads.do")
    @ResponseBody
    public String fileUploads(@RequestParam("name")String name,@RequestParam("image") CommonsMultipartFile[] files) throws IOException {
        for (int i = 0; i <files.length ; i++) {
            String path = "d:/"+files[i].getOriginalFilename();
            File destFile = new File(path);
            FileUtils.copyInputStreamToFile(files[i].getInputStream(), destFile);// 复制临时文件到指定目录下
        }
        return "file操作/fileInit";
    }
    @RequestMapping(value = "fileDownload.do")
    public void fileDownload(FileModel model){
        System.out.println(model);
    }
}
