package pl.testy.zadanie.testy_spring_homework.component;

import lombok.*;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionType;
import pl.testy.zadanie.testy_spring_homework.entity.Address;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressRevision {

    private Address entity;
    private DefaultRevisionEntity addressEntityRevision;
    private RevisionType revisionType;

}
