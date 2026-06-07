package me.ngyu.domain;

public enum Currency {
  KRW(0),
  USD(2),
  ;

  private final int digit;

  Currency(int i) {
    this.digit = i;
  }

  public int getDigit() {
    return digit;
  }
}
