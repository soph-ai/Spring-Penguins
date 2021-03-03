package com.qa.penguins;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.qa.penguins.domain.Penguin;
import com.qa.penguins.rest.PenguinController;

@SpringBootApplication
public class SpringPenguinsApplication {

	@Bean
	public List<Penguin> makeListBean() {
		List<Penguin> penguins = new ArrayList<>();
		penguins.add(new Penguin("Oswald Cobblepot", 62, 0, 78));
		return penguins;
	}

	public static void main(String[] args) {
		ApplicationContext beanBag = SpringApplication.run(SpringPenguinsApplication.class, args);
		// VERY DODGEY - DO NOT PUT IN PROJECT!!111!!!!1
		PenguinController pc = beanBag.getBean(PenguinController.class);
		System.out.println(pc);
//
//		List<Penguin> arrayList = new ArrayList<>();
//		PenguinController withAnArrayList = new PenguinController(arrayList);
//
//		List<Penguin> linkedList = new LinkedList<>();
//		PenguinController withALinkedList = new PenguinController(linkedList);
	}

}
