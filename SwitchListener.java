import java.awt.event.*;


public class SwitchListener extends SwitchListener2  implements ActionListener{
    


    public SwitchListener(PuzzleGame gr){
	super(gr);
    }
 
    public void doThis(){
	gr.init3();
    }
}