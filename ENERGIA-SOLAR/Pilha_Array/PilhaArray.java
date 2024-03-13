public class PilhaArray implements Pilha2 {
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
    public void desIncrement(){
        if((size() * 100)/capacidade == 25.00){
            this.capacidade /=2;
        }
       
        Object[] newArray = new Object[this.capacidade];

        for(int x = 0; x < size();x++){
            newArray[x] = this.array[x];
        }
        this.array = newArray;
    }


    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return this.size == 0;
    }

    @Override
    public Object top() throws PilhaVaziaExcecao {
        return this.array[size()-1];

    }

    @Override
    public void push(Object o) {
        // TODO Auto-generated method stub
        if(size() < this.capacidade){
            this.array[size()] = o;
            this.size +=1;
        }else{
            this.capacidade *=2;

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
        desIncrement();
        this.size -=1;
        return e;

    }
    @Override
    public void clear() {
        this.size = 0;
        this.array = new Object[capacidade];
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
