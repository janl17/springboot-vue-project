package com.lantu;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

import static com.baomidou.mybatisplus.generator.config.builder.GeneratorBuilder.strategyConfig;

public class CodeGenerator {
    public static void main(String[] args) {
        String url = "jdbc:mysql:///xdb";
        String username = "root";
        String password = "";
        String moduleName = "sys";
        String mapperLocation = "/Users/janleung/IdeaProjects/x-admin/src/main/resources/mapper/" + moduleName;
        String tables = "x_user";

        FastAutoGenerator.create(url,username,password)
                .globalConfig(builder -> {
                    builder.author("laocai")
//                            .enableSwagger()
//                            .fileOverride()
                            .outputDir("/Users/janleung/IdeaProjects/x-admin/src/main/java");
                })
                .packageConfig(builder -> {
                        builder.parent("com.lantu")
                                .moduleName(moduleName)
                                .pathInfo(Collections.singletonMap(OutputFile.xml, mapperLocation));
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables)
                            .addTablePrefix("x_");
                })
                        .templateEngine(new FreemarkerTemplateEngine())
                        .execute();
    }
}
