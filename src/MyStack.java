/*
kevin sbarski 324589480
amit  sherman 209284017
 */
import java.util.EmptyStackException;

public class MyStack {

    //Class attributes.
    private int stack[];
    private int flag;

    //Default constructor,initialize flag(elements' counter to zero).
    //Initialize stack attribute to array in length of 0.
    public MyStack(){
        this.flag = 0;
        this.stack = new int[0];
    }

    //Boolean method to check if stack is empty.
    //EX1
    boolean isEmpty(){
        if (this.flag > 0) {return false;}
        return true;
    }

    //A method to insert a num into a stack
    //EX2
    public void push(int num){
        //If the stack is empty,it creates an array of length 1 and insert to it the number.
        if (this.isEmpty()){
            stack =new int[1];
            stack[0] = num;
            flag+=1;
        }
        //Else it copies the first element to a new stack array and copy the rest of the elements.
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

    //A method that pop the first element out of the stack array.
    //Return the popped element.
    //EX3
    public int pop()throws EmptyStackException{
        int poppedNumber;
        if(isEmpty()){
            throw new EmptyStackException();
        }
        else{
            flag-=1;
            poppedNumber = this.stack[0];
            int copyStack [] = new int[stack.length-1];
            for(int i = 0; i < copyStack.length; i++){
                copyStack[i] = stack[i+ 1];
            }
            stack = copyStack;
            }
        return poppedNumber;
    }

    //A method which peek the first element of the stack array and return it.
    //EX4
    public int peek()throws Exception {

            if (this.isEmpty()) {
                throw new EmptyStackException();
            } else {
                return this.stack[0];
            }

    }

    //A getter method for stack attribute.
    public int[] getStack() {
        return stack;
    }

    //A getter method for flag attribute.
    public int getFlag() {
        return flag;
    }

    @Override//A method to print the stack.
    //EX5
    public String toString()throws EmptyStackException {
        if(this.isEmpty()){
            System.out.println("Stack is empty.");
            return null;
        }
        String str = "[";
        for (int i = 0; i < this.stack.length-1; i++) {
            str += this.stack[i] + ", ";
        }
        str += this.stack[this.stack.length-1];
        str += "]";
        return str;
    }
}