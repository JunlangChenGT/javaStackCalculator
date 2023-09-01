package h08;

/* An interface to a stack
 * @author	Biagioni, Edoardo
 * @date	February 16, 2011
 * @lecture	February 17, 2011, or later
 */

import java.util.EmptyStackException;

public interface StackInterface<E> {
    /* @param	value to push onto the stack */
    /* @return	that very same value */
    E push(E value);
    /* @return	and remove the top value on the stack */
    E pop() throws java.util.EmptyStackException;
    /* @return	the top value on the stack */
    E peek() throws java.util.EmptyStackException;
    /* @return	whether the stack is empty */
    boolean empty();
}
