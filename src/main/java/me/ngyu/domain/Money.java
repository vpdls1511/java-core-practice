package me.ngyu.domain;

import java.math.BigDecimal;

public record Money(BigDecimal amount,
                    String currency) {

  public static Money of(int amount, String currency) {
    return new Money(BigDecimal.valueOf(amount), currency);
  }

  public String get() {
    return amount.toString() + " " + currency;
  }

}
