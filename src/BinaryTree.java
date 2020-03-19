public class BinaryTree<E> {
    protected E val;
    protected BinaryTree<E> padre;
    protected BinaryTree<E> left, right;

    public BinaryTree(){
        val=null;
        padre=null;
        left=this;
        right=this;
    }

    public BinaryTree(E value){
        val=value;
        right=new BinaryTree<E>();
        left=new BinaryTree<E>();
        setLeft(left);
        setRight(right);
    }
    public void setLeft(BinaryTree<E> newLeft){
        if (left != null && left.padre()==this){
            left.setPadre(null);
        }
        left=newLeft;
        left.setPadre(this);
    }

    public void setRight(BinaryTree<E> newRight){
        if (right != null && right.padre()==this){
            right.setPadre(null);
        }
        right=newRight;
        right.setPadre(this);
    }

    protected void setPadre(BinaryTree<E> newParent){
            padre=newParent;
    }

    public BinaryTree<E> left(){
        return left;
    }

    public BinaryTree<E> right(){
        return right;
    }

    public BinaryTree<E> padre(){
        return padre;
    }

    public E value(){
        return val;
    }

    public void setValue(E value){
        val=value;
    }

    public boolean isEmpty(){
        return this.left.value() == null && this.right.value() == null;
    }

}
