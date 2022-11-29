/*
kevin sbarski 324589480
amit  sherman 209284017
 */
import java.util.EmptyStackException;
import java.util.Random;

public class main {
    public static void main(String [] args)throws Exception{
        MyStack stack = new MyStack();
        initializeStack(stack);
        MyStack stack2 = new MyStack();
        initializeStack(stack2);
        MyStack stack3 = new MyStack();
        initializeStack(stack3);

        Hstack hstack = new Hstack();
        hstack.getStackH()[0]=stack;
        hstack.getStackH()[1]=stack2;
        hstack.getStackH()[2]=stack3;

//        System.out.println("Ex 1 - Reverse stack method.");
//        System.out.println("stack before reverse method - "+stack.toString());
//        System.out.println("stack after reverse method  - "+reverse(stack));

//        System.out.println("Ex 3 - sorting a stack by low to high value.");
//        System.out.println("stack before sort method - "+stack.toString());
//        System.out.println("stack after sort method  -"+sortStack(stack));

//        stack = sortStack(stack);//       stack2 = sortStack(stack2);//       System.out.println("Ex 2  - merging two sorted stacks.");
//        System.out.println("stack1 before merging\nstack 1 - "+stack.toString());
//        System.out.println("stack2 before merging\nstack 2 - "+stack2.toString());
//        System.out.println("after merging - "+mergeStacks(stack,stack2));

//        System.out.println("Ex 4 - deleting a number in stack.");
//        System.out.println("stack before deleting method - "+stack.toString());
//        System.out.println("stack after deleting method - "+deleteElement(stack,97));

//          System.out.println("Ex 5 - moving the bigest elemnt in Hstack[0] to Hstack[1].");
//        System.out.println("hstack before the method -  "+hstack.getStackH()[0].toString());
//        System.out.println("                            "+hstack.getStackH()[1].toString());
//        System.out.print("stack after moving method - ");
//        bigMoveElement(hstack);

//        System.out.println("Ex 6 - merging all stack of Hstack into one sack.");
//        System.out.println("Hstack before method - "+hstack.toString());
//        mergeToOne(hstack);
//        System.out.println("Hstack after method - "+hstack.toString());




    }
    //A method to initialize the stack with random numbers.
    public static void initializeStack(MyStack stack){
        Random r = new Random();
        int randomNum = r.nextInt(1,100);
        for(int i = 0; i <4;i++){
            stack.push(randomNum);
            randomNum = r.nextInt(1,100);
        }
    }

    //A method to reverse the stack given.
    public static MyStack   reverse (MyStack stack)throws Exception{
        MyStack newStack = new MyStack();
        int iLim = stack.getFlag();
        try{
            for(int i=0; i<iLim ;i++){
               newStack.push(stack.pop());
            }
        }catch (EmptyStackException e){
            System.out.println(e.toString());
        }
       return newStack;
    }

    //A method to merge between two stacks.
    public static MyStack mergeStacks (MyStack stack1, MyStack stack2) throws Exception {
        int indexFlag = stack1.getFlag() + stack2.getFlag();
        MyStack mergedStack = new MyStack();
        int empty = 0;
        while (!(stack1.isEmpty()) || !(stack2.isEmpty())) {
            if (!(stack1.isEmpty()) && !(stack2.isEmpty()))
                empty = 1;
            if (!(stack1.isEmpty()))
                empty = 2;
            if (!(stack2.isEmpty()))
                empty = 3;

            switch (empty) {
                case 1:
                    if (stack1.peek() >= stack2.peek()) {
                        mergedStack.push(stack2.pop());
                    } else if (stack2.peek() >= stack1.peek()) {
                        mergedStack.push(stack1.pop());
                    }
                    break;
                case 2:
                    mergedStack.push(stack1.pop());
                    break;
                case 3:
                    mergedStack.push(stack2.pop());
                    break;
            }

        }

        return sortStack(mergedStack) ;
    }

    //A method to sort stack from the lowest element to the highest.
    public static MyStack sortStack (MyStack stack) throws Exception {
        MyStack  tmpStack = new MyStack();
        while(!stack.isEmpty())
        {
            int tmp = stack.pop();

            while(!tmpStack.isEmpty() && tmpStack.peek() > tmp)
            {
                stack.push(tmpStack.pop());
            }
            tmpStack.push(tmp);
        }
        tmpStack = reverse(tmpStack);
        return tmpStack;
    }

    //A boolean method to delete the number given in a stack given.
    //if the element is not in the stack it will return false.
    public static boolean deleteElement(MyStack stack,int num) throws Exception {
        MyStack tmpStack = new MyStack();

        int indexStack = stack.getStack().length;
        int elementDelete = -1;
        for(int i = 0; i<indexStack; i++){
            if(stack.getStack()[i] == num){
                elementDelete = i;
                break;
            }
        }
        if(elementDelete > -1){
            for(int i = 0; i<=indexStack-1; i++){
                if(i==elementDelete)
                    i++;
                if(i < indexStack)
                tmpStack.push(stack.getStack()[i]);
            }
        stack = tmpStack;
        stack = reverse(stack);
        }

    if(elementDelete >-1){
        System.out.println(stack);
        return true;
    }
        System.out.println(stack);
    return false ;
    }

    //A method to move the biggest element in a given Hstack object to second stack array in Hstack.
    public static void bigMoveElement(Hstack hstack) throws Exception {
        hstack.getStackH()[0] = reverse(sortStack(hstack.getStackH()[0]));
        hstack.move(1);
        System.out.println(hstack.getStackH()[1].toString());

    }

    //A method to merge all the stacks of an Hstack object into one stack.
    public static Hstack mergeToOne(Hstack hstack) throws Exception {
        while(!hstack.getStackH()[1].isEmpty()){
            hstack.move(2);
        }
        while(!hstack.getStackH()[2].isEmpty()){
            hstack.move(3);
        }
        hstack.getStackH()[0] = sortStack(hstack.getStackH()[0]);
        return hstack;


    }

    }





