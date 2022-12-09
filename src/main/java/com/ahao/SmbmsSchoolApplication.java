package com.ahao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ahao.mapper")
public class SmbmsSchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmbmsSchoolApplication.class, args);
    }
}
