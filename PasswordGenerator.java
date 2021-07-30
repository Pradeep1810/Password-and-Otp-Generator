package com.passwordProject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hi, What's your name ?");
		Scanner sc = new Scanner(System.in);
		
		String name = sc.nextLine();
		System.out.println("Welcome " +name +" "  +"to the Program ");
		Thread.sleep(1000);
		
			System.out.print("Loading ");
			Thread.sleep(1000);
			System.out.println("......");
		
		
		System.out.println("Please enter the corresponding option number ");
         System.out.println("1. Password generator ");
         System.out.println("2. OTP generator and checker ");
        int option = sc.nextInt();
        switch (option)
        {
        case (1):
        	System.out.println("hi " +name);

		int response;
		int loopCount=1;
		int combinedAndConvertedSize=0;
		int finalComboSize=0;
		String finalCombo="";
		String randomPassword="";
		String combinedAndConverted;
		

		do {
		System.out.println("Enter the number of passwords you desire ->->  ");
		 sc = new Scanner(System.in);
		int numberOfPasswords=sc.nextInt();
		 
		/*  we use lists or collections here casue we can randomly select from them
		 it solves the problem as each string is assigned to an index position*/
		
		ArrayList<String> capitalAlphabets = new ArrayList<>();
		    capitalAlphabets.add("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		
		ArrayList<String>smallAlphabets = new ArrayList<>();
		    smallAlphabets.add("abcdefghijklmnopqrstuvwxyz");
		
		capitalAlphabets.addAll(smallAlphabets);
		
		ArrayList<String> numbers = new ArrayList<>();
		numbers.add("0123456789");
		capitalAlphabets.addAll(numbers);
		
		ArrayList<String> specialCharacter = new ArrayList<>();
		specialCharacter.add("!@#$%^&*?");
		capitalAlphabets.addAll(specialCharacter);
		
		/*  StringBUilder is used to create a flexible mutable changable string*/
		
		StringBuilder stb = new StringBuilder();
		for(String  a : capitalAlphabets) {
			stb.append(a);   /* each value of a which is inturn retrived
            from capitalAlphabets is put in this stringBuilder class object*/
			/* cannot directly use combinedAndConverted = stb; */
			combinedAndConverted=stb.toString(); // here tostring converts the stringbuilder to a normal string
			 combinedAndConvertedSize=combinedAndConverted.length();
			}

		do {
		for(int i=0;i<4;i++) {
			
			while(finalComboSize!=combinedAndConvertedSize) {
				
				Random randomNumber=new Random();
				int randomIndexPOsition=  randomNumber.nextInt(4);
				String temporaryList = capitalAlphabets.get(randomIndexPOsition);
				while(!finalCombo.contains(temporaryList)) {
					finalCombo=finalCombo+temporaryList;
				}
				finalComboSize=finalCombo.length();
			}

		}    /* System.out.println("final combo is  " +finalCombo);  uncomment this to see that finalCombo for 
		a session is different for every password
		for(int u=1;u<=numberOfPasswords;u++) { use this code when you want to keep the finalcombo same
		                                       for a session of generations of passwords */
		
		Random random=new Random();
		int passwordLengthlimit=random.nextInt(18-8+1) +8;
		for(int i=0;i<=passwordLengthlimit;i++) {
			
			Random randomPasswordIndex=new Random();
			int passwordIndex= randomPasswordIndex.nextInt(finalCombo.length());
		  randomPassword= randomPassword + finalCombo.charAt(passwordIndex);
		}
		System.out.println("Your generated password is " +randomPassword);
		randomPassword=""; // here we are reinistializing to get a pure random password avaoiding appending operation
		Thread.sleep(1000);
		
		loopCount++;
		finalCombo="";
		finalComboSize=finalCombo.length(); //we also have to reinitialize the finalCombosize to zero to start it fresh...
		
		}while(loopCount<=numberOfPasswords);
		
		System.out.println("Enter 1 to run the program again or  ");
		System.out.println("0 to end it ");
		Scanner program = new Scanner(System.in);
		 response= program.nextInt();
		 loopCount=1;
			}while(response==1);
			       System.out.println("Program Closing ");
		System.out.print("....");
			Thread.sleep(1000);
		System.out.println("....");
		 Thread.sleep(1000);
		      System.out.print("b");
		    Thread.sleep(1000);
		         System.out.print("y");
		         Thread.sleep(1000);
		         System.out.print("e");
		         break;
        case (2):
        	String otp = "";
        System.out.println("Enter the number you want an OTP for ");
        sc = new Scanner(System.in);
        String number = sc.nextLine();
    	for (int i =1;i<5;i++)
    	{  
    		
              	String nums= "0123456789";
    		Random random = new Random();
    		int indexOtp = random.nextInt(nums.length());
    		
    		 otp =otp +nums.charAt(indexOtp);
    	}
    	System.out.println("Your OTP for the given number is  " +otp);
  
    	for(int tryCount=2;tryCount>=0;tryCount--)
    	{
    		System.out.println("ENTER UR OTP");
    		 sc = new Scanner(System.in);
    		String userOtp = sc.nextLine();
    		
    		
    		
    		if (tryCount<=0 && !userOtp.equals(otp)) 
    			{
    			 
    			System.out.println("Your OTP is wrong ");
    			System.out.println("Your crossed the number of attempts ");
    			System.out.println("Sorry your session is over "); 
    			Thread.sleep(2000);
    			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    		break;
    			}
    		if (userOtp.equals(otp))
    		{
    			System.out.println("Your entered OTP is correct ");
    		break;
    		}
    		else 
    		{
    			System.out.println("Entered OTP is wrong ");
    			System.out.println("**************************");

    			System.out.println("Try again " +tryCount  +" chances left " );
    			System.out.println("**************************");
    		}
//    	sc = new Scanner(System.in); // you need to once declare scanner but every use it needs to create an object again
//    	String userOtp = sc.nextLine();
     
        }
    	 break;
    	 
        default:
           	System.out.println("Entered option number doesn't exist ");
	}

}
}

