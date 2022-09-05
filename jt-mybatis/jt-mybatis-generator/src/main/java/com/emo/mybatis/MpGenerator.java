package com.emo.mybatis;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;

/**
 * @author sherxia92
 * 2022/9/5 0005 下午 17:00
 */
@Slf4j
public class MpGenerator {

    /**
     * RUN THIS
     */
    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir") + "/jt-mybatis/jt-mybatis-generator";
        String outDir = projectPath + "/src/main/java";
        log.debug("outDir: " + outDir);

        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&serverTimezone=GMT&useSSL=false&characterEncoding=utf8","root","123456")
                .globalConfig(builder -> {
                    builder.author("sherxia92") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
//                            .disableOpenDir() //禁止打开输出目录
                            .outputDir(outDir); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.emo.redis") // 设置父包名
                            .entity("entity") //设置entity包名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, projectPath + "/src/main/resources/mapper")); // 设置mapperXml生成路径

                })
//                .injectionConfig(consumer -> {
//                    Map<String, String> customFile = new HashMap<>();
//                    // DTO
//                    customFile.put("DTO.java", "/templates/entityDTO.java.ftl");
//                    consumer.customFile(customFile);
//                })
                .strategyConfig(builder -> {
                    builder.addInclude("pms_sku_stock") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                //.templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }

}
