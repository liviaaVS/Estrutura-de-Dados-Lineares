package Heap_Node;

class HeapNode implements Heap{
    public  Node root = null;
    public  Node last = null;
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
    public int height() throws HeapVaziaExcecao {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object elements() throws HeapVaziaExcecao {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object nos() throws HeapVaziaExcecao {
        throw new UnsupportedOperationException("Not supported yet.");
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
    public Node parent(Node no) throws HeapVaziaExcecao {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object children(Node no) throws HeapVaziaExcecao {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isExternal(Node no) throws HeapVaziaExcecao {
        return no.getFilhoD() == null && no.getFilhoE() == null;
    }

    @Override
    public Node heapOrder(Node no) {
       
        if( no.getPai() !=null){
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
    private Node upLast(Node no) {
        Node new_last = new Node();
        
        // Primeira verificação para garantir que o nó não é a raiz ou está na posição correta
        while (!isRoot(no) && no.getPai().getFilhoE() == no) { 
            no = no.getPai();
            System.out.println(no.key);  // Apenas para depuração
        }
        
        // Caso o nó seja a raiz
        if (isRoot(no)) {
            if (no.getFilhoE() == null) {
                // Insere o novo nó à esquerda
                new_last.setPai(no);
                no.setFilhoE(new_last);
            } else if (no.getFilhoD() == null) {
                // Insere o novo nó à direita
                new_last.setPai(no);
                no.setFilhoD(new_last);
            } else {
                // Desce até o nó externo à esquerda e insere o novo nó
                while (!isExternal(no)) {
                    no = no.getFilhoE();
                }
                new_last.setPai(no);
                no.setFilhoE(new_last);
            }
            this.last = new_last;
            return this.last;
        }
        
        // Caso o nó tenha um pai e seja o filho à esquerda
        if (no.getPai() != null && no.getPai().getFilhoE() == no) {
            no = no.getPai();
            if (no.getFilhoD() == null) {
                // Insere o novo nó à direita
                new_last.setPai(no);
                no.setFilhoD(new_last);
            } else {
                // Desce até o nó externo à esquerda e insere o novo nó
                while (!isExternal(no)) {
                    no = no.getFilhoE();
                }
                new_last.setPai(no);
                no.setFilhoE(new_last);
            }
            this.last = new_last;
        }
        
        return this.last;  
    }
    
    @Override
    public Node upHeap(int k, Object o) {
        // Caso a heap esteja vazia, criamos a raiz
        Node no = new Node();
        if (isEmpty()) {
            Node rt = new Node(o, null, k);
            this.root = rt;
            root.setFilhoE(no);
            upLast(this.root);
            this.size = 1;  // Atualiza o tamanho da heap
            return rt;
        } else {
            this.size++; 
            this.last = upLast(this.last);
            this.last.setKey(k);
            this.last.setElement(o);
            heapOrder(last);
          
            return no ;  
        }
    }
    public void printTree(Node n, String prefix, boolean isLeft) {
        if (n != null) {
            // Imprime o nó atual (com prefixo)
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + n.getKey());
    
            // Recursão para o filho esquerdo e direito, ajustando o prefixo
            printTree(n.getFilhoE(), prefix + (isLeft ? "│   " : "    "), true);
            printTree(n.getFilhoD(), prefix + (isLeft ? "│   " : "    "), false);
        }
    }
    
    public  void Emordem(Node n) {
        if (n != null) {
            Emordem(n.getFilhoE());  
            System.out.println(n.getKey());        
            Emordem(n.getFilhoD());  
        }
    }

    @Override
    public Object downHeap(Node no) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

 

}

