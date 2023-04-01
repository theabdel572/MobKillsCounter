package theabdel572.MKC.events;

import org.bukkit.event.entity.EntityDeathEvent;
import theabdel572.MKC.MobTypes.MobType;

public interface KillAction {

  void onKill(EntityDeathEvent e, MobType mob);
}
