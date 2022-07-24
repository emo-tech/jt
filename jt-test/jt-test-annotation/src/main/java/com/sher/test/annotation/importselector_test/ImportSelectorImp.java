package com.sher.test.annotation.importselector_test;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

/**
 * @author sherxia92
 */
public class ImportSelectorImp implements ImportSelector {

    private String userClass = "com.sher.test.annotation.common.User";

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {
                "com.sher.test.annotation.common.User"
        };
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String str) {
                if (str.matches(userClass)) {
                    return true;
                }
                return false;
            }
        };
        return predicate;
    }
}
