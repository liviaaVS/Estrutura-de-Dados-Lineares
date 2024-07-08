public interface Sequencia {
    int size();
    boolean isEmpty();
    Node atRank(int r); // recebe um rank e retorna um nó
    int rankOF(Node n); // Recebe um no e retorna um rank
}
