package AVL;

import java.util.ArrayList;

public class Main {
    
    
    public static void main(String[] args) {
        AVL.avl arvore = new AVL.avl();
        Node no = new Node();
        arvore.insertAVL(no, 10);
        arvore.insertAVL(no, 20);
        arvore.insertAVL(no, 30);
        arvore.insertAVL(no, 40);
        arvore.insertAVL(no, 50);
        arvore.insertAVL(no, 60);
        arvore.insertAVL(no, 70);
        arvore.insertAVL(no, 80);
        arvore.insertAVL(no, 75);

        arvore.insertAVL(no, 8);
        arvore.insertAVL(no, 9);



        
        ArrayList<Node> nodes = new ArrayList<>();
        arvore.Emordem(arvore.raiz, nodes);
        // arvore.mostrarArvoreDev(nodes, arvore);
        arvore.printTree(arvore.raiz, " ", false);
        nodes.clear();
        arvore.Emordem(arvore.raiz, nodes);
        Node removido = arvore.removeNo(arvore.raiz, 40);
        // Node removido2 = arvore.removeNo(arvore.raiz, 20);

        System.out.println("Removido: " + removido.getValue());
        // System.out.println("Removido: " + removido2.getValue());
        nodes.clear();
        arvore.Emordem(arvore.raiz, nodes);
        arvore.printTree(arvore.raiz, " ", false);
    }
}
