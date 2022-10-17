package co.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {

	public MyFrame() {

		setTitle("윈도우 UI"); // 윈도우제목
		setSize(300, 250); // 윈도우사이즈

		setLayout(new FlowLayout()); // 배치관리자

		JButton btn = new JButton("확인"); // 버튼
		JButton btn1 = new JButton("취소"); // 취소

		// 정석
//		btn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("확인버튼 클릭.");
//			}
//		});
//		btn1.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("취소버튼 클릭.");
//				System.exit(0);
//			}
//		});

		// 람다표현식
		btn.addActionListener(e -> System.out.println("확인버튼 클릭."));
		btn1.addActionListener((e) -> {
			System.out.println("취소버튼 클릭.");
			System.exit(0);
		});

		add(btn); // 컨트롤등록
		add(btn1);

		setVisible(true); // 화면출력
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 화면종료

	}

	public static void main(String[] args) {
		new MyFrame();
	}
}
