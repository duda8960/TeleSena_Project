import java.util.Arrays;

public class TeleSena {

   private double valor = 10.00;
   private int conjunto1[] = new int[25];
   private int conjunto2[] = new int[25];







   public TeleSena(){

   this.conjunto1 = getSorteioOrdenado(sortear(conjunto1));
   this.conjunto2 = getSorteioOrdenado(sortear(conjunto2));

   }
   public double getValor() {

      return valor;
   }

   public int[] getConjunto1() {
      return conjunto1;
   }

   public int[] getConjunto2() {
      return conjunto2;
   }
   public String toString(){
      String str;
      String cnj1 = " ";
      String cnj2 = " ";
      for (int i = 0; i<conjunto1.length; i++){
         cnj1 = cnj1 + conjunto1[i]+ " ";
         cnj2 = cnj2 + conjunto2[i] + " ";
      }
      str = ("-----------"+ "\n" + "Conjunto 1:" + cnj1+"\n" + "Conjunto 2:"+ cnj2+"\n" + "-----------");
      return str;


   }
   public int[] getSorteioOrdenado(int cartela[]){
      int sorteioOrdenado[] = Arrays.copyOf(cartela, cartela.length);

      Arrays.sort(sorteioOrdenado);

      return sorteioOrdenado;
   }

   public int[] sortear(int cartela[]){


      int numeroAleatorio;
      boolean numeroUnico;

      for(int i = 0; i<cartela.length; i ++){

         do{
            numeroAleatorio = (int)(Math.random()*60 +1);
            numeroUnico = true;


            for(int j = 0; j<i; j++) {
               if(cartela[j] == numeroAleatorio){
                  numeroUnico = false;
                  break;
               }


            }
         }while(!numeroUnico);
         cartela[i] = numeroAleatorio;
      }

      return cartela;
   }



}
