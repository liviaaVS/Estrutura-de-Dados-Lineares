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
    public int size(){
        return this.size;
    }
    @Override
    public boolean  isEmpty(){
        return size() == 0;
    }
    @Override
    public boolean isFirst(int p) {
        return p == 0;
    }
    @Override
    public boolean isLast(int p) {
        return p == size() -1;
    }
    @Override
    public int first() {
        if (isEmpty()) {
            throw new ListaVaziaExcecao("Lista está vazia");
        }else{
            return 0;
        }
    }
    @Override
    public int last() {
        if (isEmpty()) {
            throw new ListaVaziaExcecao("Lista está vazia");
        }else{
            return size()-1;

        }
    }
    @Override
    public Object replaceElement(int n, Object o) {
            Node no = getElement(n);
            Object e = no.getValue();
            no.setValue(o);
            return e ; 
    }

    private void checkPosition(int p){
        if(isEmpty()){
            throw new ListaVaziaExcecao("A lista está vazia. ");
        }else  if(p > size() || p < 0){
            throw new PosicaoInvalida(p + " - Posição inválida");
        }
        
    }


    private Node getElement(int p){   
        checkPosition(p);
        Node current = this.inicio;
        for(int x=0; x<=p;x++){
            current = current.getProximo();
        }
        return current;        
    }

    @Override
    public void swapElements(int n, int q) {

        Node e1 = getElement(q); 
        Node e2 = getElement(n);

        Object temp =  e1.getValue();
        e1.setValue(e2.getValue());
        e2.setValue(temp);
    }

    @Override
    public int insertBefore(int n, Object o) {
        checkPosition(n);
    
        Node new_no = new Node();
        new_no.setValue(o);
        Node current  = getElement(before(n));
        new_no.setAnterior(current);
        new_no.setProximo(current.getProximo());
        current.getProximo().setAnterior(new_no);
        current.setProximo(new_no);

        this.size++;
        return n;
    }
    @Override
    public int insertAfter(int n, Object o) {
        checkPosition(n);
    
        Node new_no = new Node();
        new_no.setValue(o);
        Node current  = getElement(after(n));
        new_no.setProximo(current);
        new_no.setAnterior(current.getAnterior());
        current.getAnterior().getProximo().setProximo(new_no);
      

        this.size++;
       return n+1;
    }

    @Override
    public int insertFirst(Object o) {
        Node new_no = new Node();
        inicio.setAnterior(new_no);
        new_no.setProximo(inicio);
        new_no.setValue(o);
        this.inicio = new_no;
        this.size++;
        return 0;
    }
    
    @Override
    public int insertLast(Object o){
        Node novoNo = new Node();
        novoNo.setValue(o);
        if(this.fim != null){
            // Pegando o último nó existente
            novoNo.setAnterior(this.fim);
            this.fim.setProximo(novoNo);
            this.fim = novoNo; // atualiza o último nó para o nov nó criado
        }else{
            this.fim = novoNo;
            this.inicio = this.fim;
        }
        this.size++;

        return this.size()-1;
    }
    @Override
    public int before(int n) {
        if(isFirst(n)){
            throw new PosicaoInvalida("Não existe posição anterior ao primeiro.");
       }else{
        return n-1;
       }
    }
    @Override
    public int after(int n) {
        if(isFirst(n)){
            throw new PosicaoInvalida("Não existe posição anterior ao primeiro.");
       }else{
        return n-1;
       }
    }
    
    public String toString(){
        Node current = this.inicio;
        String vetor = "[";
        while(current != null){
            if(current.getProximo() == null) vetor += current.getValue();
            else vetor +=  current.getValue() + ",";
            current = current.getProximo();
            
        }
        return vetor +="]";
    } 




}