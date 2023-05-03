package pl.testy.zadanie.testy_spring_homework.component;

import lombok.*;
import org.hibernate.envers.RevisionType;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddressRevisionDTO {

    private Long id;
    private String streetName;
    private String communeCode;
    private String houseNumber;
    private String flatNumber;
    private boolean defaultAddress;
    private Long revNumber;
    private RevisionType revisionType;

    private String createdBy;

    private String modifiedBy;

}
