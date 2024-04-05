public class arvore {
    int size = 0; // quantidade de nos da arvore
    //no pai 
    // filho a esquerda
    // filho a direita
    // caminhamento em ordem
    // visita o direito depois o pai depois o esquerdo
}
// ARVORE BINÁRIA
// Filhos a esquerda são menores e filhos a direitas são maiores
// remoção: remove de qualquer lugar
// 3 casos podem ocorrer
// 1 - Remover um nó com nenhum filho
//    dizer ao pai daquele nó que ele não tem mais aquele filho
//    setendo o filho como null
// 2 - quando o nó tem 1 filho
//      Insere o filho do nó a ser removido como filho do pai do nó a ser removido
//      2 pai do 4 e 4 pai no 5, se quero remover o 4.
//      então o pai do 5 agora é o dois e o filho do dois agora é o 5.
// 3 - remover um nó com 2 filhos
//      remover a raiz. 
//      pega o nó sucessor (maior) e desse nó maior pega o nó menor possível
//      vai indo para os filhos a esquerda até encontrar um nó null, quando encontrar, o pai desse
//      nó null é o sucessor


// se (isExternal(v)){
//     return 0  

// }senao
h=0
para cara w em children(v)