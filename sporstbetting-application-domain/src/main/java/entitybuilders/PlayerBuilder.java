package entitybuilders;



import entities.Currency;
import entities.Player;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PlayerBuilder extends BuilderBase<Player> {
    private String email;
    private String password;
    private String name;
    private Integer accountNumber;
    private BigDecimal balance;
    private LocalDate birth;
    private Currency currency;

    public PlayerBuilder setEmail(String email){
        this.email=email;
        return this;
    }

    public PlayerBuilder setPassword(String password){
        this.password=password;
        return this;
    }

    public PlayerBuilder setName(String name){
        this.name=name;
        return this;
    }

    public PlayerBuilder setAccountNumber(Integer accountNumber){
        this.accountNumber=accountNumber;
        return this;
    }
    public PlayerBuilder setBalance(BigDecimal balance){
        this.balance=balance;
        return this;
    }

    public PlayerBuilder setBirth(LocalDate birth){
        this.birth=birth;
        return this;
    }

    public PlayerBuilder setCurrency(Currency currency){
        this.currency=currency;
        return this;
    }
    @Override
    public Player build() {
        return new Player(email,password,name,accountNumber,balance,birth,currency);
    }
}
