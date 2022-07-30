import java.util.LinkedList;

/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */

// @lc code=start
class Solution {
    public void displayLinkedList(LinkedList<Integer> s){
        s = (LinkedList<Integer>)s.clone();
        if (s.size() == 0) {
            System.out.println("<>");
            return ;
        }
        System.out.print("<");
        for (int i = 0; i < s.size(); i++){
            int e = s.get(i);
            if(e == '+' || e == '-' || e == '(' || e == ')') {
                System.out.printf("%c ", e);
            }else{
                System.out.printf("%d ", e);
            }
        }
        System.out.print(">\n");
    }

    public LinkedList<Integer> digitsTransform(String s) {
        var stack = new LinkedList<Integer>();
        int sum = 0;
        boolean isPlaced = true;
        for (var c : s.toCharArray()) {

            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                sum = sum * 10 + (c - '0');
                isPlaced = false;
            } else {
                if(isPlaced){
                    // System.out.printf("c:%c\n", c);
                    stack.addLast((int)c);
                }else{
                    stack.addLast(sum);
                    sum = 0;
                    isPlaced = true;
                    // System.out.printf("c:%c\n", c);
                    stack.addLast((int)c);
                }
            }
        }
        if(!isPlaced){
            stack.addLast(sum);
        }
        // displayLinkedList(stack);
        return stack;
    }

    LinkedList<Integer> minusTransform(LinkedList<Integer> s){
        var output = new LinkedList<Integer>();
        boolean nearDigit = false;
        while(s.size() > 0){
            var x = s.pop();
            if (x == '-' && !nearDigit) {
                output.addLast(0);
            }
            output.addLast(x);
            if(x != '+' && x != '-' && x != '(' ){
                nearDigit = true;
            }else{
                nearDigit = false;
            }
        }
        return output;
    }

    public int calculate(String s) {
        var calculateList = digitsTransform(s);
        // displayLinkedList(calculateList);            
        calculateList =  minusTransform(calculateList);
        var assistStack = new LinkedList<Integer>();

        while(calculateList.size() > 0){
            var x = calculateList.pop();
            // System.out.println(String.format("current x:%d", x));
            if (x == '+' || x == '-') {
                if(calculateList.peek() != '('){
                    var ans = assistStack.pop() + calculateList.pop() * ((x == '+') ? 1 : -1);
                    assistStack.push(ans);
                } else {
                    assistStack.push(x);
                    calculateList.pop();
                }
            } else if (x == '(') {
                //Do nothing.
            }
            else if (x == ')') {
                if (assistStack.size() < 3) {
                    continue;
                }
                var operatand2 = assistStack.pop();    
                var operator1 = assistStack.pop();
                var operatand1 = assistStack.pop();
                var ans = operatand1 + operatand2 * ((operator1 == '+') ? 1 : -1);
                assistStack.push(ans);
                //Do nothing?
            }else{
                assistStack.push(x);
            }
            // displayLinkedList(calculateList);
            // displayLinkedList(assistStack);
            // System.out.println("---");
            
        }
        return assistStack.peek();
    }

    public static void main(String[] args) {
        // var t = "(-1+2)";
        // System.out.println(new Solution().minusTransform(new Solution().digitsTransform(t)));
        
        var s = "(1+(4+5+2)-3)+(6+8)";
        // var a = new Solution().digitsTransform(s);
        // System.out.println(a);
        var b = new Solution().calculate(s);
        System.out.println(b);
    }
}
// @lc code=end
