package lab.jpa_join_fetch_paging.post.service;

import lab.jpa_join_fetch_paging.common.util.finder.EntityFinder;
import lab.jpa_join_fetch_paging.post.domain.entity.PostEntity;
import lab.jpa_join_fetch_paging.post.domain.dto.PostDto;
import lab.jpa_join_fetch_paging.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final EntityFinder<PostEntity, Long> postFinder;

    @Transactional(readOnly = true)
    public PostDto.Response getPostById(Long postId){
        PostEntity postEntity = postFinder.findByIdOrThrow(postId);
        return new PostDto.Response(postEntity);
    }

    @Transactional(readOnly = true)
    public List<PostDto.Response> getAllPosts(){

        List<PostEntity> postEntities = postRepository.findAll();

        return postEntities.stream()
                .map(postEntity -> new PostDto.Response(postEntity))
                .collect(Collectors.toList());
    }

    @Transactional
    public PostDto.Response createPost(PostDto.Request postRequestDto){
        PostEntity postEntity = PostEntity.builder()
                .title(postRequestDto.getTitle())
                .content(postRequestDto.getContent())
                .build();

        postRepository.save(postEntity);
        return new PostDto.Response(postEntity);
    }
}
