package com.app.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.dao.UserDao;
import com.app.entities.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserDaoTests {
	@Autowired
	private UserDao userDao;

	@Test
	void testUserInsertion() {
		List<User> users = List.of(new User("Nikhil573", "nik@email.com", "nik123", "Pune", "9075856965"),
				new User("Rohit629", "rohit@email.com", "roh123", "Jalgaon", "9922871190"),
				new User("Yogi1011", "yogi@email.com", "yog123", "Nashik", "8390323096"),
				new User("Sangita111", "sangita@email.com", "san123", "Pachora", "8624909604"));

		List<User> list = userDao.saveAll(users);

		assertEquals(4, list.size());

	}
}
