import java.util.EmptyStackException;

public class MyStack {

    private int stack[];
    private int flag;

    public MyStack(){
        this.flag = 0;
        this.stack = new int[1];
        System.out.println("the array has benn created,the first number in the array is: "+ stack[0]);
    }

    public void flagCheck(){
        if(this.flag<0) {flag = 0;}

    }

    boolean isEmpty(){
        if (this.flag > 0) {return false;}
        return true;
    }
    public void push(int num){
        if (this.isEmpty()){
            stack[0] = num;
            flag+=1;
        }
        else {
             int copyStack [] = new int[stack.length+1];
             copyStack[0] = num;
             flag+=1;
             for(int i = 1; i < copyStack.length-1; i++){
                copyStack[i] = stack[i-1];
                flag+=1;
             }

             copyStack[flag-1] = num;
             stack = copyStack;
        }

    }
    public void pop(){
        if (flag <= 0)
            throw new ArrayIndexOutOfBoundsException("Cannot pop! Stack is empty.");


    }

    public int[] getStack() {
        for(int i=0; i<stack.length; i++){
            System.out.print("the elemnet is"+stack[i]);
        }
        return stack;
    }

    public int getFlag() {
        return flag;
    }
}
