import java.util.Arrays;
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
             for(int i = 1; i < copyStack.length; i++){
                copyStack[i] = this.stack[i-1];
             }
             this.stack = copyStack;
        }

    }
    public int pop()throws EmptyStackException{
        int popedNumber;
        if(isEmpty()){
            throw new EmptyStackException();
        }
        else{
            System.out.println("before pop stack flag="+flag);
            System.out.println(stack.length);
            flag-=1;
            popedNumber = this.stack[0];
            int copyStack [] = new int[stack.length-1];
            for(int i = 0; i < copyStack.length; i++){
                copyStack[i] = stack[i+ 1];
            }
            stack = copyStack;
            System.out.println("after pop func flag="+flag);

            }
        return popedNumber;
    }

    public int peek()throws Exception {

            if (this.isEmpty()) {
                throw new EmptyStackException();
            } else {
                return this.stack[0];
            }
    }





    public int[] getStack() {
        for(int i=0; i<stack.length; i++){
            System.out.print("the elemnet is "+stack[i]);

        }
        System.out.println();
        return stack;
    }

    public int getFlag() {
        return flag;
    }
//    public String ToString(){
//
//
//    }

    @Override
    public String toString()throws EmptyStackException {
        if(this.isEmpty())
            throw new EmptyStackException();

        String str = "[";
        for (int i = 0; i < this.stack.length-1; i++) {
            str += this.stack[i] + ", ";
        }
        str += this.stack[this.stack.length-1];
        str += "]";
        return str;
    }
}
