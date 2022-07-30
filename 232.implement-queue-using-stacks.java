import java.util.Arrays;

/*
 * @lc app=leetcode id=232 lang=java
 *
 * [232] Implement Queue using Stacks
 */

// @lc code=start

class MyQueue {
    public int[] stack = new int[100];
    int sp = 0;
    int length = 0;

    void spush(int e){
        stack[sp++] = e; 
    }

    int spop(){
        sp--;    
        return stack[sp];
        
    }

    int speek(){
        return stack[sp-1];
    }

    boolean sempty(){
        return sp == 0;
    }

    int speekTail(){
        return stack[0];
    }
    //---
    public int[] stack2 = new int[100];
    int sp2 = 0;
    int length2 = 0;

    void spush2(int e){
        stack2[sp2++] = e; 
    }

    int spop2(){
        sp2--;    
        return stack2[sp2];
        
    }

    int speek2(){
        return stack2[sp2-1];
    }

    boolean sempty2(){
        return sp2 == 0;
    }

    int speekTail2(){
        return stack2[0];
    }

    public MyQueue() {
        
    }
    
    public void push(int x) {
        spush(x);
    }
    
    public int pop() {
        while(!sempty()) {
            spush2(spop());
        }
        // System.out.println(Arrays.toString(stack.stack));
        var ans = spop2();
        while(!sempty2()){
            spush(spop2());
        }
        return ans;
    }
    
    public int peek() {
        return speekTail();
    }
    
    public boolean empty() {
        return sempty();
    }
    public static void main(String[] args) {
        var mq = new MyQueue();
        mq.push(1);
        mq.push(2);
        var a = mq.peek();
        var b = mq.pop();
        var c = mq.empty();
        System.out.printf("%d %d %d\n", a, b, c ? 1 : 0);
    }
}
// class myStack{
//     public int[] stack = new int[100];
//     int sp = 0;
//     int length = 0;

//     void push(int e){
//         stack[sp++] = e; 
//     }

//     int pop(){
//         sp--;    
//         return stack[sp];
        
//     }

//     int peek(){
//         return stack[sp-1];
//     }

//     boolean empty(){
//         return sp == 0;
//     }

//     int peekTail(){
//         return stack[0];
//     }
// }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

