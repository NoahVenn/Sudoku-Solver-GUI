package noah.sudoku;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
//import javax.swing.plaf.metal.MetalBorders.TextFieldBorder;



public class GUI {
private Table sudokuTable = new Table();
	
	private JFrame frame = new JFrame("Sudoku Solver");
	private JTextField textField[][] = new JTextField[9][9];
	
	private GridPanel gridPanel = new GridPanel(new GridLayout(9,9,1,1));
	

	GUI(){
		for (int y = 0; y < 9; y++){
			for (int x = 0; x < 9; x++){
				textField[x][y] = new JTextField();
				textField[x][y].setForeground(Color.BLUE);
				textField[x][y].setFont(new Font("poppins", Font.PLAIN, 16));
				textField[x][y].setHorizontalAlignment(JTextField.CENTER);
				gridPanel.add(textField[x][y]);
			}
		}
		
	}
	
	boolean checkText(){
		for (int y = 0; y < 9; y++){
			for (int x = 0; x < 9; x++){
				if (!textField[x][y].getText().equals("")){
					try {
						int digit = Integer.parseInt(textField[x][y].getText());
						if (digit <= 0 || digit >= 10)
							return false;
					}
					catch (NumberFormatException e){
						return false;
					}
				}
			}
		}
		return true;
	}

	public void GUIToSudokuTable(){
		for (int y = 0; y < 9; y++){
			for (int x = 0; x < 9; x++){
				if (!textField[x][y].getText().equals("")){
					sudokuTable.getDigit(x,y).setAnswer(Integer.parseInt(textField[x][y].getText()));
					sudokuTable.getDigit(x,y).setSafe(true); 
					textField[x][y].setForeground(Color.BLUE); 
				}
				else {
					sudokuTable.getDigit(x,y).setAnswer(0);
					textField[x][y].setForeground(Color.BLACK); 
				}
			}
		}
	}
	
	public void sudokuTableToGUI(){
		for (int y = 0; y < 9; y++){
			for (int x = 0; x < 9; x++){		
				if (sudokuTable.getDigit(x,y).isSolved())
					textField[x][y].setText(String.valueOf(sudokuTable.getDigit(x,y).getAnswer()));			
			}
		}
	}
	
	public void clearGrid(){
		for (int y = 0; y < 9; y++){
			for (int x = 0; x < 9; x++){
				textField[x][y].setText("");
				textField[x][y].setForeground(Color.BLUE);
			}
		}
	}
	
	public void createGUI(){
		
		//Main Panel
		JPanel mainPanel = new JPanel(new GridBagLayout()); //create main panel
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		
		gridBagConstraints.weighty = 1;
		gridBagConstraints.weightx = 1;
		gridBagConstraints.anchor = GridBagConstraints.NORTH;
		
		// Label of main panel
		JLabel topLabel = new JLabel("SUDOKU SOLVER", JLabel.CENTER);
//		topLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		topLabel.setOpaque(true);
		topLabel.setBackground(Color.BLACK);
		topLabel.setForeground(Color.WHITE);
		topLabel.setFont(new Font("poppins", Font.BOLD, 25));
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.weighty = 0.05;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		mainPanel.add(topLabel, gridBagConstraints);
		
		
		//grid panel
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.weighty = 1;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.anchor = GridBagConstraints.NORTH;
		mainPanel.add(gridPanel, gridBagConstraints); 
		
		//gridbagconstraints for all bottom buttons
		gridBagConstraints.anchor = GridBagConstraints.SOUTH;
		gridBagConstraints.weighty = 0.1;
		
		//example button to generate example sudoku
		JButton exampleButton = new JButton("Example Sudoku");
		exampleButton.setFont(new Font("poppins", Font.PLAIN, 16));
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.anchor = GridBagConstraints.SOUTH;
		gridBagConstraints.ipadx = 50;
		mainPanel.add(exampleButton, gridBagConstraints);
		exampleButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Example example = new Example();
				sudokuTable = example.createExamplePuzzle();
				clearGrid();
				sudokuTableToGUI();
			}
		});
		
		//Clear button to clear screen
		JButton clearButton = new JButton("Clear Table");
		clearButton.setFont(new Font("poppins", Font.PLAIN, 16));
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.ipadx = 0;
		mainPanel.add(clearButton, gridBagConstraints);
		clearButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				sudokuTable = new Table();
				clearGrid();
			}
		});
		
		//solve button on the bottom panel
		JButton solveButton = new JButton("Solve");
		solveButton.setFont(new Font("poppins", Font.BOLD, 16));
		solveButton.setBackground(Color.CYAN);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 2;
		mainPanel.add(solveButton, gridBagConstraints);
		solveButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (!checkText())
					JOptionPane.showMessageDialog(frame,"Please Enter Values between 1 to 9 only.","Error",JOptionPane.ERROR_MESSAGE);
				else {
					GUIToSudokuTable();
					if (!sudokuTable.solve(1))
						JOptionPane.showMessageDialog(frame,"This is an Unsolvable Sudoku.","Error",JOptionPane.ERROR_MESSAGE);
					else
						sudokuTableToGUI();
				}
			}
		});
		
		
		//frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.getContentPane().add(mainPanel); //add main panel to frame
		frame.setLocationRelativeTo(null);
		frame.setMinimumSize(new Dimension(500,500));
		frame.setVisible(true);
	}
	
	//nested class for gridpanel
	public class GridPanel extends JPanel{
		private static final long serialVersionUID = 6969696969420L;

		GridPanel(GridLayout layout){
			super(layout);
		}
		
		//lines for quadrants
		public void paintComponent(Graphics g){
			g.fillRect(getWidth()/3 - 1,0,3,getHeight());
			g.fillRect(2*getWidth()/3 - 1,0,3,getHeight());
			g.fillRect(0,getHeight()/3 - 1,getWidth(),3);
			g.fillRect(0,2*getHeight()/3 - 2,getWidth(),3);
		}
	}

}
