package Heap_Node;

import java.util.ArrayList;
import java.util.Random;

public class HeapTest {
    public static void main(String[] args) {
        HeapNode heap = new HeapNode();
        
        // Inserções na heap
        heap.insert(5, "algo");
        heap.insert(2, "algo");
        heap.insert(1, "algo");
        heap.insert(8, "algo");
        heap.insert(9, "algo");
        heap.insert(9, "algo");

        // Exibe a árvore após as inserções iniciais
        System.out.println("Heap após inserções iniciais:");
        heap.printTree(heap.root(), "", false);
        
        // Percurso em ordem
        System.out.println("\nPercurso em ordem:");
        heap.Emordem(heap.root());

        // Teste de remoção do menor elemento
        System.out.println("\nRemovendo o menor elemento:");
        heap.removeMin();
        heap.printTree(heap.root(), "", false);

        // Remover outro elemento
        System.out.println("\nRemovendo outro menor elemento:");
        heap.removeMin();
        heap.printTree(heap.root(), "", false);

        // Inserção de novos elementos
        System.out.println("\nInserindo novos elementos (8, 11):");
        heap.insert(8, "algo");
        heap.insert(11, "algo");
        heap.printTree(heap.root(), "", false);

        // Verificando o tamanho da heap
        System.out.println("\nTamanho da heap: " + heap.size());

        // Verificando se a heap está vazia
        System.out.println("Heap está vazia? " + heap.isEmpty());

        // Verificando a altura da heap
        try {
            System.out.println("Altura da heap: " + heap.height());
        } catch (HeapVaziaExcecao e) {
            System.out.println("Erro ao calcular a altura: " + e.getMessage());
        }

        // Verificar elementos na heap
        try {
            ArrayList<Object> elements = heap.elements();
            System.out.println("Elementos na heap: " + elements);
        } catch (HeapVaziaExcecao e) {
            System.out.println("Erro ao obter elementos: " + e.getMessage());
        }
         // Verificar nos na heap
         try {
            ArrayList<Node> nos = heap.nos();
            System.out.println("Nos na heap: " + nos);
        } catch (HeapVaziaExcecao e) {
            System.out.println("Erro ao obter nos: " + e.getMessage());
        }
        // Verificar profundidade de um nó
       
        try {
            ArrayList<Node> nos = heap.nos();
            Node no = nos.get(new Random().nextInt(nos.size()));
            System.out.println("Profundidade do nó de chave " + no.getKey() + ": " + heap.depth(no));
        } catch (HeapVaziaExcecao e) {
            System.out.println("Erro ao obter a profundidade do nó: " + e.getMessage());
        }



        // Verificar se o nó raiz é o esperado
        try {
            Node root = heap.root();
            System.out.println("Nó raiz: chave = " + root.getKey() + ", valor = " + root.getElement());
        } catch (HeapVaziaExcecao e) {
            System.out.println("Erro ao obter o nó raiz: " + e.getMessage());
        }

        // Teste de percurso final em ordem
        System.out.println("\nPercurso final em ordem:");
        heap.Emordem(heap.root());
    }
}
