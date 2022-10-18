package co.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import co.gui.MailScreen.MyActionListener;

public class SmsScreen extends JFrame {
	JPanel center, bottom;
	JLabel fromLbl, toLbl, contentLbl;
	JTextField fromTxt, toTxt;
	JTextArea contentTxt;
	JButton send, cancel;

	SmsApp app = new SmsApp();

	public SmsScreen() {
		setTitle("문자보내기 UI");
		setSize(280, 320);
		setLayout(new BorderLayout());

		center = new JPanel();
		bottom = new JPanel();

		toLbl = new JLabel("받는사람");
		fromLbl = new JLabel("보내는사람");
		contentLbl = new JLabel("내용");

		toTxt = new JTextField(22);
		fromTxt = new JTextField(22);
		contentTxt = new JTextArea(10, 25);

		send = new JButton("보내기");
		send.addActionListener(new MyActionListener());
		cancel = new JButton("취소");
		cancel.addActionListener(new MyActionListener());

		center.add(fromLbl);
		center.add(fromTxt);
		center.add(toLbl);
		center.add(toTxt);
		center.add(contentLbl);
		center.add(contentTxt);

		bottom.add(send);
		bottom.add(cancel);

		add("Center", center);
		add("South", bottom);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();
			if (src == send) {
				String from = fromTxt.getText();
				String to = toTxt.getText();
				String content = contentTxt.getText();

				app.sendSms(to, from, content);
				JOptionPane.showMessageDialog(null, "발송성공!!", "전송결과", JOptionPane.DEFAULT_OPTION);
				toTxt.setText("");
				fromTxt.setText("");
				contentTxt.setText("");

			} else if (src == cancel) {
				toTxt.setText("");
				fromTxt.setText("");
				contentTxt.setText("");
			}

		}

	}

	public static void main(String[] args) {
		new SmsScreen();
	}

}
