package ArvoreRubroNegra;

public class Main {

    public static void printTree(Node n, String prefix, boolean isLeft) {
        if (n != null) {
            if(n.getPai() == null){            
                System.out.println(prefix + "   " + n.getValue());
            }else{
                System.out.println(prefix + (isLeft ? "├──E " : "└──D ") + n.getValue());
            }
            printTree(n.getFilhoE(), prefix + (isLeft ? "│   " : "    "), true);
            printTree(n.getFilhoD(), prefix + (isLeft ? "│   " : "    "), false);
        }
    }

    public static void main(String[] args) {
        Rotacoes rotac = new Rotacoes();

        // Criação dos nós
        Node pai = new Node();
        Node avo = new Node();
        Node new_no = new Node();

        // Configuração das relações entre nós
        avo.setFilhoE(pai);
        pai.setFilhoE(new_no);
        pai.setPai(avo);
        new_no.setPai(pai);

        // Configuração dos valores nos nós
        avo.setValue(9);
        pai.setValue(8);
        new_no.setValue(4);

        // Exibe a árvore antes da rotação
        System.out.println("Árvore antes da rotação:");
        printTree(avo, "", false);

        // Realiza a rotação simples à esquerda
        Node novo = rotac.rotacaoSD(pai);
     

        // Exibe a árvore após a rotação
        System.out.println("\nÁrvore após a rotação Simples Direita:");
        printTree(avo, "|", false);
    }
}
