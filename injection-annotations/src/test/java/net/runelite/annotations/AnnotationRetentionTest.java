package net.runelite.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Mixins;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.mapping.Construct;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.Import;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnnotationRetentionTest
{
    private static void assertRuntimeRetention(Class<?> clazz)
    {
        Retention r = clazz.getAnnotation(Retention.class);
        assertNotNull("Missing Retention on " + clazz.getSimpleName(), r);
        assertEquals(RetentionPolicy.RUNTIME, r.value());
    }

    private static void assertTargets(Class<?> clazz, ElementType... expected)
    {
        Target t = clazz.getAnnotation(Target.class);
        assertNotNull("Missing Target on " + clazz.getSimpleName(), t);
        assertArrayEquals("Wrong targets on " + clazz.getSimpleName(), expected, t.value());
    }

    @Test
    public void testMappingAnnotations()
    {
        assertRuntimeRetention(Construct.class);
        assertTargets(Construct.class, ElementType.METHOD);

        assertRuntimeRetention(Export.class);
        assertTargets(Export.class, ElementType.FIELD, ElementType.METHOD);

        assertRuntimeRetention(Implements.class);
        assertTargets(Implements.class, ElementType.TYPE);

        assertRuntimeRetention(Import.class);
        assertTargets(Import.class, ElementType.FIELD, ElementType.METHOD);

        assertRuntimeRetention(ObfuscatedGetter.class);
        assertTargets(ObfuscatedGetter.class, ElementType.FIELD);

        assertRuntimeRetention(ObfuscatedName.class);
        assertTargets(ObfuscatedName.class, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE);

        assertRuntimeRetention(ObfuscatedSignature.class);
        assertTargets(ObfuscatedSignature.class, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD);
    }

    @Test
    public void testMixinAnnotations()
    {
        assertRuntimeRetention(Copy.class);
        assertTargets(Copy.class, ElementType.METHOD);

        assertRuntimeRetention(FieldHook.class);
        assertTargets(FieldHook.class, ElementType.METHOD);

        assertRuntimeRetention(Inject.class);
        assertTargets(Inject.class, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR);

        assertRuntimeRetention(MethodHook.class);
        assertTargets(MethodHook.class, ElementType.METHOD);

        assertRuntimeRetention(Mixin.class);
        assertTargets(Mixin.class, ElementType.TYPE);

        assertRuntimeRetention(Mixins.class);
        assertTargets(Mixins.class, ElementType.TYPE);

        assertRuntimeRetention(Replace.class);
        assertTargets(Replace.class, ElementType.METHOD);

        assertRuntimeRetention(Shadow.class);
        assertTargets(Shadow.class, ElementType.FIELD);
    }
}
