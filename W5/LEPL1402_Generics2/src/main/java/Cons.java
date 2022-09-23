import java.util.function.Predicate;
import java.util.function.Function;

public class Cons<E> {
    // The item inside this list node
    public E v;
    // The next element, null if there is none
    public Cons<E> next;

    // Returns a new Cons by applying Function function on all elements
    public <R> Cons<R> map(Function<E, R> function) {
        Cons<R> act = new Cons<>(function.apply(v), null);
        if (!(this.next == null)) act.next = next.map(function);
        return act;
    }

    // Returns a new Cons containing all elements that match Predicate predicate
    public Cons<E> filter(Predicate<E> predicate) {
        Cons<E> new_;
        if (this.next != null) {
            if (predicate.test(v)) {
                new_ = new Cons<>(v, next.filter(predicate));
            } else {
                new_ = next.filter(predicate);
            }
        } else {
            if (predicate.test(v)) {
                new_ = new Cons<>(v, null);
            } else {
                return null;
            }
        }
        return new_;
    }

    // Constructor
    public Cons(E v, Cons<E> next) {
        this.v = v;
        this.next = next;
    }
}
