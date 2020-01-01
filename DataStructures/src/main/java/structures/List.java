package structures;

public interface List<E> extends Iterable<E> {

    void addFirst(E data);

    void addLast(E data);

    E removeFirst();

    E removeLast();

    E remove(E data);

    E peekFirst();

    E peekLast();

    boolean contains(E data);

    int size();

}
