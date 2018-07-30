
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class mainFrame extends javax.swing.JFrame {
    
    Coin c1 = null;
    public mainFrame() {
        c1 = new Coin();
        initComponents();
        c1.sort(streamTable);
        resizeColumnWidth(streamTable);
        
        c1.sort2(portfolioTable);
        c1.showData(portfolioTable);
        resizeColumnWidth(portfolioTable);
        
        c1.sort3(walletTable);
        c1.showWalletData(walletTable);
        resizeColumnWidth(walletTable);
//        c1.showPortData(mathTable);
//        resizeColumnWidth(mathTable);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        startStream = new javax.swing.JButton();
        buyBtn = new javax.swing.JButton();
        sellBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        botOn = new javax.swing.JRadioButton();
        botOff = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        streamTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        portfolioTable = new javax.swing.JTable();
        refreshBtn = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        walletTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TradingBot_RPG");

        startStream.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        startStream.setText("Start Stream");
        startStream.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startStreamActionPerformed(evt);
            }
        });

        buyBtn.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        buyBtn.setText("Buy");
        buyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyBtnActionPerformed(evt);
            }
        });

        sellBtn.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        sellBtn.setText("Sell");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("STREAM");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        buttonGroup1.add(botOn);
        botOn.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        botOn.setText("Bot On");

        buttonGroup1.add(botOff);
        botOff.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        botOff.setSelected(true);
        botOff.setText("Bot Off");
        botOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botOffActionPerformed(evt);
            }
        });

        streamTable.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        streamTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rank", "Name", "Symbol", "Price ($)", "% Change (1Hr)", "% Change (24Hr)", "% Change (7D)", "Time Recorded"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        streamTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        streamTable.setColumnSelectionAllowed(true);
        streamTable.setDragEnabled(true);
        jScrollPane3.setViewportView(streamTable);
        streamTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        portfolioTable.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        portfolioTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Buy Date", "Name", "Qty", "Buy Price", "Investment", "Current Price", "Price G/L", "Current Value", "Earnings"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        portfolioTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane4.setViewportView(portfolioTable);

        refreshBtn.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        refreshBtn.setText("Refresh Stream");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        jToggleButton1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jToggleButton1.setText("AutoRefresh On/Off");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setText("My Portfolio");

        jLabel2.setText("My BitWallet");

        walletTable.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        walletTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Transaction", "Total Balance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        walletTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(walletTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(startStream, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(refreshBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(buyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(botOn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botOff)
                                .addGap(2, 2, 2))
                            .addComponent(sellBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 821, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buyBtn, jToggleButton1, refreshBtn, sellBtn, startStream});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(startStream)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshBtn)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton1)
                        .addGap(18, 18, 18)
                        .addComponent(buyBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sellBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botOn)
                            .addComponent(botOff))
                        .addGap(77, 77, 77))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buyBtn, jToggleButton1, refreshBtn, sellBtn, startStream});

        pack();
    }// </editor-fold>//GEN-END:initComponents

