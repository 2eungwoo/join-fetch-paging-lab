package lab.jpa_join_fetch_paging.reply.service;

import lab.jpa_join_fetch_paging.common.util.finder.EntityFinder;
import lab.jpa_join_fetch_paging.post.domain.entity.PostEntity;
import lab.jpa_join_fetch_paging.reply.domain.dto.ReplyDto;
import lab.jpa_join_fetch_paging.reply.domain.entity.ReplyEntity;
import lab.jpa_join_fetch_paging.reply.domain.repository.ReplyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReplyServiceTest {

    @Mock
    private ReplyRepository replyRepository;

    @Mock
    private EntityFinder<PostEntity, Long> postFinder;

    @InjectMocks
    private ReplyService replyService;

    private PostEntity postEntity;
    private ReplyEntity replyEntity;

    @BeforeEach
    void setUp() {
        postEntity = PostEntity.builder()
                .title("Test Post")
                .content("Test Content")
                .build();

        replyEntity = ReplyEntity.builder()
                .content("Reply Content 1")
                .postEntity(postEntity)
                .build();
    }

    @Test
    void createReply() {
        // given
        Long postId = 1L;
        ReplyDto.Request replyRequestDto = ReplyDto.Request.builder()
                .content(replyEntity.getContent())
                .build();

        when(postFinder.findByIdOrThrow(postId)).thenReturn(postEntity);
        when(replyRepository.save(any(ReplyEntity.class))).thenReturn(replyEntity);

        // when
        ReplyDto.Response replyResponseDto = replyService.createReply(postId, replyRequestDto);

        // then
        assertThat(replyResponseDto.getContent()).isEqualTo(replyResponseDto.getContent());
        verify(replyRepository, times(1)).save(any(ReplyEntity.class));
    }
}