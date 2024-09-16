package Heap_Node;
public interface Heap {    
    public int size();    
    public boolean isEmpty();
    public int height() throws HeapVaziaExcecao; // retorna a altura da arvore -> altura do nó mais externo
    public Array<Object> elements() throws HeapVaziaExcecao;
    public Array<Node> nos() throws HeapVaziaExcecao;
    public Node root() throws HeapVaziaExcecao; // retorna o nó raiz
    public Node parent(Node no) throws HeapVaziaExcecao; // retorna o nó pai de um nó
    public Array<Node> children(Node no) throws HeapVaziaExcecao; // retorna um iterador para os nós filhos de um nó
    public boolean isExternal(Node no) throws HeapVaziaExcecao;
    public boolean isInternal(Node no) throws HeapVaziaExcecao;
    public boolean isRoot(Node no) throws HeapVaziaExcecao;
    public int depth(Node no) throws HeapVaziaExcecao; // retorna a profundidade de um nó -> profundidade é quantos nós até chegar a raiz
    public int replace(Node no, Object o) throws HeapVaziaExcecao; // Altera o objeto armazenado em um Nó e retorna o valor que foi removido
    public Object upHeap(Node no);
    public Object downHeap(Node no);
    public void heapOrder(int fator); // o fator determina se a chave nos pais é <= a dos filhos ou >= a dos filhos
}
