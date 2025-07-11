package com.demoJV.demoapp.security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

public class SecurityConstants {
    public static final long JWT_EXPIRATION = 86400000;
//    public static final String JWT_SECRET = "super-super-long-secret-key-must-be-over-64-bytes-lol-123456789";
    public static final SecretKey JWT_SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
}
