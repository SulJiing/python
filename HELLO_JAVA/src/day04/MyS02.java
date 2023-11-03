package day04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyS02 extends JFrame {

	private JPanel contentPane;
	private JTextField tf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyS02 frame = new MyS02();
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
	public MyS02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf = new JTextField();
		tf.setBounds(41, 55, 96, 66);
		tf.setHorizontalAlignment(SwingConstants.RIGHT);
		tf.setText("200");
		contentPane.add(tf);
		tf.setColumns(10);
		
		JButton btn = new JButton("DECREASE");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				int count = Integer.parseInt(tf.getText());
//					count -= 1;
//				tf.setText("count");
				myClick();
			}

			
		});
		btn.setBounds(232, 76, 129, 23);
		contentPane.add(btn);
	}
	
	private void myClick() {
		String a = tf.getText();
		int aa = Integer.parseInt(a);
		aa--;
		tf.setText(String.valueOf(aa));
	}
}
