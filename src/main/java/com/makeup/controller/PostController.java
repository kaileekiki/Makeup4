/*
package com.makeup.controller;

import com.makeup.domain.Post;
import com.makeup.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @Autowired      //의존성 주입 기능 사용 PostService 클래스에 있는 인스턴스 사용 가능
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 게시물을 생성함!
    @PostMapping
    public Post createPost(@RequestParam("title") String title,
                            @RequestParam("content") String content,
                            @RequestParam("image") MultipartFile image, // 클라이언트로 전송된 파일을 Spring에서 처리할 수 있도록 해줌
                            @RequestParam("userId") Long userId) {
        return postService.createPost(title, content, image, userId);   // 메소드 호출을 통하여서 게시글을 형성한다.
    }

    // 게시물 목록을 조회함!
    // 게시글의 모든 목록을 조회하고 조회된 게시글의 목록을 반환함.
    @GetMapping     // 클라이언트로 부터 Get요청을 받으면 실행된다.
    public List<Post> getAllPosts() {
        return postService.getAllPosts();   // 모든 Post를 볼 수 있는 메소드 호출함. PostService 클래스에서
    }

    // 게시물을 상세 조회함!
    // 즉, 요청된 게시물의 ID를 파라미터로 전달받습니다.
    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable Long postId) {
        return postService.getPostById(postId);     // URL 경로에서 받은 postId를 인자로 전단한다.
                                                    // 이 서비스 메서드는 해당 ID를 가진 게시물을 데이터 베이스에서
                                                    // 찾아 반환한다.
    }

    // 게시물 공감을 추가함!
    @PostMapping("/{postId}/like")
    public int addLikeToPost(@PathVariable Long postId) {
        return postService.addLikeToPost(postId);       // 추출된 PostId의 값이 파라미터로 전달이 된다,
                                                        // 메서드를 통하여서 업데이트 된 좋아요 수를 쿨라이언트에게 반환한다.
    }

    // 게시물을 수정함!
    @PutMapping("/{postId}")
    public Post updatePost(@PathVariable Long postId,
                            @RequestParam("title") String title,
                            @RequestParam("content") String content,
                            @RequestParam("image") MultipartFile image) {
        return postService.updatePost(postId, title, content, image);
    }

    // 게시물을 삭제함!
//    postService.deletePost(postId);: PostService의
//    deletePost 메서드를 호출하면서, 삭제할 게시물의 ID를 인자로 전달한다.
    @DeleteMapping("/{postId}/delete")
    public void deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
    }
}
*/