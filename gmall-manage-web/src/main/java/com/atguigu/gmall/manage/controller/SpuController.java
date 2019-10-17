package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsProductInfo;
import com.atguigu.gmall.manage.util.PmsUploadUtil;
import com.atguigu.gmall.service.SpuService;
import org.apache.tomcat.jni.Multicast;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@CrossOrigin
public class SpuController {
    @Reference
    SpuService spuService;

    @RequestMapping("foleUpload")
    @ResponseBody
    public String foleUpload(@RequestParam("file")MultipartFile multipartFile){
    String imgUrl= PmsUploadUtil.uploadImage(multipartFile);
        System.out.println(imgUrl);
    return imgUrl;
    }
    @RequestMapping("saveSpuInfo")
    @ResponseBody
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){

        return "success";
    }
    @RequestMapping("spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String catalog3Id){
        List<PmsProductInfo> pmsProductInfos=spuService.spuList(catalog3Id);
        return pmsProductInfos;
    }
}
