package org.paychex.controller;

import org.paychex.model.Validation;
import org.paychex.utils.ValidationUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ValidationController {

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/validate",  produces = { "application/json" })
    public List<Validation> validate(@RequestBody List<String> isbns) {
        if (isbns == null || isbns.size() == 0) return Collections.emptyList();

        List<Validation> validations = new ArrayList<>();
        for(String isbn : isbns) {
            validations.add(new Validation(isbn, ValidationUtils.isValid(isbn)));
        }
        return validations;
    }
}
