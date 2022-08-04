package com.sher.api.secret.test;

import com.sher.api.secret.Application;
import com.sher.api.secret.util.EncryptUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

    @Value("${secret.privateKey.h5}")
    private String h5Key;
    @Value("${secret.privateKey.default}")
    private String defaultKey;

    @Test
    public void decryptResponseData() throws Exception {
        String encryptString = "sherxia92#Letmein_2022&20220804174450";
        String decryptKey = defaultKey;
        String decryptString = EncryptUtils.aesDecrypt(encryptString, decryptKey);
        log.debug("decryptString: {}", decryptString);
        log.debug("解密");
    }

    @Test
    public void encryptResponseData() throws Exception {
        String str = "sherxia92#Letmein_2022&20220804174450";
        String decryptKey = defaultKey;
        String cryptString = EncryptUtils.aesDecrypt(str, decryptKey);
        log.debug("cryptString: {}", cryptString);
        log.debug("加密");
    }
}
