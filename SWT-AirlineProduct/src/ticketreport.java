
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
/**
 * This class handles all of the functions and elements of the 'Ticket Report' screen that can be
 * accessed from the Main Menu window.
 *
 */
public class ticketreport extends javax.swing.JInternalFrame {

  /**
   * Creates new form ticketreport
   */
  public ticketreport() {
    initComponents();
    LoadData();
    list();
  }

  Connection con;
  PreparedStatement pst;

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();
    jButton1 = new javax.swing.JButton();

    jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

    }, new String[] {"TicketNo", "Flight No", "Customer ID", "Class", "Price", "Seats", "Date"}));
    jScrollPane1.setViewportView(jTable1);

    jButton1.setText("Cancel");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap(25, 50).addComponent(
                    jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600,
                    javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup().addGap(200, 200, 200).addComponent(
                    jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
                    javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(50, Short.MAX_VALUE)));
    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup().addGap(29, 29, 29)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259,
                javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(35, 35, 35).addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(50, Short.MAX_VALUE)));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  /**
   * This method is bound to the "Cancel" button on the "Ticket Report" screen.
   * 
   * <p>
   * All it does is close the "Ticket Report" screen and return the user to the Main Menu window.
   * 
   * @param evt Whenever the "Cancel" button is clicked, this method is invoked.
   */
  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    // GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:
    this.hide();
  }// GEN-LAST:event_jButton1ActionPerformed

  
  /**
   * Each time that the "Ticket Report" screen is opened by a user, this method will grab the most
   * up to date values from the database for all ticket objects stored.
   * <p>
   * Due to the nature of Java Swing, this method will not automatically run each time the ticket
   * table is updated. Which means that the "Ticket Report" screen will need to be opened each time
   * that a user wants to refresh the current listings of ticket data.
   */
  public void LoadData() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DBUtil.dbConnect();
      pst = con.prepareStatement("SELECT * from ticket");
      ResultSet rs = pst.executeQuery();

      ResultSetMetaData rsm = rs.getMetaData();
      int c;
      c = rsm.getColumnCount();

      DefaultTableModel Df = (DefaultTableModel) jTable1.getModel();
      Df.setRowCount(0);

      while (rs.next()) {
        Vector<String> v2 = new Vector<>();

        for (int i = 1; i <= c; i++) {
          v2.add(rs.getString("id"));
          v2.add(rs.getString("flightid"));
          v2.add(rs.getString("custid"));
          v2.add(rs.getString("class"));
          v2.add(rs.getString("price"));
          v2.add(rs.getString("seats"));
          v2.add(rs.getString("date"));
        }
        Df.addRow(v2);
      }

    } catch (ClassNotFoundException ex) {
      Logger.getLogger(ticket.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(ticket.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable jTable1;
  // End of variables declaration//GEN-END:variables
}
