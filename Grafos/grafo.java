package Grafos;

import java.util.*;

class Grafo {
    private int[][] matrizAdjacencia; // Matriz de adjacência
    private int vertices; // Número de vértices no grafo
    private List<int[]> ListaArestas; // Lista de arestas, usando List<int[]> para armazenar os pares de vértices
    private int[][] matrizdeCusto ; // Matriz de custo
    // Construtor que inicializa o grafo com o número de vértices
    public Grafo(int vertices) {
        this.vertices = vertices;
        this.matrizAdjacencia = new int[vertices][vertices]; // Matriz de adjacência
        this.matrizdeCusto = new int[vertices][vertices] ; // Matriz de custo
        this.ListaArestas = new ArrayList<>(); // Inicializa a lista de arestas
    }

    // Retorna os vértices de uma aresta
    public int[] finalVertices(int aresta){
        int[] arestas = ListaArestas.get(aresta);
        return new int[] {arestas[0], arestas[1]};
    }

    // Verifica se o grafo é conexo
    public boolean isConexo() {
        boolean[] visitado = new boolean[vertices];
        dfsRecursivo(0, visitado);
        for (int i = 0; i < vertices; i++) {
            if (!visitado[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean IsValid(int vertice) {
        return vertice >= 0 && vertice < vertices;
    }

    // Adiciona uma aresta no grafo (grafo não direcionado)
    public void adicionarAresta(int vertice1, int vertice2, int peso) {
        if (IsValid(vertice1) && IsValid(vertice2)) {
            matrizAdjacencia[vertice1][vertice2] = 1; // Aresta de vertice1 para vertice2
            // matrizAdjacencia[vertice2][vertice1] = 1; // Aresta de vertice2 para vertice1 se o grafo for não direcionado
            matrizdeCusto[vertice1][vertice2] = peso; // Adiciona o peso da aresta
        }
        // Atualiza lista de arestas

        ListaArestas.add(new int[] { vertice1, vertice2, peso });
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

    // Exibir matriz de custo 
    public void exibirMatrizCusto() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(matrizdeCusto[i][j] + " ");
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
            if (existeAresta(verticeAtual, i) && !visitado[i]) {
                // Chama a função recursivamente para o vértice adjacente
                dfsRecursivo(i, visitado);
            }
        }
    }

    // Retorna o grau de um vértice
    public int grau(int vertice) {
        int grau = 0;
        for (int i = 0; i < vertices; i++) {
            if (matrizAdjacencia[vertice][i] == 1) {
                grau++;
            }
        }
        return grau;
    }

    // Retorna o grau de entrada de um vértice
    public int grauEntrada(int vertice) {
        int grau = 0;
        for (int i = 0; i < vertices; i++) {
            if (matrizAdjacencia[i][vertice] == 1) {
                grau++;
            }
        }
        return grau;
        
        // Atualiza menor caminho de um vertice inicial para todos os outros recursivamente
    }

    public int minDistancia (int[] dist, boolean[] visitado) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < vertices; i++) {
            if (!visitado[i] && dist[i] <= min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    // função que aplica o algoritmo de Dijkstra em uma lista de aresta de 3 posições, vertice1, vertice2 e peso

    public int[] dijstra(int verticeInicial) {
        int[] dist = new int[vertices]; // define uma lista de distancias
        boolean[] visitado = new boolean[vertices]; // define uma lista de visitados
        for (int i = 0; i < vertices; i++) { // inicializa e lista de distancias com valores infinitos
            dist[i] = Integer.MAX_VALUE;
        }


        dist[verticeInicial] = 0; // define a distancia do vertice inicial como 0
        for (int i = 0; i < vertices; i++) { // para cada vertice no grafo 
            int u = minDistancia(dist, visitado); // pega o vertice com a menor distancia
            visitado[u] = true; // marca o vertice como visitado
            for (int j = 0; j < vertices; j++) { // para cada vertice adjacente ao vertice u
                // verifica se o vertice não foi visitado, se a aresta existe, se a distancia do vertice u é diferente de infinito
                // e se a distancia do vertice u mais o custo da aresta é menor que a distancia do vertice j
                if (!visitado[j] && matrizAdjacencia[u][j] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + matrizdeCusto[u][j] < dist[j]) {
                    dist[j] = dist[u] + matrizdeCusto[u][j];
                }
            }
        }
        return dist;
    }
    // Determina se o grafo é direcionado
    public boolean isDirecionado() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (matrizAdjacencia[i][j] != matrizAdjacencia[j][i]) {
                    return true;
                }
            }
        }
        return false;
    }
}
