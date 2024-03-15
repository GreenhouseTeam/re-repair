package dev.greenhouseteam.rerepair.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.greenhouseteam.rerepair.config.jsonc.JsonCCodec;
import dev.greenhouseteam.rerepair.util.CodecUtil;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public record ReRepairConfig(boolean overDurabilityEnabled, @Nullable Vec3 overDurabilityColor) {
    public static final ReRepairConfig DEFAULT = new ReRepairConfig(true, new Vec3(0.0, 0.0, 1.0));

    @Override
    public Vec3 overDurabilityColor() {
        if (this.overDurabilityColor == null) {
            throw new UnsupportedOperationException("Attempted to Over Durability Color config value in an unsupported environment.");
        }
        return this.overDurabilityColor;
    }

    private ReRepairConfig getThis() {
        return this;
    }

    public static final Codec<ReRepairConfig> COMMON_CODEC = RecordCodecBuilder.create(inst -> inst.group(
            CodecUtil.defaultedField(JsonCCodec.codec(List.of("Determines whether or not over-durability is enabled.", "You are able to get over-durability on an item by repairing through an anvil."), Codec.BOOL), "overdurability_enabled", ReRepairConfig.DEFAULT.overDurabilityEnabled()).forGetter(ReRepairConfig::overDurabilityEnabled)
    ).apply(inst, t1 -> new ReRepairConfig(t1, null)));

    public static final Codec<ReRepairConfig> CLIENT_CODEC = RecordCodecBuilder.create(inst -> inst.group(
            ((MapCodec.MapCodecCodec<ReRepairConfig>)COMMON_CODEC).codec().forGetter(ReRepairConfig::getThis),
            CodecUtil.defaultedField(JsonCCodec.codec(List.of("Determines the color of the over-durability meter."), Vec3.CODEC), "overdurability_color", ReRepairConfig.DEFAULT.overDurabilityColor()).forGetter(ReRepairConfig::overDurabilityColor)
    ).apply(inst, (t1, t2) -> new ReRepairConfig(t1.overDurabilityEnabled(), t2)));
}
