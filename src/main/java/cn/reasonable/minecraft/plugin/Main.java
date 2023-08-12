package cn.reasonable.minecraft.plugin;

import cn.reasonable.minecraft.plugin.PluginListener;
import org.bukkit.plugin.java.JavaPlugin;
public class Main extends JavaPlugin{
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
    
    @Override
    public void onLoad(){
        getServer().getPluginManager().registerEvents(new PluginListener(),this);
    }
}