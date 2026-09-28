import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Stack and Queue Implementations and Applications
 * Demonstrates:
 * 1. Array-based Custom Stack with push, pop, peek, isEmpty
 * 2. LinkedList-based Custom Queue with enqueue, dequeue, peek
 * 3. Standard Java Collections Stack/Queue/Deque usage
 * 4. Classic problem: Valid Parentheses checker
 */
public class StackQueueDemo {

    // 1. Custom Fixed-Capacity Array Stack
    public static class CustomArrayStack<T> {
        private final Object[] elements;
        private int top = -1;
        private final int capacity;

        public CustomArrayStack(int capacity) {
            this.capacity = capacity;
            this.elements = new Object[capacity];
        }

        public void push(T item) {
            if (top == capacity - 1) {
                throw new IllegalStateException("Stack Overflow: capacity reached (" + capacity + ")");
            }
            elements[++top] = item;
        }

        @SuppressWarnings("unchecked")
        public T pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack Underflow: stack is empty");
            }
            T val = (T) elements[top];
            elements[top--] = null;
            return val;
        }

        @SuppressWarnings("unchecked")
        public T peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack Underflow: stack is empty");
            }
            return (T) elements[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public int size() {
            return top + 1;
        }
    }

    // 2. Custom Singly-Linked Queue
    public static class CustomLinkedQueue<T> {
        private static class QNode<T> {
            T data;
            QNode<T> next;
            QNode(T data) { this.data = data; }
        }

        private QNode<T> head;
        private QNode<T> tail;
        private int size = 0;

        public void enqueue(T item) {
            QNode<T> newNode = new QNode<>(item);
            if (tail != null) {
                tail.next = newNode;
            }
            tail = newNode;
            if (head == null) {
                head = tail;
            }
            size++;
        }

        public T dequeue() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue Underflow: queue is empty");
            }
            T val = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return val;
        }

        public T peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            return head.data;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }
    }

    // 3. Classic Application: Valid Parentheses Checking
    public static boolean isValidParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("=== 1. Custom Stack Test ===");
        CustomArrayStack<Integer> stack = new CustomArrayStack<>(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Top element (peek): " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Stack size: " + stack.size());

        System.out.println("\n=== 2. Custom Queue Test ===");
        CustomLinkedQueue<String> queue = new CustomLinkedQueue<>();
        queue.enqueue("Task A");
        queue.enqueue("Task B");
        queue.enqueue("Task C");
        System.out.println("Queue front: " + queue.peek());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Queue size: " + queue.size());

        System.out.println("\n=== 3. Valid Parentheses Test ===");
        String test1 = "{[()]}";
        String test2 = "{[(])}";
        System.out.println(test1 + " -> " + isValidParentheses(test1));
        System.out.println(test2 + " -> " + isValidParentheses(test2));
    }
}
