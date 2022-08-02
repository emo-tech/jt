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
        String encryptString = "BZphXKR35/p9iqelT/S68CuGxLPKdxMc2/ABA/J+jJGbk9T0d585Ers9hYAK6mspAwO///SCVG+m3zAmbmTcUqH9RBm/m9zGKqTvu/tkO3IZ8EdH+Z2+b0NVSsPkoXmyyGelgvonZXd0coLhEs4ksqSmamf8HgNALlJGmKVy/A9LtwmxzQi53vfMK6/Dlihu8LjcOsNY/C2f9KdHMTckZRvMkVw6Faend24BnTl/nkXHDqA8Bt5ZgeBTV8CJAbkfrVZKXcbPcDbsqDhDnhExUA==";
        String decryptKey = defaultKey;
        String decryptString = EncryptUtils.aesDecrypt(encryptString, decryptKey);
        log.debug("decryptString: {}", decryptString);
        log.debug("解密");
    }
}
