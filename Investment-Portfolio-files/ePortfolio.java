/*
    Go through README document to know how to compile and run this program
*/

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JMenu;
import java.awt.BorderLayout;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout.Constraints;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Boolean;
import java.lang.String;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.awt.event.*;
import java.util.ListIterator;

/*
    First when a the user compile the code and run it. A window is opened called eportfolio. which has a welcome message and a brief 
    instruction of how to use the system. The "Commands" menu has six choices: buy, sell, update, getGain, serach and quit.

*/

public class ePortfolio extends JFrame//implements KeyListener
{
    public static final int WIDTH = 600;
    public static final int HEIGHT = 450;
    int ListId = 0;
    ArrayList<Investment> investment = new ArrayList<Investment>();

    private JPanel sellPanel;
    private JPanel buyPanel;
    private JPanel updatePanel;
    private JPanel searchPanel;
    private JPanel gainPanel;
    private JPanel commandPanel;
    private JPanel buy1panel;  //Sub panel for BuyPanel
    private JPanel message1panel; //sub panel for BUypanel
    private JPanel buttonPanel;
    private JTextField textField2;  //textfield for symbol
    private JTextField textField3;   //textfield for Name
    private JTextField textField4;   //textfield for Quantity
    private JTextField textField5;   //textfield for Price
    private JComboBox<String> TypecomboBox; //combo for type of investment
    private JTextField sytextField;
    private JTextField QntextField;
    private JTextField PrytextField;
    private JPanel sell1Panel;
    private JPanel messageSellPanel;
    private JPanel sellbtnPanel;
    private JPanel update1Panel;
    private JPanel messageupdatePanel;
    private JPanel updatebtnPanel;
    private JTextField symTextField;
    private JTextField nameTextField;
    private JTextField PriceTextField;
    private JPanel getgainPanel;
    private JPanel gainmessagePanel;
    private JTextField gainTextField;
    private JPanel searchingPanel;
    private JPanel searchmessagePanel;
    private JPanel searchbtnPanel;
    private JTextField srsymTextfield;
    private JTextField keyTextfield;
    private JTextField lowTextfield;
    private JTextField highTextfield;
    private JTextArea textArea4;

    //private JTextArea textArea;



