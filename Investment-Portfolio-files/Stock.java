import java.lang.String;

public class Stock extends Investment
{
    public static double comission = 9.99;


    public void bookValue()
    {
        bookValue = quantity * price + comission;
    }

    
    /** 
     * @param shares
     */
    public void updatebookValue(int shares)
    {
        double reducedShares = quantity - shares;
        double quanInDouble = quantity;
        bookValue = (reducedShares/quanInDouble)*bookValue;
    }

    
    /** 
     * @param Symbol
     */
    public void newInvestment(String Symbol, String inName, String inQuantity, String inPrice)  //recently edited
    {
        symbol = Symbol;
        name = inName;
        quantity = Integer.parseInt(inQuantity);
        price = Double.parseDouble(inPrice);
        bookValue();
        gain = 0;
        
    }


    
    /** 
     * @return int
     */
    public int sell(String inQn, String inPrice)
    {
        int shares = Integer.parseInt(inQn);
        double newPrice = Double.parseDouble(inPrice);

        if(quantity < shares)
        {
            return 2;
        }
        if(quantity == shares)
        {
            price = newPrice;
            quantity = quantity - shares;
            totalGain(); 
            return 1;
        }
        else
        {
            updatebookValue(shares);
            price = newPrice;
            quantity = quantity - shares;
            totalGain();
        }
        return 0;
    }
    public void updatePrice(String inPrice)
    {
        price = Double.parseDouble(inPrice);
        totalGain();
    }

    public void totalGain()
    {
        double newBkvalue = 0;
        newBkvalue = quantity * price - comission; 
        gain = newBkvalue - bookValue;
    }
    
    
    /** 
     * @param Usertype
     */
    public void setType(String Usertype)
    {
        type = Usertype;
    }

    
    /** 
     * @return String
     */
    public String toString()
    {
        return "Type: " + type + "\nSymbol: " + symbol +"\nName: " + name + "\nPrice: " + price + "\nQuantity: " + quantity + "\nBook Value: " + bookValue + "\nGain: " + gain + "\n"; //prints all arrayList
    }

}