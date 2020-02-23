package trou.mask.event;

import net.minecraft.block.BlockFire;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemGlassBottle;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import trou.mask.block.BlockPolypropylene;
import trou.mask.enchantment.EnchantmentRegistryHandler;
import trou.mask.item.ItemRegistryHandler;
import trou.mask.item.mask.ArmorMask;

import java.util.List;

@Mod.EventBusSubscriber(modid = "mask")
public class EventHandler {
    @SubscribeEvent
    public static void onPlayerUpdate(LivingUpdateEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            ItemStack itemStack = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
            if (player.isCreative()) return;
            if (itemStack.getItem() instanceof ArmorMask && player.isInsideOfMaterial(Material.WATER) && EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistryHandler.SELF_CYCLE, itemStack) == 3) {
                player.capabilities.allowFlying = true;
            }
            if (!(itemStack.getItem() instanceof ArmorMask)) {
                player.capabilities.allowFlying = false;
                player.capabilities.isFlying = false;
                return;
            }
            if (!player.isInsideOfMaterial(Material.WATER)) {
                player.capabilities.allowFlying = false;
                player.capabilities.isFlying = false;
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.side.isClient()) return;
        World world = event.player.getEntityWorld();
        List<Entity> entities = world.getEntities(EntityBat.class, input -> {
            if (input == null) return false;
            BlockPos batLocation = input.getPosition();
            return event.player.getPosition().getDistance(batLocation.getX(), batLocation.getY(), batLocation.getZ()) <= 5;
        });
        ItemStack itemStack = event.player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
        if (itemStack.getItem() instanceof ArmorMask) {
            if (((ArmorMask) itemStack.getItem()).canProtectPoison()) {
                return;
            }
        }
        if (entities.size() > 0) {
            event.player.addPotionEffect(new PotionEffect(Potion.getPotionById(19), 200, 0));
            event.player.addPotionEffect(new PotionEffect(Potion.getPotionById(18), 200, 0));
            event.player.addPotionEffect(new PotionEffect(Potion.getPotionById(17), 200, 1));
        }
    }

    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getSide().isClient()) return;
        if (event.getHand().equals(EnumHand.OFF_HAND)) return;
        EntityPlayer player = event.getEntityPlayer();
        World world = event.getWorld();
        BlockPos pos = event.getPos();
        if (player.getHeldItemMainhand().getItem() instanceof ItemGlassBottle && world.getBlockState(event.getPos()).getBlock() instanceof BlockPolypropylene) {
            if (world.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() instanceof BlockFire) {
                world.destroyBlock(pos, false);
                player.getHeldItemMainhand().shrink(1);
                player.inventory.addItemStackToInventory(new ItemStack(ItemRegistryHandler.POLYPROPYLENE_BOTTLE));
            }
        }
    }
}
