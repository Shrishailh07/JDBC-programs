package com.xworkz.dao;

import java.util.List;
import javax.persistence.RollbackException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import com.xworkz.entity.DogEntity;
import com.xworkz.sessionfactoryp.*;

@Component
public class DogDAOImpl implements DogDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public void savedog(DogEntity dogentity) {
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			session.persist(dogentity);
			transaction.commit();
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		} catch (NullPointerException n) {
		}
	}

	@Override
	public void getDogId(int id) {
		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {

			DogEntity d1 = session.find(DogEntity.class, id);
			System.out.println("The Dog Name is " + d1.getName());
//		Transaction transaction = session.beginTransaction();		
//		transaction.commit();
		} catch (IllegalArgumentException i) {
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		}
	}

	@Override
	public void update() {
		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			DogEntity db = session.get(DogEntity.class, 5);
			db.setName("chetan");
			transaction.commit();
		} catch (IllegalArgumentException i) {
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		}
	}

	@Override
	public void delete() {
		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			;
			DogEntity dk = session.find(DogEntity.class, 10);
			session.remove(dk);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			session.close();
		} catch (IllegalArgumentException i) {
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		}
	}

	@Override
	public void getDogDetails() {
		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
//			String dog = "from DogEntity";
//			Query query =session.createQuery(dog);
			Query query = session.getNamedQuery("getDogDetailsHQL");
			List l = query.list();
			System.out.println(l);
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		} catch (NullPointerException n) {
		}
	}

	@Override
	public void countDogs() {
		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
//			String count ="from DogEntity";
//			Query query = session.createQuery(count);
			Query query = session.getNamedQuery("countDogsHQL");
			List l = query.list();
			System.out.println("Total dogs =" + l.size());
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		} catch (NullPointerException n) {
		}
	}

	@Override
	public void maxWeight() {
		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
//			String max="select max(weight)from DogEntity";
//			Query query = session.createQuery(max);
			Query query = session.getNamedQuery("maxWeightHQL");
			Object l = query.uniqueResult();
			System.out.println(l);
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		} catch (NullPointerException n) {
		}
	}

	@Override
	public void minWeight() {
		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			// String min = "select min(weight)from DogEntity ";
			// Query query = session.createQuery("min");
			Query query = session.getNamedQuery("minWeightHQL");
			Object k = query.uniqueResult();
			System.out.println(k);
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		} catch (NullPointerException n) {
		}
	}

	@Override
	public void avgWeight() {
		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
//			String avg ="select avg(weight)from DogEntity ";
//			Query query = session.createQuery(avg);
			Query query = session.getNamedQuery("avgWeightHQL");
			Object m = query.uniqueResult();
			System.out.println(m);
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		} catch (NullPointerException n) {
		}
	}

	@Override
	public void sumOfWeight() {
		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
//			String sum ="select sum(weight)from DogEntity";
//			Query query = session.createQuery(sum);
			Query query = session.getNamedQuery("sumOfWeightHQL");
			Object s = query.uniqueResult();
			System.out.println(s);
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		} catch (NullPointerException n) {
		}
	}

	@Override
	public void nameStartsWith() {
		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			// String start ="select name from DogEntity where name LIKE 'C%'";
			// Query query = session.createQuery(start);
			Query query = session.getNamedQuery("nameStartsWithHQL");
			Object s = query.list();
			System.out.println(s);
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		} catch (NullPointerException n) {
		}
	}

	@Override
	public void nameEndsWith() {
		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			// String end ="select name from DogEntity where name LIKE '%y'";
			// Query query = session.createQuery(end);
			Query query = session.getNamedQuery("nameEndsWithHQL");
			Object s = query.list();
			System.out.println(s);
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		} catch (NullPointerException n) {
		}
	}

	@Override
	public void weightBetweenDogs() {
		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			// String betn = "from DogEntity where weight BETWEEN 30 and 65";
			// Query q = session.createQuery(betn);
			Query query = session.getNamedQuery("weightBetweenDogsHQL");
			List l = query.list();
			System.out.println(l);
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		} catch (NullPointerException n) {
		}

	}

	@Override
	public void updateColourByName(String colour, String name) {
		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			Query query = session.getNamedQuery("updateColourByNameHQL");
			query.setParameter("a", colour);
			query.setParameter("b", name);
			int noOfRowsAffected = query.executeUpdate();
			System.out.println(noOfRowsAffected);
			System.out.println("updateColourByName");
			transaction.commit();
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		} catch (NullPointerException n) {
		}
	}

	@Override
	public void updateNameByWeight(String name, int weight) {
		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
//     String str = "UPDATE DogEntity set name='"+name+"' where weight ='"+weight+"'";
//     Query query = session.createQuery(str);
			Query query = session.getNamedQuery("updatingbyweightHQL");
			query.setParameter("x", name);
			query.setParameter("y", weight);
			query.executeUpdate();
			transaction.commit();
			System.out.println("üpdated by weight");
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		} catch (NullPointerException n) {
		}
	}

