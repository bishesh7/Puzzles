import java.util.Vector;

public class Puzzle{
    private String [] hop;
    PuzzleGame g = new PuzzleGame();
    private int [][] feedData;
    String game ;
    String gameType;
    
    Vector<String> hold = new Vector<String>();
    


    public Puzzle(String s, String a){
	game = s;
	gameType = a;
    }

    public int [][] toInt (){
	hop=g.getArray(game);
	for(int i=0;i< hop.length ; i++){
	    hold.addElement (hop[i]);
	       if (hop[i]=="")
		   hold.set(i,"0");
	}

	hold.remove(hold.size()-1);
	int [][]feedData = new int [7][7];
	for (int i=0; i<(feedData[0]).length;i++){
	    feedData[0][i]=Integer.parseInt(hold.elementAt(i));
	    feedData[6][i]=Integer.parseInt(hold.elementAt(hold.size()-7+i));
	 
	}
	for(int i=1;i<=5;i++){
	    feedData[i][0]=Integer.parseInt(hold.elementAt(7+(i-1)*2));
	    feedData[i][6]=Integer.parseInt(hold.elementAt(7+(i-1)*2+1));
	}
	feedData[0][0]=13; feedData[0][6]=14;
	feedData [6][0]=15; feedData [6][6]=16;

	return feedData;
    }

    public int [][] toInt2 (){
	hop=g.getArray(game);
	for(int i=0;i< hop.length ; i++){
	    hold.addElement (hop[i]);

	}

	int k=0;
	int [][]feedData = new int [7][7];
	for (int i=1; i<feedData[0].length-1;i++){
	    for (int j=1; j<feedData[0].length -1;j++){
		feedData[i][j]=Integer.parseInt(hold.elementAt(k++));
	    }
	}
	
	return feedData;
    }

    public int[][] getData(){
	if (gameType.equals("seven"))
	    return this.toInt();
	else 
	    return this.toInt2();
	
    }
}