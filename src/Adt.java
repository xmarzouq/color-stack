import java.util.NoSuchElementException;

public class Adt<E> implements ColorStack<E> {

	private E[] doubleStack;
	private int   topOnLeft_red;
	private int   topOnRight_blue;
	private int size;

	@SuppressWarnings("unchecked")
	public Adt(int size) {
		doubleStack = (E[]) new Object[size];
		this.topOnLeft_red = 0;
		this.topOnRight_blue = doubleStack.length - 1;
		this.size = size;
	}
	//-------------------------------------------------------------------
	public void push(E item, int place) throws IllegalStateException {
		if(size() == doubleStack.length || (topOnLeft_red > topOnRight_blue)) {
			throw new IllegalStateException("Stack is full");
		}
		// add to the left doubleStack
		if (place == 0) {redPush(item);} 
		// add to the right doubleStack
		else {bluePush(item);}
	}
	@Override
	public void redPush(E e) {
		doubleStack[++topOnLeft_red] = e;
		System.out.println("(" + e +") has been pushed in red");
	}
	@Override
	public void bluePush(E e) {
		doubleStack[--topOnRight_blue] = e;
		System.out.println("(" + e +") has been pushed in blue");
	}
	//--------------------------------------------------------------------
	@Override
	public E redPop() {
		return doubleStack[topOnLeft_red--];
	}
	@Override
	public E bluePop() {
		return doubleStack[topOnRight_blue++];
	}
	public E pop(int place) {
		if (topOnLeft_red == 0 && place == 0) { // if choice is 0 then check emptiness of left stack

            throw new NoSuchElementException("Left stack is empty");
        } else if (topOnRight_blue == doubleStack.length - 1 && place == 1) { // if choice is 1 then check emptiness of right stack
            throw new NoSuchElementException("Right stack is empty");
        }
		if(isEmpty(place)) {
			throw new NoSuchElementException(" doubleStack is empty");
		}
		if (place == 0)   {return redPop();} 
		else 			  {return bluePop();}
	}
	//----------------------------------------------------------------------

	@Override
	public E peekRed() {
		return doubleStack[topOnLeft_red - 1];
	}
	@Override
	public E peekBlue() {
		return doubleStack[topOnRight_blue + 1];
	}
	public E peek(int place) throws NoSuchElementException{
		if (topOnLeft_red == 0 && place == 0) {
			throw new NoSuchElementException("Left doubleStack is empty");
		} else if (topOnRight_blue == doubleStack.length - 1 && place == 1) { 
			throw new NoSuchElementException("Right doubleStack is empty");
		}
		if (place == 0) {
			return peekRed();
		} else {
			return peekBlue();
		}
	}
	//----------------------------------------------------------------------
	public int size(int place) {
		if (place == 0) {return redSize();}
		else {return doubleStack.length - topOnRight_blue;}
	}
	@Override
	public int redSize() {return topOnLeft_red;}
	@Override
	public int blueSize() {return doubleStack.length - topOnRight_blue;}
	public int size() {
		return redSize() + blueSize();
	}
	//----------------------------------------------------------------------
	public boolean isEmpty(int place) {
		if (place == 0) {return topOnLeft_red == 0;}
		else {return topOnRight_blue == doubleStack.length - 1;}
	}
	//-----------------------------------------------------------------------
}