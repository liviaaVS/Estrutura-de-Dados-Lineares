public interface Vetor {
    int size();
    boolean isEmpty();
    Node elemAtRank(int r) throws PosicaoInvalida, SequenciaVaziaExcecao; // Retorna o elemento na colocação R sem removê-lo.
    Object replaceAtRank(int r, Object o ) throws PosicaoInvalida, SequenciaVaziaExcecao; // Substitui o elemento na posição r pelo objeto o e retorna o antigo elemento.
    Object removeAtRank(int r) throws PosicaoInvalida, SequenciaVaziaExcecao; // Remove e retorna o elemento na posição r
    void insertAtRank(int r, Object o ) throws PosicaoInvalida; // Insere um objeto o na colocação r.


    // Duvidas:
    // Precisa colocar esse throws novamente lá na classe de Override da classe VetorArray?
}
