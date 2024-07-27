package xyz.aikoyori.mineable_unmineable.mixins;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.EndPortalBlock;
import net.minecraft.block.EndPortalFrameBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EndPortalBlock.class)
public abstract class EndPortalMixin extends Block {
    public EndPortalMixin(Settings settings) {
        super(settings);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if((sourceBlock instanceof EndPortalFrameBlock || sourceBlock instanceof EndPortalBlock) && world.getBlockState(sourcePos).isAir()){
            if(pos.getY() == sourcePos.getY()){
                world.breakBlock(pos,false);
            }
        }
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
    }
}
