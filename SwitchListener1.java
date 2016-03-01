import java.awt.event.*;


public class SwitchListener1 extends SwitchListener2  implements ActionListener{
    


    public SwitchListener1(PuzzleGame gr){
	super(gr);
    }
 
    public void doThis(){
	gr.init2();
    }
}