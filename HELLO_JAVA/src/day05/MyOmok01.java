package day05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyOmok01 extends JFrame {

	private JPanel contentPane;
	private JButton btn;
	private int cnt;
	private boolean flag_wb = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyOmok01 frame = new MyOmok01();
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
	public MyOmok01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 787);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_reset = new JButton("처음으로");
		btn_reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btn.setIcon(new ImageIcon("/day05/0.png"));
			}
		});
		btn_reset.setBounds(669, 342, 91, 23);
		contentPane.add(btn_reset);
		
		for(int i=2; i<=15; i++) { 
			for(int j =2; j<=15; j++) {
		btn = new JButton("");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myClick(e);
			}
		});
		
		btn.setIcon(new ImageIcon(MyOmok01.class.getResource("/day05/0.png")));
		btn.setBounds(40*i, 40*j, 40, 40); // X, Y, WIDTH, HEIGHT
		btn.setBorderPainted(false); // 버튼 눌리는 보더설정을 없애주는 메서드
		contentPane.add(btn);
		}
		}
	}
	private void myClick(MouseEvent e) {
		if (flag_wb) {
			((AbstractButton) e.getSource()).setIcon(new ImageIcon(MyOmok01.class.getResource("/day05/1.png")));
		} else {
			((AbstractButton) e.getSource()).setIcon(new ImageIcon(MyOmok01.class.getResource("/day05/2.png")));
		}
		flag_wb = !flag_wb;
	}
}
