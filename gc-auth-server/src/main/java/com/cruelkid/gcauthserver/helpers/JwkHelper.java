package com.cruelkid.gcauthserver.helpers;

import com.nimbusds.jose.jwk.RSAKey;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwkHelper {

    public static RSAKey generateRsa() throws NoSuchAlgorithmException {
        KeyPair keyPair = generateRsaKey();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        return new RSAKey.Builder(publicKey)
                .privateKey(privateKey)
                .keyID(UUID.randomUUID().toString())
                .build();
    }

    public static KeyPair generateRsaKey() throws NoSuchAlgorithmException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");

        generator.initialize(2048);

        return generator.generateKeyPair();
    }

}
