package chess.algebra.matcher;

import java.util.List;

import chess.algebra.Token;
import chess.algebra.Type;
import chess.algebra.UnrecognizableNotationException;
import chess.game.Color;
import chess.game.Move;
import chess.game.Square;

public class LongCastleMatcher implements Matcher {

	private Matcher next;

	@Override
	public Move match(List<Token> input, Color color) throws UnrecognizableNotationException {
		// O-O-O
		if (input.size() == 5 && input.get(0).getType() == Type.CASTLE && input.get(1).getType() == Type.DASH
				&& input.get(2).getType() == Type.CASTLE && input.get(3).getType() == Type.DASH
				&& input.get(3).getType() == Type.CASTLE) {

			Square square = null;

			if (color.equals(Color.BLACK)) {
				square = new Square("c", 8);

			} else {
				square = new Square("c", 1);

			}

			return new Move(color, "K", square);

		}
		if (next == null) {
			throw new UnrecognizableNotationException("Invalid algebraic chess notation: " + getValue(input));
		}
		return next.match(input, color);

	}

	@Override
	public void setNext(Matcher matcher) {
		this.next = matcher;
	}
}
