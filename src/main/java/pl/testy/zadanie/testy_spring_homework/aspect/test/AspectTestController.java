package pl.testy.zadanie.testy_spring_homework.aspect.test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aspect-test")
@RequiredArgsConstructor
public class AspectTestController {

    private final AspectTestRepository aspectTestRepository;


    @GetMapping
    public void test() {
        aspectTestRepository.findAll();
    }

}
