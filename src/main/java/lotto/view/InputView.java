package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final String DELIMITER = ",";
    public static final String BLANK = " ";
    public static final String REPLACEMENT = "";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String inputMoney() {
        OutputView.printInputMoneyMessage();
        return SCANNER.nextLine();
    }

    public static List<String> inputWinningNumbers() {
        OutputView.printInputWinningNumbers();
        return inputLottoNumbers();
    }

    public static List<String> inputLottoNumbers() {
        return Arrays.asList(SCANNER.nextLine()
                .replace(BLANK, REPLACEMENT)
                .split(DELIMITER));
    }

    public static String inputBonusNumber() {
        OutputView.printInputBonusNumberMessage();
        return SCANNER.nextLine();
    }

    public static String inputManualLottoAmount() {
        //TODO : 안내메세지 출력.
        return SCANNER.nextLine();
    }
}
