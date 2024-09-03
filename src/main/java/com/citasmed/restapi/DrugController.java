package com.citasmed.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/drugs")
public class DrugController {

    @GetMapping("/")
    public String index() {
        return new String("Hello World");
    }
}
