import java.util.Random;

public class Pessoa {
    private String nome;
    private double premiacao;
    Random random = new Random();
    private int quantidadeAdquirida = random.nextInt(14) + 1;
    private TeleSena[] teleSenasAdquiridas = new TeleSena[quantidadeAdquirida];

    public Pessoa(String nome){
        this.nome = nome;
        this.premiacao = 0.0;

        for (int i = 0; i<teleSenasAdquiridas.length; i++){
            teleSenasAdquiridas[i] = new TeleSena();
        }


    }


    public TeleSena[] getTeleSenasAdquiridas() {
     return teleSenasAdquiridas;
    }

    public int getQuantidadeAdquirida() {

        return quantidadeAdquirida;
    }


    public String toString() {
        return "Nome : " + nome+"\n"+ "Tele Senas compradas: "+ quantidadeAdquirida;
    }
}

