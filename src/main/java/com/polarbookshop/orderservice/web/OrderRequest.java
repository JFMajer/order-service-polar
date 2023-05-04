package com.polarbookshop.orderservice.web;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;


// OrderRequest will act as DTO (Data Transfer Object) for the Order entity.
public record OrderRequest(
        @NotBlank(message = "The book ISBN must not be blank")
        String isbn,

        @NotNull(message = "The book quantity must be defined")
        @Min(value = 1, message = "You must order at least one item")
        @Max(value = 5, message = "You cannot order more than 5 items")
        Integer quantity
) {


}
