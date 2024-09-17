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
        // para cima ate achar um filho esquerdo ou o a raiz
        // caso afirmativo vai para o filho direito
        // no filho direito desce ate achar um no folha
    }

    @Override
    public Node insert(int k, Object o) {
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
    public Node removeMin() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object downHeap(Node no) {
        throw new UnsupportedOperationException("Not supported yet.");
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
