package com.xworkz.service;

import com.xworkz.Exception.DogException;
import com.xworkz.entity.DogEntity;

public interface DogService {
	public boolean validateDogEntity(DogEntity dogentity)throws DogException;
}
