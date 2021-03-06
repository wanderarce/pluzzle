package pluzzle.engine;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Engine extends JFrame implements ActionListener {

	private static final long serialVersionUID = -1689655435011405996L;

	private JButton next;

	public List<JButton> buttons = new ArrayList<JButton>();
	private int width = 50;
	private int height = 40;

	private List<String> initialData = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", " ");
	private List<String> temp = new ArrayList<String>();

	public Engine() {
		super("Puzzle Game");
		initData();

	}

	private void setCoordinates(int i, JButton jButton) {
		JButton btn = jButton;
		int x = 20;
		int y = 40;
		x = getCoordinateX(i, x);
		y = getCoordinateY(i, y);
		btn.setBounds(x, y, width, height);

	}

	private int getCoordinateY(int i, int y) {
		if (i >= 3 && i <= 5) {
			y = 90;
		} else if (i > 5) {
			y = 140;
		}
		return y;
	}

	private int getCoordinateX(int i, int x) {
		if (i == 1 || i == 4 || i == 7) {
			x = 80;
		} else if (i == 2 || i == 5 || i == 8) {
			x = 140;
		}
		return x;
	}

	private void initData() {
		temp.clear();
		buttons.clear();
		Random rand = new Random();

		while (temp.size() < 9) {
			getRandomValue(rand);
		}
		addButtons();

		for (int i = 0; i < buttons.size(); i++) {
			setCoordinates(i, buttons.get(i));
		}

		for (JButton jButton : buttons) {
			add(jButton);
			jButton.addActionListener(this);
		}
		next = new JButton("next");
		next.setBounds(100, 220, 100, 40);

		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				new Engine();

			}
		});
		add(next);

		next.setBackground(Color.black);
		next.setForeground(Color.green);
		setSize(260, 350);

		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void addButtons() {
		for (String item : temp) {
			buttons.add(new JButton(item));
		}
	}

	private String getRandomValue(Random rand) {
		int randomIndex = rand.nextInt(initialData.size());

		String value = initialData.get(randomIndex);
		if (temp.isEmpty() || !temp.contains(value)) {

			temp.add(value);

		} else {
			return getRandomValue(rand);
		}
		return value;

	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn.getText() == " ") {
			JOptionPane.showMessageDialog(Engine.this, "Clique em um item com valor!!");
			return;
		}
		checkZero(e);

		checkOne(e);

		checkTwo(e);

		checkThree(e);

		checkFour(e);

		checkFive(e);

		checkSix(e);

		checkSeven(e);

		checkEight(e);

		if (assertResults()) {
			JOptionPane.showMessageDialog(Engine.this, "Voc??? ganhou!!");
		}

	}

	private void checkEight(ActionEvent e) {
		if (e.getSource() == buttons.get(8)) {
			String s = buttons.get(8).getText();
			if (buttons.get(5).getText().equals(" ")) {
				buttons.get(5).setText(s);
				buttons.get(8).setText(" ");
			} else if (buttons.get(7).getText().equals(" ")) {
				buttons.get(7).setText(s);
				buttons.get(8).setText(" ");
			}
		}
	}

	private void checkSeven(ActionEvent e) {
		if (e.getSource() == buttons.get(7)) {
			String s = buttons.get(7).getText();
			if (buttons.get(6).getText().equals(" ")) {
				buttons.get(6).setText(s);
				buttons.get(7).setText(" ");
			} else if (buttons.get(8).getText().equals(" ")) {
				buttons.get(8).setText(s);
				buttons.get(7).setText(" ");
			} else if (buttons.get(4).getText().equals(" ")) {
				buttons.get(4).setText(s);
				buttons.get(7).setText(" ");
			}

		}
	}

	private void checkSix(ActionEvent e) {
		if (e.getSource() == buttons.get(6)) {
			String s = buttons.get(6).getText();
			if (buttons.get(3).getText().equals(" ")) {
				buttons.get(3).setText(s);
				buttons.get(6).setText(" ");
			} else if (buttons.get(7).getText().equals(" ")) {
				buttons.get(7).setText(s);
				buttons.get(6).setText(" ");
			}

		}
	}

	private void checkFive(ActionEvent e) {
		if (e.getSource() == buttons.get(5)) {

			String s = buttons.get(5).getText();
			if (buttons.get(4).getText().equals(" ")) {
				buttons.get(4).setText(s);
				buttons.get(5).setText(" ");
			}
			if (buttons.get(8).getText().equals(" ")) {
				buttons.get(8).setText(s);
				buttons.get(5).setText(" ");
			} else if (buttons.get(2).getText().equals(" ")) {
				buttons.get(2).setText(s);
				buttons.get(5).setText(" ");
			}

		}
	}

	private void checkFour(ActionEvent e) {
		if (e.getSource() == buttons.get(4)) {
			String s = buttons.get(4).getText();
			if (buttons.get(1).getText().equals(" ")) {
				buttons.get(1).setText(s);
				buttons.get(4).setText(" ");
			} else if (buttons.get(3).getText().equals(" ")) {
				buttons.get(3).setText(s);
				buttons.get(4).setText(" ");
			} else if (buttons.get(5).getText().equals(" ")) {
				buttons.get(5).setText(s);
				buttons.get(4).setText(" ");
			} else if (buttons.get(7).getText().equals(" ")) {
				buttons.get(7).setText(s);
				buttons.get(4).setText(" ");
			}
		}
	}

	private void checkThree(ActionEvent e) {
		if (e.getSource() == buttons.get(3)) {
			String s = buttons.get(3).getText();
			if (buttons.get(0).getText().equals(" ")) {
				buttons.get(0).setText(s);
				buttons.get(3).setText(" ");
			} else if (buttons.get(6).getText().equals(" ")) {
				buttons.get(6).setText(s);
				buttons.get(3).setText(" ");
			} else if (buttons.get(4).getText().equals(" ")) {
				buttons.get(4).setText(s);
				buttons.get(3).setText(" ");
			}
		}
	}

	private void checkTwo(ActionEvent e) {
		if (e.getSource() == buttons.get(1)) {
			String s = buttons.get(1).getText();
			if (buttons.get(0).getText().equals(" ")) {
				buttons.get(0).setText(s);
				buttons.get(1).setText(" ");
			} else if (buttons.get(2).getText().equals(" ")) {
				buttons.get(2).setText(s);
				buttons.get(1).setText(" ");
			} else if (buttons.get(4).getText().equals(" ")) {
				buttons.get(4).setText(s);
				buttons.get(1).setText(" ");
			}
		}
	}

	private void checkOne(ActionEvent e) {
		if (e.getSource() == buttons.get(2)) {
			String s = buttons.get(2).getText();
			if (buttons.get(1).getText().equals(" ")) {
				buttons.get(1).setText(s);
				buttons.get(2).setText(" ");
			} else if (buttons.get(5).getText().equals(" ")) {
				buttons.get(5).setText(s);
				buttons.get(2).setText(" ");
			}
		}
	}

	private void checkZero(ActionEvent e) {
		if (e.getSource() == buttons.get(0)) {
			String s = buttons.get(0).getText();
			if (buttons.get(1).getText().equals(" ")) {
				buttons.get(1).setText(s);
				buttons.get(0).setText(" ");
			} else if (buttons.get(3).getText().equals(" ")) {
				buttons.get(3).setText(s);
				buttons.get(0).setText(" ");
			}
		}
	}

	private boolean assertResults() {
		boolean valid = true;
		for (int i = 0; i < buttons.size(); i++) {
			if (!buttons.get(i).getText().equals(initialData.get(i))) {
				valid = false;
			}
		}
		return valid;
	}

}// end of class