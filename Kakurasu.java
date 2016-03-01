

public class Kakurasu extends Allpuzzle{
    
    private int [][] feedData;
   
    public Kakurasu(){
	Puzzle dev = new Puzzle ("kakurasu", "seven");
	feedData = dev.getData();
    }


    public boolean rowConstraintChecker( int i){
	int count =0;
	 for (int k=1; k<feedData[0].length-1; k++){
	    if (feedData[i][k]==0)
		return true;
	    if (feedData[i][k]==1)
		count += feedData[0][k];
	 }
	 if (count == feedData[i][feedData[0].length-1])
	     return true;
	 return false;
    }
     public boolean columnConstraintChecker(int i){
	 int count =0;
	 for (int k=1; k<feedData[0].length-1; k++){
	    if (feedData[k][i]==0)
		return true;
	    if (feedData[k][i]==1)
		count += feedData[k][0];
	 }
	 if (count == feedData[feedData[0].length-1][i])
	     return true;
	 return false;
    }
    public boolean constraintChecker(int i, int j){

	if (this.rowConstraintChecker(i)==false || this.columnConstraintChecker(j)== false){
	        return false;
	}
	else{ 
	       return true;}
    }
 
   public int[][] getData(){
	return feedData;
    }

    public int [] fillWhat(){
	int [] bool = {1,2};
	return bool;
    }

    public static void main ( String[] egs){
	Kakurasu blend = new Kakurasu();
 
			Solver sol = new Solver(blend);
	      	 int [][]give = sol.fillAll();
	for(int i=0;i<7;i++){
	    for(int j=0;j<7;j++){
		System.out.print("  "+give[i][j]+"");
		
	    }System.out.print("\n");}
	    System.out.print("\n");   
    }
}
	    
	