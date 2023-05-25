package pl.testy.zadanie.testy_spring_homework.entity;


import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "person_entity")
@NoArgsConstructor
@Transactional
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq_generator")
    @SequenceGenerator(name = "person_seq_generator", sequenceName = "person_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 100)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false)
    private Integer active;

    @OneToMany(mappedBy = "personEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Role> roleEntity;


}
