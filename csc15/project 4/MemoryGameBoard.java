//Memory game board


import java.util.Random;

public class MemoryGameBoard {
	public int BOARD_SIZE = 4;
	private int NUM_SWAPS = 1000;
	private Card[][] gameBoard;
	
	public MemoryGameBoard() {
		gameBoard = new Card[BOARD_SIZE+1][BOARD_SIZE+1];
		initializeCards();
	}
	
	public void shuffleCards() {
		turnCardsFaceDown();
      Random rand = new Random();
		for(int i = 1; i <= NUM_SWAPS; i++) {
			int row1 = rand.nextInt(BOARD_SIZE) +1;
         int col1 = rand.nextInt(BOARD_SIZE) +1;
			int row2 = rand.nextInt(BOARD_SIZE) +1;
			int col2 = rand.nextInt(BOARD_SIZE) +1;
			Card temp_card = gameBoard[row1][col1];
			gameBoard[row1][col1] = gameBoard[row2][col2];
			gameBoard[row2][col2] = temp_card;
		}		
	}
	
   //Calls the method hideBoard() to hide the previously printed board. 
	public void showBoard() {
		hideBoard();
		System.out.println(this);
	}
   
   //Returns true if the card at gameBoard[row1][col1] is equal to the card at gameBoard[row2][col2] otherwise false is returned. 
   public boolean cardsMatch(int row1, int col1, int row2, int col2) {
      if(gameBoard[row1][col1].equals(gameBoard[row2][col2])) {
			return true;
		}
		else {
			return false;
		}
	}

   //Returns the value of the instance variable faceUp for the Card at gameBoard[row][col]. 
   //This method will call the method isFaceUp() in the Card class.
	public boolean isFaceUp(int row, int col) {
		return gameBoard[row][col].isFaceUp();
	}
	
   //Turns over the Card at gameBoard[row][col] by calling the flipCard method in the Card class.
	public void flipCard(int row, int col) {
		gameBoard[row][col].flipCard();
	}
	
   //Builds and returns a String that contains the current state of the gameBoard
	public String toString() {
		String final_matrix = "   ";
		
		
		for(int i = 1; i <= BOARD_SIZE; i++) {
			final_matrix += " " + i ;
		}
		final_matrix += "\n   ";
		for(int i = 1; i <= (BOARD_SIZE*2); i++) {
			final_matrix += "=";
		}
		final_matrix += "\n";
		for(int i = 1; i <= BOARD_SIZE; i++) {
			final_matrix += i + " | ";
			for(int j = 1 ; j <= BOARD_SIZE; j++) {
				final_matrix += String.format("%s ", gameBoard[i][j].toString());
			}
			final_matrix += "|\n";
		}
		final_matrix += "   ";
		for(int i = 1; i <= (BOARD_SIZE*2); i++) {
			final_matrix += "=";
		}
		return final_matrix;	
		
	}
	
   //Instantiates and initializes the cards in the used portion of the gameBoard array.
	private void initializeCards() {
		for (int i = 1; i <= BOARD_SIZE; i++) {
			for(int j = 1; j <= BOARD_SIZE; j++) {
				gameBoard[i][j] = new Card(j + (BOARD_SIZE*((i-1)%(BOARD_SIZE/2))));
			}
		}
	}
	
   //Hides the last board printed on the screen by scrolling it down using System.out.println() .
	private void hideBoard() {
		for(int i =1; i<=10; i++) {
			System.out.println();
		}
	}
	
   //Sets the value of the instance variable faceUp to false for all the Cards 
   //in the gameBoard array by calling the method setFaceUp in the Card class.
	private void turnCardsFaceDown() {
		for (int i = 1; i <= BOARD_SIZE; i++) {
			for(int j = 1; j <= BOARD_SIZE; j++) {
				gameBoard[i][j].setFaceDown();
			}
		}
	}
	
   //This method is to be used only for testing purposes.
	public void displayGameBoardValues() {
		String begin = "   ";
		for(int i = 1; i <= BOARD_SIZE; i++) {
			begin += " " + i ;
		}
		begin += "\n   ";
		for(int i = 1; i <= (BOARD_SIZE*2); i++) {
			begin += "=";
		}
		begin += "\n";
		for(int i = 1; i <= BOARD_SIZE; i++) {
			begin = i + " | ";
			for(int j = 1 ; j <= BOARD_SIZE; j++) {
				gameBoard[i][j].flipCard();
				begin += String.format("%s ", gameBoard[i][j].toString());
			}
			begin += "|\n";
		}
		begin += "   ";
		for(int i = 1; i <= (BOARD_SIZE*2); i++) {
			begin += "=";
		}
		System.out.println(begin);
	}
}
