/**
 * Represets one of the 64 squares on the checkers board. 
 * It remembers its position on the x axis and its position on
 * the y axis and an instance of the Piece class that is on the square.
 * @author David Nester and Kyle Johnson
 * @version 1.0 Sep 11, 2014.
 */
public class Square {
	
	/**
	 * x coordinate on board
	 */
	private int xpos;
	
	/**
	 * y coordinate on board
	 */
	private int ypos;
	
	/**
	 * instance of Piece on square
	 */
	private Piece piece;

	/**
	 * Creates and instance of the Square class
	 * @param x the x position on the board
	 * @param y the y position on the board
	 * @param p the instance of Piece on the Square
	 */
	public Square(int x, int y, Piece p)
	{
		xpos = x;
		ypos = y;
		piece = p;
	}

	/**
	 * Returns the x coordinate of the square
	 * @return and integer between 0 and 7 that is the x coordinate
	 */
	public int getx()
	{
		return xpos;
	}

	/**
	 * Returns the y coordinate of the square
	 * @return the integer between 0 and 7 that is the y coordinate
	 */
	public int gety()
	{
		return ypos;
	}
	/**
	 * Returns the instance of Piece on the square
	 * @return the instance of Piece
	 */
	public Piece getPiece()
	{
		if (piece == null)
		{
			return null;
		}
		return piece;
	}
	/**
	 * Sets the instance of Piece on the Square
	 * @param p the instance of Piece that is set to the square
	 */
	public void setPiece(Piece p)
	{
		piece = p;
	}
}
