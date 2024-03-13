import java.util.*;


public class es_Stack {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        ArrayList<Stack<Integer>> linhas = new ArrayList<>();
        Stack<Integer> linha = new Stack<>();
        ArrayList<Integer> P = new ArrayList<>();
        ArrayList<Integer> aux = new ArrayList<>();

        P.add(3);
        P.add(6);
        P.add(2);
        P.add(7);
        P.add(5);

        // P.add(8);
        // P.add(6);
        // P.add(10);
        // P.add(4);
        // P.add(1);
        // P.add(5);
        // P.add(3);
        boolean alocado = false;
    while (P.size() != 0) {

        if(P.size() == 1){
            linha.push(P.get(0));
            linhas.add((Stack<Integer>) linha);
            P.remove(0);
            break;
        }
        
        for (int x = 1; x < P.size(); ++x) {

            if (P.get(x) > P.get(x - 1)) {

                if (!alocado) {
                    linha.push(P.get(x));
                    aux.add(P.get(x));
                    alocado = true;
                
                }else{
                    alocado = false;
                }

            } else {
                if(x == 1) {
                    linha.push(P.get(x-1));
                    aux.add(P.get(x-1));
                }
                linha.push(P.get(x));
                aux.add(P.get(x));
                alocado =  true;

            }
        }

        // Adiciona a última linha à lista de linhas
        if (!linha.isEmpty()) {
            linhas.add((Stack<Integer>) linha.clone());
        }

        for(int y = 0 ; y < aux.size();++y){
            P.remove(P.indexOf(aux.get(y)));
        }
       

        linha.clear();
        aux.clear();
        alocado = false;
        
    }
        System.out.println(P);
        for (Stack<Integer> l : linhas) {
            System.out.println("Linha de força: " + l);
        }
    }
}
