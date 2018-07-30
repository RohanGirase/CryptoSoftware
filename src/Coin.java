import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.awt.Desktop;
import static java.awt.Frame.NORMAL;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import javax.xml.bind.annotation.XmlRootElement;
import net.proteanit.sql.DbUtils;
//import static mainFrame.getDataByJavaIO;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
class Coin {
    
	@JsonProperty("24h_volume_usd")
	private double volume_usd;

    public String symbol;

    public double available_supply;

    public double percent_change_1h;

    public BigDecimal price_usd;

    public double price_btc;

    public String id;

    public double total_supply;

    public double percent_change_24h;

    public double max_supply;

    public int rank;

    public String name;
    
    public int order;

    public int last_updated;

    public double percent_change_7d;

    public double market_cap_usd;
    
    public Coin(){
    }
    
    public Coin(String Symbol){
        this.symbol=Symbol;
    }
    
    public Coin(String Symbol, BigDecimal priceUSD, double total_supply){
        this.symbol=Symbol;
        this.price_usd=priceUSD;
        this.total_supply=total_supply;
    }
    
    public Coin(int Order,String Name,String Symbol, BigDecimal priceUSD, double percent_change_1h, double percent_change_24h, double percent_change_7d){
        this.order=Order;
        this.name=Name;
        this.symbol=Symbol;
        this.price_usd=priceUSD;
        this.percent_change_1h=percent_change_1h;
        this.percent_change_24h=percent_change_24h;
        this.percent_change_7d=percent_change_7d;
        
//        System.out.println(Order+" , "+name+" , "+Symbol+" , "+priceUSD+" , "+percent_change_1h+" , "+percent_change_24h+" , "+percent_change_7d);
    }
    
    public double getvolume_usd ()
    {
        return volume_usd;
    }

    public void setvolume_usd (double volume_usd)
    {
        this.volume_usd = volume_usd;
    }

    public String getSymbol ()
    {
        return symbol;
    }

    public void setSymbol (String symbol)
    {
        this.symbol = symbol;
    }

    public double getAvailable_supply ()
    {
        return available_supply;
    }

    public void setAvailable_supply (double available_supply)
    {
        this.available_supply = available_supply;
    }

    public double getPercent_change_1h ()
    {
        return percent_change_1h;
    }

    public void setPercent_change_1h (double percent_change_1h)
    {
        this.percent_change_1h = percent_change_1h;
    }

    public BigDecimal getPrice_usd ()
    {
        return price_usd;
    }

    public void setPrice_usd (BigDecimal price_usd)
    {
        this.price_usd = price_usd;
    }

    public double getPrice_btc ()
    {
        return price_btc;
    }

