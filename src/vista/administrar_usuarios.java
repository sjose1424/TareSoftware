/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.event.*;
import clases.Conexion;

import com.mysql.cj.xdevapi.DbDoc;
import controller.ControllerSettings;
import java.awt.Graphics;
import java.awt.Label;
import java.util.HashSet;
import java.util.Set;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.*;

/**
 *
 * @author perse
 */
public class administrar_usuarios extends javax.swing.JFrame implements ActionListener, ItemListener, ChangeListener {

    static String string_statususer;
    public static int banderamdf;
    String user, tipo_usuario;

    Connection bd = Conexion.conectar();

    public administrar_usuarios() {
        initComponents();
        banderamdf = 0;
        user = Login.user;
        tipo_usuario = Login.tipo_usuario;

        setLayout(null);
        getContentPane().setBackground(new Color(48, 48, 48));
        setSize(600, 420);
        setTitle("Aministrar_Usuarios");
        setResizable(false);
        setLocation(105, 75);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        string_statususer = "Activo";

        /*administrar usuarios*/
        nombrenusuario = new JTextField();
        nombrenusuario.setBounds(25, 65, 150, 30);
        nombrenusuario.setFont(new Font("SF Pro Rounded Heavy", 1, 12));
        add(nombrenusuario);

        usernamenusuario = new JTextField();
        usernamenusuario.setBounds(25, 130, 150, 30);
        usernamenusuario.setFont(new Font("SF Pro Rounded Heavy", 1, 12));
        add(usernamenusuario);

        contrasenanusuario = new JPasswordField();
        contrasenanusuario.setBounds(225, 130, 150, 30);
        contrasenanusuario.setFont(new Font("SF Pro Rounded Heavy", 1, 12));
        add(contrasenanusuario);

        numerotelnusuario = new JTextField();
        numerotelnusuario.setBounds(25, 190, 150, 30);
        numerotelnusuario.setFont(new Font("SF Pro Rounded Heavy", 1, 12));
        add(numerotelnusuario);

        emailnusuario = new JTextField();
        emailnusuario.setBounds(225, 190, 200, 30);
        emailnusuario.setFont(new Font("SF Pro Rounded Heavy", 1, 12));
        add(emailnusuario);

        buscar_usuarios = new JTextField();
        buscar_usuarios.setBounds(335, 285, 150, 30);
        buscar_usuarios.setFont(new Font("SF Pro Rounded Heavy", 1, 12));
        add(buscar_usuarios);

        contrasenabandera = new JTextField();
        contrasenabandera.setBounds(225, 130, 150, 30);
        contrasenabandera.setFont(new Font("SF Pro Rounded Heavy", 1, 12));
        add(contrasenabandera);
        contrasenabandera.setVisible(false);
        
         registradopor = new JTextField();
        registradopor.setBounds(225, 65, 150, 30);
        registradopor.setFont(new Font("SF Pro Rounded Heavy", 1, 12));
        add(registradopor);
        registradopor.setEnabled(false);
      

        /*botones interfaz usuario*/
 /*ImageIcon boton_agguserimg = new ImageIcon("src/images/adduserimgc.png");
        boton_agguser = new JButton(boton_agguserimg);
        boton_agguser.setBounds(25, 260, 70, 70);
        boton_agguser.setBorder(null);
        boton_agguser.setBorderPainted(false);
        boton_agguser.setBackground(new Color(0, 0, 0));
        boton_agguser.setOpaque(true);
        boton_agguser.setIcon(new ImageIcon(boton_agguserimg.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
        add(boton_agguser);
        boton_agguser.addActionListener(this);
         */

 /*ImageIcon boton_deleteuserimg = new ImageIcon("src/images/deleteuserimg.png");
        boton_deleteuser = new JButton(boton_deleteuserimg);
        boton_deleteuser.setBounds(120, 260, 70, 70);
        boton_deleteuser.setBorder(null);
        boton_deleteuser.setBorderPainted(false);
        boton_deleteuser.setBackground(new Color(0, 0, 0));
        boton_deleteuser.setOpaque(true);
        boton_deleteuser.setIcon(new ImageIcon(boton_deleteuserimg.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
        boton_deleteuser.addActionListener(this);
        add(boton_deleteuser);  
         */
 /*ImageIcon boton_mduserimg = new ImageIcon("src/images/mdf.png");
        boton_mduser = new JButton(boton_mduserimg);
        boton_mduser.setBounds(215, 260, 70, 70);
        boton_mduser.setBorder(null);
        boton_mduser.setBorderPainted(false);
        boton_mduser.setBackground(new Color(0, 0, 0));
        boton_mduser.setOpaque(true);
        boton_mduser.setIcon(new ImageIcon(boton_mduserimg.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
        add(boton_mduser);
        boton_mduser.addActionListener(this);
         */
      /*  ImageIcon boton_buscaruserimg = new ImageIcon("src/images/buscar-us.png");
        boton_buscaruser = new JButton();
        boton_buscaruser.setBounds(495, 265, 70, 70);
        boton_buscaruser.setBorder(null);
        boton_buscaruser.setBorderPainted(false);
        boton_buscaruser.setBackground(new Color(0, 0, 0));
        boton_buscaruser.setOpaque(true);
        boton_buscaruser.setIcon(new ImageIcon(boton_buscaruserimg.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
        boton_buscaruser.addActionListener(this);
        add(boton_buscaruser);

        /*este es el codigo para los jcombobox
         */
        permisos = new JComboBox();
        permisos.setBounds(440, 190, 110, 30);
        add(permisos);

        permisos.addItem("Ninguno");
        permisos.addItem("Administrador");
        permisos.addItem("Estandar");
        permisos.addItemListener(this);

        /*  statususer = new JComboBox();
        statususer.setBounds(440, 225, 110, 30);
        add(statususer);
        
       /* statususer.addItem("Ninguno");
        statususer.addItem("Inactivo");
        statususer.addItem("Activo");
        statususer.addItemListener(this);
         */
 /*inicializar metodo  para mis botones y paneles*/
        getLabelnuevov();
        getLabeldaleteus();
        getLabelguardarus();
        getLabelbuscarus();
        
        

        statuscmb = new JComboBox();
        statuscmb.setBounds(390,100,80,30);
        add(statuscmb);
        
        
        statuscmb.addItem("Activo");
        statuscmb.addItem("Inactivo");
        
        /*combo_buscaruser.addItem("Todos");
        combo_buscaruser.additem()
        /*codigo para jlabels 
        
         */
        label_nombreusuario = new JLabel("Nombre :");
        label_nombreusuario.setBounds(25, 30, 200, 30);
        label_nombreusuario.setFont(new Font("SF Pro Rounded Heavy", 1, 18));
        label_nombreusuario.setForeground(new Color(255, 255, 255));
        add(label_nombreusuario);

        label_usernamenusuario = new JLabel("Usuario :");
        label_usernamenusuario.setBounds(25, 100, 150, 30);
        label_usernamenusuario.setFont(new Font("SF Pro Rounded Heavy", 1, 18));
        label_usernamenusuario.setForeground(new Color(255, 255, 255));
        add(label_usernamenusuario);

        label_contrasenausuario = new JLabel("Contraseña");
        label_contrasenausuario.setBounds(225, 100, 150, 30);
        label_contrasenausuario.setFont(new Font("SF Pro Rounded Heavy", 1, 18));
        label_contrasenausuario.setForeground(new Color(255, 255, 255));
        add(label_contrasenausuario);

        label_numerotelusuario = new JLabel("Telefono :");
        label_numerotelusuario.setBounds(25, 165, 150, 30);
        label_numerotelusuario.setFont(new Font("SF Pro Rounded Heavy", 1, 18));
        label_numerotelusuario.setForeground(new Color(255, 255, 255));
        add(label_numerotelusuario);

        label_emailusuario = new JLabel("Email :");
        label_emailusuario.setBounds(225, 165, 150, 30);
        label_emailusuario.setFont(new Font("SF Pro Rounded Heavy", 1, 18));
        label_emailusuario.setForeground(new Color(255, 255, 255));
        add(label_emailusuario);

        label_permisos = new JLabel("Permisos :");
        label_permisos.setBounds(440, 165, 150, 30);
        label_permisos.setFont(new Font("SF Pro Rounded Heavy", 1, 18));
        label_permisos.setForeground(new Color(255, 255, 255));
        add(label_permisos);

        label_agguser = new JLabel("Nuevo");
        label_agguser.setBounds(30, 330, 150, 30);
        label_agguser.setFont(new Font("SF Pro Rounded Heavy", 1, 18));
        label_agguser.setForeground(new Color(255, 255, 255));
        add(label_agguser);

        label_mdfuser = new JLabel("Guardar");
        label_mdfuser.setBounds(220, 330, 150, 30);
        label_mdfuser.setFont(new Font("SF Pro Rounded Heavy", 1, 18));
        label_mdfuser.setForeground(new Color(255, 255, 255));
        add(label_mdfuser);

        label_deleteusuario = new JLabel("Eliminar");
        label_deleteusuario.setBounds(120, 330, 150, 30);
        label_deleteusuario.setFont(new Font("SF Pro Rounded Heavy", 1, 18));
        label_deleteusuario.setForeground(new Color(255, 255, 255));
        add(label_deleteusuario);

        label_buscaruser = new JLabel("Buscar");
        label_buscaruser.setBounds(500, 340, 150, 30);
        label_buscaruser.setFont(new Font("SF Pro Rounded Heavy", 1, 18));
        label_buscaruser.setForeground(new Color(255, 255, 255));
        add(label_buscaruser);

        label_todosuser = new JLabel("Usuarios");
        label_todosuser.setBounds(455, 5, 150, 30);
        label_todosuser.setFont(new Font("SF Pro Rounded Heavy", 1, 18));
        label_todosuser.setForeground(new Color(255, 255, 255));
        add(label_todosuser);

        
         JLabel registradop = new JLabel("Registrado Por :");
        registradop.setBounds(235, 35, 150, 30);
        registradop.setFont(new Font("SF Pro Rounded Heavy", 1, 18));
        registradop.setForeground(new Color(255, 255, 255));
        add(registradop);
        
        
        
        ImageIcon wallpaper_updateuser = new ImageIcon("src/images/updateimguserdos.png");
        JLabel updateuser = new JLabel(wallpaper_updateuser);
        updateuser.setBounds(485, 80, 70, 70);
        updateuser.setIcon(new ImageIcon(wallpaper_updateuser.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
        add(updateuser);
        
        JPanel panelupdateuser = new JPanel();
        panelupdateuser.setBounds(482,80,80,70);
        panelupdateuser.setBackground(new Color(80,80,80));
        add(panelupdateuser);
        panelupdateuser.setVisible(false);
        
                
        updateuser.addMouseListener(new MouseAdapter(){
@Override

          public void mouseClicked(MouseEvent e){
          
              if(banderamdf == 1){
              
                  
              
              }
              
              
              
          }

@Override
          public void mouseEntered(MouseEvent e){
          
             panelupdateuser.setVisible(true);
          
          }     
          
@Override
          public void mouseExited(MouseEvent e){
              
              panelupdateuser.setVisible(false);
          
          
          
          }
});
        
        
        /*este es el codigo para jcheckbox*/
        getLabelTitulo();
        
        
        
        
        

    }
    /*mis elementos
    
     */

    JButton boton_agguser, boton_deleteuser,
            boton_mduser, boton_buscaruser;
    JLabel label_nombreusuario, label_apellidousuario, label_contrasenausuario, label_emailusuario, label_numerotelusuario, label_usernamenusuario, label_permisos, label_agguser, label_mdfuser,
            label_deleteusuario, label_buscaruser;
    public JLabel label_todosuser;
    public JTextField nombrenusuario, apellidonusuario, emailnusuario, numerotelnusuario,
            usernamenusuario, buscar_usuarios, contrasenabandera, registradopor;
JComboBox statuscmb;
    JPasswordField contrasenanusuario;
    JComboBox permisos, statususer, combo_buscaruser;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 701, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(administrar_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(administrar_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(administrar_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(administrar_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new administrar_usuarios().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    
    }
    @Override
    
    public void itemStateChanged(ItemEvent e) {

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    public void Limpiar() {

        nombrenusuario.setText("");

        usernamenusuario.setText("");
        emailnusuario.setText("");
        contrasenanusuario.setText("");
        numerotelnusuario.setText("");

        permisos.setSelectedIndex(0);

        nombrenusuario.setBackground(new Color(255, 255, 255));
        usernamenusuario.setBackground(new Color(255, 255, 255));
        emailnusuario.setBackground(new Color(255, 255, 255));
        contrasenanusuario.setBackground(new Color(255, 255, 255));
        numerotelnusuario.setBackground(new Color(255, 255, 255));
        buscar_usuarios.setText("");
        contrasenabandera.setText("");

        contrasenabandera.setVisible(false);
        contrasenanusuario.setVisible(true);

    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }

    private JLabel getLabelTitulo() {
        JLabel todouser = new JLabel();
        todouser.setBounds(460, 25, 150, 30);
        todouser.setFont(new Font("SF Pro Rounded Heavy", 1, 12));
        todouser.setForeground(new Color(255, 255, 255));
        add(todouser);

        JPanel panelback = new JPanel();
        panelback.setBounds(452, 30, 75, 20);
        panelback.setBackground(new Color(85, 80, 85));
        add(panelback);
        panelback.setVisible(false);

        todouser.setText("Ver Todos ");
        todouser.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {
                GestiondeUsuarios gestion = new GestiondeUsuarios();
                gestion.setVisible(true);

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {

                panelback.setVisible(true);

            }

            @Override
            public void mouseExited(MouseEvent arg0) {

                panelback.setVisible(false);

            }

            @Override
            public void mousePressed(MouseEvent arg0) {
            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
            }
        });

        return todouser;
    }

    private JLabel getLabelnuevov() {
        ImageIcon wallpaper_nuevoimg = new ImageIcon("src/images/adduserimgc.png");
        JLabel wallpaper_nuevov = new JLabel(wallpaper_nuevoimg);
        wallpaper_nuevov.setBounds(25, 260, 80, 80);
        wallpaper_nuevov.setIcon(new ImageIcon(wallpaper_nuevoimg.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        add(wallpaper_nuevov);

        JPanel panelnuevov = new JPanel();
        panelnuevov.setBounds(25, 260, 70, 70);
        panelnuevov.setBackground(new Color(60, 60, 60));
        panelnuevov.setLayout(null);
        add(panelnuevov);
        panelnuevov.setVisible(false);

        wallpaper_nuevov.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

                Limpiar();

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {

                panelnuevov.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent arg0) {

                panelnuevov.setVisible(false);

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

    private JLabel getLabeldaleteus() {

        ImageIcon wallpaper_deleteus = new ImageIcon("src/images/deleteuserimg.png");
        JLabel wallpaper_deleteuser = new JLabel(wallpaper_deleteus);
        wallpaper_deleteuser.setBounds(110, 250, 100, 100);
        wallpaper_deleteuser.setIcon(new ImageIcon(wallpaper_deleteus.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        add(wallpaper_deleteuser);

        JPanel paneldeleteus = new JPanel();
        paneldeleteus.setBounds(125, 260, 70, 70);
        paneldeleteus.setBackground(new Color(60, 60, 60));
        paneldeleteus.setLayout(null);
        add(paneldeleteus);
        paneldeleteus.setVisible(false);

        wallpaper_deleteuser.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {



            }

            @Override
            public void mouseEntered(MouseEvent arg0) {

                paneldeleteus.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent arg0) {

                paneldeleteus.setVisible(false);

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

    private JLabel getLabelguardarus() {

        ImageIcon wallpaper_guardarus = new ImageIcon("src/images/mdf.png");
        JLabel wallpaper_guardaruser = new JLabel(wallpaper_guardarus);
        wallpaper_guardaruser.setBounds(215, 260, 85, 85);
        wallpaper_guardaruser.setIcon(new ImageIcon(wallpaper_guardarus.getImage().getScaledInstance(85, 85, Image.SCALE_SMOOTH)));
        add(wallpaper_guardaruser);

        JPanel panelguardarus = new JPanel();
        panelguardarus.setBounds(220, 260, 70, 70);
        panelguardarus.setBackground(new Color(60, 60, 60));
        panelguardarus.setLayout(null);
        add(panelguardarus);
        panelguardarus.setVisible(false);

        wallpaper_guardaruser.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

                   int permisos_cmb, statususcmb = 0, validacion = 0;
        String permisos_string = "", status_us = "", nombre_usuario, apellido_usuario, usernameusuario, email_usuario, contrasena_usuario,
                telefono_usuario;

     

            nombre_usuario = nombrenusuario.getText().trim();

            usernameusuario = usernamenusuario.getText().trim();

            email_usuario = emailnusuario.getText().trim();

            contrasena_usuario = contrasenanusuario.getText().trim();

            telefono_usuario = numerotelnusuario.getText().trim();

            permisos_cmb = permisos.getSelectedIndex() + 1;
            
            statususcmb = statuscmb.getSelectedIndex()+ 1;
            

            if (nombre_usuario.equals("")) {

                nombrenusuario.setBackground(new Color(255, 0, 0));
                validacion++;
            }

            if (usernameusuario.equals("")) {

                usernamenusuario.setBackground(new Color(255, 0, 0));
                validacion++;

            }

            if (email_usuario.equals("")) {

                emailnusuario.setBackground(new Color(255, 0, 0));
                validacion++;

            }

            if (contrasena_usuario.equals("")) {

                contrasenanusuario.setBackground(new Color(255, 0, 0));
                validacion++;

            }

            if (telefono_usuario.equals("")) {

                numerotelnusuario.setBackground(new Color(255, 0, 0));
                validacion++;
            }

            if (permisos_cmb == 1) {

                permisos_string = "Ninguno";

            } else if (permisos_cmb == 2) {

                permisos_string = "Administrador";

            } else if (permisos_cmb == 3) {

                permisos_string = "Estandar";

            }
            
            if(statususcmb == 1){
                
                status_us = "Activo";
            
            }else if(statususcmb == 2){
            
            
                status_us = "Inactivo";
            }
            try {
                Connection conn = Conexion.conectar();
                PreparedStatement pst = conn.prepareStatement(
                        "select username from usuarios where username = '" + usernameusuario + "'");

                ResultSet rss = pst.executeQuery();

                if (rss.next()) {

                    usernamenusuario.setBackground(new Color(255, 0, 0));
                    JOptionPane.showMessageDialog(null, "El nombre de usuario  ya existe!");

                    conn.close();
                } else {
                    conn.close();

                    if (validacion == 0) {

                        try {
                            Connection conndos = Conexion.conectar();
                            PreparedStatement pstdos = conndos.prepareStatement(
                                    "insert into usuarios values (?,?,?,?,?,?,?,?,?)");

                            pstdos.setInt(1, 0);
                            pstdos.setString(2, nombre_usuario);
                            pstdos.setString(3, contrasena_usuario);
                            pstdos.setString(4, usernameusuario);
                            pstdos.setString(5, telefono_usuario);
                            pstdos.setString(6, status_us);
                            pstdos.setString(7, permisos_string);
                            pstdos.setString(8, email_usuario);
                            pstdos.setString(9, user);
                            pstdos.executeUpdate();

                            conndos.close();

                            Limpiar();

                            nombrenusuario.setBackground(new Color(0, 255, 0));
                            usernamenusuario.setBackground(new Color(0, 255, 0));
                            emailnusuario.setBackground(new Color(0, 255, 0));
                            contrasenanusuario.setBackground(new Color(0, 255, 0));
                            numerotelnusuario.setBackground(new Color(0, 255, 0));

                            JOptionPane.showMessageDialog(null, "Registro de usuario completado Sastifactoriamente");

                        } catch (SQLException g) {
                            System.err.println("Error al registrar usuario." + g);
                            JOptionPane.showMessageDialog(null, "ERROR al registrar!! Contacte al ADMINISTRADOR");
                        }
                    } else {

                        JOptionPane.showMessageDialog(null, "Debes de llenar todos  los campos.");

                    }

                }

            } catch (SQLException g) {
                System.err.println("error en validar nombre de usuario" + g);
                JOptionPane.showMessageDialog(null, "ERROR, la validacion de usuario  no funciona, por favor"
                        + "contactar al administrador");
            }

        }

            

            @Override
            public void mouseEntered(MouseEvent arg0) {

                panelguardarus.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent arg0) {

                panelguardarus.setVisible(false);

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
    
    
      private JLabel getLabelbuscarus() {


        ImageIcon wallpaper_buscarus = new ImageIcon("src/images/buscuatro.png");
        JLabel wallpaper_buscaruser = new JLabel(wallpaper_buscarus);
        wallpaper_buscaruser.setBounds(495, 265, 70, 70);
        wallpaper_buscaruser.setIcon(new ImageIcon(wallpaper_buscarus.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
        add(wallpaper_buscaruser);

        JPanel panelbuscarus = new JPanel();
        panelbuscarus.setBounds(495, 265, 70, 70);
        panelbuscarus.setBackground(new Color(60, 60, 60));
        panelbuscarus.setLayout(null);
        add(panelbuscarus);
        panelbuscarus.setVisible(false);

        wallpaper_buscaruser.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

                 String buscarusuarios;

   

            buscarusuarios = buscar_usuarios.getText().trim();

            if (buscarusuarios.equalsIgnoreCase("")) {

                GestiondeUsuarios gestionusuario = new GestiondeUsuarios();
                gestionusuario.setVisible(true);
                
               dispose();

            } else {

                try {
                    Connection conntres = Conexion.conectar();
                    PreparedStatement psttres = conntres.prepareStatement(
                            "select nombre_usuario, tipo_usuario, password_usuario,registrado_por, status_usuario, username, telefono_usuario, email from usuarios"
                            + " where username = '" + buscarusuarios + "'");

                    ResultSet rsttres = psttres.executeQuery();

                    if (rsttres.next()) {

                        String nombreusuario = rsttres.getString("nombre_usuario");
                        String passwordusuario = rsttres.getString("password_usuario");
                        String username = rsttres.getString("username");
                        String telefonousuario = rsttres.getString("telefono_usuario");
                        String email = rsttres.getString("email");
                        String registropor = rsttres.getString("registrado_por");
                        String tipouser = rsttres.getString("tipo_usuario");
                        contrasenanusuario.setText(passwordusuario);
                        String pass = new String(contrasenanusuario.getPassword());

                        nombrenusuario.setText(nombreusuario);
                        usernamenusuario.setText(username);
                        emailnusuario.setText(email);
                        contrasenanusuario.setVisible(false);
                        contrasenabandera.setVisible(true);
                        contrasenabandera.setText(pass);
                        numerotelnusuario.setText(telefonousuario);
                        registradopor.setText(registropor);
                        statuscmb.setSelectedItem(rsttres.getString("status_usuario"));
                        permisos.setSelectedItem(rsttres.getString("tipo_usuario"));
                        
             
                  
                    } else {

                        JOptionPane.showMessageDialog(null,
                                "Usuario no encontrado o no existente, por favor introduzca un nombre de usuario valido");

                    }

                } catch (SQLException g) {

                    System.err.println("no se puedo realizar la busqueda en la base de dato" + g);
                    JOptionPane.showConfirmDialog(null, "la conexion nos e realizo con exito, por favor contacte al administrador");

                }

            }

                String contrabande = contrasenabandera.getText().trim();

                    if(contrabande.equals("")){

            contrasenabandera.setVisible(false);
            contrasenanusuario.setVisible(true);

        }
        }

  

    


            

            @Override
            public void mouseEntered(MouseEvent arg0) {

                panelbuscarus.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent arg0) {

                panelbuscarus.setVisible(false);

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
}