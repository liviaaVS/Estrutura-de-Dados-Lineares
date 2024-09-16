package Hash_Array;



public class HashTable {
    public class PosicaoInvalida extends RuntimeException {
        public PosicaoInvalida(String err){
           super(err);	
        }   
    }
    public class EDLVazioExcecao extends RuntimeException {
        public EDLVazioExcecao(String err){
           super(err);	
        }   
   }
   
    Object[] dado;
    int tamanho;
    int usado;
    int primoMaior; // primo < tamanho

    public HashTable(int tamanho){
        this.tamanho = encontrar_pMt(tamanho);
        this.usado = 0;
        this.primoMaior = encontrar_pmt(this.tamanho);
        this.dado = new Object[this.tamanho];


    }

    private int func_hash(Object o) {
        return o.hashCode();
    }

    private int  re_hash(Object o, int count){

        return (count*(( func_indice(o) % this.tamanho-1)+this.primoMaior)); 

    }
    private int func_indice(Object o) {
        int x = (func_hash(o) * primoMaior + primoMaior) % tamanho;
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
        this.primoMaior = encontrar_pmt(novotamanho);
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
            indice = (indice + re_hash(obj, count++)) % tamanho;
        
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
        int count =0;
        while (dado[indice] != null) {
            indice = (indice + re_hash(o, count++)) % tamanho;
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
        Object a = null;
        if (chave < tamanho) {
            Object x = dado[chave];
            dado[chave] = a;
            if(x == null) throw new PosicaoInvalida("Não possui um elemento.");
            else
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
