
public interface Lista {
    int size();
    boolean isEmpty();
    boolean isFirst(); // verifica se o elemento é o primeiro
    boolean isLast(); // verifica se o elemento é o último
    // Metodos para acessar
    Object first(); // retorna o primeiro elemento
    Object last(); // retorna o último elemento
    void replaceElement(int n, Object o); // substitui o elemento na posição n pelo elemento o 
    void swapElements(int n, int q); // Troca os elementos nas posições n e q.
    void insertBefore(int n,Object o); // Insere o elemento o antes da posição n.
    void insertAfter(int n, Object o); //Insere o elemento "o" após a posição n.
    void insertFirst(int n, Object o); // Insere o elemento o no iníci da lista
    void insertLast(int n, Object o); //Insere o elemento o no fim da lista
}