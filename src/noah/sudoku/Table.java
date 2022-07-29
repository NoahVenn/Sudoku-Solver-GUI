package noah.sudoku;
import java.util.ArrayList;



public class Table {
	private SudokuDigit[][] table = new SudokuDigit[9][9];
	

	public Table(){
		for (int y = 0; y < 9; y++){
			for (int x = 0; x < 9; x++){
				table[x][y] = new SudokuDigit(x,y);
			}
		}
	}

	
	public SudokuDigit getDigit(int x, int y){
		if (x >= 0 && x <= 8 && y >= 0 && y <= 8)
			return table[x][y];
		else
			throw new IndexOutOfBoundsException("Table x and y values are integers from 0 to 8");
	}
	
	
	boolean checkDigit(SudokuDigit digit) {
		if (!digit.isSolved())
			return true;
		
		//row
        for (int x = 0; x < 9; x++)
            if (digit.getAnswer() == table[x][digit.getY()].getAnswer() && digit.getX() != x)
                return false;

        //column
        for (int y = 0; y < 9; y++) 
            if (digit.getAnswer() == table[digit.getX()][y].getAnswer() && digit.getY() != y)
                return false;

        //check quadrant
        int startPosX = (digit.getX()/3)*3;
		int startPosY = (digit.getY()/3)*3;
		for (int y = startPosY; y < startPosY + 3; y++){
			for (int x = startPosX; x < startPosX + 3; x++){
				if (digit.getAnswer() == table[x][y].getAnswer() && digit.getX() != x && digit.getY() != y)
					return false;
			}
		}
        return true;
    }
	
	
	boolean solve(int position) {
		if (position > 81)
	    	return true;
		
		int x = (position-1)%9;
		int y = (position-1)/9;
		
	    if (table[x][y].isSolved())
	    	return solve(position+1);
	    
	    ArrayList<Integer> posssibleValues = new ArrayList<Integer>(table[x][y].getPossibleValues());
	    for (int possibleValue : posssibleValues) {
	    	SudokuDigit digit = new SudokuDigit(table[x][y]);
	    	digit.setAnswer(possibleValue);
		    if (checkDigit(digit)) {
		        table[x][y] = digit;
		       	if (solve(position+1)) 
		       		return true;
		    }
	    }
	    table[x][y].setAnswer(0);
	    return false;
	}
	
	

	public int getNumOfDigitsSolved(){
		int numOfDigitsSolved = 0;
		for (SudokuDigit[] column : table){
			for (SudokuDigit sudokuDigit : column){
				if (sudokuDigit.isSolved())
					numOfDigitsSolved += 1;
			}
		}
		return numOfDigitsSolved;
	}
	

	public boolean checkOK(){
		for (SudokuDigit[] column : table){
			for (SudokuDigit sudokuDigit : column){
				if (checkDigit(sudokuDigit) && sudokuDigit.getAnswer() >= 0 && sudokuDigit.getAnswer() <= 9)
					continue;
				return false;
			}
		}
		return true;
	}
	

	public void setSolvedToSafe(){
		for (SudokuDigit[] column : table){
			for (SudokuDigit sudokuDigit : column){
				if (sudokuDigit.isSolved())
					sudokuDigit.setSafe(true);
			}
		}
	}
	

	public String toString(){
		String str = "";
		for (int y = 0; y < 9; y++){
			for (int x = 0; x < 9; x++){
				str = str + table[x][y].getAnswer() + " ";
			}
			str = str + "\n";
		}
		return str;
	}

}
