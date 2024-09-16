package Heap_Node;

public class Node {
    public Object element =  (Integer) null;
    public Node filhoD = null;
    public Node filhoE =  null;
    public Node Pai =  null;
    public int key =  0;
    
    // Construtor que inicializa sem criar nós recursivamente
    public Node() {
        this.key = 0;
        this.element = null;
        this.filhoE = null;  // Não cria novos nós aqui
        this.filhoD = null;  // Não cria novos nós aqui
        this.Pai = null;
    }

    // Construtor que inicializa com valores fornecidos
    public Node(Object element, Node pai, int key) {
        this.element = element;
        this.Pai = pai;
        this.key = key;
        this.filhoE = null;
        this.filhoD = null;
    }
    public Object getElement() {
        return element;
    }
    public void setElement(Object element) {
        this.element = element;
    }
    public Node getFilhoD() {
        return filhoD;
    }
    public void setFilhoD(Node filhoD) {
        this.filhoD = filhoD;
    }
    public Node getFilhoE() {
        return filhoE;
    }
    public void setFilhoE(Node filhoE) {
        this.filhoE = filhoE;
    }
    public Node getPai() {
        return Pai;
    }
    public void setPai(Node pai) {
        Pai = pai;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

   

    
}
