package co.gui;

import java.awt.*;

import javax.swing.*;

public class ComponentExam2 extends JFrame {
	public ComponentExam2() {
		setTitle("입력필드 UI");
		setSize(400, 130);

		Dimension lblDim = new Dimension(60, 16);

		setLayout(new BorderLayout());

		JPanel center = new JPanel(new FlowLayout());
		JPanel bottom = new JPanel();

		JPanel panel = new JPanel(new BorderLayout());

		JLabel idLb = new JLabel("id");
		idLb.setPreferredSize(lblDim);
		JLabel pwLb = new JLabel("pw");
		pwLb.setPreferredSize(lblDim);

		JTextField idTxt = new JTextField(23);
		JTextField pwTxt = new JPasswordField(23);

		center.add(idLb);
		center.add(idTxt);
		center.add(pwLb);
		center.add(pwTxt);

		JButton btn = new JButton("확인");
		bottom.add(btn);
		
		

		add("Center",center);
		add("South",bottom);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new ComponentExam2();
	}
}
