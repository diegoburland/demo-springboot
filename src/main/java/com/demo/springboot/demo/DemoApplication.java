package com.demo.springboot.demo;

import com.demo.springboot.demo.bean.MyBean;
import com.demo.springboot.demo.bean.MyBeanWithDependency;
import com.demo.springboot.demo.bean.MyBeanWithProperties;
import com.demo.springboot.demo.component.ComponentDependency;
import com.demo.springboot.demo.entity.User;
import com.demo.springboot.demo.pojo.UserPojo;
import com.demo.springboot.demo.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(DemoApplication.class);
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;

	public DemoApplication(
			@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository) {
		this.myBean = myBean;
		this.componentDependency = componentDependency;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		saveUsersInDataBase();
		getInformationJpqlFromUser();
	}

	private void getInformationJpqlFromUser(){
		User result = userRepository.findByUserEmail("robert@gmail.com").orElseThrow(
				() -> new RuntimeException("No se encontro el usuario")
		);
		LOGGER.info("El usuario con el metodo find" + result);
	}

	private void saveUsersInDataBase(){
		User user1 = new User("John", "john@gmail.com", LocalDate.of(2000, Month.JANUARY, 5));
		User user2 = new User("Maria", "maria@gmail.com", LocalDate.of(2001, Month.MAY, 5));
		User user3 = new User("Robert", "robert@gmail.com", LocalDate.of(1999, Month.AUGUST, 12));
		User user4 = new User("Sarah", "sarah@yahoo.com", LocalDate.of(1998, Month.DECEMBER, 23));
		User user5 = new User("Adam", "adam@hotmail.com", LocalDate.of(1997, Month.MARCH, 15));
		User user6 = new User("Jennifer", "jennifer@gmail.com", LocalDate.of(2002, Month.OCTOBER, 8));
		User user7 = new User("David", "david@yahoo.com", LocalDate.of(2003, Month.JULY, 29));
		User user8 = new User("Emily", "emily@gmail.com", LocalDate.of(1996, Month.SEPTEMBER, 17));
		User user9 = new User("Jacob", "jacob@hotmail.com", LocalDate.of(1995, Month.NOVEMBER, 3));
		User user10 = new User("Olivia", "olivia@yahoo.com", LocalDate.of(2004, Month.JUNE, 19));

		List<User> list = List.of(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10);
		list.stream().forEach(userRepository::save);

	}

	public void ejemplosAnteriores (){
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + " " + userPojo.getPassword() + " " + userPojo.getAge());
		LOGGER.error("Esto es un error");
	}


}
