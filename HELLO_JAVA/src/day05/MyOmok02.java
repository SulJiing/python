package day05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class MyOmok02 extends JFrame {

	private JPanel contentPane;
	boolean flag_wb = true;
	int[][] arr2D  = {
		{0,0,0,0,0,	0,0,0,0,0},
		{0,1,2,1,0,	0,0,0,0,0},
		{0,2,1,1,0,	0,0,0,0,0},
		{0,0,0,0,0,	0,0,0,0,0},
		{0,0,0,0,0,	0,0,0,0,0},
		
		{0,0,0,0,0,	0,0,0,0,0},
		{0,0,0,0,0,	0,0,0,0,0},
		{0,0,0,0,0,	0,0,0,0,0},
		{0,0,0,0,0,	0,0,0,0,0},
		{0,0,0,0,0,	0,0,0,0,2}
	};
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyOmok02 frame = new MyOmok02();
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
	public MyOmok02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				JLabel btn = new JLabel("");
				btn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						myclick(e);
					}
				});
				btn.setIcon(new ImageIcon(MyOmok02.class.getResource("/day05/0.png")));
				btn.setBounds(i*40, j*40, 40, 40);
				contentPane.add(btn);
			}
		}

		myrender();
	}
	void myrender() {
		
	}
	
	void myclick(MouseEvent e) {

	}
}