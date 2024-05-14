public class PaquetesAire extends Paquetes{
    private String Aerolinea;
    private String ClaseEnvio;

    public PaquetesAire(double peso, String destino, int ID, String estadoEnvio, boolean seguro, boolean entregaDia, String aerolinea, String claseEnvio) {
        super(peso, destino, ID, estadoEnvio, seguro, entregaDia);
        Aerolinea = aerolinea;
        ClaseEnvio = claseEnvio;
    }

    public PaquetesAire() {
    }

    public String getAerolinea() {
        return Aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        Aerolinea = aerolinea;
    }

    public String getClaseEnvio() {
        return ClaseEnvio;
    }

    public void setClaseEnvio(String claseEnvio) {
        ClaseEnvio = claseEnvio;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                "Aerolinea='" + Aerolinea + '\'' +
                ", ClaseEnvio='" + ClaseEnvio + '\'' +
                '}';
    }

    @Override
    public double calcularTarifaEnvio() {
        double TOTAL=0;
        TOTAL=getPeso()*25;
        if(getAerolinea().equals("AA"))
        {
            TOTAL=TOTAL+(TOTAL*0.5);
        }
        else if (getAerolinea().equals("express"))
        {
            TOTAL=TOTAL+1000;
        }
        return TOTAL;
    }

    @Override
    public void calcularCostoAdicional(double Total) {
        if(isEntregaDia()==true && isSeguro()==true)
        {
            Total=Total+(Total*0.5)+2500;

        } else if (isEntregaDia()==true && isSeguro()!=true) {
            Total=Total+(Total*0.5);
        }
        else if(isEntregaDia()!=true && isSeguro()==true)
        {
            Total=Total+2500;
        }
    }

    @Override
    public double calcularTotal() {
        double Total=calcularTarifaEnvio();
        calcularCostoAdicional(Total);
        return Total;
    }
}
