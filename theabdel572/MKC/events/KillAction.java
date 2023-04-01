package theabdel572.MKC.events;

import org.bukkit.event.entity.EntityDeathEvent;
import theabdel572.MKC.MobTypes.MobType;

// An interface to manage the method that happens when an entity dies, used in the map of the Kills
// class.
public interface KillAction {

  /**
   * Method used on the map of the Kills class to handle the killing mobs event things.
   *
   * @param e The triggered EntityDeathEvent
   * @param mob The killed mob as an instance of MobType enum, to be able to get the path
   */
  void onKill(EntityDeathEvent e, MobType mob);
}
