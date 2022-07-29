package noah.sudoku;

/* Project Owner - Dhruv Singh
 * This is the example sudoku class to allow some examples to be passed through to the sudoku */


public class Example {
	private static Table[] exampleTables = new Table[3];
	private static int tableNum = (int) (Math.random() * exampleTables.length);
	
	public void setTableNum(int num){
		Example.tableNum = num;
	}
	
	public Table createExamplePuzzle(){
		Table table = exampleTables[tableNum];
		tableNum = (tableNum + 1) % exampleTables.length;
		return table;
	}
	
	public Example(){
		for (int i = 0; i < exampleTables.length; i++) {
			exampleTables[i] = new Table();
		}
		
		exampleTables[0].getDigit(0,1).setAnswer(5);
		exampleTables[0].getDigit(0,3).setAnswer(7);
		exampleTables[0].getDigit(0,6).setAnswer(8);
		exampleTables[0].getDigit(1,3).setAnswer(4);
		exampleTables[0].getDigit(1,8).setAnswer(9);
		exampleTables[0].getDigit(2,4).setAnswer(9);
		exampleTables[0].getDigit(2,8).setAnswer(5);
		exampleTables[0].getDigit(3,0).setAnswer(8);
		exampleTables[0].getDigit(3,1).setAnswer(6);
		exampleTables[0].getDigit(3,3).setAnswer(1);
		exampleTables[0].getDigit(3,6).setAnswer(4);
		exampleTables[0].getDigit(4,1).setAnswer(7);
		exampleTables[0].getDigit(4,4).setAnswer(3);
		exampleTables[0].getDigit(4,7).setAnswer(9);
		exampleTables[0].getDigit(5,2).setAnswer(9);
		exampleTables[0].getDigit(5,5).setAnswer(7);
		exampleTables[0].getDigit(5,7).setAnswer(8);
		exampleTables[0].getDigit(5,8).setAnswer(3);
		exampleTables[0].getDigit(6,0).setAnswer(4);
		exampleTables[0].getDigit(6,4).setAnswer(7);
		exampleTables[0].getDigit(7,0).setAnswer(2);
		exampleTables[0].getDigit(7,5).setAnswer(4);
		exampleTables[0].getDigit(8,2).setAnswer(5);
		exampleTables[0].getDigit(8,5).setAnswer(8);
		exampleTables[0].getDigit(8,7).setAnswer(3);


		
		exampleTables[1].getDigit(0,4).setAnswer(6);
		exampleTables[1].getDigit(0,5).setAnswer(3);
		exampleTables[1].getDigit(0,6).setAnswer(7);
		exampleTables[1].getDigit(1,3).setAnswer(9);
		exampleTables[1].getDigit(1,7).setAnswer(1);
		exampleTables[1].getDigit(2,2).setAnswer(8);
		exampleTables[1].getDigit(2,8).setAnswer(2);
		exampleTables[1].getDigit(3,1).setAnswer(6);
		exampleTables[1].getDigit(3,8).setAnswer(5);
		exampleTables[1].getDigit(4,0).setAnswer(3);
		exampleTables[1].getDigit(4,8).setAnswer(4);
		exampleTables[1].getDigit(5,0).setAnswer(7);
		exampleTables[1].getDigit(5,7).setAnswer(9);
		exampleTables[1].getDigit(6,0).setAnswer(6);
		exampleTables[1].getDigit(6,6).setAnswer(8);
		exampleTables[1].getDigit(7,1).setAnswer(9);
		exampleTables[1].getDigit(7,5).setAnswer(4);
		exampleTables[1].getDigit(8,2).setAnswer(4);
		exampleTables[1].getDigit(8,3).setAnswer(1);
		exampleTables[1].getDigit(8,4).setAnswer(9);

		
		exampleTables[2].getDigit(0,0).setAnswer(1);
		exampleTables[2].getDigit(0,1).setAnswer(2);
		exampleTables[2].getDigit(0,2).setAnswer(3);
		exampleTables[2].getDigit(0,3).setAnswer(4);
		exampleTables[2].getDigit(0,4).setAnswer(5);
		exampleTables[2].getDigit(0,5).setAnswer(6);
		exampleTables[2].getDigit(0,6).setAnswer(7);
		exampleTables[2].getDigit(0,7).setAnswer(8);
		exampleTables[2].getDigit(0,8).setAnswer(9);
		exampleTables[2].getDigit(1,0).setAnswer(4);
		exampleTables[2].getDigit(1,1).setAnswer(5);
		exampleTables[2].getDigit(1,2).setAnswer(6);
		exampleTables[2].getDigit(1,3).setAnswer(7);
		exampleTables[2].getDigit(1,4).setAnswer(8);
		exampleTables[2].getDigit(1,5).setAnswer(9);
	}

}
