package calculatorbuild;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Calculator implements ActionListener {
	JFrame calculatorFrame;
	
	JLabel screen,operationScreen; //operationScreen shows the numbers and operator in the left top of output.
	
	JButton oneButton,twoButton,threeButton,fourButton,fiveButton,sixButton,sevenButton,eightButton,nineButton,zeroButton,doubleZeroButton;
	JButton clearButton,backButton,signChangeButton,decimalButton,divButton,mulButton,minusButton,plusButton,equalButton;
	
	int answer,operatorSwitchCase=0;  //Sets 1 for addition, 2 for subtraction, 3 for multiplication, 4 for division for switch operation.
	float firstNumber,secondNumber,result;
	boolean canClickAnyOperator=false, //Used to avoid error due to initial click of operator without entering a number.
			isDecimalButtonClicked=false, //Used to avoid the error due to repetitive clicks of decimal point in one number.
			canClickAnyNumber=true; //Used to ensure no number is clicked after displaying answer, until an operator is clicked.

	
	public Calculator() {

		calculatorFrame = new JFrame("Calculator");
		calculatorFrame.setLayout(null);
		calculatorFrame.setSize(390, 500);
		calculatorFrame.setLocation(350, 80);
		
		operationScreen = new JLabel();
		operationScreen.setBounds(30, 30, 330, 40);
		operationScreen.setBackground(Color.darkGray);
		operationScreen.setForeground(Color.orange);
		operationScreen.setFont(new Font("Arial", Font.PLAIN, 25));
		operationScreen.setOpaque(true);

		screen = new JLabel();
		screen.setBounds(30, 70,330, 50);
		screen.setBackground(Color.darkGray);
		screen.setForeground(Color.white);
		screen.setFont(new Font("Arial", Font.BOLD, 35));
		screen.setHorizontalAlignment(SwingConstants.RIGHT);
		screen.setOpaque(true);

		int buttonFontSize = 22;
		clearButton = new JButton("AC");
		clearButton.setBounds(30, 155, 70, 50);
		clearButton.setFont(new Font("Arial", Font.BOLD, buttonFontSize));
		clearButton.setForeground(Color.red);
		clearButton.addActionListener(this);
		
		backButton = new JButton("B<");
		backButton.setBounds(105, 155, 70, 50);
		backButton.setFont(new Font("Arial", Font.BOLD, buttonFontSize));
		backButton.setForeground(Color.red);
		backButton.addActionListener(this);
		
		signChangeButton = new JButton("+/-");
		signChangeButton.setBounds(180, 155, 70, 50);
		signChangeButton.setFont(new Font("Arial", Font.BOLD, buttonFontSize));
		signChangeButton.addActionListener(this);
		
		sevenButton = new JButton("7");
		sevenButton.setBounds(30, 210, 70, 50);
		sevenButton.setFont(new Font("Arial", Font.BOLD, buttonFontSize));
		sevenButton.addActionListener(this);
		
		eightButton = new JButton("8");
		eightButton.setBounds(105, 210, 70, 50);
		eightButton.setFont(new Font("Arial", Font.BOLD, buttonFontSize));
		eightButton.addActionListener(this);
		
		nineButton = new JButton("9");
		nineButton.setBounds(180, 210, 70, 50);
		nineButton.setFont(new Font("Arial", Font.BOLD, buttonFontSize));
		nineButton.addActionListener(this);
		
		fourButton = new JButton("4");
		fourButton.setBounds(30, 265, 70, 50);
		fourButton.setFont(new Font("Arial", Font.BOLD, buttonFontSize));
		fourButton.addActionListener(this);
		
		fiveButton = new JButton("5");
		fiveButton.setBounds(105, 265, 70, 50);
		fiveButton.setFont(new Font("Arial", Font.BOLD, buttonFontSize));
		fiveButton.addActionListener(this);
		
		sixButton = new JButton("6");
		sixButton.setBounds(180, 265, 70, 50);
		sixButton.setFont(new Font("Arial", Font.BOLD, buttonFontSize));
		sixButton.addActionListener(this);
		
		oneButton = new JButton("1");
		oneButton.setBounds(30, 320, 70, 50);
		oneButton.setFont(new Font("Arial", Font.BOLD, buttonFontSize));
		oneButton.addActionListener(this);
		
		twoButton = new JButton("2");
		twoButton.setBounds(105, 320, 70, 50);
		twoButton.setFont(new Font("Arial", Font.BOLD, buttonFontSize));
		twoButton.addActionListener(this);
		
		threeButton = new JButton("3");
		threeButton.setBounds(180, 320, 70, 50);
		threeButton.setFont(new Font("Arial", Font.BOLD, buttonFontSize));
		threeButton.addActionListener(this);
		
		doubleZeroButton = new JButton("00");
		doubleZeroButton.setBounds(30, 375, 70, 50);
		doubleZeroButton.setFont(new Font("Arial", Font.BOLD, buttonFontSize));
		doubleZeroButton.addActionListener(this);
		
		zeroButton = new JButton("0");
		zeroButton.setBounds(105, 375, 70, 50);
		zeroButton.setFont(new Font("Arial", Font.BOLD, buttonFontSize));
		zeroButton.addActionListener(this);
		
		decimalButton = new JButton(".");
		decimalButton.setBounds(180, 375, 70, 50);
		decimalButton.setFont(new Font("Arial", Font.BOLD, buttonFontSize));
		decimalButton.addActionListener(this);
		
		divButton = new JButton("/");
		divButton.setBounds(280, 155, 80, 50);
		divButton.setFont(new Font("Arial", Font.PLAIN, buttonFontSize));
		divButton.setBackground(Color.orange);
		divButton.addActionListener(this);
		
		mulButton = new JButton("x");
		mulButton.setBounds(280, 210, 80, 50);
		mulButton.setFont(new Font("Arial", Font.PLAIN, buttonFontSize));
		mulButton.setBackground(Color.orange);
		mulButton.addActionListener(this);
		
		minusButton = new JButton("-");
		minusButton.setBounds(280, 265, 80, 50);
		minusButton.setFont(new Font("Arial", Font.BOLD, buttonFontSize));
		minusButton.setBackground(Color.orange);
		minusButton.addActionListener(this);
		
		plusButton = new JButton("+");
		plusButton.setBounds(280, 320, 80, 50);
		plusButton.setFont(new Font("Arial", Font.PLAIN, buttonFontSize));
		plusButton.setBackground(Color.orange);
		plusButton.addActionListener(this);
		
		equalButton = new JButton("=");
		equalButton.setBounds(280, 375, 80, 50);
		equalButton.setFont(new Font("Arial", Font.BOLD, buttonFontSize));
		equalButton.setBackground(Color.darkGray);
		equalButton.setForeground(Color.white);
		equalButton.addActionListener(this);
		

		
		calculatorFrame.add(clearButton);
		calculatorFrame.add(backButton);
		calculatorFrame.add(signChangeButton);
		calculatorFrame.add(sevenButton);
		calculatorFrame.add(eightButton);
		calculatorFrame.add(nineButton);
		calculatorFrame.add(sixButton);
		calculatorFrame.add(fiveButton);
		calculatorFrame.add(fourButton);
		calculatorFrame.add(oneButton);
		calculatorFrame.add(twoButton);
		calculatorFrame.add(threeButton);
		calculatorFrame.add(doubleZeroButton);
		calculatorFrame.add(zeroButton);
		calculatorFrame.add(decimalButton);
		calculatorFrame.add(divButton);
		calculatorFrame.add(mulButton);
		calculatorFrame.add(minusButton);
		calculatorFrame.add(plusButton);
		calculatorFrame.add(equalButton);

		calculatorFrame.add(screen);
		calculatorFrame.add(operationScreen);
		calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculatorFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent click) {

		if(click.getSource()==clearButton) {
			screen.setText("");
			operationScreen.setText("");
			canClickAnyOperator=false;
			isDecimalButtonClicked=false;
			canClickAnyNumber=true;
			
		}else if(click.getSource()==backButton) {
			if(screen.getText()!="" && canClickAnyNumber==true) {
				screen.setText(screen.getText().substring(0, screen.getText().length()-1));
			}else if(operatorSwitchCase!=0) {
				decimalRemove(firstNumber);
				operatorSwitchCase=0;
				operationScreen.setText("");
				canClickAnyOperator=true;
			}
			
		}else if(click.getSource()==signChangeButton && canClickAnyNumber==true) {
			if(screen.getText()=="") {
				screen.setText("-");
			}else if(screen.getText()=="-") {
				screen.setText("");
			}
			
		}else if(click.getSource()==sevenButton && canClickAnyNumber==true) {
			screen.setText(screen.getText()+"7");
			canClickAnyOperator=true;

		}else if(click.getSource()==eightButton && canClickAnyNumber==true) {
			screen.setText(screen.getText()+"8");
			canClickAnyOperator=true;
			
		}else if(click.getSource()==nineButton && canClickAnyNumber==true) {
			screen.setText(screen.getText()+"9");
			canClickAnyOperator=true;

		}else if(click.getSource()==fourButton && canClickAnyNumber==true) {
			screen.setText(screen.getText()+"4");
			canClickAnyOperator=true;

		}else if(click.getSource()==fiveButton && canClickAnyNumber==true) {
			screen.setText(screen.getText()+"5");
			canClickAnyOperator=true;

		}else if(click.getSource()==sixButton && canClickAnyNumber==true) {
			screen.setText(screen.getText()+"6");
			canClickAnyOperator=true;

		}else if(click.getSource()==oneButton && canClickAnyNumber==true) {
			screen.setText(screen.getText()+"1");
			canClickAnyOperator=true;

		}else if(click.getSource()==twoButton && canClickAnyNumber==true) {
			screen.setText(screen.getText()+"2");
			canClickAnyOperator=true;

		}else if(click.getSource()==threeButton && canClickAnyNumber==true) {
			screen.setText(screen.getText()+"3");
			canClickAnyOperator=true;

		}else if(click.getSource()==doubleZeroButton && canClickAnyNumber==true) {
			screen.setText(screen.getText()+"00");
			canClickAnyOperator=true;
			
		}else if(click.getSource()==zeroButton && canClickAnyNumber==true) {
			screen.setText(screen.getText()+"0");
			canClickAnyOperator=true;
			
		}else if(click.getSource()==decimalButton && isDecimalButtonClicked==false && canClickAnyNumber==true) {
			if(screen.getText() == "") {
				screen.setText("0.");
				isDecimalButtonClicked=true;
			}else {
				screen.setText(screen.getText()+".");
				isDecimalButtonClicked=true;
			}
			
		}else if(click.getSource()==divButton && screen.getText()!="" && canClickAnyOperator==true) {
			operationScreen.setText(" " + screen.getText()+" /");
			firstNumber=Float.parseFloat(screen.getText());
			operatorSwitchCase=4;
			screen.setText("");
			canClickAnyOperator=false;
			isDecimalButtonClicked=false;
			canClickAnyNumber=true;
				
		}else if(click.getSource()==mulButton && screen.getText()!="" && canClickAnyOperator==true) {
			operationScreen.setText(" " + screen.getText()+" x");
			firstNumber=Float.parseFloat(screen.getText());
			operatorSwitchCase=3;
			screen.setText("");
			canClickAnyOperator=false;
			isDecimalButtonClicked=false;
			canClickAnyNumber=true;
				
		}else if(click.getSource()==minusButton && screen.getText()!="" && canClickAnyOperator==true) {
			operationScreen.setText(" " + screen.getText()+" -");
			firstNumber=Float.parseFloat(screen.getText());
			operatorSwitchCase=2;
			screen.setText("");
			canClickAnyOperator=false;
			isDecimalButtonClicked=false;
			canClickAnyNumber=true;
			
		}else if(click.getSource()==plusButton && screen.getText()!="" && canClickAnyOperator==true) {
			operationScreen.setText(" " + screen.getText()+" +");
			firstNumber=Float.parseFloat(screen.getText());
			operatorSwitchCase=1;
			screen.setText("");
			canClickAnyOperator=false;
			isDecimalButtonClicked=false;
			canClickAnyNumber=true;

			
			
		}else if(click.getSource()==equalButton && canClickAnyOperator==true && operatorSwitchCase !=0) {
			operationScreen.setText(operationScreen.getText() + " " + screen.getText()+" =");
			secondNumber=Float.parseFloat(screen.getText());

			result = arithmeticOperation(firstNumber, secondNumber, operatorSwitchCase);
			decimalRemove(result);
			firstNumber=0;
			operatorSwitchCase=0;
			canClickAnyOperator = true;
			isDecimalButtonClicked=false;
			canClickAnyNumber=false;
			
		}
	}
	
	float arithmeticOperation(float number1,float number2,int choice) {
		switch(choice) {
		case 1: result=number1+number2;
			break;
		case 2: result=number1-number2;
			break;
		case 3: result=number1*number2;
			break;
		case 4: result=number1/number2;
			break;
		default :
			result =0;
		}
		return result;
	}
	
	void decimalRemove(float number) {  //Function to remove .0 in float number. Also, if there are values in decimal places,they're retained.
		answer= (int) number;
		if(number-answer==0) {
			screen.setText( answer+"");
		}else {
			screen.setText(number +"");
		}
	}

	public static void main(String[] args) {
		new Calculator();
	}
}
