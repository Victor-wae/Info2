import org.junit.Test;

public class Cons {
    // The item inside this list node
    public int v;
    // The next element, null if there is none
    public Cons next;

    // Returns a new Cons by applying function f on all elements
    public Cons map(F f) {
        Cons inst = new Cons(f.apply(this.v),null);
        if (!(this.next == null))inst.next = this.next.map(f);
        return inst;
    }
    // Returns a new Cons containing all elements that match predicate p
    public Cons filter(P p) {
        // TODO by student
        if (p.filter(this.v)) {
            if (this.next == null)return new Cons(v,null);
            return new Cons(v,this.next.filter(p));
        }
        if (this.next == null)return null;
        return this.next.filter(p);

    }

    // Constructor
    public Cons(int v, Cons next) {
        this.v = v;
        this.next = next;
    }
}