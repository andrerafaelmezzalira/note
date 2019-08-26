package note;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import note.terminal.api.MovementApi;
import note.terminal.domain.entity.Terminal;
import note.terminal.service.MovementService;
import note.terminal.service.StockService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoteTest {

	@Mock
	private MovementService movimentServiceMock;

	@Autowired
	private StockService stockService;

	@Autowired
	private MovementService movementService;

	@InjectMocks
	private MovementApi api;

	MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(api).build();
	}

	@Test
	public void testTerminalNotFound() {
		try {
			api.movement("banco", "terminal1", 100);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "credenciais não encontradas");
		}
	}

	@Test
	public void testNotesNotFound() {
		try {
			api.movement("banco1", "terminal1", 1000);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Não foi possível realizar a transferência");
		}
	}

	@Test
	public void testNotesFound() throws Exception {
		assertEquals(stockService.findStockByTerminalAndNoteValue(getTerminal(), 100).getQuantity(), new Integer(1));
		movementService.movement("banco1", "terminal1", 100);
		assertEquals(stockService.findStockByTerminalAndNoteValue(getTerminal(), 100).getQuantity(), new Integer(0));
	}

	private Terminal getTerminal() {
		Terminal terminal = new Terminal();
		terminal.setId(1);
		return terminal;
	}

}
