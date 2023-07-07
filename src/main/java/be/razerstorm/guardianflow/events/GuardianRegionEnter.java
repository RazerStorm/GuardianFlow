package be.razerstorm.guardianflow.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.codemc.worldguardwrapper.region.IWrappedRegion;


public class GuardianRegionEnter extends Event implements Cancellable {
    private Location to;
    private Location from;
    private Player player;

    private IWrappedRegion region;

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean isCancelled;

    public GuardianRegionEnter(Location to, Location from, IWrappedRegion region, Player player){
        this.to = to;
        this.from = from;
        this.player = player;
        this.region = region;
        this.isCancelled = false;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.isCancelled = cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public Location getTo() {
        return to;
    }

    public Location getFrom() {
        return from;
    }

    public Player getPlayer() {
        return player;
    }

    public IWrappedRegion getRegion() {
        return region;
    }
}