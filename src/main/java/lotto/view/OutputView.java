package lotto.view;

import lotto.domain.*;

public class OutputView {

    public static final String DIVIDER = "---------";

    private OutputView() {
    }

    public static void printInputMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printInputManualLottoAmountMessage() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public static void printInputManualLottoNumbersMessage() {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
    }

    public static void printLottoTicketsCount(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.getLottoTickets().size() + "개를 구매했습니다.");
    }

    public static void printInputWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printInputBonusNumberMessage() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            System.out.println(lottoTicket.getLottoTicket());
        }
    }

    public static void printResultStatistic(LottoResult lottoResult) {
        System.out.println("\n당첨 통계");
        System.out.println(DIVIDER);
        for (Prize prize : Prize.values()) {
            resultStatistic(prize, lottoResult.getCountByPrizeType(prize));
        }
    }

    private static void resultStatistic(Prize prize, int count) {
        if (prize == Prize.NO_PRIZE) {
            return;
        }
        if (prize == Prize.SECOND_PRIZE) {
            System.out.println(prize.getMatchCount() + "개 일치," + " 보너스 볼 일치(" + prize.getPrizeMoney().getValue() + "원)- " + count + "개");
            return;
        }
        System.out.println(prize.getMatchCount() + "개 일치(" + prize.getPrizeMoney().getValue() + "원)- " + count + "개");
    }

    public static void printProfitRate(LottoResult lottoResult, Money money) {
        System.out.println("총 수익률은 " + lottoResult.calculateProfitRate(money) + "입니다.");
    }
}