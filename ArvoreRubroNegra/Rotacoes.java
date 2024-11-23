package ArvoreRubroNegra;

public class Rotacoes {

    public Node rotacaoSE(Node no) {
        Node sucessor = no.getFilhoD()  ; // 4

        // Ajusta o no do sucessor
        if(no.getPai() != null){
            sucessor.setPai(no.getPai());

            if (no == no.getPai().getFilhoE()) { // se o no desb. for filho esquerdo do seu no
                no.getPai().setFilhoE(sucessor); // o filho esquerdo do no do no desb. será o filho direito do no desb.

            } else {
                no.getPai().setFilhoD(sucessor); // o filho direito do no do no desb. será o filho direito do no desb.
            }

        }else{
            sucessor.setPai(null);
        }
        no.setPai(sucessor);

        no.setFilhoD(sucessor.getFilhoE());

        if (sucessor.getFilhoE() != null) {
            sucessor.getFilhoE().setPai(no); //
        }
        sucessor.setFilhoE(no);

        // calcula o fator de balanceamento

        return sucessor;
    }


    public Node rotacaoSD(Node no) {
        Node sucessor = no.getFilhoE(); // O sucessor é o filho esquerdo
    
        // Ajusta o no do sucessor
        if (no.getPai() != null) {
            sucessor.setPai(no.getPai());
    
            if (no == no.getPai().getFilhoE()) { // Se o nó desbalanceado for filho esquerdo do seu no
                no.getPai().setFilhoE(sucessor); // O filho esquerdo do no do nó desbalanceado será o filho esquerdo do nó desbalanceado
            } else {
                no.getPai().setFilhoD(sucessor); // O filho direito do no do nó desbalanceado será o filho esquerdo do nó desbalanceado
            }
        } else {
            sucessor.setPai(null); // O sucessor se torna a nova raiz
        }
    
        no.setPai(sucessor);
    
        // Ajusta os filhos após a rotação
        no.setFilhoE(sucessor.getFilhoD()); // O filho direito do sucessor se torna o filho esquerdo do no
        if (sucessor.getFilhoD() != null) {
            sucessor.getFilhoD().setPai(no); // Ajusta o no do antigo filho direito do sucessor
        }
        sucessor.setFilhoD(no); // O antigo no se torna o filho direito do sucessor
    
        // Retorna o sucessor, que agora é o novo nó raiz da subárvore
        return sucessor;
    }
    
}
