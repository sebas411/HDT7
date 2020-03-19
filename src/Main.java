import java.io.BufferedReader;
import java.io.FileReader;
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
        tree.left.setRight(new BinaryTree(arr[2]));
        tree.setRight(new BinaryTree(arr[3]));
        tree.right.setLeft(new BinaryTree(arr[4]));
        tree.right.setRight(new BinaryTree(arr[5]));

        BufferedReader buf=new BufferedReader(new FileReader("text.txt"));
        String textoDocumento=buf.readLine();
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
    }
}
