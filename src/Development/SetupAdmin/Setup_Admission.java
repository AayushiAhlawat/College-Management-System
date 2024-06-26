
package Com.Dufins.Developer.SetupAdmin;

import Com.Dufins.Developer.LoginPkg.Login;
import Util.Coloumnautosizer;
import Util.Util;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;


public class Setup_Admission extends javax.swing.JFrame {

    
    Connection con = null;
    PreparedStatement psmnt = null;
    Statement stmt = null;
    ResultSet rs = null;
    String user = null;
    String timeset = null;
     int count = 0;
    String pass = null;
    private SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
    private int currentSecond;
    private Calendar calendar;

    public Setup_Admission() {
        initComponents();
    }

    private void reset() {
        calendar = Calendar.getInstance();
        currentSecond = calendar.get(Calendar.SECOND);
    }

    public void start() {

        reset();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                if (currentSecond == 60) {
                    reset();
                }
                timeset = String.format("%s", sdf.format(calendar.getTime()));
                currentSecond++;
                jMenu_time.setText(timeset);

            }
        }, 0, 1000);
    }

    public void dateFormat() {
        Object unit = combo_dateformat.getSelectedItem();
        String cd = unit.toString();
        Date d = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(cd);
        String s = formatter.format(d);
        txt_dateformat.setText(s);
    }

    public void retriveDateformat() {
        try {
            con = Util.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from dateformat");
            if (rs.next()) {
                Date d = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat(rs.getString(1));
                String s = formatter.format(d);
                jMenu_Date.setText(s);
            }
        } catch (Exception e) {
        }
    }

    public void updateDateFormat() {
        Object unit = combo_dateformat.getSelectedItem();
        String cd = unit.toString();
        try {
            con = Util.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from dateformat");
            if (rs.next()) {
                stmt.executeUpdate("update dateformat set dateformat='" + cd + "' where dateformat='" + rs.getString(1) + "'");

            }

        } catch (Exception e) {
        }
    }

   
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        Dialog_DateFormat = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        combo_dateformat = new javax.swing.JComboBox();
        txt_dateformat = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        Button_Set = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_fee = new javax.swing.JTable(){

            public boolean isCellEditable(int row,int column){
                if(column == 0)
                return false;//the 0th column is not editable
                return true;
            }}
            ;
            rb_2 = new javax.swing.JRadioButton();
            rb_1 = new javax.swing.JRadioButton();
            jButton1 = new javax.swing.JButton();
            jScrollPane2 = new javax.swing.JScrollPane();
            tb_Other = new javax.swing.JTable()
            {

                public boolean isCellEditable(int row,int column){
                    if(column == 0)
                    return false;//the 0th column is not editable
                    return true;
                }}
                ;
                jPanel2 = new javax.swing.JPanel();
                jPanel3 = new javax.swing.JPanel();
                cb_course = new javax.swing.JComboBox();
                cb_branch = new javax.swing.JComboBox();
                jButton2 = new javax.swing.JButton();
                jButton3 = new javax.swing.JButton();
                btn_del = new javax.swing.JButton();
                jButton5 = new javax.swing.JButton();
                jLabel2 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jPanel4 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                txt_Keyword = new javax.swing.JTextField();
                jSeparator1 = new javax.swing.JSeparator();
                jScrollPane3 = new javax.swing.JScrollPane();
                table_Login = new javax.swing.JTable();
                jPanel5 = new javax.swing.JPanel();
                jLabel3 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                jLabel6 = new javax.swing.JLabel();
                btnAddUser = new javax.swing.JButton();
                txtUserName = new javax.swing.JTextField();
                txtPassword = new javax.swing.JTextField();
                cmb_UserType = new javax.swing.JComboBox();
                jPanel8 = new javax.swing.JPanel();
                jLabel7 = new javax.swing.JLabel();
                jLabel8 = new javax.swing.JLabel();
                txtFRoll = new javax.swing.JTextField();
                txtFrcp = new javax.swing.JTextField();
                btnRollSubmit = new javax.swing.JButton();
                brnRcpSubmit = new javax.swing.JButton();
                jMenuBar1 = new javax.swing.JMenuBar();
                jMenu_Date = new javax.swing.JMenu();
                jMenu1 = new javax.swing.JMenu();
                jMenu_time = new javax.swing.JMenu();

                Dialog_DateFormat.setTitle("Dufins Billing Software Version 1.2");
                Dialog_DateFormat.setUndecorated(true);

                jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Date Format", 2, 3, new java.awt.Font("Arial", 1, 18), new java.awt.Color(102, 0, 0))); // NOI18N

                jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
                jLabel27.setText("Select Date Format");

                jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
                jLabel28.setText(" Date Format Sample");

                combo_dateformat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "dd/MM/yy", "dd.MM.yy", "dd-MM-yy", "dd/MM/YYYY", "dd.MM.YYYY", "dd-MM-YYYY", "dd-MMM-yy", "dd.MMM.yy", "dd/MMM/yy", "dd-MMM-YYYY", "dd/MMM/YYYY", "dd.MMM.YYYY" }));
                combo_dateformat.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        combo_dateformatActionPerformed(evt);
                    }
                });
                combo_dateformat.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        combo_dateformatKeyPressed(evt);
                    }
                });

                txt_dateformat.setEditable(false);
                txt_dateformat.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        txt_dateformatActionPerformed(evt);
                    }
                });

                jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
                jLabel29.setText("Legend");

                jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
                jLabel30.setText("DD - Day");

                jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
                jLabel31.setText("MM- Month");

                jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
                jLabel34.setText("YY- Year");

                Button_Set.setText("Set");
                Button_Set.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        Button_SetActionPerformed(evt);
                    }
                });
                Button_Set.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        Button_SetKeyPressed(evt);
                    }
                });

                javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
                jPanel7.setLayout(jPanel7Layout);
                jPanel7Layout.setHorizontalGroup(
                    jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(combo_dateformat, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_dateformat, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Button_Set))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jPanel7Layout.setVerticalGroup(
                    jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combo_dateformat)
                            .addComponent(txt_dateformat, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_Set)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel34)
                        .addGap(0, 0, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout Dialog_DateFormatLayout = new javax.swing.GroupLayout(Dialog_DateFormat.getContentPane());
                Dialog_DateFormat.getContentPane().setLayout(Dialog_DateFormatLayout);
                Dialog_DateFormatLayout.setHorizontalGroup(
                    Dialog_DateFormatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                );
                Dialog_DateFormatLayout.setVerticalGroup(
                    Dialog_DateFormatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setTitle("Setup Master");
                addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosed(java.awt.event.WindowEvent evt) {
                        formWindowClosed(evt);
                    }
                    public void windowOpened(java.awt.event.WindowEvent evt) {
                        formWindowOpened(evt);
                    }
                    public void windowClosing(java.awt.event.WindowEvent evt) {
                        formWindowClosing(evt);
                    }
                });

                jPanel1.setBackground(new java.awt.Color(255, 255, 255));

                table_fee.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                    },
                    new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                    }
                ));
                table_fee.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                table_fee.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                    public void propertyChange(java.beans.PropertyChangeEvent evt) {
                        table_feePropertyChange(evt);
                    }
                });
                jScrollPane1.setViewportView(table_fee);
                jScrollPane1.getViewport().setBackground(Color.white);
                table_fee.setShowVerticalLines(true);

                rb_2.setBackground(new java.awt.Color(255, 255, 255));
                buttonGroup1.add(rb_2);
                rb_2.setText("B.Tech(JCECB)");
                rb_2.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        rb_2ActionPerformed(evt);
                    }
                });

                rb_1.setBackground(new java.awt.Color(255, 255, 255));
                buttonGroup1.add(rb_1);
                rb_1.setText("B.Tech");
                rb_1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        rb_1ActionPerformed(evt);
                    }
                });

                jButton1.setText("Refresh");
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton1ActionPerformed(evt);
                    }
                });

                tb_Other.setAutoCreateRowSorter(true);
                tb_Other.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                    },
                    new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                    }
                ));
                tb_Other.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                    public void propertyChange(java.beans.PropertyChangeEvent evt) {
                        tb_OtherPropertyChange(evt);
                    }
                });
                jScrollPane2.setViewportView(tb_Other);

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rb_1)
                                .addGap(62, 62, 62)
                                .addComponent(rb_2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(366, Short.MAX_VALUE))
                );
                jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rb_2)
                            .addComponent(rb_1)
                            .addComponent(jButton1))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE))
                        .addContainerGap())
                );

                jTabbedPane1.addTab("Fee Details", jPanel1);

                jPanel2.setBackground(new java.awt.Color(255, 255, 255));

                jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Course", 0, 0, new java.awt.Font("Tahoma", 1, 12), java.awt.Color.black)); // NOI18N

                cb_course.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        cb_courseActionPerformed(evt);
                    }
                });

                jButton2.setText("add");
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton2ActionPerformed(evt);
                    }
                });

                jButton3.setText("add");
                jButton3.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton3ActionPerformed(evt);
                    }
                });

                btn_del.setText("Del");
                btn_del.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_delActionPerformed(evt);
                    }
                });

                jButton5.setText("Del");
                jButton5.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton5ActionPerformed(evt);
                    }
                });

                jLabel2.setText("Course");

                jLabel4.setText("Branch");

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                    jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cb_course, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_del))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cb_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5)))
                        .addContainerGap(62, Short.MAX_VALUE))
                );
                jPanel3Layout.setVerticalGroup(
                    jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)
                            .addComponent(btn_del)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3)
                            .addComponent(jButton5)
                            .addComponent(jLabel4))
                        .addContainerGap(24, Short.MAX_VALUE))
                );

                jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login Details", 0, 0, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

                jLabel1.setText("Search username");

                txt_Keyword.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        txt_KeywordKeyReleased(evt);
                    }
                });

                table_Login.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                    },
                    new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                    }
                ));
                table_Login.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                    public void propertyChange(java.beans.PropertyChangeEvent evt) {
                        table_LoginPropertyChange(evt);
                    }
                });
                table_Login.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        table_LoginKeyPressed(evt);
                    }
                });
                jScrollPane3.setViewportView(table_Login);

                jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                jLabel3.setText("Enter User Name :-");

                jLabel5.setText("Enter Password :-");

                jLabel6.setText("Enter User Type :-");

                btnAddUser.setText("Add User");
                btnAddUser.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnAddUserActionPerformed(evt);
                    }
                });

                txtUserName.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        txtUserNameMouseEntered(evt);
                    }
                });

                txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        txtPasswordMouseEntered(evt);
                    }
                });

                cmb_UserType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Account", "Registration", "Library", "HR" }));

                javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
                jPanel5.setLayout(jPanel5Layout);
                jPanel5Layout.setHorizontalGroup(
                    jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUserName)
                                    .addComponent(txtPassword)
                                    .addComponent(cmb_UserType, 0, 189, Short.MAX_VALUE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(btnAddUser)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jPanel5Layout.setVerticalGroup(
                    jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cmb_UserType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddUser)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
                jPanel4.setLayout(jPanel4Layout);
                jPanel4Layout.setHorizontalGroup(
                    jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator1))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_Keyword, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                jPanel4Layout.setVerticalGroup(
                    jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_Keyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Start Roll Number & Reciept Number", 0, 0, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

                jLabel7.setText("Enter Roll Number");

                jLabel8.setText("Enter Reciept Number");

                btnRollSubmit.setText("Submit");
                btnRollSubmit.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnRollSubmitActionPerformed(evt);
                    }
                });

                brnRcpSubmit.setText("Submit");
                brnRcpSubmit.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        brnRcpSubmitActionPerformed(evt);
                    }
                });

                javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
                jPanel8.setLayout(jPanel8Layout);
                jPanel8Layout.setHorizontalGroup(
                    jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(txtFRoll, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRollSubmit))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(txtFrcp, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(brnRcpSubmit)))
                        .addContainerGap(23, Short.MAX_VALUE))
                );
                jPanel8Layout.setVerticalGroup(
                    jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtFRoll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRollSubmit))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFrcp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(brnRcpSubmit)
                            .addComponent(jLabel8))
                        .addContainerGap(14, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(349, 349, 349))
                );
                jPanel2Layout.setVerticalGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                );

                jTabbedPane1.addTab("Other Details", jPanel2);

                jMenu_Date.setForeground(new java.awt.Color(0, 0, 204));
                jMenu_Date.setText("Date");
                jMenu_Date.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jMenu_Date.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                        jMenu_DateMousePressed(evt);
                    }
                });
                jMenuBar1.add(jMenu_Date);

                jMenu1.setText("l");
                jMenu1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
                jMenuBar1.add(jMenu1);

                jMenu_time.setForeground(new java.awt.Color(0, 0, 204));
                jMenu_time.setText("Time");
                jMenu_time.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jMenuBar1.add(jMenu_time);

                setJMenuBar(jMenuBar1);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                );

                pack();
            }

    private void jMenu_DateMousePressed(java.awt.event.MouseEvent evt) {
       
        int code = evt.getClickCount();
        if (code == 2) {
            Dialog_DateFormat.setBounds(350, 60, 440, 160);
            Dialog_DateFormat.setVisible(true);
        }
    }

    private void combo_dateformatActionPerformed(java.awt.event.ActionEvent evt) {
       
        dateFormat();
    }

    private void combo_dateformatKeyPressed(java.awt.event.KeyEvent evt) {
      
        int code = evt.getKeyCode();
        if (code == java.awt.event.KeyEvent.VK_ENTER) {
            Button_Set.requestFocus();
        } else if (code == java.awt.event.KeyEvent.VK_ESCAPE) {
            Dialog_DateFormat.dispose();
        }
    }

    private void txt_dateformatActionPerformed(java.awt.event.ActionEvent evt) {
       
    }

    private void Button_SetActionPerformed(java.awt.event.ActionEvent evt) {
       
        updateDateFormat();
        retriveDateformat();
        Dialog_DateFormat.dispose();
    }

    private void Button_SetKeyPressed(java.awt.event.KeyEvent evt) {
        
        int code = evt.getKeyCode();
        if (code == java.awt.event.KeyEvent.VK_ENTER) {
            updateDateFormat();
            Dialog_DateFormat.dispose();
        }
    }
    public void retrievebtech() {
        try {
            con = Util.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from fee_btech");

            table_fee.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
            Coloumnautosizer.sizeColumnsToFit(table_fee);


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void retrievebtech_j() {
        try {
            con = Util.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from fee_btech_jcecb");
            table_fee.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
            Coloumnautosizer.sizeColumnsToFit(table_fee);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {
   
        rb_1.setSelected(true);
        retrieveLogin();
        retrieveOther();
        retrievebtech();
        retrieveCourse();
        retrieveBranch();

        start();
        try {
            con = Util.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from dateformat");
            if (rs.next()) {
                Date d = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat(rs.getString(1));
                String s = formatter.format(d);
                jMenu_Date.setText(s);
            }
        } catch (Exception e) {
        }
    }

    private void rb_2ActionPerformed(java.awt.event.ActionEvent evt) {
     
        if (rb_2.isSelected()) {
            retrievebtech_j();
        }

    }

    private void rb_1ActionPerformed(java.awt.event.ActionEvent evt) {
        
        if (rb_1.isSelected()) {
            retrievebtech();
        }
    }

    private void table_feePropertyChange(java.beans.PropertyChangeEvent evt) {

        int row = table_fee.getSelectedRow();
        int col = table_fee.getSelectedColumn();
        if (row >= 0 || col >= 0) {
            String selected = table_fee.getColumnName(col);
            int value = 0;
            try {
                value = Integer.parseInt(table_fee.getValueAt(row, col).toString());
            } catch (Exception e) {
            }

            try {
             

                con = Util.getConnection();

                if (rb_1.isSelected()) {
                    int tot = 0;
                    psmnt = con.prepareStatement("update fee_btech set " + selected + "=? where fee_type=?");
                    psmnt.setInt(1, value);
                    psmnt.setString(2, table_fee.getValueAt(row, 0).toString());
                    psmnt.executeUpdate();
                    psmnt = con.prepareStatement("select sum(" + selected + ") from fee_btech where fee_type <> 'TOTAL'");
                    rs = psmnt.executeQuery();
                    while (rs.next()) {
                        tot = rs.getInt(1);
                    }
                    psmnt = con.prepareStatement("update fee_btech set " + selected + "=" + tot + " where fee_type = 'TOTAL'");
                    psmnt.executeUpdate();


                }
                if (rb_2.isSelected()) {
                    int tot = 0;
                    psmnt = con.prepareStatement("update fee_btech_jcecb set " + selected + "=? where fee_type=?");
                    psmnt.setInt(1, value);
                    psmnt.setString(2, table_fee.getValueAt(row, 0).toString());
                    psmnt.executeUpdate();
                    psmnt = con.prepareStatement("select sum(" + selected + ") from fee_btech_jcecb where fee_type <> 'TOTAL'");
                    rs = psmnt.executeQuery();
                    while (rs.next()) {
                        tot = rs.getInt(1);
                    }
                    psmnt = con.prepareStatement("update fee_btech_jcecb set " + selected + "=" + tot + " where fee_type = 'TOTAL'");
                    psmnt.executeUpdate();

                }


            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                Util.closeResultset(rs);
                Util.closeStatement(psmnt);
                Util.closeConnection(con);
            }
        }

    }
    public void retrieveCourse() {

        ArrayList course = new ArrayList();
        cb_course.removeAllItems();
        try {
            con = Util.getConnection();
            psmnt = con.prepareStatement("select course from course");
            rs = psmnt.executeQuery();
            while (rs.next()) {
                course.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < course.size(); i++) {
            cb_course.addItem(course.get(i));
        }
    }

    public void retrieveBranch() {
        ArrayList course = new ArrayList();
        cb_branch.removeAllItems();
        Object obj = cb_course.getSelectedItem();
        if (obj != null) {
            try {
                con = Util.getConnection();
                psmnt = con.prepareStatement("select branch from branch where course ='" + cb_course.getSelectedItem().toString() + "'");
                rs = psmnt.executeQuery();
                while (rs.next()) {
                    course.add(rs.getString(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < course.size(); i++) {
                cb_branch.addItem(course.get(i));
            }
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
       
        if (rb_1.isSelected()) {
            retrievebtech();
        } else if (rb_2.isSelected()) {
            retrievebtech_j();

        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        
        String input = JOptionPane.showInputDialog(pass);
        try {
            con = Util.getConnection();
            psmnt = con.prepareStatement("select course from course where course = '" + input + "'");
            rs = psmnt.executeQuery();
            if (!rs.next()) {
                psmnt = con.prepareStatement("insert into course value(?)");
                psmnt.setString(1, input);
                psmnt.executeUpdate();
            } else {
                JOptionPane.showMessageDialog(null, "This course already exists.");
            }
        } catch (SQLException e) {
        }
        retrieveCourse();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
       
        String input = JOptionPane.showInputDialog(pass);
        try {
            con = Util.getConnection();
            psmnt = con.prepareStatement("select course,branch from branch where branch = '" + input + "' and course = '" + cb_course.getSelectedItem().toString() + "'");
            rs = psmnt.executeQuery();
            if (!rs.next()) {
                psmnt = con.prepareStatement("insert into branch value(?,?)");
                psmnt.setString(1, cb_course.getSelectedItem().toString());
                psmnt.setString(2, input);
                psmnt.executeUpdate();
            } else {
                JOptionPane.showMessageDialog(null, "This branch for the selected course already exists.");
            }
        } catch (SQLException e) {
        }
        retrieveBranch();
    }

    private void cb_courseActionPerformed(java.awt.event.ActionEvent evt) {
       
        retrieveBranch();
    }

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {
        try {
         
            con = Util.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate("delete  from branch where course = '" + cb_course.getSelectedItem().toString() + "'");
            stmt.executeUpdate("delete  from course where course = '" + cb_course.getSelectedItem().toString() + "'");
            retrieveCourse();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
            
            con = Util.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate("delete  from branch where course = '" + cb_course.getSelectedItem().toString() + "' and branch ='" + cb_branch.getSelectedItem().toString() + "'");
                          
            retrieveBranch();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void retrieveOther() {
        try {
            con = Util.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from other_fee");

            tb_Other.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
            Coloumnautosizer.sizeColumnsToFit(tb_Other);


        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }

    private void tb_OtherPropertyChange(java.beans.PropertyChangeEvent evt) {
        int row = tb_Other.getSelectedRow();
        int col = tb_Other.getSelectedColumn();
        if (row >= 0 || col >= 0) {
            int value = 0;
            try {
                value = Integer.parseInt(tb_Other.getValueAt(row, 1).toString());
            } catch (Exception e) {
            }

            try {
               
                con = Util.getConnection();
                psmnt = con.prepareStatement("update other_fee set fee_amount=? where attribute=?");
                psmnt.setInt(1, value);
                psmnt.setString(2, tb_Other.getValueAt(row, 0).toString());
                psmnt.executeUpdate();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }  finally {
                Util.closeResultset(rs);
                Util.closeStatement(psmnt);
                Util.closeConnection(con);
            }
        }

    }

    public void retrieveLogin() {
        try {
            con = Util.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from Login");

            table_Login.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
            Coloumnautosizer.sizeColumnsToFit(table_Login);


        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Admin");
        comboBox.addItem("Accounts");
        comboBox.addItem("Registration");
        comboBox.addItem("Library");


        table_Login.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(comboBox));
 
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setToolTipText("Click for User");
        table_Login.getColumnModel().getColumn(2).setCellRenderer(renderer);
    }

    private void txt_KeywordKeyReleased(java.awt.event.KeyEvent evt) {
        try {
            con = Util.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from Login where username like '" + txt_Keyword.getText() + "%'");

            table_Login.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
            Coloumnautosizer.sizeColumnsToFit(table_Login);


        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }

    public int validAdmin()
    {
        String s[][]=new String[100][100];

          count = 0;
            int nCol = table_Login.getColumnCount();
            int nRow = table_Login.getRowCount();
            Object[][] tableData = new Object[nRow][nCol];
            for (int i = 0 ; i < nRow ; i++)
             {                                
                    tableData[i][2] = table_Login.getValueAt(i,2);
                    s[i][2]  = tableData[i][2].toString();  
                    if((s[i][2].equals("Admin")))
                    {
                     count++;
                    }             
             }
            if(count>0)
             return count;
            else
             return count;

    }
    private void table_LoginPropertyChange(java.beans.PropertyChangeEvent evt) {
              
        int row = table_Login.getSelectedRow();
        int col = table_Login.getSelectedColumn();
        if (row >= 0 || col >= 0) {
            String selected = table_Login.getColumnName(col);
            try {
                
                con = Util.getConnection();
                psmnt = con.prepareStatement("update login set " + selected + "=? where username=?");
                psmnt.setString(1, table_Login.getValueAt(row, col).toString());
                psmnt.setString(2, table_Login.getValueAt(row, 0).toString());
                int a = psmnt.executeUpdate();
                if(a>0)
                {
                    JOptionPane.showMessageDialog(this, "Data successfully updated.");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }  finally {
                Util.closeResultset(rs);
                Util.closeStatement(psmnt);
                Util.closeConnection(con);
            }
        }
    }

    private void table_LoginKeyPressed(java.awt.event.KeyEvent evt) {
              
        int row = table_Login.getSelectedRow();
        int col = table_Login.getSelectedColumn();
        System.out.println("Row"+row);
        System.out.println("Col"+col);
            try {

                con = Util.getConnection();
        
                if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE)
                {
                if (validAdmin()>1) {
                    psmnt = con.prepareStatement("delete from login where username = ?");
                    psmnt.setString(1, table_Login.getValueAt(row, 0).toString());
                    int a = psmnt.executeUpdate();
                    if(a>0)
                        JOptionPane.showMessageDialog(null, "Successfully deleted");
                }
                else if(validAdmin() == 1 && !(table_Login.getValueAt(row, 2).toString().equals("Admin")))
                {
                    psmnt = con.prepareStatement("delete from login where username = ?");
                    psmnt.setString(1, table_Login.getValueAt(row, 0).toString());
                    int a = psmnt.executeUpdate();
                    if(a>0)
                        JOptionPane.showMessageDialog(null, "Successfully deleted");
                }
                else
                    JOptionPane.showMessageDialog(null, "One Admin user must have");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }  finally {
                Util.closeResultset(rs);
                Util.closeStatement(psmnt);
                Util.closeConnection(con);
            }
      retrieveLogin();
    }
    

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            String un = txtUserName.getText();
            String pass = txtPassword.getText();
            String ut = cmb_UserType.getSelectedItem().toString();
            if (un.equals("") || pass.equals("")) {
                JOptionPane.showMessageDialog(this, "username and password should not be blank");

            } else {
                con = Util.getConnection();
                psmnt = con.prepareStatement("insert into Login(username, password, usertype) values(?,?,?)");
                psmnt.setString(1, un);
                psmnt.setString(2, pass);
                psmnt.setString(3, ut);
                int a = psmnt.executeUpdate();
                if (a > 0) {
                    JOptionPane.showMessageDialog(this, "Data successfully added.");
                } else {
                    JOptionPane.showMessageDialog(this, "Error while adding data.");
                }

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error while adding data :-(" + ex + ")");
        }
        retrieveLogin();
        txtUserName.setText("");
        txtPassword.setText("");
        cmb_UserType.setSelectedIndex(0);
    }

    private void txtUserNameMouseEntered(java.awt.event.MouseEvent evt) {
        txtUserName.setForeground(Color.BLACK);
    }

    private void txtPasswordMouseEntered(java.awt.event.MouseEvent evt) {
        txtPassword.setForeground(Color.BLACK);
    }

    private void formWindowClosed(java.awt.event.WindowEvent evt) {
        
        
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        
        Login l = new Login();
        l.setVisible(true);
        
        try{
            con.close();
            psmnt.close();
            rs.close();
            System.out.println("setup admin being close.");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private void btnRollSubmitActionPerformed(java.awt.event.ActionEvent evt) {
       
         try {
            con = Util.getConnection();
            stmt = con.createStatement();
            int a = stmt.executeUpdate("update codelist set rollno = '"+txtFRoll.getText().trim()+"' where slno = 1");
            if(a>0)
                JOptionPane.showMessageDialog(this, "Roll Number Submitted");
            txtFRoll.setText("");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void brnRcpSubmitActionPerformed(java.awt.event.ActionEvent evt) {
       
         try {
            con = Util.getConnection();
            stmt = con.createStatement();
            int a = stmt.executeUpdate("update codelist set rcpno = '"+txtFrcp.getText().trim()+"' where slno = 1");
            if(a>0)
                JOptionPane.showMessageDialog(this, "Reciept Number Submitted");
            txtFrcp.setText("");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Setup_Admission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Setup_Admission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Setup_Admission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Setup_Admission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Setup_Admission().setVisible(true);
            }
        });
    }
   
    private javax.swing.JButton Button_Set;
    private javax.swing.JDialog Dialog_DateFormat;
    private javax.swing.JButton brnRcpSubmit;
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnRollSubmit;
    private javax.swing.JButton btn_del;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cb_branch;
    private javax.swing.JComboBox cb_course;
    private javax.swing.JComboBox cmb_UserType;
    private javax.swing.JComboBox combo_dateformat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenu_Date;
    private javax.swing.JMenu jMenu_time;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rb_1;
    private javax.swing.JRadioButton rb_2;
    private javax.swing.JTable table_Login;
    private javax.swing.JTable table_fee;
    private javax.swing.JTable tb_Other;
    private javax.swing.JTextField txtFRoll;
    private javax.swing.JTextField txtFrcp;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JTextField txt_Keyword;
    private javax.swing.JTextField txt_dateformat;
}
