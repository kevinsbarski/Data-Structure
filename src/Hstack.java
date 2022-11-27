import java.util.EmptyStackException;

public class Hstack {
    private MyStack stackH [];
    public Hstack(){
        this.stackH = new MyStack[3];
    }
    public boolean isEmpty(int s){
        return this.stackH[s].isEmpty();
    }
    public int peek (int s) throws Exception {
        if (this.stackH[s].isEmpty()){
            throw new EmptyStackException();
        }
        return this.stackH[s].peek();
    }
    public void move (int s){

    }
}
