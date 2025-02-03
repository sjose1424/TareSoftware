
package clases;


public class Usuarios {

    public Usuarios() {
    }
    
    
    
  private  int id;
   private String  nom_user;

    public Usuarios(int id, String nom_user) {
        this.id = id;
        this.nom_user = nom_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_user() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }
   
   
   
   
}
