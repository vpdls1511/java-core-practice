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

    if (amount.compareTo(BigDecimal.ZERO) < 0) {
      throw new MoneyValidateException("amount는 음수일 수 없습니다.");
    }
  }

  public static Money of(long amount) {
    return Money.of(amount, "KRW");
  }

  public static Money of(long amount, String currency) {
    return new Money(BigDecimal.valueOf(amount), currency);
  }

  public static Money of(Double amount) {
    return Money.of(amount, "KRW");
  }

  public static Money of(Double amount, String currency) {
    return new Money(BigDecimal.valueOf(amount), currency);
  }

  public static Money of(BigDecimal amount) {
    return Money.of(amount, "KRW");
  }

  public static Money of(BigDecimal amount, String currency) {
    return new Money(amount, currency);
  }

  public String get() {
    return amount.toString() + " " + currency;
  }

}
