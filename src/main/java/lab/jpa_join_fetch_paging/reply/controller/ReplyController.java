package lab.jpa_join_fetch_paging.reply.controller;

import lab.jpa_join_fetch_paging.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;
}
