

public class TesteLista {
    


public static void main(String[] args) {
    ListaNode lista = new ListaNode();

    // Testando métodos genéricos
    System.out.println("A lista está vazia? " + lista.isEmpty());
    lista.insertLast("A");
    lista.insertLast("B");
    lista.insertLast("C");
    System.out.println("Lista após inserções: " + lista);
    System.out.println("Tamanho da lista: " + lista.size());
    System.out.println("A lista está vazia? " + lista.isEmpty());

    // Testando métodos de fila
    System.out.println("O primeiro elemento é 'A'? " + lista.isFirst(0));
    System.out.println("O último elemento é 'C'? " + lista.isLast(2));

    // Testando métodos para acessar
    System.out.println("Primeiro elemento: " + lista.first());
    System.out.println("Último elemento: " + lista.last());
    System.out.println("Elemento antes de B: " + lista.before(1));
    System.out.println("Elemento após A: " + lista.after(0));

    // Testando métodos para atualizar
    lista.replaceElement(1, "D");
    System.out.println("Lista após substituir B por D: " + lista);
    lista.swapElements(0, 2);
    System.out.println("Lista após trocar A com C: " + lista);
    lista.insertBefore(1, "E");
    System.out.println("Lista após inserir E antes de D: " + lista);
    lista.insertAfter(1, "F");
    System.out.println("Lista após inserir F após E: " + lista);
    lista.insertFirst("G");
    System.out.println("Lista após inserir G no início: " + lista);
    lista.insertLast("H");
    System.out.println("Lista após inserir H no final: " + lista);
}
}