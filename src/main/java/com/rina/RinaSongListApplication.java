package com.rina;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author arvin
 */
@SpringBootApplication
@MapperScan("com.rina.mapper")
public class RinaSongListApplication {

	public static void main(String[] args) {
		SpringApplication.run(RinaSongListApplication.class, args);
	}

}
