public class GerarNomes {
    private static final String[] nomes = {
            "Ana", "Bruno", "Carlos", "Daniela", "Eduardo", "Fernanda", "Julia",
            "Lucas", "Isabela", "João", "Eduarda", "Vinicius", "Mariana", "Nicolas",
            "Fábio", "Paulo", "Camila", "Renata", "Sophia", "Arthur", "Felipe",
            "Rodrigo", "Matheus", "Roberto", "Yasmin", "Amanda"
    };

    public static String gerarNome() {
        int i= (int) (Math.random() * nomes.length);
        return nomes[i];
    }
}

