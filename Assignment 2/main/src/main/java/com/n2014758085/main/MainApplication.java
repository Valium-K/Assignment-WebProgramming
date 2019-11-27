package com.n2014758085.main;

import com.n2014758085.main.domain.Basic;
import com.n2014758085.main.domain.Profile;
import com.n2014758085.main.repository.BasicRepository;
import com.n2014758085.main.repository.ProfileRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.stream.IntStream;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(BasicRepository basicRepository, ProfileRepository profileRepository) {
		return (args) -> IntStream.rangeClosed(1, 10).forEach(index -> {

			basicRepository.save(Basic.builder()
					.name("lee")
					.label("student")
					.email("email@email.com")
					.phone(index + "-1234-567")
					.build()
			);

			profileRepository.save(Profile.builder()
					.network("sns")
					.userName("@name")
					.url("https://socialMedia" + index + "/@home")
					.createdAt(LocalDateTime.now())
					.build()
			);
		});
	}
}
