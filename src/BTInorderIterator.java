import java.util.Stack;

public class BTInorderIterator<E> {
    protected BinaryTree<E> root;
    protected Stack<BinaryTree<E>> todo;

    public BTInorderIterator(BinaryTree<E> root){
        todo= new Stack<BinaryTree<E>>();
        this.root=root;
        reset();
    }

    public boolean hasNext(){
        return !todo.isEmpty();
    }

    public void reset(){
        todo.clear();
        BinaryTree<E> current=root;
        while (!current.isEmpty()){
            todo.push(current);
            current=current.left();
        }
    }

    public E get(){
        return todo.get(todo.size()-1).value();
    }

    public E next(){
        BinaryTree<E> old=todo.pop();
        E result=old.value();
        if (!old.right().isEmpty()){
            BinaryTree<E> current=old.right();
            do{
                todo.push(current);
                current=current.left();
            }while (!current.isEmpty());
        }
        return result;
    }
}
