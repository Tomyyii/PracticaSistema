import java.util.*;

public class Empresa {

    private String Nombre;
    private HashSet<Paquetes> paquetes;

    private HashMap<String, HashSet<Paquetes>> MapaPaquetes;


    public Empresa(String nombre) {
        Nombre = nombre;
        this.paquetes = new HashSet<>();
        MapaPaquetes = new HashMap<>();
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public HashSet<Paquetes> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(HashSet<Paquetes> paquetes) {
        this.paquetes = paquetes;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "Nombre='" + Nombre + '\'' +
                ", paquetes=" + paquetes +
                '}';
    }

    public void cargarPaquetes(Paquetes paquete) {
        HashSet<Paquetes> PaquetesEnviados = MapaPaquetes.getOrDefault("Enviado", new HashSet<>());
        HashSet<Paquetes> PaquetesNoEnviados = MapaPaquetes.getOrDefault("No Enviado", new HashSet<>());
        if (paquete.getEstadoEnvio().equals("Enviado")) {
            PaquetesEnviados.add(paquete);
            MapaPaquetes.put("Enviado", PaquetesEnviados);
        } else if (paquete.getEstadoEnvio().equals("No Enviado")) {
            PaquetesNoEnviados.add(paquete);
            MapaPaquetes.put("No Enviado", PaquetesNoEnviados);
        }
    }


    /*
    public boolean VerificarSiUnPaqueteFueEnviado(int ID)
    {
        boolean flag=false;
        Iterator<Map.Entry<String, HashSet<Paquetes>>> iterator=MapaPaquetes.entrySet().iterator();
        while (iterator.hasNext() && flag==false)
        {
            Map.Entry<String,HashSet<Paquetes>> entry=iterator.next();
            HashSet<Paquetes> set=entry.getValue();
            Iterator<Paquetes>iterator1=set.iterator();
            while (iterator1.hasNext() && flag==false)
            {
                Paquetes paquetes1=iterator1.next();
                if(paquetes1.getEstadoEnvio().equals("Enviado"))
                {
                    flag=true;
                }
            }
        }
        return flag;
    }
     */

    

}
