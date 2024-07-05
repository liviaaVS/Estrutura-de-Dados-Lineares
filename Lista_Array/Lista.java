public package Lista_Array;

public interface Lista {
    int size();
    boolean isEmpty();
    boolean isFirst(); // verifica se o elemento é o primeiro
    boolean isLast(); // verifica se o elemento é o último
    // Metodos para acessar
    Object first(); // retorna o primeiro elemento
    Object last(); // retorna o último elemento
    
}