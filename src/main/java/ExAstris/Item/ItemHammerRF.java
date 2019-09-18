package ExAstris.Item;

import ExAstris.Data.ItemData;
import ExAstris.Data.ModData;
import cofh.redstonearsenal.item.RAItems;
import cofh.redstonearsenal.item.tool.ItemToolRF;
import exnihilo.items.hammers.IHammer;
import exnihilo.registries.HammerRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemHammerRF extends ItemToolRF implements IHammer {
	IIcon activeIcon;
	IIcon drainedIcon;

	public ItemHammerRF() {
		super(RAItems.TOOL_MATERIAL_FLUX);
		this.energyPerUseCharged = 1600;
		setCreativeTab(ExAstris.ExAstris.ExAstrisTab);
		setHarvestLevel("pickaxe", 3);
	}

	@Override
	public boolean isHammer(ItemStack stack) {
		return true;
	}

	@Override
	public boolean canItemHarvestBlock(Block block) {
		return HammerRegistry.registered(new ItemStack(block));
	}

	@Override
	public float getDigSpeed(ItemStack item, Block block, int meta) {
		if(HammerRegistry.registered(new ItemStack(block, 1, meta)) && block.getHarvestLevel(meta) <= this.toolMaterial.getHarvestLevel()) {
			if(isEmpowered(item)) {
				return efficiencyOnProperMaterial * 6.0f;
			} else if(getEnergyStored(item) >= getEnergyPerUse(item)) {
				return efficiencyOnProperMaterial * 1.0f;
			}
		}
		return 0.5f;
	}

	@Override
	public String getUnlocalizedName() {
		return ModData.ID + "." + ItemData.HAMMER_RF_UNLOCALIZED_NAME;
	}

	@Override
	public String getUnlocalizedName(ItemStack item) {
		return ModData.ID + "." + ItemData.HAMMER_RF_UNLOCALIZED_NAME;
	}

	@Override
	public void registerIcons(IIconRegister register) {
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":HammerRF");
		this.activeIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":HammerRF_Active");
		this.drainedIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":HammerRF_Drained");
	}

	@Override
	public IIcon getIcon(ItemStack paramItemStack, int paramInt) {
		return getEnergyStored(paramItemStack) <= 0 ? this.drainedIcon : isEmpowered(paramItemStack) ? this.activeIcon : this.itemIcon;
	}

	public EnumRarity getRarity(ItemStack itemStack) {
		return EnumRarity.uncommon;
	}
}