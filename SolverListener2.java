import java.awt.event.*;
import javax.swing.*;

public class SolverListener2 implements ActionListener{
    PuzzleGame g;
    JButton [] jbuttons;
   

    public SolverListener2(PuzzleGame ga){
	g = ga;
	jbuttons = g.getButtons();
      
    }
	
    public void actionPerformed (ActionEvent e){
	Kakurasu blend = new Kakurasu();     
	Solver sol = new Solver(blend);
	int [][]give = sol.fillAll();
	int t=0;
	for (int k=1; k<give[0].length-1;k++){
	    for (int h=1; h<give[0].length-1;h++){
		if (give [k][h]==1)
		    jbuttons[t++].setText("m");
		else
		   jbuttons[t++].setText(""); 
	    }}
    }

}