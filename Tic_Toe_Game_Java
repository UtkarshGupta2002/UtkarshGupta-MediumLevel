import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tic_tac_toe extends JFrame implements ActionListener {
    private JButton[][] buttons;
    private boolean playerXTurn;

    public Tic_tac_toe() {
        buttons = new JButton[3][3];
        playerXTurn = true;
        setTitle("Tic-Tac-Toe");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));
        initializeButtons();
    }

    private void initializeButtons() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new JButton("");
                buttons[row][col].setFont(new Font("Arial", Font.PLAIN, 60));
                buttons[row][col].setFocusPainted(false);
                buttons[row][col].addActionListener(this);
                add(buttons[row][col]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if (!clickedButton.getText().equals("")) {
            return;
        }

        if (playerXTurn) {
            clickedButton.setText("X");
        } else {
            clickedButton.setText("O");
        }

        playerXTurn = !playerXTurn;

        if (checkForWinner()) {
            JOptionPane.showMessageDialog(this, "Player " + (playerXTurn ? "O" : "X") + " wins!");
            resetBoard();
        } else if (isBoardFull()) {
            JOptionPane.showMessageDialog(this, "The game is a tie!");
            resetBoard();
        }
    }

    private boolean checkForWinner() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (checkThree(buttons[i][0], buttons[i][1], buttons[i][2]) ||
                checkThree(buttons[0][i], buttons[1][i], buttons[2][i])) {
                return true;
            }
        }

        // Check diagonals
        return (checkThree(buttons[0][0], buttons[1][1], buttons[2][2]) ||
                checkThree(buttons[0][2], buttons[1][1], buttons[2][0]));
    }

    private boolean checkThree(JButton b1, JButton b2, JButton b3) {
        return (!b1.getText().equals("") && b1.getText().equals(b2.getText()) && b2.getText().equals(b3.getText()));
    }

    private boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (buttons[row][col].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void resetBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
            }
        }
        playerXTurn = true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Tic_tac_toe game = new Tic_tac_toe();
            game.setVisible(true);
        });
    }
}
