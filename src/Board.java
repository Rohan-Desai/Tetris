import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener, KeyListener {
	static final int BLOCK_WIDTH = 40;
	static final int BLOCK_LENGTH = 40;
	static final int BOARD_WIDTH = BLOCK_WIDTH * 25;
	static final int BOARD_LENGTH = BLOCK_LENGTH * 25;
	int x1, y1, x2, y2, x3, y3, x4, y4;
	int temp;
	int rotateCounter = 0;
	int[][] board = new int[25][25];

	Timer t = new Timer(1000, this);

	public Board() {
		t.start();
		this.addKeyListener(this);
		this.setFocusable(true);
		LPiece();

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i <= 25; i++) {
			g.drawLine(0, i * BLOCK_WIDTH, 1000, i * BLOCK_WIDTH);
		}
		for (int j = 0; j <= 25; j++) {
			g.drawLine(j * BLOCK_LENGTH, 0, j * BLOCK_LENGTH, 1000);
		}

		for (int i = 0; i <= 24; i++) {
			for (int j = 0; j <= 24; j++) {
				if (board[i][j] == 1) {
					g.fillRect(board[i][j] * i * 40, board[i][j] * j * 40, BLOCK_WIDTH, BLOCK_LENGTH);
				}
				// System.out.println(board[i][j] + " x = " + i + " y = " + j);
				// System.out.println(board[j][i] + " x = " + i + " y = " + j);
			}
		}

	}

	public void IPiece() {
		x1 = 0;
		x2 = 1;
		x3 = 2;
		x4 = 3;
		y1 = 0;
		y2 = 0;
		y3 = 0;
		y4 = 0;

		board[x1][y1] = 1;
		board[x2][y2] = 1;
		board[x3][y3] = 1;
		board[x4][y4] = 1;
	}

	public void OPiece() {
		x1 = 0;
		x2 = 1;
		x3 = 0;
		x4 = 1;
		y1 = 0;
		y2 = 0;
		y3 = 1;
		y4 = 1;

		board[x1][y1] = 1;
		board[x2][y2] = 1;
		board[x3][y3] = 1;
		board[x4][y4] = 1;
	}

	public void SPiece() {
		x1 = 0;
		x2 = 0;
		x3 = 1;
		x4 = 1;
		y1 = 0;
		y2 = 1;
		y3 = 1;
		y4 = 2;

		board[x1][y1] = 1;
		board[x2][y2] = 1;
		board[x3][y3] = 1;
		board[x4][y4] = 1;
	}

	public void ZPiece() {
		x1 = 1;
		x2 = 1;
		x3 = 0;
		x4 = 0;
		y1 = 0;
		y2 = 1;
		y3 = 1;
		y4 = 2;

		board[x1][y1] = 1;
		board[x2][y2] = 1;
		board[x3][y3] = 1;
		board[x4][y4] = 1;
	}

	public void LPiece() {
		x1 = 0;
		y1 = 0;
		x2 = 1;
		y2 = 0;
		x3 = 1;
		y3 = 1;
		x4 = 1;
		y4 = 2;

		board[x1][y1] = 1;
		board[x2][y2] = 1;
		board[x3][y3] = 1;
		board[x4][y4] = 1;
	}

	public void JPiece() {
		x1 = 1;
		x2 = 1;
		x3 = 1;
		x4 = 0;
		y1 = 0;
		y2 = 1;
		y3 = 2;
		y4 = 2;

		board[x1][y1] = 1;
		board[x2][y2] = 1;
		board[x3][y3] = 1;
		board[x4][y4] = 1;
	}

	public void TPiece() {
		x1 = 0;
		x2 = 1;
		x3 = 2;
		x4 = 1;
		y1 = 0;
		y2 = 0;
		y3 = 0;
		y4 = 1;

		board[x1][y1] = 1;
		board[x2][y2] = 1;
		board[x3][y3] = 1;
		board[x4][y4] = 1;
	}

	// if space below piece is equal to 0 then increment each y value by one until
	// it reaches the bottom of the board or until the space below y4 is equal to 1
	public void moveRight() {
		if (x1 < 24 && x2 < 24 && x3 < 24 && x4 < 24) {
			clearPiece();
			x1 += 1;
			x2 += 1;
			x3 += 1;
			x4 += 1;
			setPiece();
			repaint();
		}
	}

	public void moveLeft() {
		if (x1 > 0 && x2 > 0 && x3 > 0 && x4 > 0) {
			clearPiece();
			x1 -= 1;
			x2 -= 1;
			x3 -= 1;
			x4 -= 1;
			setPiece();
			repaint();
		}
	}

	public void fall() {
		if (y1 < 24 && y2 < 24 && y3 < 24 && y4 < 24) {
			clearPiece();
			y1 += 1;
			y2 += 1;
			y3 += 1;
			y4 += 1;
			setPiece();
			repaint();
		} else {

		}
	}

	/*
	 * all other blocks rotate around the third block
	 */
	public void rotate() {
		clearPiece();
		rotateFirstBlock();
		rotateSecondBlock();
		rotateFourthBlock();
		setPiece();
		repaint();
	}

	public void rotateFirstBlock() {
		switch (rotateCounter % 4) {
		case 0:
			x1 = x3 - 1;
			y1 = y3 - 1;
			break;
		case 1:
			x1 = x3 + 1;
			y1 = y3 - 1;
			break;
		case 2:
			x1 = x3 + 1;
			y1 = y3 + 1;
			break;
		case 3:
			x1 = x3 - 1;
			y1 = y3 + 1;
			break;
		}
	}

	public void rotateSecondBlock() {
		switch (rotateCounter % 4) {
		case 0:
			x2 = x3;
			y2 = y3 - 1;
			break;
		case 1:
			x2 = x3 + 1;
			y2 = y3;
			break;
		case 2:
			x2 = x3;
			y2 = y3 + 1;
			break;
		case 3:
			x2 = x3 - 1;
			y2 = y3;
			break;
		}
	}

	public void rotateFourthBlock() {
		switch (rotateCounter % 4) {
		case 0:
			x4 = x3;
			y4 = y3 + 1;
			break;
		case 1:
			x4 = x3 - 1;
			y4 = y3;
			break;
		case 2:
			x4 = x3;
			y4 = y3 - 1;
			break;
		case 3:
			x4 = x3 + 1;
			y4 = y3;
			break;
		}
	}

	public void clearPiece() {
		board[x1][y1] = 0;
		board[x2][y2] = 0;
		board[x3][y3] = 0;
		board[x4][y4] = 0;

	}

	public void setPiece() {
		board[x1][y1] = 1;
		board[x2][y2] = 1;
		board[x3][y3] = 1;
		board[x4][y4] = 1;
	}

	public void printCoords() {
		System.out.print("Coords: {");
		System.out.print("(" + x1 + "," + y1 + ")");
		System.out.print("(" + x2 + "," + y2 + ")");
		System.out.print("(" + x3 + "," + y3 + ")");
		System.out.print("(" + x4 + "," + y4 + ")");
		System.out.println("}");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_DOWN) {
			fall();
		}
		if (key == KeyEvent.VK_RIGHT) {
			moveRight();
		}
		if (key == KeyEvent.VK_LEFT) {
			moveLeft();
		}
		if (key == KeyEvent.VK_UP) {
			rotateCounter++;
			rotate();

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		clearPiece();
		fall();
		setPiece();

	}
}