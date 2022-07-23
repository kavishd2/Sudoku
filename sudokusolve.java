// Enter your sudoku by leaving a space after each number. Put a 0 if blank.
import java.util.Scanner;
public class sudokusolve 
{
    public static void main(String[] args)
    {
    	Scanner kb = new Scanner(System.in);
    	System.out.print("Enter the size: (must be a perfect square) ");
    	int s = kb.nextInt();
    	int[][] board = new int[s][s];
    	for (int i = 0; i < s; i++)
    		for (int j = 0; j < s; j++)
    			board[i][j] = kb.nextInt();
    	sudoku b = new sudoku(board, s);
    	System.out.print(b);
    }
}