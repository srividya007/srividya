package com.capgemini.pecuniafinance.dao;

import com.capgemini.pecuniafinance.bean.AccountDetails;

public interface IAccountManagementDao {
boolean updateCustomerDetails(AccountDetails ad);
boolean accountType(AccountDetails ad);
AccountDetails closeAccount(AccountDetails ad);


}