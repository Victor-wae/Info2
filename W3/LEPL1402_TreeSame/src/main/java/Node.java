public class Node {

    public int val;
    public Node left;
    public Node right;

    public Node(int val){
        this.val = val;
    }

    public boolean isLeaf(){
        return this.left == null && this.right == null;
    }

    @Override
    public boolean equals(Object o){
        if (o.getClass() != this.getClass()){return false;} // si o n'est pas de la bonne classe --> return False
        Node NodeAcomp = (Node) o;  // On caste l'objet o dans la class Node

        if (NodeAcomp.isLeaf() && this.isLeaf()){ // Si this et o sont des feuilles
            return NodeAcomp.val == this.val;    // retourn True si les valeurs sont éguales
        }
        if(NodeAcomp.left == null && NodeAcomp.right == null){// Si Node à comparer a sa droite et sa gauche == null
            if (this.left == null && this.right == null){// si this == Node à comparer sur cette feuille --> retourne true
                return true;
            }else if (this.left == null || this.right == null){// si les deux ne sont pas feuille --> retourne false
                return false;
            }
        }
        else if(this.val == NodeAcomp.val ){ //Si valeurs ==
            return this.left.equals(NodeAcomp.left) && this.right.equals(NodeAcomp.right); //Fonction rec equ  branche gauche + branche droite
        }
        return false;
    }
}