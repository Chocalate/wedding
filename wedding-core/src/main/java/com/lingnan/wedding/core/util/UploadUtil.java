package com.lingnan.wedding.core.util;

import com.lingnan.wedding.core.vo.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.UUID;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-04-13 12:39
 **/
@Component
public class UploadUtil {

    /**
     * 项目端口
     */
    @Value("${server.port}")
    public String port;

    /**
     * 项目路径
     */
    @Value("${server.servlet.context-path}")
    public String contextPath;

    /**
     * 上传文件
     *
     * @param multipartFile 文件对象
     * @param dir 上传目录
     * @return
     */
    public Response uploadFile(MultipartFile multipartFile) {


        try {
            if (multipartFile.isEmpty()) {
                return Response.error("请选择文件");
            }
            // 获取文件的名称
            String originalFilename = multipartFile.getOriginalFilename();
            // 文件后缀 例如：.png
            String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            // uuid 生成文件名
            String uuid = String.valueOf(UUID.randomUUID());
            // 根路径，在 resources/static/upload
            String basePath = ResourceUtils.getURL("classpath:").getPath() + "static/imgs/goodsInfo/";
            // 新的文件名，使用uuid生成文件名
            String fileName = uuid + fileSuffix;
            // 获取文件对象
            File file = new File(basePath, fileName);
            // 完成文件的上传
            multipartFile.transferTo(file);
            // 返回绝对路径
            return Response.success("http://" + InetAddress.getLocalHost().getHostAddress() + ":" + port + contextPath + "/imgs/goodsInfo/" + fileName);
        } catch (Exception e) {


            e.printStackTrace();
        }
        return Response.error("上传失败");
    }

}
