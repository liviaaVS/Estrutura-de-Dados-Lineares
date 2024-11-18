package ArvoreRubroNegra;

public class Rotacoes {

    public void rotacaoSE(Node no) {
        if (no == null || no.getPai() == null || no.getPai().getPai() == null) {
            throw new IllegalArgumentException("O nó ou seus ascendentes são inválidos para realizar a rotação.");
        }

        Node avo = no.getPai().getPai();
        Node pai = no.getPai();

        // Ajusta o filho direito do avô para o filho esquerdo do pai
        avo.setFilhoD(pai.getFilhoE());
        if (pai.getFilhoE() != null) {
            pai.getFilhoE().setPai(avo);
        }

        // Ajusta a relação entre pai e avô
        pai.setFilhoE(avo);
        Node bisavo = avo.getPai();
        avo.setPai(pai);

        // Ajusta a relação entre o pai e o bisavô (se existir)
        if (bisavo != null) {
            if (bisavo.getFilhoE() == avo) {
                bisavo.setFilhoE(pai);
            } else {
                bisavo.setFilhoD(pai);
            }
            pai.setPai(bisavo);
        } else {
            pai.setPai(null); // Pai torna-se a nova raiz
        }
    }
    public void rotacaoSD(Node no) {
        if (no == null || no.getPai() == null || no.getPai().getPai() == null) {
            throw new IllegalArgumentException("O nó ou seus ascendentes são inválidos para realizar a rotação.");
        }

        Node avo = no.getPai().getPai();
        Node pai = no.getPai();

        // Ajusta o filho direito do avô para o filho esquerdo do pai
        avo.setFilhoD(pai.getFilhoE());
        if (pai.getFilhoE() != null) {
            pai.getFilhoE().setPai(avo);
        }

        // Ajusta a relação entre pai e avô
        pai.setFilhoE(avo);
        Node bisavo = avo.getPai();
        avo.setPai(pai);

        // Ajusta a relação entre o pai e o bisavô (se existir)
        if (bisavo != null) {
            if (bisavo.getFilhoE() == avo) {
                bisavo.setFilhoE(pai);
            } else {
                bisavo.setFilhoD(pai);
            }
            pai.setPai(bisavo);
        } else {
            pai.setPai(null); // Pai torna-se a nova raiz
        }
    }
}
