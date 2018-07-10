package DAO;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.Person;

public class PersonDAOTest {

	@Test
	public void test() throws Exception {
		Person p = new Person();
		p.setUsername("ÐìÎ°");
		PersonDAOImp dao = new PersonDAOImp();
		System.out.println(dao.save(p));
	}

}
