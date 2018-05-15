package com.ruge.test.springMVC.file操作;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
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
                             @RequestParam("image") MultipartFile image){
        return "file操作/fileInit";
    }
    /**
     * 文件多个上传
     * @return
     */
    @RequestMapping(value = "fileUploads.do")
    @ResponseBody
    public String fileUploads(@Validated  FileModel users, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "file操作/fileInit";
    }
    @RequestMapping(value = "fileDownload.do")
    public void fileDownload(FileModel model){
        System.out.println(model);
    }
}
