
public class AdtTest {
    private static Adt<Integer> stack;
    public static final int CAPACITY=1000;

    public static void main(String[] args) {
    	 stack = new Adt<>(CAPACITY);
    	 stack.push(1, 0);
         stack.push(2, 0);
         stack.push(3, 0);
         System.out.println("Popped: "+ stack.pop(0));
         stack.push(12, 0);
         stack.push(15, 0);
         stack.push(17, 0);
         System.out.println("Popped: "+ stack.pop(0));
         stack.push(1, 0);
         stack.push(2, 0);
         stack.push(3, 0);
         
         stack.push(4, 1);
         stack.push(5, 1);
         stack.push(6, 1);
         System.out.println("Popped: "+ stack.pop(1));
         stack.push(4, 1);
         stack.push(5, 1);
         stack.push(6, 1);
         System.out.println("Popped: "+ stack.pop(1));
         stack.push(7, 1);
         stack.push(8, 1);
    }
}