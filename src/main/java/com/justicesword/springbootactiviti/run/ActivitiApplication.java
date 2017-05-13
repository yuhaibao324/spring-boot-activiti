package com.justicesword.springbootactiviti.run;

import com.justicesword.springbootactiviti.dao.CompRepository;
import com.justicesword.springbootactiviti.dao.PersonRepository;
import com.justicesword.springbootactiviti.model.Comp;
import com.justicesword.springbootactiviti.model.Person;
import com.justicesword.springbootactiviti.service.ActivitiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JusticeSword on 2017/05/14.
 */
@RestController
@SpringBootApplication
@ComponentScan("com.justicesword.springbootactiviti")
@EnableJpaRepositories("com.justicesword.springbootactiviti.dao")
@EntityScan("com.justicesword.springbootactiviti.model")
public class ActivitiApplication  implements EmbeddedServletContainerCustomizer{

	@Autowired
	private CompRepository compRepository;
	@Autowired
	private PersonRepository personRepository;

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {

		container.setPort(8081);
	}

	@RequestMapping("/debug")
	public String testPort() {

		return "Hello 端口8081......";
	}

	public static void main(String[] args) {
		System.out.println("start project.");
		SpringApplication.run(ActivitiApplication.class, args);
	}

	// 初始化模拟数据
	@Bean
	public CommandLineRunner init(final ActivitiService myService) {
		return new CommandLineRunner() {
			public void run(String... strings) throws Exception {
				if (personRepository.findAll().size() == 0) {
					personRepository.save(new Person("wtr"));
					personRepository.save(new Person("wyf"));
					personRepository.save(new Person("admin"));
				}
				if (compRepository.findAll().size() == 0) {
					Comp group = new Comp("great company");
					compRepository.save(group);
					Person admin = personRepository.findByPersonName("admin");
					Person wtr = personRepository.findByPersonName("wtr");
					admin.setComp(group);
					wtr.setComp(group);
					personRepository.save(admin);
					personRepository.save(wtr);
				}
			}
		};
	}
}