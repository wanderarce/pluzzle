package pluzzle.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EngineTest {

	@Test
	public void initDataTest() {
		Engine engine =new Engine();
		int size = engine.buttons.size();
		assertEquals(9, size);
	}
}
