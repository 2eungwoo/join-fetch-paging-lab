package lab.jpa_join_fetch_paging.reply.domain.dto;

import lab.jpa_join_fetch_paging.reply.domain.entity.ReplyEntity;

import lombok.Builder;
import lombok.Getter;

public class ReplyDto {

    @Getter
    @Builder
    public static class Request {

        private String content;

        public ReplyEntity toEntity(){
            return ReplyEntity.builder()
                    .content(content)
                    .build();
        }
    }

    @Getter
    public static class Response {
        private final Long id;
        private final String content;

        public Response(ReplyEntity replyEntity) {
            this.id = replyEntity.getId();
            this.content = replyEntity.getContent();
        }
    }
}
