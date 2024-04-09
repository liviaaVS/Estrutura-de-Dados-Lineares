package VetorNode;

public class VetorNode implements Vetor {
    public int size =0;
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
    public Node elemAtRank(int r) {
        if(r < 0 || r > size()) throw new IndiceInvalido("Indice inválido: " + r);
        if(isEmpty()) throw new VetorVazioExcecao("O vetor está vazio");
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
        if(r < 0 || r > size()) throw new IndiceInvalido("Indice inválido: " + r);
        if(isEmpty()) throw new VetorVazioExcecao("O vetor está vazio");

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
        if (r < 0 || r > size()) throw new IndiceInvalido("Índice inválido: " + r);
    
        if (isEmpty()){
            // Trata a inserção no início da lista quando ela é vazia
            this.inicio.setValue(o);
            this.fim = inicio;   
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
    
    public String toString(){
        Node current = inicio;
        String vetor = "[";
        while(current != null){
            if(current.getProximo() == null) vetor += current.getValue();
            else vetor +=  current.getValue() + ",";
            current = current.getProximo();
            
        }
        return vetor +="]";
    } 

    public void clear() {
        this.size = 0;
    }



}
