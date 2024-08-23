public class HashTableTest {

    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>(10);

        // Testando inserção
        hashTable.put("Alice", 25);
        hashTable.put("Bob", 30);
        hashTable.put("Charlie", 35);

        // Testando recuperação
        assert hashTable.get("Alice") == 25 : "Falha ao recuperar Alice";
        assert hashTable.get("Bob") == 30 : "Falha ao recuperar Bob";
        assert hashTable.get("Charlie") == 35 : "Falha ao recuperar Charlie";
        assert hashTable.get("NonExistent") == null : "Deveria retornar null para chave não existente";

        // Testando remoção
        hashTable.remove("Bob");
        assert hashTable.get("Bob") == null : "Falha ao remover Bob";

        // Testando o tamanho
        assert hashTable.size() == 2 : "O tamanho da tabela hash deve ser 2 após a remoção de Bob";

        System.out.println("Todos os testes passaram!");
    }
}
