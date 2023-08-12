package cn.reasonable.minecraft.plugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Candle;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

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
    public void onTheEither(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location location = player.getLocation();
        World world = player.getWorld();
        if (world.getEnvironment() == World.Environment.NETHER) {
            Block block = location.getBlock();
            if (block.getType() == Material.CAULDRON) {
                //玩家在地狱里泡澡
            }
        }
    }

    @EventHandler
    public void onDirtBlockBreakByPlayerWithEnchantTool(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (item.containsEnchantment(Enchantment.SILK_TOUCH)) {
            Block block = event.getBlock();
            if (block.getType() == Material.DIRT) {
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
        if (damageEvent != null && damageEvent.getDamager().getType() == EntityType.MINECART_TNT) {
            Entity vehicle = player.getVehicle();
            if (vehicle instanceof Minecart) {
                // 玩家坐在矿车上被TNT矿车炸死
                // 在这里添加您想要执行的代码
            }
        }
    }

    @EventHandler
    public void onSpiderDamageByPlayer(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player player && event.getEntity() instanceof Spider spider) {
            if (spider.getLocation().getBlock().getType() == Material.COBWEB) {
                double finalDamage = event.getFinalDamage();
                if (spider.getHealth() - finalDamage <= 0) {
                    // 玩家杀死了一只在蜘蛛网中的蜘蛛
                    // 在这里添加您想要执行的代码
                }
            }
        }
    }

    @EventHandler
    public void onVillagerReplenishTrade(VillagerReplenishTradeEvent event) {
        // 获取事件中的村民实体
        Villager villager = (Villager) event.getEntity();
        // 检查村民的职业是否为牧羊人
        if (villager.getProfession() == Villager.Profession.SHEPHERD) {
            // 获取村民所处的位置
            Location loc = villager.getLocation();
            // 获取村民附近的所有实体
            List<Entity> nearbyEntities = villager.getNearbyEntities(10, 10, 10);
            // 遍历附近的实体
            for (Entity entity : nearbyEntities) {
                // 检查实体是否为铁傀儡
                if (entity instanceof IronGolem golem) {
                    // 检查铁傀儡是否有攻击目标
                    if (golem.getTarget() != null && golem.getTarget() instanceof Player) {
                        // 附近有有仇恨的铁傀儡
                        // 在这里添加您想要执行的代码
                    }
                }
            }
        }
    }

    @EventHandler
    public void onZombineDeathByPlayer(EntityDeathEvent event) {
        if (event.getEntity() instanceof Zombie zombie && event.getEntity().getKiller() instanceof Player) {
            Player player = zombie.getKiller();
            Biome biome = player.getLocation().getBlock().getBiome();
            if (biome == Biome.SUNFLOWER_PLAINS) {
                EntityEquipment equipment = zombie.getEquipment();
                if (equipment != null && equipment.getItemInMainHand().getType() == Material.IRON_DOOR && equipment.getHelmet().getType() == Material.IRON_HELMET) {
                    // 玩家在向日葵平原生物群系杀死了拿着铁门带铁头盔的僵尸
                    // 在这里添加您想要执行的代码
                }
            }
        }
    }

    @EventHandler
    public void onPlayerInteractWithFllowerPot(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && Objects.requireNonNull(event.getClickedBlock()).getType() == Material.FLOWER_POT) {
            Player player = event.getPlayer();
            ItemStack item = player.getInventory().getItemInMainHand();
            if (item.getType() == Material.WITHER_ROSE) {
                // 玩家将枯萎的灌木插入花盆
                // 在这里添加您想要执行的代码
            }
        }
    }

    @EventHandler
    public void onCraftItem(CraftItemEvent event) {
        if (event.getRecipe().getResult().getType() == Material.MELON) {
            // 玩家合成了西瓜
            // 在这里添加您想要执行的代码
        }
    }

    @EventHandler
    public void onPlayerFish(PlayerFishEvent event) {
        Player player = event.getPlayer();
        if (player.getWorld().getEnvironment() == World.Environment.NETHER) {
            if (event.getState() == PlayerFishEvent.State.CAUGHT_ENTITY) {
                Entity caught = event.getCaught();
                if (caught instanceof Item caughtItem) {
                    if (caughtItem.getItemStack().getType() == Material.COOKED_SALMON) {
                        // 玩家在地狱中用钓竿吊起熟鲑鱼
                        // 在这里添加您想要执行的代码
                    }
                }
            }
        }
    }

    @EventHandler
    public void onWhenPlayerDeathHasGlowing(PlayerDeathEvent event) {
        Player player = event.getEntity();
        if (player.hasPotionEffect(PotionEffectType.GLOWING)) {
            // 玩家死亡时拥有发光效果
            // 在这里添加您想要执行的代码
        }
    }

    @EventHandler
    public void onCreatureSpawnSnowMan(CreatureSpawnEvent event) {
        if (event.getEntity() instanceof Snowman && event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.BUILD_SNOWMAN) {
            Location loc = event.getLocation();
            if (loc.getBlock().getBiome() == Biome.DESERT) {
                // 玩家在沙漠中建造了一只雪傀儡
                // 在这里添加您想要执行的代码
            }
        }
    }

    @EventHandler
    public void onEntityDamageLIGHTNING(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player player && event.getCause() == EntityDamageEvent.DamageCause.LIGHTNING) {
            Location loc = player.getLocation();
            if (loc.getBlock().getType() == Material.LIGHTNING_ROD) {
                // 玩家在避雷针上被雷劈
                // 在这里添加您想要执行的代码
            }
        }
    }

    @EventHandler
    public void onEntityDeathByPlayerWhitCat(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        // 检查死亡的实体是否是猫
        if (entity instanceof Cat cat) {
            // 检查这只猫是否是女巫小屋的那只猫
            if (cat.getCustomName() != null && cat.getCustomName().equals("Witch's Cat")) {
                // 检查这只猫是否被玩家杀死
                if (event.getEntity().getKiller() instanceof Player) {
                    Player player = event.getEntity().getKiller();
                    // 在这里执行您想要的操作，例如发送消息给玩家
                    // 在这里添加您想要执行的代码
                }
            }
        }
    }

    @EventHandler
    public void onBlockBreakWithAir(BlockBreakEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();
        // 检查破坏的方块是否是刷怪笼
        if (block.getType() == Material.SPAWNER) {
            // 检查玩家是否是空手
            if (player.getInventory().getItemInMainHand().getType() == Material.AIR) {
                // 在这里执行您想要的操作，例如发送消息给玩家
                // 你的内容
            }
        }
    }

    @EventHandler
    public void onCraftItemCHISELEDNETHERBRICKS(CraftItemEvent event) {
        ItemStack item = event.getCurrentItem();
        // 检查合成的物品是否是錾制下界砖块
        if (item.getType() == Material.CHISELED_NETHER_BRICKS) {
            // 在这里执行您想要的操作，例如发送消息给玩家
            // 你的内容
        }
    }

    @EventHandler
    public void onPlayerInteractCOOKINGRABBIT(PlayerInteractEvent event) {
        Block block = event.getClickedBlock();
        Player player = event.getPlayer();
        // 检查玩家交互的方块是否是灵魂营火
        if (block != null && block.getType() == Material.SOUL_CAMPFIRE) {
            // 检查玩家手中是否拿着兔子肉
            if (player.getInventory().getItemInMainHand().getType() == Material.RABBIT) {
                // 在这里执行您想要的操作，例如发送消息给玩家
                // 你的内容
            }
        }
    }

    @EventHandler
    public void onEntityDamageBySlime(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        // 检查实体是否是玩家
        if (entity instanceof Player player) {
            // 检查玩家是否从高处落下
            if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
                // 检查玩家是否从50格高空落下
                if (player.getFallDistance() >= 50) {
                    // 检查玩家脚下的方块是否是史莱姆方块
                    Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
                    if (block.getType() == Material.SLIME_BLOCK) {
                        // 在这里执行您想要的操作，例如发送消息给玩家
                        // 你的内容
                    }
                }
            }
        }
    }
    @EventHandler
    public void onEntityDeathByPlayerWithFireWork(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        // 检查死亡的实体是否是幻翼
        if (entity instanceof Phantom) {
            // 检查这只幻翼是否被烟花弩杀死
            if (event.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent damageEvent) {
                if (damageEvent.getDamager() instanceof Firework firework) {
                    // 在这里执行您想要的操作，例如发送消息给玩家
                    // 你的内容
                }
            }
        }
    }
    @EventHandler
    public void onCakeBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();
        // 检查破坏的方块是否是蛋糕
        if (block.getType() == Material.CAKE) {
            // 检查蛋糕上面是否插着燃烧着的蜡烛
            Block aboveBlock = block.getRelative(BlockFace.UP);
            if (aboveBlock.getType() == Material.CANDLE && aboveBlock.getBlockData() instanceof Candle candle) {
                if (candle.isLit()) {
                    // 在这里执行您想要的操作，例如发送消息给玩家
                    // 你的内容
                }
            }
        }
    }
    private Map<UUID, Integer> jumpCounts = new HashMap<>();

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location from = event.getFrom();
        Location to = event.getTo();
        // 检查玩家是否在蜂蜜块上跳跃
        if (from.getY() < to.getY() && player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.HONEY_BLOCK) {
            // 记录玩家的跳跃次数
            int jumpCount = jumpCounts.getOrDefault(player.getUniqueId(), 0) + 1;
            jumpCounts.put(player.getUniqueId(), jumpCount);
            // 检查玩家是否已经跳跃了100次
            if (jumpCount >= 100) {
                // 在这里执行您想要的操作，例如发送消息给玩家
                // 你的内容
            }
        }
    }
    @EventHandler
    public void onPlayerInteractWithLODESTONE(PlayerInteractEvent event) {
        Block block = event.getClickedBlock();
        Player player = event.getPlayer();
        // 检查玩家是否与磁石方块交互
        if (block != null && block.getType() == Material.LODESTONE) {
            // 在这里执行您想要的操作，例如发送消息给玩家
            // 你的内容
        }
    }
    @EventHandler
    public void onPlayerDeathByRESPAWNANCHOR(PlayerDeathEvent event) {
        Player player = event.getEntity();
        // 检查玩家是否在主世界
        if (player.getWorld().getEnvironment() == World.Environment.NORMAL) {
            // 检查玩家是否被重生锚炸死
            if (player.getLastDamageCause() instanceof EntityDamageByBlockEvent damageEvent) {
                if (damageEvent.getDamager().getType() == Material.RESPAWN_ANCHOR) {
                    // 在这里执行您想要的操作，例如发送消息给玩家
                    // 你的内容
                }
            }
        }
    }
    @EventHandler
    public void onPlayer(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location location = player.getLocation();
        // 检查玩家脚下的方块是否都是竹子
        boolean allBamboo = true;
        for (int y = 0; y < 64; y++) {
            Block block = location.getBlock().getRelative(0, -y, 0);
            if (block.getType() != Material.BAMBOO) {
                allBamboo = false;
                break;
            }
        }
        if (allBamboo) {
            // 在这里执行您想要的操作，例如发送消息给玩家
            // 你的内容
        }
    }
    private Map<UUID, Integer> bellRingCounts = new HashMap<>();

    @EventHandler
    public void onPlayerInteractBELL(PlayerInteractEvent event) {
        Block block = event.getClickedBlock();
        Player player = event.getPlayer();
        // 检查玩家是否使用鸡蛋敲钟
        if (block != null && block.getType() == Material.BELL && player.getInventory().getItemInMainHand().getType() == Material.EGG) {
            // 记录玩家的敲钟次数
            int bellRingCount = bellRingCounts.getOrDefault(player.getUniqueId(), 0) + 1;
            bellRingCounts.put(player.getUniqueId(), bellRingCount);
            // 检查玩家是否已经敲钟了5次
            if (bellRingCount >= 5) {
                // 在这里执行您想要的操作，例如发送消息给玩家
                // 你的内容
                // 重置玩家的敲钟次数

            }
        }
    }

}