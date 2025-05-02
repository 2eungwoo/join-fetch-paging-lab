package lab.jpa_join_fetch_paging.reply.domain.dto;

import lab.jpa_join_fetch_paging.reply.domain.ReplyEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReplyDto {

    @Getter
    @Builder
    static class Request {

        private String content;

        public ReplyEntity(){
            return ReplyEntity.builder()
                    .content(content)
                    .build();
        }
    }

    static class Response {
        private Long id;
        private String content;


    }
}
