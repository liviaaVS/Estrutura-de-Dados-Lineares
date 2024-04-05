public interface Vetor {
    int size();
    boolean isEmpty();
    Object elemAtRank(int r) throws IndiceInvalido, VetorVazioExcecao; // Retorna o elemento na colocação R sem removê-lo.
    Object replaceAtRank(int r, Object o ) throws IndiceInvalido, VetorVazioExcecao; // Substitui o elemento na posição r pelo objeto o e retorna o antigo elemento.
    Object removeAtRank(int r) throws IndiceInvalido, VetorVazioExcecao; // Remove e retorna o elemento na posição r
    void insertAtRank(int r, Object o ) throws IndiceInvalido; // Insere um objeto o na colocação r.


    // Duvidas:
    // Precisa colocar esse throws novamente lá na classe de Override da classe VetorArray?
}
