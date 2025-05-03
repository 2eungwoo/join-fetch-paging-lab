package lab.jpa_join_fetch_paging.post.domain.repository;

import lab.jpa_join_fetch_paging.post.domain.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
