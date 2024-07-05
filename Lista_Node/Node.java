package VetorNode;

public class Node {
    public Object value =  (Integer) null;
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
