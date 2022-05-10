import java.util.Scanner;
import java.lang.String;

public class MutualFunds extends Investment
{
    public static int redemtionFee = 45;

    
    public void bookValue()
    {
        bookValue = quantity * price; 
    }
    
    /** 
     * @param units
     */
    public void updatebookValue(int units)
    {
        int reducedunits = quantity - units;
        double quanInDouble = quantity;
        bookValue = (reducedunits/quanInDouble)*bookValue;
    }

    
    /** 
     * @param Symbol
     */
    public void newInvestment(String Symbol, String inName, String inQuantity, String inPrice)
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
        int units = Integer.parseInt(inQn);
        double newPrice = Double.parseDouble(inPrice);
        
        if(quantity == units)
        {
            price = newPrice;
            quantity = quantity - units;
            totalGain(); 
            return 1;
        }
        if(quantity < units)
        {
            return 2;
        }
        else
        {
            updatebookValue(units);
            price = newPrice;
            quantity = quantity - units;
            totalGain();
        }
        
        return 0;
    }

    public void updatePrice(String inprice)
    {
        price = Double.parseDouble(inprice);
        totalGain();
    }

    public void totalGain()
    {
        double newBkvalue = 0;
        newBkvalue = quantity * price - redemtionFee; 
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