package ExAstris.Bridge;

import ExAstris.Data.ModData;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.registries.SieveRegistry;
import net.minecraft.init.Blocks;

public class BigReactors {
	public static void init() {
		addSieveRegistry();
	}

	public static void addSieveRegistry() {
		SieveRegistry.register(Blocks.sand, 0, GameRegistry.findItem("BigReactors", "BRIngot"), 4, ModData.oreYelloriumChance);
	}
}
