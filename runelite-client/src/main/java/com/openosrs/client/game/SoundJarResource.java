package com.openosrs.client.game;

import lombok.EqualsAndHashCode;
import lombok.Value;
import net.runelite.client.RuneLite;

import java.net.URL;

@Value
@EqualsAndHashCode(callSuper = true)
public class SoundJarResource extends Sound
{
    String path;

    @Override
    public URL getPath()
    {
        return RuneLite.class.getResource(path);
    }
}
