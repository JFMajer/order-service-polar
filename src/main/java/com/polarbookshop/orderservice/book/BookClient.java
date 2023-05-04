package com.polarbookshop.orderservice.book;

import com.polarbookshop.orderservice.exception.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Component
public class BookClient {
    private static final String BOOKS_ROOT_API = "/books";
    private final WebClient webClient;

    public BookClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Book> getBookByIsbn(String isbn) {
        return webClient.get()
                .uri(BOOKS_ROOT_API + "/{isbn}", isbn)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> Mono.error(new BookNotFoundException("Error retrieving book with isbn " + isbn)))
                .bodyToMono(Book.class);
    }

}
