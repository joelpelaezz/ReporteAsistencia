/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.reporteasistencia.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author joel
 */
public class CalcularAsistencia extends javax.swing.JFrame {

    /**
     * Creates new form CalcularAsistencia
     */
    public CalcularAsistencia() {
        initComponents();
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
        jButton1 = new javax.swing.JButton();
        lblRutaArchivo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Seleccione el Origen");

        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblRutaArchivo.setText("no seleccionó ningun archivo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(jButton1)
                .addGap(37, 37, 37)
                .addComponent(lblRutaArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(lblRutaArchivo))
                .addContainerGap(311, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // muestra el cuadro de diálogo de archivos, para que el usuario pueda elegir el archivo a abrir
        JFileChooser selectorArchivos = new JFileChooser();
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos Excel", "xls");
        selectorArchivos.setFileFilter(filtro);
        
        FileNameExtensionFilter filtro2 = new FileNameExtensionFilter("Archivos Excel", "xlsx");
        selectorArchivos.setFileFilter(filtro2);
        
        // indica cual fue la accion de usuario sobre el jfilechooser
        int resultado = selectorArchivos.showOpenDialog(this);
        File archivo = selectorArchivos.getSelectedFile(); // obtiene el archivo seleccionado

        boolean seleccionoArchivo = false;
        // muestra error si es inválido
        if ((archivo == null) || (archivo.getName().equals(""))) {
         //JOptionPane.showMessageDialog(this, "Nombre de archivo inválido", "Nombre de archivo inválido", JOptionPane.ERROR_MESSAGE);
         lblRutaArchivo.setText("No seleccionó ningun archivo");
        }else{ // fin de if

            lblRutaArchivo.setText(archivo.getName());
            seleccionoArchivo = true ;
        }
        
        // calcular 
        if (seleccionoArchivo) {
//            File f = new File("PATH\FICHERO.xlsx");
//            InputStream inp = new FileInputStream(f);
//            Workbook wb = WorkbookFactory.create(inp);
//            Sheet sh = wb.getSheetAt(0);
//            
//            
//            Row row = sh.getRow(iRow); //En qué fila empezar ya dependerá también de si tenemos, por ejemplo, el título de cada columna en la primera fila
//            while(row!=null) 
//            {
//                Cell cell = row.getCell(1);  
//                String value = cell.getStringCellValue();
//                System.out.println("Valor de la celda es " + value);
//                iRow++;  
//                row = sh.getRow(iRow);
//            }

            try {
            String rutaArchivoExcel = archivo.getAbsolutePath();
            FileInputStream inputStream = new FileInputStream(new File(rutaArchivoExcel));
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();
            
            DataFormatter formatter = new DataFormatter();
            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                while(cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    String contenidoCelda = formatter.formatCellValue(cell);
                    System.out.println("celda: " + contenidoCelda);
                }
                
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

        private static void CreateExcel(String fileName, String[] data) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Hoja prueba");

        for (int j = 0; j < 2; j++) {// 2 por el Encabezado y la linea de informacion
            HSSFRow row = sheet.createRow(j);
            for (int i = 0; i < data.length; i++) {// Tantos loops como info en el arreglo
                HSSFCell cell = row.createCell(i);
                if (j == 0) {
                    cell.setCellValue("#" + i);
                } else {
                    cell.setCellValue(data[i]);
                }
            }
        }

        try {
            FileOutputStream fos = null;
            File file;

            file = new File(fileName);
            fos = new FileOutputStream(file);

            workbook.write(fos);
            workbook.close();
            fos.close();
            System.out.println("Finalizado");

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    private static void ReadExcel(String fileName) {
        try {
            InputStream myFile = new FileInputStream(new File(fileName));
            HSSFWorkbook wb = new HSSFWorkbook(myFile);
            HSSFSheet sheet = wb.getSheetAt(0);

            HSSFCell cell;
            HSSFRow row;

            System.out.println("Apunto de entrar a loops");

            System.out.println("" + sheet.getLastRowNum());

            for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
                row = sheet.getRow(i);
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    cell = row.getCell(j);
                    System.out.println("Valor: " + cell.toString());
                }
            }
            System.out.println("Finalizado");

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    private static void OverwriteExcel(String fileName, String[] data) {
        try {
            InputStream inp = new FileInputStream(new File(fileName));
            HSSFWorkbook oldWorkbook = new HSSFWorkbook(inp);

            HSSFSheet oldSheet = oldWorkbook.getSheetAt(0);

            HSSFRow oldRow;

            oldRow = oldSheet.createRow(oldSheet.getLastRowNum() + 1);
            for (int i = 0; i < data.length; i++) {// Tantos loops como info en el arreglo
                HSSFCell cell = oldRow.createCell(i);
                cell.setCellValue(data[i]);
            }

            FileOutputStream fos = null;
            File file;

            file = new File(fileName);
            fos = new FileOutputStream(file);

            oldWorkbook.write(fos);
            oldWorkbook.close();
            fos.close();

            System.out.println("Finalizado");

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
    
    
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
            java.util.logging.Logger.getLogger(CalcularAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalcularAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalcularAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalcularAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalcularAsistencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblRutaArchivo;
    // End of variables declaration//GEN-END:variables
}
