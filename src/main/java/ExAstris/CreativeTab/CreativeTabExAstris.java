package ExAstris.CreativeTab;

import exnihilo.ENItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabExAstris extends CreativeTabs {
	public CreativeTabExAstris(int id) {
		super(id, "ExAstrisTab");
	}

	@Override
	public Item getTabIconItem() {
		return ENItems.Crook;
	}
}
