package com.capgemini.pecuniafinance.service;
 import com.capgemini.pecuniafinance.bean.*;
 
 
 
public interface IAccountManagementService {
boolean updateCustomerDetails(AccountDetails ad);
boolean accountType(AccountDetails ad);
AccountDetails closeAccount(AccountDetails ad);

}