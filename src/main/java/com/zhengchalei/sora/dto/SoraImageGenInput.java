package com.zhengchalei.sora.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.util.List;


/**
 * Sora 图片生成输入参数
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SoraImageGenInput {

    // 快速构建， 输入 prompt + upload_media_id
    public static SoraImageGenInput fastBuild(String prompt, String uploadMediaId) {
        SoraImageGenInput soraImageGenInput = new SoraImageGenInput();
        soraImageGenInput.prompt = prompt;

        InpaintItem inpaintItem = new InpaintItem();
        inpaintItem.setUploadMediaId(uploadMediaId);
        soraImageGenInput.inpaintItems = List.of(inpaintItem);
        return soraImageGenInput;
    }

    @SneakyThrows
    public static String fastBuildToJson(String prompt, String uploadMediaId) {
        SoraImageGenInput soraImageGenInput = fastBuild(prompt, uploadMediaId);
        return new ObjectMapper().writeValueAsString(soraImageGenInput);
    }

    /**
     * 提示词
     */
    @JsonProperty("prompt")
    private String prompt;

    /**
     * 图片宽度
     */
    @JsonProperty("width")
    private Integer width = 480;

    /**
     * 图片高度
     */
    @JsonProperty("height")
    private Integer height = 720;

    /**
     * 生成变体数量
     */
    @JsonProperty("n_variants")
    private Integer nVariants = 1;

    /**
     * 绘制项目列表
     */
    @JsonProperty("inpaint_items")
    private List<InpaintItem> inpaintItems;

    /**
     * 操作类型
     */
    @JsonProperty("operation")
    private String operation = "remix";

    /**
     * 生成类型
     */
    @JsonProperty("type")
    private String type = "image_gen";

    /**
     * 帧数
     */
    @JsonProperty("n_frames")
    private Integer nFrames = 1;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InpaintItem {

        @JsonProperty("type")
        private String type = "image";

        @JsonProperty("frame_index")
        private Integer frameIndex = 0;

        @JsonProperty("preset_id")
        private String presetId = null;

        @JsonProperty("generation_id")
        private String generationId = null;

        @JsonProperty("upload_media_id")
        private String uploadMediaId = null;

        @JsonProperty("source_start_frame")
        private Integer sourceStartFrame = 0;

        @JsonProperty("source_end_frame")
        private Integer sourceEndFrame = 0;

        @JsonProperty("crop_bounds")
        private Object cropBounds = null;
    }
}