//	@Override
//	public void insertNewDog() {
//		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
//		try (Session session = sessionFactory.openSession()) {
//			Transaction transaction = session.beginTransaction();
//			String str = "(InSerT into DogEntity (7,'Chetan','yellow','male',100)SeLeCt id,name,colour,gender,weight from DogEntity)";
//			Query query = session.createQuery(str);
//			Object result = query.executeUpdate();
//			System.out.println(result);
//			transaction.commit();
//		} catch (HibernateException e) {
//		} catch (RollbackException r) {
//		} catch (NullPointerException n) {
//	}

	@Override
	public void deleteByColour(String colour) {
		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			// String wtf = "DeLeTe from DogEntity wheRe colour='"+colour+"' ";
			// Query query = session.createQuery(wtf);
			Query query = session.getNamedQuery("deleteByColourHQL");
			query.setParameter("m", colour);
			query.executeUpdate();
			System.out.println("deleteByColour");
			transaction.commit();
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		} catch (NullPointerException n) {
		}
	}

	@Override
	public void getDogsByGender(String gender) {
		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
//			String gen = "froM DogEntity where gender='"+gender+"'";
//			Query query = session.createQuery(gen);
			Query query = session.getNamedQuery("ByGenderHQL");
			query.setParameter("g", gender);
			List obj = query.list();
			System.out.println(obj);
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		} catch (NullPointerException n) {
		}
	}

	@Override
	public void duplicatesByGender() {
		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			// String sop = "SeLecT DisTincT gender from DogEntity";
			// Query query = session.createQuery(sop);
			Query query = session.getNamedQuery("duplicatesByGenderHQL");
			List res = query.list();
			System.out.println(res);
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		} catch (NullPointerException n) {
		}
	}

	@Override
	public void getByWeightandId() {
		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			// String st = "from DogEntity wHere weight=40 AnD id=4";
			// Query query = session.createQuery(st);
			Query query = session.getNamedQuery("getByWeightandIdHQL");
			Object result = query.uniqueResult();
			System.out.println(result);
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		} catch (NullPointerException n) {
		}
	}

	@Override
	public void getByNameOrColour() {
		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			// String stop = "FRom DogEntity wherE name='PInKy' oR colour='pInk'";
			// Query query = session.createQuery(stop);
			Query query = session.getNamedQuery("getByNameOrColourHQL");
			Object result = query.uniqueResult();
			System.out.println(result);
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		} catch (NullPointerException n) {
		}
	}

	@Override
	public void dogContainsLetter() {
		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			// String n = "from DogEntity where name LiKe '%N%'";
			// Query query =session.createQuery(n);
			Query query = session.getNamedQuery("dogContainsLetterHQL");
			List result = query.list();
			System.out.println(result);
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		} catch (NullPointerException n) {
		}
	}

	@Override
	public void orderByWeight() {
		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			// String orm = "from DogEntity order by weight";
			// Query query = session.createQuery(orm);
			Query query = session.getNamedQuery("orderByWeightHQL");
			Object result = query.list();
			System.out.println(result);
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		} catch (NullPointerException n) {
		}
	}

	@Override
	public void orderByName() {
		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			// String orm = "from DogEntity order by name";
			// Query query = session.createQuery(orm);
			Query query = session.getNamedQuery("orderByNameHQL");
			List result = query.list();
			System.out.println(result);
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		} catch (NullPointerException n) {
		}
	}

	@Override
	public void orderByIdDesc() {
		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			// String orm = "from DogEntity order by id desc";
			// Query query = session.createQuery(orm);
			org.hibernate.Query query = session.getNamedSQLQuery("orderByIdDescHQL");
			List result = query.list();
			System.out.println(result);
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		} catch (NullPointerException n) {
		}
	}
                                                                                                                                                                                                                 
	@Override
	public void orderByColourDesc() {
		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			// String orm = "from DogEntity orDer bY colour desc";
			// Query query = session.createQuery(orm);
			Query query = session.getNamedQuery("orderByColourDescHQL");
			List result = query.list();
			System.out.println(result);
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		} catch (NullPointerException n) {
		}
	}

	@Override
	public void weightGreaterthan() {
		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			// String mj="from DogEntity where weight>50";
			// Query query = session.createQuery(mj);
			Query query = session.getNamedQuery("weightGreaterthanHQL");
			List result = query.list();
			System.out.println(result);
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		} catch (NullPointerException n) {
		}
	}

	@Override
	public void weightLesserthan() {
		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			// String mj="from DogEntity where weight<55";
			// Query query = session.createQuery(mj);
			Query query = session.getNamedQuery("DogEntity.weightLesserthanHQL");
			List result = query.list();
			System.out.println(result);
		} catch (HibernateException e) {
		} catch (RollbackException r) {
		} catch (NullPointerException n) {
		}
	}

//	@Override
//	public void findSecondHighest() {
//		SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
//		try (Session session = sessionFactory.openSession()) {
//			String sec="Select top(1) weight from(select top(2) weight from DogEntity order by weight desc)order by weight asc";
//			Query query = session.createQuery(sec);
//			Object wt = query.uniqueResult();
//			System.out.println(wt);
//		} catch (HibernateException e) {
//		} catch (RollbackException r) {
//		} catch (NullPointerException n) {
//	}					
}
