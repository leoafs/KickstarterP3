package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import enums.Categories;
import enums.Country;
import projects.Project;
import system.Database;
import users.Admin;
import users.User;

public class DatabaseTest {
	Database database;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		database = new Database();
		User adm = new Admin("Carlos", "chta@ic.ufal.br", "password");
		assertEquals(adm.getName(), database.getUsers().get(0).getName());
		assertEquals(adm.getEmail(), database.getUsers().get(0).getEmail());
		assertEquals(adm.getPassword(), database.getUsers().get(0).getPassword());
	}

}
