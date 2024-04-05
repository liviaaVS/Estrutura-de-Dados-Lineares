public class FilaTwoPilha implements Fila{
    public PilhaNode pilha1 = null;
    public PilhaNode pilha2 = null;  
    public int size = 0;

    
    public FilaTwoPilha() {
        this.pilha1 = new PilhaNode();
        this.pilha2 = new PilhaNode();
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
    public Object Dfileirar() throws FilaVaziaExcecao {
        if (isEmpty()) 
            throw new FilaVaziaExcecao("Fila vazia");
        else {

            while (!pilha1.isEmpty()) {
                pilha2.push(pilha1.pop()); 
            }
    
            Object topo = pilha2.pop();
    
            while (!pilha2.isEmpty()) {
                pilha1.push(pilha2.pop()); 
            }
            
            return topo;
        }
    }
    
    @Override
    public void fileirar(Object o) {
        this.pilha1.push(o);
        this.size++;
    }

    @Override
    public Object first() throws FilaVaziaExcecao {
        if (isEmpty()) 
            throw new FilaVaziaExcecao("Fila vazia");
        
        while (!pilha1.isEmpty()) {
            pilha2.push(pilha1.pop()); 
        }
        
        Object topo = pilha2.top(); 
        
        while (!pilha2.isEmpty()) {
            pilha1.push(pilha2.pop()); 
        }
        
        return topo;
    }
    
    
}
