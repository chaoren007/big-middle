package com.morning.star.retail.export.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.morning.star.retail.base.poi.ExcelUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.UUID;

/**
 * @Author: kimhuhg
 * @Date: 18-11-12 上午9:49
 * @desc: 统一导出工具类
 */
@Component(value = "ExportUtil")
public class ExportUtil<T> {
    private Logger log = LoggerFactory.getLogger(ExportUtil.class);

    @Value("${cdn.url}")
    private String cdnUrl;

    @Value("${qiniu.url}")
    private String qiniuUrl;

    @Value("${qiniu.access.key}")
    private String accessKey;

    @Value("${qiniu.secret.key}")
    private String secretKey;

    @Value("${qiniu.secret.bucketName}")
    private String bucketName;

    // 密钥配置
    // 创建上传对象
    private UploadManager uploadManager = new UploadManager();

    public String export(Class<T> clazz,List<T> list, String sheetName) {
        String filename = UUID.randomUUID().toString() + ".xlsx";
        ByteArrayOutputStream os = new ExcelUtil<>(clazz).writeToFileStream(list, filename, sheetName);
        byte[] bytes = os.toByteArray();
        return upload(bytes);
    }

    private String upload(byte[] file) {
        try {
            String key = UUID.randomUUID().toString() + "." + "xlsx";
            Auth auth = Auth.create(accessKey, secretKey);
            Response res = uploadManager.put(file, key, auth.uploadToken(bucketName));
            log.info("excel导出上传成功！");
            JSONObject object = JSON.parseObject(res.bodyString());
            if (object == null) {
                return null;
            }
            return cdnUrl + object.getString("key"); // key就是前面我们自己指定的上传后文件名
        } catch (QiniuException e) {
            throw new RuntimeException("上传导出excel文件异常", e);
        }
    }

}
