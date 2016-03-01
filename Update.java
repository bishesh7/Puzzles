import java.awt.event.*;
import javax.swing.*;

public class Update implements ActionListener{
    PuzzleGame g;
    JButton theButton;
    
    public Update ( PuzzleGame game, JButton jb){
	g = game;
	theButton= jb;
    }

    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();
	if (action.equals("clear"))
	    theButton.setText("");
	else
           theButton.setText(action);
    }
}