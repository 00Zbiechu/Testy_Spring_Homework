package pl.testy.zadanie.testy_spring_homework.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "token_blacklist")
public class TokenBlacklistEntity {
    @Id
    @Column(name = "token", nullable = false)
    private String token;

    @Column(name = "expire_date")
    private Timestamp expireDate;
}
