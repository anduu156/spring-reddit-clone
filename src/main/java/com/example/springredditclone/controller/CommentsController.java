package com.example.springredditclone.controller;

import com.example.springredditclone.dto.CommentsDto;
import com.example.springredditclone.exception.SpringRedditException;
import com.example.springredditclone.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@AllArgsConstructor
public class CommentsController {
    private final CommentService commentService;


    @PostMapping
    public ResponseEntity<Void> createComment(@RequestBody CommentsDto commentsDto) throws SpringRedditException {
        commentService.createComment(commentsDto);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
    @GetMapping("/by-post/{postId}")
    public ResponseEntity<List<CommentsDto>> getAllCommentsForPost(@PathVariable Long postId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(commentService.getAllCommentsForPost(postId));

    }
    @GetMapping("/by-user/{userName}")
    public ResponseEntity<List<CommentsDto>> getAllCommentsForUser(@PathVariable String userName){
        return ResponseEntity.status(HttpStatus.OK)
                .body(commentService.getAllCommentsForUser(userName));
    }
}
