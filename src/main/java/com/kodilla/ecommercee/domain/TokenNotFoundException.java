package com.kodilla.ecommercee.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Token was not found!")
public class TokenNotFoundException extends Exception {
}
