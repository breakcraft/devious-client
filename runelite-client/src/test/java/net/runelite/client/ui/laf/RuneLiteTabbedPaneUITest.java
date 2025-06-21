package net.runelite.client.ui.laf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import org.junit.Test;

public class RuneLiteTabbedPaneUITest
{
    @Test
    public void testWrapMixedWidthTabs()
    {
        JTabbedPane pane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
        pane.setUI(new RuneLiteTabbedPaneUI());
        pane.addTab("A", new JPanel());
        pane.addTab("LongTabName", new JPanel());
        pane.addTab("B", new JPanel());

        pane.setSize(new Dimension(100, 100));
        pane.addNotify();
        pane.doLayout();

        Rectangle first = pane.getBoundsAt(0);
        Rectangle second = pane.getBoundsAt(1);
        Rectangle third = pane.getBoundsAt(2);

        assertEquals(first.y, second.y);
        assertTrue(third.y > second.y);
    }
}
