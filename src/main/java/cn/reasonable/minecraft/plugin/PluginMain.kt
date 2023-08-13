package cn.reasonable.minecraft.plugin

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class PluginMain : JavaPlugin() {
    override fun onLoad() {
        server.pluginManager.registerEvents(PluginListener(), this)
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (command.name.equals("listAllChallenge") and (sender is Player)){
            if (args.size>1){
                sender.sendMessage("仅仅接受一个参数呢!")
            }else if (args[0].toInt() !in 1..5){
                sender.sendMessage("目前只有1~5级挑战呢!")
            } else if(args[0].toInt() == 1){
                sender.sendMessage("1级挑战有：\n* [1]用坏一把木镐\n" +
                        "* [1]站在堆满的堆肥桶里\n" +
                        "* [1]给村民穿上全套皮革装备\n" +
                        "* [1]放置576个橡树树叶\n" +
                        "* [1]穿着一身拥有铁质纹饰的铁装备\n" +
                        "* [1]在自己的上下左右前后铺满唱片机\n" +
                        "* [1]被披着地毯的羊驼吐口水\n" +
                        "* [1]站在蘑菇上催熟这颗蘑菇\n" +
                        "* [1]用灵魂营火烤兔子肉\n" +
                        "* [1]在地狱的炼药锅中泡澡\n" +
                        "* [1]被坠落的石笋戳死")
            }else if(args[0].toInt() == 2){
                sender.sendMessage("2级挑战有:\n* [2]使用带精准采集附魔的工具挖掘泥土\n" +
                        "* [2]在试图击杀盔甲架时被反杀\n" +
                        "* [2]为木斧附魔锋利\n" +
                        "* [2]坐在矿车上被TNT矿车炸死\n" +
                        "* [2]杀死一只处在蜘蛛网中的蜘蛛\n" +
                        "* [2]在惹恼铁傀儡时与牧羊人交易\n" +
                        "* [2]用望远镜观察幼年海龟\n" +
                        "* [2]在向日葵平原击杀拿着铁门戴铁头盔的僵尸\n" +
                        "* [2]将枯萎的灌木插进花盆\n" +
                        "* [2]合成一个西瓜\n" +
                        "* [2]在地狱用钓竿钓上熟鲑鱼\n" +
                        "* [2]在死亡时拥有发光效果\n" +
                        "* [2]在沙漠搭建一只雪傀儡\n" +
                        "* [2]站在避雷针上被雷劈\n" +
                        "* [2]杀死女巫小屋那只猫\n" +
                        "* [2]空手破坏刷怪笼\n" +
                        "* [2]合成一组錾制下界砖块")
            }else if(args[0].toInt() == 3){
                sender.sendMessage("3级挑战有:\n* [3]从50格高空落到史莱姆块上\n" +
                        "* [3]使用烟花弩击杀一只幻翼\n" +
                        "* [3]敲掉插着燃烧着的蜡烛的蛋糕\n" +
                        "* [3]在蜂蜜块上跳跃100次\n" +
                        "* [3]使用磁石这个垃圾方块\n" +
                        "* [3]在主世界被重生锚炸死\n" +
                        "* [3]脚下64格都是竹子\n" +
                        "* [3]用鸡蛋敲钟5次\n" +
                        "* [3]在沙漠杀死流髑\n" +
                        "* [3]将背包填满单格的兰花\n" +
                        "* [3]拥有一身弹射物保护的附魔\n" +
                        "* [3]使用雪球击杀一只烈焰人\n" +
                        "* [3]剪掉jeb_羊的羊毛\n" +
                        "* [3]手持刷子破坏可疑的沙子\n" +
                        "* [3]在末影龙存活的情况下到达末地副岛")
            }else if(args[0].toInt() == 4){
                sender.sendMessage("4级挑战有:\n* [4]死于主世界的虚空\n" +
                        "* [4]站在失活的珊瑚块上杀死一只尼莫\n" +
                        "* [4]穿一件锁链装备\n" +
                        "* [4]在拥有中毒效果的同时半径3格内出现蝙蝠\n" +
                        "* [4]获得斑驳的涂蜡切制铜楼梯\n" +
                        "* [4]用末影珍珠砸死末影螨\n" +
                        "* [4]被一只角的山羊击杀\n" +
                        "* [4]在拥有跳跃效果的前提下击杀一只兔子\n" +
                        "* [4]击杀手持金斧的僵尸猪灵\n" +
                        "* [4]在名为Toast兔子面前吃兔肉煲\n" +
                        "* [4]用珍珠砸死一只生物的同时自己落地过猛\n" +
                        "* [4]在靠近一个上下左右前后铺满遮光玻璃的僵尸")

            }else if(args[0].toInt() == 5){
                sender.sendMessage("5级挑战有:\n* [5]使用喷溅型药水击杀女巫\n" +
                        "* [5]清洗有麻将图案的旗帜\n" +
                        "* [5]和名为Johnny的卫道士在同一艘船里\n" +
                        "* [5]拥有不祥之兆buff时使用弩击杀一只村民(谁才是掠夺者！)\n" +
                        "* [5]杀死叼着不死图腾的狐狸\n" +
                        "* [5]在古城吹响山羊角")
            }
        }
        return true
    }
}