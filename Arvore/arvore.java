import java.util.Array;

public class Arvore {

    private static class Array<T> {

        public Array() {
        }
    }
    
    public class Node {
        public Object value =  (Integer) null;
        public Node filhoD = null;
        public Node filhoE =  null;
        public Node pai =  null;
        public Node(Object value) {
            this.value = value;
        }
        public Object getValue() {
            return value;
        }
        public void setValue(Object value) {
            this.value = value;
        }
        public Node getFilhoD() {
            return filhoD;
        }
        public void setFilhoD(Node filhoD) {
            this.filhoD = filhoD;
        }
        public Node getFilhoE() {
            return filhoE;
        }
        public void setFilhoE(Node filhoE) {
            this.filhoE = filhoE;
        }
        public Node getPai() {
            return pai;
        }
        public void setPai(Node pai) {
            this.pai = pai;
        }
        
    }
    
    int size = 0; 
    Node raiz = null; 

    public int size(){
        return this.size;
    }

    public int height(Node no) {
        if (no == null) {
            return -1; 
        }
    
        int altura_direita = height(no.filhoD);
        int altura_esquerda = height(no.filhoE); 
    
        return 1 + Math.max(altura_direita, altura_esquerda);
    }
    public int depth(Node no) {

        if(isRoot(no)){
            return 0;
        }
    
        return 1 + depth(no.getPai());
    }


    public boolean isEmpty(){
        return this.size == 0;
    }
    public boolean isInternal(Node no){
        return no.getFilhoD() != null ||  no.getFilhoE() != null;
    }
    public boolean isExternal(Node no){
        return no.getFilhoD() == null && no.getFilhoE() == null ;
    }

    public boolean isRoot(Node no){
        return no.getValue() ==  this.raiz;
    }


    private void Preordem(Node n, Array<Object> s) {
        s.add(n.getValue());
        if (n.getFilhoE() != null)
            Preordem(n.getFilhoE(), s);
        if (n.getFilhoD() != null)
            Preordem(n.getFilhoD(), s);
    }
    private void Emordem(Node n, Array<Object> s) {
        if (n != null) {
            Emordem(n.getFilhoE(), s);  
            s.add(n.getValue());        
            Emordem(n.getFilhoD(), s);  
        }
    }
    
    public Array<Object> elements() {
        Array<Object> array = new Array<Object>();
        Emordem(raiz, array);
        return array;
    }


}

//no pai 
// filho a esquerda
// filho a direita
// caminhamento em ordem
// visita o direito depois o pai depois o esquerdo


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
// h=0
// para cara w em children(v)