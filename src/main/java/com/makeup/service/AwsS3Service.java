/*
package com.makeup.service;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;

@Service
public class AwsS3Service {

    private final S3Client s3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    public AwsS3Service(@Value("${cloud.aws.credentials.access-key}") String accessKey,
                        @Value("${cloud.aws.credentials.secret-key}") String secretKey,
                        @Value("${cloud.aws.region.static}") String region) {
        // S3 클라이언트 초기화
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKey, secretKey);
        this.s3Client = S3Client.builder()
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .region(Region.of(region))
                .build();
    }

    public URL upload(MultipartFile file, String dirName) throws IOException {
        String fileName = dirName + "/" + createFileName(file.getOriginalFilename());

        // MultipartFile을 InputStream으로 변환하여 S3에 업로드
        try {
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(fileName)
                    .build();

            s3Client.putObject(putObjectRequest, software.amazon.awssdk.core.sync.RequestBody.fromInputStream(file.getInputStream(), file.getSize()));

            // 업로드된 파일의 URL 반환
            return s3Client.utilities().getUrl(builder -> builder.bucket(bucketName).key(fileName));
        } catch (IOException e) {
            throw new RuntimeException("S3 파일 업로드 실패", e);
        }
    }

    private String createFileName(String originalFilename) {
        // 파일 이름 생성 로직 (예: UUID 추가)
        return System.currentTimeMillis() + "_" + originalFilename;
    }
}

 */