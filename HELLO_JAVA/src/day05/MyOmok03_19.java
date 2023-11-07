package day05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MyOmok03_19 extends JFrame {

	private JPanel contentPane;
	boolean flag_b = false;
	boolean flag_wb = true;
	boolean flag_ing = true;
	/*int[][] arr2D  = {
		{0,0,0,0,0,	0,0,0,0,0, 0,0,0,0,0, 0,0,0,0},
		{0,0,0,0,0,	0,0,0,0,0, 0,0,0,0,0, 0,0,0,0},
		{0,0,0,0,0,	0,0,0,0,0, 0,0,0,0,0, 0,0,0,0},
		{0,0,0,0,0,	0,0,0,0,0, 0,0,0,0,0, 0,0,0,0},
		{0,0,0,0,0,	0,0,0,0,0, 0,0,0,0,0, 0,0,0,0},
		{0,0,0,0,0,	0,0,0,0,0, 0,0,0,0,0, 0,0,0,0},
		{0,0,0,0,0,	0,0,0,0,0, 0,0,0,0,0, 0,0,0,0},
		{0,0,0,0,0,	0,0,0,0,0, 0,0,0,0,0, 0,0,0,0},
		{0,0,0,0,0,	0,0,0,0,0, 0,0,0,0,0, 0,0,0,0},
		{0,0,0,0,0,	0,0,0,0,0, 0,0,0,0,0, 0,0,0,0},
		{0,0,0,0,0,	0,0,0,0,0, 0,0,0,0,0, 0,0,0,0},

		{0,0,0,0,0,	0,0,0,0,0, 0,0,0,0,0, 0,0,0,0},
		{0,0,0,0,0,	0,0,0,0,0, 0,0,0,0,0, 0,0,0,0},
		{0,0,0,0,0,	0,0,0,0,0, 0,0,0,0,0, 0,0,0,0},
		{0,0,0,0,0,	0,0,0,0,0, 0,0,0,0,0, 0,0,0,0},
		{0,0,0,0,0,	0,0,0,0,0, 0,0,0,0,0, 0,0,0,0},
		{0,0,0,0,0,	0,0,0,0,0, 0,0,0,0,0, 0,0,0,0},
		{0,0,0,0,0,	0,0,0,0,0, 0,0,0,0,0, 0,0,0,0},
		{0,0,0,0,0,	0,0,0,0,0, 0,0,0,0,0, 0,0,0,0},
		{0,0,0,0,0,	0,0,0,0,0, 0,0,0,0,0, 0,0,0,0}
	};*/
	int [][] arr2D = new int [19][19];
	JLabel [][]lbl2D = new JLabel[arr2D.length][arr2D.length];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyOmok03_19 frame = new MyOmok03_19();
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
	public MyOmok03_19() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 856);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_reset = new JLabel("RESET"); // 리셋버튼
		lbl_reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myreset();
			}
		});
		
		lbl_reset.setToolTipText("");
		lbl_reset.setIcon(null);
		lbl_reset.setBounds(775, 10, 58, 40);
		contentPane.add(lbl_reset);
			
		for(int i=0;i<arr2D.length;i++){
			for(int j=0;j<arr2D.length;j++){
				JLabel lbl = new JLabel("");
				lbl.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						myclick(e);
					}
				});
				lbl.setIcon(new ImageIcon(MyOmok03_19.class.getResource("/day05/0.png")));
				lbl.setBounds(j*40, i*40, 40, 40);
				lbl.setText(i+","+j);
				contentPane.add(lbl);
				lbl2D[i][j]= lbl; 
			}
		}
		myrender();
	}
	
	void myreset() {
		// 이중포문으로 arr다 넣어주고 마이랜더 호출 플래그ing(재시작)는 트루로 플래그 땁디(흑돌선)는 트루로
		for (int i = 0; i < arr2D.length; i++) {
			for (int j = 0; j < arr2D.length; j++) {
				arr2D[i][j] = 0; 
			}
		}
		myrender();
		flag_ing = true;
		flag_wb = true;
	}
	
	void myrender() {
		for (int i =0; i<arr2D.length; i++) {
			for(int j=0; j<arr2D.length; j++) {
				if(arr2D[i][j]==0) {
					lbl2D[i][j].setIcon(new ImageIcon(MyOmok03_19.class.getResource("/day05/0.png")));
				}
				if(arr2D[i][j]==1) {
					lbl2D[i][j].setIcon(new ImageIcon(MyOmok03_19.class.getResource("/day05/1.png")));
				}
				if(arr2D[i][j]==2) {
					lbl2D[i][j].setIcon(new ImageIcon(MyOmok03_19.class.getResource("/day05/2.png")));
				}
			}
		}
	}
	
	int getUP(int i, int j, int stone) {
		int cnt = 0;
			try { // 맨 위에 돌 놓으면 오류나는 것
				while (true) {
					i--; // up이니까 위를 확인 x축을 움직여주는 것
					if (arr2D[i][j] == stone) {
						cnt++;
					} else {
						return cnt;
					}
				}
			} catch (Exception e) {
				return cnt;
			}
	}
	
	int getDW(int i, int j, int stone) {
		int cnt = 0;
			try { // 맨 위에 돌 놓으면 오류나는 것
				while (true) {
					i++; // down이니까 밑를 확인 x축을 움직여주는 것
					if (arr2D[i][j] == stone) {
						cnt++;
					} else {
						return cnt;
					}
				}
			} catch (Exception e) {
				return cnt;
			}
	}
	
	int getLE(int i, int j, int stone) {
		int cnt = 0;
			try { // 맨 위에 돌 놓으면 오류나는 것
				while (true) {
					j--; // left이니까 왼쪽을 확인 y축을 움직여주는 것
					if (arr2D[i][j] == stone) {
						cnt++;
					} else {
						return cnt;
					}
				}
			} catch (Exception e) {
				return cnt;
			}
	}
	
	int getRI(int i, int j, int stone) {
		int cnt = 0;
			try { // 맨 위에 돌 놓으면 오류나는 것
				while (true) {
					j++; // right이니까 오른쪽을 확인 y축을 움직여주는 것
					if (arr2D[i][j] == stone) {
						cnt++;
					} else {
						return cnt;
					}
				}
			} catch (Exception e) {
				return cnt;
			}
	}
	
	int getUL(int i, int j, int stone) {
		int cnt = 0;
		try { // 맨 위에 돌 놓으면 오류나는 것
			while (true) {
				i--;
				j--;
				if (arr2D[i][j] == stone) {
					cnt++;
				} else {
					return cnt;
				}
			}
		} catch (Exception e) {
			return cnt;
		}
	}
	
	int getUR(int i, int j, int stone) {
		int cnt = 0;
		try { // 맨 위에 돌 놓으면 오류나는 것
			while (true) {
				i++;
				j++;
				if (arr2D[i][j] == stone) {
					cnt++;
				} else {
					return cnt;
				}
			}
		} catch (Exception e) {
			return cnt;
		}
	}
	
	int getDR(int i, int j, int stone) {
		int cnt = 0;
		try { // 맨 위에 돌 놓으면 오류나는 것
			while (true) {
				i++;
				j++;
				if (arr2D[i][j] == stone) {
					cnt++;
				} else {
					return cnt;
				}
			}
		} catch (Exception e) {
			return cnt;
		}
	}
	
	int getDL(int i, int j, int stone) {
		int cnt = 0;
		try { // 맨 위에 돌 놓으면 오류나는 것
			while (true) {
				i--;
				j--;
				if (arr2D[i][j] == stone) {
					cnt++;
				} else {
					return cnt;
				}
			}
		} catch (Exception e) {
			return cnt;
		}
	}
	
	void myclick(MouseEvent e) {
		if(!flag_ing) { // 게임종료시 더이상 돌 안놓아지게끔
			return;
		}
		JLabel temp = (JLabel) e.getSource();
		// split
		String str_ij = temp.getText();
		String[] arr_ij = str_ij.split(",");
		int i = Integer.parseInt(arr_ij[0]);
		int j = Integer.parseInt(arr_ij[1]);
		if (arr2D[i][j] > 0) { // 같은 돌 누르면 색 바뀌는 것
			return;
		}
		int stone = 0;
		if (flag_wb) {
			arr2D[i][j] = 1;
			stone = 1;
		} else {
			arr2D[i][j] = 2;
			stone = 2;
		}
		// 기준에서 돌을 세어줌
		int up = getUP(i, j, stone);
		int dw = getDW(i, j, stone);
		int le = getLE(i, j, stone);
		int ri = getRI(i, j, stone);
		int ur = getUR(i, j, stone);
		int ul = getUL(i, j, stone);
		int dr = getDR(i, j, stone);
		int dl = getDL(i, j, stone);
		/*System.out.println("up: "+up);
		System.out.println("dw: "+dw);
		System.out.println("le: "+le);
		System.out.println("ri: "+ri);
		System.out.println("ur: "+ur);
		System.out.println("ul: "+ul);
		System.out.println("dr: "+dr);
		System.out.println("dl: "+dl);*/
		
		// 게임 종료
		int d1 = up + dw + 1;
		int d2 = ur + dl + 1;
		int d3 = le + ri + 1;
		int d4 = ul + dr + 1;
		myrender();

		String a;
//		if(stone == 1) {  // 얘도 되지만 flag가 stone의 기준이 되지 때문에 그게 더 좋다고 함
//			a = "흑";
//		} else {
//			a = "백";
//		}
		if (flag_wb) {
			a = "흑";
		} else {
			a = "백";
		}
		if (d1 == 5 || d2 == 5 || d3 == 5 || d4 == 5) {
			JOptionPane.showMessageDialog(null, "Game Over\n" + a + "돌 승리!");
			flag_ing = false;
		}
		flag_wb = !flag_wb; // 턴종료
	}
}