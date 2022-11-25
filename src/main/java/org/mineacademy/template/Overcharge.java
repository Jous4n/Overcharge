package org.mineacademy.template;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.mineacademy.fo.plugin.SimplePlugin;

/**
 * PluginTemplate is a simple template you can use every time you make
 * a new plugin. This will save you time because you no longer have to
 * recreate the same skeleton and features each time.
 *
 * It uses Foundation for fast and efficient development process.
 */
public final class Overcharge extends SimplePlugin {

	/**
	* Automatically perform login ONCE when the plugin starts.
	*/
	@Override
	protected void onPluginStart() {
	}

	/**
	 * Automatically perform login when the plugin starts and each time it is reloaded.
	 */

	/* ------------------------------------------------------------------------------- */
	/* Events */
	/* ------------------------------------------------------------------------------- */

	/**
	 * An example event that checks if the right clicked entity is a cow, and makes an explosion.
	 * You can write your events to your main class without having to register a listener.
	 *
	 * @param event
	 */
	@EventHandler
	public void onPlayerInteractEntity(final PlayerInteractEntityEvent event) {
		Entity entity = event.getRightClicked();
		Player player = event.getPlayer();

		if (entity instanceof Creeper) {
			final Creeper creeper = (Creeper) entity;

			if (!creeper.isPowered()) {
				creeper.getWorld().strikeLightningEffect(creeper.getLocation());

				creeper.setPowered(true);
			}
		}

		if (entity instanceof Creeper) {
			final Creeper creeper = (Creeper) entity;

			if (creeper.isPowered() && creeper.isClimbing()) {
				creeper.setFuseTicks(10);
				creeper.setGlowing(true);
			}
		}
	}
}
