package day04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyS08 extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	private JTextArea ta;
	int com = (int) (Math.random() * 99);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyS08 frame = new MyS08();
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
	public MyS08() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 275, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl = new JLabel("맞출수");
		lbl.setBounds(48, 37, 50, 15);
		contentPane.add(lbl);

		tf = new JTextField();
		tf.setBounds(130, 34, 96, 21);
		contentPane.add(tf);
		tf.setColumns(10);

		JButton btn = new JButton("맞춰보기");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				click();
			}

		});
		btn.setBounds(58, 62, 146, 23);
		contentPane.add(btn);

		ta = new JTextArea();
		ta.setBounds(12, 95, 237, 158);
		contentPane.add(ta);
	}

	private void click() {
			System.out.println(com);
			String mine = tf.getText();
			int mm = Integer.parseInt(mine);
			String str_new = "";
			if (mm < com) {
				str_new = mine + "보다 UP\n";
			} else if (mm > com) {
				str_new = mine + "보다 DOWN\n";
			} else if (mm == com) {
				str_new = mine + " 정답\n";
				JOptionPane.showMessageDialog(null, mm+"정답입니다");
		}
			String str_old = ta.getText();
			
			ta.setText(str_old+str_new);
			tf.setText("");
	}
}
