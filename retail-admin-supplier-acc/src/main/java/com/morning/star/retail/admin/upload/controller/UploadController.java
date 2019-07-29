package com.morning.star.retail.admin.upload.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Api(tags = "图片上传接口")
@RestController
@RequestMapping("/api")
public class UploadController extends AdminController {
    private Logger logger = LoggerFactory.getLogger(UploadController.class);

    @Value("${cdn.url}")
    private String cdnUrl;
    @Value("${qiniu.url}")
    private String qiniuUrl;
    @Value("Rd5XKj0cEcETJUB_mc2mmCa20EL9Jeee6yQ4OEKu")
    private String accessKey;
    @Value("${qiniu.secret.key}")
    private String secretKey;
    @Value("${qiniu.secret.bucketName}")
    private String bucketName;

    // 密钥配置
    // 创建上传对象
    private UploadManager uploadManager = new UploadManager();

    @ApiOperation(value = "上传图片")
    @RequestMapping(value = "/upload/img", method = RequestMethod.POST)
    public WebBean<String> uploadImg(@RequestParam MultipartFile file) {
        String filePath = saveImg(file);
        Validate.notEmpty(filePath, "上传图片失败");
        return WebBean.ok(cdnUrl + filePath);
    }

    @ApiOperation(value = "批量上传图片")
    @RequestMapping(value = "/upload/imgs", method = RequestMethod.POST)
    public WebBean<List<String>> uploadImgs(@RequestParam MultipartFile[] files) {
        List<String> result = new ArrayList<String>();
        for (MultipartFile file : files) {
            if (file != null) {
                String path = saveImg(file);
                Validate.notEmpty(path, "上传图片失败");
                result.add(cdnUrl + path);
            }
        }
        return WebBean.ok(result);
    }

    private String saveImg(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        byte[] bytes = null;
        try {
            bytes = file.getBytes();
        } catch (IOException e) {
            throw new RuntimeException("上传图片异常", e);
        }
        logger.info("upload file " + originalFilename + ", size " + bytes.length);
        return upload(bytes, originalFilename.split("\\.")[1]);
    }

    private String upload(byte[] file, String suffixStr) {
        try {
            String key = UUID.randomUUID().toString() + "." + suffixStr;
            Auth auth = Auth.create(accessKey, secretKey);
            Response res = uploadManager.put(file, key, auth.uploadToken(bucketName));

            JSONObject object = JSON.parseObject(res.bodyString());
            if (object == null) {
                return null;
            }
            return object.getString("key"); // key就是前面我们自己指定的上传后文件名
        } catch (QiniuException e) {
            logger.error("qiniu upload fail", e);
            return null;
        }
    }
}
