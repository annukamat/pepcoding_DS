public class client {
    public static void main(String[] args) throws Exception {
        dynamicStack st = new dynamicStack(5);

        for(int i=0; i<12; i++){
            st.push(i*10);
        }
        
        // while(st.size() != 0){
        // System.out.println(st); 
        // System.out.println(st.pop()); 
        // }

        System.out.println(st); 

    }
}