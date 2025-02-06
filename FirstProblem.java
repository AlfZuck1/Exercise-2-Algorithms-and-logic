import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // Leemos la entrada F que determina el numero de frutos
        int F = Integer.parseInt(st.nextToken());
        // Leemos la siguiente línea de entrada que dice los frutos
        st = new StringTokenizer(br.readLine());
        // Asignamos el primer fruto a la raiz
        int rootWeight = Integer.parseInt(st.nextToken());
        Node root = null;
        root = Cedar.insertNode(root, rootWeight);
        
        // Recorremos todos los frutos, menos el de la raiz que ya fue asignado
        while (F-- > 1) {
            int weight = Integer.parseInt(st.nextToken());
            Cedar.insertNode(root, weight);
        }

        List<Integer> leaves = new ArrayList<>();
        Cedar.findLeaves(root, leaves);

        // Ordenamos las hojas del cedro
        leaves.sort(Integer::compareTo);

        // Imprimimos los valores requeridos
        System.out.println(leaves.size());
        leaves.forEach(leave -> System.out.println(leave + " "));
    }
}

// Clase que representa los nodos del arból
class Node{
    int weight;
    Node left, right;
    public Node(int weight){
        this.weight = weight;
        this.left = this.right = null;
    }
}

// Clase que utiliza los métodos del cedro
class Cedar{
    // Método para insertar un nuevo nodo
    public static Node insertNode(Node root, int weight){
        // Si es el primer fruto, se asigna
        if(root == null){
            return new Node(weight);
        }

        // Se compara el peso con el numero para agignarlo a la izquierda o derecha
        if(weight < root.weight){
            root.left = insertNode(root.left, weight);
        }
        else{
            root.right = insertNode(root.right, weight);
        }

        return root;
    }

    // Método para encontrar las hojas del cedro
    public static void findLeaves(Node root, List<Integer> leaves){
        if(root == null) return;

        if(root.left == null && root.right == null){
            leaves.add(root.weight);
        }
        else{
            findLeaves(root.left, leaves);
            findLeaves(root.right, leaves);
        }
    }
}