import java.util.LinkedList;
import java.util.Queue;

class MyStack {
     Queue<Integer> q=new LinkedList<>();

    public MyStack() {
        // Constructor
    }

    public void push(int x) {
        q.add(x);
        for(int i=0;i<q.size()-1;i++){
            int temp=q.poll();
            q.add(temp);
        }

      
    }

    public int pop() {
       return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
