package com.diplomado.SegundoTrabajoV1.web.rest.exceptions;

public class UserIdNotFoundException extends RuntimeException{
    public UserIdNotFoundException(Long userId) {
        super("No user id: " + userId);
    }
}
