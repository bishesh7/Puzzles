

public class Hitori extends Allpuzzle{
    
   
    private int [][] feedData;
    private int [][] dummyData;
    private int [][] constant;
    
    


    public Hitori(){
	Puzzle dev = new Puzzle ("hitori" , "five");
	feedData = dev.getData();
	constant = dev.getData();
        dummyData = dev.getData();
    }

   

    public int[][] getData(){
	return feedData;
    }
    public int[][] getdummyData(){
	
	
	for (int l=0; l<dummyData[0].length;l++){
		dummyData[0][l]=7;
		dummyData[dummyData[0].length-1][l]=7;
		dummyData[l][0]=7;
		dummyData[l][dummyData[0].length-1]=7;
	    }
       for (int i=1; i<constant[0].length-2;i++){
	    for (int j=1; j<constant[0].length-1;j++){
	      for (int k=1; k<feedData[0].length-1;k++){
	   
		  if (feedData[i][j]!=0 && feedData[i][j]== feedData[i][k] && k!=j){                 feedData[i][j]=0;feedData[i][k]=0;
		      dummyData[i][j]=0;dummyData[i][k]=0;}

		  if (feedData[i][j]!=0 && feedData[i][j]== feedData[k][j] && k!=i){                  feedData[i][j]=0;feedData[k][j]=0;
		      dummyData[i][j]=0;dummyData[k][j]=0;}		
	    }
	
	    }
	}
       
	return dummyData;
    }
    public int [] fillWhat(){
	int [] bool = {8,9};
	return bool;
    } 
    public boolean repeatChecker(int i,int j){
	  boolean bool1 = true;
	  boolean bool2 = true;
	  int count = 20;
	 for(int d=0;d<=i;d++){
	    for(int w=0;w<7;w++){  
		if (dummyData[d][w]==8)
		    feedData [d][w] = constant[d][w];
		else if (dummyData [d][w]==9)
		    feedData [d][w] = 0;
	    }
	 }
		    
	for (int k=1; k<feedData[0].length-1;k++){
	   
		if (feedData[i][j]!=0 && feedData[i][j]== feedData[i][k] && k!=j)
		    bool1 = false;

	        if (feedData[i][j]!=0 && feedData[i][j]== feedData[k][j] && k!=i)
		    bool2 = false;		
	    }
	if (bool1==false || bool2== false)
	    return false;
	else 
	    return true;
		
     } 

     public boolean blackConstraint(int i, int j){
       
	int a = dummyData[i][j];
	int b = dummyData[i-1][j];
	int c  = dummyData[i][j-1];
   
	if ((a==9 && a==b)||(a==9 && a==c))
	    return false;
	return true;
	} 

    public boolean closedConstraint(int i, int j){
	boolean bool1 = trap(i,j-1);
	boolean bool2 = trap(i,j+1);
	boolean bool3 = trap(i-1,j);
	boolean bool4 = trap(i+1,j);

	if (bool1==false || bool2 == false || bool3==false || bool4==false)
	    return false;
	return true;
    }

	 public boolean trap (int i, int j){

	     if (i==0 ||j==0||i==dummyData[0].length-1 ||j==dummyData[0].length-1)
		 return true;
	     int a = dummyData[i-1][j];
	     int b  = dummyData[i][j-1];
	     int c = dummyData [i][j+1];
	     int d = dummyData [i+1][j];

	   if ((a==9||b==7)&& (b==9||c==7)&& (c==9||d==7) && (d==9||d==7))
	      return false;
	   return true;
	 }


    public boolean constraintChecker(int i, int j){

	if (this.repeatChecker(i,j)==false || this.blackConstraint(i,j)==false || this.closedConstraint(i,j)==false){
	    //	 System.out.println("false");
	    	    return false;
		}
	else{ //System.out.println("true");
		    return true;}
    }


    public static void main ( String[] egs){
	Hitori blend = new Hitori();
	 Solver sol = new Solver(blend);
		 int [][]give = sol.fillAll();
		for(int i=0;i<7;i++){
	    for(int j=0;j<7;j++){
		System.out.print("  "+give[i][j]+"");
		
	    }System.out.print("\n");}
	    System.out.print("\n");
    }
}
	    
