package com.dauphine.blogger.controllers.requestbody;

import java.util.UUID;

public record PostRequestBody(String title, String content, UUID categoryId) {
}
