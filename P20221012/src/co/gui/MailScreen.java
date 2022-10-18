package co.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MailScreen extends JFrame {

	Dimension lbl1 = new Dimension(65, 15);
	Dimension lbl2 = new Dimension(45, 15);

	JPanel center, bottom; // 컴포넌트를 모아두기 위한 컨테이너
	JLabel fromLbl, toLbl, subjectLbl, contentLbl; // 레이블
	JTextField fromTxt, toTxt, subjectTxt; // 텍스트필드
	JTextArea contentTxt;
	JButton send, cancel;

	MailApp app = new MailApp();

	public MailScreen() {
		setTitle("메일보내기 UI");
		setSize(360, 320);
		setLayout(new BorderLayout());

		// 패널
		center = new JPanel();
		bottom = new JPanel();

		// 라벨
		toLbl = new JLabel("받는사람");
		fromLbl = new JLabel("보내는사람");
		subjectLbl = new JLabel("메일제목");
		contentLbl = new JLabel("내용");
		toLbl.setPreferredSize(lbl1);
		fromLbl.setPreferredSize(lbl1);
		subjectLbl.setPreferredSize(lbl1);
		contentLbl.setPreferredSize(lbl2);

		// 텍스트필드
		toTxt = new JTextField(22);
		fromTxt = new JTextField(22);
		subjectTxt = new JTextField(22);
		contentTxt = new JTextArea(10, 25);

		// 버튼
		send = new JButton("보내기");
		send.addActionListener(new MyActionListener()); // ActionListener는 인터페이스 ->구현객체
		cancel = new JButton("취소");
		cancel.addActionListener(new MyActionListener()); // ActionListener는 인터페이스 ->구현객체

		// 컨테이너에 컴포넌트 배치(center)
		center.add(fromLbl);
		center.add(fromTxt);
		center.add(toLbl);
		center.add(toTxt);
		center.add(subjectLbl);
		center.add(subjectTxt);
		center.add(contentLbl);
		center.add(contentTxt);

		// 컨테이너에 컴포넌트 배치(bottom)
		bottom.add(send);
		bottom.add(cancel);

		// 윈도우에 컨테이너 배치
		add("Center", center);
		add("South", bottom);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	// 기능실행하는 구현객체
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();
			if (src == send) {
				String from = fromTxt.getText();
				String to = toTxt.getText();
				String subject = subjectTxt.getText();
				String content = contentTxt.getText();
				
				if(app.sendMail(from, to, subject, content).equals("Success")) {
					// 콘솔에 성공; -> 값을 지워주도록
					JOptionPane.showMessageDialog(null, "발송성공!!", "전송결과", JOptionPane.DEFAULT_OPTION);
					toTxt.setText("");
					fromTxt.setText("");
					subjectTxt.setText("");
					contentTxt.setText("");
				} else {
					//콘솔에 실패;
					JOptionPane.showMessageDialog(null, "발송실패!!", "에러", JOptionPane.WARNING_MESSAGE);
				}
			} else if (src == cancel) {
				System.out.println("취소버튼 actionPerformed.");
				toTxt.setText("");
				fromTxt.setText("");
				subjectTxt.setText("");
				contentTxt.setText("");
			}
		}
	}

	public static void main(String[] args) {
		new MailScreen();
	}

}
