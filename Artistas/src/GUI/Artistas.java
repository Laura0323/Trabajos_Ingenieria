package GUI;

import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Artistas extends javax.swing.JFrame {

    public Artistas() {
        initComponents();
    }

    //Crear la variable para manipular el archivo
    File archivo;
    File archivo2;

    //Crear el array para almacenar los datos de la linea del archivo
    String[] cadena;
    String[] cadena2;

    //Crear el modelo para la tabla
    DefaultTableModel modeloTabla = new DefaultTableModel();

    //Método para escribir los datos en el archivo
    public void Escribir(String cc, String nom, String gen, String cos) {
        try {
            //Indicar cual es el archivo a escribir
            archivo = new File("./src/Recursos/Artistas.txt");
            //Crear el stream de datos de escritura
            //FileWriter escritor=new FileWriter(archivo);//Sobre escribir
            FileWriter escritor = new FileWriter(archivo, true);//Añadir datos
            //Crear el buffer de escritura
            PrintWriter pw = new PrintWriter(escritor);

            //Guardar o escribir los datos en el archivo
            pw.println(cc + "," + nom + "," + gen + "," + cos);
            JOptionPane.showMessageDialog(null, "Se han registrado los datos en el archivo");
            pw.close();//Cerrar el archivo
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//Cierre del metodo

    public void Escribir2(String cc, String nom, String vHora, String hContra) {
        if (!CCB.equals(null) && !hContra.equals(null)) {
            try {
                //Indicar cual es el archivo a escribir
                archivo2 = new File("./src/Recursos/Ventas.txt");
                //Crear el stream de datos de escritura
                //FileWriter escritor=new FileWriter(archivo);//Sobre escribir
                FileWriter escritor = new FileWriter(archivo2, true);//Añadir datos
                //Crear el buffer de escritura
                PrintWriter pw = new PrintWriter(escritor);

                //Guardar o escribir los datos en el archivo
                int x = Integer.parseInt(vHora);
                int y = Integer.parseInt(hContra);
                int z = x * y;
                Total.setText(String.valueOf(z));
                pw.println(cc + "," + nom + "," + vHora + "," + hContra + "," + z);
                JOptionPane.showMessageDialog(null, "Se han registrado los datos en el archivo");
                pw.close(); //Cerrar el archivo 
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No puedes registrar nada si no tienes una busqueda y un numero de horas");
        }
    }

    public void Buscar(String cc) {
        try {
            //Indicar el archivo a leer
            archivo = new File("./src/Recursos/Artistas.txt");
            //Crear el stream de datos para lectura
            FileReader lector = new FileReader(archivo);
            //Crear el buffer de lectura
            BufferedReader buffer = new BufferedReader(lector);//Para poder leer en el archivo
            String linea; //Traer cada linea del archivo
            boolean encontro = false; //Algoritmo de busqueda
            //Recorrer todo el archivo
            while ((linea = buffer.readLine()) != null) {
                //Recortar la línea con SPLIT y lo almacenar en array cadena
                cadena = linea.split(",");
                //Validar si el cliente está en el vector
                if (cc.equals(cadena[0])) {
                    encontro = true;
                    break;
                } else {
                    encontro = false;
                }
            }//Cierre del while
            if (encontro) {
                Nombre.setText(cadena[1]);
                GeneroR.setText(cadena[2]);
                cHora.setText(cadena[3]);
            } else {
                JOptionPane.showMessageDialog(null, "El Artista no está registrado ");
            }
            lector.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void Buscar2(String cc) {
        try {
            //Indicar el archivo a leer
            archivo = new File("./src/Recursos/Artistas.txt");
            //Crear el stream de datos para lectura
            FileReader lector = new FileReader(archivo);
            //Crear el buffer de lectura
            BufferedReader buffer = new BufferedReader(lector);//Para poder leer en el archivo
            String linea; //Traer cada linea del archivo
            boolean encontro = false; //Algoritmo de busqueda
            //Recorrer todo el archivo
            while ((linea = buffer.readLine()) != null) {
                //Recortar la línea con SPLIT y lo almacenar en array cadena
                cadena = linea.split(",");
                //Validar si el cliente está en el vector
                if (cc.equals(cadena[0])) {
                    encontro = true;
                    break;
                } else {
                    encontro = false;
                }
            }//Cierre del while
            if (encontro) {
                NombreB.setText(cadena[1]);
                GeneroR.setText(cadena[2]);
                vHora.setText(cadena[3]);
            } else {
                JOptionPane.showMessageDialog(null, "El Artista no está registrado ");
            }
            lector.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void Actualizar(String cc, String nom, String gen, String cos) {
        //Las variables para el manejo del archivo original (agenda.txt)
        File archivo = null;
        FileReader lector = null;
        BufferedReader br = null;

        //Las variables para el manejo del archivo auxiliar (auxiliar.txt)
        File archAux = null;
        FileWriter auxiliar = null;
        PrintWriter pwAux = null;

        try {
            //Abrir el archivo orinal para leer sus datos
            archivo = new File("./src/Recursos/Artistas.txt");
            lector = new FileReader(archivo);
            br = new BufferedReader(lector);

            //Abrir el archivo auxiliar para escribir datos
            archAux = new File("./src/Recursos/auxiliar.txt");
            auxiliar = new FileWriter(archAux, true);
            pwAux = new PrintWriter(auxiliar);

            String linea;
            boolean encontro = false;
            while ((linea = br.readLine()) != null) {
                cadena = linea.split(",");
                if (!cc.equals(cadena[0])) {
                    //Modificar los datos del cliente
                    pwAux.println(cc + "," + nom + "," + gen + "," + cos);
                    encontro = true;
                } else {
                    pwAux.println(cadena[0] + "," + cadena[1] + "," + cadena[2] + "," + cadena[3]);
                }
            }//Cierre del while
            if (encontro) {
                JOptionPane.showMessageDialog(null, "Se han actualizado los datos en el archivo");
            } else {
                JOptionPane.showMessageDialog(null, "No se actualizaron los datos en el archivo");
            }
            lector.close();
            pwAux.close();//Cerrar el archivo
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        //Borrar el archivo original (agenda.txt)
        archivo.delete();
        //Renombrar el archivo auxiliar.txt por agenda.txt
        boolean success = archAux.renameTo(archivo);
        if (!success) {
            JOptionPane.showMessageDialog(null, "Imposible renombrar el archivo ");
        }
    }//Cierre del metodo

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        CC = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Nombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Genero = new javax.swing.JComboBox<>();
        GeneroR = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cHora = new javax.swing.JTextField();
        Agregar = new javax.swing.JButton();
        Buscar = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        CCB = new javax.swing.JTextField();
        Find = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        NombreB = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        vHora = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        hContra = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        Ventas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Contratación de artistas");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Artista", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Identificación:");

        CC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Nombre Completo:");

        Nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Género Artístico:");

        Genero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pop", "Rock", "Reggeton", "Trap", "Indie", "Salsa", "Jazz", "Clasica" }));
        Genero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                GeneroItemStateChanged(evt);
            }
        });

        GeneroR.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Costo Hora Función:");

        cHora.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Agregar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Agregar.setText("Agregar");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        Buscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        Actualizar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(33, 33, 33))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(12, 12, 12)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Nombre)
                            .addComponent(CC, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(Genero, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(GeneroR, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Agregar)
                            .addComponent(jLabel6))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(Buscar)
                                .addGap(39, 39, 39)
                                .addComponent(Actualizar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cHora, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GeneroR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Agregar)
                    .addComponent(Buscar)
                    .addComponent(Actualizar))
                .addGap(35, 35, 35))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Venta de Funciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Identificación:");

        CCB.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCBActionPerformed(evt);
            }
        });

        Find.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Find.setText("Buscar ");
        Find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Nombre Completo:");

        NombreB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        NombreB.setForeground(new java.awt.Color(51, 51, 255));
        NombreB.setText("?");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Valor Hora:");

        vHora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        vHora.setForeground(new java.awt.Color(51, 51, 255));
        vHora.setText("0");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Horas contratadas:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Valor a pagar:");

        Total.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Total.setForeground(new java.awt.Color(0, 0, 255));
        Total.setText("0");

        Ventas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Ventas.setText("Registrar ventas");
        Ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(CCB, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(Find))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NombreB, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(vHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(47, 47, 47))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(hContra, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addGap(11, 11, 11)
                                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(Ventas)))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(CCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Find))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(NombreB))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(vHora))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(hContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(Total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(Ventas)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addComponent(jLabel1)))
                .addGap(0, 57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GeneroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_GeneroItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_GeneroItemStateChanged

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        Escribir(CC.getText(), Nombre.getText(), Genero.getSelectedItem().toString(), cHora.getText());
    }//GEN-LAST:event_AgregarActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        Buscar(CC.getText());
    }//GEN-LAST:event_BuscarActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        Actualizar(CC.getText(), Nombre.getText(), Genero.getSelectedItem().toString(), cHora.getText());
    }//GEN-LAST:event_ActualizarActionPerformed

    private void FindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindActionPerformed
        Buscar2(CCB.getText());
    }//GEN-LAST:event_FindActionPerformed

    private void CCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CCBActionPerformed

    private void VentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentasActionPerformed
        Escribir2(CCB.getText(), NombreB.getText(), vHora.getText(), hContra.getText());
    }//GEN-LAST:event_VentasActionPerformed

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
            java.util.logging.Logger.getLogger(Artistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Artistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Artistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Artistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Artistas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton Agregar;
    private javax.swing.JButton Buscar;
    private javax.swing.JTextField CC;
    private javax.swing.JTextField CCB;
    private javax.swing.JButton Find;
    private javax.swing.JComboBox<String> Genero;
    private javax.swing.JTextField GeneroR;
    private javax.swing.JTextField Nombre;
    private javax.swing.JLabel NombreB;
    private javax.swing.JLabel Total;
    private javax.swing.JButton Ventas;
    private javax.swing.JTextField cHora;
    private javax.swing.JTextField hContra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel vHora;
    // End of variables declaration//GEN-END:variables
}
