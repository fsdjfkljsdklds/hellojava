package co.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class ComponentExam extends JFrame {
	public ComponentExam() {
		setTitle("라벨 예제");
		setSize(new Dimension(300, 250));

		JPanel panel = new JPanel();
		JLabel label = new JLabel("Color Label");
		label.setForeground(Color.yellow);
		label.setFont(new Font("Arial", Font.ITALIC, 25));
		label.setText("Yellow Font");
		JLabel label1 = new JLabel("Font Label");
		label1.setFont(new Font("Arial", Font.BOLD, 25));
		label1.setForeground(Color.green);

		JLabel label3 = new JLabel();
		ImageIcon icon = new ImageIcon("C:/temp/spring.jpg");
		
		// 이미지 크기 지정
		label3.setIcon(icon);
		label3.setPreferredSize(new Dimension(180, 150));

		panel.add(label);
		panel.add(label1);
		panel.add(label3);
		add(panel);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new ComponentExam();
	}
}
