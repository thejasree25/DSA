import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public MyStack() {
        // Constructor
    }

    public void push(int x) {
        // Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        // Add the new element to q1
        q1.offer(x);

        // Move everything back from q2 to q1
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
    }

    public int pop() {
        if (!q1.isEmpty()) {
            return q1.poll(); // Remove and return the front (top of stack)
        }
        return -1; // or throw exception
    }

    public int top() {
        if (!q1.isEmpty()) {
            return q1.peek(); // Peek front element
        }
        return -1; // or throw exception
    }

    public boolean empty() {
        return q1.isEmpty(); // q1 holds all elements
    }
}
