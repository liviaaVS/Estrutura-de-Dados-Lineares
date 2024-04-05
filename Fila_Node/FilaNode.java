
public class FilaNode implements Fila{
    
    public int size = 0;
    public Node inicio = new Node();
    public Node fim = new Node();

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Object Dfileirar() throws FilaVaziaExcecao {
        if (isEmpty()) 
            throw new FilaVaziaExcecao("Fila vazia");
        else {
            Node removedNode = this.inicio;
            this.inicio = inicio.getProximo();
            size--;
            return removedNode.getValue();
        }
    }
    
    @Override
    public void fileirar(Object o) {
        if (isEmpty()) {
            this.inicio = new Node(); // Criar um novo nó se a fila estiver vazia
            this.inicio.setValue(o);
            this.fim = this.inicio;
            this.size++;
        } else {
            Node current = this.inicio;
            while (current.proximo != null) {
                current = current.proximo;
            }
            Node newNode = new Node();
            newNode.setValue(o);
            this.fim = newNode;
            current.proximo = newNode;
            this.size++;
        }
    }

    @Override
    public Object first() throws FilaVaziaExcecao {
        if(isEmpty()) throw new FilaVaziaExcecao("Fila vazia");
        else{
            return this.inicio.getValue();
        }
    }
    
}
