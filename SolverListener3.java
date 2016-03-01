import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;

public class SolverListener3 implements ActionListener{
    PuzzleGame g;
    JButton [] jbuttons;
    JButton bt = new JButton("");
   

    public SolverListener3(PuzzleGame ga){
	g = ga;
	jbuttons = g.getButtons();
      
    }
	
    public void actionPerformed (ActionEvent e){
	Hitori blend = new Hitori();     
	Solver sol = new Solver(blend);
	int [][]give = sol.fillAll();
	int t=0;
	for (int k=1; k<give[0].length-1;k++){
	    for (int h=1; h<give[0].length-1;h++){
		if (give [k][h]==9)
		    jbuttons[t++].setBackground(Color.GRAY);
		else
		   jbuttons[t++].setBackground(bt.getBackground()); 
	    }}
    }

}