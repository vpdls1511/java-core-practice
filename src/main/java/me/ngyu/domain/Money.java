package me.ngyu.domain;

import java.math.BigDecimal;

public record Money(BigDecimal amount,
                    String currency) {

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
