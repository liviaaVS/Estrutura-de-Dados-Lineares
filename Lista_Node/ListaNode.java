public class ListaNode implements Lista{
    public int size;
    public Node inicio = new Node();
    public Node fim = new Node();

    public ListaNode() {
        this.fim = null;
        this.inicio = null;
        this.size = 0;
    }
    @Override
    public int size(){ // O(1)
        return this.size;
    }
    @Override
    public boolean  isEmpty(){ // O(1)
        return size() == 0;
    }
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
            throw new ListaVaziaExcecao("Lista está vazia");
        }else{
            return this.inicio;
        }
    }
    @Override
    public Node last() { // O(1)
        if (isEmpty()) {
            throw new ListaVaziaExcecao("Lista está vazia");
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

    // corrigir daqui para baixo
    @Override
    public Node insertBefore(Node n, Object o) { // O(1)
        if(isEmpty()){
            throw new ListaVaziaExcecao("Lista Vazia.");
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
            throw new ListaVaziaExcecao("Lista Vazia.");
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
    
    

    public String toString(){ // O(n)
        Node current = this.inicio;
        String vetor = "[";
        while(current != null){
            if(current.getProximo() == null) vetor += current.getValue();
            else vetor +=  current.getValue() + ",";
            current = current.getProximo();
            
        }
        return vetor +="]";
    }
    @Override
    public Object remove(Node p) {
        Object old_no = new Object();
       if(isEmpty()){
            throw new ListaVaziaExcecao("Lista Vazia.");
       }else{
        if(isFirst(p)){
            old_no = this.inicio.getValue();
            this.inicio = this.inicio.getProximo();
            this.inicio.setAnterior(null);
        }else
        if(isLast(p)){
            old_no = this.fim.getValue();
            this.fim = this.fim.getAnterior();
            this.fim.setProximo(null);
        }else{
            old_no = p.getValue();
            p.getAnterior().setProximo(p.getProximo()); // o proximo do anterior agora é o meu próximo
            p.getProximo().setAnterior(p.getAnterior()); // o anterior do proximo agora é o meu anterior

        }

        return  old_no;
       }
    } 




}