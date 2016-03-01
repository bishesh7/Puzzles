

public class Skyscaper extends Allpuzzle{
    int [][] feedData;

    public Skyscaper(){
	Puzzle dev = new Puzzle("sky" , "seven");
	feedData = dev.getData();
    }
	


    public int[][] getData(){
	return feedData;

    }
    public int[][] getdummyData(){
	return feedData;

    }
    public int [] fillWhat(){
	int [] num = {1,2,3,4,5};
	return num;
    }
    public int numRange(){
	return 5;
    }

    public boolean repeatChecker(int i,int j){
	for (int k=1; k<feedData[0].length-2;k++){
	    for (int h=k+1; h<feedData[0].length-1;h++){
		if (feedData[i][k]!=0 && feedData[i][k]== feedData[i][h]){
		    //  System.out.println("false");
		    return false;
		}
	    }
	}
	    
	for (int k=1; k<feedData[0].length-2;k++){
	    for (int h=k+1; h<feedData[0].length-1;h++){
		if (feedData[k][j]!=0 && feedData[k][j]== feedData[h][j]){
		    //    System.out.println("false");
		    return false;
		}
	    }
	}
	//	System.out.println("true");
	return true;
    }

     public boolean rowConstraintChecker( int i){
	int max1 =0;
	int max2=0;
	int count1=0;
	int count2=0;
   
	for (int k=1; k<feedData[0].length-1; k++){
	    if (feedData[i][k]==0)
		return true;
	    if (feedData[i][k]> max1){
		max1 =feedData[i][k]; count1++;
	    }
	}
	for (int k=feedData[0].length-2; k>0;k--){
	    if (feedData[i][k]==0)
		return true;
	    if (feedData[i][k]> max2){
		max2 =feedData[i][k]; count2++;
	    }
	}
	
	if (count1==feedData[i][0] && count2 == feedData[i][feedData[0].length-1])
	    return true;
	return false;
    }

    public boolean columnConstraintChecker(int i){
	int max1 =0;
	int max2=0;
	int count1=0;
	int count2=0;
	for (int k=1; k<feedData[0].length-1; k++){
	    if (feedData[k][i]==0)
		return true;
	    if (feedData[k][i]> max1){
		max1 = feedData[k][i]; count1++;
	    }
	}
	for (int k=feedData[0].length-2;k>0; k--){
	    if (feedData[k][i]==0)
		return true;
	    if (feedData[k][i]> max2){
		max2 = feedData[k][i]; count2++;
	    }
	}
	
	if (count1==feedData[0][i] && count2 == feedData[feedData[0].length-1][i])
	    return true;
	return false;
    }
    
    public boolean constraintChecker(int i, int j){

	if (this.repeatChecker(i,j)==false || this.rowConstraintChecker(i)==false || this.columnConstraintChecker(j)== false){
	    //	 System.out.println("false");
	    	    return false;
		}
	else{ //System.out.println("true");
		    return true;}
    }
	
   
	
	

    public static void main ( String[] egs){
       	Skyscaper blend = new Skyscaper();     
	Solver sol = new Solver(blend);
	 int [][]give = sol.fillAll();
	for(int i=0;i<7;i++){
	    for(int j=0;j<7;j++){
		System.out.print("  "+give[i][j]+"");
		
	    }System.out.print("\n");}
	    System.out.print("\n");   
	      
	
    }
}
	    
	