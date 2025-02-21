
package FoodOrderingSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Cart extends javax.swing.JFrame implements MyInterface {

    final private String cart = "Cart.txt";
    final private String STATUS = "Preparing";
    final private String ORDERSTATUS = "Order Status.txt";
    final private String TXN = "Transaction.txt";
    private String DRID = null;
    private String txnId;
    private String cartId;
    private String vendorId;
    private String customerId;
    private String foodName;
    private String foodPrice;
    private String quantity;
    private String remarks;
    private String method;
    private String selectedCartId;
    private String orderId;
    private String deliveryFee;
    private double totalPrice;
    private double creditAmount;
    
    // DATE
    LocalDate currentDate = LocalDate.now();
    int day = currentDate.getDayOfMonth();
    int month = currentDate.getMonthValue();
    int year = currentDate.getYear();
    DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String formattedDate = currentDate.format(formatDate);

    // TIME
    LocalTime currentTime = LocalTime.now();
    DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss a");
    String formattedTime = currentTime.format(formatTime);
    
    /**
     * Creates new form Cart
     */
    public Cart() {
        initComponents();
        RowSelectionListener();
    }
    
    public Cart(String CUSTID){
        initComponents();
        RowSelectionListener();
        this.customerId = CUSTID;
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        CartTable = new javax.swing.JTable();
        CloseBtn = new javax.swing.JButton();
        OrderBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        AppsNameLbl1 = new javax.swing.JLabel();
        AppsNameLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cart");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        CartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cart ID", "Vendor ID", "Customer ID", "Food Name", "Price", "Quantity", "Remarks", "Method", "Delivery Fee"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CartTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(CartTable);
        if (CartTable.getColumnModel().getColumnCount() > 0) {
            CartTable.getColumnModel().getColumn(0).setResizable(false);
            CartTable.getColumnModel().getColumn(1).setResizable(false);
            CartTable.getColumnModel().getColumn(2).setResizable(false);
            CartTable.getColumnModel().getColumn(3).setResizable(false);
            CartTable.getColumnModel().getColumn(4).setResizable(false);
            CartTable.getColumnModel().getColumn(5).setResizable(false);
            CartTable.getColumnModel().getColumn(6).setResizable(false);
            CartTable.getColumnModel().getColumn(7).setResizable(false);
            CartTable.getColumnModel().getColumn(8).setResizable(false);
        }

        CloseBtn.setText("Back");
        CloseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseBtnActionPerformed(evt);
            }
        });

        OrderBtn.setText("Order");
        OrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderBtnActionPerformed(evt);
            }
        });

        DeleteBtn.setBackground(new java.awt.Color(255, 51, 51));
        DeleteBtn.setText("Delete");
        DeleteBtn.setOpaque(true);
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        AppsNameLbl1.setFont(new java.awt.Font("STCaiyun", 1, 48)); // NOI18N
        AppsNameLbl1.setText("JOM");

        AppsNameLbl.setFont(new java.awt.Font("STCaiyun", 1, 48)); // NOI18N
        AppsNameLbl.setText("MAKAN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AppsNameLbl)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(AppsNameLbl1)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DeleteBtn)
                                .addGap(18, 18, 18)
                                .addComponent(OrderBtn))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CloseBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(52, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(AppsNameLbl1)
                        .addGap(69, 69, 69)
                        .addComponent(AppsNameLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OrderBtn)
                    .addComponent(DeleteBtn))
                .addGap(18, 18, 18)
                .addComponent(CloseBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void refreshData(){
        try{
            String read;
            FileReader fr = new FileReader(this.cart);
            
            // Prevent Glitch from file use BufferedReader
            BufferedReader br = new BufferedReader(fr);
            
               
            // To start use the JTable use DefaultTableModel
            DefaultTableModel model = (DefaultTableModel) CartTable.getModel();
            model.setRowCount(0);
            
            while((read = br.readLine()) != null ){
                String[] data = read.split(";");


                this.cartId = read.split(";")[0];
                this.vendorId = read.split(";")[1];
                String tempCustId = read.split(";")[2];
                this.foodName = read.split(";")[3];
                this.foodPrice = read.split(";")[4];
                this.quantity = read.split(";")[5];
                this.remarks = read.split(";")[6];
                this.method = read.split(";")[7];
                this.deliveryFee = read.split(";")[8];

                //EXTRACTING CART TEXT WITH SAME CUSTOMER ID
                if(this.customerId.equals(tempCustId)){
                    // ADD DATA FROM FILE INTO TABLE
                    model.addRow(new Object[]{
                        this.cartId, this.vendorId, this.customerId, this.foodName, this.foodPrice, this.quantity, this.remarks, this.method, this.deliveryFee
                    });
                }                    
            }
            br.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e, "System", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private boolean getAvailableRunnerId(){
        try(BufferedReader runnerReader = new BufferedReader(new FileReader("Runner.txt"))) {
            String line;
            
            while((line = runnerReader.readLine()) != null) {
                String[] runnerColumns = line.split(";");
                String tempRunnerId = runnerColumns[0];
                String runnerStat = runnerColumns[2];
                
                //IF THE RUNNER ACTIVE
                if("Available".equalsIgnoreCase(runnerStat)) {
                    this.DRID = tempRunnerId;
                }
            }
            return true;
        }catch(IOException e) {
            JOptionPane.showMessageDialog(this, "No available runner at the moment !", "System", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Error reading from Runner.txt" + e.getMessage());
            return false;
        }
    }
    
    private boolean addOrderToStatus(List<String> cartData){         

        try(BufferedReader br = new BufferedReader(new FileReader(this.ORDERSTATUS));
        FileWriter fw = new FileWriter(this.ORDERSTATUS, true)){

            int rowCount = 0;
            while(br.readLine() != null){
                rowCount++;
            }

//            LocalDate currentDate = LocalDate.now();
//            int day = currentDate.getDayOfMonth();
//            int month = currentDate.getMonthValue();
//            int year = currentDate.getYear();

            for(String cartLine : cartData) {
                String[] cartColumns = cartLine.split(";");               

                //GENERATE ORDER ID
                this.orderId = "JM" + String.format("%03d", rowCount + 1);
                rowCount++;

                if("delivery".equalsIgnoreCase(this.method)){
                    if(getAvailableRunnerId()){
                         fw.write(this.orderId + ";" +
                            this.vendorId + ";" +
                            this.DRID + ";" +
                            this.customerId + ";" +
                            year + ";" +
                            month + ";" +
                            day + ";" +
                            this.foodName + ";" +
                            this.foodPrice + ";" +
                            Double.parseDouble(this.deliveryFee) + ";" +
                            this.quantity + ";" +
                            this.STATUS + ";" +
                            this.remarks + "\n"
                        );       
                    }else{
                        JOptionPane.showMessageDialog(this, "There are no runner available at the moment. Please wait until next available runner.", "System", JOptionPane.INFORMATION_MESSAGE);
                    }                       
                }else{
                    fw.write(this.orderId + ";" +
                    this.vendorId + ";" +
                    null + ";" +
                    this.customerId + ";" +
                    year + ";" +
                    month + ";" +
                    day + ";" +
                    this.foodName + ";" +
                    this.foodPrice + ";" +
                    "0" + ";" +
                    this.quantity + ";" +
                    this.STATUS + ";" +
                    this.remarks + "\n"
                    );       
                }
            }
            return true;
        }catch(IOException e){
            System.out.println("Error writing to text file: " + e.getMessage());
            return false;
        }  
//        try(BufferedReader br = new BufferedReader(new FileReader(this.ORDERSTATUS));
//            FileWriter fw = new FileWriter(this.ORDERSTATUS, true)){
//            
//            int rowCount = 0;
//            while(br.readLine() != null){
//                rowCount++;
//            }
//            
////            LocalDate currentDate = LocalDate.now();
////            int day = currentDate.getDayOfMonth();
////            int month = currentDate.getMonthValue();
////            int year = currentDate.getYear();
//            
//            for(String cartLine : cartData) {
//                String[] cartColumns = cartLine.split(";");               
//                
//                //GENERATE ORDER ID
//                this.orderId = "JM" + String.format("%03d", rowCount + 1);
//                rowCount++;
//                
//                if("delivery".equalsIgnoreCase(this.method)){
//                    fw.write(this.orderId + ";" +
//                    this.vendorId + ";" +
//                    this.DRID + ";" +
//                    this.customerId + ";" +
//                    year + ";" +
//                    month + ";" +
//                    day + ";" +
//                    this.foodName + ";" +
//                    this.foodPrice + ";" +
//                    Double.parseDouble(this.deliveryFee) + ";" +
//                    this.quantity + ";" +
//                    this.STATUS + ";" +
//                    this.remarks + "\n"
//                    );       
//                    return true;
//                }else{
//                    fw.write(this.orderId + ";" +
//                    this.vendorId + ";" +
//                    null + ";" +
//                    this.customerId + ";" +
//                    year + ";" +
//                    month + ";" +
//                    day + ";" +
//                    this.foodName + ";" +
//                    this.foodPrice + ";" +
//                    null + ";" +
//                    this.quantity + ";" +
//                    this.STATUS + ";" +
//                    this.remarks + "\n"
//                    );       
//                    return true;
//                }
//            
//            }
//                // ADJUSTING THE COLUMNS BY DATA CART
////                String vendorAiDi = cartColumns[1];
//
//                
//            
//            
//        }catch(IOException e){
//            System.out.println("Error writing to text file: " + e.getMessage());
////            return false;
//        }
//        return false;
    }
        
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        this.setLocationRelativeTo(null);    
        refreshData();
        readDataFromCustomerProfile();
    }//GEN-LAST:event_formWindowActivated

    private void readDataFromCustomerProfile(){
        try{
            String read;
            String fileName = "Customer Profile.txt";
            Object[] options = {"Ok", "Close"};
            FileReader fr = new FileReader(fileName);
            
            // Prevent Glitch from file use BufferedReader
            BufferedReader br = new BufferedReader(fr);
                      
            int rowIndex = 0;
            boolean foundVendor = false;
            
            List<String> allData = new ArrayList<>();
            
            while((read = br.readLine()) != null){
                allData.add(read);
            }
            
            boolean founderCustomer = false;
            
            for (String line : allData){
                String[] data = line.split(";");
                
                if(data.length < 7) continue;               
                    String custIds = data[0];
                    String credAmnt = data[7];
                    
                    if(custIds.equals(this.customerId)){
                        System.out.println(credAmnt);
                        founderCustomer = true;
                        this.creditAmount = Double.parseDouble(credAmnt);
                        System.out.println(creditAmount);
                    }
            }
            if(!founderCustomer){
                int response = JOptionPane.showOptionDialog(this,"No customer record found. Please register an account first.", "System", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,
                            null,
                            options,
                            options[0]);
//                        if(response == 0 || response == 1) {
//                            //dispose();                            
//                        }
            }
            br.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e, "System", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void updateCustomerCreditAmount(double updatedCreditAmount){
        try{
            File file = new File("Customer Profile.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            List<String> allData = new ArrayList<>();
            
            String line;
            
            //READ ALL LINE AND UPDATE THE AMOUNT
            while((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                
                if(data.length >= 7 && data[0].equals(this.customerId)){
                    data[7] = String.valueOf(updatedCreditAmount);
                }
                allData.add(String.join(";", data));
            }
            
            reader.close();
            
            //WRITE BACK THE UPDATED DATA TO TXT FILE
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for(String updatedLine : allData){
                writer.write(updatedLine);
                writer.newLine();
            }
            
            writer.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(this, "Error in updating credit amount: " + e.getMessage());
        }
    }
    
    private void addToOrderTxt(){
        try{
            FileReader fr = new FileReader("Order History.txt");
            BufferedReader br = new BufferedReader(fr);
        }catch(IOException e){
            JOptionPane.showMessageDialog(this, "There's an error in adding to history.", "System", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private void OrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderBtnActionPerformed
        int priceIndex = 4;
        
        //SET THE CRED AMOUNT
        readDataFromCustomerProfile();
        
        // ENSURING CREDIT AMOUNT WAS SET
        if(this.creditAmount <= 0){
            JOptionPane.showMessageDialog(this, "Unable to retrieve customer credit. Please contact admin.", "System", JOptionPane.ERROR_MESSAGE);
            return;
        }
        List<String> cartData = new ArrayList<>();
        
        try{
            String line;
            FileReader fr = new FileReader(this.cart);
            BufferedReader br = new BufferedReader(fr);
            System.out.println("Reading the cart data..");
            
            // START READING ORDER STATUS.
            while((line = br.readLine()) != null){
                
                //STORING ALL ROW IN CART DATA
                cartData.add(line);
                
                //SPLIT THE LINE INTO AN ARRAY
                String[] columns = line.split(";");
                if(columns.length > priceIndex){
                    try{
                        double price = Double.parseDouble(columns[priceIndex]);
                        totalPrice += price;
                    }catch(NumberFormatException e){
                        System.out.println("Invalid price format in row: " + line);
                    }
                }
            }
            
            System.out.println("Total Price: " + String.format("%.2f", totalPrice));     
            // CHECKING THE CREDIT ENOUGH OR NOT
            if(this.creditAmount >= this.totalPrice){
                
                double updatedAmount = this.creditAmount - this.totalPrice;
                updateCustomerCreditAmount(updatedAmount);
                
                // ADD DATA TO TXN FILE
                addDataToTxn(this.totalPrice);
                
                // PROCEED WITH PLACING THE ORDER AND ADD INTO ORDER STATUS TEXT
                if(addOrderToStatus(cartData)){
                    deleteAllData();
                    JOptionPane.showMessageDialog(this, "Sucessfully placed your order.", "System", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this, "Failed to place the order. Contact administrator.", "System", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Insufficient credit balance. Please top up your account.", "System", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(IOException e){
            System.out.println("Error reading cart file: " + e.getMessage());
        }
        refreshData();        
    }//GEN-LAST:event_OrderBtnActionPerformed

    
    private void addDataToTxn(double Amount){
        
        try{
            FileReader fr = new FileReader(this.TXN);
            BufferedReader br = new BufferedReader(fr);
            String line;
            int rowCount = 0;
            
            while((line = br.readLine()) != null){
                rowCount++;
//                if(rowCount != 0){
//                    this.txnId = "TXN" + String.format("%03d", rowCount + 1);
//                }else if(rowCount > 0){
//                    this.txnId = "TXN" + String.format("%03d", rowCount + 1);
//                }
            }
            br.close();
            
            this.txnId = "TXN" + String.format("%03d", rowCount + 1);
                
            FileWriter fw = new FileWriter(this.TXN, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.write(
                    this.txnId + ";" +
                    this.customerId + ";" +                        
                    formattedDate + ";" +
                    formattedTime + ";" +
                    Amount + ";" +
                    "Debit" + "\n"
            );
            pw.close();
            bw.close();
            fw.close();
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(this, "506 There's an error occured. Your order has been submitted to vendor. Please contact administrator for this error.", "System", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void RowSelectionListener(){
        CartTable.getSelectionModel().addListSelectionListener((ListSelectionEvent e)->{
            if(!e.getValueIsAdjusting()){
                int selectedRow = CartTable.getSelectedRow();
                if(selectedRow != -1) {
                    selectedCartId = (String) CartTable.getValueAt(selectedRow,0);
                    System.out.println("Vendor Id: " + selectedCartId);
                }
            }
    });
    }
    
    private void deleteAllData(){
        try{
            FileWriter fw = new FileWriter("Cart.txt", false);
            fw.write("");
            fw.close();
            System.out.println("File Cart Deleted");
        }catch(IOException e){
            JOptionPane.showMessageDialog(this, "There's an error occured. Please contact administrator", "System", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    // THIS METHOD IS NOT FUNCTIONING CAUSE THE ROW IS NOT DELETED
    private void deleteRowFromFile(String fileName, String selectedVendorID, int columnIndex){
        File inputFile = new File(fileName);
        List<String> lines = new ArrayList<>();
        
        // NO NEED TO CLOSE THE br BECAUSE WHEN USING try-with-resources, it automatically closes.
        try(BufferedReader br = new BufferedReader(new FileReader(inputFile))){            
            String line;
            
            while((line = br.readLine()) != null){
                String[] columns = line.split(";");
                if(columns.length > columnIndex && !columns[columnIndex].equals(selectedVendorID)){
                    lines.add(line);
                }
            }
        }catch(IOException e){
            System.out.println("Error in reading file: " + e.getMessage());
            return;
        }
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(inputFile))){
            for(String modifiedLine : lines){
                bw.write(modifiedLine);
                bw.newLine();
            }
//            FileWriter fw = new FileWriter(fileName);
//            BufferedWriter bw = new BufferedWriter(fw);
            
            //THE COLON (:) SEPARATE THE LOOP VARIABLE = FOR EACH LOOP
//            for(String modifiedLine : lines){
//                bw.write(modifiedLine);
//                bw.newLine();
//            }
//            bw.close();
        }catch(IOException e){
            System.out.println("Error");
        }
    }
    
    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        if(selectedCartId != null && !selectedCartId.isEmpty()){
            deleteRowFromFile("Cart.txt", selectedCartId, 0);
        }else if(selectedCartId == null){
            System.out.println("No Item selected for deleting.");
        }
        refreshData();
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void CloseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseBtnActionPerformed
        this.setVisible(false);
        MenuDashboard MD = new MenuDashboard(this.vendorId, this.customerId);
        MD.setVisible(true);
    }//GEN-LAST:event_CloseBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AppsNameLbl;
    private javax.swing.JLabel AppsNameLbl1;
    private javax.swing.JTable CartTable;
    private javax.swing.JButton CloseBtn;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton OrderBtn;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
