package com.example.undertowinstrumentationbug;

import io.opentelemetry.api.baggage.Baggage;
import io.opentelemetry.api.trace.Span;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;

@RestController
@RequestMapping("/home")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public ResponseEntity<String> getHome() {
        final Baggage baggage = Baggage.current();
        if (baggage.isEmpty()) {
            logger.warn("Baggage is empty!");
        } else {
            logger.warn("Baggage foo is {}", baggage.getEntryValue("foo"));
        }
        return ResponseEntity.ok("Welcome to Home!");
    }
}
