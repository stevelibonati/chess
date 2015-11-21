package chess.pgn;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

public class StringTokenLexerTest {
	private Lexer lexer;
	private StringTokenLexer stringTokenLexer;

	@Before
	public void before() {
		lexer = new Lexer();
		stringTokenLexer = new StringTokenLexer();
	}

	@Test
	public void testLex() throws Exception {

		String fischeStein1967 = FileUtils.readFileToString(new File(
				"./src/test/resources/fischer_stein_1967.pgn"));

		assertNotNull(fischeStein1967);
		List<Token> tokens = null;

		tokens = lexer.lex(fischeStein1967);

		assertFalse(tokens.isEmpty());
		
		
		tokens = stringTokenLexer.lex(tokens);

		for (Token token : tokens) {
			System.out.println(token.getType());
		}

	}

}
