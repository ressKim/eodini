package com.study.eodini.user.domain;

import com.study.eodini.auditing.BaseInformEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity
public class UserEntity extends BaseInformEntity {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    private String id;
    private String name;
    private String email;
    private String password;
    private String age;
}
