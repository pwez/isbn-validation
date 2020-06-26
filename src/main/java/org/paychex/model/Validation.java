package org.paychex.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Validation {

    private String isbn;
    private boolean isValid;

    public Validation (String isbn, boolean isValid) {
        this.isbn = isbn;
        this.isValid = isValid;
    }

}
