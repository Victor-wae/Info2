import java.util.function.Function;

public abstract class FTree<A> {

    public final int depth() {
        if (left() == null && right() == null)return 0;
        else if (left().depth() >= right().depth()) return left().depth()+1;
        else return right().depth()+1;

    }

    public abstract A value();
    public abstract FTree<A> left();
    public abstract FTree<A> right();

    public final <B> FTree<B> map(Function<A,B> f) {
        if (this instanceof Node)return new Node<>(f.apply(this.value()),this.right().map(f),this.left().map(f));
        else if (this instanceof Leaf){
            return new Leaf<>(f.apply(this.value()));
        }
        return null;

    }

}
