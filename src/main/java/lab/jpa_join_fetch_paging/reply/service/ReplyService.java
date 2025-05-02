package lab.jpa_join_fetch_paging.reply.service;

import lab.jpa_join_fetch_paging.reply.domain.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;
}
