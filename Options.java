import java.awt.event.*;
import javax.swing.*;

public class Options implements ActionListener{
    private JButton myButton;
    private PuzzleGame g;
    JPopupMenu options;

    public Options ( PuzzleGame game1, JButton jb){
	g=game1;
	myButton=jb;
    
	options = new JPopupMenu ("Numbers");
 
	Update ch = new Update (g, myButton);
	
	for (int i=0; i<5; i++){
	    JMenuItem one = new JMenuItem ("    "+(i+1)+"    ");

	    options.add(one);
	    one.addActionListener(ch);
	}
	JMenuItem blank = new JMenuItem ("clear");
        options.add(blank);
	blank.addActionListener(ch);
    }

    public void actionPerformed(ActionEvent e){
	options.show(myButton, myButton.getWidth()/4,myButton.getHeight()/2);
    }
}