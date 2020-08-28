package th.go.rd.bankaccount.controller;

import org.springframework.web.bind.annotation.*;
import th.go.rd.bankaccount.data.BankAccountRepository;
import th.go.rd.bankaccount.model.BankAccount;

import java.util.List;

@RestController
@RequestMapping("/api/bankaccount")
public class BankAccountRestController {

    private BankAccountRepository repository;

    public BankAccountRestController(BankAccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/customer/{id}")
    public List<BankAccount> getAllCustomerId(@PathVariable int id) {
        return repository.findByCustomerId(id);
    }

    @GetMapping
    public List<BankAccount> getAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public BankAccount getOne(@PathVariable int id){
        return repository.findById(id).get();
    }

    @PostMapping
    public BankAccount create(@RequestBody BankAccount bankAccount){ //@RequestBody ส่งเป็น JSON /==>รับ JSON มาจาก user
        repository.save(bankAccount); // method save จะส่งค่าไปเก็บ
        return repository.findById(bankAccount.getId()).get(); //คืนค่าเป็นobj หรือคืนค่า bankaccount ไปเลยก็ได้
    }


    @PutMapping("/{id}")
    public BankAccount update(@PathVariable int id,
                              @RequestBody BankAccount bankAccount) {
        BankAccount record = repository.findById(id).get(); //ดึงข้อมูลใน account ด้วย findById  มาเก็บใน record
        record.setBalance(bankAccount.getBalance());
        repository.save(record);//save ค่ากลับเข้าไป
        return record;
    }

    @DeleteMapping("/{id}")
    public BankAccount delete(@PathVariable int id) {
        BankAccount record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }

}
