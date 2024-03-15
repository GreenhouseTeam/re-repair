package dev.greenhouseteam.rerepair.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;

import java.util.Objects;
import java.util.Optional;

public class CodecUtil {
    public static <A> MapCodec<A> defaultedField(final Codec<A> codec, final String name, final A defaultValue) {
        return Codec.optionalField(name, codec).xmap(
                o -> o.orElse(defaultValue),
                Optional::of
        );
    }
    
}
