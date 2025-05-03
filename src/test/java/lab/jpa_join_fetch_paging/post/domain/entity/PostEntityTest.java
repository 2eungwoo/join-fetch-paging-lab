package lab.jpa_join_fetch_paging.post.domain.entity;

import lab.jpa_join_fetch_paging.reply.domain.entity.ReplyEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("h2")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//        connection = EmbeddedDatabaseConnection.H2)
class PostEntityTest {

    @Autowired
    private TestEntityManager entityManager;

    private PostEntity post;

    @BeforeEach
    void setUp() {
        post = PostEntity.builder()
                .title("Test Post")
                .content("Test Content")
                .build();

        entityManager.persistAndFlush(post);
        entityManager.clear();
    }
    @Test
    void addReply_메소드_테스트() {
        // given
        ReplyEntity reply1 = ReplyEntity.builder()
                .content("Test Reply 1")
                .postEntity(post)
                .build();

        ReplyEntity reply2 = ReplyEntity.builder()
                .content("Test Reply 2")
                .postEntity(post)
                .build();

        // when
        post.addReply(reply1);
        post.addReply(reply2);

        entityManager.persist(reply1);
        entityManager.persist(reply2);
        entityManager.flush();
        entityManager.clear();

        // then
        PostEntity foundPost = entityManager.find(PostEntity.class, post.getId());

        assertThat(foundPost.getReplies()).hasSize(2);
        assertThat(foundPost.getReplies().get(0).getContent()).isEqualTo("Test Reply 1");
        assertThat(foundPost.getReplies().get(1).getContent()).isEqualTo("Test Reply 2");
    }
}