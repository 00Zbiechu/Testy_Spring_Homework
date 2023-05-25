package pl.testy.zadanie.testy_spring_homework.entity;

import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "user_role")
@NoArgsConstructor
@Transactional
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq_generator")
    @SequenceGenerator(name = "role_seq_generator", sequenceName = "role_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;


    @ManyToOne
    @JoinColumn(name = "PERSON_ID", nullable = false, referencedColumnName = "ID")
    private PersonEntity personEntity;

}
