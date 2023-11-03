package day04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyS05 extends JFrame {

	private JPanel contentPane;
	JLabel lbl1 = new JLabel("_");
	JLabel lbl2 = new JLabel("_");
	JLabel lbl3 = new JLabel("_");
	JLabel lbl4 = new JLabel("_");
	JLabel lbl5 = new JLabel("_");
	JLabel lbl6 = new JLabel("_");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyS05 frame = new MyS05();
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
	public MyS05() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		lbl1.setBounds(12, 26, 50, 15);
		contentPane.add(lbl1);

		lbl2.setBounds(76, 26, 50, 15);
		contentPane.add(lbl2);

		lbl3.setBounds(135, 26, 50, 15);
		contentPane.add(lbl3);

		lbl4.setBounds(197, 26, 50, 15);
		contentPane.add(lbl4);

		lbl5.setBounds(259, 26, 50, 15);
		contentPane.add(lbl5);

		lbl6.setBounds(326, 26, 50, 15);
		contentPane.add(lbl6);

		JButton btnNewButton = new JButton("로또 생성하기");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				click();
			}

		});
		btnNewButton.setBounds(12, 61, 364, 23);
		contentPane.add(btnNewButton);
	}

	private void click() {
		
		int[] arr = {
		    1,2,3,4,5,6,7,8,9,10,
		    11,12,13,14,15,16,17,18,19,20,
		    21,22,23,24,25,26,27,28,29,30,
		    31,32,33,34,35,36,37,38,39,40,
		    41,42,42,43,44,45
		};
				
		
//		int rndArr[] = new int[6];
		
		for (int i = 0; i <= 1000; i++) {
			int rnd = (int)(Math.random()*45)+1;
			int a = arr[0];
			arr[0]=arr[rnd];
			arr[rnd] = a;
//			rndArr[i] = (int)(Math.random()*45) + 1;
		}
		for(int i =0; i<arr.length; i++) {
			System.out.print(arr[i]+",");
		}
		lbl1.setText(arr[0]+"");
		lbl2.setText(arr[1]+"");
		lbl3.setText(arr[2]+"");
		lbl4.setText(arr[3]+"");
		lbl5.setText(arr[4]+"");
		lbl6.setText(arr[5]+"");
	}
}
