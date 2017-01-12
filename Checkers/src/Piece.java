/**
 * Represents instances of each piece on a checkers board.
 * Each object remembers its color and can return a letter depending on its color, return its color,
 * and check if a movement of a piece is legal whether it is jumping a piece or moving one square. 
 * @author David Nester and Kyle Johnson
 * @version 1.0 Sep 11, 2014.
 */
public class Piece {
	/**
	 * color of piece
	 */
	protected boolean color;

	/**
	 * Creates an instance of class Piece
	 * @param pieceColor true if piece is red and false if piece is black
	 */
	public Piece(boolean piececolor){
		color = piececolor;
	}

	/**
	 * Checks the color and returns the proper letter
	 * @return The string "r" or "b"
	 */
	public String getLetter()
	{

		if (color) {return "r";}
		else if(!color) {return "b";}
		return " ";
	}
	
	/**
	 * Returns a boolean that signifies a color
	 * @return returns true if color is red and false if color is black 
	 */
	public boolean getColor()
	{
		return color;
	}
	
	/**
	 * Checks if move that involves a jump is legal
	 * @param board the array of Square objects that keeps track of locations
	 * @param fromX the x coordinate of the origin square
	 * @param fromY the y coordinate of the origin square
	 * @param toX the x coordinate of the destination square
	 * @param toY the y coordinate of the destination square
	 * @param turn the boolean value that represents which color's turn it is
	 * @return true if move is legal and false if move is illegal
	 */
	public boolean checkMoveJump(Square[][] board, int fromX, int fromY, int toX, int toY, boolean turn)
	{
		if (turn && toY-fromY < 0)
		{
			if(board[(fromX+toX)/2][(fromY+toY)/2].getPiece().getColor() != turn)
			{
				return true;
			}
		}
		else if(!turn && toY-fromY > 0)
		{
			if(board[(fromX+toX)/2][(fromY+toY)/2].getPiece().getColor() != turn)
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if move of one space is legal
	 * @param board the array of Square objects that keeps track of locations
	 * @param fromX the x coordinate of the origin square
	 * @param fromY the y coordinate of the origin square
	 * @param toX the x coordinate of the destination square
	 * @param toY the y coordinate of the destination square
	 * @param turn the boolean value that represents which color's turn it is
	 * @return true if move is legal and false if move is illegal
	 */
	public boolean checkMove(Square[][] board, int fromX, int fromY, int toX, int toY, boolean turn)
	{
		if (turn && toY-fromY < 0)
		{
			return true;
		}
		else if(!turn && toY-fromY > 0)
		{
			return true;
		}
		return false;
	}
}
