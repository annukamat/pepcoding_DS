import java.util.Stack;

public class queueUsingStack_pop {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> temp = new Stack<>();

    public int size(){
        return st.size();
    }

    public boolean isEmpty(){
        return st.isEmpty();
    }

    private void transferToAnotherStack(){
        while(st.size() != 0){
            temp.push(st.pop());
        }
    }

    public void add(int data){
        transferToAnotherStack();
        this.st.push(data);

        while(this.temp.size() != 0)
            this.st.push(this.temp.pop());
        
    }

    public int peek(){
        return this.st.peek();
    }

    public int remove(){
        return this.st.pop(); 
    }
}