
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.toedter.calendar.JDateChooser;

/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
/**
 * This class is designed to handle operations concerning the searching of Customers within the
 * 'airline' database.
 *
 */
public class searchCustomer extends javax.swing.JInternalFrame {

  /**
   * Creates new form searchCustomer
   */
  public searchCustomer() {
    initComponents();
  }

  Connection con;
  PreparedStatement pst;

  String path = null;
  byte[] userimage = null;
  private Boolean blobFlag;
  /*
   * blobFlag is a special attribute that is used primarily for testing. It is used to allow tests
   * to bypass the obtaining of blob objects when testing the searchCustomer class. A blob is a
   * 'binary large object' that mostly exists as a way to store image file paths within a SQL
   * database. They only exist for the duration of the transaction they are created for and unlike
   * other data types in Java they require a lot of hoops to jump through to create.
   * 
   */

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
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    txtlastname = new javax.swing.JTextField();
    txtfirstname = new javax.swing.JTextField();
    txtnic = new javax.swing.JTextField();
    txtpassport = new javax.swing.JTextField();
    jScrollPane1 = new javax.swing.JScrollPane();
    txtaddress = new javax.swing.JTextArea();
    jLabel6 = new javax.swing.JLabel();
    jPanel2 = new javax.swing.JPanel();
    jLabel8 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    jLabel10 = new javax.swing.JLabel();
    r1 = new javax.swing.JRadioButton();
    r2 = new javax.swing.JRadioButton();
    txtcontact = new javax.swing.JTextField();
    txtphoto = new javax.swing.JLabel();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    jButton3 = new javax.swing.JButton();
    txtcustid = new javax.swing.JTextField();
    jButton4 = new javax.swing.JButton();
    txtdob = new JDateChooser();

