
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ACLC PC17
 */
public class ManageCategory extends javax.swing.JFrame {

    private int categoryPk = 0;
    private String category_pk;

    /**
     * Creates new form ManageCategory
     */
    private String currentUserName;
    private int selectedCustomerId;
    private boolean isEditMode = false;
    private String originalName = "";
    private String originalEmail = "";
    private String originalNumber = "";
    private int customerPk = 0;
    private int productPk = 0;
    private long finalTotalPrice = 0;
    private String orderId = "";
    private String currentUserRole;
    private String orderPaid;

    public ManageCategory() {
        initComponents();
        setLocationRelativeTo(null);
        refresh();
    }

    public ManageCategory(String role, String names) {
        initComponents();
        setLocationRelativeTo(null);
        this.currentUserRole = role;
        this.currentUserName = names;
        refresh(); // Add this line to initialize the table
    }

    private boolean validateFields() {
        String name = txtname.getText().trim();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Category name is required.");
            return false;
        }

        if (name.length() > 30) {
            JOptionPane.showMessageDialog(null, "Category name cannot exceed 30 characters.");
            return false;
        }

        return true;
    }

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    private void formComponentShown(java.awt.event.ComponentEvent evt) {

        DefaultTableModel model = (DefaultTableModel) tableCategory.getModel();

        try {
//          Connection con = ConnectionProvider.getCon();
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement", "root", "");
            ps = con.prepareStatement("Select * from inventorymanagementsystem where userrole = ?");
            ps.executeQuery("Select * from category");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("category_pk"), rs.getString("name")});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        update.setEnabled(false);
    }

    private void clearForm() {
        txtname.setText("");
        categoryPk = 0;
        update.setEnabled(false);
        tableCategory.clearSelection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        txtname = new javax.swing.JTextField();
        searchbar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCategory = new javax.swing.JTable();
        update = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        delete = new javax.swing.JButton();
        save = new javax.swing.JButton();
        close = new javax.swing.JButton();
        BG5 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(876, 540));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(41, 88, 82));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Impact", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MANAGE CATEGORY");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, -1, 60));

        jPanel6.setBackground(new java.awt.Color(163, 198, 134));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(41, 88, 82));
        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, -1, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 30, 40));

        jPanel7.setBackground(new java.awt.Color(163, 198, 134));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(41, 88, 82));
        jPanel7.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, -1, 10));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 30, 40));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 10, 880, 60);

        txtname.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 88, 82), 2, true));
        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });
        getContentPane().add(txtname);
        txtname.setBounds(460, 80, 380, 30);

        searchbar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        searchbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbarActionPerformed(evt);
            }
        });
        searchbar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchbarKeyTyped(evt);
            }
        });
        getContentPane().add(searchbar);
        searchbar.setBounds(81, 80, 310, 30);

        tableCategory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(227, 186, 24)));
        tableCategory.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tableCategory.setForeground(new java.awt.Color(41, 88, 82));
        tableCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCategory.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tableCategory.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCategoryMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableCategory);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(40, 120, 800, 360);

        update.setBackground(new java.awt.Color(0, 29, 29));
        update.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        update.setForeground(new java.awt.Color(242, 242, 242));
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update);
        update.setBounds(290, 490, 100, 30);

        jPanel2.setBackground(new java.awt.Color(163, 198, 134));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/magnifying-glass.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 30, 30));

        jLabel2.setFont(new java.awt.Font("Javanese Text", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 29, 29));
        jLabel2.setText("NAME:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 60, 30));

        jPanel3.setBackground(new java.awt.Color(41, 88, 82));
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 880, -1));

        jPanel4.setBackground(new java.awt.Color(41, 88, 82));
        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 80, 10, 440));

        jPanel5.setBackground(new java.awt.Color(41, 88, 82));
        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 10, 440));

        delete.setBackground(new java.awt.Color(0, 29, 29));
        delete.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        delete.setForeground(new java.awt.Color(242, 242, 242));
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel2.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 490, 100, -1));

        save.setBackground(new java.awt.Color(0, 29, 29));
        save.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        save.setForeground(new java.awt.Color(242, 242, 242));
        save.setText("SAVE");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel2.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, 100, -1));

        close.setBackground(new java.awt.Color(0, 29, 29));
        close.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        close.setForeground(new java.awt.Color(242, 242, 242));
        close.setText("CLOSE");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        jPanel2.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 490, 110, -1));

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 880, 540);

        BG5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/mrr.png"))); // NOI18N
        BG5.setMaximumSize(new java.awt.Dimension(876, 540));
        BG5.setMinimumSize(new java.awt.Dimension(876, 540));
        BG5.setPreferredSize(new java.awt.Dimension(876, 540));
        getContentPane().add(BG5);
        BG5.setBounds(0, 0, 876, 540);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        if (!validateFields()) {
            return;
        }

        String name = txtname.getText().trim();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement", "root", "");

            // Check if category already exists
            ps = con.prepareStatement("SELECT COUNT(*) FROM category WHERE name = ?");
            ps.setString(1, name);
            rs = ps.executeQuery();
            rs.next();

            if (rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, "Category already exists!");
                return;
            }

            // Insert new category
            ps = con.prepareStatement("INSERT INTO category (name) VALUES (?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);

            int result = ps.executeUpdate();
            if (result > 0) {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    DefaultTableModel model = (DefaultTableModel) tableCategory.getModel();
                    model.addRow(new Object[]{rs.getString(1), name});
                    JOptionPane.showMessageDialog(null, "Category added successfully!");
                    clearFields();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error adding category: " + e.getMessage());
        }
    }//GEN-LAST:event_saveActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        try {
            int selectedRow = tableCategory.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a category to update.");
                return;
            }

            // Get the current values
            String categoryId = tableCategory.getValueAt(selectedRow, 0).toString();
            String currentName = tableCategory.getValueAt(selectedRow, 1).toString();
            String newName = txtname.getText().trim();

            // Check if any changes were made
            if (currentName.equals(newName)) {
                JOptionPane.showMessageDialog(null, "No changes made.");
                return;
            }

            // Validate input
            if (newName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Category name cannot be empty.");
                return;
            }

            if (newName.length() > 30) {
                JOptionPane.showMessageDialog(null, "Category name cannot exceed 30 characters.");
                return;
            }

            // Check if the name already exists for other categories
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement", "root", "");

            // Check if the new name already exists for a different category
            ps = con.prepareStatement("SELECT COUNT(*) FROM category WHERE name = ? AND category_pk != ?");
            ps.setString(1, newName);
            ps.setString(2, categoryId);
            rs = ps.executeQuery();
            rs.next();

            if (rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, "A category with this name already exists!");
                return;
            }

            // Perform the update
            ps = con.prepareStatement("UPDATE category SET name = ? WHERE category_pk = ?");
            ps.setString(1, newName);
            ps.setString(2, categoryId);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                // Update the table
                tableCategory.setValueAt(newName, selectedRow, 1);

                // Clear selection and fields
                clearForm();

                JOptionPane.showMessageDialog(null, "Category updated successfully!");

                // Refresh the table to show updated data
                refresh();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update category.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error updating category: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try {
            int selectedRow = tableCategory.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a category to delete.");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to delete this category?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                String categoryId = tableCategory.getValueAt(selectedRow, 0).toString();

                // Connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement", "root", "");
                ps = con.prepareStatement("DELETE FROM category WHERE category_pk = ?");
                ps.setString(1, categoryId);

                int result = ps.executeUpdate();
                if (result > 0) {
                    DefaultTableModel model = (DefaultTableModel) tableCategory.getModel();
                    model.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(null, "Category deleted successfully!");
                    clearFields();
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error deleting category: " + e.getMessage());
        }
    }//GEN-LAST:event_deleteActionPerformed
    private void clearFields() {
        txtname.setText("");
        categoryPk = 0;
        update.setEnabled(false);
    }
    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(null, "Do you want to close the app?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            this.dispose();
            if (currentUserRole != null) {
                new ManageProduct(currentUserRole, currentUserName).setVisible(true); // Pass the user role back to Home
            } else {
                JOptionPane.showMessageDialog(this, "User role is not defined. Redirecting to default home.");
                new Home().setVisible(true); // Open Home without the role (safe default)
            }
        }
    }//GEN-LAST:event_closeActionPerformed
    public void refresh() {
        DefaultTableModel model = (DefaultTableModel) tableCategory.getModel();
        model.setRowCount(0); // Clear the table

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement", "root", "");

            String query = "SELECT * FROM category";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("category_pk"),
                    rs.getString("name")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error refreshing category list: " + e.getMessage());
        }
    }
    private void searchbarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchbarKeyTyped
        // Limit search bar to 30 characters
        if (searchbar.getText().length() >= 30) {
            evt.consume();
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement", "root", "");
            String query = "SELECT * FROM category WHERE category_pk LIKE ? OR name LIKE ?";

            ps = con.prepareStatement(query);
            String searchText = "%" + searchbar.getText() + "%";

            ps.setString(1, searchText);
            ps.setString(2, searchText);

            rs = ps.executeQuery();
            DefaultTableModel dt = (DefaultTableModel) tableCategory.getModel();
            dt.setRowCount(0);

            while (rs.next()) {
                dt.addRow(new Object[]{
                    rs.getString("category_pk"),
                    rs.getString("name")
                });
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchbarKeyTyped

    private void searchbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableCategory.getModel();
        model.setRowCount(0);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement", "root", "");

            ResultSet rs = ps.executeQuery();

            // Loop through the result set and add each product to the table
            while (rs.next()) {
                String id = rs.getString("category_pk");
                String named = rs.getString("name");

                // Add row to the table
                model.addRow(new Object[]{id, txtname});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to search products: " + e.getMessage());
        }
    }//GEN-LAST:event_searchbarActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void tableCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCategoryMouseClicked
        try {
            int selectedRow = tableCategory.getSelectedRow();
            if (selectedRow != -1) {
                String categoryId = tableCategory.getValueAt(selectedRow, 0).toString();
                String categoryName = tableCategory.getValueAt(selectedRow, 1).toString();

                // Store the selected category's ID
                categoryPk = Integer.parseInt(categoryId);

                // Set the name in the text field
                txtname.setText(categoryName);

                // Enable the update button
                update.setEnabled(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error selecting category: " + e.getMessage());
        }
    }//GEN-LAST:event_tableCategoryMouseClicked
    private boolean isValidCategoryName(String name) {
        return name != null && !name.trim().isEmpty() && name.length() <= 30;
    }

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
            java.util.logging.Logger.getLogger(ManageCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCategory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG5;
    private javax.swing.JButton close;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton save;
    private javax.swing.JTextField searchbar;
    private javax.swing.JTable tableCategory;
    private javax.swing.JTextField txtname;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
