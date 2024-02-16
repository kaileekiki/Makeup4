package com.makeup.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Entity
public class Post {
    private String uploadDir;     // 파일을 업로드할 서버상의 데이터 베이스 디렉토리 경로를 저장하는 필드임.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String title;

    @Setter
    private String content;

    // 이미지 파일의 구체적인 경로나 이름을 저장하는 필드.
    // uploadDir 필드와 비슷해 보이지만
    // uploadDir에서 저젱된 기본 경로 내에서 특정파일을 식별하는데 사용된다.
    // 두 개의 필드를 사용함으로서 파일 업로드와 관리의 접근 방식을 효율적으로 관리한다.
    private String imagePath;

    @Getter
    @Setter
    private int likes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    // JPA의 요구 사항을 충족시키고 클래스의 인스턴스 생성을 제어하기 위함
    protected Post() {
    }

    // 포스트 클래스의 생성자
    public Post(String title, String content, String imagePath, Member member, int likes) {
        this.title = title;
        this.content = content;
        this.imagePath = imagePath;
        this.member = member;
        this.likes = likes;
    }

    // 파일의 이미지를 저장하는 메소드
    // 이미지 파일과 포스트 데이터 사이의 연결이 직접적이기 때문에
    // 엔티티 내에서 관리하는 것이 자연스러울 수 있다고 봄
    public void setImage(MultipartFile image) {     // Spring Framework의 MultipartFile 인터페이스 타입의 파라미터 image를 받는다.
        if (image != null && !image.isEmpty()) {    // Null이 아니면서 실제로 데이터를 포함하고 있는지 확인한다.

            // 업로드된 파일의 원본 이름을 가져오기 위한 메소드 호룰, 현재 시간을 나타내는 메소드 호출
            // --> 파일 이름 충동을 방지하고 각 파일을 고유하게 식별하기 위한 방법
            try {
                String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
                Path uploadPath = Paths.get(uploadDir);

                // 저장 경로를 설정한다. uploadDir 필드에 저장된 경로를 기반으로 Path 객체를 생성한다.
                // 이미지 파일이 서버에 저장될 위치를 나타낸다.
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                //  파일이 성공적으로 저장된 뒤에 메소드를 호풀하여 파일의 전체 경로를 문자열로 변환하고
                // 이를 객체의 imagePath 필드에 저장한다.
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                this.imagePath = filePath.toString();    // 파일이 저장된 후 메소드를 호출하여서 imagePath 필드에 저장한다.
            } catch (IOException e) {
                // 적절한 예외 처리 로직 구현
                e.printStackTrace();
            }
        }
    }

    // 아직 로직 구현을 어떻게 해야하는지 모르겠음
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
