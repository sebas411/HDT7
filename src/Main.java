import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Association<String,String>[] arr = new Association[6];
        arr[0]=new Association<>("house","casa");
        arr[1]=new Association<>("dog","perro");
        arr[2]=new Association<>("homework","tarea");
        arr[3]=new Association<>("woman","mujer");
        arr[4]=new Association<>("town","pueblo");
        arr[5]=new Association<>("yes","si");

        BinaryTree<Association> tree= new BinaryTree(arr[0]);
        tree.setLeft(new BinaryTree(arr[1]));
        tree.left().setRight(new BinaryTree(arr[2]));
        tree.setRight(new BinaryTree(arr[3]));
        tree.right().setLeft(new BinaryTree(arr[4]));
        tree.right().setRight(new BinaryTree(arr[5]));



        String textoDocumento="The woman asked me to do my homework about my town.";
        String[] sentence=textoDocumento.split(" ");

        System.out.println("Recorrer arbol inorder");

        for(int i=0;i<sentence.length;i++){
            String word=sentence[i];
            word=word.toLowerCase();
            if(word.contains(".")) {
                StringBuilder builder = new StringBuilder(word);
                builder.deleteCharAt(builder.length() - 1);
            }
        }
        BTInorderIterator<Association> iter=new BTInorderIterator<>(tree);
        while(iter.hasNext()){
            System.out.println(iter.get().getKey());
            iter.next();
        }

        String traduccion="";
        for(int i=0;i<sentence.length;i++){
            String word=sentence[i];
            word=word.toLowerCase();
            BTInorderIterator<Association> iter2=new BTInorderIterator<>(tree);
            boolean encontrado=false;
            while (iter2.hasNext()){
                if(iter2.get().getKey().toString()==word){
                    word=iter2.get().getValue().toString();

                    encontrado=true;
                }
                iter2.next();
            }
            traduccion=traduccion+" "+word;
        }
        System.out.println(traduccion);
    }
}
