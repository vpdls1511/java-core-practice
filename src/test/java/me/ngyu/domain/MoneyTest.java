package me.ngyu.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

  @Test
  @DisplayName("Long으로 계산할 경우")
  void longTypeOperation() {
    long a = 10L;
    long b = 20L;

    long result = a + b;

    assertEquals(30L, result);
  }

  @Test
  @DisplayName("Double로 계산할 경우 정확히 떨어지지 않는다.")
  void doubleTypeOperation() {
    double a = 0.1;
    double b = 0.2;

    double result = a + b;

    System.out.println(result);
    assertNotEquals(0.3, result);
  }

  @Test
  @DisplayName("float는 0.1 + 0.2를 정확한 0.3 double 값으로 표현하지 못한다.")
  void floatTypeOperation() {
    float a = 0.1f;
    float b = 0.2f;

    float result = a + b;

    System.out.printf("%.20f%n", result);
    assertNotEquals(0.3, (double) result);
  }

  @Test
  @DisplayName("BigDecimal을 이용하면 소수점까지 잘 계산된다")
  void bigDecimalTypeOperation() {
    BigDecimal a = BigDecimal.valueOf(0.1);
    BigDecimal b = BigDecimal.valueOf(0.2);

    BigDecimal result = a.add(b);

    assertEquals(0, result.compareTo(BigDecimal.valueOf(0.3)));
  }

}
