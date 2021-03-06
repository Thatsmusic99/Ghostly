package zombieenderman5.ghostly.common.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.world.World;
import zombieenderman5.ghostly.common.core.GhostlyItemManager;
import zombieenderman5.ghostly.common.core.GhostlySoundManager;
import zombieenderman5.ghostly.common.entity.monster.IPartiallyIncorporeal;

public class EntityDustedVenomCorporealityArrow extends EntityVenomCorporealityArrow implements ICorporealityProjectile
{
    public EntityDustedVenomCorporealityArrow(World worldIn)
    {
        super(worldIn);
    }

    public EntityDustedVenomCorporealityArrow(World worldIn, EntityLivingBase shooter)
    {
        super(worldIn, shooter);
    }

    public EntityDustedVenomCorporealityArrow(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate()
    {
        super.onUpdate();

        if (this.world.isRemote && !this.inGround)
        {
            this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    protected ItemStack getArrowStack()
    {
        return new ItemStack(GhostlyItemManager.dustedArrowOfCorporeality);
    }

    @Override
    protected void arrowHit(EntityLivingBase living)
    {
        super.arrowHit(living);
        if (living instanceof IPartiallyIncorporeal) {
        	living.playSound(GhostlySoundManager.CORPOREALITY_TOOL_HIT, 1.0F, 1.0F);
        	living.addPotionEffect(new PotionEffect(MobEffects.POISON, 100, 1));
        } else {
        	living.addPotionEffect(new PotionEffect(MobEffects.WITHER, 200));
        	living.addPotionEffect(new PotionEffect(MobEffects.POISON, 100, 1));
        }
    }

    public static void registerFixesDustedArrow(DataFixer fixer)
    {
        EntityCorporealityArrow.registerFixesArrow(fixer, "DustedVenomCorporealityArrow");
    }
}