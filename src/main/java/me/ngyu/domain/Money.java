package me.ngyu.domain;

import java.math.BigDecimal;
import me.ngyu.exception.MoneyValidateException;

public record Money(BigDecimal amount,
                    String currency) {

  public Money {
    if (amount == null) {
      throw new MoneyValidateException("amount는 null일 수 없습니다.");
    }

    if (currency == null || currency.isBlank()) {
      throw new MoneyValidateException("currency는 비어 있을 수 없습니다.");
    }
  }

  public static Money of(long amount) {
    return Money.of(amount, "KRW");
  }

  public static Money of(long amount, String currency) {
    return Money.of(BigDecimal.valueOf(amount), currency);
  }

  public static Money of(BigDecimal amount) {
    return Money.of(amount, "KRW");
  }

  public static Money of(BigDecimal amount, String currency) {
    return new Money(amount, currency);
  }

  public Money add(Money other) {
    validOperation(other);
    return Money.of(amount.add(other.amount), this.currency);
  }

  public Money minus(Money other) {
    validOperation(other);
    return Money.of(amount.subtract(other.amount), this.currency);
  }

  public Money multiply(Money other) {
    validOperation(other);
    return Money.of(amount.multiply(other.amount), this.currency);
  }

  public Money divide(Money other) {
    validOperation(other);
    return Money.of(amount.divide(other.amount), this.currency);
  }

  public String get() {
    return amount.toString() + " " + currency;
  }


  private void validOperation(Money other) {
    if (other == null) {
      throw new MoneyValidateException("연산 대상자는 null일 수 없습니다.");
    }

    if(!this.currency.equals(other.currency)) {
      throw new MoneyValidateException("통화가 다릅니다.");
    }
  }
}
