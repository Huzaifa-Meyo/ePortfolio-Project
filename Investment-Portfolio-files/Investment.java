import java.util.Scanner;
import java.lang.String;
import java.util.StringTokenizer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class Investment 
{
    protected double bookValue;
    protected int quantity;
    protected String symbol;
    protected String name;
    protected double price;
    protected double gain;
    protected String type;

    
    /** 
     * @return double
     */
    public double getGain()
    {
        return gain;
    }
    
    /** 
     * @return double
     */
    public double getPrice()
    {
        return price;
    }
    
    /** 
     * @return String
     */
    public String getSymbol()
    {
        return symbol;
    }
    
    /** 
     * @return int
     */
    public int getQuantity()
    {
        return quantity;
    } 
    
    /** 
     * @return String
     */
    public String getName()
    {
        return name;
    }
    
    /** 
     * @return double
     */
    public double getBookvalue()
    {
        return bookValue;
    }
    
    /** 
     * @return String
     */
    public String getType()
    {
        return type;
    }
    
    
    /** 
     * @param Usertype
     */
    public void setType(String Usertype)
    {
        type = Usertype;
    }
    
    /** 
     * @param UserSymbol
     */
    public void setSymbol(String UserSymbol)
    {
        symbol = UserSymbol;
    }
    
    /** 
     * @param UserName
     */
    public void setname(String UserName)
    {
        name = UserName;
    }
    
    /** 
     * @param UserPrice
     */
    public void setPrice(String UserPrice)
    {
        price = Double.parseDouble(UserPrice);
    }
    
    /** 
     * @param UserBookvalue
     */
    public void setBookvalue(String UserBookvalue)
    {
        bookValue = Double.parseDouble(UserBookvalue);
    }
    
    /** 
     * @param UserQuantity
     */
    public void setQuantity(String UserQuantity)
    {
        quantity = Integer.parseInt(UserQuantity);
    }

    
    /** 
     * @return String
     */
    public String toString()
    {
        return "Type: " + type + "\nSymbol: " + symbol +"\nName: " + name + "\nPrice: " + price + "\nQuantity: " + quantity + "\nBook Value: " + bookValue + "\nGain: " + gain + "\n"; //prints all arrayList
    }
    
    /** 
     * @param filename
     */
    /*public int addNamefromFile(String filename)
    {
        Scanner inputStream = null;
        
        try 
        {
            inputStream = new Scanner(new FileInputStream(filename));
        } catch (FileNotFoundException e)  //throws an error if the name of the file is not found
        {
            System.out.println("File data.txt was not found");
            System.out.println("or could not be opened.");

            return 0;
        }
        String delimiters = ",:;= \"";
        
        while (inputStream.hasNextLine()) 
        {
            String temp;
            temp = inputStream.nextLine();
            if(temp.isEmpty())
            {
                temp = inputStream.nextLine();
            }
            StringTokenizer nameFactory = new StringTokenizer(temp, delimiters);
            
            String firstArray = nameFactory.nextToken();
            String secondArray = nameFactory.nextToken();
            if(firstArray.equalsIgnoreCase("type"))
            {
                type = secondArray;
            }
            if(firstArray.equalsIgnoreCase("symbol"))
            {
                symbol = secondArray;
            }
            if(firstArray.equalsIgnoreCase("name"))
            {
                name = secondArray;
            }
            if(firstArray.equalsIgnoreCase("quantity"))
            {
                quantity = Integer.parseInt(secondArray);
            }
            if(firstArray.equalsIgnoreCase("price"))
            {
                price = Double.parseDouble(secondArray);
            }
            if(firstArray.equalsIgnoreCase("bookvalue"))
            {
                bookValue = Double.parseDouble(secondArray);
            }
                        
        }
        gain = 0;
        inputStream.close();
        System.out.println("Importing done");
        return 1;
    }*/


}