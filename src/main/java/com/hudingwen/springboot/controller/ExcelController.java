package com.hudingwen.springboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * ClassName:ExcelController
 * Package:com.hudingwen.springboot.controller
 * Description:描述
 *
 * @Date:2023/1/7 10:51
 * @Author:胡丁文
 * @E-mail:admin@aiwanyun.cn
 **/
@Tag( name = "Excel操作")
@RestController
@RequestMapping("/api/excel")
@Slf4j
public class ExcelController {
    @Operation(summary = "下载excel")
    @GetMapping("/download")
    public String fileDownLoad(HttpServletResponse response){
        File file = new File("C:\\Users\\hudin\\Desktop\\原始记录单.xlsx");
        if(!file.exists()){
            log.info("下载文件不存在");
            return "下载文件不存在";
        }
        response.reset();
        // 此处 setHeader、addHeader 方法都可用。但 addHeader时写多个会报错：“...,but only one is allowed”
        response.setHeader("Access-Control-Allow-Origin", "*");
        //response.addHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
        // 解决预请求（发送2次请求），此问题也可在 nginx 中作相似设置解决。
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Cache-Control,Pragma,Content-Type,Token, Content-Type");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment;filename=" + "test.xlsx" );

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));) {
            byte[] buff = new byte[1024];
            OutputStream os  = response.getOutputStream();
            int i = 0;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {

            log.info("下载失败");
            log.error("{}",e);
            return "下载失败";
        }
        log.info("下载成功");
        return "下载成功";
    }
    @Operation(summary = "下载exceljson")
    @RequestMapping("/downloadJson")
    public String fileDownLoadJson(HttpServletResponse response){
        File file = new File("C:\\Users\\hudin\\Desktop\\原始记录单.txt");
        if(!file.exists()){
            log.info("下载文件不存在");
            return "下载文件不存在";
        }
        response.reset();
        // 此处 setHeader、addHeader 方法都可用。但 addHeader时写多个会报错：“...,but only one is allowed”
        response.setHeader("Access-Control-Allow-Origin", "*");
        //response.addHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
        // 解决预请求（发送2次请求），此问题也可在 nginx 中作相似设置解决。
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Cache-Control,Pragma,Content-Type,Token, Content-Type");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment;filename=" + "test.txt" );

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));) {
            byte[] buff = new byte[1024];
            OutputStream os  = response.getOutputStream();
            int i = 0;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {

            log.info("下载失败");
            log.error("{}",e);
            return "下载失败";
        }
        log.info("下载成功");
        return "下载成功";
    }

    @Operation(summary = "上传excel")
    @PostMapping("/upload")
    public String fileUpload(HttpServletResponse response,@RequestParam("files") MultipartFile files[]){

        response.setHeader("Access-Control-Allow-Origin", "*");
        //response.addHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
        // 解决预请求（发送2次请求），此问题也可在 nginx 中作相似设置解决。
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Cache-Control,Pragma,Content-Type,Token, Content-Type");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        for(int i=0;i<files.length;i++){
            String fileName = files[i].getOriginalFilename();  // 文件名
            File dest = new File("C:\\Users\\hudin\\Desktop\\test.xlsx");
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                files[i].transferTo(dest);
            } catch (Exception e) {
                log.error("上传出错");
                log.error("{}",e);
                return "上传出错";
            }
        }
        return "上传成功";
    }

}
