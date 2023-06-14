package com.nest.strykerwebappbackend;

import org.springframework.http.HttpStatus;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.nest.strykerwebappbackend.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ResourceNotFoundExceptionTest {
    @Test
    public void testConstructorAndGetMessage() {
        String errorMessage = "Resource not found";
        ResourceNotFoundException exception = new ResourceNotFoundException(errorMessage);

        // Verify the exception message
        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    public void testResponseStatusAnnotation() {
        ResponseStatus annotation = ResourceNotFoundException.class.getAnnotation(ResponseStatus.class);

        // Verify the response status value in the ResponseStatus annotation
        assertEquals(HttpStatus.NOT_FOUND, annotation.value());
    }
}

