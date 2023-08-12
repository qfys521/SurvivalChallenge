package cn.reasonable.minecraft.plugin;

import org.bukkit.block.data.type.TNT;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.Location;
import java.util.HashMap;
import java.util.Objects;

import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.block.Block;
import org.bukkit.World;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.Listener;

public class PluginListener implements Listener {

    private final HashMap<String, Integer> leaveMap = new HashMap<>();

    @EventHandler
    public void onHoeBreak(PlayerItemBreakEvent event) {
        if (event.getBrokenItem().getType() == Material.WOODEN_HOE) {

        }
    }

    @EventHandler
    public void atComposter(PlayerMoveEvent event) {
        Location location = event.getPlayer().getLocation();
        if (location.getBlock().getType() == Material.COMPOSTER) {

        }
    }

    @EventHandler
    public void playerSetupOakLeaveBlock(BlockPlaceEvent event) {
        if (event.getBlock().getType() == Material.OAK_LEAVES) {
            this.leaveMap.put(event.getPlayer().getName(), leaveMap.getOrDefault(event.getPlayer().getName(), 0) + 1);
        }
        if (this.leaveMap.get(event.getPlayer().getName()) == 576) {

        }
    }

    @EventHandler
    public void onPlayerMusicBoxPlace(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        World world = player.getWorld();
        Location location = player.getLocation();
        int x = (int) location.getX();
        int y = (int) location.getY();
        int z = (int) location.getZ();
        boolean isSurroundedByJukeboxes = true;
        isSurroundedByJukeboxes = !(world.getBlockAt(x + 1, y, z).getType() != Material.JUKEBOX
                || world.getBlockAt(x - 1, y, z).getType() != Material.JUKEBOX
                || world.getBlockAt(x, y + 1, z).getType() != Material.JUKEBOX
                || world.getBlockAt(x, y - 1, z).getType() != Material.JUKEBOX
                || world.getBlockAt(x, y, z + 1).getType() != Material.JUKEBOX
                || world.getBlockAt(x, y, z - 1).getType() != Material.JUKEBOX
                || world.getBlockAt(x + 1, y + 1, z).getType() != Material.JUKEBOX
                || world.getBlockAt(x - 1, y + 1, z).getType() != Material.JUKEBOX
                || world.getBlockAt(x, y + 2, z).getType() != Material.JUKEBOX
                || world.getBlockAt(x, y, z + 1).getType() != Material.JUKEBOX
                || world.getBlockAt(x, y, z - 1).getType() != Material.JUKEBOX);

        if (isSurroundedByJukeboxes) {
            // 玩家在自己的上下左右前后铺满唱片机
            // 在这里处理玩家的行为
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player && event.getDamager() instanceof LlamaSpit spit) {
            if (spit.getShooter() instanceof Llama llama) {
                if (llama.getInventory().getDecor() != null) {
                    // 玩家被披着地毯的羊驼吐口水
                    // 在这里处理玩家受伤的行为
                }
            }
        }
    }

    @EventHandler
    public void onPlayerMushRoom(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack item = event.getItem();
        Block block = event.getClickedBlock();
        if (action == Action.RIGHT_CLICK_BLOCK && item != null && item.getType() == Material.BONE_MEAL) {
            if (block != null && (block.getType() == Material.BROWN_MUSHROOM || block.getType() == Material.RED_MUSHROOM)) {
                // 在这里执行相应的操作
            }
        }
    }
    @EventHandler
    public void onTheEither(PlayerMoveEvent event){
        Player player = event.getPlayer();
        Location location= player.getLocation();;
        World world = player.getWorld();
        if (world.getEnvironment() == World.Environment.NETHER){
            Block block = location.getBlock();
            if (block.getType() == Material.CAULDRON){
                //玩家在地狱里泡澡
            }
        }
    }
    @EventHandler
    public void  onDirtBlockBreakByPlayerWithEnchantTool(BlockBreakEvent event){
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if(item.containsEnchantment(Enchantment.SILK_TOUCH)){
            Block block = event.getBlock();
            if (block.getType() == Material.DIRT){
                //玩家使用精准采集附魔挖掘泥土
            }
        }
    }
    @EventHandler
    public void onPlayerDeathByArmorStand(PlayerDeathEvent event) {
        Player player = event.getEntity();
        EntityDamageByEntityEvent damageEvent = (EntityDamageByEntityEvent) player.getLastDamageCause();
        if (damageEvent != null && damageEvent.getDamager() instanceof ArmorStand) {
            // 玩家被盔甲架反杀
            // 在这里添加您想要执行的代码
        }
    }
    @EventHandler
    public void onPlayerInteractWoodenAxe(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && Objects.requireNonNull(event.getClickedBlock()).getType() == Material.ENCHANTING_TABLE) {
            Player player = event.getPlayer();
            ItemStack item = player.getInventory().getItemInMainHand();
            if (item.getType() == Material.WOODEN_AXE && item.containsEnchantment(Enchantment.DAMAGE_ALL)) {
                int level = item.getEnchantmentLevel(Enchantment.DAMAGE_ALL);
                // 玩家为木斧附魔锋利，附魔等级为 level
                // 在这里添加您想要执行的代码
            }
        }
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        EntityDamageByEntityEvent damageEvent = (EntityDamageByEntityEvent) player.getLastDamageCause();
        if (damageEvent != null && damageEvent.getDamager().getType()==EntityType.MINECART_TNT) {
            Entity vehicle = player.getVehicle();
            if (vehicle instanceof Minecart) {
                // 玩家坐在矿车上被TNT矿车炸死
                // 在这里添加您想要执行的代码
            }
        }
    }

}