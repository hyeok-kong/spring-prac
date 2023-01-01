package com.kong.prac.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity // 테이블과 링크될 클래스임을 나타냄
public class Posts {
    @Id // 해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙, IDENTITY 는 auto_increment임
    private Long id;

    // Column 어노테이션의 경우 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됨.
    // 기본값 외에 추가로 변경이 필요한 옵션이 있을 시 사용
    @Column(length = 500, nullable = false) // 문자열의 경우 VARCHAR(255)가 기본이지만, 500으로 변경
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) { // 더티체킹(Dirty Checking)
        this.title = title;
        this.content = content;
    }
}
