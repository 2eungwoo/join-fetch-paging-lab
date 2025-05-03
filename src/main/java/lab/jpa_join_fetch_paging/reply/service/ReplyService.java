package lab.jpa_join_fetch_paging.reply.service;

import lab.jpa_join_fetch_paging.common.util.finder.EntityFinder;
import lab.jpa_join_fetch_paging.post.domain.entity.PostEntity;
import lab.jpa_join_fetch_paging.post.domain.repository.PostRepository;
import lab.jpa_join_fetch_paging.reply.domain.dto.ReplyDto;
import lab.jpa_join_fetch_paging.reply.domain.entity.ReplyEntity;
import lab.jpa_join_fetch_paging.reply.domain.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final EntityFinder<PostEntity, Long> postFinder;


    //@Transactional(readOnly = true)

    @Transactional
    public ReplyDto.Response createReply(Long postId, ReplyDto.Request replyRequestDto){
        ReplyEntity replyEntity = ReplyEntity.builder()
                .postEntity(postFinder.findByIdOrThrow(postId))
                .content(replyRequestDto.getContent())
                .build();

        replyRepository.save(replyEntity);
        return new ReplyDto.Response(replyEntity);
    }
}
