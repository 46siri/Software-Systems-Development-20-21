package business;

public class Robot {
    private int id;
    private boolean estadoLivre;
    private Localizacao partida;
    private double velocidade = 0.2; // velocidade do robot em metros por segundo

    public Robot(int id, Localizacao partida) {
        this.id = id;
        this.estadoLivre = true;
        this.partida = partida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEstadoLivre() {
        return estadoLivre;
    }

    public void setEstadoLivre(boolean estadoLivre) {
        this.estadoLivre = estadoLivre;
    }

    public Localizacao getPartida() {
        return partida;
    }

    public void setPartida(Localizacao partida) {
        this.partida = partida;
    }

    public void fazEntrega(Localizacao destino) throws InterruptedException {
        //wait((long) (this.partida.percurso(this.partida.getPercurso(destino)) * this.velocidade));
        this.partida = destino;
    }


}
