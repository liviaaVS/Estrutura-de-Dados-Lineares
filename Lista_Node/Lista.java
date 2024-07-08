
public interface Lista {
    int size();
    boolean isEmpty();
    boolean isFirst(int p); // verifica se o elemento é o primeiro
    boolean isLast(int p); // verifica se o elemento é o último
    // Metodos para acessar
    int first(); // retorna o primeiro elemento
    int last(); // retorna o último elemento
    int before(int n); // retorna o elemento antes de n 
    int after(int n); // retorna o elemento depois de n
    Object replaceElement(int n, Object o); // substitui o elemento na posição n pelo elemento o 
    void swapElements(int n, int q); // Troca os elementos nas posições n e q.
    int insertBefore(int n,Object o); // Insere o elemento o antes da posição n.
    int insertAfter(int n, Object o); //Insere o elemento "o" após a posição n.
    int insertFirst(Object o); // Insere o elemento o no iníci da lista
    int insertLast(Object o); //Insere o elemento o no fim da lista
}