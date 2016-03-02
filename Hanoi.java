 
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
   
   // NOTE: This hasn't been tested with anything
   // besides the initial data from the constructor
   public int getTopDisc(int towerNumber) {
     for (int i = this.numDiscs-1; i >= 0; i--) {
       //System.out.println(this.towers[towerNumber][i]);
       // How do we find the top disc?
       // search for integer in spaces are not zero
        if (this.towers[i][towerNumber] != 0)
          return(this.towers[i][towerNumber]);
     }
     return 0;
   }
   
   // print the current state
   public void print() {
     System.out.println(this);
   }
   
   // Identify eligible towers to take discs?
   // NEW: we don't need this.
   /*public int discCheck() {
     // check if size is less than the disc size of existing discs
     
   }*/
  
   public void moveTower(int dest) {
     // figures out additional variables method called from 
     // main makes more sense
     
     // assume there is only one tower
     // find the first tower that has discs in it and store the index in start
     for (int i = 0; i < this.NUM_TOWERS; i++) {
       if (this.getTopDisc(i) > 0) {
         int start = i;
         break;
       }
     }
     
     
     
     
     moveTower(this.numDiscs, start, dest, spare)
   }
   
   
  // sorts discs to new area
  // NEW: spare (to more effectively keep track of which tower is which)
  public void moveTower(int size, int start, int dest, int spare) {
    // base case : move size 1 tower
    if (size == 1) {
      this.moveDisc(start, dest);
      this.print();
    } // end base case
    else { // recursive case 
      // move size-1 tower from top of tower to spare
      moveTower(size-1, start, spare, dest);
      // move largest disc to dest
      moveTower(1, start, dest, spare);
      // move size-1 tower from spare to destination
      moveTower(size-1, spare, dest, start);      
      this.print();
    } // end recursive case
    this.print();
  }// method: moveTower
  
  // method for moving disc from top of one tower
  // to top of other tower
  public void moveDisc(int start, int destination) {
    // loop through start column
    int tmp = 0;
    for (int i = NUM_TOWERS-1; i >= 0; i--) {
      // find disc value
      // loop through destination column
      // i = towers j = discs
      if (this.towers[i][start] != 0) {
        tmp = this.towers[i][start];
        // replace disc value with 0
        this.towers[i][start] = 0;
        //System.out.println(tmp);
        break;
      }
    }
    // find first empty slot
    for (int i = 0; i < NUM_TOWERS; i++) {
      if (this.towers[i][destination] == 0) {
      // copy disc value into destination
        this.towers[i][destination] = tmp;
        break;
      }
    }
  } // method: moveDisc
  
  // the main method
  public static void main(String[] args) {
    Hanoi tower = new Hanoi(3);
    tower.print();
    System.out.println(tower.getTopDisc(0));
    
    tower.moveTower(3, 0, 2);
    
    /*tower.moveDisc(0, 2);
    System.out.println();
    tower.print();
    tower.moveDisc(0, 2);
    System.out.println();
    tower.print();
    tower.moveDisc(0, 2);
    System.out.println();
    tower.print();*/
   
  } // method: main
    
} // class Hanoi
