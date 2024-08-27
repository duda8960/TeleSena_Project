
public class ControleTeleSena {
    private Pessoa[] pessoas = new Pessoa[20];
    private boolean ganhador;
    private double premio;
    private int indice = 25;
    private int ganhadores =0;
    private GerarNomes g = new GerarNomes();
    private int sequenciaSorteada[] =new int[25];
    private int novaSequencia[];
    private int totalTeleSenasCompradas = 0;
    private double lucros;

    public ControleTeleSena(){

        this.sequenciaSorteada = sortear(sequenciaSorteada);
        this.novaSequencia = sequenciaSorteada;


        for (int p = 0; p< pessoas.length; p++){

            pessoas[p] = new Pessoa(g.gerarNome());
           totalTeleSenasCompradas = totalTeleSenasCompradas + pessoas[p].getQuantidadeAdquirida();

        }
        do{
            for(int p =0; p<pessoas.length; p++){
            for (int t = 0; t<pessoas[p].getQuantidadeAdquirida(); t++) {


                if(verificarQuantidadeAcertos(pessoas[p].getTeleSenasAdquiridas()[t], sequenciaSorteada)){

                    System.out.println(pessoas[p].toString());

                    System.out.println("------------------");
                    ganhadores++;

                }
                }
            }
            if(ganhadores == 0){

                novoSorteio();

            }
        }while (ganhadores == 0);

        this.lucros = (totalTeleSenasCompradas*pessoas[0].getTeleSenasAdquiridas()[0].getValor())*0.2;
        this.premio = ((totalTeleSenasCompradas*pessoas[0].getTeleSenasAdquiridas()[0].getValor())*0.8)/ganhadores;
        infoVendas();
        imprimirCartelaSorteada();
    }
    public void novoSorteio(){
        int numAleatorio;

        novaSequencia = new int[indice+1];

        for(int i =0; i<sequenciaSorteada.length; i++){
            novaSequencia[i] = sequenciaSorteada[i];



        }
        numAleatorio = getNumAleatorio(novaSequencia.length-1, novaSequencia);

        novaSequencia[novaSequencia.length -1] = numAleatorio;
        indice++;
        sequenciaSorteada = novaSequencia;

    }

    private int getNumAleatorio(int i, int[] novaSequencia) {
        int numAleatorio;
        boolean numeroUnico;
        do{
            numAleatorio = (int)(Math.random() * 60 + 1);
            numeroUnico = true;

            for(int j = 0; j<i; j++) {
                if(novaSequencia[j] == numAleatorio){
                    numeroUnico = false;
                    break;
                }
            }
        }while(!numeroUnico);
        return numAleatorio;
    }

    public int[] sortear(int cartela[]){


        int numeroAleatorio;
        boolean numeroUnico;

        for(int i = 0; i<cartela.length; i ++){

            numeroAleatorio = getNumAleatorio(i, cartela);
            cartela[i] = numeroAleatorio;
        }

        return cartela;
    }


    public boolean verificarQuantidadeAcertos(TeleSena conjunto, int[] sequenciaSorteada){
        int teleSenaOrdenada[] = conjunto.getSorteioOrdenado(sequenciaSorteada);

        int acertosC1 = 0;
        int acertosC2 = 0;

        for(int i =0; i<sequenciaSorteada.length; i++){
            for (int j = 0; j<25; j++){
            if(teleSenaOrdenada[i] == conjunto.getConjunto1()[j]){
                acertosC1++;
            }
            if (teleSenaOrdenada[i] == conjunto.getConjunto2()[j]){
                acertosC2++;
            }
        }
        }
        if(acertosC1 == 25 || acertosC2 == 25 ){

            ganhador = true;
        }
        else {

            ganhador = false;
        }
        return ganhador;
    }
    public void imprimirCartelaSorteada(){

        System.out.println("-------------------------------------");
        System.out.println("          TELE SENA SORTEIO          ");
        System.out.println("-------------------------------------");

        for (int i = 0; i<sequenciaSorteada.length; i++){
            System.out.print(sequenciaSorteada[i]+ " ");
        }







    }
    public void  infoVendas(){

        System.out.println("INFORMAÇÕES VENDAS");
        System.out.println("------------------");
        System.out.println("Unidades Tele Sena vendidas: "+ totalTeleSenasCompradas);
        System.out.println("Valor unidade Tele Sena R$: "+ pessoas[0].getTeleSenasAdquiridas()[0].getValor());
        System.out.println("Valor Premiação Cada Ganhador R$: "+ premio);
        System.out.println("Lucros R$: "+ lucros);
        System.out.println("Valor total arrecadado R$:" + totalTeleSenasCompradas*pessoas[0].getTeleSenasAdquiridas()[0].getValor());
        System.out.println("Ganhadores: "+ ganhadores);


    }
}
