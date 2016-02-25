 
public class Hanoi 
{  // number of discs
   public static final int MAX_DISCS = 99;
   public static final int NUM_TOWERS = 3;
   // lets be reckless and skip getters/setters and make it public
   // bad form, but we'll do it just this once
   public int[][] towers = new int[NUM_TOWERS][MAX_DISCS];
   public int numDiscs;
   
   
   // constructor that initializes array
   // we'll be rude again and not do default constructor
   public Hanoi(int size) {
     this.numDiscs = size;
     
     // make 2nd & 3rd towers all 0s
     for (int i = 1; i < NUM_TOWERS; i++) { // 3 columns
       for (int j = 0; j < size; j++) { // size rows
         this.towers[i][j] = 0; 
       }
     }
     
     // initialize first tower
     for (int i = 0; i < size; i++) {
       this.towers[i][0] = size - i;
     }
   } //constructor: Hanoi

   // toString to help with print
   public String toString() {
     String out = "";
     for (int i = NUM_TOWERS; i > 0; i--) {
       //System.out.println(" i = " + i);
       for (int j = 0; j < this.numDiscs; j++) {
         //System.out.println(" j = " + j);
         out = out + this.towers[i-1][j] + " ";
       }
       out = out + "\n";
       //System.out.println(out);
     }
     return(out);
   } // method toString
   
   // print the current state
   public void print() {
     System.out.println(this);
   }
   
  
  
  
  // sorts discs to new area
  public void moveTower() {
    // base case
    // new tower
    
    // recursive case
    
  }// method: moveTower
  
  // TODO:

  // actually need to make recursive method.
  
  // the main method
  public static void main(String[] args) {
    Hanoi tower = new Hanoi(3);
    tower.print();
   
  } // method: main
    
} // class Hanoi
