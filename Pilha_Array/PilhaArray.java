public class PilhaArray implements Pilha {
    private int size = 0;
    private Object[] array = null;
    private int FatorC = 0;
    private int capacidade = 0;

    public PilhaArray (int capacidadeI, int crescimento){
        this.array = new Object[capacidadeI];
        this.capacidade =  capacidadeI;
        this.FatorC = crescimento;
    }
    @Override
    public int size() {
        return this.size;

    }

 

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return this.size == 0;
    }

    @Override
    public Object top() throws PilhaVaziaExcecao {
        // TODO Auto-generated method stub
        return this.array[size()-1];

    }

    @Override
    public void push(Object o) {
        // TODO Auto-generated method stub
        if(size() < this.capacidade){
            this.array[size()] = o;
            this.size +=1;
        }else{
            if(this.FatorC <= 0) this.capacidade *=2;
            if(this.FatorC >0) this.capacidade += this.FatorC;

            Object[] newArray = new Object[this.capacidade];

            for(int x = 0; x < size();x++){
                newArray[x] = this.array[x];
            }
            this.array = newArray;
            this.array[size()] = o;
            this.size +=1;

        }

    }

    @Override
    public Object pop() throws PilhaVaziaExcecao {
        // TODO Auto-generated method stub
        Object e = this.array[size()-1];
        this.array[size()-1] = null;
        this.size -=1;
        return e;

    }
    @Override
    public void clear() {
        // TODO Auto-generated method stub
        this.size = 0;
    }
    @Override
    public String toString(){
        
        String pilha = "[";
        for(int x = 0; x < size(); x++){
            if(x == size()-1)  pilha += this.array[x];
            else pilha += this.array[x].toString() + ",";
            
        }
        return pilha +="]";
    }
    
}
