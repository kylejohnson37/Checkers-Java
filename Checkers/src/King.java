/**
 * The king class is a subclass of the Piece class. The differences are 
 * that the getLetter() method returns upper case letters instead of lower case
 * letters and the checkMove() and checkMoveJump() methods do not have lines that
 * check if the pieces are moving in the right direction for their color.
 * @author David Nester and Kyle Johnson
 * @version 1.0 Sep 11, 2014.
 */
public class King extends Piece{

	/**
	 * Creates King using constructor of super class Piece
	 * @param color true = red or false = black
	 */
	public King(boolean c)
	{
		super(c);
		this.color = c; 
	}

	/**
	 * Checks the color and returns the proper letter
	 * @return The string "R" or "B"
	 */
	public String getLetter()
	{
		if (color) {return "R";}
		else if(!color) {return "B";}
		return " ";

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
		if(board[(fromX+toX)/2][(fromY+toY)/2].getPiece().getColor() != turn)
		{
			return true;
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
		return true;
	}
}
