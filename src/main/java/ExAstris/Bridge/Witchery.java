package ExAstris.Bridge;

import ExAstris.Data.ModData;
import com.emoniph.witchery.entity.EntityCovenWitch;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.Fluids;
import exnihilo.registries.BarrelRecipeRegistry;
import exnihilo.registries.SieveRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class Witchery {

	public static void init() {
		addSifting();
		if(ModData.witcheryEnableCovenWitch) {
			BarrelRecipeRegistry.addMobRecipe(Fluids.fluidWitchWater, new ItemStack(GameRegistry.findItem("witchery", "witchhand")), covenWitchClass(), "portal", null);
		}
	}

	private static void addSifting() {
		SieveRegistry.register(Blocks.grass, 0, GameRegistry.findItem("witchery", "seedsartichoke"), 0, ModData.witcherySeedsChance);
		SieveRegistry.register(Blocks.grass, 0, GameRegistry.findItem("witchery", "seedswolfsbane"), 0, ModData.witcherySeedsChance);
		SieveRegistry.register(Blocks.grass, 0, GameRegistry.findItem("witchery", "seedsmandrake"), 0, ModData.witcherySeedsChance);
		SieveRegistry.register(Blocks.grass, 0, GameRegistry.findItem("witchery", "seedsbelladonna"), 0, ModData.witcherySeedsChance);
		SieveRegistry.register(Blocks.grass, 0, GameRegistry.findItem("witchery", "seedssnowbell"), 0, ModData.witcherySeedsChance);
	}

	private static Class covenWitchClass() {
		return EntityCovenWitch.class;
	}

}
