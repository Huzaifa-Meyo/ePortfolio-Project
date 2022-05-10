Compilation:
javac ePortfolio.java Stock.java Investment.java MutualFunds.java
To run:
java ePortfolio Stock Investment MutualFunds


Description/ User Guid:
-First when a the user compile the code and run it. A window is opened called eportfolio. which has a welcome message and a brief 
instruction of how to use the system. The "Commands" menu has six choices: buy, sell, update, getGain, serach and quit.

-If the user select buy command the interface will be chnaged to the figure for "Buying an investment". The investment type 
can be selected from the drop-down list, where stock is selected as default. The user is required to enter Symbol, Name, Quanity 
and price. If the user does not enter any data or even one is missing and error will be displayed in message area. If the user 
enters string for quantity or price an error will be shown and will ask the user to enter number. There are 2 buttons on the right-side
the "Reset" button is for reseting all the textfield and "Submit" button is for buying a new investment. Once the investment is
brought then that investment will be shown in the message panel.

-If the user select sell command from the menu the interface will change to the Figure"Selling an investment". The interface is 
similar to buying an investment, but with fewer textfield. The user can enter the symbol name, the quantity and the price the user
want to sell that investment for. If the symbol does not exists then an error will be displayed or else it will sell the investment
for the price the user enters. If the quantity is more than what user have then an error will be displayed in message panel.

-If user select update command from the menu the interface will change to figure "updating Investment". This interface will show
symbol and name in uneditable textfield. There are 3 buttons on the right side of the interface; prev, Next and save. The user can 
click the next button to move forward in the arraylist and the accordingly the text in symbol and name textfield will change. Similarly,
the user can press prev button to move backwards. Then the user can enter new price he/she wish to update and press save button to
update the price. The updated price will be displayed on the message panel. If the users enters string in price textfield an error 
will be displayed in mesage panel and will ask the user to enter number.  

-If user select GetGain command from the menu the interface will change to figure "Getting total Gain". The total gain textfield is
not editable and will show the total gain from all the investment in the arraylist. And message panel will display all the individual
gain with all the attributes. 

-If user select search command from the menu the interface will change to figure "Searching Investment". The interface looked 
almost similar to buying an investment except that there are 2 differnent labels "low price" and "high price". The user enters in
low price textfeild as the starting of range and the high price for the end of the range. The code will check if the price of the 
investment the user is searching from exists within the price range the user entered. If not then an error will be displayed else 
the the searched investment will be displayed in message panel. Similary, if the user enters symbol and name keyword that does not 
exists then error will be displayed.

-If users select quit command from the menu, the program will end. Or if the user press X on the top of window then also the program
will end.



Assumptions:
-The user enter the correct spelling when typing in the type of investment or else the system will not recognize it.
-The user doesn't enter text when asked to enter number or the program will show an error.
-User enters the enters data in all the textfield with searching or else and error will show asking user to enter all the data.

Improvment:
-Learn a better and efficient way or doing it
-Make the inteface better and attractive by adding colors 
-Make the errors stand out 

limitation:
-Two types of investment (stock and Mutualfund) cannot have the same symbol name as they are saved in one arraylist
-Time was one of the limitations and also assignment from other courses were due on the same date
-Not able to use Netbean or other GUI builder that would have made it way easier
-only limited to two GUI packages awt and swing

TestCases:

1) Testing Buy, Sell
XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxx
-Selects Buy command from menu
Buy an Investment
type ------ Stock
symbol ------ Unity
Name ------ AQA
Quantity ------ 50
Price ------- 100

-press submit button to buy the investment

-In message area this is shown:
Purchased Investment: 
Type: Stock
Symbol: Unity 
Name: AQA
Price: 100.0
Quantity: 50
Book Value: 5009.99
Gain: 0.0

-select sell command from menu
Sell and Investment
symbol ------ Unity
Quantity ------ 10
Price ------- 101

-press sell button to sell the investment

-In message area this is shown:
Investment left for Unity: 
Type: Stock
Symbol: Unity
Name: AQA
Price: 101.0
Quantity: 40
Book Value: 4007.992
Gain: 22.01800000000003
 

