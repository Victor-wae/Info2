public class Tree {

    public Node root;

    public Tree(Node root){
        this.root = root;
    }

    @Override
    public boolean equals(Object o){
        if (o == null){return false;}
        if (this.getClass() != o.getClass()){return false;}
        Tree equals = (Tree) o;
        if (equals.root == null && this.root == null)return true;
        if (equals.root == null || this.root == null)return false;
        else if (this.root.val == equals.root.val){
            return this.root.left.equals(equals.root.left) &&this.root.right.equals(equals.root.right);
        }return false;
    }

}