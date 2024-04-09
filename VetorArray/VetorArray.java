public class VetorArray implements Vetor{
    public int size = 0;
    public Object[] array = null;
    public int capacidade;

    VetorArray(int capacidadeI){
        this.array = new Object[capacidadeI];
        this.capacidade =  capacidadeI;
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
    public Object elemAtRank(int r) {
        if(r < 0 || r > size()) throw new IndiceInvalido("Indice inválido: " + r);
        if(isEmpty()) throw new VetorVazioExcecao("O vetor está vazio");
        return array[r];
    }

    @Override
    public Object replaceAtRank(int r, Object o) {
        Object old_element = elemAtRank(r);
        this.array[r] =  o;
        return old_element;
    }

    public void IncreCapacidade(){
        if(this.size() == this.capacidade){
            this.capacidade *=2;
            Object[] new_array = new Object[this.capacidade];
            int x = 0;
            while (x != size()) {
                new_array[x] = this.array[x];
                x++;
            }
            this.array =  new_array;
        }
    }


    @Override
    public Object removeAtRank(int r) {
        Object removido = elemAtRank(r);

        while (r != (size()-1)) {
            this.array[r] = this.array[r+1];
            r++;
        }
        this.size--;
        return removido;
    }

    @Override
    public void insertAtRank(int r, Object o){
        if(r < 0 || r > size()) throw new IndiceInvalido("Indice inválido: " + r);
            if(isEmpty()){
                if(r==0){
                    this.array[r] = o;
                    this.size++;
                }
            }else{
                if(r == size()){
                    IncreCapacidade();
                    this.array[r] = o;
                    this.size++;
                }else{
                    IncreCapacidade();
                    Object anterior =  elemAtRank(r);                     
                    this.array[r] = o;
                    this.size++;
                    r++;
                    while(r != size()){
                        Object copy = elemAtRank(r);
                        this.array[r] = anterior;
                        anterior =  copy;
                        r++;
                    }
                }
            }
    }
    public String toString(){
        
        String vetor = "[";
        for(int x = 0; x < size(); x++){
            if(x == size()-1)  vetor += elemAtRank(x);
            else vetor += elemAtRank(x) + ",";
            
        }
        return vetor +="]";
    } 

    public void clear() {
        this.size = 0;
        this.array = new Object[capacidade]; 
    }
}

