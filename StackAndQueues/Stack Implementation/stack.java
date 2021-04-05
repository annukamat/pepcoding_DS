public class stack {

    // FIELDS
    protected int[] arr = null;
    protected int capacity = 0; //maximum element that array can hold
    protected int elementCount = 0; // no. of elements presents in stack
    protected int tos = -1;     // top of stack

    // constructor.================================================================

    protected void initializeVariables(int capacity){
        this.capacity = capacity;
        this.arr = new int[this.capacity];
        this.elementCount = 0;
        this.tos = -1;
    }

    public stack(){
        initializeVariables(10); // default capaciy
    }

    public stack(int size){
        initializeVariables(size);
    }

    // basic functions ==============================================
    public int size(){
        return this.elementCount;
    }

    public boolean isEmpty() {
        return this.elementCount == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.elementCount; i++) {
            sb.append(this.arr[i]);
            if (i != this.elementCount - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

 

    // Exceptions ==============================================
    private void OverflowException() throws Exception {
        if(this.capacity == this.elementCount) {
            throw new Exception("StackIsFull"); 
        }
    }

    private void underFlowException() throws Exception {
        if(this.elementCount == 0){
            throw new Exception("StackIsEmpty");
        }
    }

    // stack Functions ==============================================
    protected void push_(int data){
        this.arr[++this.tos] = data;
        this.elementCount++;
    }

    public void push(int data) throws Exception {
        OverflowException();
        push_(data);
    }


    public int top() throws Exception {
        underFlowException();
        return this.arr[this.tos];
    }

    protected int pop_(){
        int rv = this.arr[this.tos];
        this.arr[this.tos--] = 0;
        this.elementCount--;
        return rv;
    }

    public int pop() throws Exception {
        underFlowException();
        return pop_();
    }

}