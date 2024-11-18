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
        Node new_no2 = new Node();

        // Configuração das relações entre nós
        avo.setFilhoD(pai);
        pai.setFilhoD(new_no);
        new_no2.setPai(pai);
        pai.setPai(avo);
        new_no.setPai(pai);

        // Configuração dos valores nos nós
        avo.setValue(4);
        pai.setValue(8);
        new_no.setValue(9);

        // Exibe a árvore antes da rotação
        System.out.println("Árvore antes da rotação:");
        printTree(avo, "", false);

        // Realiza a rotação simples à esquerda
        rotac.rotacaoSE(new_no);

        // Determina a nova raiz após a rotação
        Node novaRaiz = pai.getPai() == null ? pai : avo;

        // Exibe a árvore após a rotação
        System.out.println("\nÁrvore após a rotação Simples esquerda:");
        printTree(novaRaiz, "|", false);
    }
}
