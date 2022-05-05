import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;  
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;




public class stokekrani extends javax.swing.JFrame {

    public stokekrani() {
        initComponents();
        jTable_goster();
    } 
    
    public Connection getConnection(){
        
        Connection con;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userislemleri?autoReconnect=true&useSSL=false","root","Gelisim2022!");
            return con;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        
    }
    
    public ArrayList<userislemleri> getUserlist()
    {
        ArrayList<userislemleri> userList = new ArrayList<userislemleri>();
        Connection connection = getConnection();
        String query = "SELECT * FROM kullanici_girisi.userislemleri";
        Statement st;
        ResultSet rs;
        
        try{
            st = connection.createStatement();
            rs = st.executeQuery(query);
            userislemleri userislemleri;
            while(rs.next())
            {
                userislemleri = new userislemleri(rs.getInt("barkodid"),rs.getString("urunad"),rs.getInt("stokadet"),rs.getInt("fiyat"),rs.getString("kategori"),rs.getString("aciklama"));
                userList.add(userislemleri);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return userList;
        
    }
    
    public void jTable_goster()
    {
        ArrayList<userislemleri> list = getUserlist();
        DefaultTableModel model = (DefaultTableModel)jTableusers.getModel();
        Object[] row = new Object[6];
        for(int i =0; i < list.size(); i++)
        {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getUrunadi();
            row[2] = list.get(i).getstokAdet();
            row[3] = list.get(i).getfiyat();
            row[4] = list.get(i).getkategorii();
            row[5] = list.get(i).getaciklamaa();
            
            model.addRow(row);
        }
    }
    public void calistir(String query, String mesaj)
    {
        Connection con = getConnection();
        Statement st;
        try {
            st = con.createStatement();
            if(st.executeUpdate(query) == 1)
            {
                DefaultTableModel model = (DefaultTableModel)jTableusers.getModel();
                model.setRowCount(0);
                jTable_goster();
                
                JOptionPane.showMessageDialog(null,"İşlem" + mesaj + "Başarılı");
            }else{
                JOptionPane.showMessageDialog(null,"İşlem Başarısız" + mesaj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_id = new java.awt.TextField();
        txt_urunad = new java.awt.TextField();
        txt_stokadet = new java.awt.TextField();
        txt_fiyat = new java.awt.TextField();
        txt_kategori = new java.awt.TextField();
        txt_aciklama = new java.awt.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableusers = new javax.swing.JTable();
        button_giris = new javax.swing.JButton();
        button_guncelle = new javax.swing.JButton();
        button_sil = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Barkod Id:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Ürün Adı: ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Stok Adet:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Fiyat:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Kategori:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Açıklama:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Stok Takip Programı");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("STOK İŞLEMLERİ MENÜSÜ");

        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });

        jTableusers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barkod Id", "Ürün Adı", "Stok Adet", "Fiyat", "Kategori", "Açıklama"
            }
        ));
        jTableusers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableusersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableusers);

        button_giris.setText("Kaydet");
        button_giris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_girisActionPerformed(evt);
            }
        });

        button_guncelle.setText("Güncelle");
        button_guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_guncelleActionPerformed(evt);
            }
        });

        button_sil.setText("Sil");
        button_sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_silActionPerformed(evt);
            }
        });

        jButton1.setText("Stok Sorgu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(309, 309, 309)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(286, 286, 286)
                                .addComponent(jLabel9)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_urunad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_stokadet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_fiyat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_kategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_aciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(button_giris, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button_guncelle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(button_sil, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txt_urunad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txt_stokadet, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txt_fiyat, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txt_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txt_aciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button_giris, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_guncelle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_sil, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        
    }//GEN-LAST:event_txt_idActionPerformed

    private void jTableusersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableusersMouseClicked
        
        int i = jTableusers.getSelectedRow();
        TableModel model = jTableusers.getModel();
        
        txt_id.setText(model.getValueAt(i,0).toString());
        txt_urunad.setText(model.getValueAt(i,1).toString());
        txt_stokadet.setText(model.getValueAt(i,2).toString());
        txt_fiyat.setText(model.getValueAt(i,3).toString());
        txt_kategori.setText(model.getValueAt(i,4).toString());
        txt_aciklama.setText(model.getValueAt(i,5).toString());
    }//GEN-LAST:event_jTableusersMouseClicked

    private void button_girisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_girisActionPerformed
        
        String query = "INSERT INTO userislemleri (barkodid, urunad, stokadet, fiyat, kategori , aciklama) VALUES (" + txt_id.getText()+",'"+txt_urunad.getText()+"',"+txt_stokadet.getText()+"',"+txt_fiyat.getText()+"',"+txt_kategori.getText()+"',"+txt_aciklama.getText()+"')";
        calistir(query, "Giris");
    }//GEN-LAST:event_button_girisActionPerformed

    private void button_guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_guncelleActionPerformed
        String query = "UPDATE userislemleri SET barkodid ='" + txt_id.getText()+"', urunad = '" + txt_urunad.getText()+"', stokadet = " + txt_stokadet.getText()+ "', fiyat = "+ txt_fiyat.getText() + "', kategori = " + txt_kategori.getText() + "', aciklama = " +txt_aciklama.getText()+" WHERE barkodid = "+ txt_id.getText();
        calistir(query, "Guncelleme");
    }//GEN-LAST:event_button_guncelleActionPerformed

    private void button_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_silActionPerformed
        String query = "DELETE FROM userislemleri WHERE barkodid =" + txt_id.getText();
        calistir(query, "Silme");
    }//GEN-LAST:event_button_silActionPerformed

    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new stokekrani().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_giris;
    private javax.swing.JButton button_guncelle;
    private javax.swing.JButton button_sil;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableusers;
    private java.awt.TextField txt_aciklama;
    private java.awt.TextField txt_fiyat;
    private java.awt.TextField txt_id;
    private java.awt.TextField txt_kategori;
    private java.awt.TextField txt_stokadet;
    private java.awt.TextField txt_urunad;
    // End of variables declaration//GEN-END:variables
}
