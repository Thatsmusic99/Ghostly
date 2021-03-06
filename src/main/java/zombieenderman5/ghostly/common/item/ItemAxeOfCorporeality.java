package zombieenderman5.ghostly.common.item;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zombieenderman5.ghostly.client.core.GhostlyCreativeTabManager;
import zombieenderman5.ghostly.common.core.GhostlyItemManager;
import zombieenderman5.ghostly.common.core.GhostlySoundManager;
import zombieenderman5.ghostly.common.entity.monster.IPartiallyIncorporeal;

public class ItemAxeOfCorporeality extends ItemAxe implements IToolOfCorporeality {
	
	public ItemAxeOfCorporeality() {
		
		super(GhostlyItemManager.CORPOREALITY_TOOL_MATERIAL, 8.0F, -3.0F);
		
		setUnlocalizedName("axe_of_corporeality");
		setRegistryName("axe_of_corporeality");
		setCreativeTab(GhostlyCreativeTabManager.tools);
		
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        if (target instanceof IPartiallyIncorporeal) {
        	stack.damageItem(2, attacker);
        	target.playSound(GhostlySoundManager.CORPOREALITY_TOOL_HIT, 1.0F, 1.0F);
        }
        else {
        	stack.damageItem(3, attacker);
        }
        return true;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
        return GhostlyItemManager.CORPOREAL_RARITY;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		
		tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("ghostly.corporeality.melee_tool.information"));
		
	}
	
}
