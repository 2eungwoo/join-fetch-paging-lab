package lab.jpa_join_fetch_paging.reply.domain.entity;

import jakarta.persistence.*;
import lab.jpa_join_fetch_paging.post.domain.entity.PostEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;

    @Builder
    public ReplyEntity(String content, PostEntity postEntity) {
        this.content = content;
        this.post = postEntity;
    }
}