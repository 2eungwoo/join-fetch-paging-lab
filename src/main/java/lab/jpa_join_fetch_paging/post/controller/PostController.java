package lab.jpa_join_fetch_paging.post.controller;

import lab.jpa_join_fetch_paging.post.domain.dto.PostDto;
import lab.jpa_join_fetch_paging.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts/{postId}")
    public ResponseEntity<?> getPostById(@PathVariable Long postId){
        PostDto.Response postResponseDto = postService.getPostById(postId);
        return ResponseEntity.ok(postResponseDto);
    }

    @GetMapping("/posts")
    public ResponseEntity<?> getAllPosts(){
        List<PostDto.Response> postResponseDto = postService.getAllPosts();
        return ResponseEntity.ok(postResponseDto);
    }

    @PostMapping("/posts")
    public ResponseEntity<?> createPost(@RequestBody PostDto.Request postRequestDto){
        PostDto.Response postResponseDto = postService.createPost(postRequestDto);
        return ResponseEntity.ok(postResponseDto);
    }
}
