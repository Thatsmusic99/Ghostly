package zombieenderman5.ghostly.common.entity.ai;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import zombieenderman5.ghostly.GhostlyConfig;

public class EntityAIFleeLight extends EntityAIBase {

	 private final EntityCreature creature;
	    private double shelterX;
	    private double shelterY;
	    private double shelterZ;
	    private final double movementSpeed;
	    private final World world;

	    public EntityAIFleeLight(EntityCreature theCreatureIn, double movementSpeedIn)
	    {
	        this.creature = theCreatureIn;
	        this.movementSpeed = movementSpeedIn;
	        this.world = theCreatureIn.world;
	        this.setMutexBits(1);
	    }

	    /**
	     * Returns whether the EntityAIBase should begin execution.
	     */
	    @Override
	    public boolean shouldExecute()
	    {
	        if ((float)GhostlyConfig.MOBS.shadeDissipationLightLevel == -0.1D || !(this.world.getLightBrightness(new BlockPos(creature)) > ((float)GhostlyConfig.MOBS.shadeDissipationLightLevel * 0.6))) {
	        	
	        	return false;
	        	
	        }
	        else
	        {
	            Vec3d vec3d = this.findPossibleShelter();

	            if (vec3d == null)
	            {
	                return false;
	            }
	            else
	            {
	                this.shelterX = vec3d.x;
	                this.shelterY = vec3d.y;
	                this.shelterZ = vec3d.z;
	                return true;
	            }
	        }
	    }

	    /**
	     * Returns whether an in-progress EntityAIBase should continue executing
	     */
	    @Override
	    public boolean shouldContinueExecuting()
	    {
	        return !this.creature.getNavigator().noPath();
	    }

	    /**
	     * Execute a one shot task or start executing a continuous task
	     */
	    @Override
	    public void startExecuting()
	    {
	        this.creature.getNavigator().tryMoveToXYZ(this.shelterX, this.shelterY, this.shelterZ, this.movementSpeed);
	    }

	    @Nullable
	    private Vec3d findPossibleShelter()
	    {
	        Random random = this.creature.getRNG();
	        BlockPos blockpos = new BlockPos(this.creature.posX, this.creature.getEntityBoundingBox().minY, this.creature.posZ);

	        for (int i = 0; i < 10; ++i)
	        {
	            BlockPos blockpos1 = blockpos.add(random.nextInt(20) - 10, random.nextInt(6) - 3, random.nextInt(20) - 10);

	            if (this.world.getLightBrightness(blockpos) < ((float)GhostlyConfig.MOBS.shadeDissipationLightLevel * 0.6))
	            {
	                return new Vec3d((double)blockpos1.getX(), (double)blockpos1.getY(), (double)blockpos1.getZ());
	            }
	        }

	        return null;
	    }

}
