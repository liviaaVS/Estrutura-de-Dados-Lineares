public class PilhaTwoFila implements Pilha{
    public FilaNode fila1 = null;
    public FilaNode fila2 = null;
    public int size = 0;
    PilhaTwoFila(){
        this.fila1 = new FilaNode();
        this.fila2 = new FilaNode();
    }

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
        if(isEmpty()){
            throw new PilhaVaziaExcecao("Pilha Vazia");
        }else{
            // Indo para o final da fila
            // 1 2 3 4 5 6 7 8
            while (!fila1.isEmpty()) {
                fila2.fileirar(fila1.Dfileirar());
            }
            // 8 7 6 5 4 3 2 1
            Object topo  = fila2.first(); // 8
            
            while (!fila2.isEmpty()) {
                fila1.fileirar(fila2.Dfileirar());
            }

            return topo;

        }
    }

    @Override
    public void push(Object o) {
        this.fila1.fileirar(o);
        this.size++;
    }

    @Override
    public Object pop() throws PilhaVaziaExcecao {
        if(isEmpty()){
            throw new PilhaVaziaExcecao("Pilha Vazia");
        }else{
            // Indo para o final da fila
            // 1 2 3 4 5 6 7 8
            for(int x= 0; x<size()-1; x++) {
                fila2.fileirar(fila1.Dfileirar());
            }

            Object topo  = fila1.Dfileirar(); 
            
            while (!fila2.isEmpty()) {
                fila1.fileirar(fila2.Dfileirar());
            }
            this.size--;

            return topo;
        }    
    }

    @Override
    public void clear() {
        this.size = 0;
    }
    
    


}
