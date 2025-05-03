package lab.jpa_join_fetch_paging.reply.domain.repository;

import lab.jpa_join_fetch_paging.reply.domain.entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {
}
