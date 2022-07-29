package noah.sudoku;
import java.util.ArrayList;


public class SudokuDigit {
	private int ans;
	private int xLoc;
	private int yLoc;
	private ArrayList<Integer> possibleVal = new ArrayList<Integer>();
	private boolean isSafe = false;

	
	SudokuDigit(int answer){
		this.ans = answer;
	}
	
	SudokuDigit(int xLocation, int yLocation){
		for (int i = 0; i < 9; i++){
			possibleVal.add(i+1);
		}
		this.xLoc = xLocation;
		this.yLoc = yLocation;
	}
	
	
	SudokuDigit(SudokuDigit sudokuDigit){;
		this.ans = sudokuDigit.ans;
		this.xLoc = sudokuDigit.xLoc;
		this.yLoc = sudokuDigit.yLoc;
		this.possibleVal = sudokuDigit.possibleVal;
		this.isSafe = sudokuDigit.isSafe;
	}

	
	
	public ArrayList<Integer> getPossibleValues(){
		return possibleVal;
	}
	
	public boolean isSolved(){
		return (ans != 0);
	}
	
	public boolean isSafe(){
		return isSafe;
	}
	
	public int getAnswer(){
		return ans;
	}
	
	public int getX(){
		return xLoc;
	}
	
	public int getY(){
		return yLoc;
	}

	
	public void setSafe(boolean isSafe){
		this.isSafe = isSafe;
	}
	
	public void setAnswer(int answer){
		this.ans = answer;
		possibleVal.clear();
		if (answer == 0) { // add all possible values from 1 to 9
			for (int i = 1; i < 10; i ++)
				this.possibleVal.add(i);
		}
	}

	public void removePossibleValue(int possibleValue){
		if (ans == 0) {
			if (possibleVal.contains(possibleValue))
				possibleVal.remove(possibleValue);
			if (possibleVal.size() == 1)
				setAnswer(possibleVal.get(0));
		}
	}
	
	public String toString(){
		if (ans == 0){
			String str = "Possible values for location are (" + xLoc + "," + yLoc + "): ";
			for (int value : possibleVal)
				str = str + value + " ";
			return str;
		}
		else
			return "Location (" + xLoc + "," + yLoc + "): " + ans;
	}

}
