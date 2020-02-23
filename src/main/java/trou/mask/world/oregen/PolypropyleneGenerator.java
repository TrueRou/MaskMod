package trou.mask.world.oregen;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import trou.mask.block.BlockRegistryHandler;

import java.util.Random;

public class PolypropyleneGenerator extends WorldGenerator {
    private final WorldGenerator polypropyleneGenerator = new WorldGenMinable(BlockRegistryHandler.POLYPROPYLENE_BLOCK.getDefaultState(), 4);

    @Override
    public boolean generate(World world, Random rand, BlockPos pos) {
        if (TerrainGen.generateOre(world, rand, this, pos, OreGenEvent.GenerateMinable.EventType.CUSTOM)) {
            for (int i = 0; i < 4; ++i) {
                int posX = pos.getX() + rand.nextInt(16);
                int posY = 10 + rand.nextInt(16);
                int posZ = pos.getZ() + rand.nextInt(16);
                BlockPos blockpos = new BlockPos(posX, posY, posZ);
                polypropyleneGenerator.generate(world, rand, blockpos);
            }
        }
        return true;
    }
}
