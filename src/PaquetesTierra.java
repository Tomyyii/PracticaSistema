public class PaquetesTierra extends Paquetes{
    private int DistanciaEnvio;
    private String TipoVehiculo;

    public PaquetesTierra(double peso, String destino, int ID, String estadoEnvio, boolean seguro, boolean entregaDia, int distanciaEnvio, String tipoVehiculo) {
        super(peso, destino, ID, estadoEnvio, seguro, entregaDia);
        DistanciaEnvio = distanciaEnvio;
        TipoVehiculo = tipoVehiculo;
    }

    public PaquetesTierra() {
    }

    public int getDistanciaEnvio() {
        return DistanciaEnvio;
    }

    public void setDistanciaEnvio(int distanciaEnvio) {
        DistanciaEnvio = distanciaEnvio;
    }

    public String getTipoVehiculo() {
        return TipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        TipoVehiculo = tipoVehiculo;
    }

    @Override
    public String toString() {
        return "PaquetesTierra{" +
                "DistanciaEnvio=" + DistanciaEnvio +
                ", TipoVehiculo='" + TipoVehiculo + '\'' +
                '}';
    }

    @Override
    public double calcularTarifaEnvio() {
        double TOTAL=0;
        TOTAL=getPeso()*25;
        if(getTipoVehiculo().equals("camion"))
        {
            TOTAL=TOTAL+(TOTAL*0.1);
        }

        if(getDistanciaEnvio()>100)
        {
            int DistanciaSumar=getDistanciaEnvio()-100;
            for(int i=0;i<DistanciaSumar;i++)
            {
                TOTAL=TOTAL+(TOTAL*0.05);
            }
        }
        return TOTAL;
    }

    @Override
    public void calcularCostoAdicional(double Total) {
        if(isEntregaDia()==true && isSeguro()==true)
        {
            Total=Total+(Total*0.25)+1500;

        } else if (isEntregaDia()==true && isSeguro()!=true) {
            Total=Total+(Total*0.25);
        }
        else if(isEntregaDia()!=true && isSeguro()==true)
        {
            Total=Total+1500;
        }
    }

    public double calcularTotal() {
        double Total=calcularTarifaEnvio();
        calcularCostoAdicional(Total);
        return Total;
    }
}
