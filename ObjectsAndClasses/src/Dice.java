import java.util.Random;

public
class Dice {

   private int sides;
   public Dice(int sides){
      this.sides = sides;
   }

   public int getSides() {
      return this.sides;
   }

   public
   void setSides (int sides) {
      this.sides = sides;
   }

   public int roll(){
      Random rand =   new Random ();
     return rand.nextInt (this.sides)+1;

   }
}
