
public interface Lista {
    int size();
    boolean isEmpty();
    boolean isFirst(Object p); // verifica se o elemento é o primeiro
    boolean isLast(Object p); // verifica se o elemento é o último
    // Metodos para acessar
    Object first(); // retorna o primeiro elemento
    Object last(); // retorna o último elemento
    Object before(Object n); // retorna o elemento antes de n 
    Object after(Object n); // retorna o elemento depois de n
    Object replaceElement(Object n, Object o); // substitui o elemento na posição n pelo elemento o 
    void swapElements(Object n, Object q); // Troca os elementos nas posições n e q.
    Object insertBefore(Object n,Object o); // Insere o elemento o antes da posição n. retorna posição em que foi inserido
    Object insertAfter(Object n, Object o); //Insere o elemento "o" após a posição n. retorna posição em que foi inserido
    void insertFirst(Object o); // Insere o elemento o no início da lista
    void insertLast(Object o); //Insere o elemento o no fim da lista
    Object remove(Object p); // Remove o nó e o retorna
}