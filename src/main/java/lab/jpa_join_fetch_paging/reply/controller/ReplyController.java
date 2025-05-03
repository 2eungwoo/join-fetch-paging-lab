package lab.jpa_join_fetch_paging.reply.controller;

import lab.jpa_join_fetch_paging.reply.domain.dto.ReplyDto;
import lab.jpa_join_fetch_paging.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping("/posts/{postId}/reply")
    public ResponseEntity<?> createReply(@PathVariable Long postId, @RequestBody ReplyDto.Request replyRequestDto){
        ReplyDto.Response result = replyService.createReply(postId, replyRequestDto);
        return ResponseEntity.ok(result);
    }
}
