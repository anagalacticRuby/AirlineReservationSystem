import javax.security.auth.login.LoginException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
/**
 * This class houses the methods and display elements for the 'Main Menu' screen for the
 * SWT-AirlineReservationSystem.
 *
 */
public class Main extends javax.swing.JFrame {

  /**
   * Creates new form Main
   * 
   * @throws LoginException
   */
  public Main() {
    if (loginFlag) {
      initComponents();
    } else {
      terminateSystem();
    }
  }

  /**
   * A special constructor that allows the loginFlag to be specified at creation time.
   * 
   * @param loginFlag A boolean value that the loginFlag will be initialized with
   */
  public Main(boolean loginFlag) {
    setLoginFlag(loginFlag);
    if (getLoginFlag()) {
      initComponents();
    } else {
      terminateSystem();
    }
  }

  /**
   * A security method that will throw a LoginException and tell the user that they are attempting
   * to access the program illegally.
   * <p>
   * After the user clicks on the pop-up window that appears alongside the exception throwing, the
   * program will terminate itself.
   * @throws LoginException Throws a loginException if the user accesses Main directly
   */
  public void terminateSystem() {
    try {
      throw new LoginException();
    } catch (LoginException e) {
      JOptionPane.showMessageDialog(this,
          "Illegal access to program. Shutting down to secure data.");
      e.printStackTrace();
      this.setVisible(false);
      //System.exit(1);
    }
  }

  private boolean loginFlag = false;
  /*
   * This boolean flag is designed to check if a user has logged in for authentication. By default
   * it is set to false because a user must log in from Login.Java to have permission to access the
   * entire program.
   */

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jDesktopPane1 = new javax.swing.JDesktopPane();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    jMenuItem1 = new javax.swing.JMenuItem();
    jMenuItem2 = new javax.swing.JMenuItem();
    jMenu2 = new javax.swing.JMenu();
    jMenuItem3 = new javax.swing.JMenuItem();
    jMenuItem6 = new javax.swing.JMenuItem();
    jMenu3 = new javax.swing.JMenu();
    jMenuItem4 = new javax.swing.JMenuItem();
    jMenu4 = new javax.swing.JMenu();
    jMenuItem5 = new javax.swing.JMenuItem();

    jMenu1.setName("customer");
    jMenu2.setName("ticket");
    jMenu3.setName("flight");
    jMenu4.setName("user");

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setPreferredSize(new java.awt.Dimension(1366, 768));

    javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
    jDesktopPane1.setLayout(jDesktopPane1Layout);
    jDesktopPane1Layout.setHorizontalGroup(
        jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0,
            400, Short.MAX_VALUE));
    jDesktopPane1Layout.setVerticalGroup(
        jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0,
            279, Short.MAX_VALUE));

    jMenu1.setText("Customer");

    jMenuItem1.setText("Add Customer");
    jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem1ActionPerformed(evt);
      }
    });
    jMenu1.add(jMenuItem1);

    jMenuItem2.setText("Search Customer");
    jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem2ActionPerformed(evt);
      }
    });
    jMenu1.add(jMenuItem2);

    jMenuBar1.add(jMenu1);

    jMenu2.setText("Tickets");

    jMenuItem3.setText("Book Ticket");
    jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem3ActionPerformed(evt);
      }
    });
    jMenu2.add(jMenuItem3);

    jMenuItem6.setText("Ticket Report");
    jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem6ActionPerformed(evt);
      }
    });
    jMenu2.add(jMenuItem6);

    jMenuBar1.add(jMenu2);

    jMenu3.setText("Flight");

    jMenuItem4.setText("Add Flight");
    jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem4ActionPerformed(evt);
      }
    });
    jMenu3.add(jMenuItem4);

    jMenuBar1.add(jMenu3);

    jMenu4.setText("User");

    jMenuItem5.setText("UserCreation");
    jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem5ActionPerformed(evt);
      }
    });
    jMenu4.add(jMenuItem5);

    jMenuBar1.add(jMenu4);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jDesktopPane1));
    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jDesktopPane1));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  /**
   * This method brings up the 'Add Customer' screen when a user clicks on the 'Add Customer' option
   * in the 'Customer' drop down menu within the Main Menu window.
   * 
   * @param evt An ActionListener invoked by a user's interaction.
   */
  private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
    // GEN-FIRST:event_jMenuItem1ActionPerformed
    // TODO add your handling code here:

    addCustomer addCustomerScreen = new addCustomer();
    jDesktopPane1.add(addCustomerScreen);
    addCustomerScreen.setVisible(true);

  }// GEN-LAST:event_jMenuItem1ActionPerformed

  /**
   * This method brings into view the 'Search Customer' screen when a user clicks on the 'Search
   * Customer' option in the 'Customer' drop down menu within the Main Menu window.
   * 
   * @param evt An ActionListener invoked by a user's interaction.
   */
  private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
    // GEN-FIRST:event_jMenuItem2ActionPerformed
    // TODO add your handling code here:

    searchCustomer searchCustomerScreen = new searchCustomer();
    jDesktopPane1.add(searchCustomerScreen);
    searchCustomerScreen.setVisible(true);

  }// GEN-LAST:event_jMenuItem2ActionPerformed

  /**
   * This method brings into view the 'Add Flight ' screen when a user clicks on the 'Add Flight'
   * option in the 'Flight' drop down menu within the Main Menu window.
   * 
   * @param evt An ActionListener that is invoked by a user.
   */
  private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {
    // GEN-FIRST:event_jMenuItem4ActionPerformed
    // TODO add your handling code here:
    addflight addFlightScreen = new addflight();
    jDesktopPane1.add(addFlightScreen);
    addFlightScreen.setVisible(true);

  }// GEN-LAST:event_jMenuItem4ActionPerformed

  /**
   * This method brings into view the 'Book Ticket' screen when a user clicks on the 'Book Ticket'
   * option in the 'Ticket' drop down menu within the Main Menu window.
   * 
   * @param evt An ActionListener that is invoked by a user.
   */
  private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {
    // GEN-FIRST:event_jMenuItem3ActionPerformed
    // TODO add your handling code here:
    ticket bookTicketScreen = new ticket();
    jDesktopPane1.add(bookTicketScreen);
    bookTicketScreen.setVisible(true);

  }// GEN-LAST:event_jMenuItem3ActionPerformed

  /**
   * This method brings into view the 'Ticket Report' screen when a user clicks on the 'Ticket
   * Report' option in the 'Ticket' drop down menu within the Main Menu window.
   * 
   * @param evt An ActionListener that is invoked by a user.
   */
  private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {
    // GEN-FIRST:event_jMenuItem6ActionPerformed
    // TODO add your handling code here:

    ticketreport ticketReportScreen = new ticketreport();
    jDesktopPane1.add(ticketReportScreen);
    ticketReportScreen.setVisible(true);

  }// GEN-LAST:event_jMenuItem6ActionPerformed

  /**
   * This method brings into view the 'User Creation' screen when a user clicks on the
   * 'UserCreation' option in the 'Customer' drop down menu within the Main Menu window.
   * 
   * @param evt An ActionListener that is invoked by a user.
   */
  private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {
    // GEN-FIRST:event_jMenuItem5ActionPerformed
    // TODO add your handling code here:

    userCreation userCreationScreen = new userCreation();
    jDesktopPane1.add(userCreationScreen);
    userCreationScreen.setVisible(true);

  }// GEN-LAST:event_jMenuItem5ActionPerformed

  /**
   * The 'main' method of Main.Java.
   * <p>
   * All this method does is set the Java Swing 'look and feel' of the program.
   * 
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
    // (optional) ">
    /*
     * If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
          .getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE,
          null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE,
          null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE,
          null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE,
          null, ex);
    }
    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Main().setVisible(true);
      }
    });
  }

  /**
   * Sets the loginFlag to the state passed in.
   * 
   * @param loginStatus The state to set the loginFlag to.
   */
  public void setLoginFlag(boolean loginStatus) {
    this.loginFlag = loginStatus;
  }

  /**
   * Gets the status of the loginFlag
   * 
   * @return The state of the loginFlag attribute
   */
  public boolean getLoginFlag() {
    return loginFlag;
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JDesktopPane jDesktopPane1;
  private javax.swing.JMenu jMenu1;
  private javax.swing.JMenu jMenu2;
  private javax.swing.JMenu jMenu3;
  private javax.swing.JMenu jMenu4;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenuItem jMenuItem1;
  private javax.swing.JMenuItem jMenuItem2;
  private javax.swing.JMenuItem jMenuItem3;
  private javax.swing.JMenuItem jMenuItem4;
  private javax.swing.JMenuItem jMenuItem5;
  private javax.swing.JMenuItem jMenuItem6;
  // End of variables declaration//GEN-END:variables
}
