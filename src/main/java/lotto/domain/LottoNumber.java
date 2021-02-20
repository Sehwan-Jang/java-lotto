package lotto.domain;

import lotto.exception.IllegalLottoNumberException;

import java.util.Objects;
import java.util.regex.Pattern;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MAX_LOTTO_NUMBER = 45;
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    private static final int MIN_LOTTO_NUMBER = 1;

    private final int value;

    public LottoNumber(String input) {
        validateLottoNumber(input);
        this.value = Integer.parseInt(input);
    }

    private void validateLottoNumber(String input) {
        if (isInvalidNumberFormat(input) || isInvalidLottoNumberRange(input)) {
            throw new IllegalLottoNumberException();
        }
    }

    private boolean isInvalidNumberFormat(String input) {
        return !NUMBER_PATTERN.matcher(input).matches();
    }

    private boolean isInvalidLottoNumberRange(String input) {
        int value = Integer.parseInt(input);
        return value > MAX_LOTTO_NUMBER || value < MIN_LOTTO_NUMBER;
    }

    private int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public int compareTo(LottoNumber anotherLottoNumber) {
        return Integer.compare(this.getValue(), anotherLottoNumber.getValue());
    }
}
