package be.razerstorm.guardianflow.events;

import be.razerstorm.guardianflow.utils.WorldGuardUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMovement implements Listener {
    @EventHandler
    public void onWalk(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        // EXIT

        if(WorldGuardUtil.exists(event.getFrom())) {
            if(WorldGuardUtil.exists(event.getTo())) {
                // NOG STEEDS IN REGION
                return;
            }else{
                GuardianRegionExit regionExitEvent = new GuardianRegionExit(event.getTo(), event.getFrom(), WorldGuardUtil.getRegionAtLocation(event.getFrom()), player);
                Bukkit.getPluginManager().callEvent(regionExitEvent);

                if(regionExitEvent.isCancelled()) {
                    event.setCancelled(true);
                }
            }
            return;
        }

        // ENTER

        if(WorldGuardUtil.exists(event.getTo())) {
            if(WorldGuardUtil.exists(event.getFrom())) {
                // NOG STEEDS IN REGION
                return;
            }else{
                GuardianRegionEnter regionEnterEvent = new GuardianRegionEnter(event.getTo(), event.getFrom(), WorldGuardUtil.getRegionAtLocation(event.getTo()), player);
                Bukkit.getPluginManager().callEvent(regionEnterEvent);

                if(regionEnterEvent.isCancelled()) {
                    event.setCancelled(true);
                }
            }
        }
    }
}