    public void setPrice_btc (double price_btc)
    {
        this.price_btc = price_btc;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public double getTotal_supply ()
    {
        return total_supply;
    }

    public void setTotal_supply (double total_supply)
    {
        this.total_supply = total_supply;
    }

    public double getPercent_change_24h ()
    {
        return percent_change_24h;
    }

    public void setPercent_change_24h (double percent_change_24h)
    {
        this.percent_change_24h = percent_change_24h;
    }

    public double getMax_supply ()
    {
        return max_supply;
    }

    public void setMax_supply (double max_supply)
    {
        this.max_supply = max_supply;
    }

    public int getRank ()
    {
        return rank;
    }

    public void setRank (int rank)
    {
        this.rank = rank;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public int getLast_updated ()
    {
        return last_updated;
    }

    public void setLast_updated (int last_updated)
    {
        this.last_updated = last_updated;
    }

    public double getPercent_change_7d ()
    {
        return percent_change_7d;
    }

    public void setPercent_change_7d (double percent_change_7d)
    {
        this.percent_change_7d = percent_change_7d;
    }

    public double getMarket_cap_usd ()
    {
        return market_cap_usd;
    }

    public void setMarket_cap_usd (double market_cap_usd)
    {
        this.market_cap_usd = market_cap_usd;
    }
    
TaskData coin = null;

Connection sqlCon = null;
PreparedStatement pst = null;
ResultSet rs = null;

Connection sqlCon2 = null;
PreparedStatement pst2 = null;
ResultSet rs2 = null;

DefaultTableModel model1=null;
DefaultTableModel model2=null;

double currentBalance=1000;

private static final  String URL="https://api.coinmarketcap.com/v1/ticker/?limit=0";

public ArrayList StartStream() throws JsonParseException, JsonMappingException, IOException{
        ArrayList<Coin> streamList = new ArrayList<Coin>();
        try {
	        
	        	ObjectMapper objectMapper = new ObjectMapper();
	        	ArrayList<Coin> commentsList = objectMapper.readValue(getDataByJavaIO(URL), new TypeReference<ArrayList<Coin>> (){});
	        	
	        	for (int i=0;i<commentsList.size();i++){
                                int order=commentsList.get(i).getRank();
                                String name= commentsList.get(i).getName();
                                String symbol= commentsList.get(i).getSymbol();
//                                 System.out.println(name);
                                BigDecimal price_usd = commentsList.get(i).getPrice_usd();
                                //store price_usd as prevPrice
//                                 System.out.println(price_usd);
                                double percent_change_1h = commentsList.get(i).getPercent_change_1h();
                                double percent_change_24h = commentsList.get(i).getPercent_change_24h();
                                double percent_change_7d = commentsList.get(i).getPercent_change_7d();
                                
                                streamList.add(new Coin(order,name,symbol,price_usd,percent_change_1h,percent_change_24h,percent_change_7d));
	        	}
                        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
            return streamList;
}

public static String getDataByJavaIO(String url) throws IOException{
    InputStream IS = null;
    BufferedReader BR = null;
    try{
        IS = new URL (url).openStream();
        BR = new BufferedReader(new InputStreamReader(IS, Charset.forName("UTF-8")));
        return readData(BR);
    }
    catch(IOException e){
        throw e;
    }
    finally{
        closeResource(IS);
        closeResource(BR);
    }
}

public static String readData (Reader reader) throws IOException{
    StringBuilder stringBuilder = new StringBuilder();
    int cp;
    while ((cp = reader.read())!=-1){
        stringBuilder.append((char)cp);
    }
    return stringBuilder.toString();
}

private static void closeResource(AutoCloseable closeable) {
    try{
        if (closeable!=null){
            closeable.close();
            System.out.println("\n"+closeable.getClass().getName()+"CLOSED...");
            //System.exit(0);
            }
        }
	catch(Exception e){
            e.printStackTrace(System.err);
	}
}
    
boolean validS = false;
String timeStamp="";
//  String action="BUY";
String symbolBuy="";
String nameBuy="";
double inputQty;
String bsPrice = "";
String tC="";
double iQ;
BigDecimal price_usdBuy=BigDecimal.ZERO;
double total_supplys=0.0;
BigDecimal tS=BigDecimal.ZERO;
BigDecimal totalCost=BigDecimal.ZERO;


public void buy(JTable walletTable){
        String inputName=JOptionPane.showInputDialog("Enter Valid Coin Name");
        String inputSymbol=JOptionPane.showInputDialog("Enter Valid Coin Symbol");
    ObjectMapper objectMapper = new ObjectMapper();
    ArrayList<Coin> commentsList;
    
        try {
            commentsList = objectMapper.readValue(getDataByJavaIO(URL), new TypeReference<ArrayList<Coin>> (){});
            
            for (int i=0;i<commentsList.size();i++){
                String name1 = commentsList.get(i).getName();
                String symbol1 = commentsList.get(i).getSymbol();

                while (name1.equalsIgnoreCase(inputName) && symbol1.equalsIgnoreCase(inputSymbol)){
//                    System.out.println("Valid Coin Symbol");
                    validS=true;
                    Object rowData[] = new Object[2];
                    timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SSS").format(new Date());
                            for (int j=0;j<rowData.length;j++){
//                                double price_usd=commentsList.get(i).price_usd;
                                 nameBuy = commentsList.get(i).name;
                                 symbolBuy = commentsList.get(i).symbol;
                                 price_usdBuy = commentsList.get(i).price_usd;
                                 price_usdBuy.setScale(rank, RoundingMode.HALF_EVEN);
                                 total_supplys = commentsList.get(i).total_supply;
//                                commentsList.add(new Coin(symbolBuy,price_usdBuy,total_supply));
//                                System.out.println(symbolBuy);
//                                System.out.println(price_usdBuy);
//                                System.out.println(total_supply);
//                                model1.addRow(rowData);
                            }
                           break;      
                }
                
            }
            tS = BigDecimal.valueOf(total_supplys);
            
            if (validS==false){
                commentsList = objectMapper.readValue(getDataByJavaIO(URL), new TypeReference<ArrayList<Coin>> (){});
                JOptionPane.showMessageDialog(null, "Name Not Found!");
                inputName=JOptionPane.showInputDialog("Enter Valid Coin Name");
                inputSymbol=JOptionPane.showInputDialog("Enter Valid Coin Symbol");
                for (int i=0;i<commentsList.size();i++){
                String name1 = commentsList.get(i).getName();
                String symbol1 = commentsList.get(i).getSymbol();

                if (name1.equalsIgnoreCase(inputName) && symbol1.equalsIgnoreCase(inputSymbol)){
                    
//                    System.out.println("Valid Coin Symbol");
                    
                    Object rowData[] = new Object[2];
                    timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SSS").format(new Date());
                            for (int j=0;j<rowData.length;j++){
//                                double price_usd=commentsList.get(i).price_usd;
                                 nameBuy = commentsList.get(i).name;
                                 symbolBuy = commentsList.get(i).symbol;
                                 price_usdBuy = commentsList.get(i).price_usd;
                                 price_usdBuy.setScale(rank, RoundingMode.HALF_EVEN);
                                 total_supplys = commentsList.get(i).total_supply;
//                                commentsList.add(new Coin(symbolBuy,price_usdBuy,total_supply));
//                                System.out.println(symbolBuy);
//                                System.out.println(price_usdBuy);
//                                System.out.println(total_supply);
//                                model1.addRow(rowData);
                            }
                            validS=true;
                            break;
                }
                
            }
            }
            else if(validS==true){
                JOptionPane.showMessageDialog(null, "Name Found!");
                if (total_supplys==0){
                    JOptionPane.showMessageDialog(null, "Sorry, Not Enough Supply!"+"\n\n"+"\n( Max Supply of "+nameBuy+" = "+String.format(Locale.ENGLISH,"%,.2f", tS.setScale(2, RoundingMode.HALF_EVEN))+" )"+"\nPlease Choose Different Coin!");
                    buy(walletTable);
                }
                else{
                String inputQ=JOptionPane.showInputDialog("Enter Valid Qty for Purchase"+"\n"+"\n( Max Supply of "+nameBuy+" = "+String.format(Locale.ENGLISH,"%,.2f", tS.setScale(2, RoundingMode.HALF_EVEN))+" )");
                inputQty=Double.parseDouble(inputQ);
//                double totalCost = inputQty*rowData[2];
//                iQ=Integer.parseInt(inputQty);
//                iQ=Double.parseDouble(inputQty);
                while (inputQty>total_supplys){
                    JOptionPane.showMessageDialog(null, "Not Enough Supply! Please Enter Lower Purchase Quantity.");
                    inputQ=JOptionPane.showInputDialog("Enter Valid Qty for Purchase");
                    inputQty=Double.parseDouble(inputQ);
                }

                while (inputQty==0){
                    JOptionPane.showMessageDialog(null, "Invalid Quantity! Please Enter Quantity above 1");
                    inputQ=JOptionPane.showInputDialog("Enter Valid Qty for Purchase");
                    inputQty=Double.parseDouble(inputQ);
                }
                
                BigDecimal boughtQty = BigDecimal.valueOf(inputQty);
//                totalCost=iQ*price_usdBuy;
                totalCost = boughtQty.multiply(price_usdBuy);
//                System.out.println("Total: "+"$"+totalCost);
                bsPrice = String.valueOf(price_usdBuy);
                tC=String.valueOf(totalCost);
                
                Double totCost = Double.valueOf(tC);
                
                
                while (currentBalance<totCost){
                    JOptionPane.showMessageDialog(null, "Not Enough Funds! Please Enter Lower Purchase Quantity.");
                    inputQ=JOptionPane.showInputDialog("Enter Valid Qty for Purchase");
                    inputQty=Double.parseDouble(inputQ);
                    boughtQty = BigDecimal.valueOf(inputQty);
    //                totalCost=iQ*price_usdBuy;
                    totalCost = boughtQty.multiply(price_usdBuy);
    //                System.out.println("Total: "+"$"+totalCost);
                    bsPrice = String.valueOf(price_usdBuy);
                    tC=String.valueOf(totalCost);

                    totCost = Double.valueOf(tC);
                    }
                
                String iQQ = String.valueOf(inputQty);
                String[] options = {"Yes","No"};
                int opt=JOptionPane.showOptionDialog(null,"Purchase "+iQQ+" coin(s) of "+nameBuy +" for " +"$"+totalCost.setScale(4, RoundingMode.HALF_EVEN)+"?", "Confirm?", YES_NO_OPTION, QUESTION_MESSAGE, null, options, NORMAL);
                if (opt==0){
                    try{
                    
                    String sql = "INSERT INTO mb1"
                            +"(Name, Symbol, Quantity_Bought, Buy_Price, Total_Investment)"
                            +"VALUES (?,?,?,?,?)";
                    
                    sqlCon = DriverManager.getConnection("jdbc:mysql://localhost/mybot1", "root", "");
                    pst = sqlCon.prepareStatement(sql);
//                        pst.setString(1,action);
                        pst.setString(1,nameBuy);
                        pst.setString(2,symbolBuy);
                        pst.setString(3,inputQ);
                        pst.setString(4,bsPrice);
                        pst.setString(5,tC);    
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Success!");
                    
                    walletBuy(walletTable,inputQty, nameBuy, totalCost);
                    
                    }
                    catch(Exception ed){
                        JOptionPane.showMessageDialog(null, ed);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Transaction Canceled");
                }
                }
            }
            
        }
        catch (Exception ex) {
            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
public void walletBuy(JTable walletTable,double inputQuantity, String coinBought, BigDecimal grandTotal ) throws SQLException{
    
    String action = "BUY";
    String inQ = String.valueOf(inputQuantity);
    String grandT = String.valueOf(grandTotal);
    
    Double gT = Double.valueOf(grandT);
    if (currentBalance>gT){
    currentBalance-=gT;
    String newB = String.valueOf(currentBalance);
    
    String sql = "INSERT INTO transactions"
                +"(Action, Input_Quantity, Coin_Bought, Grand_Total, New_Balance)"
                +"VALUES (?,?,?,?,?)";
    
    sqlCon = DriverManager.getConnection("jdbc:mysql://localhost/mybot1", "root", "");
    pst = sqlCon.prepareStatement(sql);
    
        pst.setString(1, action);
        pst.setString(2, inQ);
        pst.setString(3, coinBought);
        pst.setString(4, grandT);
        pst.setString(5, newB);
    pst.executeUpdate();
    }
    
}

public void walletBuy(){
   
}

public void sort(JTable streamTable){
    TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(streamTable.getModel());
    streamTable.setRowSorter(sorter);
    
    List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
    sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
    sorter.setSortKeys(sortKeys);
}

public void sort2(JTable streamTable){
    TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(streamTable.getModel());
    streamTable.setRowSorter(sorter);
    
    List<RowSorter.SortKey> sortKeys = new ArrayList<>(8);
    sortKeys.add(new RowSorter.SortKey(0, SortOrder.DESCENDING));
    sorter.setSortKeys(sortKeys);
}
public void sort3(JTable streamTable){
    TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(streamTable.getModel());
    streamTable.setRowSorter(sorter);
    
    List<RowSorter.SortKey> sortKeys = new ArrayList<>(3);
    sortKeys.add(new RowSorter.SortKey(0, SortOrder.DESCENDING));
    sorter.setSortKeys(sortKeys);
}

public void showData(JTable portfolioTable){
        try{
                    sqlCon = DriverManager.getConnection("jdbc:mysql://localhost/mybot1", "root", "");
                    
                    String sql = "SELECT * FROM mb1";
                    
                    pst = sqlCon.prepareStatement(sql);
                       
                    rs=pst.executeQuery();
                    
                    List<String> rankBS=new ArrayList<>();
                    List<String> timeBS=new ArrayList<>();       
                    List<String> namesBS=new ArrayList<>();
                    List<String> symbolsBS=new ArrayList<>();
                    List<String> pricesBS=new ArrayList<>();
                    List<String> qtyBS=new ArrayList<>();
                    List<String> totalBS=new ArrayList<>();
                    while (rs.next()) {
                        
                        timeBS.add(rs.getTimestamp(2).toString());
//                        System.out.println(rs.getTimestamp(2).toString());
                        namesBS.add(rs.getString(3));
                        symbolsBS.add(rs.getString(4));
//                        System.out.println(rs.getString(3));
                        qtyBS.add(rs.getString(5));  
                        pricesBS.add(rs.getString(6));
                        totalBS.add(rs.getString(7));
//                        System.out.println(rs.getString(4));
                    }
                    
                    model1 = (DefaultTableModel) portfolioTable.getModel();
                    model1.setRowCount(0);
                    ArrayList<Coin> list1 = StartStream();
                    Object rowData[] = new Object[9];
                    
                    for (int k=0; k<namesBS.size();k++){
                        String bsTime = timeBS.get(k);
                        String test = namesBS.get(k);
                        String bsSymbol = symbolsBS.get(k);
                        String bsPrice = pricesBS.get(k);
                        String bsQty = qtyBS.get(k);
                        String bsTotal = totalBS.get(k);
                        
                        for (int i=0;i<list1.size();i++){
                            if (test.equalsIgnoreCase(list1.get(i).getName()) && bsSymbol.equalsIgnoreCase(list1.get(i).getSymbol()) ){
                                
                                double bsP = Double.parseDouble(bsPrice);
//                                System.out.println(bsP);

                                BigDecimal newPrice = list1.get(i).price_usd;

                                double nP = newPrice.doubleValue();
//                             
                                double totalDifference = 0;
                                totalDifference = 100*((nP/bsP)-1);
                                BigDecimal tD = BigDecimal.valueOf(totalDifference);
                                double qP = Double.parseDouble(bsQty);
                                double newValue = nP*qP;
                                BigDecimal nV = BigDecimal.valueOf(newValue);
                                
                                double tP = Double.parseDouble(bsTotal);
                                  BigDecimal totalGL = BigDecimal.valueOf(newValue-tP);
                                  
                                rowData[0] = bsTime;
                                rowData[1] = test;
                                rowData[2] = bsQty;
                                rowData[3] = "$ "+bsPrice;
                                rowData[4] = "$ "+bsTotal;
                                rowData[5] = "$ "+list1.get(i).price_usd;
                                rowData[6] = tD.setScale(4, RoundingMode.HALF_EVEN)+" %";
                                rowData[7] = "$ "+nV.setScale(4, RoundingMode.HALF_EVEN);
                                rowData[8] = "$ "+totalGL.setScale(4, RoundingMode.HALF_EVEN);
                                model1.addRow(rowData);
                                
                            }
                        }
                    }
                    
                }
                catch(Exception et){
                    JOptionPane.showMessageDialog(null, et);
                }
    }

public void showWalletData(JTable walletTable){
    try{
        sqlCon2 = DriverManager.getConnection("jdbc:mysql://localhost/mybot1", "root", "");
                    
        String sql2 = "SELECT * FROM transactions";
                    
        pst2 = sqlCon2.prepareStatement(sql2);
                       
        rs2=pst2.executeQuery();
        
        List<String> dateBS=new ArrayList<>();
        List<String> aBS=new ArrayList<>();
        List<String> iBS=new ArrayList<>();
        List<String> sBS=new ArrayList<>();
        List<String> tBS=new ArrayList<>();
        List<String> bBS=new ArrayList<>();
        
        while(rs2.next()){
            dateBS.add(rs2.getString(2));
            aBS.add(rs2.getString(3));
            iBS.add(rs2.getString(4));
            sBS.add(rs2.getString(5));
            tBS.add(rs2.getString(6));
            bBS.add(rs2.getString(7));
//            System.out.println(rs2.getString(3));
        }
        
        model2 = (DefaultTableModel) walletTable.getModel();
        model2.setRowCount(0);
        Object rowData2[] = new Object[3];
        
        for (int k=0; k<dateBS.size();k++){
            String bsDate = dateBS.get(k);
            String bsA = aBS.get(k);
            String bsI = iBS.get(k);
            String bsS = sBS.get(k);
            String bsT = tBS.get(k);
            String bsB = bBS.get(k);
            DecimalFormat nFormat = new DecimalFormat("#.0000");
//            System.out.println(dateBS.get(k));
            DecimalFormat numberFormat = new DecimalFormat("#.0000");
            Double valBST = Double.valueOf(bsT);
            numberFormat.format(valBST);
            bsT = String.valueOf(valBST);

            rowData2[0] = bsDate;
            rowData2[1] = "BUY "+bsI+" coin(s) of "+bsS+" for "+"$"+bsT;
            rowData2[2] = "$"+bsB;
            model2.addRow(rowData2);
        }
    }
    catch(Exception ed){
    
    }
}

}
