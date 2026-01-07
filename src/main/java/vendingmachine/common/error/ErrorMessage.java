package vendingmachine.common.error;

public enum ErrorMessage {
    INVALID_INTEGER_FORMAT("정수 형식의 문자가 아닙니다."),
    INVALID_DECIMAL_FORMAT("소수 형식의 문자가 아닙니다."),
    INVALID_DATETIME_FORMAT("올바른 시간 형식의 문자 입력이 아닙니다."),
    INVALID_Y_N_FORMAT("Y 또는 N을 입력해주세요."),

    EMPTY_INPUT("입력이 비어있을 수 없습니다."),
    BLANK_STRING("문자열이 비어있거나 공백일 수 없습니다."),

    EXCEEDS_MAX_VALUE("최댓값 %s를 초과했습니다."),
    BELOW_MIN_VALUE("최솟값 %s 미만입니다."),
    EXCEEDS_MAX_LENGTH("최대 길이 %d를 초과하였습니다."),
    BELOW_MIN_LENGTH("최소 길이 %d 미만입니다."),

    NOT_EXISTS_COIN("존재하지 않는 동전 정보를 조회하였습니다"),
    NOT_EXISTS_PRODUCT("입력하신 상품를 찾을 수 없습니다"),
    INVALID_PRODUCT_PRICE_UNIT("상품 금액은 %d 단위여야 합니다."),
    INSUFFICIENT_STOCK("상품 재고가 충분하지 않습니다."),
    EMPTY_MACHINE_BALANCE("자판기 잔고 정보가 등록되어 있지 않습니다."),
    EMPTY_PRODUCT("구매 가능한 상품이 존재하지 않습니다."),

    INVALID_MENU_NUMBER("존재하지 않는 메뉴를 선택하셨습니다."),
    EMPTY_SPLITTED_VALUE("비어있는 항목이 존재합니다."),
    INVALID_PRODUCT_PURCHASE_FORMAT("올바른 상품 등록 형식이 아닙니다"),
    ;

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }

    public String formatted(final Object... args) {
        return message.formatted(args);
    }
}
