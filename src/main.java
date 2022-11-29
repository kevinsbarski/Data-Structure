import java.util.EmptyStackException;
import java.util.Random;

public class main {
    public static void main(String [] args)throws Exception{
        MyStack stack = new MyStack();

        stack.push(45);
        stack.push(17);
        stack.push(15);
        stack.push(19);
        stack.push(20);
        System.out.println(stack.toString());
        //reverse(stack);

        MyStack stack2 = new MyStack();
        stack2.push(2);
        stack2.push(6);
        stack2.push(8);
        stack2.push(23);
        MyStack stack3 = new MyStack();
        stack3.push(13);
        stack3.push(19);
        stack3.push(17);
        Hstack hstack = new Hstack();
        hstack.getStackH()[0]=stack;
        hstack.getStackH()[1]=stack2;
        hstack.getStackH()[2]=stack3;
 //       bigMoveElement(hstack);
 //      System.out.println(hstack.getStackH()[0].toString());
        mergeToOne(hstack);
        System.out.println(hstack.getStackH()[0]);

    }
    public static void initializeStack(MyStack stack){
        Random r = new Random();
        int randomNum = r.nextInt(1,100);
        for(int i = 0; i <4;i++){
            stack.push(randomNum);
            randomNum = r.nextInt(1,100);
        }

    }
    public static MyStack reverse (MyStack stack)throws Exception{
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
        return mergedStack;
    }

    public static MyStack sortStack (MyStack stack) throws Exception {
        MyStack  tmpStack = new MyStack();
        while(!stack.isEmpty())
        {
            // pop out the first element
            int tmp = stack.pop();

            // while temporary stack is not empty and
            // top of stack is greater than temp
            while(!tmpStack.isEmpty() && tmpStack.peek() > tmp)
            {
                // pop from temporary stack and
                // push it to the input stack
                stack.push(tmpStack.pop());
            }

            // push temp in temporary of stack
            tmpStack.push(tmp);
        }
        tmpStack = reverse(tmpStack);

        return tmpStack;
    }
    public static boolean deleteElement(MyStack stack,int num) throws Exception {
        MyStack tmpStack = new MyStack();
        //tmpStack = reverse(stack);

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
    return false;
    }

    public static void bigMoveElement(Hstack hstack) throws Exception {
        hstack.getStackH()[0] = reverse(sortStack(hstack.getStackH()[0]));
        hstack.move(1);
        System.out.println(hstack.getStackH()[1].toString()+"2");

    }
    public static void mergeToOne(Hstack hstack) throws Exception {
        while(!hstack.getStackH()[1].isEmpty()){
            hstack.move(2);
        }
        while(!hstack.getStackH()[2].isEmpty()){
            hstack.move(3);
        }
        hstack.getStackH()[0] = sortStack(hstack.getStackH()[0]);


    }
    }





