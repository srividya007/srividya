package com.capgemini.pecuniafinance.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.capgemini.pecuniafinance.bean.AccountDetails;
import com.capgemini.pecuniafinance.service.AccountManagementServiceImp;

public class AccountManagementDaoImp implements IAccountManagementDao{
      boolean flag=false;
	 static Map<Long,AccountDetails> map=new HashMap<Long,AccountDetails>();
       {
       map.put(944094835100l,new AccountDetails("pritam",7893078017l,944094835100l,"Savings","3-77/2a","srinagar","hyderabad","Telangana","India",502516,9005.00));
       map.put(944094835101l,new AccountDetails("shanthi",9989748457l,944094835101l,"Savings","3-73/2a","karimnagar","hyderabad","Telangana","India",502512,5045.00));
       map.put(944094835102l,new AccountDetails("srividya",9177878965l,944094835102l,"current","3-72/2a","gandhi nagar","hyderabad","Telangana","India",502519,7026.00));
       map.put(944094835103l,new AccountDetails("nikshitha",7985858202l,944094835103l,"Savings","3-71/2a","dn colony","hyderabad","Telangana","India",502513,6005.00));
       map.put(944094835104l,new AccountDetails("ChVenu",8913078945l,944094835104l,"current","3-75/2a","vishnupur","hyderabad","Telangana","India",502515,15005.00));
       map.put(789307801700l,new AccountDetails("abc",8913078945l,789307801700l,"current","3-75/2a","vishnupur","hyderabad","Telangana","India",502515,15005.00));

       }
       public boolean checkAccNumber(long accNumber) {
    	   boolean flag=true;
    	   if(!map.containsKey(accNumber)) {
    		   flag=false;
    	   }
    	   return flag;
       }
       
       AccountDetails account1=null;
       //AccountDetails account2=null;
	public boolean updateCustomerDetails(AccountDetails accountDetails) {
		//System.out.println(accountDetails.getCustomername());
		boolean flag1=false;
		for (long i : map.keySet()) {
			long accNumber=i;
			if(accNumber==accountDetails.getAccNumber()) {
				account1= map.get(accNumber);
				flag1=true;
			}
		}
		if(flag1==false) {
			try {
			throw new Exception();
			}catch(Exception e) {
				
			}
		}
		switch(accountDetails.getChoice()) {
		case 1:
				if(accountDetails.getCustomerName()!=null) {
					account1.setCustomerName(accountDetails.getCustomerName());
					flag=true;
				}
		        break;
		case 2:
		     if(accountDetails.getCustomerPhno()!=0l) {
			   account1.setCustomerPhno(accountDetails.getCustomerPhno());
			   flag=true;
		    }
		    break;
		case 3:
			 if(accountDetails.getCustomerAddress1()!=null && accountDetails.getCustomerAddress2()!=null && 
			                 accountDetails.getCity()!=null && accountDetails.getState()!=null && accountDetails.getCountry()!=null && accountDetails.getPincode()!=0 ) {
				account1.setCustomerAddress1(accountDetails.getCustomerAddress1());
				account1.setCustomerAddress2(accountDetails.getCustomerAddress2());
				account1.setCity(accountDetails.getCity());
				account1.setState(accountDetails.getState());
				account1.setCountry(accountDetails.getCountry());
				account1.setPincode(accountDetails.getPincode());
				flag=true;
			}
			}
		return flag;
	}

	public boolean accountType(AccountDetails accountdetails) {
		for (long i : map.keySet()) {
			long accNo=i;
			if(accNo==accountdetails.getAccNumber()) {
				account1= map.get(accNo);
			}
		}
		if(accountdetails.getAccType().equals("Savings") || accountdetails.getAccType().equals("Current")) {
			//System.out.println(accountdetails2.getAccounttype());
			account1.setAccType(accountdetails.getAccType());
			flag=true;
			}
		return flag;
	}

	public AccountDetails closeAccount(AccountDetails accountdetails) {
		
		long accNo=accountdetails.getAccNumber();
		if(map.containsKey(accNo))
		{
			   double amount=map.get(accNo).getBalance();
			   //System.out.println(amount);
			   accountdetails.setCustomerName(map.get(accNo).getCustomerName());
			   accountdetails.setAccType(map.get(accNo).getAccType());
			   accountdetails.setBalance(amount);
			   accountdetails.setAccStatus("Closed");
		}
		AccountDetails accountdetails2=accountdetails;
		map.remove(accountdetails.getAccNumber());
		return accountdetails2;
	}

	public static Map<Long, AccountDetails> getMap() {
		return map;
	}

	public static void setMap(Map<Long, AccountDetails> map) {
		AccountManagementDaoImp.map = map;
	}

}