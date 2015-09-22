import java.awt.BorderLayout;
import java.awt.GridLayout;

//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//import JOptionPane;
import java.util.List;

public class TicTacToe implements ActionListener {
	
	private JFrame myTicTacToe = new JFrame("Tic Tac Toe");
	private JPanel p = new JPanel();
	private JButton[] buttons = new JButton[20];
	private int count = 0;
	private static int human = 0;
	private static int computer = 1;
	private int turn = human;
	//depth 19 as required
	private int depth = 19;
	
	//this is a temp 2 dimension array, the AI use this as a temporary board to do calculate
	private int[][] temp = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
	
	private JPanel FistGo = new JPanel();
	private JButton AI = new JButton();
	private JButton people = new JButton();
	private JButton reset = new JButton();
	private int finalScore;
	private JButton AI2 = new JButton();
	private JButton AI3 = new JButton();
	//AIchoose: AI level, 1 easy,2 middle,3 hard
	private int AIchoose;
	private JButton pickAI = new JButton();
	private JButton pickAI2 = new JButton();
	private JButton pickAI3 = new JButton();
	
//	sorry about the buttons on GUI is a little confuse, 
//	1. you can click AI level to let AI play first, such as "AI level 1", which is the lowest level
//	2. a. you can click pickAI to choose level, but AI wont move in this case, 
//		you have to click the game board to start
//	   b. you can click player if you want play first
//	3. you can reset the game after finish, but you need rechoose the choise as mentioned above

