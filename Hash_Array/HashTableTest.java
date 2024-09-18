package Hash_Array;


public class HashTableTest {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);

        hashTable.inserir(1);
        hashTable.inserir(1);
        hashTable.printlista();
        System.out.println("Todos os testes passaram!");
    }
}
