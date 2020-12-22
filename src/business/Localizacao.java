package business;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Localizacao {
    private int id;

    public Localizacao(int id) {
        this.id = id;
    }

    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Localizacao)) return false;
        Localizacao that = (Localizacao) o;
        return getId() == that.getId();
    }

    /*
    public List<Localizacao> getPercurso(Localizacao destino) {
        List<Localizacao> result = new ArrayList<>(){};
        if(this.equals(destino)) {
            result.add(destino);
        }else{
            int size = this.mapa.size();
            while (size > 0){ // verificar isto
                result.a (mapa.get(size).getNodo().getPercurso(destino));
            }
        }
        return result;
    }

    public int percurso(Localizacao destino){
        int result = 0;
        return result;
    }

    public void toLocalizacao(String local){
        this.zona = local.charAt(0);
        this.seccao = local.charAt(1);
        this.prateleira = local.charAt(2);
    }

    @Override
    public String toString(){return "Localização:" +this.zona + this.seccao + this.zona; }
*/

}
