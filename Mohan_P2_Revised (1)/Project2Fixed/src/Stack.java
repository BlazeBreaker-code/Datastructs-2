class Stack {
    //pg183 + 182 questions
    /*
    Step 1 − scan the expression from left to right
    Step 2 − if it is an operand push it to stack
    Step 3 − if it is an operator pull operand from stack and perform operation
    Step 4 − store the output of step 3, back to stack
    Step 5 − scan the expression until all operands are consumed
    Step 6 − pop the stack and perform operation
     */

    private int count; //number of elements in the stack
    private int top;    //top element of the stack. top == -1 if the stack is empty private
    int MAXSIZE = 1000; //Physical size of the stack
    private int [] array;

    //constructor
    Stack() {
        array = new int[MAXSIZE];
        top = -1;

    }

    //inspectors
    public boolean stackEmpty() {
        //Returns true if the stack is empty. Otherwise returns false.
        if (top<0){
            //System.out.println("Stack is empty!");
            return true;
        } else{
            return false;
        }
    }
    public int stackTop() {
        //Returns the top element of the stack
        return array[top];
    }

    public int stackCount() {
        //Returns the number of elements in the stack
        count = array.length;
        return count;
    }

    public String toString() {
        //Returns the elements of the stack with the following format:
        // < E1 E2 E3 ... En> where E1 is at the bottom of the stack
        // and En is at the top of the stack.

        //Didn't really understand the reason behind this duplicate
        if (stackEmpty()) {
            return "< >";
        } else {

            while (!stackEmpty()) {
                //{
                String lol = "";
                int i;
                for (i = 0; i <= top; i++) {

                    char temp = (char) array[i];
                    lol += temp;
                }

                return ("< " + lol + " >");
            }
        }
        return "";
    }

    public String printCharStack() {
        //Returns the elements of the stack with the following format:
        // < E1 E2 E3 ... En> where E1 is at the bottom of the stack
        // and En is at the top of the stack.
        //The elements are printed to the returning string as chars.

        //Had to create a clone in order to print out the array
        if (stackEmpty()) {
            return "< >";
        } else {

            while (!stackEmpty()) {
                //{
                String lol = "";
                int i;
                for (i = 0; i <= top; i++) {

                    char temp = (char) array[i];
                    lol += temp;
                }

                return ("< " + lol + " >");
            }
        }
        return "";
    }

    //modifiers
    public void stackPush(int element) {
        //Pushes element to the top of the stack.
        //Assumes that we will not run out of space in the stack.
        if(top>MAXSIZE){
            System.out.println("Stack is full!");
        } else {
            array[++top] = (char)element;
            // System.out.println("Pushed to stack: " +(char)element);
        }
    }

    public boolean stackPop() {
        //Pops out the top element of the stack.
        // Returns true if the operation was successful.
        // Returns false otherwise.
        if (!stackEmpty()) {
            //System.out.println("Popped from stack: " + stack[top]);
            array[top] = array[top--];
            return true;
        } else {
            System.out.println("Stack is empty!");
            return false;
        }
    }
}

