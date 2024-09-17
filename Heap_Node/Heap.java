package Heap_Node;

import java.util.ArrayList;

public interface Heap {    
    public int size();    
    public boolean isEmpty();
    public int height() throws HeapVaziaExcecao; // retorna a altura da arvore -> altura do nó mais externo
    public ArrayList<Object> elements() throws HeapVaziaExcecao;
    public ArrayList<Node> nos() throws HeapVaziaExcecao;
    public Node root() throws HeapVaziaExcecao; // retorna o nó raiz
    public Node parent(Node no) throws HeapVaziaExcecao; // retorna o nó pai de um nó
    public ArrayList<Node> children(Node no) throws HeapVaziaExcecao; // retorna um iterador para os nós filhos de um nó
    public boolean isExternal(Node no) throws HeapVaziaExcecao;
    public boolean isInternal(Node no) throws HeapVaziaExcecao;
    public boolean isRoot(Node no) throws HeapVaziaExcecao;
    public int depth(Node no) throws HeapVaziaExcecao; // retorna a profundidade de um nó -> profundidade é quantos nós até chegar a raiz
    public Object replace(Node no, Object o) throws HeapVaziaExcecao; // Altera o objeto armazenado em um Nó e retorna o valor que foi removido
    public Node insert(int k, Object o);
    public Node removeMin();
    public Object downHeap(Node no);
    public Node upHeap(Node no); // o fator determina se a chave nos pais é <= a dos filhos ou >= a dos filhos
}
