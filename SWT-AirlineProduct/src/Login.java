
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

public class Login extends javax.swing.JFrame {

  private int attemptsLeft = 3;
  private boolean validLogin = false;

  /**
   * Creates new form Login
   */
  public Login() {
    initComponents();
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

    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    txtuser = new javax.swing.JTextField();
    txtpass = new javax.swing.JPasswordField();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login",
        javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
        javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

    jLabel1.setText("Username");

    jLabel2.setText("Password");

    jButton1.setText("Login");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jButton2.setText("Cancel");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout
        .setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup().addGap(50, 50, 50)
                        .addGroup(jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1).addComponent(jLabel2))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtuser).addComponent(txtpass,
                                javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup().addGap(136, 136, 136)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18).addComponent(jButton2,
                            javax.swing.GroupLayout.PREFERRED_SIZE, 116,
                            javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(25, Short.MAX_VALUE)));
    jPanel1Layout.setVerticalGroup(jPanel1Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup().addGap(46, 46, 46)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1).addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(43, 43, 43)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2).addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31,
                Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                    javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(45, 45, 45)));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup().addGap(26, 26, 26)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(44, Short.MAX_VALUE)));
    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup().addGap(30, 30, 30)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(22, Short.MAX_VALUE)));

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  /**
   * This method is called each time the 'Login' button is pressed by a user.
   * 
   * @param evt Obtained from an ActionListener attached to jButton1, the 'Login' button.
   */
  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    // GEN-FIRST:event_jButton1ActionPerformed

    User user = handleLoginEnter(evt, txtuser.getText(), txtpass.getText());

  }// GEN-LAST:event_jButton1ActionPerformed

  /**
   * This method is tied to the 'Cancel' button on the Login screen. Formally known as jButton2.
   * <p>
   * When a user clicks on the 'Cancel' button while on the Login screen, the program will
   * terminate.
   * 
   * @param evt Whenever a user clicks on the 'Cancel' button, an ActionListener is invoked.
   */
  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

    JOptionPane.showMessageDialog(this, "Canceled Login.");
    System.out.println("Canceled Login.");
    System.exit(0);
    // Terminate program if user clicks on the 'Cancel' button while on the Login screen.
  }


  /**
   * This method is invoked after a user clicks on the 'Login' button, which is jButton1.
   * <p>
   * When this method is invoked, it first creates a User object with the username and password
   * values that have been passed in from the txtpass element and the txtuser element. Then a check
   * is performed to make sure that the username and password fields are not empty. If the username
   * and password are valid and exist within the user table of the 'airline' database, then the user
   * is able to proceed into the Main Menu of the program, Main.java Else, a series of smaller
   * queries are performed to determine if both the username and password are invalid, or just the
   * password. A simple switch case is utilized to decide what error message to print to the user so
   * they understand what information was incorrect. A user has only 3 attempts to login before the
   * system will lock them out and terminate itself. This is done to increase security and prevent
   * easy brute force attempts to access the program.
   * 
   * @param evt ActionEvent, user clicks on the 'Login' JButton.
   * @param username A String containing a username, obtained from the JTextField named txtuser
   * @param password A string containing a password, obtained from the JPasswordField named txtpass
   * @return User Object of class User.
   */
  public User handleLoginEnter(java.awt.event.ActionEvent evt, String username, String password) {
    User currentUser = new User(username, password);

    if (username.isEmpty() || password.isEmpty()) {
      setLoginValidity(false);
      // Set validLogin flag to be false, because the login attempt was unsuccessful.
      JOptionPane.showMessageDialog(this, "Username or Password is blank.");
    } else {
      try {
        if (attemptsLeft != 0) {
          con = DBUtil.dbConnect();
          pst = con.prepareStatement("select * from user where username = ? and password = ?");
          pst.setString(1, username);
          pst.setString(2, password);

          ResultSet rs;
          rs = pst.executeQuery();

          if (rs.next()) {
            setLoginValidity(true);
            // Update the validLogin flag to True, indicating a successful login attempt.
            Main m = new Main();
            this.setVisible(false);
            // Set the Login window to become invisible, which also hides it from interaction.
            m.setVisible(true);
            // Set the Main window to become visible, and thus enables interaction.
            System.out.println("Successful Login!");
          } else {

            // Initialize variable to determine what error message to display
            int invalidCase = 0;
            /*
             * Case 0 is a valid password, but not a matching username. In order to ensure security,
             * a user is simply informed that the username and password do not match.
             */

            /*
             * The following segment of code determines what elements input by the user are invalid,
             * And makes an appropriate error message appear.
             */
            // -------//
            pst = con.prepareStatement("select * from user where exists "
                + "(select * from user where username = ? and password = ?)");
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (!rs.next()) {
              invalidCase = 1;
              // Case 1, invalid username.
            }
            pst = con.prepareStatement(
                "select * from user where exists " + "(select * from user where username = ?)");
            pst.setString(1, username);
            rs = pst.executeQuery();
            if (rs.next()) {
              /*
               * The EXISTS keyword for SQL will make the query return TRUE if there exists at least
               * one record
               */
              invalidCase = 2;
              // Case 2, valid username but invalid password.
            }
            /*
             * A switch case system is implemented to determine what error message to display based
             * on what the user has input into the system.
             */
            switch (invalidCase) {
              case 0:
                JOptionPane.showMessageDialog(this, "Username and Password do not match.");
                txtuser.setText("");
                txtpass.setText("");
                txtuser.requestFocus();
                break;
              case 1:
                JOptionPane.showMessageDialog(this, "Invalid username.");
                txtuser.setText("");
                txtpass.setText("");
                txtuser.requestFocus();
                break;
              case 2:
                JOptionPane.showMessageDialog(this, "Invalid password.");
                txtpass.setText("");
                txtpass.requestFocus();
                break;
              default:
                JOptionPane.showMessageDialog(this,
                    "Invalid input. Please enter valid characters.");
                txtuser.setText("");
                txtpass.setText("");
                txtuser.requestFocus();
            }
            // ------//
            JOptionPane.showMessageDialog(this, "Attempts left: " + attemptsLeft);
            attemptsLeft--;
            System.out.println("Attempts left: " + attemptsLeft);
            setLoginValidity(false);
            // Set validLogin flag to be false, because the login attempt was unsuccessful.
          }
          DBUtil.closeResultSet(rs);
          DBUtil.closePreparedStatement(pst);
          // Close resources after they are done being used.
        } else {
          JOptionPane.showMessageDialog(this, "Maximum number of attempts exceeded.");
          System.out.println("Maximum number of attempts exceeded.");
          System.exit(0);
        }
      } catch (SQLException ex) {
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    DBUtil.dbDisconnect();
    // Close connection to the database when finished.
    return currentUser;
    // The currentUser is returned to tell the system who is currently logged in.
  }

  /**
   * All this method does is determine the 'look and feel' of all the swing elements.
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
      java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE,
          null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE,
          null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE,
          null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE,
          null, ex);
    }
    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Login().setVisible(true);
      }
    });
  }

  /**
   * This method's only purpose is to obtain the boolean value of the validLogin attribute.
   * <p>
   * Used to encapsulate data and prevent users from brute forcing their way into the program.
   * 
   * @return Returns the boolean value currently stored in the validLogin flag.
   */
  public boolean getLoginValidity() {
    return this.validLogin;
  }

  /**
   * This method will update the value of the validLogin attribute to the passed parameter.
   * <p>
   * Assign a value of True to indicate a valid login attempt and False for invalid attempts.
   * 
   * @param loginStatus A boolean flag that indicates if a login attempt is valid or not.
   */
  public void setLoginValidity(boolean loginStatus) {
    this.validLogin = loginStatus;
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPasswordField txtpass;
  private javax.swing.JTextField txtuser;
  // End of variables declaration//GEN-END:variables
}
