
public class HashTable {
    public class Node {

        public Object value = null;
        public Node proximo = null;
        public Node anterior =  null;
        
        public Node getAnterior() {
            return anterior;
        }
        public void setAnterior(Node anterior) {
            this.anterior = anterior;
        }
        public Object getValue() {
            return value;
        }
        public void setValue(Object value) {
            this.value = value;
        }
        public Node getProximo() {
            return proximo;
        }
        public void setProximo(Node proximo) {
            this.proximo = proximo;
        }

        
    }
   
    Object[] dado;
    int tamanho;
    int usado;
    int pmt; // primo < tamanho

    public HashTable(int tamanho){
        this.tamanho = tamanho;
    }

    private int func_hash(Object o) {
        return o.hashCode();
        // Possibilidade de alterar a função de hashing para uma personalizada
    }

    private int  re_hash(int x, int count){
        return  ((x + (count*((x%tamanho-1)+pmt))) % tamanho ); 

    }
    private int func_indice(Object o) {
        int x = (func_hash(o) * pmt + pmt) % tamanho;
        if(x < 0) x = x*-1;
        return x;
    }

    private boolean ehprimo(int i) {
        for (int j = 2; j < i; j++) {
            if (i % j == 0)
                return false;
        }
        return true;
    }

    private int encontrar_pmt(int i) {
        while (!ehprimo(i--));
        return i;
    }

    private int encontrar_pMt(int i) {
        while (!ehprimo(i++));
        return i;
    }

    private void mudartamanho(int novotamanho) {
        Object dadovelho[] = dado;
        Object dadonovo[] = new Object[novotamanho];

        this.dado = dadonovo;
        this.tamanho = novotamanho;
        this.pmt = encontrar_pmt(novotamanho);
        this.usado = 0;

        for (Object i : dadovelho) {
            if(i != null)
            inserir(i);
        }
    }

    public int encontrarchave(Object obj) {
        int indice = func_indice(obj);
        int count = 0;
        while (dado[indice] != obj)
            indice = (indice + 1) % tamanho;
        if (count == tamanho + 1)
            throw new  EDLVazioExcecao("Não existe esse elemento");
        return indice;
    }

    public Object encontrarobj(int chave) {
        if (chave < tamanho)
            return dado[chave];
        else
            throw new EDLVazioExcecao("Errado");
    }

    public void inserir(Object o) {
        usado++;
        if (usado >= tamanho/2) {
            mudartamanho(encontrar_pMt(tamanho*2));
        }
        
        int indice = func_indice(o);
        while (dado[indice] != null && dado[indice] != null) {
            indice = (indice + 1) % tamanho;
        }
        
        if (dado[indice] == null || dado[indice] == null) {
            dado[indice] = o;
        }
        
        System.out.println("'" + o + "' : " + func_indice(o));
        
    }
    
    public Object removerobj(Object obj) {
        return removerchave(encontrarchave(obj));
    }

    public Object removerchave(int chave) {
        usado--;
        if (chave < tamanho) {
            Object x = dado[chave];
            dado[chave] = null;
            return x;
        } else
            throw new EDLVazioExcecao("Errado");
    }

    public void printlista() {
        System.out.print("[");
        for (Object o : dado) {
            if( o != null)
                System.out.print( o + ", ");
            else
                System.out.print("-, ");

        }
        System.out.print("]\n");

    }

}