    public ePortfolio()
    {
        super("ePortfolio");
        setSize(WIDTH, HEIGHT);
        //setTitle("Menu Demonstration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        //setLayout (new BorderLayout());
        //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx Buy Panel Starting xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
        /*
            If the user select buy command the interface will be chnaged to the figure for "Buying an investment". The investment type 
            can be selected from the drop-down list, where stock is selected as default. The user is required to enter Symbol, Name, Quanity 
            and price. If the user does not enter any data or even one is missing and error will be displayed in message area. If the user 
            enters string for quantity or price an error will be shown and will ask the user to enter number. There are 2 buttons on the right-side
            the "Reset" button is for reseting all the textfield and "Submit" button is for buying a new investment. Once the investment is
            brought then that investment will be shown in the message panel.

        */
        buyPanel = new JPanel(new BorderLayout());
        buy1panel = new JPanel(new GridBagLayout());
        message1panel = new JPanel(new BorderLayout());

        //message panel starting from here
        JTextArea textArea = new JTextArea("Purchased Investment will be shown here:");
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        JScrollPane scrolledText = new JScrollPane(textArea);
        scrolledText.setHorizontalScrollBarPolicy(
                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  //scrollbars will always show
        scrolledText.setVerticalScrollBarPolicy(
                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrolledText.setPreferredSize(new Dimension(450, 100));
        message1panel.add(scrolledText, BorderLayout.CENTER);

        message1panel.setVisible(false);
        message1panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Message"));
            
        message1panel.setPreferredSize(new Dimension(600, 170));
        
        buyPanel.add(message1panel, BorderLayout.SOUTH);
        //end of messagePanel

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.anchor = GridBagConstraints.WEST;
        

        JLabel test = new JLabel("Type"); //type for Buy
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        buy1panel.add(test, constraints);
        
        TypecomboBox = new JComboBox<String>(); //mkaing a combo box
        TypecomboBox.addItem("Stock");
		TypecomboBox.addItem("MutualFund");
        TypecomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

        TypecomboBox.setPreferredSize(new Dimension(100, 20));
        constraints.gridx = 1;
		buy1panel.add(TypecomboBox, constraints);

        JLabel symbollabel = new JLabel("Symbol");  //Symbol label
        constraints.gridy = 1;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        buy1panel.add(symbollabel, constraints);
        

        textField2 = new JTextField(20);
        textField2.setPreferredSize(new Dimension(100, 20));
        constraints.gridx = 1;
		buy1panel.add(textField2, constraints);

        JLabel NameLabel = new JLabel("Name");  //Name label
        constraints.gridy = 2;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        buy1panel.add(NameLabel, constraints);

        textField3 = new JTextField(20);
        textField3.setPreferredSize(new Dimension(100, 20));
        constraints.gridx = 1;
		buy1panel.add(textField3, constraints);

        JLabel quantityLabel = new JLabel("Quantity");  //Quantity label
        constraints.gridy = 3;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        buy1panel.add(quantityLabel, constraints);

        textField4 = new JTextField(20); 
        textField4.setPreferredSize(new Dimension(100, 20));
        constraints.gridx = 1;
		buy1panel.add(textField4, constraints);
        
        JLabel PriceLabel = new JLabel("Price");  //Price label
        constraints.gridy = 4;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        buy1panel.add(PriceLabel, constraints);

        textField5 = new JTextField(20); 
        textField5.setPreferredSize(new Dimension(100, 20));
        constraints.gridx = 1;
		buy1panel.add(textField5, constraints);

        buy1panel.setVisible(false);
        buy1panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Buy an Investment"));
        
        buy1panel.setPreferredSize(new Dimension(400, 300));

        buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setPreferredSize(new Dimension(100, 300));
        buttonPanel.setVisible(false);
        JButton btnReset = new JButton("Reset");
        buttonPanel.add(btnReset, BorderLayout.NORTH);
        btnReset.addActionListener(new ActionListener() {  //reseting all the textfield by setting the text to null
			public void actionPerformed(ActionEvent e) {
				textField2.setText(null);
				textField3.setText(null);
				textField4.setText(null);
				textField5.setText(null);
				textArea.setText(null);
				
			}
		});
        //SUbmit Button
        JButton btnSubmit = new JButton("Submit");
        buttonPanel.add(btnSubmit, BorderLayout.SOUTH);
        
        btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean quantityExists = false;
                boolean priceExists = false;

                if(textField2.getText().isEmpty() || textField3.getText().isEmpty() || textField4.getText().isEmpty() || textField5.getText().isEmpty())
                {
                    textArea.setText("Please Enter all the information\n");
                }
                else
                {
                    textArea.setText(null);
                    try{
                        int i = Integer.parseInt(textField4.getText());
                        quantityExists = true;
                    }catch(NumberFormatException el) {
                        textArea.setText(textArea.getText() + "Invalid Quantity Number \n");
                         
                    }
                    try{
                        double i = Double.parseDouble(textField5.getText());
                        priceExists = true;
                        
                    }catch(NumberFormatException el) {
                        textArea.setText(textArea.getText() + "Invalid Price Fromat\n");
                    }
                    if(quantityExists == true && priceExists == true)
                    {
                        textArea.setText("Submitted");
                        if(TypecomboBox.getSelectedItem().equals("Stock"))
                        {
                            String inSymbol = textField2.getText();
                            String inName = textField3.getText();
                            String inQn = textField4.getText();
                            String inPrice = textField5.getText();
                            Stock newStock = new Stock();
                            newStock.setType("Stock");
                            newStock.newInvestment(inSymbol, inName, inQn, inPrice);
                            investment.add(newStock);
                        }
                        else if(TypecomboBox.getSelectedItem().equals("MutualFund"))
                        {
                            String inSymbol = textField2.getText();
                            String inName = textField3.getText();
                            String inQn = textField4.getText();
                            String inPrice = textField5.getText();
                            MutualFunds newFunds = new MutualFunds();
                            newFunds.setType("MutualFund");
                            newFunds.newInvestment(inSymbol, inName, inQn, inPrice);
                            investment.add(newFunds);
                        }
                        for(int i = 0 ; i < investment.size(); i++) //printing all the data from arrayList
                        {
                            textArea.setText("Purchased Investment: \n"+investment.get(i).toString());        
                        }
                    }
                    nameTextField.setText(investment.get(0).getName());
                    symTextField.setText(investment.get(0).getSymbol());
                    
                }
                textField2.setText(null);
				textField3.setText(null);
				textField4.setText(null);
				textField5.setText(null);
				
			}
		});

