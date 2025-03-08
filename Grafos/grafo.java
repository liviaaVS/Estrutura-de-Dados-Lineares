package Grafos;

import java.util.*;
 
class Grafo {
    private int[][] matrizAdjacencia; // Matriz de adjacência
    private int vertices; // Número de vértices no grafo

    // Construtor que inicializa o grafo com o número de vértices
    public Grafo(int vertices) {
        this.vertices = vertices;
        this.matrizAdjacencia = new int[vertices][vertices]; // Matriz de adjacência
    }

    // Adiciona uma aresta no grafo (grafo não direcionado)
    public void adicionarAresta(int vertice1, int vertice2) {
        if (vertice1 >= 0 && vertice1 < vertices && vertice2 >= 0 && vertice2 < vertices) {
            matrizAdjacencia[vertice1][vertice2] = 1; // Aresta de vertice1 para vertice2
            matrizAdjacencia[vertice2][vertice1] = 1; // Grafo não direcionado, então adiciona a aresta reversa
        }
    }

    // Verifica se existe uma aresta entre dois vértices
    public boolean existeAresta(int vertice1, int vertice2) {
        if (vertice1 >= 0 && vertice1 < vertices && vertice2 >= 0 && vertice2 < vertices) {
            return matrizAdjacencia[vertice1][vertice2] == 1;
        }
        return false;
    }

    // Exibe a matriz de adjacência
    public void exibirMatrizAdjacencia() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(matrizAdjacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Implementação da busca em largura (BFS)
    public void bfs(int verticeInicial) {
        // Cria uma fila para a BFS
        Queue<Integer> fila = new LinkedList<>();
        // Vetor para marcar os vértices visitados
        boolean[] visitado = new boolean[vertices];

        // Marca o vértice inicial como visitado e o adiciona à fila
        visitado[verticeInicial] = true;
        fila.add(verticeInicial);

        System.out.println("Busca em Largura (BFS) a partir do vértice " + verticeInicial + ":");

        // Enquanto a fila não estiver vazia
        while (!fila.isEmpty()) {
            // Retira o próximo vértice da fila
            int verticeAtual = fila.poll();
            System.out.print(verticeAtual + " "); // Imprime o vértice visitado

            // Para cada vértice adjacente ao vértice atual
            for (int i = 0; i < vertices; i++) {
                // Se a aresta existe e o vértice não foi visitado
                if (matrizAdjacencia[verticeAtual][i] == 1 && !visitado[i]) {
                    // Marca como visitado e adiciona à fila
                    visitado[i] = true;
                    fila.add(i);
                }
            }
        }
        System.out.println();
    }

    // Implementação da busca em profundidade (DFS)
    public void dfs(int verticeInicial) {
        // Vetor para marcar os vértices visitados
        boolean[] visitado = new boolean[vertices];

        System.out.println("Busca em Profundidade (DFS) a partir do vértice " + verticeInicial + ":");
        dfsRecursivo(verticeInicial, visitado);
        System.out.println();
    
    }

    // Função auxiliar para a busca em profundidade (DFS)
    private void dfsRecursivo(int verticeAtual, boolean[] visitado) {
        // Marca o vértice atual como visitado
        visitado[verticeAtual] = true;
        System.out.print(verticeAtual + " "); // Imprime o vértice visitado

        // Para cada vértice adjacente ao vértice atual
        for (int i = 0; i < vertices; i++) {
            // Se a aresta existe e o vértice não foi visitado
            if ( existeAresta(verticeAtual, i) && !visitado[i]) {
                // Chama a função recursivamente para o vértice adjacente
                dfsRecursivo(i, visitado);
            }
        }
    }
}
