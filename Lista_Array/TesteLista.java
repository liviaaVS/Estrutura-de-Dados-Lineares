public class TesteLista {

public static void main(String[] args) {

    ListaArray lista = new ListaArray(4);

    // Testando métodos genéricos
    System.out.println("A lista está vazia? " + lista.isEmpty());
    lista.insertLast(1);
    lista.insertLast(2);
    lista.insertLast(3);
    lista.insertLast(4);

    System.out.println("Lista após inserções: " + lista);
    System.out.println("Tamanho da lista: " + lista.size());
    System.out.println("A lista está vazia? " + lista.isEmpty());
    


    // Testando métodos de fila
    System.out.println("O primeiro elemento é '1'? " + lista.isFirst(1));
    System.out.println("O último elemento é '1'? " + lista.isLast(1));
    System.out.println("O último elemento é '4'? " + lista.isLast(4));

    // Testando métodos para acessar
    System.out.println("Primeiro elemento: " + lista.first());
    System.out.println("Último elemento: " + lista.last());
    System.out.println("Elemento antes de 4: " + lista.before(2));
    System.out.println("Elemento após 1: " + lista.after(3));


    // Testando métodos para atualizar
    lista.replaceElement(2, 20);
    System.out.println("Lista após substituir 2 por 20: " + lista);
    lista.swapElements(4, 1);
    System.out.println("Lista após trocar 4 com 1: " + lista);
    lista.insertBefore(1, 80);
    System.out.println("Lista após inserir 80 antes de 1: " + lista);
    lista.insertAfter(4, 90);
    System.out.println("Lista após inserir 90 após 4: " + lista);
    lista.insertFirst(1000);
    System.out.println("Lista após inserir 1000 no início: " + lista);
    lista.insertLast(2000);
    System.out.println("Lista após inserir 2000 no final: " + lista);
    lista.remove(1000);

    System.out.println("Lista após remoção no início: " + lista);
    lista.remove(2000);
    System.out.println("Lista após remoção no final: " + lista);

    lista.remove(90);

    System.out.println("Lista após remoção no meio: " + lista);

}
}