package com.study.eodini.user.domain;

import com.study.eodini.auditing.BaseInformEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;


/**
 * 회원가입 전 임시 저장소
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity
public class UserTempEntity extends BaseInformEntity {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    private String id;
    private String name;
    private String email;
    private String password;
    private String age;


}
