//Suraj Mohan N01234931
import java.util.Scanner;

public class Project2Fixed {

    public static int precedence(char c) {
        switch(c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

        //Had to restructure assignment to include main that was in the project

        public static void main(String[] args){
        String infixExp;//infix expression to be read
        String postfixExp;//postfix expression to be output
        postfixExp = "";
        Stack S = new Stack(); //stack for converting the infix expression
                               // to postfix notation
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a infix expression: ");


        infixExp = scan.next();
        System.out.println();
        char temp;

        for(int i = 0; i < infixExp.length(); i++) {
            temp = infixExp.charAt(i);

            if(Character.isLetterOrDigit(temp)) {
                postfixExp += temp;
                System.out.format("%c:   %-30s%-30s\n",temp,postfixExp,S.printCharStack());
            }

            else if(temp == '(') {
                S.stackPush(temp);
                System.out.format("%c:   %-30s%-30s\n", temp, postfixExp, S.printCharStack());
            }

            else if(temp == ')') {

                boolean output = false;
                while((char)S.stackTop() != '(') {
                    postfixExp += (char)S.stackTop();
                    S.stackPop();
                    if(!output) {
                        System.out.format("%c:   %-30s%-30s\n", temp, postfixExp, S.printCharStack());
                        output = true;
                    } else {
                        System.out.format("%c    %-30s%-30s\n", ' ', postfixExp, S.printCharStack());
                    }
                }

                S.stackPop();
                if(!output) {
                    System.out.format("%c:   %-30s%-30s\n", temp, postfixExp, S.printCharStack());
                    output = true;
                }
                else {
                    System.out.format("%c    %-30s%-30s\n", ' ', postfixExp, S.printCharStack());
                }
            } else {
                boolean output = false;
                if(!S.stackEmpty() && temp != '(') {
                    while(!S.stackEmpty() && (precedence(temp) <= precedence((char)S.stackTop()))) {

                        postfixExp += (char)S.stackTop();
                        S.stackPop();
                        if(!output) {
                            System.out.format("%c:   %-30s%-30s\n", temp, postfixExp, S.printCharStack());
                            output = true;
                        } else {
                            System.out.format("%c    %-30s%-30s\n", ' ', postfixExp, S.printCharStack());
                        }

                    }

                }
                S.stackPush(temp);

                if((!output)) {
                    System.out.format("%c:   %-30s%-30s\n", temp, postfixExp, S.printCharStack());
                    output = true;
                } else {
                    System.out.format("%c    %-30s%-30s\n", ' ', postfixExp, S.printCharStack());
                }
            }
        }

        while(!S.stackEmpty()) {
            postfixExp += (char)S.stackTop();
            S.stackPop();
            System.out.format("%c    %-30s%-30s\n", ' ', postfixExp, S.printCharStack());
        }

        System.out.println("\nThe expression in postfix notation is "+postfixExp);
    }
}

