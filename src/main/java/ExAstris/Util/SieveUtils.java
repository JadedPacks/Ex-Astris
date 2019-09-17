package ExAstris.Util;

import exnihilo.registries.SieveRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import java.util.HashMap;

public class SieveUtils {

	private static HashMap<ItemInfo, Boolean> registryCache = new HashMap<ItemInfo, Boolean>();

	public static boolean registered(ItemStack item) {
		Boolean allowed = registryCache.get(new ItemInfo(item));
		if(allowed == null) {
			if(SieveRegistry.registered(Block.getBlockFromItem(item.getItem()), item.getMetadata())) {
				registryCache.put(new ItemInfo(item), true);
				return true;
			} else {
				registryCache.put(new ItemInfo(item), false);
			}
		} else return allowed;
		return false;
	}
}
