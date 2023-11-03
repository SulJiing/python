package day04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyS04 extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyS04 frame = new MyS04();
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
	public MyS04() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl = new JLabel("출력단수");
		lbl.setBounds(107, 29, 83, 34);
		contentPane.add(lbl);

		tf = new JTextField();
		tf.setBounds(202, 36, 96, 21);
		tf.setText("");
		contentPane.add(tf);
		tf.setColumns(10);

		JButton btn = new JButton("출력하기");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				click();
			}

		});
		btn.setBounds(120, 79, 178, 34);
		contentPane.add(btn);
		
		ta = new JTextArea();
		ta.setBounds(68, 148, 292, 392);
		ta.getText();
		contentPane.add(ta);
	}

	private void click() {
		String a = tf.getText();
		int dan = Integer.parseInt(a);
		String txt = "";
		for (int i = 1; i <= 9; i++) {
			System.out.println(dan + "" + "*" + i + "" + "=" + dan * i + "");
//			ta.append(dan + "" + "*" + i + "" + "=" + dan * i + "\n");
			txt += dan + "" + "*" + i + "" + "=" + dan * i + "\n";
		}
		ta.setText(txt);
	}
}