DefaultTableModel model1=null;

    private void startStreamActionPerformed(java.awt.event.ActionEvent evt) {
      
        try {
                    model1 = (DefaultTableModel) streamTable.getModel();
                    ArrayList<Coin> list1 = c1.StartStream();
                    Object rowData[] = new Object[8];
                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.SSS").format(new Date());

                        for (int i=0;i<list1.size();i++){
                            rowData[0] = list1.get(i).order;
                            rowData[1] = list1.get(i).name;
                            rowData[2] = list1.get(i).symbol;
                            rowData[3] = list1.get(i).price_usd;
                            rowData[4] = list1.get(i).percent_change_1h;
                            rowData[5] = list1.get(i).percent_change_24h;
                            rowData[6] = list1.get(i).percent_change_7d;
                            rowData[7] = " "+timeStamp.toString();
                            model1.addRow(rowData);
                        }
                        c1.sort(streamTable);
                        resizeColumnWidth(streamTable);
                        c1.showData(portfolioTable);
                        resizeColumnWidth(portfolioTable);
                        c1.showWalletData(walletTable);
                        resizeColumnWidth(walletTable);
//                        c1.showPortData(mathTable);
//                        resizeColumnWidth(mathTable);
        } catch (Exception es) {
            es.printStackTrace(System.err);
        }
       
    }

    //GEN-LAST:event_startStreamActionPerformed
  
    private void botOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botOffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botOffActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        // TODO add your handling code here:
        try {
            
                model1 = (DefaultTableModel) streamTable.getModel();
                model1.setRowCount(0);
                ArrayList<Coin> list1 = c1.StartStream();
                Object rowData[] = new Object[8];
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.SSS").format(new Date());
                
                    for (int i=0;i<list1.size();i++){
                        rowData[0] = list1.get(i).order;
                        rowData[1] = list1.get(i).name;
                        rowData[2] = list1.get(i).symbol;
                        rowData[3] = list1.get(i).price_usd;
                        rowData[4] = list1.get(i).percent_change_1h;
                        rowData[5] = list1.get(i).percent_change_24h;
                        rowData[6] = list1.get(i).percent_change_7d;
                        rowData[7] = " "+timeStamp.toString();
                        model1.addRow(rowData);
                    }
                c1.sort(streamTable);
                resizeColumnWidth(streamTable);
                c1.showData(portfolioTable);
                resizeColumnWidth(portfolioTable);
                c1.showWalletData(walletTable);
                resizeColumnWidth(walletTable);
//                c1.showPortData(mathTable);
//                resizeColumnWidth(mathTable);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        
    Timer timer = new Timer(0, new ActionListener() {

       @Override
       public void actionPerformed(ActionEvent e) {
          updateRecords();
       }

            private void updateRecords() {
               try {
            
                model1 = (DefaultTableModel) streamTable.getModel();
                model1.setRowCount(0);
                ArrayList<Coin> list1 = c1.StartStream();
                Object rowData[] = new Object[8];
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SSS").format(new Date());
                
                
                
                    for (int i=0;i<list1.size();i++){
                        rowData[0] = list1.get(i).order;
                        rowData[1] = list1.get(i).name;
                        rowData[2] = list1.get(i).symbol;
                        rowData[3] = list1.get(i).price_usd;
                        rowData[4] = list1.get(i).percent_change_1h;
                        rowData[5] = list1.get(i).percent_change_24h;
                        rowData[6] = list1.get(i).percent_change_7d;
                        rowData[7] = " "+timeStamp.toString();
                        model1.addRow(rowData);
                    }
                    
                    c1.sort(streamTable);
                    resizeColumnWidth(streamTable);
                    c1.showData(portfolioTable);
                    resizeColumnWidth(portfolioTable);
                    c1.showWalletData(walletTable);
                    resizeColumnWidth(walletTable);
//                    c1.showPortData(mathTable);
//                    resizeColumnWidth(mathTable);

                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        });
      timer.setDelay(300000); // delay for 30 seconds
      timer.start();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void buyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyBtnActionPerformed
        // TODO add your handling code here:
//    int option=JOptionPane.showOptionDialog(null, "Add a new employee or project", "Add Record", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, NORMAL);
        c1.buy(walletTable);
        c1.sort(streamTable);
        resizeColumnWidth(streamTable);
        c1.showData(portfolioTable);
        resizeColumnWidth(portfolioTable);
        c1.showWalletData(walletTable);
        resizeColumnWidth(walletTable);
//        c1.showPortData(mathTable);
//        resizeColumnWidth(mathTable);
    }//GEN-LAST:event_buyBtnActionPerformed
    
    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            if(width > 300)
                width=300;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
    
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
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton botOff;
    private javax.swing.JRadioButton botOn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buyBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable portfolioTable;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton sellBtn;
    private javax.swing.JButton startStream;
    private javax.swing.JTable streamTable;
    private javax.swing.JTable walletTable;
    // End of variables declaration//GEN-END:variables
}
