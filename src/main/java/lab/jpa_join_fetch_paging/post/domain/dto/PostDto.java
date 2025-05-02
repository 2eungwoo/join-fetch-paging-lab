package lab.jpa_join_fetch_paging.post.domain.dto;

import lab.jpa_join_fetch_paging.post.domain.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;

public class PostDto {

    @Builder
    @Getter
    public static class Request{
        private String title;
        private String content;
        // private Reply list

        public PostEntity toEntity(){
            return PostEntity.builder()
                    .title(title)
                    .content(content)
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Response{
        private Long id;
        private String title;
        private String content;
        // priavet Reply list

        public Response(PostEntity postEntity){
            this.id = postEntity.getId();
            this.title = postEntity.getTitle();
            this.content = postEntity.getContent();
        }
    }
}