2) Testing File Buy, update, getGain
XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxx
-Selects Buy command from menu
Buy an Investment
type ------ Stock
symbol ------ AUS
Name ------ bitcoin
Quantity ------ 10
Price ------- 122

-press submit button to buy the investment

-In message area this is shown:
Purchased Investment: 
Type: MutualFund
Symbol: AUS
Name: bitcoin
Price: 122.0
Quantity: 10
Book Value: 1220.0
Gain: 0.0

-press reset and buy a new investment

-select update command from menu
Selects Buy command from menu
Buy an Investment
type ------ Stock
symbol ------ Unity
Name ------ AQA
Quantity ------ 50
Price ------- 100

-press submit button to buy the investment

-In message area this is shown:
Purchased Investment: 
Type: Stock
Symbol: Unity 
Name: AQA
Price: 100.0
Quantity: 50
Book Value: 5009.99
Gain: 0.0

-select update command from menu
-use the buttons to move forward or backwards and find AUS symbol and change the price 
symbol ------ AUS
Name ------ bitcoin
Price ------ 130
-press save button to update the price

-In message area this is shown:
This is the updated price: 
Type: MutualFund
Symbol: AUS
Name: bitcoin
Price: 130.0
Quantity: 10
Book Value: 1220.0
Gain: 35.0

-select getGain command from menu

Total Gain ----- 57.01800000000003

-In message area this is shown:
Type: MutualFund
Symbol: AUS
Name: bitcoin
Price: 130.0
Quantity: 10
Book Value: 1220.0
Gain: 35.0

3) Testing Buy, update, getGain, search, Quit
XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxx
-Selects Buy command from menu
Buy an Investment
type ------ Stock
symbol ------ AUS
Name ------ bitcoin
Quantity ------ qw
Price ------- ww
-press submit button to buy the investment
-In message area this is shown:
Invalid Quantity Number 
Invalid Price Fromat

-press reset and buy a new investment
-Selects Buy command from menu
Buy an Investment
type ------ Stock
symbol ------ AUS
Name ------ bitcoin
Quantity ------ 10
Price ------- 122

-press submit button to buy the investment

-In message area this is shown:
Purchased Investment: 
Type: MutualFund
Symbol: AUS
Name: bitcoin
Price: 122.0
Quantity: 10
Book Value: 1220.0
Gain: 0.0

-press reset and buy a new investment

-select update command from menu
Selects Buy command from menu
Buy an Investment
type ------ Stock
symbol ------ Unity
Name ------ AQA
Quantity ------ 50
Price ------- 100

-press submit button to buy the investment

-In message area this is shown:
Purchased Investment: 
Type: Stock
Symbol: Unity 
Name: AQA
Price: 100.0
Quantity: 50
Book Value: 5009.99
Gain: 0.0

-select update command from menu
-use the buttons to move forward or backwards and find AUS symbol and change the price 
symbol ------ AUS
Name ------ bitcoin
Price ------ 130
-press save button to update the price

-In message area this is shown:
This is the updated price: 
Type: MutualFund
Symbol: AUS
Name: bitcoin
Price: 130.0
Quantity: 10
Book Value: 1220.0
Gain: 35.0

-select getGain command from menu

Total Gain ----- 57.01800000000003

-In Individual gain area this is shown:
Type: MutualFund
Symbol: AUS
Name: bitcoin
Price: 130.0
Quantity: 10
Book Value: 1220.0
Gain: 35.0

-select Search command from menu
Searching Investment
Symbol------- AUS
Name ------- bitcoin
Low Price ------- 0
Low Price------- 100

-select search button

-In Search Result area this is shown:
No investment was found for price range entered

-select reset button
Searching Investment
Symbol------- AUS
Name ------- bitcoin
Low Price ------- 0
Low Price------- 200

-In Search Result area this is shown:
Type: MutualFund
Symbol: AUS
Name: bitcoin
Price: 130.0
Quantity: 10
Book Value: 1220.0
Gain: 35.0

-select quit command from menu to quit or to close the program




