import java.util.Scanner;

/**
 * Runs the checkers game interface and implements the rules.
 * This class displays the board, asks for input, changes the
 * board, checks for winers, and keeps track of the winners.
 * @author David Nester and Kyle Johnson
 * @version 1.0 Sep 11, 2014.
 */
public class CheckersPlayer 
{
	/**
	 * Number of times red and black have won
	 */
	
	private static int redWins = 0;
	private static int blackWins = 0;
	
	/**
	 * Tracks which color's turn it is. Red = true  Black = false
	 */
	//Red = true  Black = False
	public static boolean turn = true; 
	
	/**
	 * The x and y coordinates for the origin square and the destination square
	 */
	private static int toX, fromX, toY, fromY;
	
	/**
	 * The checkers board made up of squares
	 */
	private static CheckersMain board;
	
	/**
	 * The main method that runs the entire game
	 */
	public static void main(String[] args)
	{
		for (int i = 0; i<1000; i++)
		{
			System.out.println("Welcome to Checkers! The rules are the same as regular checkers just with no double jumps. ");
			System.out.println("To make a move you want to enter the coordinates of the peice you are moving and then the destination of where you want it to land at.");
			Scanner input = new Scanner(System.in);
			System.out.print("Red Wins: " + redWins);
			System.out.println(" Black Wins: " + blackWins);
			Square checkersBoard[][] = new Square[8][8];
			for (int d = 0; d<8; d++){
				for (int j = 0; j<8; j++){
					checkersBoard[d][j] = new Square(d,j,null);
				}
			}

			board = new CheckersMain(true);
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
			
			board.printCheckersBoard();
			while(true)
			{


				if(turn)
				{
					System.out.println("Turn: Red");
				}
				else
				{
					System.out.println("Turn: Black");
				}
				System.out.println("row of coordinate of origin square");

				if(input.hasNextInt())
				{				

					fromX = input.nextInt();
					System.out.println("column of coordinate of origin square");
					fromY = input.nextInt();
					System.out.println("row of coordinate of destination square");
					toX = input.nextInt();
					System.out.println("column of coordinate of destination square");
					toY = input.nextInt();


					if(board.checkMove(checkersBoard,fromX,fromY,toX,toY,turn))
					{
						if(Math.abs(fromX-toX)==2)
						{
							checkersBoard[(toX+fromX)/2][(toY+fromY)/2].setPiece(null);
							checkersBoard[toX][toY].setPiece(checkersBoard[fromX][fromY].getPiece());
							checkersBoard[fromX][fromY].setPiece(null);
						}
						if(Math.abs(fromX-toX)==1)
						{
							checkersBoard[toX][toY].setPiece(checkersBoard[fromX][fromY].getPiece());
							checkersBoard[fromX][fromY].setPiece(null);
						}

						if (turn && toX==0)
						{
							checkersBoard[toX][toY].setPiece(new King(turn));
						}
						else if (!turn && toX == 7)
						{
							checkersBoard[toX][toY].setPiece(new King(turn));
						}
						turn = !turn;
					}
					else
					{
						System.out.println("Invalid Move: Try again");
					}
					int redLeft = 0;
					int blackLeft = 0;
					for(int k = 0; k<8; k++)
					{
						for(int j = 0; j<8; j++)
						{
							if (checkersBoard[k][j].getPiece() != null)
							{
								if(checkersBoard[k][j].getPiece().getColor() == true)
								{
									redLeft++;
								}
								else if(checkersBoard[k][j].getPiece().getColor() == false)
								{
									blackLeft++;
								}
							}	
						}
					}
					if (blackLeft == 0)
					{
						redWins++;
						System.out.println("RED WINS!!!!!");
						break;
					}
					else if(redLeft == 0)
					{
						blackWins++;
						System.out.println("BLACK WINS!!!!!");
						break;
					}


				}
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
		}
	}
}