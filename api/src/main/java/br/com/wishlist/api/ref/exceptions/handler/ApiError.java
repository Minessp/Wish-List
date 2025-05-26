package br.com.wishlist.api.exceptions.handler;

import lombok.Builder;

import java.util.List;

@Builder
public record ApiError(String timestamp, int code, List<String> errors) {
}
