class Stack{
    private linklist<Integer> stack;
    public Stack(){
        stack = new linklist<Integer>();
    }

    public void push(int value){
        stack.insert(value, 0);
    }
    public int pop(){
        return stack.remove(0);
    }
    public int peek(){
        return stack.get(0);
    }
    public int getSize(){
        return stack.getSize();
    }
}
public class sTAQUE {

    public static void main(String[] args){
        Stack numbers = new Stack();
        numbers.push(34);
        System.out.println(numbers.peek());
        numbers.push(12);
        System.out.println(numbers.peek());
        System.out.println(numbers.pop());
        System.out.println(numbers.peek());
        System.out.println(numbers.getSize());
    }
}
