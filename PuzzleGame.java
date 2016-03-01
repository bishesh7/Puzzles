import java.awt.*;

import javax.swing.*;

public class PuzzleGame extends JFrame{

    private int buttonCount=25;
    private JButton[] buttons;
    private int front=0;
    private int t=0;
   
      private String [] sky={"","2","1","5","2","2","","2","2","1","3","2","1","4","2","2","3","","3","4","1","2","3","",""};
    private String[] hitori={"4","5","1","2","4","5","4","3","2","1","3","3","2","1","4","1","4","5","3","2","5","1","2","4","4"};
    private String [] kakurasu = {"","1","2","3","4","5","","1","15","2","10","3","11","4","2","5","3","","1","10","8","4","6","",""};
    Container contentPane;

    public void init1(){
       
	contentPane = this.getContentPane();

	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	contentPane.setLayout(new GridLayout(8,7));


	for (int i=0;i<8;i++){
	    this.add(sky);
	}

		buttons = new JButton[buttonCount];
	
	for (int i=0; i< buttonCount; i++){
	    JButton jb = new JButton("");
	    contentPane.add(jb);
	    Options opt = new Options(this, jb);
	    jb.addActionListener(opt);
	    buttons[i] = jb;

	    if (i==4){ 	
		this.add(sky); this.add(sky);
	    }
	     if (i==9){ 		
		 this.add(sky); this.add(sky);
	    }
	      if (i==14){ 		
		 this.add(sky); this.add(sky); 
	    }
	       if (i==19){ 
		   this.add(sky); this.add(sky);
	    }
	}  
		for (int j=0;j<9;j++){
	           this.add(sky);
         	}

		contentPane.add(new JLabel("skyscraper"));
	contentPane.add(new JLabel(""));
	JButton solve = new JButton("Solve");
	solve.addActionListener(new SolverListener1(this));
	contentPane.add(solve);
	contentPane.add(new JLabel(""));
	JButton change = new JButton("Switch");
	change.addActionListener(new SwitchListener1(this));
	contentPane.add(change);
	front=0;
    }

    public void init2(){

	contentPane = this.getContentPane();
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	contentPane.setLayout(new GridLayout(0,5));

	for(int i=0; i<buttonCount; i++){
	    HitoriButton jb = new HitoriButton(hitori[t++]);
	    contentPane.add(jb);
	    buttons[i]=jb;
	}

	contentPane.add(new JLabel("hitori"));
	contentPane.add(new JLabel(""));
	JButton solve = new JButton("Solve");
	contentPane.add(solve);
	solve.addActionListener(new SolverListener3(this));
	contentPane.add(new JLabel(""));
	JButton chang = new JButton("Switch");
	chang.addActionListener(new SwitchListener(this));
	contentPane.add(chang);
	t=0;
    }

    public void init3(){
       
	contentPane = this.getContentPane();
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	contentPane.setLayout(new GridLayout(8,7));


	for (int i=0;i<8;i++){
	    this.add(kakurasu);
	}

		buttons = new JButton[buttonCount];
	
	for (int i=0; i< buttonCount; i++){
	    JButton jb = new JButton("");
	    contentPane.add(jb);
	    Marker mar = new Marker(this,jb);
	    jb.addActionListener(mar);
	    buttons[i]= jb;

	    if (i==4){ 	
		this.add(kakurasu); this.add(kakurasu);
	    }
	     if (i==9){ 		
		 this.add(kakurasu); this.add(kakurasu);
	    }
	      if (i==14){ 		
		 this.add(kakurasu); this.add(kakurasu); 
	    }
	       if (i==19){ 
		   this.add(kakurasu); this.add(kakurasu);
	    }
	}  
		for (int j=0;j<9;j++){
	           this.add(kakurasu);
         	}

	contentPane.add(new JLabel("kakurasu"));
	contentPane.add(new JLabel(""));
	JButton solve = new JButton("Solve");
	solve.addActionListener(new SolverListener2(this));
	contentPane.add(solve);
	contentPane.add(new JLabel(""));
	JButton change = new JButton("Switch");
	change.addActionListener(new SwitchListener2(this));
	contentPane.add(change);
        front=0;
    }


    public void add(String[] a){
	contentPane.add(new JLabel ("       "+a[front]+"")); front++;
    }

    public String [] getArray ( String s){
	if (s.equals("sky")){
	    return sky;}
	else if (s.equals("hitori")){
	    return hitori;}
	else{
	    return kakurasu;}
    }

    public JButton [] getButtons(){
	return buttons;
    }

    public static void main(String[] args){
        PuzzleGame thisOne = new PuzzleGame ();
	thisOne.init1();
        thisOne.setVisible(true);
	thisOne.setSize( new Dimension(600,600));
    }
}

