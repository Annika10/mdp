package annika.mdp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener {

	int count = 0;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JFrame frame;
	private JPanel panel;
	private static JTextField textfield1;
	private JTextField textfield2;
	private JTextField textfield3;
	private JTextField textfield4;
	private JTextField textfield5;
	private JTextField textfield6;
	
	public GUI() {
		
		frame = new JFrame();
				
		JButton button = new JButton("Click me");
		button.addActionListener(this);
		
		label1 = new JLabel("Startdate");
		label1.setFont(new Font("Serif", Font.BOLD, 40));
		textfield1 = new JTextField("DD.MM.YYYY");
		textfield1.setFont(new Font("Serif", Font.BOLD, 40));
		
		label2 = new JLabel("Enddate");
		label2.setFont(new Font("Serif", Font.BOLD, 40));
		textfield2 = new JTextField("DD.MM.YYYY");
		textfield2.setFont(new Font("Serif", Font.BOLD, 40));
		
		label3 = new JLabel("Number");
		label3.setFont(new Font("Serif", Font.BOLD, 40));
		textfield3 = new JTextField("DD.MM.YYYY");
		textfield3.setFont(new Font("Serif", Font.BOLD, 40));
		
		label4 = new JLabel("new Startdate");
		label4.setFont(new Font("Serif", Font.BOLD, 40));
		textfield4 = new JTextField();
		textfield4.setFont(new Font("Serif", Font.BOLD, 40));
		
		label5 = new JLabel("new Enddate");
		label5.setFont(new Font("Serif", Font.BOLD, 40));
		textfield5 = new JTextField("DD.MM.YYYY");
		textfield5.setFont(new Font("Serif", Font.BOLD, 40));
		
		label6 = new JLabel("Redaktionsschluss");
		label6.setFont(new Font("Serif", Font.BOLD, 40));
		textfield6 = new JTextField("DD.MM.YYYY");
		textfield6.setFont(new Font("Serif", Font.BOLD, 40));
		

		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 300, 300));
		panel.setLayout(new GridLayout(0, 2));
		
		panel.add(label1);
		panel.add(textfield1);
		panel.add(label2);
		panel.add(textfield2);
		panel.add(label3);
		panel.add(textfield3);
		panel.add(label4);
		panel.add(textfield4);
		panel.add(label5);
		panel.add(textfield5);
		panel.add(label6);
		panel.add(textfield6);
		
		panel.add(button);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Messdienerplanprogramm");
		frame.pack();
		frame.setVisible(true);
		
		//open window in center of monitor
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		
		
	}
	public static void main(String[] args) {
		new GUI();
		System.out.println(textfield1.getText());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		label1.setText("Number of clicks: "+ count);
	}

}
