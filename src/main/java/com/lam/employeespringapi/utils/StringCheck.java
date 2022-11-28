package com.lam.employeespringapi.utils;

import com.lam.employeespringapi.validator.BlankConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringCheck implements ConstraintValidator<BlankConstraint, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !s.isBlank();
    }

    @Override
    public void initialize(BlankConstraint constraintAnnotation) {}
}
