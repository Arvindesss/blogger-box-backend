package com.dauphine.blogger.controllers.requestbody;

import java.util.UUID;

public record CreatePostRequestBody(String title, String content, UUID categoryId) {
}
