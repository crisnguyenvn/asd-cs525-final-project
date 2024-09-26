package domain.banking.rules;

import domain.framework.entity.Account;
import domain.framework.entity.AccountEntry;
import domain.framework.entity.TransactionType;
import domain.framework.rules.BankTransactionRule;
import domain.framework.notification.subject.Subject1;

public class CompanyWithdrawRule implements BankTransactionRule<Account, AccountEntry> {
    private final Subject1 subject;

    public CompanyWithdrawRule(Subject1 subject) {
        this.subject = subject;
    }

    @Override
    public boolean matches(Account account, Double amount, String description, TransactionType transactionType) {
        return account.getCustomer().getCustomerType().equals("Company");
    }

    @Override
    public void apply(Account account, Double amount, String description, TransactionType transactionType) {
        this.subject.notifyObservers(transactionType, account);
    }
}
