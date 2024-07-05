public package Lista_Array;

public interface Lista {
    int size();
    boolean isEmpty();
    boolean isFirst(); // verifica se o elemento é o primeiro
    boolean isLast(); // verifica se o elemento é o último
    // Metodos para acessar
    Object first(); // retorna o primeiro elemento
    Object last(); // retorna o último elemento
    replaceElement(int n, Object o); // substitui o elemento na posição n pelo elemento o 
    swapElements(int n, int q); // Troca os elementos nas posições n e q.
    insertBefore(int n,Object o); // Insere o elemento o antes da posição n.
    insertAfter(int n, o); //Insere o elemento "o" após a posição n.
    insertFirst(int n, o); //Insere o elemento "o" antes a posição n.
}