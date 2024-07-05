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
    public boolean isFirst() {
        
    }
    @Override
    public boolean isLast() {
       
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
            for(int x=0; x<n;x++){
                current = current.getProximo();
            }
            current.setValue(o);

        }
    }
    @Override
    public void swapElements(int n, int q) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'swapElements'");
    }
    @Override
    public void insertBefore(int n, Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertBefore'");
    }
    @Override
    public void insertAfter(int n, Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertAfter'");
    }
    @Override
    public void insertFirst(int n, Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertFirst'");
    }
  





}