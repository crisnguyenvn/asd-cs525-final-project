package domain.framework.factory;

import domain.framework.entity.Account;
import domain.framework.entity.Customer;

public interface AccountFactory {
    Account createAccount(String accountNumber, Customer customer);
}
