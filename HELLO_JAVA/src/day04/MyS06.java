package day04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyS06 extends JFrame {

	private JPanel contentPane;
	private JTextField tf_mine;
	private JTextField tf_com;
	private JTextField tf_result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyS06 frame = new MyS06();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyS06() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 236, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_mine = new JLabel("나:");
		lbl_mine.setBounds(45, 29, 50, 15);
		contentPane.add(lbl_mine);
		
		JLabel lbl_com = new JLabel("컴:");
		lbl_com.setBounds(45, 67, 50, 15);
		contentPane.add(lbl_com);
		
		JLabel lbl_result = new JLabel("결과:");
		lbl_result.setBounds(45, 104, 50, 15);
		contentPane.add(lbl_result);
		
		tf_mine = new JTextField();
		tf_mine.setBounds(107, 26, 96, 21);
		contentPane.add(tf_mine);
		tf_mine.setColumns(10);
		
		tf_com = new JTextField();
		tf_com.setColumns(10);
		tf_com.setBounds(107, 64, 96, 21);
		contentPane.add(tf_com);
		
		tf_result = new JTextField();
		tf_result.setColumns(10);
		tf_result.setBounds(107, 101, 96, 21);
		contentPane.add(tf_result);
		
		JButton btn = new JButton("게임하기");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myClick();
			}

		});
		btn.setBounds(45, 152, 158, 38);
		contentPane.add(btn);
	}

	private void myClick() {
		String mine = tf_mine.getText().trim();
		double com = (double)(Math.random());
		System.out.println(com);
		String com1 = "";
		String result = "";
		if(com<= 0.5) {
			com1 = "짝";
		} else if (com>0.5){
			com1 = "홀";
		}
		tf_com.setText(com1);
		if (com1.equals(mine)) {
			result = "승리!!";
		} else if (!com1.equals(mine)) {
			result = "패배ㅠㅠ";
		} else {
			result = "잘못된 값 입력!";
		}
		tf_result.setText(result);
	}
}
