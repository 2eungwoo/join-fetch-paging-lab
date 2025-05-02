package lab.jpa_join_fetch_paging.post.service;

import lab.jpa_join_fetch_paging.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
}
