package be.razerstorm.guardianflow.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.codemc.worldguardwrapper.WorldGuardWrapper;
import org.codemc.worldguardwrapper.region.IWrappedRegion;

import java.util.Set;

public class WorldGuardUtil {

    private static WorldGuardWrapper wrapper;

    public static void init() {
        wrapper = WorldGuardWrapper.getInstance();
    }


    public static IWrappedRegion getRegionAtLocation(Location location) {
        Set<IWrappedRegion> regionSet = wrapper.getRegions(location);
        return regionSet.iterator().next();
    }

    public static IWrappedRegion getRegionByName(String worldString, String id) {
        World world = Bukkit.getWorld(worldString);
        return wrapper.getRegion(world, id).get();
    }


    public static boolean exists(Location location) {
        try {
            getRegionAtLocation(location);
            return true;
        }catch (Exception err) {
            return false;
        }
    }
}