
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;



/**
 *
 * @author Joshua
 */
public class RemoveStudent extends javax.swing.JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    DefaultTableModel model = new DefaultTableModel();


    /**
     * Creates new form RemoveStudent
     */
    public RemoveStudent() {
        initComponents();
        setLocationRelativeTo(null);
         View();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        sid = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel2.setText("Remove Student");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(60, 10, 360, 60);

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setText("Exit");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(1000, 10, 100, 31);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Student Id");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 130, 120, 40);

        sid.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jPanel1.add(sid);
        sid.setBounds(179, 140, 250, 40);

        table.setAutoCreateRowSorter(true);
        table.setBackground(new java.awt.Color(204, 204, 204));
        table.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        table.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Mobile  NO.", "Gender", "Father's Name", "Mother's Name", "DOB", "Age", "Course1", "Course2", "Course3", "Course4"
            }
        ));
        table.setPreferredSize(new java.awt.Dimension(700, 64));
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 210, 1200, 310);

        jButton2.setBackground(new java.awt.Color(204, 255, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton2.setText("Remove Student Data");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(1000, 140, 270, 37);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atlantic-blurred-background.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1490, 810);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1490, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         JDialog.setDefaultLookAndFeelDecorated(true);
       int response = JOptionPane.showConfirmDialog(null,"Do you want to EXIT?",   "Confirm" ,
               JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
       if(response == JOptionPane.YES_NO_OPTION){
         setVisible(false);
         Admin a = new Admin();
         a.setVisible(true);
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         try{
           Class.forName("com.mysql.jdbc.Driver");
             try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","")) {
                 String sql = "DELETE from studentinfo WHERE  ID = ?";
                 PreparedStatement pst = con.prepareStatement(sql);
                 pst.setString(1, sid.getText());
                 pst.execute();
                 JOptionPane.showMessageDialog(null,"Given Id is deleted from records.. ");
             }
        }
        catch(HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_jButton2ActionPerformed
public void View() { 
    try{
Class.forName("com.mysql.jdbc.Driver");
                  try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","")) {
                      String sql ="SELECT * FROM studentinfo";
        pst=con.prepareStatement(sql);
        rs=pst.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
        pst.close();
                      }
                  catch(Exception e){
                     JOptionPane.showMessageDialog(null, e); 
                  }
    }
                      catch(HeadlessException | ClassNotFoundException e){
                       JOptionPane.showMessageDialog(null, e);   
                      }
                      
                      
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RemoveStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RemoveStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RemoveStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RemoveStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RemoveStudent().setVisible(true);
            }
        });
    }

    // Variables declaration //GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField sid;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
