package microservices.book.gamification.game.badgeprocessors;

import microservices.book.gamification.game.domain.BadgeType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

public class SilverBadgeProcessorTest {

    private SilverBadgeProcessor badgeProcessor;

    @BeforeEach
    public void setUp() {
        badgeProcessor = new SilverBadgeProcessor();
    }

    @Test
    public void shouldGiveBadgeIfScoreOverThreshold() {
        Optional<BadgeType> badgeType = badgeProcessor
                .processForOptionalBadge(150, List.of(), null);
        assertThat(badgeType).contains(BadgeType.SILVER);
    }

    @Test
    public void shouldNotGiveBadgeIfScoreUnderThreshold() {
        Optional<BadgeType> badgeType = badgeProcessor
                .processForOptionalBadge(130, List.of(), null);
        assertThat(badgeType).isEmpty();
    }

}

/*private BronzeBadgeProcessor badgeProcessor;

    @BeforeEach
    public void setUp() {
        badgeProcessor = new BronzeBadgeProcessor();
    }

    @Test
    public void shouldGiveBadgeIfScoreOverThreshold() {
        Optional<BadgeType> badgeType = badgeProcessor
                .processForOptionalBadge(60, List.of(), null);
        assertThat(badgeType).contains(BadgeType.BRONZE);
    }

    @Test
    public void shouldNotGiveBadgeIfScoreUnderThreshold() {
        Optional<BadgeType> badgeType = badgeProcessor
                .processForOptionalBadge(40, List.of(), null);
        assertThat(badgeType).isEmpty();
    }*/