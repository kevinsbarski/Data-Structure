import java.util.EmptyStackException;

public class main {
    public static void main(String [] args)throws Exception{
        MyStack stack = new MyStack();
        System.out.println("the stack is empty?"+stack.isEmpty());
        stack.push(3);
        System.out.println(stack.getStack());
        System.out.println("the stack is empty?"+stack.isEmpty());
        stack.push(4);
        System.out.println(stack.getStack());
        stack.push(6);
        System.out.println(stack.getStack());
        System.out.println(stack.toString());
        stack.pop();
        System.out.println("first popo was succeses");
        stack.pop();
        stack.pop();
        System.out.println(stack.getStack());
        System.out.println("the stack is empty?"+stack.isEmpty());
        System.out.println(stack.getStack());
        System.out.println(stack.getFlag());
        try{
            System.out.println(stack.peek());
        }catch (EmptyStackException e){
            System.out.println(e.toString());
        }

        System.out.println("end");
    }

}
