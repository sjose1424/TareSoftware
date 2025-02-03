/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.sql.*;
import clases.Conexion;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.WindowConstants;
import javax.swing.*;

/**
 *
 * @author perse
 */
public class Administrador extends javax.swing.JFrame implements ActionListener {
    
    String user, nombre_usuario;
    public static int sesion_usuario;

    /**
     * Creates new form Administrador
     */
    public Administrador() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        user = Login.user;
        sesion_usuario = 1;
        
        setLayout(null);
        setTitle("Administrador_sesion_iniciada_de : " + user);
        getContentPane().setBackground(new Color(36, 36, 36));

        /*panel = new JPanel();
        panel.setBounds(0, 0, 1440, 900);
        panel.setBackground(new Color(46, 46, 46));
        add(panel);
         */
        panel_menu = new JPanel();
        panel_menu.setBounds(0, 0, 100, 900);
        panel_menu.setBackground(new Color(0, 0, 0));
        panel_menu.setLayout(null);
        add(panel_menu);
        
        ImageIcon wallpaper_screen = new ImageIcon("src/images/wallpaper_login.png");
        JLabel wallpaper_inicio = new JLabel(wallpaper_screen);
        wallpaper_inicio.setBounds(300, 60, 950, 950);
        wallpaper_inicio.setIcon(new ImageIcon(wallpaper_screen.getImage().getScaledInstance(950, 950, Image.SCALE_SMOOTH)));
        add(wallpaper_inicio);

        /*inicializar metodo para botones mouselistener*/
        getLabelimg();
        getLabelimgclient();
        getLabelimgcom();
        getLabelimgpro();
        getLabelimgsupp();
        getLabelimguser();
        getLabelimguser();
        getLabelimgvent();


        label_facturar = new JLabel("Facturar");
        label_facturar.setBounds(10, 150, 100, 30);
        label_facturar.setFont(new Font("SF Pro Rounded Bold", 1, 18));
        label_facturar.setForeground(new Color(255, 255, 255));
        panel_menu.add(label_facturar);
        
        label_producto = new JLabel("Productos");
        label_producto.setBounds(5, 265, 100, 30);
        label_producto.setFont(new Font("SF Pro Rounded Bold", 1, 18));
        label_producto.setForeground(new Color(255, 255, 255));
        panel_menu.add(label_producto);
        
        label_compras = new JLabel("Compras");
        label_compras.setBounds(7, 390, 100, 30);
        label_compras.setFont(new Font("SF Pro Rounded Bold", 1, 18));
        label_compras.setForeground(new Color(255, 255, 255));
        panel_menu.add(label_compras);
        
        label_clientes = new JLabel("Clientes");
        label_clientes.setBounds(10, 500, 100, 30);
        label_clientes.setFont(new Font("SF Pro Rounded Bold", 1, 18));
        label_clientes.setForeground(new Color(255, 255, 255));
        panel_menu.add(label_clientes);
        
        label_ventas = new JLabel("Ventas");
        label_ventas.setBounds(15, 620, 100, 30);
        label_ventas.setFont(new Font("SF Pro Rounded Bold", 1, 18));
        label_ventas.setForeground(new Color(255, 255, 255));
        panel_menu.add(label_ventas);
        
        label_suplidores = new JLabel("Suplidores");
        label_suplidores.setBounds(0, 755, 100, 30);
        label_suplidores.setFont(new Font("SF Pro Rounded Bold", 1, 18));
        label_suplidores.setForeground(new Color(255, 255, 255));
        panel_menu.add(label_suplidores);
        
        label_adduser = new JLabel("Usuarios");
        label_adduser.setBounds(1350, 95, 100, 30);
        label_adduser.setFont(new Font("SF Pro Rounded Bold", 1, 18));
        label_adduser.setForeground(new Color(255, 255, 255));
        add(label_adduser);
        
