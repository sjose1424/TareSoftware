
package clases;

import java.util.ArrayList;


public class Listadouser {
    
    ArrayList<Usuarios>lista;
    
    public Listadouser(){
    
        lista = new ArrayList();
    }
    
    public void agregarusuarios(Usuarios h){
        
        lista.add(h);
    
    }
}
