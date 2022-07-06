package com.xworkz.doggy;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.xworkz.dao.DogDAO;
import com.xworkz.dao.DogDAOImpl;
import com.xworkz.dao.DogDAOImplSQL;
import com.xworkz.entity.DogEntity;

public class Tester {

	public static void main(String[] args) {

		// dog dg = new dog(3,"i","black","female");
		
//		impl.getDogId(2);
//		impl.update();
//		impl.delete();
//		impl.getDogDetails();
//		impl.countDogs();
//		impl.maxWeight();
//		impl.minWeight();
//		impl.avgWeight();
//		impl.sumOfWeight();
//		impl.nameStartsWith();
//		impl.nameEndsWith();
//		impl.weightBetweenDogs();
//		impl.updateColourByName("White", "Ganesh");
//		impl.updateNameByWeight("Simbha", 87);
//		impl.insertNewDog();
//		impl.deleteByColour("chocolate");
//		impl.getDogsByGender("male");
//		impl.duplicatesByGender();
//		impl.getByWeightandId();
//		impl.getByNameOrColour();
//		impl.dogContainsLetter();
//		impl.orderByWeight();
//		impl.orderByName();
//		impl.orderByIdDesc();
//		impl.orderByColourDesc();
//		impl.weightGreaterthan();
//		impl.weightLesserthan();
//      impl.findSecondHighest();

//		DogDAOImplSQL sql = new DogDAOImplSQL();
//		sql.getDogDetails();
//		sql.countDogs();
//		sql.maxWeight();
//		sql.minWeight();
//		sql.avgWeight();
//		sql.sumOfWeight();
//		sql.nameStartsWith();
//		sql.nameEndsWith();
//		sql.weightBetweenDogs();
//		sql.updateColourByName("Saffron", "Ganesh");
//		sql.updateNameByWeight("Jhonny", 87);
//		sql.deleteByColour("chocolate");
//		sql.getDogsByGender("female");
//		sql.duplicatesByGender();
//		sql.getByWeightandId();
//		sql.getByNameOrColour();
//		sql.dogContainsLetter();
//		sql.orderByWeight();
//		sql.orderByName();
//		sql.orderByIdDesc();
//		sql.orderByColourDesc();
//		sql.weightGreaterthan();
//		sql.weightLesserthan();
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
		DriverManagerDataSource dataSource = (DriverManagerDataSource)context.getBean("datasource");
		 DogDAOImpl impl = context.getBean(DogDAOImpl.class);
		 DogEntity dog = new DogEntity();
		 dog.setName("Gani");
		 dog.setGender("male");
		 dog.setWeight(28);
		 dog.setColour("white");
		 impl.savedog(dog);
		 System.out.println("Saved successfully");
	}
}
