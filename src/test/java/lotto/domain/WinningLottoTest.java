package lotto.domain;

import lotto.exception.IllegalWinningLottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @Test
    @DisplayName("당첨번호와 보너스 번호가 중복되는 지 검증")
    void checkDuplicateBonusNumber() {
        LottoTicket winningTicket = new LottoTicket(Arrays.asList(
                LottoNumber.createLottoNumber("1"),
                LottoNumber.createLottoNumber("2"),
                LottoNumber.createLottoNumber("3"),
                LottoNumber.createLottoNumber("4"),
                LottoNumber.createLottoNumber("5"),
                LottoNumber.createLottoNumber("7")));
        LottoNumber bonusNumber = LottoNumber.createLottoNumber("3");
        assertThatThrownBy(() -> {
            WinningLotto winningLotto = new WinningLotto(winningTicket, bonusNumber);
        }).isInstanceOf(IllegalWinningLottoException.class)
        .hasMessage(bonusNumber + " : 티켓 내 숫자와 보너스 번호가 중복됩니다.");
    }
}