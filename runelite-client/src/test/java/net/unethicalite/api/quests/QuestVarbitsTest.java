package net.unethicalite.api.quests;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuestVarbitsTest
{
    @Test
    public void testWesternDiaryVarbits()
    {
        assertEquals(4471, QuestVarbits.ACHIEVEMENT_DIARY_WESTERN_EASY.getId());
        assertEquals(4472, QuestVarbits.ACHIEVEMENT_DIARY_WESTERN_MEDIUM.getId());
        assertEquals(4473, QuestVarbits.ACHIEVEMENT_DIARY_WESTERN_HARD.getId());
        assertEquals(4474, QuestVarbits.ACHIEVEMENT_DIARY_WESTERN_ELITE.getId());
    }
}
