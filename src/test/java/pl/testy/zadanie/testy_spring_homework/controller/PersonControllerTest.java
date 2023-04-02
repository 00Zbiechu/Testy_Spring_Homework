package pl.testy.zadanie.testy_spring_homework.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.testy.zadanie.testy_spring_homework.common.BaseApiTest;
import pl.testy.zadanie.testy_spring_homework.common.PersonTestDataProvider;
import pl.testy.zadanie.testy_spring_homework.entity.Person;
import pl.testy.zadanie.testy_spring_homework.mapper.PersonMapper;
import pl.testy.zadanie.testy_spring_homework.model.PersonDTO;
import pl.testy.zadanie.testy_spring_homework.model.PersonListResponse;
import pl.testy.zadanie.testy_spring_homework.repository.PersonReposiotry;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class PersonControllerTest extends BaseApiTest {

    private final String PERSON_CONTROLLER_PATH = "/api/person";


    @Autowired
    private PersonReposiotry personReposiotry;



    @DisplayName("Test /api/person/all should return List of PersonDTO")
    @Test
    void testOfGetOperationsShouldReturnListOfPersonDTO() throws Exception {
        //given
        personReposiotry.saveAll(PersonTestDataProvider.prepareMockData());

        //when
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(PERSON_CONTROLLER_PATH + "/all"));

        //then
        resultActions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.persons").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.persons[0].firstName").value("Test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.persons[0].lastName").value("Test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.persons[0].birthDate").value(LocalDate.now().toString()));

    }

    @DisplayName("Test /api/person/save should save Person to Database")
    @Test
    void testOfPostOperationsShouldSaveNewPersonToDatabase() throws Exception {

        //given
        PersonDTO personDTO = PersonMapper.INSTANCE.toDTO(PersonTestDataProvider.prepareMockData().get(0));


        //when
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post(PERSON_CONTROLLER_PATH+"/save")
                .content(asJson(personDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));


        resultActions
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.persons[0].id").value(String.valueOf(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.persons[0].firstName").value("Test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.persons[0].lastName").value("Test"));

    }

    @DisplayName("Test /api/person/update should update Person in Database")
    @Test
    public void testOfPutOperationShouldUpdatePersonInDatabase() throws Exception
    {
        //given
        personReposiotry.saveAll(PersonTestDataProvider.prepareMockData());

        PersonDTO personDTO = PersonMapper.INSTANCE.toDTO(PersonTestDataProvider.prepareMockData().get(0));
        personDTO.setLastName("Zbiewski");


        ResultActions resultActions = mockMvc.perform( MockMvcRequestBuilders
                        .put(PERSON_CONTROLLER_PATH+"/update/{id}", 1)
                        .content(asJson(personDTO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));

         resultActions
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.persons[0].lastName").value("Zbiewski"));
    }




    @DisplayName("Test /api/person/delete should delete one Person from Database")
    @Test
    public void testOfDeleteOperationsShouldDeletePerson() throws Exception
    {
        //given
        personReposiotry.saveAll(PersonTestDataProvider.prepareMockData());

        //when
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.delete(PERSON_CONTROLLER_PATH+"/delete/{id}",3));

        resultActions
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.persons[2].id").doesNotExist());




    }




}