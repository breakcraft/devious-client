package com.openosrs.client.game;

import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;
import lombok.Value;

import java.io.File;
import java.net.URL;

@Value
@EqualsAndHashCode(callSuper = true)
public class SoundFileResource extends Sound
{
    File file;

    @Override
    @SneakyThrows
    public URL getPath()
    {
        return file.toURI().toURL();
    }
}
