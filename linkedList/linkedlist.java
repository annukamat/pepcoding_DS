public class linkedlist {
    private class Node {
        int data = 0;
        Node next = null;

        Node(int data){
            this.data = data;
        }
    }


    private Node head = null;
    private Node tail = null;
    private int sizeOfLL = 0;

    public boolean isEmpty() {
        return this.sizeOfLL == 0;
    }

    public int size(){
        return this.sizeOfLL;
    }

    public void display(){
        Node curr = this.head;

        while(curr != null){
            System.out.println(curr.data + "->");
            curr = curr.next;

        }
        System.out.println();
    }

    // Exception
    private void EmptyException() throws Exception {
        if (this.sizeOfLL == 0) {
            throw new Exception("LinkedList is Empty: -1");
        }
    }

    private void IndexOutOfBoundSizeExclusiveException(int idx) throws Exception {
        if(idx < 0 || idx >= this.sizeOfLL){
            throw new Exception("Index Out of Bound: -1");
        }
    }

    private void IndexOutOfBoundSizeInclusiveException(int idx) throws Exception {
        if(idx < 0 || idx > this.sizeOfLL){
            throw new Exception("Index Out of Bound: -1");
        }
    }

    // get_==================================================
    public int getFirst() throws Exception{
        EmptyException();
        return this.head.data;
    }

    public int getLast() throws Exception{
        EmptyException();
        return this.tail.data;
    }

    private Node getNodeAt(int idx){
        Node curr = this.head;
        while(idx-- > 0){
            curr = curr.next;
        }
        return curr;
    }
    
    public int getAt(int idx){
        IndexOutOfBoundSizeExclusiveException(idx);
        Node node = getNodeAt(idx);
        return node.data;
    }

    // add_==================================================
    private void addFirstNode(Node node){
       if(this.head == null){
           this.head = node;
           this.tail = node;
       }else{
           node.next = this.head;
           this.head = node;
       }

       this.sizeOfLL++;
    }
    public void addFirst(int data){
        Node node = new Node(data);
        addFirstNode(node);
    }

    private void addLasttNode(Node node){
       if(this.head == null){
           this.head = node;
           this.tail = node;
       }else{
           this.tail.next = node;
           this.tail = node;
       }

       this.sizeOfLL++;
    }
    public void addLast(int data){
        Node node = new Node(data);
        addLasttNode(node);
    }

    private void addAtNode(int idx, Node node){
        if(idx == 0){
        addFirstNode(node);
        }else if(idx == this.sizeOfLL){
            addLasttNode(node);
        }else{
            Node prev = getNodeAt(idx - 1);
            Node forw = prev.next;

            prev.next = node;
            node.next = forw;

            this.sizeOfLL++;

        }
    }

    public void addAt(int idx, int data) throws Exception{
        IndexOutOfBoundSizeInclusiveException(idx);
        Node node = new Node(data);
        addAtNode(idx, node);
    }


    // remove_==================================================

    private Node removeFirstNode(){
        Node removeNode = this.head;
        if(this.sizeOfLL == 1){
            this.head = null;
            this.tail = null;
        }else{
            Node forw = this.head.next;
            removeNode.next = null;
            this.head = forw;
        }

        this.sizeOfLL--;
        return removeNode;
    }

    public int removeFirst() throws Exception{
        EmptyException();
        Node node = removeFirstNode();
        return node.data;
    }

    private Node removeLastNode(){
        Node removeNode = this.tail;
        if(this.sizeOfLL == 1){
            this.head = null;
            this.tail = null;
        }else{
            Node secondLastNode = getNodeAt(this.sizeOfLL - 2);
            this.tail = secondLastNode;
            this.tail.next = null
        }
        this.sizeOfLL--;
        return removeNode;
    }

    public int removeLast(){
        EmptyException();
        Node node = removeLastNode();
        return node.data;

    }


}