	//constructor to initialize the game
	public TicTacToe(){
		myTicTacToe.setSize(1000,500);
		myTicTacToe.setResizable(false);
		myTicTacToe.setLayout(new BorderLayout());
		myTicTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.setLayout(new GridLayout(4, 5));
		for(int i=0;i<buttons.length;i++){
			buttons[i] = new JButton();
			buttons[i].addActionListener(this);
			p.add(buttons[i]);
		}
		
		AI3.setText("AI Level 3");
		people.setText("player");
		AI3.addActionListener(this);
		pickAI.setText("pick AI level 1");
		pickAI.addActionListener(this);
		pickAI2.setText("pick AI level 2");
		pickAI2.addActionListener(this);
		pickAI3.setText("pick AI level 3");
		pickAI3.addActionListener(this);
		
		AI2.setText("AI Level 2");
		AI2.addActionListener(this);
		AI.setText("AI Level 1");
		AI.addActionListener(this);
		
		people.addActionListener(this);
		FistGo.add(AI);
		FistGo.add(AI2);
		FistGo.add(AI3);
		FistGo.add(pickAI);
		FistGo.add(pickAI2);
		FistGo.add(pickAI3);
		
		FistGo.add(people);
		reset.setText("reset game");
		reset.addActionListener(this);
		FistGo.add(reset);
		
		myTicTacToe.getContentPane().add(BorderLayout.CENTER, p);
		myTicTacToe.getContentPane().add(BorderLayout.NORTH, FistGo);
		myTicTacToe.setVisible(true);
		System.out.println("button text"+buttons[1].getText());
	
	}
	
	
	//create GUI so this function is to listen the mouse click action and decide whose turn to play
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==pickAI){
			AIchoose=1;
		}else if(e.getSource()==pickAI2){
			AIchoose=2;
		}else if(e.getSource()==pickAI3){
			AIchoose=3;
		}
		
		
		if(e.getSource()==AI||e.getSource()==AI2||e.getSource()==AI3||e.getSource()==people||e.getSource()==reset){
			if(e.getSource()==AI){
				count++;
				AIchoose = 1;
				stupidComputerTurn();
				if(count>=7){
					whoWon();
				}
			}else if(e.getSource()==AI2){
				count++;
				AIchoose = 2;
				computerLevelTwoTurn();
				if(count>=7){
					whoWon();
				}
			}else if(e.getSource()==AI3){
				count++;
				System.out.println("click here?");
				AIchoose = 3;
				computerTurn();
				if(count>=7){
					whoWon();
				}
			}else if(e.getSource()==people){
				System.out.println("I click");
//				if(count>=7){
//					whoWon();
//				}
			}else if(e.getSource()==reset){
				reset();
				return;
			}
			
//			if(count>=7){
//				whoWon();
//			}
		}else{
			System.out.println("Count: " + count);
			if(e.getSource()==buttons[0]){
				System.out.println("works until here");
				buttons[0].setText("O");
				count++;
				System.out.println("works also here");
				//buttons[0].setEnabled(false);
			}else if(e.getSource()==buttons[1]){
				System.out.println("2works until here");
				buttons[1].setText("O");
				count++;
				System.out.println("2works also here");
				//buttons[1].setEnabled(false);
			}else if(e.getSource()==buttons[2]){
				buttons[2].setText("O");
				count++;
				//buttons[2].setEnabled(false);
			}else if(e.getSource()==buttons[3]){
				buttons[3].setText("O");
				count++;
				//buttons[3].setEnabled(false);
			}else if(e.getSource()==buttons[4]){
				buttons[4].setText("O");
				count++;
				//buttons[4].setEnabled(false);
			}else if(e.getSource()==buttons[5]){
				buttons[5].setText("O");
				count++;
				//buttons[5].setEnabled(false);
			}else if(e.getSource()==buttons[6]){
				buttons[6].setText("O");
				count++;
				//buttons[6].setEnabled(false);
			}else if(e.getSource()==buttons[7]){
				buttons[7].setText("O");
				count++;
				//buttons[7].setEnabled(false);
			}else if(e.getSource()==buttons[8]){
				buttons[8].setText("O");
				count++;
				//buttons[8].setEnabled(false);
			}else if(e.getSource()==buttons[9]){
				buttons[9].setText("O");
				count++;
				//buttons[9].setEnabled(false);
			}else if(e.getSource()==buttons[10]){
				buttons[10].setText("O");
				count++;
				//buttons[10].setEnabled(false);
			}else if(e.getSource()==buttons[11]){
				buttons[11].setText("O");
				count++;
				//buttons[11].setEnabled(false);
			}else if(e.getSource()==buttons[12]){
				buttons[12].setText("O");
				count++;
				//buttons[12].setEnabled(false);
			}else if(e.getSource()==buttons[13]){
				buttons[13].setText("O");
				count++;
				//buttons[13].setEnabled(false);
			}else if(e.getSource()==buttons[14]){
				buttons[14].setText("O");
				count++;
				//buttons[14].setEnabled(false);
			}else if(e.getSource()==buttons[15]){
				buttons[15].setText("O");
				count++;
				//buttons[15].setEnabled(false);
			}else if(e.getSource()==buttons[16]){
				buttons[16].setText("O");
				count++;
				//buttons[16].setEnabled(false);
			}else if(e.getSource()==buttons[17]){
				buttons[17].setText("O");
				count++;
				//buttons[17].setEnabled(false);
			}else if(e.getSource()==buttons[18]){
				buttons[18].setText("O");
				count++;
				//buttons[18].setEnabled(false);
			}else if(e.getSource()==buttons[19]){
				buttons[19].setText("O");
				count++;
				//buttons[19].setEnabled(false);
			}
			//after human play, AI makes choice
			//count++;
			
			if(count>=7){
				if(whoWon()){
					return;
				}
			}
			if(AIchoose==1&&e.getSource()!=pickAI&&e.getSource()!=reset){
				stupidComputerTurn();
				count++;
				if(count>=7){
					if(whoWon()){
						return;
					}
				}
			}else if(AIchoose==2&&e.getSource()!=pickAI2&&e.getSource()!=reset){
				computerLevelTwoTurn();
				count++;
				if(count>=7){
					if(whoWon()){
						return;
					}
				}
			}else if(AIchoose==3&&e.getSource()!=pickAI3&&e.getSource()!=reset){
				computerTurn();
				count++;
				if(count>=7){
					if(whoWon()){
						return;
					}
				}
			}
		}
		
		System.out.println("Count: " + count);	
		
		//moves equals or more than 7, begin to judge which player wins
