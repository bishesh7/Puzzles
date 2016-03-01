



public class Solver{
    int [][] data;
    Allpuzzle puzzle;
    int [] range;
   
 
     public Solver(Skyscaper sk){
      	puzzle = new Skyscaper();
	puzzle = sk;
	data = puzzle.getData();
	range = puzzle.fillWhat();
	
	}  
     public Solver (Kakurasu ka){
	 puzzle = new Kakurasu();
	puzzle = ka;
	data = puzzle.getData();
	range= puzzle.fillWhat();
	
	    } 

    public Solver (Hitori hi){
      	puzzle = new Hitori();
	puzzle = hi;
	data = puzzle.getdummyData();     
	range= puzzle.fillWhat();
 
	    }


    public int [][] filling(int [][] d, int i , int j){
	   
	    if (d [i][j]== range[range.length -1]){
		//	System.out.println(" "+i+"  "+j+"  "+data[i][j]+" ");
		d[i][j]=0;
	   
		//	System.out.println(" "+i+"  "+j+"  "+data[i][j]+" ");
		if (j==1){
		    j= d[0].length-2;
		    this.filling(data,i-1,j);
		}
		else{ // System.out.println(" "+i+"  "+j+"  "+data[i][j]+" ");;
	             this.filling(data,i,j-1);
		}
	    }
	    else{
		int t=0;
		for (int k=0; k<range.length; k++){
		   
		    if (d[i][j] == range[k])
			t = k+1;  	
		}
	
		    
	
           		d[i][j]= range[t];
		   
			//	    System.out.println(" "+i+"  "+j+"  "+data[i][j]+" ");
			while (( puzzle.constraintChecker(i,j) == false) && t<range.length){
			data[i][j]= range [t++];
		   
			//    System.out.println(" "+i+"  "+j+"  "+data[i][j]+" ");}
		    }
			if (puzzle.constraintChecker(i,j) == false){
			if (j==1){
			     data[i][j]=0;
			     //  System.out.println(" "+i+"  "+j+"  "+data[i][j]+" ");
		            j= d[0].length-2;
		            this.filling(data,i-1,j);
		        }
		        else{
	                    this.filling(data,i,j);
		        }
		    }
		   
	    }
	return d;
    }
	    
   
	
    public int [][] fill(){
       
        int i=1;
	int j=1;
		while(i<data[0].length-1){
	    j=1;
	       while(j<data[0].length-1){
		if (data[i][j]==0){
		    data [i][j]= range[0];
		 
		    //		System.out.println(" "+i+"  "+j+"  "+data[i][j]+" ");}
			    int t=0;
			    while ((puzzle.constraintChecker(i,j) == false) && t<range.length){
		        data[i][j]= range [t++];
		    
			//    System.out.println(" "+i+"  "+j+"  "+data[i][j]+" ");}
	            }
			    if (puzzle.constraintChecker(i,j) == false){
			data = this.filling(data,i,j);
	      
			int m=1;
			int n=1;
			while(m<data[0].length-1 && data[m][n]!=0){
			   n=1;
			    while(n<data[0].length-1 && data[m][n]!=0){
				
				    i=m;j=n; n++;
			    }  m++;}
				    
		    }
		}
			j++ ;   } 
		i++;}
	return data;
    }
	


    public int [][] fillAll(){
	int [][]store =this.fill();
	return store;
    }
    
 
}