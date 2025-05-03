package lab.jpa_join_fetch_paging.post.service;

import lab.jpa_join_fetch_paging.common.util.finder.EntityFinder;
import lab.jpa_join_fetch_paging.post.domain.dto.PostDto;
import lab.jpa_join_fetch_paging.post.domain.entity.PostEntity;
import lab.jpa_join_fetch_paging.post.domain.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @Mock
    private EntityFinder<PostEntity, Long> postFinder;

    @InjectMocks
    private PostService postService;

    private PostEntity postEntity;
    private PostEntity postEntity2;

    @BeforeEach
    void setUp() {
        postEntity = PostEntity.builder()
                .title("Test Post")
                .content("Test Content")
                .build();

        postEntity2 = PostEntity.builder()
                .title("Test Post 2")
                .content("Test Content 2")
                .build();

    }

    @Test
    void createPost() {
        // given
        PostDto.Request postRequestDto = PostDto.Request.builder()
                .title("Test Post")
                .content("Test Content")
                .build();

        when(postRepository.save(any(PostEntity.class))).thenReturn(postEntity);

        // when
        PostDto.Response postResponseDto = postService.createPost(postRequestDto);

        // then
        assertThat(postResponseDto.getId()).isEqualTo(postEntity.getId());
        assertThat(postResponseDto.getTitle()).isEqualTo(postEntity.getTitle());
        assertThat(postResponseDto.getContent()).isEqualTo(postEntity.getContent());

        verify(postRepository, times(1)).save(any(PostEntity.class));
    }

    @Test
    void getPostById() {
        // given
        Long postId = 1L;
        when(postFinder.findByIdOrThrow(postId)).thenReturn(postEntity);

        // when
        PostDto.Response postResponseDto = postService.getPostById(postId);

        // then
        assertThat(postResponseDto.getId()).isEqualTo(postEntity.getId());
        assertThat(postResponseDto.getTitle()).isEqualTo(postEntity.getTitle());
        assertThat(postResponseDto.getContent()).isEqualTo(postEntity.getContent());

        verify(postFinder, times(1)).findByIdOrThrow(postId);
    }

    @Test
    void getAllPosts() {
        // given
        when(postRepository.findAll()).thenReturn(Arrays.asList(postEntity, postEntity2));

        // when
        List<PostDto.Response> postResponses = postService.getAllPosts();

        // then
        assertThat(postResponses.size()).isEqualTo(2);

        PostDto.Response postResponse1 = postResponses.get(0);
        assertThat(postResponse1.getId()).isEqualTo(postEntity.getId());
        assertThat(postResponse1.getTitle()).isEqualTo(postEntity.getTitle());
        assertThat(postResponse1.getContent()).isEqualTo(postEntity.getContent());

        PostDto.Response postResponse2 = postResponses.get(1);
        assertThat(postResponse2.getId()).isEqualTo(postEntity2.getId());
        assertThat(postResponse2.getTitle()).isEqualTo(postEntity2.getTitle());
        assertThat(postResponse2.getContent()).isEqualTo(postEntity2.getContent());

        verify(postRepository, times(1)).findAll();
    }
}