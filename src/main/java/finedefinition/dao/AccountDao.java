package finedefinition.dao;

import finedefinition.model.Account;

public interface AccountDao {
    public void add(Account account);

    Account get(String accountNumber);

    void update(Account account);

}
