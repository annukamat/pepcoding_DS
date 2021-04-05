public class client {
    // public static void main(String[] args){
    //     queueUsingStack_pop que = new queueUsingStack_pop();

    //     for(int i=1; i<=10; i++){
    //         que.add(i*10);
    //     }
    //     while(que.size() != 0){
    //         System.out.println(que.remove());
    //     }
    // }

    public static void main(String[] args){
        StackUsingQueue_pop st = new StackUsingQueue_pop();

        for(int i=1; i<=10; i++){
            st.push(i*10);
        }
        while(st.size() != 0){
            System.out.println(st.pop());
        }
    }

}