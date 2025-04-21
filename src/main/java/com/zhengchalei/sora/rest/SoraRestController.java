package com.zhengchalei.sora.rest;

import com.zhengchalei.sora.dto.SoraImageGenOutput;
import com.zhengchalei.sora.dto.SoraImageTaskOutput;
import com.zhengchalei.sora.service.SoraService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/sora")
class SoraRestController {

    private final SoraService soraService;

    SoraRestController(SoraService soraService) {
        this.soraService = soraService;
    }

    // 上传文件
    @PostMapping("/generator")
    public String generator(@RequestParam("file") MultipartFile file, @RequestParam("prompt") String prompt) {
        SoraImageGenOutput soraImageGenOutput = soraService.generator(file, prompt);
        return soraImageGenOutput.getId();
    }

    // 获取结果
    @GetMapping("/result/{id}")
    public SoraImageTaskOutput getResult(@PathVariable("id") String taskId) {
        return soraService.getResult(taskId);
    }

}
