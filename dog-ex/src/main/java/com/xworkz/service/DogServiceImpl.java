package com.xworkz.service;

import com.xworkz.Exception.DogException;
import com.xworkz.Exception.InvalidDogColourException;
import com.xworkz.Exception.InvalidDogGenderException;
import com.xworkz.Exception.InvalidDogNameException;
import com.xworkz.entity.DogEntity;

public class DogServiceImpl implements DogService{

	boolean flag = false;

	public boolean validateDogEntity(DogEntity dogentity) throws DogException {
		if (dogentity.getName()!= null && !dogentity.getName().isEmpty() && !dogentity.getName().isBlank()) {
			flag = true;
			System.out.println("Name is valid");
		} else {
			flag = false;
			System.out.println("Name is not valid");
			//return flag;
		}

		if (dogentity.getColour() != null && !dogentity.getColour().isEmpty() && !dogentity.getColour().isBlank()) {
			flag = true;
			System.out.println("Colour is valid");
		} else {
            flag=false;
			System.out.println("Colour is not Valid");
			//return flag;
		}
		if (dogentity.getGender() != null && !dogentity.getGender().isEmpty() && !dogentity.getGender().isBlank()) {
			flag = true;
			System.out.println("Gender is valid");
		} else {
			flag = false;
			System.out.println("Gender is not valid");
			//return flag;
		}
		if (dogentity.getWeight()>0) {
			flag = true;
			System.out.println("Weight is valid");
		} else {
			flag = false;
			System.out.println("Weight is not valid");
			//return flag;
		}
		return flag;
	}

	}

