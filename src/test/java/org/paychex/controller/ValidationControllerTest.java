package org.paychex.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.paychex.model.Validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidationControllerTest {

    private ValidationController validationController;

    @Before
    public void before() {
        validationController = new ValidationController();
    }

    @Test
    public void nullListReturnsEmptyList () {
        Assert.assertEquals(Collections.emptyList(), validationController.validate(null));
    }

    @Test
    public void zeroLengthListReturnsEmptyList () {
        List<String> isbnList = new ArrayList<>();
        Assert.assertEquals(Collections.emptyList(), validationController.validate(isbnList));
    }

    @Test
    public void stringListReturnsValidationList () {
        List<String> isbnList = new ArrayList<>();
        isbnList.add("0198526631");
        isbnList.add("019852663X");
        List<Validation> validations = validationController.validate(isbnList);
        Assert.assertEquals(2, validations.size());
        Assert.assertTrue(validations.get(0).isValid());
        Assert.assertFalse(validations.get(1).isValid());
    }

}
