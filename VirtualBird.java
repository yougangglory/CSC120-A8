
import java.util.Arrays;

public class VirtualBird implements Contract {

    String name;
    String nestingMaterial;
    Double weight;
    String [] goodTypeMaterial  = {"dead leaves","organic item","staw","hemp","Plant Fluff","Dried Grass Clippings"};
    String [] badTypeMaterial  = {"metal","plastic","rubber","non-organic","artificial grass"};
    String[] Material = {"metal","plastic","rubber","non-organic","artificial grass","dead leaves","organic item","staw","hemp","Plant Fluff","Dried Grass Clippings"};
 
    public VirtualBird(String bird){
        this.name=bird;
    }
    

   /*
    * grab an item from an array of items
    *@param name of item
    *return nothing
    */
    public void grab(String item) {
        boolean doesContain = Arrays.stream(Material).anyMatch(item::equals);
       if ( doesContain == false) {
        throw new RuntimeException("Please choose your item from the list provided!");
       }
       else {
         this.nestingMaterial=item;
        System.out.println("Congratulation. You have grabbed 1 "+ item +".\n Examine if it is the right type of material and if yes,use it to build your nest. If not, drop it and grab another item" );
       }
     
    }


    /*
    *return a statement giving the name of the bird and some instructions for the game
    */
    public String toString() {
        return ("Hi! Your name is "+ this.name+"." +"To build your nest,choose between these items to fab:\n + metal \n + plastic \n + rubber \n + non-organic \n + artificial grass \n + dead leaves \n + organic item \n + staw \n + hemp \n + Plant Fluff \n + Dried Grass Clippings\n ");
    }


   /*
    * drop the item previously grabbed
    *@param name of item
    *return the name of the item dropped
    */
    public String drop(String item) {
    this.nestingMaterial=null;
    return (name+" you just dropped this item : " + item); 
    }


    /*
    * examine if the item grabbed is a good material for the nest
    *@param name of item
    *return nothing
    */
    public void examine(String item) {

        boolean doesContain = Arrays.stream(goodTypeMaterial).anyMatch(item::equals);
        if ( doesContain == false) {
         System.out.println("\n Oups! Your item is not of good quality for a nest. Drop it and grab another one");
        }
        else {  
         System.out.println("\n Congratulation. You have the good type of nesting material. Use it to build your nest" );
        }
    }


   /*
    * Use the item grabbed to build the nest
    *@param name of item
    *return nothing
    */
    public void use(String item) {
        if ( nestingMaterial == null) {
            throw new RuntimeException("\n Please grab an item before using it. You don't actually one");
           }
           else {
             this.nestingMaterial=null;
            System.out.println("\n Congratulation. You just used this "+ item +" Start back the process to complete your nest");
           }
    }


   /*
    * enable the bird to walk towards a direction
    *@param direction to be taken
    *return T/F if the bird is able to walk
    */
    public boolean walk(String direction) {
        if ( direction == "left"|| direction == "right") {
            System.out.println("\nYou just walked to the left");
            return true;  
        }
        else {
            throw new RuntimeException("Your direction must be either left or right");   
        }
    }
  

   /*
    * enable the bird to fly from a point to another
    *@param x(depart) and y(arrival) 
    *return T/F if the bird is able to fly
    */
    public boolean fly(int x, int y) {
        if ( x-y > 10 || y-x > 10) {
            System.out.println("\nYou just flight. You have arrived to your location");
            return true;  
        }
        else {
            System.out.println("You can't fly. The distance is less than 10 inches. Don't be lazy! WALK!");
            return false; 
        }
    }


   /*
    * Initialize the weight of the bird
    *@param Initial weight of the bird
    *return the initialized value of the weight of the bird
    */
    public  String Weight(Double InitialWeight) {
        if ( InitialWeight >= 16.0 && InitialWeight <= 34.0) {
            weight=InitialWeight;
            return ("You just initialized your weight to: "+ InitialWeight + " pounds");
        }
        else {
         throw new RuntimeException("\n Sorry! Your weight must be between 16 and 34 pounds! You don't want to be sick");       
        }
    }


    /*
    * reduces the weight of the bird if the weight was initialized and if the weight is superior to 4 pounds
    *return the new weight after the reduction 
    */
    public Number shrink() {
        if ( weight==null  ) {
            throw new RuntimeException("\n Sorry! Initialize your weight first ");           
        }
         else if(weight < 4){
            throw new RuntimeException("\n Sorry! Your weight is less than 4 pounds, you will die if you shrink. Grow first!");          
        }
         else { 
            weight= weight-2;
            System.out.println("You just shrank from 2 pounds ");
            return weight;
        } 
    }


   /*
    * add the weight of the bird
    *return the new weight after the increase
    */    
    public Number grow() {
        if ( weight > 38) {
            throw new RuntimeException("\n Sorry! If your weight increases, you may not be able to walk or fly again and later die ");
        }       
         else { 
            weight= weight+2;
            System.out.println("You just grew. You weight increased by 2 pounds ");
            return weight;
        }
    }


   /*
    * print a message to say that the bird is resting
    *return void
    */
    public void rest() {
        System.out.println("You are resting. You can choose to sleep or take a nap ");     
    }


   /*
    * print a message to say that the bird can't undo and give the user steps to follow to undo an action manually
    *return void
    */
    public void undo() {       
       System.out.println("Sorry you can't undo what you just did. What you might want to do is to change your previous values using the diffent option we have");
    }
  
    public static void main(String[] args) {
        VirtualBird korokoro = new VirtualBird("korokoro");
        System.out.println(korokoro);    
        korokoro.grab("dead leaves");
        korokoro.examine("dead leaves");
      // System.out.println( korokoro.drop("metal"));
       korokoro.use("metal");
       System.out.println(korokoro.walk("left"));
       System.out.println(korokoro.fly(5, 16));
       //System.out.println(korokoro.Weight(5.2));
       System.out.println(korokoro.Weight(32.0));
       System.out.println(korokoro.shrink());
       System.out.println(korokoro.grow());
       System.out.println(korokoro.grow());
       korokoro.rest();
       korokoro.undo();
    }
}

