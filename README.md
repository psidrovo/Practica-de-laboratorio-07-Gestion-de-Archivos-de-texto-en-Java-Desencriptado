# Practica-de-laboratorio-07-Gestion-de-Archivos-de-texto-en-Java-Desencriptado
Practica-de-laboratorio-07-Gestion-de-Archivos-de-texto-en-Java-Desencriptado

**1.	Proyecto: Practica-07-Desencriptado**
En este proyecto se crearon tres paquetes:

	ec.edu.ups.controlador
	ec.edu.ups.multimedia
	ec.edu.ups.vista
  
**2.	ec.edu.ups.controlador** 
en este paquete se creo una clase en la cual se encarga de desencriptar el texto de un documento.
*ControladorDesencriptado.java

package ec.edu.ups.controlador;

    import java.nio.charset.StandardCharsets;
    import java.util.StringTokenizer;


    public class ControladorDesencriptado {

    public String desencriptar(String texto) {
        String textoDesencriptado = "";
        StringTokenizer desencriptado = new StringTokenizer(texto, "%$");
        while (desencriptado.hasMoreTokens()) {
            String caracter = desencriptado.nextToken();
            int codigo = Integer.valueOf(caracter);
            codigo -= 10;
            codigo = codigo / 5;
            char letra = (char) codigo;
            textoDesencriptado = textoDesencriptado + letra;
        }
        return textoDesencriptado;
    }

**3.	ControladorDesencriptado.java**
En esta clase se importaron los siguientes paquetes:

	import java.nio.charset.StandardCharsets
	import java.util.StringTokenizer
  
esta clase recibe el texto de un archivo y procede a des-encriptarlo.

	desencriptar: este método recibe en su parámetro un objeto de tipo String. Se utiliza el StringTokenizer la cual nos ayuda a separar los caracteres encriptados. Este método recibe en sus parámetros dos objetos de tipo String. El primero es el texto que desea desencriptar y el segundo son los caracteres que poner como separadores. Después se recorre el StringTokinizer con un while(), mientras va leyendo cada código se va des-encriptando el texto con la inversa del método personalizado que se creo. Por ultimo se va concatenando el texto y se retorna ese texto des-encriptado.  
  
**4.	ec.edu.ups.multimedia**
este paquete solamente contiene graficas para mejorar la visualización de la interfaz al momento de utilizarla.

**5.	ec.edu.ups.vista**
este paquete contiene una interfaz de tipo Aplication Sample form.
*DesEncriptacion 

    package ec.edu.ups.vista;

    import ec.edu.ups.controlador.ControladorDesencriptado;
    import java.io.BufferedReader;
    import java.io.File;
    import java.io.FileNotFoundException;
    import java.io.FileReader;
    import java.io.IOException;
    import javax.swing.ImageIcon;
    import javax.swing.JFileChooser;
    import javax.swing.UIManager;
    import javax.swing.UnsupportedLookAndFeelException;
    import javax.swing.filechooser.FileNameExtensionFilter;

    public class DesEncriptacion extends javax.swing.JFrame {

    private String ruta;
    private String texto;
    private ControladorDesencriptado controladorDesencriptado;

    public DesEncriptacion() {
        initComponents();
        this.ruta = "";
        this.texto = "";
        this.controladorDesencriptado = new ControladorDesencriptado();
        this.setLocationRelativeTo(this);
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/ec/edu/ups/multimedia/carpeta.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaTexto = new javax.swing.JTextArea();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        mnAbrir = new javax.swing.JMenuItem();
        mnCerrar = new javax.swing.JMenuItem();
        mnSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DESENCRIPTADO DE DOCUMENTOS");

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("TEXTO DESENCRIPTADO:");

        txtaTexto.setColumns(20);
        txtaTexto.setRows(5);
        jScrollPane1.setViewportView(txtaTexto);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Archivo");

        mnAbrir.setMnemonic('o');
        mnAbrir.setText("Abrir");
        mnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAbrirActionPerformed(evt);
            }
        });
        fileMenu.add(mnAbrir);

        mnCerrar.setMnemonic('o');
        mnCerrar.setText("Cerrar");
        mnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCerrarActionPerformed(evt);
            }
        });
        fileMenu.add(mnCerrar);

        mnSalir.setMnemonic('o');
        mnSalir.setText("Salir");
        mnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSalirActionPerformed(evt);
            }
        });
        fileMenu.add(mnSalir);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAbrirActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("BUSCAR DOCUMENTO");
        fc.setCurrentDirectory(new File("D:\\"));
        fc.setFileFilter(new FileNameExtensionFilter("Notas.txt", "txt"));
        if (fc.showOpenDialog(this) == 0) {
            ruta = fc.getSelectedFile().toString();
        }
        try {
            FileReader archivoLectura = new FileReader(ruta);
            BufferedReader lectura = new BufferedReader(archivoLectura);
            texto = "";
            String linea = "";
            while ((linea = lectura.readLine()) != null) {
                texto += linea;
            }
            lectura.close();
        } catch (FileNotFoundException e1) {
            System.out.println("Ruta de archivo no encontrada");
        } catch (IOException e2) {
            System.out.println("Error de lectura");
        } catch (Exception e3) {
            System.out.println("Error General");
        }
        txtaTexto.setText(controladorDesencriptado.desencriptar(texto));
    }//GEN-LAST:event_mnAbrirActionPerformed

    private void mnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCerrarActionPerformed
        txtaTexto.setEditable(false);
        txtaTexto.setText("");
    }//GEN-LAST:event_mnCerrarActionPerformed


    private void mnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(DesEncriptacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DesEncriptacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DesEncriptacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DesEncriptacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    System.out.println("Error setting Java LAF: " + e);
                }
                new DesEncriptacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mnAbrir;
    private javax.swing.JMenuItem mnCerrar;
    private javax.swing.JMenuItem mnSalir;
    private javax.swing.JTextArea txtaTexto;
    // End of variables declaration//GEN-END:variables

