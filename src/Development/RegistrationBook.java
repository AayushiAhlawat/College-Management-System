
package Com.Dufins.Developer.STManagement.Forms;

import Com.Dufins.Developer.LoginPkg.Login;
import Util.Util;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;


public class RegistrationBook extends javax.swing.JFrame {

    
    StudentInformationServices st = null;
    SISReport sr = null;
    StudentReport rs = null;

    public RegistrationBook() {
        initComponents();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                setExtendedState(MAXIMIZED_BOTH);
            }
        });
        Image im = null;
        try {
            im = ImageIO.read(getClass().getResource("/Image/icon_2.png"));
        } catch (IOException ex) {
        }
        setIconImage(im);
        ImageIcon leafIcon = createImageIcon("/Image/minus.png");
        if (leafIcon != null) {
            DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
            renderer.setLeafIcon(leafIcon);
            renderer.setOpenIcon(leafIcon);
            renderer.setClosedIcon(null);

            jtree_Menu.setCellRenderer(renderer);
        }
        getUser();

    }

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = RegistrationBook.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    private void getUser() {
        try {
            try (Connection connection = Util.getConnection();
                    Statement stm = connection.createStatement();
                    ResultSet rs = stm.executeQuery("select username from login where active = 'Y' ")) {
                if (rs.next()) {
                    jMenu1.setText(rs.getString(1).toUpperCase());
                } else {
                    jMenu1.setText("Guest".toUpperCase());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        imagePanel1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtree_Menu = new javax.swing.JTree();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("(Registration Book) cmsDufins Version 1.0");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        imagePanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Registration Book");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Student Information Services");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Student Details");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Student Information Reports");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Student's Report");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Payment's Report");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jtree_Menu.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jtree_Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtree_MenuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtree_Menu);

        jMenu6.setText("USER ID:");
        jMenuBar1.add(jMenu6);

        jMenu1.setText("jMenu1");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("|");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Login Time:");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("jMenu4");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("|");
        jMenuBar1.add(jMenu5);

        jMenu7.setText("Date:");
        jMenuBar1.add(jMenu7);

        jMenu8.setText("jMenu8");
        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(imagePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );

        pack();
    }

    private void formWindowClosed(java.awt.event.WindowEvent evt) {
      
        Login l = new Login();
        l.setVisible(true);
    }

    private void jtree_MenuMouseClicked(java.awt.event.MouseEvent evt) {
       
        TreePath selectionPath = jtree_Menu.getSelectionPath();
        System.out.println(selectionPath);
        String selected = selectionPath.getLastPathComponent().toString();
        System.out.println(selected);
        int width_Imagepanel = imagePanel1.getWidth();
        int height_Imagepanel = imagePanel1.getHeight();

        switch (selected) {
            case "Student Details":
                st = new StudentInformationServices();
                imagePanel1.removeAll();
                st.setBounds(0, 0, width_Imagepanel, height_Imagepanel);
                imagePanel1.add(st);
                st.setVisible(true);
                this.repaint();
                break;

            case "Student's Report":
                sr = new SISReport();
                imagePanel1.removeAll();
                sr.setBounds(0, 0, width_Imagepanel, height_Imagepanel);
                imagePanel1.add(sr);
                sr.setVisible(true);
                this.repaint();
                break;

            case "Payment's Report":
                rs = new StudentReport();
                imagePanel1.removeAll();
                rs.setBounds(0, 0, width_Imagepanel, height_Imagepanel);
                imagePanel1.add(rs);
                rs.setVisible(true);
                this.repaint();
                break;
        }
    }
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistrationBook().setVisible(true);
            }
        });
    }
   
    private javax.swing.JDesktopPane imagePanel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jtree_Menu;
   
}