        buyPanel.add(buy1panel, BorderLayout.LINE_START);
        buyPanel.add(buttonPanel, BorderLayout.CENTER);
        
        buyPanel.setVisible(false);
        add(buyPanel); //end of buy panel

        //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX  SELL panel formating XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx
        /*
            If the user select sell command from the menu the interface will change to the Figure"Selling an investment". The interface is 
            similar to buying an investment, but with fewer textfield. The user can enter the symbol name, the quantity and the price the user
            want to sell that investment for. If the symbol does not exists then an error will be displayed or else it will sell the investment
            for the price the user enters. If the quantity is more than what user have then an error will be displayed in message panel.
        */

        sellPanel = new JPanel( new BorderLayout());
        sell1Panel = new JPanel(new GridBagLayout());
        sell1Panel.setVisible(false);

        messageSellPanel = new JPanel(new BorderLayout());

        //message panel starting from here
        JTextArea textArea2 = new JTextArea("After selling the investment, what is left will be shown here:");
        textArea2.setLineWrap(true);
        textArea2.setEditable(false);
        JScrollPane scrolledText2 = new JScrollPane(textArea2);
        scrolledText2.setHorizontalScrollBarPolicy(
                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrolledText2.setVerticalScrollBarPolicy(
                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrolledText2.setPreferredSize(new Dimension(450, 100));
        messageSellPanel.add(scrolledText2, BorderLayout.CENTER);

        messageSellPanel.setVisible(false);
        messageSellPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Message"));
            
        messageSellPanel.setPreferredSize(new Dimension(600, 180));
        
        sellPanel.add(messageSellPanel, BorderLayout.SOUTH);


        JLabel smLabel = new JLabel("Symbol");  //Symbol label
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        sell1Panel.add(smLabel, constraints);

        sytextField = new JTextField(20);
        sytextField.setPreferredSize(new Dimension(100, 20));
        constraints.gridx = 1;
		sell1Panel.add(sytextField, constraints);

        JLabel QnLabel = new JLabel("Quantity");  //Quantity label
        constraints.gridy = 1;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        sell1Panel.add(QnLabel, constraints);

        QntextField = new JTextField(20);
        QntextField.setPreferredSize(new Dimension(100, 20));
        constraints.gridx = 1;
		sell1Panel.add(QntextField, constraints);

        JLabel Prlabel = new JLabel("Price");  //price label
        constraints.gridy = 2;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        sell1Panel.add(Prlabel, constraints);

        PrytextField = new JTextField(20);
        PrytextField.setPreferredSize(new Dimension(100, 20));
        constraints.gridx = 1;
		sell1Panel.add(PrytextField, constraints);


        sell1Panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Sell an Investment"));
        
        sell1Panel.setPreferredSize(new Dimension(400, 300));

        sellPanel.add(sell1Panel, BorderLayout.LINE_START);

        sellbtnPanel = new JPanel(new BorderLayout());
        sellbtnPanel.setVisible(false);
        sellbtnPanel.setPreferredSize(new Dimension(100, 300));
        sellbtnPanel.setVisible(false);
        JButton sellbtnReset = new JButton("Reset");
        sellbtnPanel.add(sellbtnReset, BorderLayout.NORTH);
        sellbtnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrytextField.setText(null);
				sytextField.setText(null);
				QntextField.setText(null);
                textArea2.setText(null);
			}
		});
        //SUbmit Button
        JButton sellbtnSubmit = new JButton("Sell");
        sellbtnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    boolean quantityExists = false;
                boolean priceExists = false;

                if(PrytextField.getText().isEmpty() || sytextField.getText().isEmpty() || QntextField.getText().isEmpty() )
                {
                    textArea2.setText("Please Enter all the information\n");
                }
                else
                {
                    textArea2.setText(null);
                    try{
                        int i = Integer.parseInt(QntextField.getText());
                        quantityExists = true;
                    }catch(NumberFormatException el) {
                        textArea2.setText(textArea2.getText() + "Invalid Quantity Format. Please enter only integer numbers \n");
                         
                    }
                    try{
                        double i = Double.parseDouble(PrytextField.getText());
                        priceExists = true;
                        
                    }catch(NumberFormatException el) {
                        textArea2.setText(textArea2.getText() + "Invalid Price Fromat. Please enter number (double or integer) \n");
                    }
                    if(quantityExists == true && priceExists == true)
                    {
                        String symbolName = sytextField.getText();
                        boolean exist = false;
                        for(int i =0; i<investment.size(); i++)
                        {
                            
                            if(symbolName.equals(investment.get(i).getSymbol()) == true)
                            {
                                if(investment.get(i).getType().equalsIgnoreCase("mutualfund")) //if the investment type is mutual fund 
                                {
                                    int size;
                                    size = ((MutualFunds) investment.get(i)).sell(QntextField.getText(), PrytextField.getText()); //casting to call the method from subclass to main                       
                                    exist = true;
                                    if(size == 2)
                                    {
                                        textArea2.setText("Please enter quantity equal to or less than what you have");
                                    }
                                    if(size == 1)
                                    {
                                        textArea2.setText("All the investment for" + symbolName + "are sold");
                                        investment.remove(i); //removing the investment from the arrayList   
                                    }
                                }

                            }
                            if(symbolName.equals(investment.get(i).getSymbol()) == true)
                            {
                                if(investment.get(i).getType().equalsIgnoreCase("stock")) //if the investment type in stock 
                                {
                                    int size;
                                    size = ((Stock) investment.get(i)).sell(QntextField.getText(), PrytextField.getText());     //casting to the right subclass type                  
                                    exist = true;
                                    if(size == 2)
                                    {
                                        textArea2.setText("Please enter quantity equal to or less than what you have");
                                    }
                                    if(size == 1)
                                    {
                                        textArea2.setText("All the investment for " + symbolName + " are sold");
                                        investment.remove(i); //removing the investment from the arrayList    
                                    }
                                }
                            }
                        }
                        if(exist == false)  //if the symbol entered by the user is wrong than an error message is printed
                        {
                            textArea2.setText("There was no match found for the Symbol: " + symbolName + " you entered"); //error message
                        }
                        for(int i = 0 ; i < investment.size(); i++) //printing all the data from arrayList
                        {
                            if(symbolName.equals(investment.get(i).getSymbol()) == true)
                            {
                                textArea2.setText("Investment left for " + symbolName + ": \n"+investment.get(i).toString());
                            }
                                    
                        }
                        
                        PrytextField.setText(null);
				        sytextField.setText(null);
				        QntextField.setText(null);

                    }
                }
			}
		});

        sellbtnPanel.add(sellbtnSubmit, BorderLayout.SOUTH);
        sellPanel.add(sellbtnPanel, BorderLayout.CENTER);

        sellPanel.setVisible(false);
        add(sellPanel);

        //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxxxxxx Update Panel Formatting XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        /*
            If user select update command from the menu the interface will change to figure "updating Investment". This interface will show
            symbol and name in uneditable textfield. There are 3 buttons on the right side of the interface; prev, Next and save. The user can 
            click the next button to move forward in the arraylist and the accordingly the text in symbol and name textfield will change. Similarly,
            the user can press prev button to move backwards. Then the user can enter new price he/she wish to update and press save button to
            update the price. The updated price will be displayed on the message panel. If the users enters string in price textfield an error 
            will be displayed in mesage panel and will ask the user to enter number.  
        */
        updatePanel = new JPanel(new BorderLayout());
        update1Panel = new JPanel(new GridBagLayout());
        update1Panel.setVisible(false);

        messageupdatePanel = new JPanel(new BorderLayout());

        //message panel starting from here
        JTextArea textArea3 = new JTextArea("The Updated price will be shown here");
        textArea3.setLineWrap(true);
        textArea3.setEditable(false);
        JScrollPane scrolledText3 = new JScrollPane(textArea3);
        scrolledText3.setHorizontalScrollBarPolicy(
                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrolledText3.setVerticalScrollBarPolicy(
                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrolledText3.setPreferredSize(new Dimension(450, 100));
        messageupdatePanel.add(scrolledText3, BorderLayout.CENTER);

        messageupdatePanel.setVisible(false);
        messageupdatePanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Message"));
            
        messageupdatePanel.setPreferredSize(new Dimension(600, 150));
        
        updatePanel.add(messageupdatePanel, BorderLayout.SOUTH);

        JLabel smLabel1 = new JLabel("Symbol");  //Symbol label
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        update1Panel.add(smLabel1, constraints);

        symTextField = new JTextField(20);
        symTextField.setPreferredSize(new Dimension(100, 20));
        symTextField.setEditable(false);
        constraints.gridx = 1;
		update1Panel.add(symTextField, constraints);

        JLabel name1Label = new JLabel("Name");  //Quantity label
        constraints.gridy = 1;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        update1Panel.add(name1Label, constraints);

        nameTextField = new JTextField(20);
        //nameTextField.setText("HI there");
        nameTextField.setPreferredSize(new Dimension(100, 20));
        nameTextField.setEditable(false);
        constraints.gridx = 1;
		update1Panel.add(nameTextField, constraints);

        JLabel Prlabel1 = new JLabel("Price");  //price label
        constraints.gridy = 2;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        update1Panel.add(Prlabel1, constraints);

        PriceTextField = new JTextField(20);
        PriceTextField.setPreferredSize(new Dimension(100, 20));
        constraints.gridx = 1;
		update1Panel.add(PriceTextField, constraints);


        update1Panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Updating Investment"));
        
        update1Panel.setPreferredSize(new Dimension(400, 300));
        updatePanel.add(update1Panel, BorderLayout.LINE_START);

        updatebtnPanel = new JPanel(new BorderLayout());
        updatebtnPanel.setVisible(false);
        updatebtnPanel.setPreferredSize(new Dimension(100, 300));
        
        JButton updatebtnPre = new JButton("Prev");
        updatebtnPre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if ( ListId-1 >=0) 
                {
                    symTextField.setText(investment.get(ListId-1).getSymbol());
                    nameTextField.setText(investment.get(ListId-1).getName());
                    ListId--; 
                }    
            }
        });
        updatebtnPanel.add(updatebtnPre, BorderLayout.NORTH);
        
        JButton updatebtnNext = new JButton("Next");
        
        updatebtnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (ListId+1 < investment.size() ) 
                {
                    symTextField.setText(investment.get(ListId+1).getSymbol());
                    nameTextField.setText(investment.get(ListId+1).getName());
                    ListId++;
                      
                }
            }
        });
        updatebtnPanel.add(updatebtnNext, BorderLayout.CENTER);
       
        //Save Button
        JButton updatebtnSave = new JButton("Save");
        updatebtnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean priceExists = false;
                if(PriceTextField.getText().isEmpty())
                {
                    textArea3.setText("Please enter the price to update");
                }
                else
                {
                    textArea3.setText(null);
                    try{
                        double i = Double.parseDouble(PriceTextField.getText());
                        priceExists = true;
                    }catch(NumberFormatException el) {
                        textArea3.setText(textArea3.getText() + "Invalid Price Format. Please enter numbers only \n");    
                    }
                    String inSymbol = symTextField.getText();
                    String inPrice = PriceTextField.getText();
                    int indexValue = 0;
                    if(priceExists == true)
                    {
                        for(int i = 0; i < investment.size(); i++)
                        {
                            if(inSymbol.equalsIgnoreCase(investment.get(i).getSymbol()))
                            {
                                indexValue = i;
                                if(investment.get(i).getType().equalsIgnoreCase("stock"))  //if the type matches 
                                {
                                    ((Stock) investment.get(i)).updatePrice(inPrice);  //updatePrice is called
                                }
                                if(investment.get(i).getType().equalsIgnoreCase("mutualfund"))
                                {
                                    ((MutualFunds) investment.get(i)).updatePrice(inPrice);
                                }
                            }
                        }
                        for(int i = 0; i < investment.size(); i++)
                        {
                            textArea3.setText("This is the updated price: \n" + investment.get(indexValue).toString());
                        }
                    }
                    PriceTextField.setText(null);
                    
                }
                
            }
        });
        updatebtnPanel.add(updatebtnSave, BorderLayout.SOUTH);

        updatePanel.add(updatebtnPanel, BorderLayout.CENTER);

        updatePanel.setBackground(Color.WHITE);
        updatePanel.setVisible(false);
        add(updatePanel);


        //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx Search Investment Panel Formatting xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
        /*
            If user select search command from the menu the interface will change to figure "Searching Investment". The interface looked 
            almost similar to buying an investment except that there are 2 differnent labels "low price" and "high price". The user enters in
            low price textfeild as the starting of range and the high price for the end of the range. The code will check if the price of the 
            investment the user is searching from exists within the price range the user entered. If not then an error will be displayed else 
            the the searched investment will be displayed in message panel. Similary, if the user enters symbol and name keyword that does not 
            exists then error will be displayed.
        */
        searchPanel = new JPanel(new BorderLayout());
        searchPanel.setBackground(Color.GRAY);
        searchingPanel = new JPanel(new GridBagLayout());
        searchingPanel.setVisible(false);

        JLabel smLabel2 = new JLabel("Symbol");  //Symbol label
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        searchingPanel.add(smLabel2, constraints);

        srsymTextfield = new JTextField(20);
        srsymTextfield.setPreferredSize(new Dimension(100, 20));
        constraints.gridx = 1;
		searchingPanel.add(srsymTextfield, constraints);

        JLabel keyLabel = new JLabel("Name Keywords");  //Quantity label
        constraints.gridy = 1;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        searchingPanel.add(keyLabel, constraints);

        keyTextfield = new JTextField(20);
        keyTextfield.setPreferredSize(new Dimension(100, 20));
        constraints.gridx = 1;
		searchingPanel.add(keyTextfield, constraints);

        JLabel lowLabel = new JLabel("Low Price");  //Low price label
        constraints.gridy = 2;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        searchingPanel.add(lowLabel, constraints);

        lowTextfield = new JTextField(20);
        lowTextfield.setPreferredSize(new Dimension(100, 20));
        constraints.gridx = 1;
		searchingPanel.add(lowTextfield, constraints);

        JLabel highLabel = new JLabel("High Price");  //High price label
        constraints.gridy = 3;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        searchingPanel.add(highLabel, constraints);

        highTextfield = new JTextField(20);
        highTextfield.setPreferredSize(new Dimension(100, 20));
        constraints.gridx = 1;
		searchingPanel.add(highTextfield, constraints);

        searchingPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Searching Investments"));
        
        searchingPanel.setPreferredSize(new Dimension(400, 300));
        searchPanel.add(searchingPanel, BorderLayout.LINE_START);

        searchmessagePanel = new JPanel(new BorderLayout());
        searchmessagePanel.setVisible(false);

        JTextArea textArea5 = new JTextArea("The search result will be shown here:");
        textArea5.setLineWrap(true);
        textArea5.setEditable(false);
        JScrollPane scrolledText5 = new JScrollPane(textArea5);
        scrolledText5.setHorizontalScrollBarPolicy(
                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrolledText5.setVerticalScrollBarPolicy(
                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrolledText5.setPreferredSize(new Dimension(450, 100));
        searchmessagePanel.add(scrolledText5, BorderLayout.CENTER);

        searchmessagePanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Search Result"));
            
        searchmessagePanel.setPreferredSize(new Dimension(600, 170));
        
        searchPanel.add(searchmessagePanel, BorderLayout.SOUTH);
        
        searchbtnPanel = new JPanel(new BorderLayout());
        searchbtnPanel.setPreferredSize(new Dimension(100, 300));
        searchbtnPanel.setVisible(false);
        JButton searchbtnReset = new JButton("Reset");
        searchbtnPanel.add(searchbtnReset, BorderLayout.NORTH);
        searchbtnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				srsymTextfield.setText(null);
				keyTextfield.setText(null);
				lowTextfield.setText(null);
                highTextfield.setText(null);
                textArea5.setText(null);
			}
		});
        //SUbmit Button
        JButton searchbtnSubmit = new JButton("Search");
        searchbtnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                
                if(srsymTextfield.getText().isEmpty() || keyTextfield.getText().isEmpty() || lowTextfield.getText().isEmpty() || highTextfield.getText().isEmpty())
                {
                    textArea5.setText("Please Enter all the information\n");
                }
                else
                {
                    boolean symbolcheck = false;
                    boolean keywordExists = false;
                    boolean lowpreiceExists = false;
                    boolean highpriceExists = false;
                    String inSymbolName = srsymTextfield.getText();
                    String key[] = keyTextfield.getText().split("[.,:;/+]");
                    double tempHigh = Double.parseDouble(highTextfield.getText());
                    double tempLow = Double.parseDouble(lowTextfield.getText());
                    textArea5.setText(null);
                    try{
                        Double i = Double.parseDouble(lowTextfield.getText());
                        lowpreiceExists = true;
                    }catch(NumberFormatException el) {
                        textArea5.setText(textArea5.getText() + "Invalid LowPrice Format \n");
                         
                    }
                    try{
                        double i = Double.parseDouble(highTextfield.getText());
                        highpriceExists = true;
                        
                    }catch(NumberFormatException el) {
                        textArea5.setText(textArea5.getText() + "Invalid HighPrice Fromat\n");
                    }
                    if(lowpreiceExists == true && highpriceExists == true)
                    {
                        for(int i=0; i<investment.size(); i++)
                        {
                            if(inSymbolName.equalsIgnoreCase(investment.get(i).getSymbol())) //checks if the symbol exists or not
                            {
                                symbolcheck = true;
                                for(int k=0; k<key.length; k++) //checking if the keyword matches
                                {
                                    if(investment.get(i).getName().contains(key[k]))
                                    {
                                        keywordExists = true;
                                    }
                                }
                                if(keywordExists == true && symbolcheck == true)
                                {
                                    if(investment.get(i).getPrice() <= tempHigh && investment.get(i).getPrice() >= tempLow)
                                    {
                                        textArea5.setText("The search result: \n"+ investment.get(i).toString());
                                    }
                                    else
                                    {
                                        textArea5.setText("No investment was found for price range entered");
                                    }
                                }
                                else
                                {
                                    textArea5.setText("The entered KeyName = "+ keyTextfield.getText() +" was not found");
                                }
                            }
                            if(symbolcheck == false)
                            {
                                textArea5.setText("The entered Symbol name : " + srsymTextfield.getText() + " was not found \n");
                            }
                        }
                    }
                }

            }
        });
        searchbtnPanel.add(searchbtnSubmit, BorderLayout.SOUTH);
        searchPanel.add(searchbtnPanel, BorderLayout.CENTER);


        searchPanel.setVisible(false);
        add(searchPanel);

        //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx Gain Panel Formatting xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
        /*
            If user select GetGain command from the menu the interface will change to figure "Getting total Gain". The total gain textfield is
            not editable and will show the total gain from all the investment in the arraylist. And message panel will display all the individual
            gain with all the attributes.
        */
        gainPanel = new JPanel(new BorderLayout());

        gainmessagePanel = new JPanel(new BorderLayout());
        gainmessagePanel.setVisible(false);
        //message panel starting from here
        textArea4 = new JTextArea("Individual Gains are displayed below \n");
        textArea4.setLineWrap(true);
        textArea4.setEditable(false);
        JScrollPane scrolledText4 = new JScrollPane(textArea4);
        scrolledText4.setHorizontalScrollBarPolicy(
                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrolledText4.setVerticalScrollBarPolicy(
                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrolledText4.setPreferredSize(new Dimension(450, 100));
        gainmessagePanel.add(scrolledText4, BorderLayout.CENTER);

        gainmessagePanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Individual Gains"));
            
        gainmessagePanel.setPreferredSize(new Dimension(600, 200));
        
        gainPanel.add(gainmessagePanel, BorderLayout.SOUTH);

        getgainPanel = new JPanel(new GridBagLayout());
        getgainPanel.setVisible(false);
        JLabel gainLabel = new JLabel("Total Gain");  //Total gain label
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        getgainPanel.add(gainLabel, constraints);

        gainTextField = new JTextField(20);
        gainTextField.setPreferredSize(new Dimension(100, 20));
        gainTextField.setEditable(false);
        constraints.gridx = 1;
		getgainPanel.add(gainTextField, constraints);        

        getgainPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Getting Total Gain"));
        
        gainPanel.add(getgainPanel);

        gainPanel.setVisible(false);
        add(gainPanel);
        //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx End of gain Panels xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

        commandPanel = new JPanel(new BorderLayout() );
        commandPanel.setBackground(Color.WHITE);
        commandPanel.setVisible(true);
        
        String text = "Choose a command from the 'Commands' menu to buy or sell an investment, update prices for all investments, get gain for the portfolio, search for relevant investments, or quit the program.";
        JLabel cLabel1 = new JLabel("<html>"+text+"</html>", SwingConstants.LEFT);
        JLabel cLabel = new JLabel("<html>"+"Welcome to ePortfolio."+"</html>", SwingConstants.LEFT);
        
        cLabel.setFont(new Font("Verdana", 1, 20));
        cLabel1.setFont(new Font("Verdana", 1, 15));
                
        commandPanel.add(cLabel1, BorderLayout.CENTER);
        commandPanel.add(cLabel, BorderLayout.NORTH);
        add(commandPanel);


        //Menu staring here
        JMenu Menu = new JMenu("Commands");

        JMenuItem Buy = new JMenuItem("Buy");
        Buy.addActionListener(new BuyListener());
        Menu.add(Buy);

        JMenuItem Sell = new JMenuItem("Sell");
        Sell.addActionListener(new SellListener());
        Menu.add(Sell);

        JMenuItem update = new JMenuItem("Update");
        update.addActionListener(new UpdateListener());
        Menu.add(update);

        JMenuItem gain = new JMenuItem("getGain");
        gain.addActionListener(new GainListener());
        Menu.add(gain);
        
        JMenuItem search = new JMenuItem("Search");
        search.addActionListener(new SearchListener());
        Menu.add(search);

        JMenuItem quit = new JMenuItem("Quit");
        quit.addActionListener(new QuitListener());
        Menu.add(quit);


        JMenuBar bar = new JMenuBar( );
        bar.add(Menu);
        setJMenuBar(bar);
        //end of menu

    }
    public static void main(String[] args) 
    {
        ePortfolio window = new ePortfolio();
        window.setVisible(true);
        
    }

    //panels
    private class BuyListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            sellPanel.setVisible(false);
            buyPanel.setVisible(true);
            updatePanel.setVisible(false);
            searchPanel.setVisible(false);
            gainPanel.setVisible(false);
            commandPanel.setVisible(false);
            buy1panel.setVisible(true);
            message1panel.setVisible(true);
            buttonPanel.setVisible(true);
        }
    }//End of BuyListener inner class
    private class SellListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            sellPanel.setVisible(true);
            buyPanel.setVisible(false);
            updatePanel.setVisible(false);
            searchPanel.setVisible(false);
            gainPanel.setVisible(false);
            commandPanel.setVisible(false);
            sell1Panel.setVisible(true);
            messageSellPanel.setVisible(true);
            sellbtnPanel.setVisible(true);
        }
    }//End of SellListener inner class
    private class UpdateListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            sellPanel.setVisible(false);
            buyPanel.setVisible(false);
            updatePanel.setVisible(true);
            searchPanel.setVisible(false);
            gainPanel.setVisible(false);
            commandPanel.setVisible(false);
            messageupdatePanel.setVisible(true);
            update1Panel.setVisible(true);
            updatebtnPanel.setVisible(true);
        }
    }//End of UpdateListener inner class
    private class SearchListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            sellPanel.setVisible(false);
            buyPanel.setVisible(false);
            updatePanel.setVisible(false);
            searchPanel.setVisible(true);
            gainPanel.setVisible(false);
            commandPanel.setVisible(false);
            searchingPanel.setVisible(true);
            searchmessagePanel.setVisible(true);
            searchbtnPanel.setVisible(true);
        }
    }//End of SearchListener inner class
    private class GainListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            sellPanel.setVisible(false);
            buyPanel.setVisible(false);
            updatePanel.setVisible(false);
            searchPanel.setVisible(false);
            gainPanel.setVisible(true);
            commandPanel.setVisible(false);
            gainmessagePanel.setVisible(true);
            getgainPanel.setVisible(true);
            textArea4.setText(null);
            double totalGain = 0;
            for(int i =0; i<investment.size(); i++)
            {
                //textArea4.setText(textArea4 + investment.get(i).toString());
                totalGain = totalGain + investment.get(i).getGain();
            }
            for(Investment a : investment)
            {
                textArea4.setText(textArea4.getText() + a + "\n");
            }
            gainTextField.setText(Double.toString(totalGain));
        }
    }//End of GainListener inner class

    private class QuitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            dispose();
        }
    }//End of QuitListener inner class
    
}
