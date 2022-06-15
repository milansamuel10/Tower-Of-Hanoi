public interface StackInterface<E>
{
    void push(E o);
    E peek();
    E pop();
    boolean empty();
    boolean contains(E o);
    int size();
    E get(int x);
}