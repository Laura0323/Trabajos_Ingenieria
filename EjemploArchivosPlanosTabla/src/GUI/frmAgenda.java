package GUI;

//Importar el paquete para trabajar archivos
import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmAgenda extends javax.swing.JFrame {

    /**
     * Creates new form frmAgenda
     */
    public frmAgenda() {
        initComponents();
    }
    
    //Crear la variable para manipular el archivo
    File archivo;
    
    //Crear el array para almacenar los datos de la linea del archivo
    String[] cadena;
    
    //Crear el modelo para la tabla
    DefaultTableModel modeloTabla=new DefaultTableModel();
    
    //Método para listar los datos en la tabla
    public void Listar(){
        File archivo=null;
        FileReader lector=null;
        BufferedReader br=null;
        //Limpiar la tabla
        modeloTabla.setRowCount(0);
        try{
            //Indicar el archivo a leer
            archivo=new File("./src/Recursos/agenda.txt");
            //Crear el stream de datos para lectura
            lector=new FileReader(archivo);
            //Crear el buffer de lectura
            br=new BufferedReader(lector);//Para poder leer en el archivo
            String linea; //Traer cada linea del archivo
            
            //Crear un array para los titulo de la tabla
            String[] titulos={"Codigo","Nombre","Apellido"};
            modeloTabla.setColumnIdentifiers(titulos);
            Object[] fila=new Object[modeloTabla.getColumnCount()];
            
            //Recorrer todo el archivo
            while((linea=br.readLine())!=null){
                cadena=linea.split(",");
                modeloTabla.addRow(cadena);
            }//Cierre del while
            tblDatos.setModel(modeloTabla);
            lector.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error: " + e.getMessage());
        }
    }
    
    //Método para escribir los datos en el archivo
    public void Escribir(String cod,String nom,String ape){
        try{
            //Indicar cual es el archivo a escribir
            archivo=new File("./src/Recursos/agenda.txt");
            //Crear el stream de datos de escritura
            //FileWriter escritor=new FileWriter(archivo);//Sobre escribir
            FileWriter escritor=new FileWriter(archivo,true);//Añadir datos
            //Crear el buffer de escritura
            PrintWriter pw=new PrintWriter(escritor);
            
            //Guardar o escribir los datos en el archivo
            pw.println(cod + "," + nom + "," + ape);
            JOptionPane.showMessageDialog(null,"Se han registrado los datos en el archivo");
            pw.close();//Cerrar el archivo
        }catch(IOException e){
                JOptionPane.showMessageDialog(null,"Error: " + e.getMessage());
        }
    }//Cierre del metodo
    
    //Método para buscar un dato en el archivo
    public void Buscar(String cod){
        try{
            //Indicar el archivo a leer
            archivo=new File("./src/Recursos/agenda.txt");
            //Crear el stream de datos para lectura
            FileReader lector=new FileReader(archivo);
            //Crear el buffer de lectura
            BufferedReader buffer=new BufferedReader(lector);//Para poder leer en el archivo
            String linea; //Traer cada linea del archivo
            boolean encontro=false; //Algoritmo de busqueda
            //Recorrer todo el archivo
            while((linea=buffer.readLine())!=null){
                //Recortar la línea con SPLIT y lo almacenar en array cadena
                cadena=linea.split(",");
                //Validar si el cliente está en el vector
                if(cod.equals(cadena[0])){
                    encontro=true;
                    break;
                }else{
                    encontro=false;
                }
            }//Cierre del while
            if(encontro){
                txtNom.setText(cadena[1]);
                txtApe.setText(cadena[2]);
            }else{
                JOptionPane.showMessageDialog(null,"El cliente no está registrado ");
            }
            lector.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error: " + e.getMessage());
        }
    }//Cierre del metodo
    
    //Método para actualizar los datos en el archivo
    public void Actualizar(String cod,String nom,String ape){
        //Las variables para el manejo del archivo original (agenda.txt)
        File archivo=null;
        FileReader lector=null;
        BufferedReader br=null;
        
        //Las variables para el manejo del archivo auxiliar (auxiliar.txt)
        File archAux=null;
        FileWriter auxiliar=null;
        PrintWriter pwAux=null;
 
        try{
            //Abrir el archivo orinal para leer sus datos
            archivo=new File("./src/Recursos/agenda.txt");
            lector=new FileReader(archivo);
            br=new BufferedReader(lector);
            
            //Abrir el archivo auxiliar para escribir datos
            archAux=new File("./src/Recursos/auxiliar.txt");
            auxiliar=new FileWriter(archAux,true);
            pwAux=new PrintWriter(auxiliar);
            
            String linea;
            boolean encontro=false;
            while((linea=br.readLine())!=null){
                cadena=linea.split(",");
                if(cod.equals(cadena[0])){
                    //Modificar los datos del cliente
                    pwAux.println(cod + "," + nom + "," + ape);
                    encontro=true;
                }else{
                    pwAux.println(cadena[0] + ","+ cadena[1] + "," + cadena[2]);
                }
            }//Cierre del while
            if(encontro){
               JOptionPane.showMessageDialog(null,"Se han actualizado los datos en el archivo"); 
            }else{
                JOptionPane.showMessageDialog(null,"No se actualizaron los datos en el archivo");
            }
            lector.close();
            pwAux.close();//Cerrar el archivo
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error: " + e.getMessage());
        }
        //Borrar el archivo original (agenda.txt)
        archivo.delete();
        //Renombrar el archivo auxiliar.txt por agenda.txt
        boolean success=archAux.renameTo(archivo);
        if(!success){
            JOptionPane.showMessageDialog(null,"Imposible renombrar el archivo ");
        }
    }//Cierre del metodo
    
    
    //Método para eliminar los datos en el archivo
    public void Eliminar(String cod){
        //Las variables para el manejo del archivo original (agenda.txt)
        File archivo=null;
        FileReader lector=null;
        BufferedReader br=null;
        
        //Las variables para el manejo del archivo auxiliar (auxiliar.txt)
        File archAux=null;
        FileWriter auxiliar=null;
        PrintWriter pwAux=null;
 
        try{
            //Abrir el archivo orinal para leer sus datos
            archivo=new File("./src/Recursos/agenda.txt");
            lector=new FileReader(archivo);
            br=new BufferedReader(lector);
            
            //Abrir el archivo auxiliar para escribir datos
            archAux=new File("./src/Recursos/auxiliar.txt");
            auxiliar=new FileWriter(archAux,true);
            pwAux=new PrintWriter(auxiliar);
            
            String linea;
            boolean encontro=false;
            while((linea=br.readLine())!=null){
                cadena=linea.split(",");
                if(!cod.equals(cadena[0])){
                   pwAux.println(cadena[0] + ","+ cadena[1] + "," + cadena[2]);
                }
            }//Cierre del while
            JOptionPane.showMessageDialog(null,"Se han eliminado los datos en el archivo"); 
            lector.close();
            pwAux.close();//Cerrar el archivo
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error: " + e.getMessage());
        }
        //Borrar el archivo original (agenda.txt)
        archivo.delete();
        //Renombrar el archivo auxiliar.txt por agenda.txt
        boolean success=archAux.renameTo(archivo);
        if(!success){
            JOptionPane.showMessageDialog(null,"Imposible renombrar el archivo ");
        }
    }//Cierre del metodo
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApe = new javax.swing.JTextField();
        pnlTransaccion = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnListado = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda de Clientes");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Agenda de Clientes");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Código:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Apellido:");

        pnlTransaccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnListado.setText("Listado");
        btnListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTransaccionLayout = new javax.swing.GroupLayout(pnlTransaccion);
        pnlTransaccion.setLayout(pnlTransaccionLayout);
        pnlTransaccionLayout.setHorizontalGroup(
            pnlTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTransaccionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTransaccionLayout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTransaccionLayout.createSequentialGroup()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnListado, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        pnlTransaccionLayout.setVerticalGroup(
            pnlTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTransaccionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnActualizar)
                    .addComponent(btnSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnEliminar)
                    .addComponent(btnListado))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Listado de Clientes:");

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDatosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDatos);

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtApe, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5))
                                .addGap(36, 36, 36)
                                .addComponent(pnlTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(pnlTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       Escribir(txtCod.getText(),txtNom.getText(),txtApe.getText());
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Buscar(txtCod.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
       Actualizar(txtCod.getText(),txtNom.getText(),txtApe.getText());
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Eliminar(txtCod.getText());
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListadoActionPerformed
        Listar();
    }//GEN-LAST:event_btnListadoActionPerformed

    private void tblDatosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMousePressed
        if(evt.getClickCount()==1){
            txtCod.setText(tblDatos.getValueAt(tblDatos.getSelectedRow(), 0).toString());
            txtNom.setText(tblDatos.getValueAt(tblDatos.getSelectedRow(), 1).toString());
            txtApe.setText(tblDatos.getValueAt(tblDatos.getSelectedRow(), 2).toString());
        }
    }//GEN-LAST:event_tblDatosMousePressed

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
            java.util.logging.Logger.getLogger(frmAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAgenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnListado;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlTransaccion;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtApe;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtNom;
    // End of variables declaration//GEN-END:variables
}
