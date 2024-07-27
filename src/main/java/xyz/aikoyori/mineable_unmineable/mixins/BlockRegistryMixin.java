package xyz.aikoyori.mineable_unmineable.mixins;

import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(Blocks.class)
public class BlockRegistryMixin {
    @ModifyArg(method = "<clinit>",at = @At(value = "INVOKE", target = "Lnet/minecraft/block/EndPortalFrameBlock;<init>(Lnet/minecraft/block/AbstractBlock$Settings;)V"),index = 0)
    private static AbstractBlock.Settings breakableUnbrekable$breakableEndPortalFrame(AbstractBlock.Settings settings) {
        return AbstractBlock.Settings.create()
                        .mapColor(MapColor.GREEN)
                        .instrument(Instrument.BASEDRUM)
                        .sounds(BlockSoundGroup.GLASS)
                        .luminance(state -> 1)
                        .strength(300f, 3600000.0F)
                        .requiresTool()
                        .pistonBehavior(PistonBehavior.BLOCK);
    }    @ModifyArg(method = "<clinit>",at = @At(value = "INVOKE", target = "Lnet/minecraft/block/EndPortalBlock;<init>(Lnet/minecraft/block/AbstractBlock$Settings;)V"),index = 0)
    private static AbstractBlock.Settings breakableUnbrekable$breakableEndPortal(AbstractBlock.Settings settings) {
        return AbstractBlock.Settings.create()
                        .mapColor(MapColor.BLACK)
                        .noCollision()
                        .luminance(state -> 15)
                        .strength(50f, 3600000.0F)
                        .dropsNothing()
                        .pistonBehavior(PistonBehavior.BLOCK);
    }
}
