public class PilhaNode implements Pilha {
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

    
    public Object top() throws PilhaVaziaExcecao {
        if (isEmpty())
            throw new PilhaVaziaExcecao("Pilha vazia");
        else{
        return fim.getValue();
        }
    }


    @Override
    public void push(Object o) {
        Node newNode = new Node(); // criando novo no a ser inserido 
        if(isEmpty()){ // verificando se está vazio, pois a inserção muda quando se insere no começo
            this.inicio =  newNode; // definindo o novo No como o inicio
            inicio.setValue(o); // adicionando o valor do ao novo no
            this.fim.setValue(this.inicio); // como é o comedo
            this.size++;
        }else{
            newNode.setValue(o);
            this.fim.setProximo(newNode);
            this.fim = newNode;
            this.size++;
        }
    }

    @Override
    public Object pop() throws PilhaVaziaExcecao {
        if (isEmpty()) {
            throw new PilhaVaziaExcecao("Pilha vazia");
        } else {
            if (size == 1) {
                Object topo = inicio.getValue();
                inicio = null;
                fim = null;
                size = 0;
                return topo;
            } else {
                Node current = inicio;
                while (current.proximo != fim) {
                    current = current.proximo;
                }
                
                // Removendo o último elemento da pilha
                Object topo = fim.getValue();
                fim = current;
                fim.proximo = null;
                size--;
                return topo;
            }
        }
    }
    

    @Override
    public void clear() {
        this.size = 0;
    }
    @Override
    public String toString(){
        Node current = this.inicio;
        String pilha = "[";
        for(int x = 0; x < size(); x++){
            if(x == size()-1){
                  pilha += current.getValue();
                  current = current.proximo;
            } else {
                pilha += current.getValue() + ",";
                current = current.proximo;
            }
        }
        return pilha +="]";
    }
    
}
