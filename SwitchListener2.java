import java.awt.event.*;


public class SwitchListener2 implements ActionListener{
    PuzzleGame gr;


    public SwitchListener2 (PuzzleGame gr){
	this.gr=gr;
    }

    public void doThis(){
	gr.init1();
    }
 
    public void actionPerformed(ActionEvent e){
	       
		gr.getContentPane().removeAll() ;
           	 doThis();
		 gr.validate(); 
		 gr.repaint();
    }

}