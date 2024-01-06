
package Inf;
import DB.DBconnect;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;



public class DipositMenu extends javax.swing.JFrame {
   Connection conn = null;
   PreparedStatement pst =null;
   ResultSet rs =null;

    
    public DipositMenu() {
        initComponents();
        
        //database cnnection class eka link kirima
        conn =DBconnect.connect();
    }
    
    
    public void enter(){
        //database data get to variable
        String[][] data = new String [100][5] ;
    
         
                            try {

                                String sql = "SELECT * FROM user";
                                pst = conn.prepareStatement(sql);
                                rs = pst.executeQuery(); 
                                
                                
                                
                                if (rs.next()) {
                                    
                                    String Nic1    = rs.getString("Nic");
                                    String Pin1    = rs.getString("Pin");
                                    String Amount1 = rs.getString("Amount");
                                    String Acc1    = rs.getString("AccountNumber");
                                    int i=0; 
                                           data[i][0]=Nic1;
                                           
                                           data[i][2]=Pin1;
                                           data[i][3]=Amount1;
                                           data[i][4]=Acc1;
                                    i++;
                                      while (rs.next()) {
                            Nic1    = rs.getString("Nic");
                            Pin1    = rs.getString("Pin");
                            Amount1 = rs.getString("Amount");
                            Acc1    = rs.getString("AccountNumber");
                             
                                           data[i][0]=Nic1;
                                           data[i][2]=Pin1;
                                           data[i][3]=Amount1;
                                           data[i][4]=Acc1;
                                           i++;
                                       
                    }
                    } else {
                        System.out.println("No data found.");
                    }
                           
                          } catch (Exception e) {

                              JOptionPane.showMessageDialog(null, e);
                          }
                            
                        

                            //Account check
                            String BankAccNumber2 =BankAccNumber.getText();
                            String NicNumber2     =NicNumber.getText();
                            String Amount2        =Amount.getText();
                            double Amount3        =Double.parseDouble(Amount2);
                           
                            for(int i=0; i<3; i++){
                             String id     =  data[i][0];
                             String blc    =  data[i][3];
                             String acc    =  data[i][4];
                             double blc1   =  Double.parseDouble(blc);
                             
                             System.out.println(BankAccNumber2+" "+NicNumber2+" "+Amount2);
                              if(acc.equals(BankAccNumber2 )){System.out.println("account ok");}
                                  if(id.equals(NicNumber2 )){System.out.println("nic ok");}
                                   if(0 <= Amount3){System.out.println("amountok ok ok");}
                                   if(BankAccNumber2.length()==12){System.out.println("length ok ok");}
                             
                             if(acc.equals(BankAccNumber2 ) && id.equals(NicNumber2 ) && 0 <= Amount3 && BankAccNumber2.length()==12 ){
                                
                                 
                                 blc1=blc1+Amount3;
                                 String blc2 =Double.toString(blc1);
                                 
                                 //database Update
                                 try {
                                  
                                    String sql = "UPDATE user SET   Amount ='"+blc2+"'  WHERE AccountNumber ='"+acc+"' "; 
                                    pst= conn.prepareStatement(sql);
                                    pst.execute();
                                    JOptionPane.showMessageDialog(null, "Deposit Success");
                                    break;
                                    
                                } catch (Exception e) {
                                    
                                    JOptionPane.showMessageDialog(null, e);
                                }
                                 
                                 
                             }else{
                                 
                             }
                            
                            }
                           
                            //clear
                            BankAccNumber.setText("");
                            NicNumber.setText("");
                            Amount.setText("");
                            
                           
                            
     }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel11 = new UI.Panel1();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BankAccNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        NicNumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Amount = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Diposit");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Bank Account Number");

        BankAccNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BankAccNumber.setForeground(new java.awt.Color(204, 204, 204));
        BankAccNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BankAccNumber.setText("0000-0000-0000-0000");
        BankAccNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BankAccNumberFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BankAccNumberFocusLost(evt);
            }
        });
        BankAccNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BankAccNumberActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("NIC Number");

        NicNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NicNumber.setForeground(new java.awt.Color(204, 204, 204));
        NicNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NicNumber.setText("000000000V");
        NicNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                NicNumberFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                NicNumberFocusLost(evt);
            }
        });
        NicNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NicNumberActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Amount");

        Amount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Amount.setForeground(new java.awt.Color(204, 204, 204));
        Amount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Amount.setText("0000.00");
        Amount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                AmountFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                AmountFocusLost(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Diposit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel11Layout = new javax.swing.GroupLayout(panel11);
        panel11.setLayout(panel11Layout);
        panel11Layout.setHorizontalGroup(
            panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel11Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel11Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(NicNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel11Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel11Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Amount, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel11Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BankAccNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(268, 268, 268))
        );
        panel11Layout.setVerticalGroup(
            panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel11Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BankAccNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NicNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BankAccNumber.setText("");
        NicNumber.setText("");
        Amount.setText("");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Mainmenu MainObj = new Mainmenu();
        MainObj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        enter();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void BankAccNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BankAccNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BankAccNumberActionPerformed

    private void BankAccNumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BankAccNumberFocusGained
        if(BankAccNumber.getText().equals("0000-0000-0000-0000")){

        BankAccNumber.setText("");
        BankAccNumber.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_BankAccNumberFocusGained

    private void BankAccNumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BankAccNumberFocusLost
        if(BankAccNumber.getText().equals("")){

        BankAccNumber.setText("0000-0000-0000-0000");
        BankAccNumber.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_BankAccNumberFocusLost

    private void NicNumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NicNumberFocusGained
       if(NicNumber.getText().equals("000000000V")){

        NicNumber.setText("");
        NicNumber.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_NicNumberFocusGained

    private void NicNumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NicNumberFocusLost
       if(NicNumber.getText().equals("")){

        NicNumber.setText("000000000V");
        NicNumber.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_NicNumberFocusLost

    private void NicNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NicNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NicNumberActionPerformed

    private void AmountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AmountFocusGained
        if(Amount.getText().equals("0000.00")){

        Amount.setText("");
        Amount.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_AmountFocusGained

    private void AmountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AmountFocusLost
        if(Amount.getText().equals("")){

        Amount.setText("0000.00");
        Amount.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_AmountFocusLost

    
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
            java.util.logging.Logger.getLogger(DipositMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DipositMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DipositMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DipositMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DipositMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Amount;
    private javax.swing.JTextField BankAccNumber;
    private javax.swing.JTextField NicNumber;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private UI.Panel1 panel11;
    // End of variables declaration//GEN-END:variables
}
