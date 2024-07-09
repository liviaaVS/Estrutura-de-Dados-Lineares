package Lista_Array;

public interface Lista {
    int size();
    boolean isEmpty();
    boolean isFirst(int p); // verifica se o elemento é o primeiro
    boolean isLast(int p); // verifica se o elemento é o último
    // Metodos para acessar
    Object first(); // retorna o primeiro elemento
    Object last(); // retorna o último elemento
    Object before(int n); // retorna o elemento antes de n 
    Object after(int n); // retorna o elemento depois de n
    Object replaceElement(int n, Object o); // substitui o elemento na posição n pelo elemento o 
    void swapElements(int n, int q); // Troca os elementos nas posições n e q.
    int insertBefore(int n,Object o); // Insere o elemento o antes da posição n. retorna posição em que foi inserido
    int insertAfter(int n, Object o); //Insere o elemento "o" após a posição n. retorna posição em que foi inserido
    void insertFirst(Object o); // Insere o elemento o no início da lista
    void insertLast(Object o); //Insere o elemento o no fim da lista
    Object remove(int p); // Remove o nó e o retorna
}