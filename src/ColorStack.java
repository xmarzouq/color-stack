
public interface ColorStack<E> {
	int size(int i );
	boolean isEmpty( int i);
	E redPop( );
	E bluePop( );
	E peekRed();
	E peekBlue();
	void redPush(E e);
	void bluePush(E e);
	int redSize();
	int blueSize();
}
