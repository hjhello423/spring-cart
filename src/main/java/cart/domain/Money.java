package cart.domain;

import cart.exception.ServiceException;

import java.math.BigDecimal;

import static cart.exception.ErrorType.INVALID_MONEY;

public class Money {

    private static final int MINIMUM_VALUE = 0;

    private final BigDecimal value;

    private Money(BigDecimal value) {
        this.value = value;
    }

    public static Money of(long value) {
        if (value < MINIMUM_VALUE) {
            throw new ServiceException(INVALID_MONEY);
        }

        return new Money(BigDecimal.valueOf(value));
    }

    public BigDecimal getValue() {
        return value;
    }

    public long getLongValue() {
        return value.longValue();
    }

}
