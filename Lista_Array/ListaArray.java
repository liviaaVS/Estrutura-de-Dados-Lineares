public class ListaArray implements Lista {
    public int size;
    public Object[] array;
    public Object inicio;
    public Object fim;
    public int capacidadeI;

    public ListaArray(int capacidadeI) {
        this.array = new Object[capacidadeI];
        this.capacidadeI = capacidadeI; // Inicializa capacidadeI
        this.size = 0;
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
    public boolean isFirst(Object p) {
        if(isEmpty()){
            throw new ListaVaziaExcecao("Lista vazia.");
        }
       return this.array[0] == p;
    }

        // Método para obter o índice de um elemento no this.array
        public int getElement(Object p) {
            if(isEmpty()){
                throw new ListaVaziaExcecao("Lista vazia.");
            }
            for (int x = 0; x < size(); x++) {
                if (this.array[x].equals(p)) {
                    return x;
                }
            }
        
                throw new PosicaoInvalida("Posição inválida");
                
            }

    @Override
    public boolean isLast(Object p) {
        if(isEmpty()){
            throw new ListaVaziaExcecao("Lista vazia.");
        }
        return this.array[size()-1] == p;
    }
    @Override
    public Object first(){
        if(isEmpty()){
            throw new ListaVaziaExcecao("Lista vazia.");
        }
        return this.array[0];
    }
    @Override
    public Object last() {
        if(isEmpty()){
            throw new ListaVaziaExcecao("Lista vazia.");
        }
        return this.array[size()-1];
    }
    @Override
    public Object before(Object n) {
        int index = getElement(n);
        if(index == 0) throw new PosicaoInvalida("Não é existe um elemento antes do início");
        return this.array[index-1];
       
    }
    @Override
    public Object after(Object n) {
        int index = getElement(n);
        return this.array[index+1];
    }
    @Override
    public Object replaceElement(Object n, Object o) {
        int index = getElement(n);
        Object old_element = this.array[index];
        this.array[index] = o;
        return old_element;
       
    }
    @Override
    public void swapElements(Object n, Object q) {
        int index1 = getElement(n);
        int index2 = getElement(q);
        Object temp = this.array[index1];
        this.array[index1] = q;
        this.array[index2] = temp;

    }

    public void IncreCapacidade(){
        if(this.size() == this.capacidadeI){
            this.capacidadeI *=2;
            Object[] new_array = new Object[this.capacidadeI];
            int x = 0;
            while (x != size()) {
                new_array[x] = this.array[x];
                x++;
            }
            this.array =  new_array;
        }
    }


    @Override
    public Object insertBefore(Object n, Object o) {

        int index = getElement(n);
        if(index == 0) throw new PosicaoInvalida("Não é inserir um elemento antes do início");

        Object ant = this.array[index];
     
        if(index == size()){
                IncreCapacidade();
                this.array[index] = o;
                this.size++;
                return ant;
        }else{
            IncreCapacidade();
            Object anterior =  this.array[index];                     
            this.array[index] = o;
            this.size++;
            index++;
            while(index != size()){
                Object copy = this.array[index];
                this.array[index] = anterior;
                anterior =  copy;
                index++;
            }
            return ant;
        }
    }

    @Override
    public Object insertAfter(Object n, Object o) {
        int index = getElement(n);

        if(index == size()) throw new PosicaoInvalida("Não é inserir um elemento depois do fim");
        
        Object ant = this.array[index];
        index++;

        IncreCapacidade();
        Object anterior =  this.array[index];                     
        this.array[index] = o;
        this.size++;
        index++;
        while(index != size()){
            Object copy = this.array[index];
            this.array[index] = anterior;
            anterior =  copy;
            index++;
        }
        return ant;
    }

    @Override
    public void insertFirst(Object o) {
        IncreCapacidade();
        if(isEmpty()){
            this.array[0] = o;
            this.size++;
        }else{

            int index = 0;
            Object anterior =  this.array[index];                     
            this.array[index] = o;
            this.size++;
            index++;
            while(index != size()){
                Object copy = this.array[index];
                this.array[index] = anterior;
                anterior =  copy;
                index++;
            }
        }
    }

    @Override
    public void insertLast(Object o) {
        IncreCapacidade();
        this.array[size()] = o;
        this.size++;
    }
    @Override
    public Object remove(Object p) {
       int index = getElement(p);

       while (index != (size()-1)) {
           this.array[index] = this.array[index+1];
           index++;
       }
       this.size--;
       return p;
    }
    public String toString(){
        
        String lista = "[";
        for(int x = 0; x < size(); x++){
            if(x == size()-1)  lista += array[x];
            else lista += array[x] + ",";
            
        }
        return lista +="]";
    } 



}
