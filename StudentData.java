
import java.awt.HeadlessException;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JOptionPane; 
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;



/**
 *
 * @author Joshua
 */
public class StudentData extends javax.swing.JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form StudentData
     */
    public StudentData() {
        initComponents();
        setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        sid = new javax.swing.JTextField();
        sname = new javax.swing.JTextField();
        smobno = new javax.swing.JTextField();
        sgender = new javax.swing.JTextField();
        sfname = new javax.swing.JTextField();
        sfoccupation = new javax.swing.JTextField();
        sdob = new javax.swing.JTextField();
        sage = new javax.swing.JTextField();
        scaste = new javax.swing.JTextField();
        scity = new javax.swing.JTextField();
        sstate = new javax.swing.JTextField();
        squlification = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        int XAB;
        int a;
        int b;
        int c;
        int d;
        String atext;
        String btext;
        String ctext;
        String dtext;

        jPanel2.setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1290, 900));
        getContentPane().setLayout(null);





        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Student Info");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(515, 20, 220, 40);

        area.setBackground(new java.awt.Color(204, 255, 255));
        area.setColumns(20);
        area.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        area.setRows(5);
        area.setEnabled(false);
        jScrollPane1.setViewportView(area);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(290, 80, 630, 500);


        jButton2.setBackground(new java.awt.Color(102, 102, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Exit");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(330, 600, 120, 40);

        jButton3.setBackground(new java.awt.Color(102, 102, 255));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("View");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(740, 600, 120, 40);


        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/darkblurbg.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1290, 820);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JDialog.setDefaultLookAndFeelDecorated(true);
        int response = JOptionPane.showConfirmDialog(null,"Do you want to EXIT?",   "Confirm" ,
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(response == JOptionPane.YES_NO_OPTION){
            setVisible(false);
            Student a = new Student();
            a.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","");
            String sql1 = "SELECT ID AS X FROM SIGNINDATA;";
            pst = conn.prepareStatement(sql1);
            rs = pst.executeQuery();
            while (rs.next()) {
                XAB = rs.getInt("X");
                System.out.println(XAB);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        try{
            Class.forName("com.mysql.jdbc.Driver");
                                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","")) {
                                PreparedStatement pst = con.prepareStatement("SELECT MATH as x FROM marks WHERE ID = ?");
            pst.setObject(1, XAB);
                    rs=pst.executeQuery();
                    if (rs.next()) {
                        a=rs.getInt("x");}
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
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                                        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","")) {
                                        PreparedStatement pst = con.prepareStatement("SELECT ENGLISH as x FROM marks WHERE ID = ?");
                    pst.setObject(1, XAB);
                            rs=pst.executeQuery();
                            if (rs.next()) {
                                b=rs.getInt("x");}
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
    
            try{
                Class.forName("com.mysql.jdbc.Driver");
                                    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","")) {
                                    PreparedStatement pst = con.prepareStatement("SELECT ICT as x FROM marks WHERE ID = ?");
                pst.setObject(1, XAB);
                        rs=pst.executeQuery();
                        if (rs.next()) {
                            c=rs.getInt("x");}
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
    
    
    
    
            try{
                Class.forName("com.mysql.jdbc.Driver");
                                    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","")) {
                                    PreparedStatement pst = con.prepareStatement("SELECT PHYSICS as x FROM marks WHERE ID = ?");
                pst.setObject(1, XAB);
                        rs=pst.executeQuery();
                        if (rs.next()) {
                            d=rs.getInt("x");}
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

                                        if(a>=60)
                                        {
                                            atext = "Recommended";
                                        }
                                        else{
                                            atext = "Not Recommended";
                                        }

                                        if(b>=60)
                                        {
                                            btext = "Recommended";
                                        }
                                        else{
                                            btext = "Not Recommended";
                                        }

                                        if(c>=60)
                                        {
                                            ctext = "Recommended";
                                        }
                                        else{
                                            ctext = "Not Recommended";
                                        }
                                        if(d>=60)
                                        {
                                            dtext = "Recommended";
                                        }
                                        else{
                                            dtext = "Not Recommended";
                                        }
        try{
            area.setText("****************************************************\n");
            area.setText(area.getText()+"              RECOMMENDATION STATUS                   \n");
            area.setText(area.getText()+"***************************************************\n");

            area.setText(area.getText()+"\n");

            area.setText(area.getText()+"MATH:     "+Integer.toString(a)+" - "+atext+"\n");
            area.setText(area.getText()+"ENGLISH:  "+Integer.toString(b)+" - "+btext+"\n");
            area.setText(area.getText()+"ICT:      "+Integer.toString(c)+" - "+ctext+"\n");
            area.setText(area.getText()+"PHYSICS:  "+Integer.toString(d)+" - "+dtext+"\n");

        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed



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
            java.util.logging.Logger.getLogger(StudentData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentData().setVisible(true);
            }
        });
    }

    // Variables declaration //GEN-BEGIN:variables
    private javax.swing.JTextArea area;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField sage;
    private javax.swing.JTextField scaste;
    private javax.swing.JTextField scity;
    private javax.swing.JTextField sdob;
    private javax.swing.JTextField sfname;
    private javax.swing.JTextField sfoccupation;
    private javax.swing.JTextField sgender;
    private javax.swing.JTextField sid;
    private javax.swing.JTextField smobno;
    private javax.swing.JTextField sname;
    private javax.swing.JTextField squlification;
    private javax.swing.JTextField sstate;
    private int XAB;
    private int a;
    private int b;
    private int c;
    private int d;
    private String atext;
    private String btext;
    private String ctext;
    private String dtext;
    // End of variables declaration//GEN-END:variables
}
