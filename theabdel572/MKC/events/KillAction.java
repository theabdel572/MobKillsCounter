package theabdel572.MKC.events;

import org.bukkit.event.entity.EntityDeathEvent;
import theabdel572.MKC.MobTypes.MobType;

// An interface to manage the method that happens when an entity dies, used in the map of the Kills class.
public interface KillAction {

  void onKill(EntityDeathEvent e, MobType mob);
}
