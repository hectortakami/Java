/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A01377647
 */
public class Main {
    
    public static String checkForBalance(String expStr) {
        // holds left-symbols 
        ALStack<Character> s = new ALStack<Character>();
        int i = 0;
        char scanCh = ' ', matchCh;
        String msgStr = "";
        while (i < expStr.length()) {
        // access the character at index i 
            scanCh = expStr.charAt(i);
            // check for left-symbol; if so, push on stack; 
            // otherwise, check for right-symbol and 
            // check balancing 
            if (scanCh == '(' || scanCh == '[' || scanCh == '{') {
                s.push(scanCh);
            } else if (scanCh == ')' || scanCh == ']' || scanCh == '}') {
            // get character on top of stack; 
            // if stack is empty, catch the exception 
            // and return the error message 
                try {
                    matchCh = s.pop();
                // check for corresponding matching 
                // pair; if match fails, return an 
                // error message 
                    if (matchCh == '(' && scanCh != ')' || matchCh == '[' && scanCh != ']' || matchCh == '{' && scanCh != '}') {
                        msgStr += "^";
                        return "\n" + msgStr + "  Missing left symbol";
                    }
                } catch (RuntimeException e) {
                    msgStr += "^";
                    return "\n" + msgStr + "  Missing left symbol";
                }
            }
            i++;
            msgStr += " ";
        }
        // at end of scan, check the stack; if empty, 
        // return message that string is balanced; 
        // otherwise return an error message 
        if (s.isEmpty()) {
            return "\n" + msgStr + " Expression is balanced";
        } else {
            msgStr += "^";
            return "\n" + msgStr + "  Missing right symbol";
        }
    }

    public static String baseString(int num, int b) {
        // digitChar.charAt(digit) is the 
        // character that represents the digit, 
        // 0 <= digit <= 15 
        String digitChar = "0123456789ABCDEF", numStr = "";
        // stack holds the base-b digits of num 
        ALStack<Character> stk = new ALStack<Character>();
        // extract base b digits right 
        // to left and push on stack 
        do {
        // push right-most digit on the stack 
            stk.push(digitChar.charAt(num % b));
        // remove right-most digit from num 
            num /= b;
        // continue until all digits found 
        } while (num != 0);
        while (!stk.isEmpty()) // flush the stack 
        {
        // pop stack and add digit on top 
        // of stack to numStr 
            numStr += stk.pop().charValue();
        }
        return numStr;
    }
    public static void main(String[] args) {
        
        System.out.println(baseString(123456789, 16));
        System.out.println(baseString(64, 2));
        
        System.out.println(checkForBalance("(()){}[][{}]"));
    }
    
}
