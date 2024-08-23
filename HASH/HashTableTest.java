public class HashTableTest {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);

        hashTable.inserir("Eu");
        hashTable.inserir("Eu2");
        hashTable.inserir("Eu3");
        hashTable.inserir("Eu4");
        hashTable.inserir("Eu5");
        hashTable.inserir("Eu");

        hashTable.printlista();
        
        hashTable.removerobj("Eu");
        
        hashTable.printlista();

         
        System.out.println(hashTable.removerchave(1));
        
        hashTable.printlista();


        System.out.println("Todos os testes passaram!");
    }
}
