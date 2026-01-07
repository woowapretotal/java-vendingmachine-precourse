package vendingmachine.domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.domain.balance.CoinChunk;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomCoinComposeStrategyTest {

    @DisplayName("랜덤 코인 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {450, 5000, 10, 50})
    void shouldComposeComplete(int value) throws Exception {
        // given
        CoinComposeStrategy coinComposeStrategy = new RandomCoinComposeStrategy();

        // when
        List<CoinChunk> coinChunks = coinComposeStrategy.composeCoinChunks(value);

        // then
        int sum = coinChunks.stream()
                .map(CoinChunk::getCoinChunkAmount)
                .mapToInt(Integer::intValue)
                .sum();
        assertThat(sum).isEqualTo(value);
    }

}
