package th.go.rd.bankaccount.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.go.rd.bankaccount.model.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,Integer> {

}
