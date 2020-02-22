package com.capgemini.pecuniafinance.ui;


import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.pecuniafinance.bean.AccountDetails;
import com.capgemini.pecuniafinance.service.AccountManagementServiceImp;

public class AccountManagement {

public static void main(String[] args) { 
Scanner scanner = new Scanner(System.in); 
AccountDetails account = new AccountDetails();
AccountManagementServiceImp serviceobj = new AccountManagementServiceImp();
try {
while (true) {
System.out.println("WELCOME TO PECUNIA FINANCE...");
System.out.println("Please enter Customer Account Number");
long accNumber = scanner.nextLong();
account.setAccNumber(accNumber);
boolean flags=serviceobj.checkAccNumber(accNumber);
boolean flag1 = serviceobj.validAccountNumber(account);
if (flag1 == true && flags==true) {
System.out.println("****************MENU*****************");
System.out.println("1.Update Customer Account Details");
System.out.println("2.Change Customer Account Status");
System.out.println("3.Close Customer Account");
System.out.println("4.Exit");
System.out.println("Enter your choice:");
int choice = scanner.nextInt();
switch (choice) {
case 1:
while (true) {
System.out.println("1.Update Name");
System.out.println("2.Update Mobile Number");
System.out.println("3.Update Address");
System.out.println("4.Exit");
int choice1 = scanner.nextInt();
account.setChoice(choice1);
switch (choice1) {
case 1:
System.out.println("Please enter customer name");
String name = scanner.next();
boolean flag = serviceobj.validName(name);
if (flag == true) {
account.setCustomerName(name);
// System.out.println(account.getCustomername());
boolean flag4 = serviceobj.updateCustomerDetails(account);
if (flag4 == true) {
System.out.println("Customer name updated successfully...");
} else {
System.err.println("Please enter valid name....");
}
} else {
System.err.println("Please enter valid name....");
}

break;

case 2:
System.out.println("Please enter customer mobile number");
long phno = scanner.nextLong();
boolean flag2 = serviceobj.validMobileNumber(phno);
if (flag2 == true) {
account.setCustomerPhno(phno);
boolean flag5 = serviceobj.updateCustomerDetails(account);
if (flag5 == true) {
System.out.println("Customer mobile number updated successfully...");
} else {
System.err.println("Please enter valid phone number....");
}
} else {
System.err.println("Please enter valid phone number....");
}

break;
case 3:
System.out.println("Please enter customer address1");
String address1 = scanner.next();
serviceobj.validAddressLine1(address1);
System.out.println("Please enter customer address2");
String address2 = scanner.next();
serviceobj.validAddressLine2(address2);
System.out.println("Please enter customer city");
String city = scanner.next();
serviceobj.validAddressCity(city);
System.out.println("Please enter customer state");
String state = scanner.next();
serviceobj.validAddressState(state);
System.out.println("Please enter customer country");
String country = scanner.next();
serviceobj.validAddressCountry(country);
System.out.println("Please enter customer pincode");
int pincode = scanner.nextInt();
serviceobj.validAddressPincode(pincode);
boolean flag3 = serviceobj.validAddress(address1, address2, city, state, country, pincode);
if (flag3 == true) {
account.setCustomerAddress1(address1);
account.setCustomerAddress2(address2);
account.setCity(city);
account.setState(state);
account.setCountry(country);
account.setPincode(pincode);
boolean flag6 = serviceobj.updateCustomerDetails(account);
if (flag6 = true) {
System.out.println("Customer address updated successfully...");
} else {
System.err.println("Please enter valid address.....");
}
} else {
System.err.println("Please enter valid address.....");
}

break;
case 4:
System.exit(0);
break;
default:
System.err.println("Please enter valid input");
break;
}
}

case 2:
System.out.println("Please enter account type Savings or Current");
String accounttype = scanner.next();
account.setAccType(accounttype);
boolean flag = serviceobj.accountType(account);
if (flag == true) {

System.out.println("Account type changed successfully....");
} else {
System.err.println("Please enter valid type....");
}
break;
case 3:
AccountDetails accDetails = serviceobj.closeAccount(account);
System.out.println(accDetails);
System.out.println("Do you want close your account (yes/no):");
String response=scanner.next();
if (response.equals("yes")) {
System.out.println(accDetails.getAccStatus());
System.out.println("Account has been closed");

} else {
System.err.println("Account number does not exist");
}
break;
case 4:
System.exit(0);

default:
System.err.println("Please enter valid Input...");
break;
}
} else {
System.err.println("Invalid Account Number or Account Number not exist......");
}
}
}
catch(InputMismatchException e) {
System.err.println("Please enter valid Input");
}

}
}
