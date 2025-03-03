package com.app.raghu.controller;

import com.app.raghu.book.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/book")
public class BookRestController {

    @PostMapping("/showD")
    public ResponseEntity<String> showMgs4(@RequestBody Book book) {
        return ResponseEntity.ok("Data given is " + book);
    }

}
