package chess.algebra.matcher;

import java.util.List;

import chess.algebra.Type;
import chess.algebra.UnrecognizableNotationException;
import chess.game.Color;
import chess.game.Move;
import chess.game.Square;
import chess.algebra.Token;

public class PawnMoveMatcher implements Matcher {

	private Matcher next;
	
	@Override
	public Move match(List<Token> input,  Color color) throws UnrecognizableNotationException {
		// e4
		if (input.size() == 2 && 
				input.get(0).getType() == Type.FILE &&
				input.get(1).getType() == Type.RANK ){
			
			Square square = new Square(input.get(0).getValue(), Integer.valueOf(input.get(1).getValue()));
			
			return new Move(color,"", square);
		
		}
		else  {
			if (next == null) {
					throw new UnrecognizableNotationException("Invalid algebraic chess notation.");
			}
			return next.match(input, color);
		}
	}

	@Override
	public void setNext(Matcher matcher) {
		this.next = matcher;
	}

}
