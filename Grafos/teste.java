package Grafos;

public class teste {
    public static void main(String[] args) {
        // Cria um grafo com 5 vértices
        Grafo grafo = new Grafo(5);
        
        // Adiciona arestas
        grafo.adicionarAresta(0, 1, 10);
        grafo.adicionarAresta(0, 4, 100);
        grafo.adicionarAresta(0, 3, 30);
        grafo.adicionarAresta(1, 3, 50);
        grafo.adicionarAresta(2, 4, 10);
        grafo.adicionarAresta(3, 4, 60);
        grafo.adicionarAresta(3, 2, 20);
        
        // Exibe a matriz de adjacência
        grafo.exibirMatrizAdjacencia();
        System.out.println();
        // Exibe a matriz de custo
        grafo.exibirMatrizCusto();

        // Executa a busca em largura a partir do vértice 0
        grafo.bfs(4);
        int[] dist = grafo.dijstra(0);

        for(int i = 0; i < dist.length; i++) {
            System.out.println("Distância de 1 até " + (i+1) + ": " + dist[i]);
        }

        System.out.println(grafo.isDirecionado() + " " +  grafo.oposto(0, 5));
    }
}
