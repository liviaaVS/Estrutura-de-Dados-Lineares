package ArvoreRubroNegra;

public class Rotacoes {

    public Node rotacaoSE(Node avo) {
        Node pai =  avo.getFilhoD();

        // Ajusta filho esquerdo do avo
        avo.setFilhoD(pai.getFilhoE());
        //Ajusta pai do novo filho D
        avo.getFilhoD().setPai(avo);
        // Ajusta pai do novo nó 
        if(avo.getPai() !=null){
            pai.setPai(avo.getPai());
        }else{
            pai.setPai(null);
        }
        avo.setPai(pai);
       
        return pai;
    }
  
}
