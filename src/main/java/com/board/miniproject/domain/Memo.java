package com.board.miniproject.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb1_memo")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class Memo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    @Column(length = 200, nullable = false)
    private String memoText;

    @Builder
    public Memo(String memoText) {
        this.memoText = memoText;
    }
}
