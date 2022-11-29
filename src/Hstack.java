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

    public MyStack[] getStackH() {
        return stackH;
    }
}

