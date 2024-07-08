

public class SequenciaNode implements  Sequencia, Lista, Vetor{
    public int size;
    public Node inicio = new Node();
    public Node fim = new Node();

    public SequenciaNode() {
        this.fim = null;
        this.inicio = null;
        this.size = 0;
    }

    // METODOS GENÉRICOS -------------------------------------------------------------------------------------------------------------------------------------------


    @Override
    public int size() {
       return 0;
    }

    @Override
    public boolean isEmpty() {
        return size() ==0;
    }

    // METODOS DE PONTE - SEQUENCIA -------------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public Node atRank(int r) {
        if (isEmpty()) {
            throw new SequenciaVaziaExcecao("Sequencia vazia.");
        } else {
            checkRank(r);
            Node no;
            if (r <= size() / 2) {
                no = this.inicio;
                for (int x = 0; x < r; x++) {
                    no = no.getProximo();
                }
            } else {
                no = this.fim;
                for (int x = 1; x < size() - r; x++) {
                    no = no.getAnterior();
                }
            }
            return no;
        }
    }
    

    @Override
    public int rankOF(Node n) {
        int r = 0;
        if (isEmpty()) {
            throw new SequenciaVaziaExcecao("Sequencia vazia.");
        } else {
            Node current = this.inicio;
           while(current.getProximo() == null){
            if(n.getValue() == current.getValue()){
                return r;
            }
            r++;
           }
            return -1;
        }
    }

    public void checkRank(int r){
        if(r < 0 || r > size()) throw new PosicaoInvalida("Indice inválido: " + r);
    }

    // METODOS DE LISTA -------------------------------------------------------------------------------------------------------------------------------------------


    @Override
    public boolean isFirst(Node p) { // O(1)
        return p.getValue() == this.inicio.getValue();
    }
    @Override
    public boolean isLast(Node p) { // O(1)
        return p.getValue() == this.fim.getValue();
    }
    @Override
    public Node first() { // O(1)
        if (isEmpty()) { 
            throw new SequenciaVaziaExcecao("Lista está vazia");
        }else{
            return this.inicio;
        }
    }
    @Override
    public Node last() { // O(1)
        if (isEmpty()) {
            throw new SequenciaVaziaExcecao("Lista está vazia");
        }else{
            return this.fim;

        }
    }
    @Override
    public Object replaceElement(Node n, Object o) { // O(1)
        Object e = n.getValue();    
        n.setValue(o);
        return e;
    }


    private Node getElement(Object e){   // O(n) Implementei mas acabei não usando
        if(!isEmpty()){
            Node current = this.inicio;
            while(current.getValue() != e){
                current = current.getProximo();
            }
            return current; 
        }else{
            return null;
        }   
    }

    @Override
    public void swapElements(Node n , Node q) { // O(1)
        Object temp =  n.getValue();
        n.setValue(q.getValue());
        q.setValue(temp);
    }

    @Override
    public Node insertBefore(Node n, Object o) { // O(1)
        if(isEmpty()){
            throw new SequenciaVaziaExcecao("Lista Vazia.");
        }else{
            if(isFirst(n)){
                throw new PosicaoInvalida("Não é possível inserir antes do início");
            }else{
                Node new_no = new Node();
                new_no.setValue(o);
                Node current  = n;
                new_no.setProximo(current);
                current.getAnterior().setProximo(new_no);
                current.setAnterior(new_no);

                this.size++;
                return new_no;
            }
        }
    }
    
    @Override
    public Node insertAfter(Node n, Object o) { // O(1)
        if(isEmpty()){
            throw new SequenciaVaziaExcecao("Lista Vazia.");
        }else{
            if(isLast(n)){
                throw new PosicaoInvalida("Não é possível inserir depois do fim");
            }else{
                Node new_no = new Node();
                new_no.setValue(o);
                Node current  = n;
                new_no.setAnterior(current);
                current.getProximo().setAnterior(new_no);
                new_no.setProximo(current.getProximo());
                current.setProximo(new_no);
                this.size++;
                return new_no;
            }
        }
    }

    @Override
    public Node insertFirst(Object o) { // O(1)
        Node n = new Node();
        n.setValue(o);
        if (isEmpty()) {
            this.inicio = n;
            this.fim = n;
        } else {
            this.inicio.setAnterior(n);
            n.setProximo(this.inicio);
            this.inicio = n;
        }
        this.size++;
        return this.inicio;
    }
    
    
    @Override
    public Node insertLast(Object o){ // O(1)
        Node new_no = new Node();
        new_no.setValue(o);
        if(this.fim != null){
            // Pegando o último nó existente
            new_no.setAnterior(this.fim);
            this.fim.setProximo(new_no);
            this.fim = new_no; // atualiza o último nó para o nov nó criado
        }else{
            this.fim = new_no;
            this.inicio = this.fim;
        }
        this.size++;

        return new_no ;
    }
    @Override
    public Node before(Node n) { // O(1)
        if(isFirst(n)){
            throw new PosicaoInvalida("Não existe posição anterior ao primeiro.");
       }else{
        return n.getAnterior();
       }
    }
    @Override
    public Node after(Node n) {
        if(isLast(n)){
            throw new PosicaoInvalida("Não existe posição posterior ao fim.");
       }else{
        return n.getProximo();
       }
    }

    // METODOS DE VETOR -------------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public Node elemAtRank(int r) {
        if(r < 0 || r > size()) throw new PosicaoInvalida("Indice inválido: " + r);
        if(isEmpty()) throw new SequenciaVaziaExcecao("A sequencia está vazio");
        Node current = this.inicio;
        for (int x = 0; x < r;x++) { // Procurando o nó de indece r até que o próximo nó seja null
            current = current.proximo;
        }
        return current;
    }

    @Override
    public Object replaceAtRank(int r, Object o) {
        Node no = elemAtRank(r); // encontra o no
        Object old_value = no.getValue(); // Armazena o valor antigo
        no.setValue(o); // atualiza o valor 
        return old_value; // retorna o valor removido
    }


    @Override
    public Object removeAtRank(int r) {
        if(r < 0 || r > size()) throw new PosicaoInvalida("Indice inválido: " + r);
        if(isEmpty()) throw new SequenciaVaziaExcecao("A sequencia está vazio");

        Object removido = null;
        if(r==0){ // trata a exceção de remover no início
            removido = inicio.getValue();

            if(size() == 1){
                this.inicio = null;
                this.fim  = inicio;
            }else{
                if(size() > 1){
                    
                    this.inicio = inicio.getProximo(); // o novo inicio é o próximo elemento
                    inicio.setAnterior(null);
                }
            }
            this.size--;
        }else{
            if(r != size()-1){  // Removendo no meio
                Node no_ant = elemAtRank(r - 1); // encontra o nó anterior ao que será removido
                Node no_rm = no_ant.getProximo(); // Armazena o nó a ser removido
                Node no_pro = no_rm.getProximo();

                no_pro.setAnterior(no_ant); // Atualiza o nó anterior do nó posterior ao que será removido        
                
                no_ant.setProximo(no_pro); // Atualiza o próximo do nó anterior ao que será removido
                removido = no_rm.getValue(); // Armazena o valor que foi removido
                this.size--;      
            }else{ // trata a exceção de remover no final
                removido = this.fim.getValue();
                this.fim = this.fim.getAnterior(); // atualiza o fim da lista para o nó anteriror
                this.fim.setProximo(null); // atualiza o próximo da lista para null
                this.size--;
            }
        }
        return removido;
    }

    @Override
    public void insertAtRank(int r, Object o) {
        if (r < 0 || r > size()) throw new PosicaoInvalida("Índice inválido: " + r);
    
        if (isEmpty()){
            // Trata a inserção no início da lista quando ela é vazia
            this.inicio.setValue(o);
            this.fim = inicio;   
            this.size++;
            
        }else if (r == 0){
            Node new_no = new Node();
            inicio.setAnterior(new_no);
            new_no.setProximo(inicio);
            new_no.setValue(o);
            this.inicio = new_no;
            this.size++;

        } else if (r == size()) { // Trata a inserção no final da lista
            Node novoNo = new Node();
            novoNo.setValue(o);
           // Pegando o último nó existente
            novoNo.setAnterior(this.fim);
            this.fim.setProximo(novoNo);
            this.fim = novoNo; // atualiza o último nó para o nov nó criado
            this.size++;

        } else { // Trata a inserção no meio da lista
            Node no = elemAtRank(r); // Pega o nó na posição r
            Node novoNo = new Node();
            novoNo.setValue(o);
            novoNo.setAnterior(no.getAnterior());
            novoNo.setProximo(no);
            no.setAnterior(novoNo);
            if (novoNo.getAnterior() != null) {
                novoNo.getAnterior().setProximo(novoNo);
            }
            this.size++;
        }
    }
    
    public void clear() {
        this.size = 0;
    }
    // METODOS DE VETOR

    @Override
    public Object remove(Node p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }



}
