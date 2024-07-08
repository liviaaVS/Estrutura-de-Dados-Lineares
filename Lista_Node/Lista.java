
public interface Lista {
    int size();
    boolean isEmpty();
    boolean isFirst(Node p); // verifica se o elemento é o primeiro
    boolean isLast(Node p); // verifica se o elemento é o último
    // Metodos para acessar
    Node first(); // retorna o primeiro elemento
    Node last(); // retorna o último elemento
    Node before(Node n); // retorna o elemento antes de n 
    Node after(Node n); // retorna o elemento depois de n
    Object replaceElement(Node n, Object o); // substitui o elemento na posição n pelo elemento o 
    void swapElements(Node n, Node q); // Troca os elementos nas posições n e q.
    Node insertBefore(Node n,Object o); // Insere o elemento o antes da posição n.
    Node insertAfter(Node n, Object o); //Insere o elemento "o" após a posição n.
    Node insertFirst(Object o); // Insere o elemento o no iníci da lista
    Node insertLast(Object o); //Insere o elemento o no fim da lista
    Object remove(Node p); // Remove o nó e o retorna
}