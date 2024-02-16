package com.makeup.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

// 엔티티의 생성 시간과 수정 시간을 자동으로 관리하기 위한 베이스 클래스.
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTime {

    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
// --> 다른 엔티티 클래스들이 상속 받을 수 있는 베이스 클래스로서 기능함.
// 엔티티의 생성 및 수정 시간을 효율적으로 관리할 수 있음
