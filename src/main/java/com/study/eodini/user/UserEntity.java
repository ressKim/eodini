package com.study.eodini.user;

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
public class UserEntity {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    private String id;
    private String name;
    private String email;
}
