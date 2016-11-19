//****************************************************************************
//PalindromicPrimes.java                                          James Austin
//SER 215 - 83894                                                      8/29/16
//
//Take in an integer n from user, then compute and display the first n 
//palindromic prime numbers.
//****************************************************************************

import java.util.Scanner;

public class PalindromicPrimes 
{
    public static void main(String[] args)
    {
        int givenN, revResult, testCount, lineCount;
        boolean primeResult;
        
        testCount = 2;
        lineCount = 0;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        givenN = scan.nextInt();
        
        //Loop runs until user input number is met
        while (testCount <= givenN)
        {
            revResult = reverseNum(testCount);
            primeResult = testPrime(testCount);
            
            if (primeResult == true)
            {
                if (revResult == testCount)
                {
                    if (lineCount <= 9)
                    {
                        System.out.print(testCount+" ");
                        lineCount++;
                    }
                    
                    //After 10 numbers start next line
                    else
                    {
                        System.out.print("\n"+testCount+" ");
                        lineCount = 1;
                    }
                }
            }
        //System.out.print(testCount);
        //System.out.print(revResult+" ");
        testCount++;
        }
    }
    
    //Check if testCount is prime
    public static boolean testPrime(int num)
    {
        if (num == 2)
            return true;
        else if (num % 2 ==0)
            return false;
        
        for (int m = 3; m * m <= num; m = m + 2)
        {
            if(num % m == 0)
                return false;
        }
        return true;
    }
    
    //Reverse the given number
    public static int reverseNum(int num)
    {
        int remainder, result;
        result = 0;
        
        while (num > 0)
        {
            remainder = num % 10;
            num = num / 10;
            result = result * 10 + remainder;
        }
        return result;
    }
}