//		if(count>=7&&resetValue==0){
//			whoWon();
//		}
//		
	}//end method
	
	//reset the game if human want to play again
	public void reset() {
		count=0;
		AIchoose = 0;
		for(int i=0;i<buttons.length;i++){
			buttons[i].setText("");
		}
		for(int i=0;i<temp.length;i++){
			for(int j=0;j<temp[0].length;j++){
				temp[i][i]=0;
			}
		}
	}
	
	//this is the level 1 player, it random choose one cell of the board to play
	public void stupidComputerTurn(){
		
		int i = (int) Math.round((Math.random()*19));
		if(!buttons[i].getText().equalsIgnoreCase("X")&&!buttons[i].getText().equalsIgnoreCase("O")){
			buttons[i].setText("X");
		}else{
			stupidComputerTurn();
		}
	}

	//AI with MinMaxAlpha method
	public void computerTurn(){
		
		//first alpha beta algorithm
		int nMove;
		//System.out.println("ComputerTurn");
		long startTime = System.currentTimeMillis();
		System.out.println(startTime);
		
		//before move check which cell is ready been choose
		for(int i=0;i<temp.length;i++){
			for(int j=0;j<temp[0].length;j++){
				System.out.println("final test problem: "+buttons[5*i+j].getText());
				if(buttons[5*i+j].getText().equalsIgnoreCase("X")){
					temp[i][j]=1;
				}else if(buttons[5*i+j].getText().equalsIgnoreCase("O")){
					temp[i][j]=4;
				}
			}
		}
		
		//nMove = MinMaxPrune(depth,turn,startTime)[1];
		
		
		nMove = MinMaxAlpha(depth,turn,startTime,Integer.MIN_VALUE, Integer.MAX_VALUE)[1];
		
		
		System.out.println("how about here");
		System.out.println(nMove);
		buttons[nMove].setText("X");
		//buttons[nMove].setEnabled(false);
		//count++;

	}
	
	//AI with MinMax without prune
	public void computerLevelTwoTurn(){
			
			//first alpha beta algorithm
			int nMove;
			//System.out.println("ComputerTurn");
			long startTime = System.currentTimeMillis();
			System.out.println(startTime);
			
	//build small arrays then check which one is filled
			//int[][] backup = new int[4][5];
			for(int i=0;i<temp.length;i++){
				for(int j=0;j<temp[0].length;j++){
					if(buttons[5*i+j].getText().equalsIgnoreCase("X")){
						temp[i][j]=1;
					}else if(buttons[5*i+j].getText().equalsIgnoreCase("O")){
						temp[i][j]=4;
					}
				}
			}
			
			nMove = MinMax(depth,turn,startTime)[1];
			//nMove = MinMaxAlpha(depth,turn,startTime,Integer.MIN_VALUE, Integer.MAX_VALUE)[1];
			System.out.println("how about here");
			System.out.println(nMove);
			buttons[nMove].setText("X");
			//buttons[nMove].setEnabled(false);
			count++;
	
		}
	
	//MinMax with Prune method
	public int[] MinMaxAlpha(int dep, int turn,long Time,int alpha, int beta){

		List<Integer> nextMoves = generateMoves();
		finalScore = 0;
		
		int currentScore;
		int bestMove = -1;
		int tempi = 0;
		int tempj = 0;

		long endTime = System.currentTimeMillis();

		if(dep==0 || nextMoves.isEmpty()||(Math.abs(endTime)-Time>10000)){
			System.out.println("steps 2 here");
			currentScore = Evaluate();
			System.out.println("stop eval?");
			System.out.println(currentScore);
		}else{
			//System.out.println("nextMoves size: "+nextMoves.size());
			for(int i=0;i<nextMoves.size();i++){
				//System.out.println("NextMove size:" + nextMoves.size());
				if(turn==computer){
					tempi = nextMoves.get(i)/5;
					tempj = nextMoves.get(i)%5;
					temp[tempi][tempj]=3;
				}else{
					temp[tempi][tempj]=2;
				}
				
				if(turn==computer){
					
					currentScore = MinMaxAlpha(dep-1,human,Time,alpha,beta)[0];
					if(currentScore > alpha){
						alpha = currentScore;
						bestMove = nextMoves.get(i);
					}
				}else{
					currentScore = MinMaxAlpha(dep-1,computer,Time,alpha,beta)[0];
					if(currentScore<beta){
						beta = currentScore;
						bestMove = nextMoves.get(i);
					}
				}//end else
				//undo move
				temp[tempi][tempj]=0;
			}//end for
		}
		System.out.println("bestMove:" +bestMove);
		return new int[] {finalScore, bestMove};
	}
	

	public int[] MinMax(int dep, int turn,long Time){

		List<Integer> nextMoves = generateMoves();

		int bestScore = (turn==human) ? Integer.MAX_VALUE:Integer.MIN_VALUE;
		int currentScore;
		int bestMove = -1;
		int tempi = 0;
		int tempj = 0;

		long endTime = System.currentTimeMillis();

		if(dep==0 || nextMoves.isEmpty()||(Math.abs(endTime)-Time>10000)){
			System.out.println("steps 2 here");
			bestScore = Evaluate();
			System.out.println("stop eval?");
			System.out.println(bestScore);
		}else{
			for(int i=0;i<nextMoves.size();i++){
				if(turn==computer){
					tempi = nextMoves.get(i)/5;
					tempj = nextMoves.get(i)%5;
					temp[tempi][tempj]=3;
				}else{
					temp[tempi][tempj]=2;
				}
				
				if(turn==computer){
//[0]???
					currentScore = MinMax(dep-1, human,Time)[0];
					if(currentScore > bestScore){
						bestScore = currentScore;
						bestMove = nextMoves.get(i);
					}
				}else{
					currentScore = MinMax(dep-1, computer,Time)[0];
					if(currentScore<bestScore){
						bestScore = currentScore;
						bestMove = nextMoves.get(i);
					}
				}//end else
				//undo move
				temp[tempi][tempj]=0;
			}//end for
		}
		System.out.println("bestMove:" +bestMove);
		return new int[] {bestScore, bestMove};
	}
	
	//this method returns an array contains unfilled cell, which can be used to develop strategy
	public List<Integer> generateMoves(){
		List<Integer> nextMoves= new ArrayList<Integer>();
//		if((count>7)&&whoWon()){
//			return null;  //return empty list
//		}
		//System.out.println("go here?");
		for(int i=0; i<temp.length;i++){
			for(int j=0;j<temp[0].length;j++){
				if((temp[i][j]==0)){
	//problem here, add what???
					//System.out.println("----------------temp value here "+temp[i][j]);
					nextMoves.add(i*5+j);
				}
			}
		}
		return nextMoves;
	}
	
	
	//this method return evaluated value when depth is 0 or time spends larger than 10s
	public int Evaluate() {
		int score = 0;
		int XThreeInaRow = 0;
		int XTwoInaRow = 0;
		int XOneInaRow = 0;
		int OThreeInaRow = 0;
		int OTwoInaRow = 0;
		int OOneInaRow = 0;
		System.out.println("Eval inside");
		//test X
		//Vertical
		try {
			for(int j=0;j<temp[0].length;j++){
				System.out.println("firstfirst loop Xnum");
				int Xnum = 0;
				System.out.println("first loop Xnum: "+Xnum);
				for(int i=0;i<temp.length;i++){
					try {
						if(temp[i][j]==1||temp[i][j]==3){
							System.out.println("initial Xnum: "+ Xnum);
							Xnum++;
							System.out.println("Xnum: "+Xnum);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}//end inner loop
				switch(Xnum){
				case 1:
					XOneInaRow++;
					System.out.println("XOneInaRow: "+XOneInaRow);
					break;
				case 2:
					XTwoInaRow++;
					break;
				case 3:
					XThreeInaRow++;
					break;
				default:
					break;
				}//end switch
			}//end out loop
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//test Horizontal
		for(int i=0;i<temp.length;i++){
			int Xnum = 0;
			for(int j=0;j<temp[0].length;j++){
				if(temp[i][j]==1||temp[i][j]==3){
					Xnum++;
					System.out.println("stupid here");
				}
			}
			switch(Xnum){
			case 1:
				XOneInaRow++;
				break;
			case 2:
				XTwoInaRow++;
				break;
			case 3:
				XThreeInaRow++;
				break;
			default:
				break;
			}
		}
		//test Diagonal left to right 
		for(int j=0;j<2;j++){
			for(int i=0;i<temp.length;i++){
				int Xnum = 0;
				if(temp[i][i+j]==1||temp[i][i+j]==3){
					Xnum++;
				}
				
				switch(Xnum){
				case 1:
					XOneInaRow++;
					break;
				case 2:
					XTwoInaRow++;
					break;
				case 3:
					XThreeInaRow++;
					break;
				default:
					break;
				}
			}
		}
		
		//test Diagonal right to left
		for(int j=4;j>2;j--){
			for(int i=0;i<4;i++){
				int Xnum = 0;
					if(temp[i][j-i]==1||temp[i][j-i]==3){
						Xnum++;
					}
				switch(Xnum){
				case 1:
					XOneInaRow++;
					break;
				case 2:
					XTwoInaRow++;
					break;
				case 3:
					XThreeInaRow++;
					break;
				default:
					break;
				}
			}
		}
			
		
		//test O
		//Vertical
		for(int j=0;j<temp[0].length;j++){
			int Onum = 0;
			for(int i=0;i<temp.length;i++){
				if(temp[i][j]==4||temp[i][j]==2){
					Onum++;
				}
			}
			switch(Onum){
			case 1:
				OOneInaRow++;
				break;
			case 2:
				OTwoInaRow++;
				break;
			case 3:
				OThreeInaRow++;
				break;
			default:
				break;
			}
		}
		//test Horizontal
		for(int i=0;i<temp.length;i++){
			int Onum = 0;
			for(int j=0;j<temp[0].length;j++){
				if(temp[i][j]==4||temp[i][j]==2){
					Onum++;
				}
			}
			switch(Onum){
			case 1:
				OOneInaRow++;
				System.out.println("OOneInaRow: "+OOneInaRow);
				break;
			case 2:
				OTwoInaRow++;
				break;
			case 3:
				OThreeInaRow++;
				break;
			default:
				break;
			}
		}
		//test Diagonal left to right
		for(int j=0;j<2;j++){
			int Onum = 0;
			for(int i=0;i<temp.length;i++){
				if(temp[i][i+j]==4||temp[i][i+j]==2){
					Onum++;
				}
			}
			switch(Onum){
			case 1:
				OOneInaRow++;
				break;
			case 2:
				OTwoInaRow++;
				break;
			case 3:
				OThreeInaRow++;
				break;
			default:
				break;
			}
		}
		//Diagonal right to left
		for(int j=4;j>2;j--){
			int Onum = 0;
			for(int i=0;i<4;i++){
				if(temp[i][j-i]==4||temp[i][j-i]==2){
					Onum++;
				}
			}
			switch(Onum){
			case 1:
				OOneInaRow++;
				break;
			case 2:
				OTwoInaRow++;
				break;
			case 3:
				OThreeInaRow++;
				break;
			default:
				break;
			}
		}
		
		
		//test 
		score =3*XThreeInaRow+2*XTwoInaRow+XOneInaRow-(3*OThreeInaRow+2*OTwoInaRow+OOneInaRow);
		System.out.println("Score:" + score);
		return score;
	}

	//check if someone wins the game
	public boolean whoWon(){
		//check who wins the game
		//Vertical wins
		for(int i=0;i<5;i++){
			if((buttons[0+i].getText().equalsIgnoreCase("X"))&&(buttons[5+i].getText().equalsIgnoreCase("X"))&&(buttons[10+i].getText().equalsIgnoreCase("X"))
			   &&(buttons[15+i].getText().equalsIgnoreCase("X"))){
				JOptionPane.showMessageDialog(null, "sorry, AI wins! press reset button if you wanna another try!");
				return true;
			}
		}//end for loop
			
		//Horizontal wins
		for(int i=0;i<16;i+=5){
			int win = 0;
			for(int j=0;j<4;j++){
				if(buttons[i+j].getText()=="X"){
					win++;
				}
			}
			if(win==4){
				JOptionPane.showMessageDialog(null, "sorry, AI win! press reset button if you wanna another try!");
				return true;
			}
		}
		
		for(int i=1;i<16;i+=5){
			int win = 0;
			for(int j=0;j<4;j++){
				if(buttons[i+j].getText()=="X"){
					win++;
				}
			}
			if(win==4){
				JOptionPane.showMessageDialog(null, "sorry, AI win! press reset button if you wanna another try!");
				return true;
			}
		}
//		for(int i=0;i<temp.length;i++){
//			int win=0;
//			for(int j=0;j<4;j++){
//				if(buttons[i*5+j].getText()=="X"){
//					win++;
//				}
//			}
//			if(win>=4){
//				JOptionPane.showMessageDialog(null, "sorry, AI win!");
//				return true;
//			}
//		}
		
		//Diagonal wins
		for(int i=0;i<3;i++){
			if((buttons[0+i].getText()=="X")&&(buttons[6+i].getText()=="X")&&(buttons[12+i].getText()=="X")
					   &&(buttons[18+i].getText()=="X")){
						JOptionPane.showMessageDialog(null, "sorry, AI wins! press reset button if you wanna another try!");
						return true;
					}
			}
		
		for(int i=0;i<3;i++){
			if((buttons[3+i].getText()=="X")&&(buttons[7+i].getText()=="X")&&(buttons[11+i].getText()=="X")
					   &&(buttons[15+i].getText()=="X")){
						JOptionPane.showMessageDialog(null, "sorry, AI wins! press reset button if you wanna another try!");
						return true;
					}
			}
	
		//check if you wins
		//Vertical wins
		for(int i=0;i<5;i++){
			if((buttons[0+i].getText()=="O")&&(buttons[5+i].getText()=="O")&&(buttons[10+i].getText()=="O")
			   &&(buttons[15+i].getText()=="O")){
				System.out.println("button value: "+buttons[0+i].getText());
				JOptionPane.showMessageDialog(null, "Congrats, you win! press reset button if still wanna play!");
				return true;
			}
		}//end for loop
			
		//Horizontal wins
		for(int i=0;i<16;i+=5){
			int win = 0;
			for(int j=0;j<4;j++){
				if(buttons[i+j].getText()=="O"){
					win++;
				}
			}
			if(win==4){
				JOptionPane.showMessageDialog(null, "Congrats, you win! press reset button if still wanna play!");
				return true;
			}
		}
		
		for(int i=1;i<16;i+=5){
			int win = 0;
			for(int j=0;j<4;j++){
				if(buttons[i+j].getText()=="O"){
					win++;
				}
			}
			if(win==4){
				JOptionPane.showMessageDialog(null, "Congrats, you win! press reset button if still wanna play!");
				return true;
			}
		}
			
		//Diagonal wins
		for(int i=0;i<2;i++){
			if((buttons[0+i].getText()=="O")&&(buttons[6+i].getText()=="O")&&(buttons[12+i].getText()=="O")
					   &&(buttons[18+i].getText()=="O")){
						JOptionPane.showMessageDialog(null, "Congrats, you win! press reset button if still wanna play!");
						return true;
					}
			}
		
		for(int i=0;i<2;i++){
			if((buttons[3+i].getText()=="O")&&(buttons[7+i].getText()=="O")&&(buttons[11+i].getText()=="O")
					   &&(buttons[15+i].getText()=="O")){
						JOptionPane.showMessageDialog(null, "Congrats, you win! press reset button if still wanna play!");
						return true;
					}
			}
		return false;
	
	}
	
	//main method to start program
	public static void main(String[] args){
		new TicTacToe();
	}
}

