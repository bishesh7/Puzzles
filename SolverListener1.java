import java.awt.event.*;
import javax.swing.*;

public class SolverListener1 implements ActionListener{
    PuzzleGame g;
    JButton [] jbuttons;
   

    public SolverListener1(PuzzleGame ga){
	g = ga;
	jbuttons = g.getButtons();
      
    }
	
    public void actionPerformed (ActionEvent e){
	Skyscaper blend = new Skyscaper();     
	Solver sol = new Solver(blend);
	int [][]give = sol.fillAll();
	int t=0;
	for (int k=1; k<give[0].length-1;k++){
	    for (int h=1; h<give[0].length-1;h++){
		jbuttons[t++].setText(""+give[k][h]+"");
	    }}
    }

}