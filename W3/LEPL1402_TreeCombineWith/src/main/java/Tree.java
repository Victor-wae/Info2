public class Tree {

    public Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Tree combineWith(Tree o) {
        if (o == null){
            return this;
        }
        Tree t3 = new Tree(combineNode(this.root, o.root));
        return t3;
    }

    public Node combineNode(Node n1, Node n2) {
        Node res = null;
        if (n1 == null && n2 == null){return null;}
        else if (n1 != null && n2 != null ) {res = new Node(n1.val + n2.val, combineNode(n1.left, n2.left), combineNode(n1.right, n2.right));}
        else if (n1 == null) res = n2;
        else if (n2 == null) res = n1;
        return res;
    }

}