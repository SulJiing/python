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

public class MyS07 extends JFrame {

	private JPanel contentPane;
	private JTextField tf_first;
	private JTextField tf_last;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyS07 frame = new MyS07();
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
	public MyS07() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_first = new JLabel("첫별수:");
		lbl_first.setBounds(12, 93, 50, 15);
		contentPane.add(lbl_first);
		
		JLabel lbl_last = new JLabel("끝별수:");
		lbl_last.setBounds(12, 129, 50, 15);
		contentPane.add(lbl_last);
		
		tf_first = new JTextField();
		tf_first.setBounds(74, 90, 96, 21);
		contentPane.add(tf_first);
		tf_first.setColumns(10);
		
		tf_last = new JTextField();
		tf_last.setBounds(74, 126, 96, 21);
		contentPane.add(tf_last);
		tf_last.setColumns(10);
		
		JButton btn = new JButton("별그리기");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myClick();
			}

		});
		btn.setBounds(12, 173, 160, 28);
		contentPane.add(btn);
		
		ta = new JTextArea();
		ta.setBounds(206, 10, 218, 243);
		contentPane.add(ta);
	}

	public String getStar(int cnt) {
		String ret = "";
		for(int i=0; i<cnt; i++) {
			ret += "*";
		}
		ret += "\n";
		return ret;
	}
	
	private void myClick() {
		String f = tf_first.getText();
		String l = tf_last.getText();
		int ff = Integer.parseInt(f);
		int ll = Integer.parseInt(l);
		
		String txt = "";
		
		for(int i=ff;i<=ll;i++) {
			txt += getStar(i);
		}
		ta.setText(txt);
	}
}