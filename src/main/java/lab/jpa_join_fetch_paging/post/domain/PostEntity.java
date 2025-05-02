package lab.jpa_join_fetch_paging.post.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

//    @OneToMany(mappedBy = "post")
//    private List<Reply> replies;


    @Builder
    public PostEntity(String title, String content) {
        this.title = title;
        this.content = content;
        // this.replies = null;
    }

//    public void addReply(Reply reply) {
//        if (replies == null) {
//            replies = new ArrayList<>();
//        }
//        replies.add(reply);
//    }
}


