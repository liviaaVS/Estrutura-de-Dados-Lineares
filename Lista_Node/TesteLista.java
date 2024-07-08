

public class TesteLista {

public static void main(String[] args) {
    ListaNode lista = new ListaNode();

    // Testando métodos genéricos
    System.out.println("A lista está vazia? " + lista.isEmpty());
    lista.insertLast(1);
    lista.insertLast(2);
    lista.insertLast(3);
    lista.insertLast(4);

    System.out.println("Lista após inserções: " + lista);
    System.out.println("Tamanho da lista: " + lista.size());
    System.out.println("A lista está vazia? " + lista.isEmpty());
    
    Node x = lista.first();
    Node y = lista.last();


    // Testando métodos de fila
    System.out.println("O primeiro elemento é '1'? " + lista.isFirst(x));
    System.out.println("O último elemento é '1'? " + lista.isLast(x));
    System.out.println("O último elemento é '3'? " + lista.isLast(y));

    // Testando métodos para acessar
    System.out.println("Posição do primeiro elemento: " + lista.first());
    System.out.println("Último elemento: " + lista.last());
    System.out.println("Elemento antes de 4: " + lista.before(y).getValue());
    System.out.println("Elemento após 1: " + lista.after(x).getValue());
    x = lista.after(x);


    // Testando métodos para atualizar
    lista.replaceElement(x, 20);
    System.out.println("Lista após substituir 2 por 20: " + lista);
    y = lista.first();
    x= lista.last();
    lista.swapElements(y, x);
    System.out.println("Lista após trocar 4 com 1: " + lista);
    lista.insertBefore(x, 80);
    System.out.println("Lista após inserir 80 antes de 1: " + lista);
    lista.insertAfter(y, 90);
    System.out.println("Lista após inserir 90 após 4: " + lista);
    lista.insertFirst(1000);
    System.out.println("Lista após inserir 1000 no início: " + lista);
    lista.insertLast(2000);
    System.out.println("Lista após inserir 2000 no final: " + lista);
    y = lista.first();
    lista.remove(y);

    System.out.println("Lista após remoção no início: " + lista);
    x= lista.last();
    lista.remove(x);
    System.out.println("Lista após remoção no final: " + lista);

    y = lista.first();
    x = lista.after(lista.after(y));
    lista.remove(x);

    System.out.println("Lista após remoção no meio: " + lista);





}
}