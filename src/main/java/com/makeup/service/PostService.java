/*package com.makeup.service;
import com.makeup.domain.Post;
import com.makeup.repository.PostRepository;
import com.makeup.domain.Member;
import com.makeup.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final AwsS3Service awsS3Service; // AwsS3Service 추가

    @Autowired
    public PostService(PostRepository postRepository, MemberRepository memberRepository, AwsS3Service awsS3Service) {
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
        this.awsS3Service = awsS3Service; // 의존성 주입
    }

    public Post createPost(String title, String content, MultipartFile image, Long userId) {
        String imagePath = null;
        if (image != null && !image.isEmpty()) {
            try {
                imagePath = awsS3Service.upload(image, "post-images").toString(); // AWS S3에 이미지 업로드하고 URL 받아오기
            } catch (IOException e) {
                // 업로드 중 예외 처리. 적절한 예외 처리 로직을 구현하세요.
                e.printStackTrace();
            }
        }

        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found with id: " + userId));
        Post post = new Post(title, content, imagePath, member, 0);
        return postRepository.save(post);
    }
    // MultipartFile 타입의 이미지 파일을 서버의 지정된 디렉토리에 저장하는 메소드
    // 지정된 디렉토리 == uploadDir
    private String saveImage(MultipartFile image, String uploadDir) {
        try {

            String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
            Path uploadPath = Paths.get(uploadDir);

            // 업로드 할 경로를  Path 객체로 변환한다.
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // 파일을 저장
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            return filePath.toString();

            // 간단한 예외처리
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file " + image.getOriginalFilename(), e);
        }
    }


    // 데이터 베이스에서 모든 게시물을 조회하여 반환하는 기능을 수행한다.
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // 특정 ID 값을 가지는 게시물을 데이터베이스에서 조회하여 반환하는 기능을 수행한다.
    public Post getPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found with id: " + postId));
    }

    // 특정 아이디를 가진 게시물을 업데이트함.
    public Post updatePost(Long postId, String title, String content, MultipartFile image) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found with id: " + postId));

        post.setTitle(title);
        post.setContent(content);

        // 이미지가 제공되었다면 업데이트
        if (image != null && !image.isEmpty()) {
            String imagePath = saveImage(image);
            post.setImagePath(imagePath);
        }

        return postRepository.save(post);
    }

    // 게시물을 지우는 로직
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    // 이미지 파일을 서버에 저장하고, 저장된 파일의 경로를 반환한다.
    private String saveImage(MultipartFile image) {
        // 이미지 저장 로직 구현
        // 예시 코드에서는 단순히 파일 이름을 반환합니다.
        return image.getOriginalFilename(); // 이 부분을 실제 저장 위치로 변경해야 합니다.
    }

    // 특정 ID를 가진 게시물의 좋아요 수를 1 증가시킨다.
    public int addLikeToPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found with id: " + postId));
        int currentLikes = post.getLikes(); // 가정: Post 엔티티에 'likes' 필드가 있음
        post.setLikes(currentLikes + 1);
        postRepository.save(post);
        return currentLikes;
    }
}
*/