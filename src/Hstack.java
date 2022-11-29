/*
kevin sbarski 324589480
amit  sherman 209284017
 */
import java.util.Arrays;
import java.util.EmptyStackException;

public class Hstack {
    //Hstack attribute.
    private MyStack stackH [];

    //A default constructor to initialize stackH attribute with an array of 3 MyStack elements
    public Hstack(){
        this.stackH = new MyStack[3];
    }
    //Boolean method to check if Hstack[s] is empty.
    public boolean isEmpty(int s){
        return this.stackH[s].isEmpty();
    }

    //A method to peek and return the first element in Hstack in the array index given.
    public int peek (int s) throws Exception {
        if (this.stackH[s].isEmpty()){
            throw new EmptyStackException();
        }
        return this.stackH[s].peek();
    }

    //A method to move the first element in the index array given to the next place in Hstack array.
    public  void move (int s){
        switch (s){
            case 1:
                if(this.stackH[0].isEmpty()){
                    System.out.println("Empty stack.");
                    break;
                }
                this.stackH[1].push(this.stackH[0].pop());
                break;
            case 2:
                if(this.stackH[0].isEmpty()) {
                    System.out.println("Empty stack.");
                    break;
                }
                this.stackH[2].push(this.stackH[1].pop());
                break;
            case 3:
                if(this.stackH[0].isEmpty()) {
                    System.out.println("Empty stack.");
                    break;
                }
                this.stackH[0].push(this.stackH[2].pop());
                break;
            }

        }

    @Override
    public String toString() {
        return "Hstack{" +
                "stackH=" + Arrays.toString(stackH) +
                '}';
    }

    //A method which return the stackH attribute.
    public MyStack[] getStackH() {
        return stackH;
    }

}

