package com.xworkz.entity;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@Table(name="Dog")
@NamedQuery(name = "getDogDetailsHQL",query = "from DogEntity")
@NamedQuery(name = "countDogsHQL",query = "from DogEntity")
@NamedQuery(name = "maxWeightHQL",query = "select max(weight)from DogEntity ")
@NamedQuery(name = "minWeightHQL",query = "select min(weight)from DogEntity ")
@NamedQuery(name = "avgWeightHQL",query = "select avg(weight)from DogEntity ")
@NamedQuery(name = "sumOfWeightHQL",query = "select sum(weight)from DogEntity ")
@NamedQuery(name = "nameStartsWithHQL",query = "select name from DogEntity where name LIKE 'C%'")
@NamedQuery(name = "nameEndsWithHQL",query = "select name from DogEntity where name LIKE '%y'")
@NamedQuery(name = "weightBetweenDogsHQL",query = "from DogEntity where weight BETWEEN 30 and 65")
@NamedQuery(name = "updateColourByNameHQL",query = "UPDATE DogEntity set colour=:a where name=:b")
@NamedQuery(name = "updatingbyweightHQL",query = "UPDATE DogEntity set colour=:x where name=:y")
@NamedQuery(name = "deleteByColourHQL",query = "DeLeTe from DogEntity wheRe colour=:m")
@NamedQuery(name = "ByGenderHQL",query = "from DogEntity where gender=:g")
@NamedQuery(name = "duplicatesByGenderHQL",query = "SeLecT DisTincT gender from DogEntity")
@NamedQuery(name = "getByWeightandIdHQL",query = "from DogEntity wHere weight=40 AnD id=4")
@NamedQuery(name = "getByNameOrColourHQL",query = "FRom DogEntity wherE name='PInKy' oR colour='pInk'")
@NamedQuery(name = "dogContainsLetter",query = "from DogEntity where name LiKe '%N%'")
@NamedQuery(name = "orderByWeightHQL",query = "from DogEntity order by weight")
@NamedQuery(name = "orderByNameHQL",query = "from DogEntity order by name")
@NamedQuery(name = "orderByIdDescHQL",query = "from DogEntity order by id desc")
@NamedQuery(name = "orderByColourDescHQL",query = "from DogEntity orDer bY colour desc")
@NamedQuery(name = "weightGreaterthanHQL",query = "from DogEntity where weight>50")
@NamedQuery(name = "DogEntity.weightLesserthanHQL",query = "from DogEntity where weight<55")


@NamedNativeQuery(name = "getDogDetailsSQL",query = "select * from dogdb.Dog")
@NamedNativeQuery(name = "countDogsSQL",query = "select * from Dog")
@NamedNativeQuery(name = "maxWeightSQL",query = "select max(weight)from Dog ")
@NamedNativeQuery(name = "minWeightSQL",query = "select min(weight)from Dog ")
@NamedNativeQuery(name = "avgWeightSQL",query = "select avg(weight)from Dog ")
@NamedNativeQuery(name = "sumOfWeightSQL",query = "select sum(weight)from Dog ")
@NamedNativeQuery(name = "nameStartsWithSQL",query = "select name from Dog where name LIKE 'C%'")
@NamedNativeQuery(name = "nameEndsWithSQL",query = "select name from Dog where name LIKE '%y'")
@NamedNativeQuery(name = "weightBetweenDogsSQL",query = "select * from dogdb.Dog where weight BETWEEN 30 and 65")
@NamedNativeQuery(name = "updateColourByNameSQL",query = "UPDATE Dog set colour=:a where name=:b")
@NamedNativeQuery(name = "updatingnamebyweightSQL",query = "UPDATE Dog set name=:x where weight=:y")
@NamedNativeQuery(name = "deleteByColourSQL",query = "DeLeTe from Dog wheRe colour=:m")
@NamedNativeQuery(name = "ByGenderSQL",query = "select * from Dog where gender=:g")
@NamedNativeQuery(name = "duplicatesByGenderSQL",query = "SeLecT DisTincT gender from Dog")
@NamedNativeQuery(name = "getByWeightandIdSQL",query = "select * from Dog wHere weight=40 AnD dog_id=4")
@NamedNativeQuery(name = "getByNameOrColourSQL",query = "select * FRom Dog wherE name='PInKy' oR colour='pInk'")
@NamedNativeQuery(name = "dogContainsLetterSQL",query = "select name from Dog where name LIKE '%N%'")
@NamedNativeQuery(name = "orderByWeightSQL",query = "select * from dogdb.Dog order by weight")
@NamedNativeQuery(name = "orderByNameSQL",query = "select * from dogdb.Dog order by name")
@NamedNativeQuery(name = "orderByIdDescSQL",query = "select * from dogdb.Dog order by dog_id desc")
@NamedNativeQuery(name = "orderByColourDescSQL",query = "select * from dogdb.Dog orDer bY colour desc")
@NamedNativeQuery(name = "weightGreaterthanSQL",query = "select * from Dog where weight>50")
@NamedNativeQuery(name = "DogEntity.weightLesserthanSQL",query = "select * from Dog where weight<55")
@NamedNativeQuery(name = "weightLesserthanSQL",query = "select * from Dog where weight<55")
@NamedNativeQuery(name = "DogEntity.weightGreaterthanSQL" ,query=" select * from Dog where weight>50")
public class DogEntity {

		@Id
		@Column(name="dog_id")
	    
	    @GenericGenerator(name="x",strategy = "increment")
		@GeneratedValue(generator ="x")
		private int id;
		@Column(name="name")
		private String name;
		@Column(name="colour")
		private String colour;
		@Column(name="gender")
		private String gender;
		@Column(name="weight")
		private int weight;
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getColour() {
			return colour;
		}

		public void setColour(String colour) {
			this.colour = colour;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public DogEntity() {
			super();
		}

		

	
		public DogEntity(int id, String name, String colour, String gender, int weight) {
			super();
			this.id = id;
			this.name = name;
			this.colour = colour;
			this.gender = gender;
			this.weight = weight;
		}

		
		public DogEntity(String name, String colour, String gender, int weight) {
			super();
			this.name = name;
			this.colour = colour;
			this.gender = gender;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "DogEntity [id=" + id + ", name=" + name + ", colour=" + colour + ", gender=" + gender + ", weight="
					+ weight + "]";
		}
		
		
		
		
		
}
