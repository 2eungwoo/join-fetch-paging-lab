package lab.jpa_join_fetch_paging.post.domain.dto;

import lab.jpa_join_fetch_paging.post.domain.entity.PostEntity;
import lab.jpa_join_fetch_paging.reply.domain.dto.ReplyDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class PostDto {

    @Builder
    @Getter
    public static class Request{
        private String title;
        private String content;

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
        private final Long id;
        private final String title;
        private final String content;
        private final List<ReplyDto.Response> replies;

        public Response(PostEntity postEntity){
            this.id = postEntity.getId();
            this.title = postEntity.getTitle();
            this.content = postEntity.getContent();
            this.replies = postEntity.getReplies() == null ? null :
                    postEntity.getReplies().stream()
                            .map(ReplyDto.Response::new)
                            .collect(Collectors.toList());

        }
    }
}







