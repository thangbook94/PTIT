
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import org.apache.commons.codec.digest.DigestUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MSI
 */
public class Registry extends javax.swing.JFrame {

    /**
     * Creates new form Registry
     */
    public Registry() {
        initComponents();
        this.setTitle("Đăng kí");
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        Action register = new AbstractAction("register") {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton1ActionPerformed(e);
            }
        };
        String key = "register";
        jButton1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, KeyEvent.MODIFIER_NONE), key);
        jButton1.getActionMap().put(key, register);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐĂNG KÝ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tên tài khoản (CMT)*");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Mật khẩu *");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Mật khẩu (nhập lại)*");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Email");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Ngày sinh");

        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });

        jPasswordField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyReleased(evt);
            }
        });

        jPasswordField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordField2FocusLost(evt);
            }
        });
        jPasswordField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordField2KeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Đăng kí");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel7.setText("(Tên tài khoản chỉ được nhập số)");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Họ và tên");

        jLabel9.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel9.setText("(Họ tên không chứa số và kí tự đặc biệt)");

        jLabel10.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel10.setText("(Ít nhất 8 kí tự, có kí tự in hoa, có 1 kí tự đặc biệt)");

        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField2MouseExited(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jCheckBox1.setText("Show password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Show password");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel11.setText("(Ví dụ: abc@gmail.com)");

        jLabel12.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel12.setText("(Ví dụ: dd/mm/yyy)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBox1)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4)
                            .addComponent(jPasswordField1)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1)
                            .addComponent(jPasswordField2)
                            .addComponent(jTextField5)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addComponent(jTextField2)
                            .addComponent(jCheckBox2)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(5, 5, 5)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String cmt = jTextField1.getText();
        boolean testcmt = true;
        MyConnection myconnection = new MyConnection();
        myconnection.connect();
        ResultSet da = myconnection.getData();
        String a;
        try {
            while (da.next()) {
                a = da.getString(1);
                if (cmt.equals(a)) {
                    testcmt = false;
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registry.class.getName()).log(Level.SEVERE, null, ex);
        }
        String s1 = new String(jPasswordField1.getPassword());
        String s2 = new String(jPasswordField2.getPassword());
        String s = jTextField1.getText();
        int hoa = 0, db = 0;
        for (char i : s1.toCharArray()) {
            if (i >= 'A' && i <= 'Z') {
                hoa++;
            } else if (!Character.isLetterOrDigit(i)) {
                db++;
            }
        }
        boolean testpass = false;
        if (hoa >= 1 && db >= 1) {
            testpass = true;
        }
        boolean isEmail = false;
        String email = jTextField4.getText();
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        isEmail = email.matches(regex);
        boolean isDate = false;
        String d = jTextField2.getText();
        String regexd = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
        isDate = d.matches(regexd);
        if (s.equals("") || s1.equals("") || s2.equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin");
            if (s.equals("")) {
                jTextField1.setBackground(Color.red);
            }
            if (s1.equals("")) {
                jPasswordField1.setBackground(Color.red);
            }
            if (s2.equals("")) {
                jPasswordField2.setBackground(Color.red);
            }
        } else if (testcmt == false) {
            JOptionPane.showMessageDialog(null, "cmt đã được đăng kí", "Cảnh báo", JOptionPane.ERROR_MESSAGE);
            jTextField1.setBackground(Color.red);
        } else if (testpass == false) {
            JOptionPane.showMessageDialog(null, "Password không đúng định dạng", "Cảnh báo", JOptionPane.ERROR_MESSAGE);
            jPasswordField1.setBackground(Color.red);
            jPasswordField2.setBackground(Color.red);
        } else if (!email.equals("") && isEmail == false) {

            JOptionPane.showMessageDialog(null, "Email không đúng định dạng", "Cảnh báo", JOptionPane.ERROR_MESSAGE);
            jTextField4.setBackground(Color.red);

        } else if (!d.equals("") && isDate == false) {
            JOptionPane.showMessageDialog(null, "Ngày tháng sinh không đúng định dạng", "Cảnh báo", JOptionPane.ERROR_MESSAGE);
            jTextField2.setBackground(Color.red);
        } else {
            jTextField4.setBackground(Color.white);

            String u1 = jTextField1.getText();

            String u2 = new String(jPasswordField1.getPassword());
            String encodePW = DigestUtils.sha1Hex(u2);
            System.out.println(encodePW);
            String u3 = jTextField4.getText();
            String u4 = jTextField5.getText();
            String date = jTextField2.getText();
            String u5 = "no";
            String u6 = "no";

            RegistryClass rc = new RegistryClass();
            rc.DangKi(u1, encodePW, u3, u4, date, u5, u6);
            JOptionPane.showMessageDialog(null, "Đăng kí thành công", "Thông báo", JOptionPane.PLAIN_MESSAGE);
            this.setVisible(false);
            // Login l=new Login();
            // l.setVisible(true);

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        char c = evt.getKeyChar();
        int i = evt.getKeyCode();
        jTextField1.setBackground(Color.white);
        if (c >= '0' && c <= '9' || i == KeyEvent.VK_BACKSPACE) {
            jTextField1.setEditable(true);

        } else {
            jTextField1.setEditable(false);

        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        if ((jTextField1.getText() + evt.getKeyChar()).length() > 12) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
        char c = evt.getKeyChar();

        if (Character.isAlphabetic(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
            jTextField5.setEditable(true);
            // jTextField5.setBackground(Color.white);

        } else {
            jTextField5.setEditable(false);
            // jTextField5.setBackground(Color.red);

        }
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        if ((jTextField5.getText() + evt.getKeyChar()).length() > 50) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed

    }//GEN-LAST:event_jPasswordField1KeyPressed

    private void jPasswordField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField2KeyPressed

    }//GEN-LAST:event_jPasswordField2KeyPressed

    private void jPasswordField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField2FocusGained

    private void jPasswordField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField2FocusLost

    }//GEN-LAST:event_jPasswordField2FocusLost

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost

    }//GEN-LAST:event_jTextField2FocusLost

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        if (jCheckBox2.isSelected()) {
            jPasswordField2.setEchoChar((char) 0);
        } else {
            jPasswordField2.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            jPasswordField1.setEchoChar((char) 0);
        } else {
            jPasswordField1.setEchoChar('*');
        }

    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jTextField2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseExited

    }//GEN-LAST:event_jTextField2MouseExited

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        boolean isDate = false;
        String s = jTextField2.getText();
        String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
        isDate = s.matches(regex);
        if (isDate == true) {
            jTextField2.setBackground(Color.white);
        } else {
            jTextField2.setBackground(Color.red);
        }
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jPasswordField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyReleased
        String s = new String(jPasswordField1.getPassword());

        int l = s.length();

        if (l >= 8) {
            jPasswordField1.setBackground(Color.white);
        } else {
            jPasswordField1.setBackground(Color.red);
        }
    }//GEN-LAST:event_jPasswordField1KeyReleased

    private void jPasswordField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField2KeyReleased
        String s2 = new String(jPasswordField2.getPassword());
        String s1 = new String(jPasswordField1.getPassword());
        if (s2.equals(s1)) {
            jPasswordField2.setBackground(Color.white);
        } else {
            jPasswordField2.setBackground(Color.red);
        }
    }//GEN-LAST:event_jPasswordField2KeyReleased

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        String ss = jTextField1.getText();
        if (ss.length() > 8) {
            jTextField1.setBackground(Color.white);
        } else {
            jTextField1.setBackground(Color.red);
        }
    }//GEN-LAST:event_jTextField1KeyReleased

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
            java.util.logging.Logger.getLogger(Registry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
