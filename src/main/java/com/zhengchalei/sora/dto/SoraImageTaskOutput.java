package com.zhengchalei.sora.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class SoraImageTaskOutput {
    private String id;
    private String user;

    @JsonProperty("created_at")
    private String createdAt;

    private String status;

    @JsonProperty("progress_pct")
    private Double progressPct;

    @JsonProperty("progress_pos_in_queue")
    private Integer progressPosInQueue;

    @JsonProperty("estimated_queue_wait_time")
    private Integer estimatedQueueWaitTime;

    @JsonProperty("queue_status_message")
    private String queueStatusMessage;

    private Integer priority;
    private String type;
    private String prompt;

    @JsonProperty("n_variants")
    private Integer nVariants;

    @JsonProperty("n_frames")
    private Integer nFrames;

    private Integer height;
    private Integer width;
    private String model;
    private String operation;

    @JsonProperty("inpaint_items")
    private List<InpaintItem> inpaintItems;

    @JsonProperty("preset_id")
    private String presetId;

    private String caption;
    private String actions;
    private String interpolation;
    private String sdedit;

    @JsonProperty("remix_config")
    private String remixConfig;

    private String quality;
    private List<Generation> generations;

    @JsonProperty("num_unsafe_generations")
    private Integer numUnsafeGenerations;

    private String title;

    @JsonProperty("moderation_result")
    private ModerationResult moderationResult;

    @JsonProperty("failure_reason")
    private String failureReason;

    @JsonProperty("needs_user_review")
    private Boolean needsUserReview;

    @Data
    public static class InpaintItem {
        @JsonProperty("crop_bounds")
        private String cropBounds;
        private String type;
        @JsonProperty("preset_id")
        private String presetId;
        @JsonProperty("generation_id")
        private String generationId;
        @JsonProperty("upload_media_id")
        private String uploadMediaId;
        @JsonProperty("frame_index")
        private Integer frameIndex;
        @JsonProperty("source_start_frame")
        private Integer sourceStartFrame;
        @JsonProperty("source_end_frame")
        private Integer sourceEndFrame;
    }

    @Data
    public static class Generation {
        private String id;
        @JsonProperty("task_id")
        private String taskId;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("deleted_at")
        private String deletedAt;
        private String url;
        private Integer seed;
        @JsonProperty("can_download")
        private Boolean canDownload;
        @JsonProperty("download_status")
        private String downloadStatus;
        @JsonProperty("is_favorite")
        private Boolean isFavorite;
        @JsonProperty("is_liked")
        private Boolean isLiked;
        @JsonProperty("is_public")
        private Boolean isPublic;
        @JsonProperty("is_archived")
        private Boolean isArchived;
        @JsonProperty("is_featured")
        private Boolean isFeatured;
        @JsonProperty("featured_countries")
        private List<String> featuredCountries;
        @JsonProperty("has_feedback")
        private Boolean hasFeedback;
        @JsonProperty("like_count")
        private Integer likeCount;
        @JsonProperty("cloudflare_metadata")
        private String cloudflareMetadata;
        @JsonProperty("cf_thumbnail_url")
        private String cfThumbnailUrl;
        private Encodings encodings;
        private Integer width;
        private Integer height;
        @JsonProperty("n_frames")
        private Integer nFrames;
        private String prompt;
        private String title;
        private String actions;
        @JsonProperty("inpaint_items")
        private List<InpaintItem> inpaintItems;
        private String interpolation;
        private String sdedit;
        private String operation;
        private String model;
        @JsonProperty("preset_id")
        private String presetId;
        private User user;
        @JsonProperty("moderation_result")
        private ModerationResult moderationResult;
        @JsonProperty("paragen_status")
        private String paragenStatus;
        @JsonProperty("task_type")
        private String taskType;
        @JsonProperty("remix_config")
        private String remixConfig;
        private String quality;
    }

    @Data
    public static class Encodings {
        private EncodingDetail source;
        private EncodingDetail md;
        private EncodingDetail ld;
        private EncodingDetail thumbnail;
        private String spritesheet;
    }

    @Data
    public static class EncodingDetail {
        private String path;
        private Integer size;
        private Integer width;
        private Integer height;
        @JsonProperty("duration_secs")
        private Integer durationSecs;
        private String ssim;
    }

    @Data
    public static class User {
        private String id;
        private String username;
    }

    @Data
    public static class ModerationResult {
        private String type;
        @JsonProperty("results_by_frame_index")
        private Map<String, Object> resultsByFrameIndex;
        private String code;
        @JsonProperty("is_output_rejection")
        private Boolean isOutputRejection;
        @JsonProperty("task_id")
        private String taskId;
    }
}