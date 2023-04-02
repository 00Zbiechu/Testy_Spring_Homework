package pl.testy.zadanie.testy_spring_homework.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.testy.zadanie.testy_spring_homework.common.BaseApiTest;
import pl.testy.zadanie.testy_spring_homework.common.PersonDataProvider;
import pl.testy.zadanie.testy_spring_homework.model.PersonListResponse;
import pl.testy.zadanie.testy_spring_homework.repository.PersonReposiotry;


class PersonControllerTest extends BaseApiTest {

    private final String PERSON_CONTROLLER_PATH = "/api/person";


    @Autowired
    private PersonReposiotry personReposiotry;


    @Test
    void testGetAllPersonsShouldReturn2() throws Exception {
        //given
        personReposiotry.saveAll(PersonDataProvider.prepareMockData());

        //when
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(PERSON_CONTROLLER_PATH));

        //then
        PersonListResponse personListResponse = asObject(resultActions, PersonListResponse.class);

        Assertions.assertAll(
                () -> Assertions.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200),
                () -> Assertions.assertNotNull(personListResponse),
                () -> Assertions.assertEquals(personListResponse.getPersons().size(), 3),
                () -> Assertions.assertNotNull(personListResponse.getPersons().get(0).getFirstName(), "TEST"));
    }

}