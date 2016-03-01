import java.awt.event.*;
import java.awt.Color;
import javax.swing.*;

public class Marker implements ActionListener{
    PuzzleGame g;
    JButton jb;
    int count=0;
    
    
    public Marker (PuzzleGame p,JButton j){
	g=p;
	jb = j;
    }

    public void actionPerformed(ActionEvent e){
	count++;
	if (count%2!=0)
	    jb.setText("m");
	else
	    jb.setText("");
    }
}
	