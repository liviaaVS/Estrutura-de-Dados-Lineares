# Instituto Federal de Educação, Ciência e Tecnologia do Rio Grande do Norte.

- `Turma:` 2° período - TADS 2023.1
- `Professor:` Robinson Luis de Souza Alves
- `Disciplina:` Estrutura de Dados Lineares
- `Aluna:` Livia Vitória Da Silva



## Energia Solar

[ Implementação da TAD Pilha usada na resolução desse problema: click aqui](https://github.com/Naninh4/Estrutura-de-Dados-Lineares/blob/main/ENERGIA-SOLAR/Pilha_Array/PilhaArray.java)

### Problema apresentado: 

Existe um número de casas em uma rua. Cada casa tem uma planta de geração de energia solar. Casas disponíveis(não entraram em uma linha de força ainda) com valores mais altos de produção de energia em relação à sua a esquerda não podem ficar na mesma linha de transmissão, pois isso pode provocar uma sobrecarga nessa linha. É dado o valor da produção de cada casa. Crie um programa que aloque as casas em um número de linhas de força necessárias para que não haja sobrecarga na rua. Faça as verificações da esquerda para a direita.

**Ex1.:**

P={3, 6, 2, 7, 5} // produção das casas em uma rua

**Passo 1** - Determinar casas da primeira linha de força
linha de força 1 - {6,2,5}
**Passo 2** - Determinar casas da segunda linha de força
Linha de força 2 - {7}
**Passo 3** - Determinar casas da terceira linha de força
Linha de força 3 - {3}

*Nesse exemplo, foram necessárias 3 linhas de força para resolver o problema da rua P.*

**Ex2.:**

P={8,6,10,4,1,5,3} // produção das casas em uma rua

**Passo 1** - Determinar casas da primeira linha de força
linha de força 1 - {8,6,4,1,3}
**Passo 2** - Determinar casas da segunda linha de força
Linha de força 2 - {10,5}

*Nesse exemplo, foram necessárias 2 linhas de força para resolver o problema da rua P.*

## Requisitos funcionais da TAD Pilha:
1. Desenvolva uma versão com array utilizando a estratégia de duplicação em caso de enchimento do array.
2. Em caso do array chegar a 25% de ocupação, deve-se reduzir a sua capacidade pela metade.

## Implementação: 
```java
import java.util.*;
public class es {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        ArrayList<PilhaArray> linhas = new ArrayList<>();
        ArrayList<Integer> P = new ArrayList<>();
        ArrayList<Integer> aux = new ArrayList<>();


        // P.add(3);
        // P.add(6);
        // P.add(2);
        // P.add(7);
        // P.add(5);


        P.add(8);
        P.add(6);
        P.add(10);
        P.add(4);
        P.add(1);
        P.add(5);
        P.add(3);
       
        boolean alocado = false;
    while (P.size() != 0) {
        PilhaArray linha = new PilhaArray(10, 0);
        if(P.size() == 1){
            linha.push(P.get(0));
            linhas.add((PilhaArray) linha);
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
            linhas.add((PilhaArray) linha);
        }


        for(int y = 0 ; y < aux.size();++y){
            P.remove(P.indexOf(aux.get(y)));
        }
       
        aux.clear();
        alocado = false;
       
    }
        for (int i = 0; i < linhas.size(); i++) {
            System.out.println("Linha de força: " + linhas.get(i));
        }
    }
}


```
--------------------------------------------------------------------------------------
------------------------------------FIM-----------------------------------------------
--------------------------------------------------------------------------------------




