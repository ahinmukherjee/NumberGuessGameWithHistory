import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.Random;

public class GuessNumberWithHistory{
	public static void main(String args[]){
		FrameTest ft = new FrameTest();
		ft.setVisible(true);
		ft.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class FrameTest extends JFrame{
	public FrameTest(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension scrsize = kit.getScreenSize();
		int w = scrsize.width;
		int h = scrsize.height;
		setSize(560, 550);
		setLocation(w / 5, h / 8);
		setTitle("Guess Number Game");
		setResizable(false);
		add(new FramePanels());
	}
}

class FramePanels extends JPanel implements ActionListener{
	JLabel title, subtitle, label, result;
	JTextField numberField;
	JButton clickButton, restartButton, exitButton;
	JTextArea historyArea;
	JScrollPane scrollPane;
	int number;
	int attempts = 0;
	int maxAttempts = 5;

	FramePanels() {
		setLayout(null);
		setBackground(new Color(18, 18, 35));
		title = new JLabel("NUMBER GUESS SYSTEM");
		title.setFont(new Font("Segoe UI", Font.BOLD, 28));
		title.setForeground(new Color(0, 255, 255));
		title.setBounds(80, 20, 400, 40);
		add(title);

		subtitle = new JLabel("Guess a number between 1 to 100");
		subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		subtitle.setForeground(Color.WHITE);
		subtitle.setBounds(135, 60, 260, 25);
		add(subtitle);

		label = new JLabel("Enter Number");
		label.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label.setForeground(Color.WHITE);
		label.setBounds(40, 115, 140, 30);
		add(label);

		numberField = new JTextField();
		numberField.setFont(new Font("Consolas", Font.BOLD, 18));
		numberField.setHorizontalAlignment(JTextField.CENTER);
		numberField.setBackground(new Color(40, 40, 60));
		numberField.setForeground(Color.CYAN);
		numberField.setCaretColor(Color.WHITE);
		numberField.setBorder(new LineBorder(Color.CYAN, 2));
		numberField.setBounds(190, 110, 180, 40);
		add(numberField);
		
		clickButton = new JButton("GUESS");
		clickButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		clickButton.setBackground(Color.BLUE);
		clickButton.setForeground(Color.WHITE);
		clickButton.setFocusPainted(false);
		clickButton.setBorder(new LineBorder(Color.WHITE, 1));
		clickButton.setBounds(40, 180, 130, 50);
		add(clickButton);

		restartButton = new JButton("RESTART");
		restartButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		restartButton.setBackground(new Color(255, 170, 0));
		restartButton.setForeground(Color.BLACK);
		restartButton.setFocusPainted(false);
		restartButton.setBounds(200, 180, 130, 50);
		add(restartButton);

		exitButton = new JButton("EXIT");
		exitButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		exitButton.setBackground(new Color(220, 53, 69));
		exitButton.setForeground(Color.WHITE);
		exitButton.setFocusPainted(false);
		exitButton.setBounds(360, 180, 130, 50);
		add(exitButton);

		result = new JLabel("Game Started");
		result.setFont(new Font("Segoe UI", Font.BOLD, 18));
		result.setForeground(Color.YELLOW);
		result.setBounds(160, 250, 250, 30);
		add(result);

		historyArea = new JTextArea();
		historyArea.setEditable(false);
		historyArea.setFont(new Font("Consolas", Font.PLAIN, 15));
		historyArea.setBackground(new Color(25, 25, 45));
		historyArea.setForeground(new Color(0, 255, 140));
		historyArea.setCaretColor(Color.WHITE);
		historyArea.setBorder(new EmptyBorder(10, 10, 10, 10));

		scrollPane = new JScrollPane(historyArea);
		scrollPane.setBounds(40, 300, 450, 180);
		scrollPane.setBorder(new LineBorder(Color.CYAN, 2));
		add(scrollPane);

		exitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				System.exit(0);
			}
		});

		clickButton.addActionListener(this);
		restartButton.addActionListener(this);
		startGame();
	}

	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == clickButton){
			checkGuess();
		}
		if(ae.getSource() == restartButton){
			startGame();
		}
	}

	public void startGame(){
		number = new Random().nextInt(100) + 1;
		attempts = 0;
		numberField.setText("");
		historyArea.setText("========== NEW GAME ==========\n\n");
		historyArea.append("Attempts Left: 5\n");
		result.setText("Guess The Number");
		numberField.setEnabled(true);
		clickButton.setEnabled(true);
	}

	public void checkGuess(){
	try{
		int guess =Integer.parseInt(numberField.getText());
		attempts++;
		int left = maxAttempts - attempts;
		if (guess < number){
			result.setText("Too Low!");
			historyArea.append("\nAttempts Left " + left +" -> Too Low!" +"\nEntered Number: " +guess + "\n");
			}
		else if (guess > number) {
			result.setText("Too High!");
			historyArea.append("\nAttempts Left " + left +" -> Too High!" +"\nEntered Number: " +guess + "\n");
			}
		else {
			result.setText("Correct Number!");
			historyArea.append("\nCorrect! Number Was: "+ guess + "\n");
			historyArea.append("\n====== YOU WIN ======\n");
			clickButton.setEnabled(false);
			numberField.setEnabled(false);
			return;
			}
		if (attempts >= maxAttempts){
			historyArea.append("\n====== GAME OVER ======\n");
			historyArea.append("Correct Number Was: "+ number);
			result.setText("Game Over!");
			clickButton.setEnabled(false);
			numberField.setEnabled(false);
			}
		numberField.setText("");
		}
		catch (Exception ex) {
			result.setText("Invalid Number!");
		}
	}
}