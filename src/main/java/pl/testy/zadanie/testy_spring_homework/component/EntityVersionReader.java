package pl.testy.zadanie.testy_spring_homework.component;

import lombok.RequiredArgsConstructor;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.testy.zadanie.testy_spring_homework.entity.Address;

import javax.persistence.EntityManager;
import java.util.List;

@Component
@Transactional
@RequiredArgsConstructor
public class EntityVersionReader {

    private final EntityManager entityManager;

    public List<AddressRevision> readLog(){
        return AuditReaderFactory.get(entityManager)
                .createQuery()
                .forRevisionsOfEntity(Address.class, false,true)
                .getResultList().stream()
                .map(this::buildEntityRevision)
                .toList();
    }


    private AddressRevision buildEntityRevision(Object revision){
        Object[] revisionArray = (Object[]) revision;
        Address entity = (Address) revisionArray[0];
        DefaultRevisionEntity defaultRevisionEntity = (DefaultRevisionEntity) revisionArray[1];
        RevisionType revisionType = (RevisionType) revisionArray[2];


        return AddressRevision.builder()
                .entity(entity)
                .addressEntityRevision(defaultRevisionEntity)
                .revisionType(revisionType)
                .build();

    }







}
