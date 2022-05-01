package com.xworkz.clothes.tester;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	import com.xworkz.clothes.dao.ClothesDAO;
	import com.xworkz.clothes.entity.ClothesEntity;
	import com.xworkz.clothes.impl.ClothesImpl;

	public class ClothesTester {
		public static void main(String[] args) throws ParseException {
			ClothesEntity clothesEntity = new ClothesEntity();
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy");
			Date date = null;
				clothesEntity.setId(2);
				clothesEntity.setBrand("puma");
				clothesEntity.setPrice(700.00);
				date=dateFormat.parse("1998");
				clothesEntity.setYear(date);
				
				ClothesDAO clothesDAO=new ClothesImpl();
//				clothesDAO.saveClothes(clothesEntity);
//				System.out.println("saved successfully");
				
//				updateClotheBrandAndPriceById(String brand, double price, int id)
//				clothesDAO.getClothesById(3);
//				System.out.println(clothesEntity.toString());
//				System.out.println("successfully getched");
				
//				public void updateClotheBrandAndPriceById(String brand,double price,int id)
//				clothesDAO.updateClotheBrandAndPriceById("jockey",4983.78 , 1);
//				System.out.println("successfully updated");
			
//				public void deleteById(int id)
//				clothesDAO.deleteById(2);
//				System.out.println("succesfully deleted");
	
//				public void updatemanufacturedYearById(Date manufacturedYear,int id);
				date=dateFormat.parse("2022");
				clothesDAO.updatemanufacturedYearById(date, 2);
				System.out.println("updated successgully");	
		}
	}

