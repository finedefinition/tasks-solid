package finedefinition.service;

import finedefinition.model.Account;
import finedefinition.service.commission.CommissionHandler;

public interface CommissionStrategy {
    CommissionHandler get(Account.Type type);
}
