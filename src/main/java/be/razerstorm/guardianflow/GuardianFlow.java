package be.razerstorm.guardianflow;

import be.razerstorm.guardianflow.events.PlayerMovement;
import be.razerstorm.guardianflow.utils.WorldGuardUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class GuardianFlow extends JavaPlugin {

    @Override
    public void onLoad() {
        WorldGuardUtil.init();
    }

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerMovement(), this);

    }
}
