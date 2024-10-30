import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TennisScoreSheetTest {

    private TennisScoreSheet scoreSheet;

    @BeforeEach
    void setUp() {
        scoreSheet = new TennisScoreSheet("Player 1", "Player 2");
    }

    @Test
    void testInitialScore() {
        assertEquals("Player 1: Love - Player 2: Love", scoreSheet.getScore());
    }

    @Test
    void testPlayer1ScoresFirstPoint() {
        scoreSheet.scorePoint("Player 1");
        assertEquals("Player 1: 15 - Player 2: Love", scoreSheet.getScore());
    }

    @Test
    void testPlayer2ScoresFirstPoint() {
        scoreSheet.scorePoint("Player 2");
        assertEquals("Player 1: Love - Player 2: 15", scoreSheet.getScore());
    }

    @Test
    void testMultiplePointsScored() {
        scoreSheet.scorePoint("Player 1");
        scoreSheet.scorePoint("Player 1");
        scoreSheet.scorePoint("Player 2");
        assertEquals("Player 1: 30 - Player 2: 15", scoreSheet.getScore());
    }

    @Test
    void testGameNotOver() {
        scoreSheet.scorePoint("Player 1");
        scoreSheet.scorePoint("Player 1");
        assertFalse(scoreSheet.isGameOver());
    }

    @Test
    void testGameOverPlayer1Wins() {
        scoreSheet.scorePoint("Player 1");
        scoreSheet.scorePoint("Player 1");
        scoreSheet.scorePoint("Player 1");
        scoreSheet.scorePoint("Player 1"); // Player 1 wins

        assertTrue(scoreSheet.isGameOver());
        assertEquals("Player 1", scoreSheet.getWinner());
    }

    @Test
    void testGameOverPlayer2Wins() {
        scoreSheet.scorePoint("Player 2");
        scoreSheet.scorePoint("Player 2");
        scoreSheet.scorePoint("Player 2");
        scoreSheet.scorePoint("Player 2"); // Player 2 wins

        assertTrue(scoreSheet.isGameOver());
        assertEquals("Player 2", scoreSheet.getWinner());
    }

    @Test
    void testAdvantageScore() {
        scoreSheet.scorePoint("Player 1");
        scoreSheet.scorePoint("Player 1");
        scoreSheet.scorePoint("Player 1");
        scoreSheet.scorePoint("Player 2");
        scoreSheet.scorePoint("Player 2");
        scoreSheet.scorePoint("Player 2");
        scoreSheet.scorePoint("Player 1");

        assertEquals("Player 1: Advantage - Player 2: 40", scoreSheet.getScore());
    }

    @Test
    void testInvalidPlayerName() {
        scoreSheet.scorePoint("Invalid Player");
        assertEquals("Player 1: Love - Player 2: Love", scoreSheet.getScore());
    }
}