**6.	DesEncriptacion (Application Sample Form)**
Esta interfaz se encargará de desencriptar un documento, se ofrecen las siguientes opciones: abrir, cerrar, y salir.
Se importaron los siguientes paquetes:

	import ec.edu.ups.controlador.ControladorDesencriptado;
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import javax.swing.ImageIcon;
	import javax.swing.JFileChooser;
	import javax.swing.UIManager;
	import javax.swing.UnsupportedLookAndFeelException;
	import javax.swing.filechooser.FileNameExtensionFilter;
  
se instanciaron los siguientes objetos: 

	String ruta
	String texto
	ControladorDesencriptado controladorDesencriptado
  
Así mismo se crearon ActionPerformed Events para que el usuario pueda decidir que desea hacer.

	mnAbrirActionPerformed: medinate el evento action performed se ejecuta el ruta a abrir. Este se puede personalizar según el usuario, en el caso de nuestro programa se utilizo el método setDialogTitle("") para nombrar el archivo. También se utilizo el método setCurrentDirectory(File) en la cual se la pasa la ruta indicando donde deseamos abrir como predeterminando. El tercer método utilizado es el setFileFilter(FileNameExtensionFilter) en la cual se le pasa el tipo de archivo que el usuario debe elegir. El primer atributo es el nombre que queremos visualizar y el segundo es la extensión del archivo. Por ultimo se abre la ventana de guardar mediante el método showSaveDialog(). Una vez obtenido la ruta mediante el FileReader () leemos el documento y se des-encripta. Al final se pasa ese texto a que se visualize en el textArea  
	mnCerrarActionPerformed: esta opción nos permite cerrar el documento en caso de que se creo algún documento no deseado.
	mnSalirActionPerformed: esta opción termina el programa. 

**Imagen de interfaz**

<img width="668" alt="Screen Shot 2020-07-12 at 3 47 24 PM" src="https://user-images.githubusercontent.com/64902384/87256359-6ee63180-c457-11ea-810d-8d770d37895f.png">
