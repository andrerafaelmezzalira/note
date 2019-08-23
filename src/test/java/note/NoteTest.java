package note;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import note.service.MovementService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoteTest {

	@Autowired
	private MovementService service;

	@Test
	public void test() {

		for (int i = 0; i <= 1000; i++) {
			try {
				service.movement(104, 1, i);
			} catch (Exception e) {
			}
		}
		System.err.println();
	}
}
