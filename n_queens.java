package FinalProject;
import java.util.Scanner;
public class n_queens {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);
		// just some fancy text art to make this demo more interesting
		System.out.println("\r\n"
				+ "    _   __   ____                            \r\n"
				+ "   / | / /  / __ \\__  _____  ___  ____  _____\r\n"
				+ "  /  |/ /  / / / / / / / _ \\/ _ \\/ __ \\/ ___/\r\n"
				+ " / /|  /  / /_/ / /_/ /  __/  __/ / / (__  ) \r\n"
				+ "/_/ |_/   \\___\\_\\__,_/\\___/\\___/_/ /_/____/  \r\n"
				+ "                                             \r\n"
				+ "");
		System.out.println("Choose the number of Queens: ");
		int nQueens = scan.nextInt(); // scan in for the number of queens this also defines the board size ex if queens = 4 then board is 4x4
		char ChessBoard[][]=new char [nQueens][nQueens]; // this defines the ChessBoard size for the number of queens so if there are 4 queens then it is a 4 by 4 board
		
		for (int i=0;i<nQueens;i++)
			for (int j=0;j<nQueens;j++)
				ChessBoard[i][j]='⛶'; // to start every spot is this empty character
		if(solve(ChessBoard,0,nQueens)) printSolve(ChessBoard,nQueens);
		else System.out.println("No solution exists"); 
		
	}
	
	// this function is to print out the solution 
	public static void printSolve(char ChessBoard[][], int nQueens) {
		
		for(int i=0;i<nQueens;i++){ // for the starting value if i is less than the number of rows advance
            for(int j=0;j<nQueens;j++) // for the starting value if i is less than the number of columns advance
                System.out.print(" "+ChessBoard[i][j]+" ");
            System.out.println();
        }
	}
	
	// this function checks if each spot to place a queen is a a spot where one can actually be placed
	public static boolean LegalMove(char ChessBoard[][], int row, int column, int nQueens) {
	        
		
		// check this row on left side
		int i,j;
	    for(i=0;i<column;i++){
	    	if(ChessBoard[row][i]=='♕') return false;
	        }
	    
	    // check upper diagonal on left side
	    for(i=row,j=column; i>=0 && j>=0;i--,j--) {
	        if(ChessBoard[i][j]=='♕') return false;
	        }
	    // check lower diagonal on left side
	    for(i=row,j=column; i<nQueens && j>=0;i++,j--) {
	        if(ChessBoard[i][j]=='♕') return false;
	        }
	    
	        return true;
	    }
	  
	// this goes through each column to determine if there is a solve based on previous moves made or that can be made
	public static boolean solve(char ChessBoard[][], int column, int nQueens) {
	     // this line is for once every queen has been placed    
		if(column>=nQueens) return true;
	    for(int i=0;i<nQueens;i++) {
	    	if(LegalMove(ChessBoard,i,column,nQueens)) {// this checks if it can place a queen in that spot 
	        ChessBoard[i][column]='♕'; // if its a move that can be done then it places a queen in that column at that spot
	        	if(solve(ChessBoard, column+1,nQueens)) return true;
	        	ChessBoard[i][column]='⛶'; // this is if you need to backtrack to put a blank space instead of a queen
	            }
	        }
	        return false;
	    }

}
