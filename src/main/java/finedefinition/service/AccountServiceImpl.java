package finedefinition.service;

import finedefinition.dao.AccountDao;
import finedefinition.dao.AccountDaoImpl;
import finedefinition.model.Account;
import java.math.BigDecimal;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao = new AccountDaoImpl();

    @Override
    public void createNewAccount(String accountNumber) {
        Account account = new Account();
        account.setAmount(BigDecimal.valueOf(1000));
        account.setType(Account.Type.GOLD);
        account.setNumber(accountNumber);

        account.setNumber(accountNumber);
        accountDao.add(account);

    }
}
