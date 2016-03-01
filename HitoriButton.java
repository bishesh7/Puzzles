import java.awt.event.*;
import java.awt.Color;
import javax.swing.*;


public class HitoriButton extends JButton implements ActionListener{

    private String label= "label?";
    Color col= Color.RED;
    Color given = this.getBackground();
    Color copy = given;
    private int count=0;
    
    public HitoriButton (String s){
	label=s;
	 this.setText(label);
	 this.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
	count++;
	if (count%2!=0)
	    this.setBackground(Color.GRAY);
	else
	    this.setBackground(copy);
    }
}