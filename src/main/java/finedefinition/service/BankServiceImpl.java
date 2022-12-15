package finedefinition.service;

import finedefinition.dao.AccountDao;
import finedefinition.model.Account;
import java.math.BigDecimal;

public class BankServiceImpl implements BankService {

    private AccountDao accountDao;
    private CommissionStrategy commissionStrategy;

    public BankServiceImpl(AccountDao accountDao, CommissionStrategy commissionStrategy) {
        this.accountDao = accountDao;
        this.commissionStrategy = commissionStrategy;
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, BigDecimal amount) {
        // 1. Get accounts from storage
        Account fromAccount = accountDao.get(fromAccountNumber);
        Account toAccount = accountDao.get(toAccountNumber);
        // TODO: Calculate commission based on account type
        BigDecimal commission = commissionStrategy.get(fromAccount.getType()).getCommission(amount);

        BigDecimal newValueFrom = fromAccount.getAmount().subtract(amount);
        fromAccount.setAmount(newValueFrom);

        BigDecimal newValueTo = toAccount.getAmount().add(amount);
        fromAccount.setAmount(newValueTo);

        accountDao.update(fromAccount);
        accountDao.update(toAccount);

    }
}
