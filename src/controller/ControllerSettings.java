
package controller;
import vista.GestiondeUsuarios;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import vista.administrar_usuarios;
public class ControllerSettings implements MouseListener{

private final administrar_usuarios adminview;
    public ControllerSettings(administrar_usuarios adminview){

        this.adminview = adminview;
        this.adminview.label_todosuser.addMouseListener(this);
             
    
}

    @Override
    public void mouseClicked(MouseEvent e) {
        if(adminview.label_todosuser == null){
        
        
        if(e.getSource() == adminview.label_todosuser){
            
           GestiondeUsuarios gestion = new GestiondeUsuarios();
           gestion.setVisible(true);
           

            
    }
        }
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}