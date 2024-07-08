public class ListaNode implements Lista{
    public int size = 0;
    public Node inicio = new Node();
    public Node fim = new Node();

    @Override
    public int size(){
        return this.size();
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
    public Object first() {
        if (isEmpty()) {
            throw new ListaVaziaExcecao("Lista está vazia");
        }else{
            return this.inicio;
        }
    }
    @Override
    public Object last() {
        if (isEmpty()) {
            throw new ListaVaziaExcecao("Lista está vazia");
        }else{
            return this.fim;

        }
    }
    @Override
    public void replaceElement(int n, Object o) {
        if(!isEmpty()){
            Node current = this.inicio;
            for(int x=0; x<=n;x++){
                current = current.getProximo();
            }
            current.setValue(o);
        }
    }

    private void checkPosition(int p){
        if(isEmpty()){
            throw new ListaVaziaExcecao("A lista está vazia. ")
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

        Object temp = new Object();
        temp = e1.getValue();
        e1.setValue(e2.getValue());
        e2.setValue(temp);
    }

    @Override
    public int insertBefore(int n, Object o) {
        checkPosition(n);
       if(isFirst(n)){
            throw new PosicaoInvalida("Não é possível inserir antes do primeiro elemento");
       }else{
        Node new_no = new Node();
        Node current  = getElement(n);
        new_no.setProximo(current);
        new_no.setAnterior(current.getAnterior());
        current.getAnterior().setProximo(new_no); // O proximo do anterior do elemento n agora é o novo nó
        current.setAnterior(new_no);
        if(isFirst(n-1)){
            this.inicio = new_no.getAnterior();
        }

        this.size++;
       }
       return n;
    }
    @Override
    public int insertAfter(int n, Object o) {
        if(isLast(n)){
            throw new PosicaoInvalida("Não é possível inserir depois do último elemento");
       }else{
        Node new_no = new Node();
        Node current  = getElement(n);
        if(!isLast(n+1)){ // se não for o último, new_no tem proximo
            new_no.setProximo(current.getProximo());
        }
        new_no.setAnterior(current);
        current.setProximo(new_no);
        this.size++;
       }
       return n+1;
    }
    @Override
    public void insertFirst(int n, Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertFirst'");
    }
  





}