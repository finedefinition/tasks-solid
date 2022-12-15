package finedefinition.dao;

import finedefinition.db.Storage;
import finedefinition.model.Account;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void add(Account account) {
        Storage.accounts.add(account);
    }

    @Override
    public Account get(String accountNumber) {
        return Storage.accounts
                .stream()
                .filter(account -> account.getNumber().equals(accountNumber)).findFirst().get();
    }

    @Override
    public void update(Account account) {
        // 1. find
        Account accountFromDb = get(account.getNumber());
        // 2. remove
        Storage.accounts.remove(accountFromDb);
        // 3. add
        add(account);
    }
}
