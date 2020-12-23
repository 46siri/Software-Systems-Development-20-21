package business.gArmazem;

public class Prateleira{
    private String num;
    private int localizacao;
    private boolean estadoLivre;

   public Prateleira(String num, String local, Boolean estado) {
       this.num = num;
       //this.localizacao.toLocalizacao(local);
       this.estadoLivre = estado;
   }

   public String getNum(){return num;}
   public int getLocalizacao(){return localizacao;}
   public boolean getEstado(){return estadoLivre;}
}
