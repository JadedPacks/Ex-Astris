package ExAstris.Item;

import ExAstris.Data.ItemData;
import ExAstris.Data.ModData;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import thaumcraft.common.lib.world.ThaumcraftWorldGenerator;
import thaumcraft.common.lib.world.WorldGenEldritchRing;
import thaumcraft.common.lib.world.dim.MazeThread;

public class ItemEldritchPortalSpawner extends Item {
	private WorldGenEldritchRing gen;

	public ItemEldritchPortalSpawner() {
		setCreativeTab(ExAstris.ExAstris.ExAstrisTab);
		setMaxStackSize(1);
	}

	public String getUnlocalizedName() {
		return ModData.ID + "." + ItemData.ELDRITCH_PORTAL_SPAWNER_UNLOCALIZED_NAME;
	}

	public String getUnlocalizedName(final ItemStack item) {
		return ModData.ID + "." + ItemData.ELDRITCH_PORTAL_SPAWNER_UNLOCALIZED_NAME;
	}

	public void registerIcons(final IIconRegister register) {
		itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":ItemEldritchSpawner");
	}

	public boolean onItemUseFirst(ItemStack stack, final EntityPlayer player, final World world, final int x, final int y, final int z, final int side, final float hitX, final float hitY, final float hitZ) {
		if(!world.isRemote) {
			gen = new WorldGenEldritchRing();
			gen.chunkX = x;
			gen.chunkZ = z;
			final int w = 11 + world.rand.nextInt(6) * 2;
			final int h = 11 + world.rand.nextInt(6) * 2;
			gen.width = w;
			gen.height = h;
			if(gen.generate(world, world.rand, x, y, z)) {
				ThaumcraftWorldGenerator.createRandomNodeAt(world, x, y + 2, z, world.rand, false, true, false);
				final Thread t = new Thread(new MazeThread(x, z, w, h, world.rand.nextLong()));
				t.start();
				stack.stackSize--;
				if(stack.stackSize <= 0) {
					stack = null;
				}
				return true;
			}
		}
		return false;
	}
}