package com.zhengchalei.sora.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhengchalei.sora.dto.SoraImageGenInput;
import com.zhengchalei.sora.dto.SoraImageGenOutput;
import com.zhengchalei.sora.dto.SoraImageTaskOutput;
import com.zhengchalei.sora.dto.SoraUploadOutput;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Slf4j
@Service
public class SoraService {

    @Value("${sora.authorization}")
    private String authorization;

    @Value("${sora.cookie}")
    private String cookie;

    public SoraImageGenOutput generator(MultipartFile file, String prompt) {
        SoraUploadOutput soraUploadOutput = uploadToSora(file);
        return soraImageGen(prompt, soraUploadOutput.getId());
    }


    @SneakyThrows
    private SoraUploadOutput uploadToSora(MultipartFile file) {
        final String fileName = file.getOriginalFilename() == null ? file.getOriginalFilename() : UUID.randomUUID() + ".jpg";
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file", fileName,
                        RequestBody.create(
                                MediaType.parse("image/jpeg"),
                                file.getBytes()
                        )
                )
                .addFormDataPart("file_name", fileName)
                .build();
        Request request = new Request.Builder()
                .url("https://sora.chatgpt.com/backend/uploads")
                .method("POST", body)
                .addHeader("authorization", authorization)
                .addHeader("Cookie", cookie)
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            ResponseBody resultBody = response.body();
            SoraUploadOutput soraUploadOutput = new ObjectMapper().readValue(resultBody.string(), SoraUploadOutput.class);
            log.info("上传文件到 Sora 成功: {}", soraUploadOutput);
            return soraUploadOutput;
        }
        log.error("上传文件到 Sora 失败: {}", response);
        throw new RuntimeException("上传文件到 Sora 失败");
    }

    @SneakyThrows
    public SoraImageGenOutput soraImageGen(String prompt, String uploadMediaId) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, SoraImageGenInput.fastBuildToJson(prompt, uploadMediaId));
        Request request = new Request.Builder()
                .url("https://sora.chatgpt.com/backend/video_gen")
                .method("POST", body)
                .addHeader("authorization", authorization)
                .addHeader("Cookie", cookie)
                .build();

        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            ResponseBody resultBody = response.body();
            SoraImageGenOutput soraImageGenOutput = new ObjectMapper().readValue(resultBody.string(), SoraImageGenOutput.class);
            log.info("生成吉卜力风格图片成功: {}", soraImageGenOutput);
            return soraImageGenOutput;
        }

        log.error("生成吉卜力风格图片失败: {}", response);
        throw new RuntimeException("生成吉卜力风格图片失败");
    }

    @SneakyThrows
    public SoraImageTaskOutput getResult(String taskId) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://sora.chatgpt.com/backend/video_gen/" + taskId)
                .method("GET", null)
                // 这里也可以使用 getUserInfo 中的 token， 维护 cookie 就可以了。
                .addHeader("authorization", authorization)
                .addHeader("Cookie", cookie)
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            ResponseBody resultBody = response.body();
            // 获取结果
            SoraImageTaskOutput soraImageTaskOutput = new ObjectMapper().readValue(resultBody.string(), SoraImageTaskOutput.class);
            log.info("图片生成成功: {}", soraImageTaskOutput);
            return soraImageTaskOutput;
        }
        log.error("图片获取失败: {}", response);
        throw new RuntimeException("图片生成失败");
    }

}
