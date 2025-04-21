package com.zhengchalei.sora.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 {
     "id": "media_01js7fe94bfwvbp7ntdzdzja33",
     "type": "image",
     "created_at": "2025-04-19T16:52:21.764130Z",
     "filename": "images.jpg",
     "extension": "jpeg",
     "mime_type": "image/jpeg",
     "url": "https://videos.openai.com/vg-assets/assets%2Fclient_upload%2Fmedia%2Fuser-nhuvMuKN0OJDCUGna1fF5hLn%2Fmedia_01js7fe94bfwvbp7ntdzdzja33.jpeg?st=2025-04-19T15%3A07%3A03Z&se=2025-04-25T16%3A07%3A03Z&sks=b&skt=2025-04-19T15%3A07%3A03Z&ske=2025-04-25T16%3A07%3A03Z&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skoid=aa5ddad1-c91a-4f0a-9aca-e20682cc8969&skv=2019-02-02&sv=2018-11-09&sr=b&sp=r&spr=https%2Chttp&sig=yzE4Vlg%2BkCsxnco1fywtgEWbZGf6c3PB%2FWc1oIa7Vrw%3D&az=oaivgprodscus",
     "width": 678,
     "height": 452,
     "duration_sec": null,
     "n_frames": 1,
     "size_bytes": 54022,
     "thumbnail_url": "https://videos.openai.com/vg-assets/assets%2Fclient_upload%2Fmedia%2Fuser-nhuvMuKN0OJDCUGna1fF5hLn%2Fmedia_01js7fe94bfwvbp7ntdzdzja33.jpg?st=2025-04-19T15%3A07%3A03Z&se=2025-04-25T16%3A07%3A03Z&sks=b&skt=2025-04-19T15%3A07%3A03Z&ske=2025-04-25T16%3A07%3A03Z&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skoid=aa5ddad1-c91a-4f0a-9aca-e20682cc8969&skv=2019-02-02&sv=2018-11-09&sr=b&sp=r&spr=https%2Chttp&sig=vlKGZOhjbVgBrkfjCbehPBbYb6lZwEStcjqWAKyisns%3D&az=oaivgprodscus"
 }
 */
@Data
public class SoraUploadOutput {

    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("filename")
    private String filename;

    @JsonProperty("extension")
    private String extension;

    @JsonProperty("mime_type")
    private String mimeType;

    @JsonProperty("url")
    private String url;

    @JsonProperty("width")
    private Integer width;

    @JsonProperty("height")
    private Integer height;

    @JsonProperty("duration_sec")
    private Integer durationSec;

    @JsonProperty("n_frames")
    private Integer nFrames;

    @JsonProperty("size_bytes")
    private Long sizeBytes;

    @JsonProperty("thumbnail_url")
    private String thumbnailUrl;
}
