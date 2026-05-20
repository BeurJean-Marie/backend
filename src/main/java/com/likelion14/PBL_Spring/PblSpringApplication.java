package com.likelion14.PBL_Spring;

import com.likelion14.PBL_Spring.member.service.MemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PblSpringApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(PblSpringApplication.class, args);

		MemberService service = context.getBean(MemberService.class);
		System.out.println("서비스 가져오기 성공: " + service);

		System.out.println("=== 등록된 Bean 목록 ===");
		for (String name : context.getBeanDefinitionNames()) {
			System.out.println("Bean: " + name);
		}
	}
}
