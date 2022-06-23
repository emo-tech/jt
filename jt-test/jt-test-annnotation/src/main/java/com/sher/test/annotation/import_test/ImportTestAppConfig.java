package com.sher.test.annotation.import_test;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author sherxia92
 */
@Configuration
@Import(User.class)
public class ImportTestAppConfig {
}
