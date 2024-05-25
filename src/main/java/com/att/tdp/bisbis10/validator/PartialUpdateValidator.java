package com.att.tdp.bisbis10.validator;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

import com.att.tdp.bisbis10.exception.PartialUpdateValueNotValidException;

@Component
public class PartialUpdateValidator implements Validator {

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return Object.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        Set<String> nonNullFieldNames = getNonNullFieldNamesFromObject(target);

        for (FieldError fieldError : errors.getFieldErrors()) {
            if (nonNullFieldNames.contains(fieldError.getField().replace("[", "").replace("]", ""))) {
                throw new PartialUpdateValueNotValidException(fieldError.getDefaultMessage());
            }
        }
    }

    private Set<String> getNonNullFieldNamesFromObject(Object target) {
        Class<?> clazz = target.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Set<String> nonNullFieldNames = new HashSet<>();

        for (Field field : fields) {
            field.setAccessible(true);

            try {
                Object value = field.get(target);

                if (value != null) {
                    nonNullFieldNames.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                throw new PartialUpdateValueNotValidException("Unknown error has occured while validating object");
            }
        }

        return nonNullFieldNames;
    }
}
