package net.runelite.client.plugins.cleanup;

import java.lang.annotation.Annotation;
import java.time.temporal.ChronoUnit;
import javax.inject.Inject;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ExternalPluginsChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.task.ScheduledMethod;
import net.runelite.client.task.Scheduler;

@PluginDescriptor(name = "CleanupTest")
public class CleanupPlugin extends Plugin
{
    @Inject
    private EventBus eventBus;

    @Inject
    private Scheduler scheduler;

    private final Object extraSubscriber = new Object()
    {
        @Subscribe
        public void onChanged(ExternalPluginsChanged e)
        {
        }
    };

    private final Runnable extraTask = () -> {};

    @Override
    protected void startUp()
    {
        eventBus.register(extraSubscriber);
        Schedule sched = new Schedule()
        {
            @Override
            public long period()
            {
                return 1;
            }

            @Override
            public ChronoUnit unit()
            {
                return ChronoUnit.SECONDS;
            }

            @Override
            public boolean asynchronous()
            {
                return false;
            }

            @Override
            public Class<? extends Annotation> annotationType()
            {
                return Schedule.class;
            }
        };
        scheduler.addScheduledMethod(new ScheduledMethod(sched, null, extraTask, extraTask));
    }
}
