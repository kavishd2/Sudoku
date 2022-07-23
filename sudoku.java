// Solves sudoku using backtracking. If there isn't a unique solution, will find one with ascending filled in numbers.
public class sudoku 
{
	private int[][] board;
    private int size;
    
    public sudoku(int[][] b, int s) 
    {
    	size = s;
    	board = new int[s][s];
    	for (int i = 0; i < s; i++)
    		for (int j = 0; j < s; j++)
    			board[i][j] = b[i][j];
    }
    
    public boolean solve()
    {
    	for (int i = 0; i < size; i++)
    		for (int j = 0; j < size; j++)
    			if (board[i][j] == 0)
    			{
    				for (int c = 1; c <= size; c++)
    					if (isValid(i, j, c))
    					{
    						board[i][j] = c;
    						if(solve() == true)
    							return true;
    						else
    							board[i][j] = 0;
    					}
    				return false;
    			}
    	return true;
    }
    
    public boolean isValid(int row, int col, int num)
    {
    	int s = (int) Math.sqrt(size);
    	for (int i = 0; i < size; i++)
    	{
    		if (board[i][col] == num)
    			return false;
    		if (board[row][i] == num)
    			return false;
    		if (board[s * (row / s) + i / s][s * (col / s) + i % s] == num)
    			return false;
    	}	
    	return true;
    }
    
    public String toString()
    {
    	solve();
    	String s = "\n";
    	for (int i = 0; i < size; i++)
    	{
    		for (int j = 0; j < size; j++)
    			s += board[i][j] + " ";
    		s += "\n";
    	}
    	return s;
    }
}