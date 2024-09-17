package Heap_Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class HeapNode implements Heap {
    public Node root = null;
    public Node last = null;
    public int size = 0;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Node root() throws HeapVaziaExcecao {
        return this.root;
    }

    @Override
    public boolean isRoot(Node no) throws HeapVaziaExcecao {
        return this.root == no;
    }

    @Override
    public boolean isExternal(Node no) throws HeapVaziaExcecao {
        return no.getFilhoD() == null && no.getFilhoE() == null;
    }

    @Override
    public Node upHeap(Node no) {
        if (no.getPai() != null) {
            Node current = no.getPai();
            while (current != null && no.getKey() < current.getKey()) {
                swap(no, current);
                no = current;
                current = current.getPai();
            }
        }
        return no;
    }

    private void swap(Node no1, Node no2) {
        int tempKey = no1.getKey();
        no1.setKey(no2.getKey());
        no2.setKey(tempKey);

        Object tempElement = no1.getElement();
        no1.setElement(no2.getElement());
        no2.setElement(tempElement);
    }

    private Node findLast() { // O(nlog(n))
        if (root() == null) {
            return null; 
        }
        Queue<Node> fila = new LinkedList<>();
        fila.add(root());
        while (!fila.isEmpty()) {
            Node atual = fila.poll();
            if (atual.getFilhoE() == null) {
                return atual; 
            } else {
                fila.add(atual.getFilhoE());
            }
            if (atual.getFilhoD() == null) {
                return atual;
            } else {
                fila.add(atual.getFilhoD());
            }
        }
        return null;
       
    }

    private Node findLastRemove(Node no) { 

        while(!isRoot(no) && no.getPai().getFilhoD() != no){
            no = no.getPai();
        }
        if(isRoot(no)){
            if(isExternal(no))
                return no;

            else{
                while(no.getFilhoD() != null){
                    no = no.getFilhoD();
                }
                return no;
            }    
           
        }

        if(no.getPai().getFilhoE() != null){
            no = no.getPai().getFilhoE();
            while(no.getFilhoD() != null){
                no = no.getFilhoD();
            }

            return no;
        }else{
            return no.getPai();
        }
        // para cima ate achar um filho direito ou o a raiz
        // caso afirmativo vai para o filho esquerdo
        // no filho direito desce ate achar um no folha PELA DIREITA
       
    }

    private Node fLast(Node no) { // O(log(n))
        while(!isRoot(no) && no.getPai().getFilhoE() != no){
            no = no.getPai();
        }
        if(isRoot(no)){
            if(isExternal(no))
                return no;

            else{
                while(no.getFilhoE() != null){
                    no = no.getFilhoE();
                }
                return no;
            }    
           
        }

        if(no.getPai().getFilhoD() != null){
            no = no.getPai().getFilhoD();
            while(no.getFilhoE() != null){
                no = no.getFilhoE();
            }

            return no;
        }else{
            return no.getPai();
        }
        // para cima ate achar um filho direito ou o a raiz
        // caso afirmativo vai para o filho esquerdo
        // no filho direito desce ate achar um no folha
    }

    @Override
    public Node insert(int k, Object o) { // O(log(n)) melhor caso O(1)
        Node novoNo = new Node(o, null, k);
        if (isEmpty()) {
            this.root = novoNo;
            this.last = novoNo;
            this.size++;
            return this.root;
        } else {
            this.size++;
            Node paiDoNovoNo = fLast(this.last);
            if (paiDoNovoNo.getFilhoE() == null) {
                paiDoNovoNo.setFilhoE(novoNo);
            } else {
                paiDoNovoNo.setFilhoD(novoNo);
            }
            novoNo.setPai(paiDoNovoNo);
            this.last = novoNo;
            upHeap(novoNo);
            return novoNo;
        }
    }

    @Override
    public Node removeMin() {
        if (isEmpty()) {
          throw new  HeapVaziaExcecao("Não é possível remover um elemento de uma heap vazia");
        } else {
            if(size() == 1){
                Node no = root();
                this.root = null;
                this.size=0;
                return no;
            }else{
                Node old_root = new Node();
                old_root.setKey(root().getKey());
                this.root.setKey(this.last.getKey());
                this.root.setElement(this.last.getElement());
                Node old_last = this.last;
                this.last  =  findLastRemove(this.last);    
                downHeap(root());
                this.size--;
                if (old_last.getPai().getFilhoE() == old_last) {
                    // Se old_last é o filho da esquerda, exclua o filho da esquerda
                    old_last.getPai().setFilhoE(null);
                } else if (old_last.getPai().getFilhoD() == old_last) {
                    // Se old_last é o filho da direita, exclua o filho da direita
                    old_last.getPai().setFilhoD(null);
                }

                return old_root;
            }
           
        }
    }
    public void printTree(Node n, String prefix, boolean isLeft) {
        if (n != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + n.getKey());
            printTree(n.getFilhoE(), prefix + (isLeft ? "│   " : "    "), true);
            printTree(n.getFilhoD(), prefix + (isLeft ? "│   " : "    "), false);
        }
    }

    public void Emordem(Node n) {
        if (n != null) {
            Emordem(n.getFilhoE());
            System.out.println(n.getKey());
            Emordem(n.getFilhoD());
        }
    }

    @Override
    public int height() throws HeapVaziaExcecao {
        return heightRec(root());
    }

    private int heightRec(Node no) {
        if (no == null) {
            return -1;
        }
        int altura_direita = heightRec(no.filhoD);
        int altura_esquerda = heightRec(no.filhoE);
        return 1 + Math.max(altura_direita, altura_esquerda);
    }

    @Override
    public ArrayList<Object> elements() throws HeapVaziaExcecao {
        ArrayList<Object> elementos = new ArrayList<>();
        if (root != null) {
            Queue<Node> fila = new LinkedList<>();
            fila.add(root);
            while (!fila.isEmpty()) {
                Node atual = fila.poll();
                elementos.add(atual.getElement());
                if (atual.getFilhoE() != null) fila.add(atual.getFilhoE());
                if (atual.getFilhoD() != null) fila.add(atual.getFilhoD());
            }
        }
        return elementos;
    }

    @Override
    public Node parent(Node no) throws HeapVaziaExcecao {
        return no.getPai();
    }

    @Override
    public boolean isInternal(Node no) throws HeapVaziaExcecao {
        return no.getFilhoE() != null || no.getFilhoD() != null;
    }

    @Override
    public int depth(Node no) {
        if (isRoot(no)) {
            return 0;
        }
        return 1 + depth(no.getPai());
    }

    @Override
    public Object replace(Node no, Object o) throws HeapVaziaExcecao {
        Object oldElement = no.getElement();
        no.setElement(o);
        return oldElement;
    }

   

    @Override
    public Node downHeap(Node no) {
        // Se o nó for externo (ou seja, uma folha), não há necessidade de ajustar
        if (isExternal(no)) return no;
        
        // Se o nó tem dois filhos, vamos compará-los
        if (children(no).size() == 2) {
            Node filhoEsquerdo = no.getFilhoE();
            Node filhoDireito = no.getFilhoD();
            
            // Identificar o filho com a menor chave
            Node menorFilho = (filhoEsquerdo.getKey() < filhoDireito.getKey()) ? filhoEsquerdo : filhoDireito;
            
            // Se o menor filho for menor que o pai, troca de lugar com o pai
            if (menorFilho.getKey() < no.getKey()) {
                swap(no, menorFilho);
                // Continuar a operação downHeap recursivamente no filho
                downHeap(menorFilho);
            }
        } else if (children(no).size() == 1) { // Se o nó tem apenas um filho
            Node filhoEsquerdo = no.getFilhoE();
            
            // Verificar se o filho esquerdo é menor que o nó atual (pai)
            if (filhoEsquerdo.getKey() < no.getKey()) {
                swap(no, filhoEsquerdo);
                downHeap(filhoEsquerdo);
            }
        }
    
        // Retornar o nó ajustado
        return no;
    }

    @Override
    public ArrayList<Node> nos() throws HeapVaziaExcecao {
        ArrayList<Node> listaDeNos = new ArrayList<>();
        if (root != null) {
            Queue<Node> fila = new LinkedList<>();
            fila.add(root);
            while (!fila.isEmpty()) {
                Node atual = fila.poll();
                listaDeNos.add(atual);
                if (atual.getFilhoE() != null) fila.add(atual.getFilhoE());
                if (atual.getFilhoD() != null) fila.add(atual.getFilhoD());
            }
        }
        return listaDeNos;
    }
    
    @Override
    public ArrayList<Node> children(Node no) throws HeapVaziaExcecao {
        ArrayList<Node> filhos = new ArrayList<>();
        if (no.getFilhoE() != null) {
            filhos.add(no.getFilhoE());
        }
        if (no.getFilhoD() != null) {
            filhos.add(no.getFilhoD());
        }
        return filhos;
    }
    
}