    jPanel1.setBackground(new java.awt.Color(51, 0, 255));

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 255, 255));
    jLabel1.setText("FirstName");

    jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(255, 255, 255));
    jLabel2.setText("LastName");

    jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(255, 255, 255));
    jLabel3.setText("Nic No");

    jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(255, 255, 255));
    jLabel4.setText("Passport ID");

    jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(255, 255, 255));
    jLabel5.setText("Address");

    txtlastname.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtlastnameActionPerformed(evt);
      }
    });

    txtpassport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtpassportActionPerformed(evt);
      }
    });

    txtaddress.setColumns(20);
    txtaddress.setRows(5);
    jScrollPane1.setViewportView(txtaddress);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup().addGap(26, 26, 26).addGroup(jPanel1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel1)
                    .addGap(47, 47, 47).addComponent(txtfirstname))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5).addComponent(jLabel4).addComponent(jLabel3))
                    .addGap(38, 38, 38)
                    .addGroup(jPanel1Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1).addComponent(txtpassport)
                        .addComponent(txtnic))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel2).addGap(48, 48, 48)
                .addComponent(txtlastname, javax.swing.GroupLayout.PREFERRED_SIZE, 166,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)))));
    jPanel1Layout.setVerticalGroup(jPanel1Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup().addGap(37, 37, 37)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(txtfirstname, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(22, 22, 22)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2)
                .addComponent(txtlastname, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel3).addComponent(txtnic, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4)
                .addComponent(txtpassport, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel5).addComponent(jScrollPane1,
                    javax.swing.GroupLayout.PREFERRED_SIZE, 62,
                    javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(34, 34, 34)));

    jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel6.setText("Customer ID");

    jPanel2.setBackground(new java.awt.Color(51, 0, 255));

    jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(255, 255, 255));
    jLabel8.setText("Date of Birth");

    jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(255, 255, 255));
    jLabel9.setText("Gender");

    jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(255, 255, 255));
    jLabel10.setText("Contact");

    r1.setText("Male");

    r2.setText("Female");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup().addGap(22, 22, 22)
                .addGroup(jPanel2Layout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8).addComponent(jLabel9).addComponent(jLabel10))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtdob)
                            .addGroup(jPanel2Layout.createSequentialGroup().addComponent(r1)
                                .addGap(18, 18, 18).addComponent(r2))
                            .addComponent(txtcontact))))
                .addContainerGap(41, Short.MAX_VALUE)));
    jPanel2Layout.setVerticalGroup(jPanel2Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup().addGap(37, 37, 37).addComponent(jLabel8)
            .addComponent(txtdob).addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel9).addComponent(r1).addComponent(r2))
            .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel10).addComponent(txtcontact,
                    javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                    javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(108, Short.MAX_VALUE)));

    txtphoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jButton1.setText("Browse");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jButton2.setText("Update");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    jButton3.setText("Cancel");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton3ActionPerformed(evt);
      }
    });

    jButton4.setText("Find");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton4ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                    layout.createSequentialGroup().addGap(25, 25, 25).addComponent(jLabel6)
                        .addGap(29, 29, 29).addComponent(txtcustid,
                            javax.swing.GroupLayout.PREFERRED_SIZE, 147,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanel1,
                    javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                    javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtphoto, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup().addGap(337, 337, 337).addComponent(
                            jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87,
                            javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createSequentialGroup().addGap(39, 39, 39)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18).addComponent(jButton3,
                        javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup().addGap(30, 30, 30).addComponent(jButton4,
                    javax.swing.GroupLayout.PREFERRED_SIZE, 81,
                    javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(24, Short.MAX_VALUE)));
    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(17, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel6)
                .addComponent(txtcustid, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton4))
            .addGap(38, 38, 38)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup().addGap(25, 25, 25).addGroup(layout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtphoto, javax.swing.GroupLayout.DEFAULT_SIZE, 250,
                        Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
                            javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGap(49, 49, 49)));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  /**
   * A method left over from the original project.
   * <p>
   * It does nothing currently, but remains because it is part of form generation.
   * 
   * @param evt An ActionListener tied to the txtlastname field.
   */
  private void txtlastnameActionPerformed(java.awt.event.ActionEvent evt) {
    // GEN-FIRST:event_txtlastnameActionPerformed
    // TODO add your handling code here:
  }// GEN-LAST:event_txtlastnameActionPerformed

  /**
   * A method left over from the original project.
   * <p>
   * It does nothing currently, but remains because it is part of form generation.
   * 
   * @param evt An ActionListener tied to the txtpassport field.
   */
  private void txtpassportActionPerformed(java.awt.event.ActionEvent evt) {
    // GEN-FIRST:event_txtpassportActionPerformed
    // TODO add your handling code here:
  }// GEN-LAST:event_txtpassportActionPerformed

  /**
   * This method is tied to the "Browse" button on the 'Search Customer' screen accessed from the
   * Main Menu window.
   * 
   * <p>
   * It opens a file input stream and then asks for the user to select a valid image file. The valid
   * image file extensions are png, jpg, and .images type files. After a user has selected a valid
   * image file from their device, the system reads the image path and sets the customer's photo to
   * look through that path. When this is complete, the GUI will refresh and show the user the
   * selected image within the 'Search Customer' screen. At the same time the userimage swing
   * attribute is set to the path which was provided by the user to the image. This is a required
   * step for the updating of customer data within the database.
   * 
   * @param evt Whenever the "Browse" button is clicked, this method is invoked.
   * 
   */
  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    // GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:

    try {
      JFileChooser picchooser = new JFileChooser();
      picchooser.showOpenDialog(null);
      File pic = picchooser.getSelectedFile();
      FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "png", "jpg");
      picchooser.addChoosableFileFilter(filter);
      path = pic.getAbsolutePath();
      BufferedImage img;
      img = ImageIO.read(picchooser.getSelectedFile());
      ImageIcon imageIcon = new ImageIcon(
          new ImageIcon(img).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
      txtphoto.setIcon(imageIcon);

      File image = new File(path);
      FileInputStream fis = new FileInputStream(image);
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      byte[] buff = new byte[1024];
      for (int readNum; (readNum = fis.read(buff)) != -1;) {
        baos.write(buff, 0, readNum);
      }
      userimage = baos.toByteArray();
      fis.close();
    } catch (IOException ex) {
      Logger.getLogger(addCustomer.class.getName()).log(Level.SEVERE, null, ex);
    }

  }// GEN-LAST:event_jButton1ActionPerformed

  /**
   * This method is tied to the "Update" button on the 'Search Customer' screen accessed from the
   * Main Menu window.
   * 
   * <p>
   * If a user has filled out all of the fields on the 'Search Customer' screen and the customer
   * data being updated correlates to an existing customer within the database then the update will
   * be executed and the database will be refreshed with the new data. It is useful to know that
   * while a user is still able to 'update' data for a customer not in the database and get the
   * pop-up telling them that the update was succesful, nothing has actually been updated or added
   * into the database. This is because 'update' in SQL is different from 'insert' operations.
   * 
   * @param evt Whenever the "Update" button is clicked, this method is invoked.
   */
  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    // GEN-FIRST:event_jButton2ActionPerformed
    // TODO add your handling code here:
    update();

  }// GEN-LAST:event_jButton2ActionPerformed

  public Customer update() {

    Customer currentCustomer = new Customer();

    String id = txtcustid.getText();
    currentCustomer.setId(id);
    String firstname = txtfirstname.getText();
    String lastname = txtlastname.getText();
    String nic = txtnic.getText();
    String passport = txtpassport.getText();
    String address = txtaddress.getText();

    DateFormat da = new SimpleDateFormat("yyyy-MM-dd");
    String date = da.format(txtdob.getDate());
    String Gender;
    if (r1.isSelected()) {
      Gender = "Male";
    } else {
      Gender = "FeMale";
    }

    String contact = txtcontact.getText();

    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DBUtil.dbConnect();
      pst = con
          .prepareStatement("update customer set firstname = ?,lastname = ?,nic = ?,passport = ?,"
              + "address= ?,dob = ?,gender = ?,contact = ?,photo = ? where id = ?");

      pst.setString(1, firstname);
      pst.setString(2, lastname);
      pst.setString(3, nic);
      pst.setString(4, passport);
      pst.setString(5, address);
      pst.setString(6, date);
      pst.setString(7, Gender);
      pst.setString(8, contact);
      pst.setBytes(9, userimage);
      pst.setString(10, id);
      pst.executeUpdate();

      currentCustomer.setFirstname(txtfirstname.getText());
      currentCustomer.setLastname(txtlastname.getText());
      currentCustomer.setNic(txtnic.getText());
      currentCustomer.setPassport(txtpassport.getText());
      currentCustomer.setAddressString(txtaddress.getText());
      currentCustomer.setContact(txtcontact.getText());
      currentCustomer.setDob(txtdob.getDate());

      JOptionPane.showMessageDialog(null, "Registration Updated.");

    } catch (ClassNotFoundException ex) {
      Logger.getLogger(addCustomer.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(addCustomer.class.getName()).log(Level.SEVERE, null, ex);
    }
    return currentCustomer;
  }


  /**
   * This method is bound to the "Cancel" button on the "Search Customer" screen.
   * 
   * <p>
   * All it does is close the "Search Customer" screen and return the user to the Main Menu window.
   * 
   * @param evt Whenever the "Cancel" button is clicked, this method is invoked.
   */
  private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
    // GEN-FIRST:event_jButton3ActionPerformed
    // TODO add your handling code here:
    this.hide();
  }// GEN-LAST:event_jButton3ActionPerformed

  /**
   * The jButton4 element on the "Search Customer" screen is what calls the 'Find' feature.
   * <p>
   * When a user clicks on the 'Find' button on the "Search Customer" screen, this method is invoked
   * and calls the searchByID method. This separation of methods allows for the searchByID feature
   * to be tested without having to invoke anything related to jButton4.
   * 
   * @param evt Whenever the user clicks on the "Find" button this method is invoked.
   */
  private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
    // GEN-FIRST:event_jButton4ActionPerformed
    // TODO add your handling code here:
    searchByID(txtcustid.getText());
  }// GEN-LAST:event_jButton4ActionPerformed

  /**
   * searchByID is a function that allows a user to search for Customers in the 'airline' database
   * by providing a customerID on the 'Search Customer' screen.
   * 
   * <p>
   * Normally this method is called when a user clicks on the "Find" button, but encapsulating data
   * prevents users from tampering with elements that are not currently rendered on screen while
   * also enabling testing to be performed within scope.
   * 
   * @param customerID A string containing a customerID to perform a query with.
   * @return This method returns a customer object with fields set to the values found by queries.
   */
  public Customer searchByID(String customerID) {
    Customer customerFinder = new Customer();
    customerFinder.setId(customerID);

    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DBUtil.dbConnect();
      pst = con.prepareStatement("select * from customer where id = ?");
      pst.setString(1, customerID);
      ResultSet rs = pst.executeQuery();

      if (!rs.next()) {
        JOptionPane.showMessageDialog(this, "Record not Found.");
      } else {
        String fname = rs.getString("firstname");
        String lname = rs.getString("lastname");
        String nic = rs.getString("nic");
        String passport = rs.getString("passport");

        String address = rs.getString("address");
        String dob = rs.getString("dob");
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
        String gender = rs.getString("gender");

        if (blobFlag = false) {
          Blob blob = rs.getBlob("photo");
          byte[] imageBytes = blob.getBytes(1, (int) blob.length());
          ImageIcon image = new ImageIcon(imageBytes);
          Image im = image.getImage();
          Image myImg =
              im.getScaledInstance(txtphoto.getWidth(), txtphoto.getHeight(), Image.SCALE_SMOOTH);
          ImageIcon newImage = new ImageIcon(myImg);
          txtphoto.setIcon(newImage);
        }
        if (gender.equals("Female")) {
          r1.setSelected(false);
          r2.setSelected(true);

        } else {
          r1.setSelected(true);
          r2.setSelected(false);
        }
        String contact = rs.getString("contact");

        txtfirstname.setText(fname.trim());
        txtlastname.setText(lname.trim());
        txtnic.setText(nic.trim());
        txtpassport.setText(passport.trim());
        txtaddress.setText(address.trim());
        txtcontact.setText(contact.trim());
        txtdob.setDate(date1);

        customerFinder.setFirstname(txtfirstname.getText());
        customerFinder.setLastname(txtlastname.getText());
        customerFinder.setNic(txtnic.getText());
        customerFinder.setPassport(txtpassport.getText());
        customerFinder.setAddressString(txtaddress.getText());
        customerFinder.setContact(txtcontact.getText());
        customerFinder.setDob(txtdob.getDate());

      }

    } catch (ClassNotFoundException ex) {
      Logger.getLogger(searchCustomer.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(searchCustomer.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ParseException ex) {
      Logger.getLogger(searchCustomer.class.getName()).log(Level.SEVERE, null, ex);
    }
    return customerFinder;

  }

  /**
   * Mutator method to set the value of the blobFlag.
   * 
   * <p>
   * In order to implement encapsulation, a user is prevented from directly modifying the value of
   * the blobFlag. The blobFlag is used to allow tests to work properly without throwing exceptions
   * due to the way that blob objects are handled, created, and set.
   * 
   * @param blobStatus A boolean value passed in to enable/disable the blobFlag.
   */
  public void setBlobFlag(boolean blobStatus) {
    this.blobFlag = blobStatus;
  }

  /**
   * Accessor method to retrieve the value of the blobFlag attribute.
   * 
   * @return Returns the status of the blobFlag attribute.
   */
  public boolean getBlobFlag() {
    return blobFlag;
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JButton jButton3;
  private javax.swing.JButton jButton4;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JRadioButton r1;
  private javax.swing.JRadioButton r2;
  private javax.swing.JTextArea txtaddress;
  private javax.swing.JTextField txtcontact;
  private javax.swing.JTextField txtcustid;
  private javax.swing.JTextField txtfirstname;
  private javax.swing.JTextField txtlastname;
  private javax.swing.JTextField txtnic;
  private javax.swing.JTextField txtpassport;
  private javax.swing.JLabel txtphoto;
  private JDateChooser txtdob;
  // End of variables declaration//GEN-END:variables
}
