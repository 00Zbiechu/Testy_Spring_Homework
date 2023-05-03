package pl.testy.zadanie.testy_spring_homework.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.testy.zadanie.testy_spring_homework.common.AddressTestDataProvider;
import pl.testy.zadanie.testy_spring_homework.common.BaseApiTest;
import pl.testy.zadanie.testy_spring_homework.mapper.AddressMapper;
import pl.testy.zadanie.testy_spring_homework.model.AddressDTO;
import pl.testy.zadanie.testy_spring_homework.model.AddressListResponse;
import pl.testy.zadanie.testy_spring_homework.repository.AddressRepository;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AddressControllerTest extends BaseApiTest {

    private final String ADDRESS_CONTROLLER_PATH = "/api/address";

    @Autowired
    AddressRepository addressRepository;


    @DisplayName("Test /api/address/all method @Get should return List of AddressDTO")
    @Test
    void testOfGetOperationsShouldReturnListOfAddressDTO() throws Exception {
        //given
        addressRepository.saveAll(AddressTestDataProvider.prepareMockData());

        //when
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(ADDRESS_CONTROLLER_PATH + "/all"));

        //then
        AddressListResponse addressListResponse = asObject(resultActions,AddressListResponse.class);

        assertAll(
                ()->assertEquals(resultActions.andReturn().getResponse().getStatus(), 200),
                ()->assertEquals(addressListResponse.getAddresses().get(2).getFlatNumber(),"12"),
                ()->assertEquals(addressListResponse.getAddresses().get(2).getHouseNumber(),"13"),
                ()->assertEquals(addressListResponse.getAddresses().get(2).getStreetName(),"Test"),
                ()->assertEquals(addressListResponse.getAddresses().get(2).getCommuneCode(),"75-400"),
                ()->assertEquals(addressListResponse.getAddresses().get(2).isDefaultAddress(),false)
        );

    }


    @DisplayName("Test /api/address method @Post should save Address to Database")
    @Test
    void testOfPostOperationsShouldSaveNewPersonToDatabase() throws Exception {

        //given
        AddressDTO addressDTO = AddressMapper.INSTANCE.toDTO(AddressTestDataProvider.prepareMockData().get(0));


        //when
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post(ADDRESS_CONTROLLER_PATH)
                .content(asJson(addressDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));


        //then
        AddressDTO addressDTOResult = asObject(resultActions,AddressDTO.class);

        assertAll(
                ()->assertEquals(addressDTOResult.getFlatNumber(),"12"),
                ()->assertEquals(addressDTOResult.getHouseNumber(),"13"),
                ()->assertEquals(addressDTOResult.getStreetName(),"Test"),
                ()->assertEquals(addressDTOResult.getCommuneCode(),"75-400"),
                ()->assertEquals(addressDTOResult.isDefaultAddress(),false)
        );

    }

    @DisplayName("Test /api/address method @Put should update Address in Database")
    @Test
    public void testOfPutOperationShouldUpdatePersonInDatabase() throws Exception
    {
        //given
        addressRepository.saveAll(AddressTestDataProvider.prepareMockData());

        AddressDTO addressDTO = AddressMapper.INSTANCE.toDTO(AddressTestDataProvider.prepareMockData().get(0));
        addressDTO.setStreetName("Testowa");


        ResultActions resultActions = mockMvc.perform( MockMvcRequestBuilders
                .put(ADDRESS_CONTROLLER_PATH+"/{id}", 1L)
                .content(asJson(addressDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));


        //then
        AddressDTO addressDTOResult = asObject(resultActions,AddressDTO.class);

        assertAll(
                ()->assertEquals(addressDTOResult.getStreetName(),"Testowa")
        );

    }

    @DisplayName("Test /api/address method @Delete should delete one Address from Database")
    @Test
    public void testOfDeleteOperationsShouldDeletePerson() throws Exception
    {
        //given
        addressRepository.saveAll(AddressTestDataProvider.prepareMockData());

        //when
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.delete(ADDRESS_CONTROLLER_PATH+"/{id}",3L));

        resultActions
                .andExpect(status().isAccepted());


    }


}