public abstract class Paquetes implements IPaquetes{
    private double Peso;
    private String Destino;
    private int ID;
    String EstadoEnvio;
    private boolean Seguro;
    private boolean EntregaDia;

    public Paquetes(double peso, String destino, int ID, String estadoEnvio, boolean seguro, boolean entregaDia) {
        Peso = peso;
        Destino = destino;
        this.ID = ID;
        EstadoEnvio = estadoEnvio;
        Seguro = seguro;
        EntregaDia = entregaDia;
    }

    public Paquetes() {
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double peso) {
        Peso = peso;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String destino) {
        Destino = destino;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEstadoEnvio() {
        return EstadoEnvio;
    }

    public void setEstadoEnvio(String estadoEnvio) {
        EstadoEnvio = estadoEnvio;
    }

    public boolean isSeguro() {
        return Seguro;
    }

    public void setSeguro(boolean seguro) {
        Seguro = seguro;
    }

    public boolean isEntregaDia() {
        return EntregaDia;
    }

    public void setEntregaDia(boolean entregaDia) {
        EntregaDia = entregaDia;
    }

    @Override
    public String toString() {
        return "Paquetes{" +
                "Peso=" + Peso +
                ", Destino='" + Destino + '\'' +
                ", ID=" + ID +
                ", EstadoEnvio='" + EstadoEnvio + '\'' +
                ", Seguro=" + Seguro +
                ", EntregaDia=" + EntregaDia +
                '}';
    }

    @Override


    public boolean equals(Object obj)
    {
        boolean rta=false;
        if(obj!=null)
        {
            if(obj instanceof Paquetes)
            {
                Paquetes paqueteAcomparar= (Paquetes) obj;
                if(getID()==paqueteAcomparar.getID())
                {
                    rta=true;
                }
            }
        }
        return rta;
    }

}
