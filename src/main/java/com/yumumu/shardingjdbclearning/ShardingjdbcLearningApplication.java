package com.yumumu.shardingjdbclearning;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.yumumu.shardingjdbclearning.user.dao")
@MapperScans({@MapperScan("com.yumumu.shardingjdbclearning.user.dao"),
		@MapperScan("com.yumumu.shardingjdbclearning.ship.dao"),
		@MapperScan("com.yumumu.shardingjdbclearning.userLog.dao"),
		@MapperScan("com.yumumu.shardingjdbclearning.dictionary.dao")})
public class ShardingjdbcLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShardingjdbcLearningApplication.class, args);
	}

}
