package pl.testy.zadanie.testy_spring_homework.common;


import pl.testy.zadanie.testy_spring_homework.entity.Address;
import pl.testy.zadanie.testy_spring_homework.model.AddressDTO;

import java.util.List;

public class AddressTestDataProvider {

    public static List<Address> prepareMockData(){

        return List.of(

                    Address.builder()
                        .communeCode("75-400")
                        .streetName("Test")
                        .flatNumber("12")
                        .houseNumber("13")
                        .defaultAddress(false)
                        .build(),
                    Address.builder()
                        .communeCode("75-400")
                        .streetName("TEST")
                        .flatNumber("12")
                        .houseNumber("13")
                        .defaultAddress(false)
                        .build(),
                    Address.builder()
                        .communeCode("75-400")
                        .streetName("TEST")
                        .flatNumber("12")
                        .houseNumber("13")
                        .defaultAddress(false)
                        .build()

        );


    }

}
