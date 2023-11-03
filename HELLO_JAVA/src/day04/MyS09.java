package day04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.PublicKey;

import javax.swing.SwingConstants;

public class MyS09 extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	private JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;
	String a = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyS09 frame = new MyS09();
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
	public MyS09() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 281, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf = new JTextField();
		tf.setHorizontalAlignment(SwingConstants.RIGHT);
		tf.setBounds(12, 10, 214, 26);
		contentPane.add(tf);
		tf.setColumns(10);
		
		JButton btn1 = new JButton("1");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a += "1";
				
				tf.setText(a);
//				a += String.valueOf(tf.setText("1"));
			}
		});
		btn1.setBounds(12, 46, 64, 26);
		contentPane.add(btn1);
		
		JButton btn4 = new JButton("4");
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a += "4";
				tf.setText(a);
			}
		});
		btn4.setBounds(12, 81, 64, 26);
		contentPane.add(btn4);
		
		JButton btn2 = new JButton("2");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a += "2";
				tf.setText(a);
			}
		});
		btn2.setBounds(84, 46, 64, 26);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a += "3";
				tf.setText(a);
			}
		});
		btn3.setBounds(162, 46, 64, 26);
		contentPane.add(btn3);
		
		JButton btn5 = new JButton("5");
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a += "5";
				tf.setText(a);
			}
		});
		btn5.setBounds(84, 82, 64, 26);
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a += "6";
				tf.setText(a);
			}
		});
		btn6.setBounds(162, 83, 64, 26);
		contentPane.add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a += "7";
				tf.setText(a);
			}
		});
		btn7.setBounds(12, 117, 64, 26);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a += "8";
				tf.setText(a);
			}
		});
		btn8.setBounds(84, 118, 64, 26);
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a += "9";
				tf.setText(a);
			}
		});
		btn9.setBounds(162, 119, 64, 26);
		contentPane.add(btn9);
		
		JButton btn0 = new JButton("0");
		btn0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a += "0";
				tf.setText(a);
			}
		});
		btn0.setBounds(12, 153, 64, 26);
		contentPane.add(btn0);
		
		JButton btn_call = new JButton("☎");
		btn_call.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "calling...\n"+a);
			}
		});
		btn_call.setBounds(84, 154, 142, 26);
		contentPane.add(btn_call);
		
		btn1.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {myClick(e);}});
		btn2.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {myClick(e);}});
		btn3.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {myClick(e);}});
		btn4.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {myClick(e);}});
		btn5.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {myClick(e);}});
		btn6.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {myClick(e);}});
		btn7.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {myClick(e);}});
		btn8.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {myClick(e);}});
		btn9.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {myClick(e);}});
		btn0.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {myClick(e);}});
		btn1.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {myClick(e);}});
		
		btn_call.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {myCall();}});
	}
		private void myClick(MouseEvent e) {
			JButton temp = (JButton) e.getSource();
			String str_new = temp.getText();
			String str_old = tf.getText();
			
			tf.setText(str_old+str_new);
	}
		private void myCall() {
			String str_new = tf.getText();
			JOptionPane.showMessageDialog(null, "calling...\n"+str_new);
		}
}