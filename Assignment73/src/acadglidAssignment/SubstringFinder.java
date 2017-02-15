/**
 * 
 */
package acadglidAssignment;

import java.util.Scanner;

/**
 * @author nikhil Class to find a substring without using inbuilt methods of
 *         String Class
 */
public class SubstringFinder 
{

	/**
	 * Author - Nikhil Sharma 
	 * Method Name - main
	 * Params- String[] args
	 * ReturnType - void
	 */
	public static void main(String[] args)
	{
		try
		{
			Scanner  objScanner = new Scanner(System.in); // initalize scanner object to capture user input
			System.out.println("Please enter String"); // notify user to enter string input
			String strUserinPut = objScanner.nextLine(); // capture user input as a string
			System.out.println("Please enter the substring you want to search"); // notify user to enter string user want to search
			String strSubSearch = objScanner.nextLine(); // capture input for substring user want to search
			System.out.println("Do you want a case senisitive search or ignore case differences?? Please enter 1 for case sensitive and 2 for case insensitive "); // take user input for case sensitive or case insensitive search
			int iSearchType = objScanner.nextInt(); // capture user input for type of substring search
			switch(iSearchType)
			{
				case 1:
				{
					stringComparer(strUserinPut, strSubSearch); // case sensitive search method call to print if substring is found or not
				}
				break;
				case 2:
				{
					strUserinPut = strUserinPut.toLowerCase(); // converts both string to lower case for case in sensitive search
					strSubSearch = strSubSearch.toLowerCase();	// converts both string to lower case for case in sensitive search
					stringComparer(strUserinPut, strSubSearch);// method call to print if substring is found or not
				}
				break;
				default:
				{
					System.out.println("Invalid Input"); // notify user of invalid input
				}
				break;
			}
			
			objScanner.close(); // close scanner object to avoid memory leakage
			
		}
		catch(Exception ex)
		{
			System.out.println("Invalid input"); // exception occurs if user provides invalid input
		}

	}

	/**
	 * Author - Nikhil Sharma 
	 * Method Name - stringComparer
	 *  Params- String,String 
	 *  Purpose - Compares to string and prints if substring is found in main string without using String Functions Return Type - void
	 */
	static void stringComparer(String strOriginalString, String strSubString)
	{
		try
		{
			char carrOriginalString[] = strOriginalString.toCharArray(); // converting strings to charachter array
			char cArrSubString[] = strSubString.toCharArray(); // converting strings to character array
			int i = 0; //counter to iterate main string array
			int j = 0; // counter to iterate substring array
			boolean isFound = false;
			    while(i<carrOriginalString.length && j<cArrSubString.length) // to iterate till entire substring traversal has been done
			    {
			        if(carrOriginalString[i]==cArrSubString[j])
			        {
			            i++; // increasing counter each time a character search is successfull
			            j++;
			        }
			        else
			        {
			            i++; // increasing counter of main string
			            j=0; // resetting counter of substring array if a mismatch happens before traversal of entire string
			        }
			        if(j == cArrSubString.length) // if the final counter of j is same as substring array length prints Substring found
			        {
			        	isFound = true; // set is found to true if match is found 
			        }
			        else
			        {
			        	isFound = false; // set is found to false if match isn't found
			        }
			    }
			   if(isFound)
			   {
				   System.out.println("Substring Found");
			   }
			   else
			   {
				   System.out.println("Substring Not Found");
			   }
		} 
		catch (Exception ex) 
		{
			System.out.println("stringComparer::::" + ex.getStackTrace());
		}
		 
	}
}
