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
        arvore.insertAVL(no, 8);
        arvore.insertAVL(no, 9);



        
        ArrayList<Node> nodes = new ArrayList<>();
        arvore.Emordem(arvore.raiz, nodes);
        arvore.mostrarArvore(nodes, arvore);
        // arvore.printTree(arvore.raiz, " ", false);
    }
}
