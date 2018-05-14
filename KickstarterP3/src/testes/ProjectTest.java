package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import enums.Categories;
import enums.Country;
import projects.Project;

public class ProjectTest {
	Project project;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddCollected() {
		project = new Project("teste", "teste", Categories.COMICS, Country.CANADA, 0, "teste");
		project.addCollected(20);
		project.addCollected(10);
		assertEquals(30, project.getCollected());

	}

}
