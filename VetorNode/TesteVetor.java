package VetorNode;

public class TesteVetor {
    public static void main(String[] args) {
   
        VetorNode vetor = new VetorNode();

        System.out.println("Arquivo de teste para a implementacao: TAD vetor\n");
        
        // Testar excecoes
        testExceptions(vetor);

        // Testar insercao de elementos
        testInsertion(vetor);

        // Testar substituicao de elementos
        testReplacement(vetor);

        // Testar remocao de elementos
        testRemoval(vetor);

        

    }
    
    private static void testExceptions(VetorNode vetor) {
        System.out.println("\nTeste de excecoes:");
       
        // Testar excecao ao tentar exibir indices invalidos
        try {
            System.out.println(vetor.elemAtRank(4));
        } catch (IndiceInvalido e) {
            System.out.println("Erro ao exibir - indice invalido: Indice maior que o tamanho do vetor");
        }

        try {
            System.out.println(vetor.elemAtRank(-9));
        } catch (IndiceInvalido e) {
            System.out.println("Erro ao exibir - indice invalido: Indice menor que 0");
        }

        // Testar excecao ao tentar inserir em indices invalidos
        try {
            vetor.insertAtRank(9, 9);
        } catch (IndiceInvalido e) {
            System.out.println("Erro durante a insercao: Indice invalido, maior que o tamanho do vetor");
        }

        try {
            vetor.insertAtRank(-1, 9);
        } catch (IndiceInvalido e) {
            System.out.println("Erro durante a insercao: Indice invalido, menor que 0");
        }
        // TESTES COM VETOR VAZIO. 

        // nao vou testar o elemAtRank pois as funcoes de removeAtRank e replace ja utilizam ele 
        // para lancar excecao.

        // Testar excecao ao tentar remover com o vetor vazio
        try {
            vetor.removeAtRank(0);
        } catch (VetorVazioExcecao e) {
            System.out.println("Erro durante a remocao: Tentativa de remover com vetor vazio");
        }

        // Testar excecao ao tentar substituir elementos com o vetor vazio
        try {
            vetor.replaceAtRank(0, 5);
        } catch (VetorVazioExcecao e) {
            System.out.println("Erro durante a substituicao: Tentativa de substituir elementos com vetor vazio");
        }

    }


    private static void testInsertion(VetorNode vetor) {
        System.out.println("Teste de insercao:");
        try {
    
            vetor.insertAtRank(0, 10);
            vetor.insertAtRank(1, 20);
            vetor.insertAtRank(2, 30);
            vetor.insertAtRank(2, 5);
            vetor.insertAtRank(2, 2);
            vetor.insertAtRank(0, 80);
            vetor.inicio();

            System.out.println("Vetor: " + vetor.toString());
        } catch (IndiceInvalido e) {
            System.out.println("Erro durante a insercao: Indice invalido");
        }
    }

    private static void testReplacement(VetorNode vetor) {
        System.out.println("\nTeste de substituicao:");
        try {
            System.out.println("Elemento: " + vetor.replaceAtRank(1, 25) + " foi substituido");
            System.out.println("Elemento: " + vetor.replaceAtRank(0, 25) + " foi substituido");
            System.out.println("Vetor apos a substituicao: " + vetor.toString());
        } catch (IndiceInvalido e) {
            System.out.println("Erro durante a substituicao: Indice invalido");
        }
    }

    private static void testRemoval(VetorNode vetor) {
        System.out.println("\nTeste de remocao:");
        try {
            System.out.println("Elemento: " + vetor.removeAtRank(2) + " foi removido do meio");
            System.out.println("Vetor apos a remocao do meio: " + vetor.toString());
            System.out.println("Elemento: " + vetor.removeAtRank(vetor.size() - 1) + " foi removido do final");
            System.out.println("Vetor apos a remocao do final: " + vetor.toString());
            System.out.println("Elemento: " + vetor.removeAtRank(0) + " foi removido do inicio");
            System.out.println("Vetor apos a remocao do inicio: " + vetor.toString());
            System.out.println("Elemento: " + vetor.removeAtRank(0) + " foi removido do inicio");
            System.out.println("Vetor apos a remocao do inicio: " + vetor.toString());
            System.out.println("Elemento: " + vetor.removeAtRank(0) + " foi removido do inicio");
            System.out.println("Vetor apos a remocao do inicio: " + vetor.toString());
        } catch (IndiceInvalido e) {
            System.out.println("Erro durante a remocao: Indice invalido");
        }
    }
}
