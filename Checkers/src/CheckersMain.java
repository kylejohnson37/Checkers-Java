/**
 * Maintains the board object by creating the pieces and assigning the pieces to their positions
 * @author David Nester and Kyle Johnson
 * @version 1.0 Sep 11, 2014.
 */
public class CheckersMain {
	public Square checkersBoard[][]=new Square[8][8];

	/**
	 * Creates the empty board using a for loop and sets the pieces in their starting positions
	 * @param filled tells the method to print the board
	 */
	public CheckersMain(boolean filled)
	{
		for (int i = 0; i<8; i++){
			for (int j = 0; j<8; j++){
				checkersBoard[i][j] = new Square(i,j,null);
			}
		}

		checkersBoard[0][0].setPiece(new Piece(false));
		checkersBoard[0][2].setPiece(new Piece(false));
		checkersBoard[0][4].setPiece(new Piece(false));
		checkersBoard[0][6].setPiece(new Piece(false));
		checkersBoard[1][1].setPiece(new Piece(false));
		checkersBoard[1][3].setPiece(new Piece(false));
		checkersBoard[1][5].setPiece(new Piece(false));
		checkersBoard[1][7].setPiece(new Piece(false));
		checkersBoard[2][0].setPiece(new Piece(false));
		checkersBoard[2][2].setPiece(new Piece(false));
		checkersBoard[2][4].setPiece(new Piece(false));
		checkersBoard[2][6].setPiece(new Piece(false));

		checkersBoard[5][1].setPiece(new Piece(true));
		checkersBoard[5][3].setPiece(new Piece(true));
		checkersBoard[5][5].setPiece(new Piece(true));
		checkersBoard[5][7].setPiece(new Piece(true));
		checkersBoard[6][0].setPiece(new Piece(true));
		checkersBoard[6][2].setPiece(new Piece(true));
		checkersBoard[6][4].setPiece(new Piece(true));
		checkersBoard[6][6].setPiece(new Piece(true));
		checkersBoard[7][1].setPiece(new Piece(true));
		checkersBoard[7][3].setPiece(new Piece(true));
		checkersBoard[7][5].setPiece(new Piece(true));
		checkersBoard[7][7].setPiece(new Piece(true));

	}		
	/**
	 * Prints the checkersBoard with each Piece in its position
	 */
	public void printCheckersBoard() 
	{		
		for(int row = 0; row < 8; row++)
		{
			System.out.println("|___|___|___|___|___|___|___|___|");
			for (int col = 0; col < 8; col++)
			{
				System.out.print("| ");
				if (checkersBoard[row][col].getPiece() == null)
				{
					System.out.print(" ");
				}
				else
				{
					System.out.print(checkersBoard[row][col].getPiece().getLetter());
				}
				System.out.print(" ");
			}				
			System.out.print("| ");
			System.out.println(row);
		}
		System.out.println("|___|___|___|___|___|___|___|___|");
		System.out.println("  0   1   2   3   4   5   6   7");

	}
	
	/**
	 * Checks whether a move could be valid by doing broad tests before it gets passed to the piece
	 * @param board the array of Square objects that keeps track of locations
	 * @param fromX the x coordinate of the origin square
	 * @param fromY the y coordinate of the origin square
	 * @param toX the x coordinate of the destination square
	 * @param toY the y coordinate of the destination square
	 * @param turn the boolean value that represents which color's turn it is
	 * @return whether the move is legal or not
	 */	
	public boolean checkMove(Square[][] board, int fromX, int fromY, int toX, int toY, boolean turn)
	{
		if (!inRange(toX) || !inRange(toY) || !inRange(fromX) || !inRange(fromY))
		{
			return false; 
		}

		else if(fromX==toX || fromY==toY)
		{
			return false;
		}
		else if(board[fromX][fromY].getPiece() == null)
		{
			return false;
		}
		else if(board[fromX][fromY].getPiece().getColor() != turn)
		{
			return false;
		}
		else if(board[fromX][fromY].getPiece() == null)
		{
			return false;
		}
		return true;
	}
	
	/**
	 * Checks that the value is in a range that would be on the board
	 * @param value the coordinate value that is being checked 
	 * Copied from chess project from David's Bluffton University program
	 */
	//Copied from chess project from David's Bluffton University program
	public boolean inRange(int value)
	{
		return 0 <= value && value < 8;  
	}




}
