package br.com.wishlist.api.infrastructure.exceptions;

import lombok.Builder;

import java.util.List;

@Builder
public record ApiError(String timestamp, int code, List<String> errors) {
}
