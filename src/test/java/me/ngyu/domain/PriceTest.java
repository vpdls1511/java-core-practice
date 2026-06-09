package me.ngyu.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import me.ngyu.exception.MoneyValidateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PriceTest {

  @Test
  @DisplayName("Price는 Null이어서는 안된다")
  void priceIsNotNull() {
    assertThrows(MoneyValidateException.class, () -> Price.of(null));
  }

  @Test
  @DisplayName("Price는 음수여서는 안된다 - fail")
  void priceIsNegative() {
    assertThrows(MoneyValidateException.class, () -> Price.of(Money.of(-1000)));
  }

  @Test
  @DisplayName("Price는 음수여서는 안된다 - success")
  void priceIsNotNegative() {
    Price price = Price.of(Money.of(1000));

    assertTrue(price.money().amount().compareTo(BigDecimal.ZERO) > 0);
  }

  @Test
  @DisplayName("Price는 음수여서는 안된다 - isNegative 메서드 검증")
  void priceIsNotNegativeMethod() {
    Price price = Price.of(Money.of(1000));

    assertFalse(price.isNegative());
  }


}
