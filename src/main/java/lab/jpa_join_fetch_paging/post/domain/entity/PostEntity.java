package lab.jpa_join_fetch_paging.post.domain.entity;

import jakarta.persistence.*;
import lab.jpa_join_fetch_paging.reply.domain.entity.ReplyEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @OneToMany(mappedBy = "post")
    private List<ReplyEntity> replies;

    @Builder
    public PostEntity(String title, String content) {
        this.title = title;
        this.content = content;
        this.replies = null;
    }

    public void addReply(ReplyEntity replyEntity) {
        if (replies == null) {
            replies = new ArrayList<>();
        }
        replies.add(replyEntity);
    }
}


