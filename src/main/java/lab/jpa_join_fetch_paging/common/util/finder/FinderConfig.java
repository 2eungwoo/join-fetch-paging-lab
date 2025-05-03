package lab.jpa_join_fetch_paging.common.util.finder;

import lab.jpa_join_fetch_paging.post.domain.entity.PostEntity;
import lab.jpa_join_fetch_paging.post.domain.repository.PostRepository;
import lab.jpa_join_fetch_paging.reply.domain.entity.ReplyEntity;
import lab.jpa_join_fetch_paging.reply.domain.repository.ReplyRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FinderConfig {

    @Bean
    public EntityFinder<PostEntity, Long> postFinder(PostRepository postRepository) {
        return new JpaEntityFinder<>(postRepository, "Post");
    }

    @Bean
    public EntityFinder<ReplyEntity, Long> replyFinder(ReplyRepository replyRepository) {
        return new JpaEntityFinder<>(replyRepository, "Reply");
    }

    // 기타 등등
}