        nombre_usuariosesion = new JLabel(nombre_usuario);
        nombre_usuariosesion.setBounds(150, 15, 200, 30);
        nombre_usuariosesion.setFont(new Font("SF Pro Rounded Bold", 1, 24));
        nombre_usuariosesion.setForeground(new Color(255, 255, 255));
        add(nombre_usuariosesion);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        try {
            
            Connection bd = Conexion.conectar();
            
            PreparedStatement pst = bd.prepareStatement(
                    "select nombre_usuario from usuarios where username = '" + user + "'");
            
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                
                nombre_usuario = rs.getString("nombre_usuario");
                nombre_usuariosesion.setText(nombre_usuario);
                
            }
            
        } catch (Exception g) {
            
            System.err.println("error desde la interfaz de administrador");
            
        }
        
    }

    /*elementos*/
    JButton boton_menu, boton_facturar, boton_producto, boton_compras, boton_clientes,
            boton_ventas, boton_suplidores, boton_adduser;
    JPanel panel_menu;
    
    JLabel label_menu, label_facturar, label_producto, label_compras, label_clientes,
            label_ventas, label_suplidores, label_adduser, nombre_usuariosesion, img_menu, img_facturar, img_producto, img_compras, img_clientes,
            img_ventas, img_supplidores, img_adduser;
    
    @Override
    public Image getIconImage() {
        
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/loib.png"));
        return retValue;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1440, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1042, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
  
        
    }
    
    private JLabel getLabelimg() {
        
        ImageIcon wallpaper_imgfacturar = new ImageIcon("src/images/factimg.png");
        JLabel wallpaper_facturar = new JLabel(wallpaper_imgfacturar);
        wallpaper_facturar.setBounds(10, 80, 70, 70);
        wallpaper_facturar.setIcon(new ImageIcon(wallpaper_imgfacturar.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
        panel_menu.add(wallpaper_facturar);
        
        JPanel panelfact = new JPanel();
        panelfact.setBounds(5, 75, 90, 80);
        panelfact.setBackground(new Color(60, 60, 60));
        panelfact.setLayout(null);
        panel_menu.add(panelfact);
        panelfact.setVisible(false);
        
        wallpaper_facturar.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                
            }
            
            @Override
            public void mouseEntered(MouseEvent arg0) {
                
                panelfact.setVisible(true);
                
            }
            
            @Override
            public void mouseExited(MouseEvent arg0) {
                
                panelfact.setVisible(false);
                
            }
            
            @Override
            public void mousePressed(MouseEvent arg0) {
            }
            
            @Override
            public void mouseReleased(MouseEvent arg0) {
            }
        });
        
        return null;
        
    }
    
    private JLabel getLabelimgpro() {
        ImageIcon wallpaper_imgproductos = new ImageIcon("src/images/productosimg.png");
        JLabel wallpaper_productos = new JLabel(wallpaper_imgproductos);
        wallpaper_productos.setBounds(10, 200, 70, 70);
        wallpaper_productos.setIcon(new ImageIcon(wallpaper_imgproductos.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
        panel_menu.add(wallpaper_productos);
        
        JPanel panelpro = new JPanel();
        panelpro.setBounds(5, 200, 90, 72);
        panelpro.setBackground(new Color(60, 60, 60));
        panelpro.setLayout(null);
        panel_menu.add(panelpro);
        panelpro.setVisible(false);
        
        wallpaper_productos.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                
            }
            
            @Override
            public void mouseEntered(MouseEvent arg0) {
                
                panelpro.setVisible(true);
                
            }
            
            @Override
            public void mouseExited(MouseEvent arg0) {
                panelpro.setVisible(false);
                
            }
            
            @Override
            public void mousePressed(MouseEvent arg0) {
            }
            
            @Override
            public void mouseReleased(MouseEvent arg0) {
            }
        });
        
        return null;
        
    }
    
    private JLabel getLabelimgcom() {
        ImageIcon wallpaper_imgcompras = new ImageIcon("src/images/comprasimga.png");
        JLabel wallpaper_compras = new JLabel(wallpaper_imgcompras);
        wallpaper_compras.setBounds(10, 320, 70, 70);
        wallpaper_compras.setIcon(new ImageIcon(wallpaper_imgcompras.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
        panel_menu.add(wallpaper_compras);
        
        JPanel panelcomp = new JPanel();
        panelcomp.setBounds(5, 320, 90, 72);
        panelcomp.setBackground(new Color(60, 60, 60));
        panelcomp.setLayout(null);
        panel_menu.add(panelcomp);
        panelcomp.setVisible(false);
        
        wallpaper_compras.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                
            }
            
            @Override
            public void mouseEntered(MouseEvent arg0) {
                
                panelcomp.setVisible(true);
                
            }
            
            @Override
            public void mouseExited(MouseEvent arg0) {
                
                panelcomp.setVisible(false);
                
            }
            
            @Override
            public void mousePressed(MouseEvent arg0) {
            }
            
            @Override
            public void mouseReleased(MouseEvent arg0) {
            }
        });
        
        return null;
    }
    
    private JLabel getLabelimgclient() {
        
        ImageIcon wallpaper_imgclientes = new ImageIcon("src/images/clientesimg.png");
        JLabel wallpaper_clientes = new JLabel(wallpaper_imgclientes);
        wallpaper_clientes.setBounds(10, 430, 70, 70);
        wallpaper_clientes.setIcon(new ImageIcon(wallpaper_imgclientes.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
        panel_menu.add(wallpaper_clientes);
        
        JPanel panelclient = new JPanel();
        panelclient.setBounds(5, 430, 90, 72);
        panelclient.setBackground(new Color(60, 60, 60));
        panelclient.setLayout(null);
        panel_menu.add(panelclient);
        panelclient.setVisible(false);
        
        wallpaper_clientes.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                
            }
            
            @Override
            public void mouseEntered(MouseEvent arg0) {
                
                panelclient.setVisible(true);
                
            }
            
            @Override
            public void mouseExited(MouseEvent arg0) {
                
                panelclient.setVisible(false);
                
            }
            
            @Override
            public void mousePressed(MouseEvent arg0) {
            }
            
            @Override
            public void mouseReleased(MouseEvent arg0) {
            }
        });
        
        return null;
    }
    
    private JLabel getLabelimgvent() {
        
        ImageIcon wallpaper_imgventas = new ImageIcon("src/images/ventasimg.png");
        JLabel wallpaper_ventas = new JLabel(wallpaper_imgventas);
        wallpaper_ventas.setBounds(10, 555, 70, 70);
        wallpaper_ventas.setIcon(new ImageIcon(wallpaper_imgventas.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
        panel_menu.add(wallpaper_ventas);
        
           JPanel panelvent = new JPanel();
        panelvent.setBounds(5, 555, 90, 72);
        panelvent.setBackground(new Color(60, 60, 60));
        panelvent.setLayout(null);
        panel_menu.add(panelvent);
        panelvent.setVisible(false);

        
        wallpaper_ventas.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                
            }
            
            @Override
            public void mouseEntered(MouseEvent arg0) {
                panelvent.setVisible(true);
                
            }
            
            @Override
            public void mouseExited(MouseEvent arg0) {
            
            panelvent.setVisible(false);
                
            }
            
            @Override
            public void mousePressed(MouseEvent arg0) {
            }
            
            @Override
            public void mouseReleased(MouseEvent arg0) {
            }
        });
        
        return null;
    }
    
    private JLabel getLabelimgsupp() {
        ImageIcon wallpaper_imgsupplidores = new ImageIcon("src/images/suppimga.png");
        JLabel wallpaper_supplidores = new JLabel(wallpaper_imgsupplidores);
        wallpaper_supplidores.setBounds(10, 680, 70, 70);
        wallpaper_supplidores.setIcon(new ImageIcon(wallpaper_imgsupplidores.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
        panel_menu.add(wallpaper_supplidores);
        
           JPanel panelsupp = new JPanel();
        panelsupp.setBounds(5, 680, 90, 72);
        panelsupp.setBackground(new Color(60, 60, 60));
        panelsupp.setLayout(null);
        panel_menu.add(panelsupp);
        panelsupp.setVisible(false);

        
        wallpaper_supplidores.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                
            }
            
            @Override
            public void mouseEntered(MouseEvent arg0) {
                
                panelsupp.setVisible(true);
                
            }
            
            @Override
            public void mouseExited(MouseEvent arg0) {
                
                panelsupp.setVisible(false);
            }
            
            @Override
            public void mousePressed(MouseEvent arg0) {
            }
            
            @Override
            public void mouseReleased(MouseEvent arg0) {
            }
        });
        
        return null;
    }
    
    private JLabel getLabelimguser() {
        ImageIcon wallpaper_imgadduser = new ImageIcon("src/images/adduserimgt.png");
        JLabel wallpaper_adduser = new JLabel(wallpaper_imgadduser);
        wallpaper_adduser.setBounds(1350, 35, 70, 70);
        wallpaper_adduser.setIcon(new ImageIcon(wallpaper_imgadduser.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
        add(wallpaper_adduser);
        
           JPanel paneluser = new JPanel();  
        paneluser.setBounds(1340, 35, 90, 65);
        paneluser.setBackground(new Color(60, 60, 60));
        paneluser.setLayout(null);
        add(paneluser);
        paneluser.setVisible(false);

        
        wallpaper_adduser.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
                
                    administrar_usuarios Administrarusuarios = new administrar_usuarios();
            
            Administrarusuarios.setVisible(true);
                
            }
            
            @Override
            public void mouseEntered(MouseEvent arg0) {
                
                paneluser.setVisible(true);
                
                
            }
            
            @Override
            public void mouseExited(MouseEvent arg0) {
                
                paneluser.setVisible(false);
                
            }
            
            @Override
            public void mousePressed(MouseEvent arg0) {
            }
            
            @Override
            public void mouseReleased(MouseEvent arg0) {
            }
        });
        
        return null;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
