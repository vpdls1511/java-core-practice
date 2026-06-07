package me.ngyu.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import me.ngyu.exception.MoneyValidateException;
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

  @Test
  @DisplayName("Money 객체를 생성할 수 있다.")
  void createMoneyObject() {
    Money money = Money.of(10, "KRW");

    assertAll(
            () -> assertEquals("10 KRW", money.get()),
            () -> assertEquals(BigDecimal.valueOf(10), money.amount()),
            () -> assertEquals("KRW", money.currency())
            );
  }

  @Test
  @DisplayName("연산자로 덧셈이 가능하다")
  void plusOperation() {
    Money a = Money.of(10);
    Money b = Money.of(20);

    Money result = a.add(b);

    assertEquals(BigDecimal.valueOf(30), result.amount());
  }

  @Test
  @DisplayName("연산자로 뺄셈이 가능하다")
  void minusOperation() {
    Money a = Money.of(10);
    Money b = Money.of(20);

    Money result = a.minus(b);

    assertEquals(BigDecimal.valueOf(-10), result.amount());
  }

  @Test
  @DisplayName("연산자로 곱셈이 가능하다")
  void multiplyOperation() {
    Money a = Money.of(10);
    Money b = Money.of(20);

    Money result = a.multiply(b);

    assertEquals(BigDecimal.valueOf(200), result.amount());
  }

  @Test
  @DisplayName("연산자로 나눗셈이 가능하다")
  void divideOperation() {
    Money a = Money.of(10);
    Money b = Money.of(20);

    Money result = a.divide(b);

    assertEquals(BigDecimal.valueOf(0.5), result.amount());
  }
}
