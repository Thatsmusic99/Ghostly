package zombieenderman5.ghostly.client.entity.rendering.layer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zombieenderman5.ghostly.GhostlyConfig;
import zombieenderman5.ghostly.GhostlyReference;
import zombieenderman5.ghostly.client.entity.rendering.model.ModelPossessedSkeleton;
import zombieenderman5.ghostly.client.entity.rendering.monster.RenderPossessedBoxerSkeleton;
import zombieenderman5.ghostly.client.entity.rendering.monster.RenderPossessedSkeleton;
import zombieenderman5.ghostly.common.entity.monster.EntityPossessedBoxerSkeleton;

@SideOnly(Side.CLIENT)
public class LayerPossessedBoxerSkeletonEyes implements LayerRenderer<EntityPossessedBoxerSkeleton> {
	
	private static final ResourceLocation RES_WHITE_POSSESSED_BOXER_SKELETON_EYES = new ResourceLocation(GhostlyReference.MOD_ID, "textures/entity/possessed_skeleton/eyes_white.png");
	private static final ResourceLocation RES_BLUE_POSSESSED_BOXER_SKELETON_EYES = new ResourceLocation(GhostlyReference.MOD_ID, "textures/entity/possessed_skeleton/eyes_blue.png");
	private static final ResourceLocation RES_GREEN_POSSESSED_BOXER_SKELETON_EYES = new ResourceLocation(GhostlyReference.MOD_ID, "textures/entity/possessed_skeleton/eyes_green.png");
	private static final ResourceLocation RES_RED_POSSESSED_BOXER_SKELETON_EYES = new ResourceLocation(GhostlyReference.MOD_ID, "textures/entity/possessed_skeleton/eyes_red.png");
	private static final ResourceLocation RES_BLUE_RED_LEFT_POSSESSED_BOXER_SKELETON_EYES = new ResourceLocation(GhostlyReference.MOD_ID, "textures/entity/possessed_skeleton/eyes_blue_red_left.png");
	private static final ResourceLocation RES_BLUE_RED_RIGHT_POSSESSED_BOXER_SKELETON_EYES = new ResourceLocation(GhostlyReference.MOD_ID, "textures/entity/possessed_skeleton/eyes_blue_red_right.png");
	private static final ResourceLocation RES_BLUE_WHITE_LEFT_POSSESSED_BOXER_SKELETON_EYES = new ResourceLocation(GhostlyReference.MOD_ID, "textures/entity/possessed_skeleton/eyes_blue_white_left.png");
	private static final ResourceLocation RES_BLUE_WHITE_RIGHT_POSSESSED_BOXER_SKELETON_EYES = new ResourceLocation(GhostlyReference.MOD_ID, "textures/entity/possessed_skeleton/eyes_blue_white_right.png");
	private static final ResourceLocation RES_GREEN_BLUE_LEFT_POSSESSED_BOXER_SKELETON_EYES = new ResourceLocation(GhostlyReference.MOD_ID, "textures/entity/possessed_skeleton/eyes_green_blue_left.png");
	private static final ResourceLocation RES_GREEN_BLUE_RIGHT_POSSESSED_BOXER_SKELETON_EYES = new ResourceLocation(GhostlyReference.MOD_ID, "textures/entity/possessed_skeleton/eyes_green_blue_right.png");
	private static final ResourceLocation RES_GREEN_RED_LEFT_POSSESSED_BOXER_SKELETON_EYES = new ResourceLocation(GhostlyReference.MOD_ID, "textures/entity/possessed_skeleton/eyes_green_red_left.png");
	private static final ResourceLocation RES_GREEN_RED_RIGHT_POSSESSED_BOXER_SKELETON_EYES = new ResourceLocation(GhostlyReference.MOD_ID, "textures/entity/possessed_skeleton/eyes_green_red_right.png");
	private static final ResourceLocation RES_GREEN_WHITE_LEFT_POSSESSED_BOXER_SKELETON_EYES = new ResourceLocation(GhostlyReference.MOD_ID, "textures/entity/possessed_skeleton/eyes_green_white_left.png");
	private static final ResourceLocation RES_GREEN_WHITE_RIGHT_POSSESSED_BOXER_SKELETON_EYES = new ResourceLocation(GhostlyReference.MOD_ID, "textures/entity/possessed_skeleton/eyes_green_white_right.png");
	private final RenderPossessedBoxerSkeleton stoneGolemRenderer;
	
	public LayerPossessedBoxerSkeletonEyes(RenderPossessedBoxerSkeleton stoneGolemRendererIn) {
		
		stoneGolemRenderer = stoneGolemRendererIn;
	}
	
	@Override
	public void doRenderLayer(EntityPossessedBoxerSkeleton entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		
		if (entitylivingbaseIn.getEyeType() == 0) {
			
			stoneGolemRenderer.bindTexture(RES_WHITE_POSSESSED_BOXER_SKELETON_EYES);
			
		} else if (entitylivingbaseIn.getEyeType() == 1) {
			
			stoneGolemRenderer.bindTexture(RES_BLUE_POSSESSED_BOXER_SKELETON_EYES);
			
		} else if (entitylivingbaseIn.getEyeType() == 2) {
			
			stoneGolemRenderer.bindTexture(RES_GREEN_POSSESSED_BOXER_SKELETON_EYES);
			
		} else if (entitylivingbaseIn.getEyeType() == 3) {
			
			stoneGolemRenderer.bindTexture(RES_RED_POSSESSED_BOXER_SKELETON_EYES);
			
		} else if (GhostlyConfig.AESTHETICS.multicolorPossessedBoxerSkeletonEyes) {
			
			if (entitylivingbaseIn.getEyeType() == 4) {
				
				stoneGolemRenderer.bindTexture(RES_BLUE_RED_LEFT_POSSESSED_BOXER_SKELETON_EYES);
				
			} else if (entitylivingbaseIn.getEyeType() == 5) {
				
				stoneGolemRenderer.bindTexture(RES_BLUE_RED_RIGHT_POSSESSED_BOXER_SKELETON_EYES);
				
			} else if (entitylivingbaseIn.getEyeType() == 6) {
				
				stoneGolemRenderer.bindTexture(RES_BLUE_WHITE_LEFT_POSSESSED_BOXER_SKELETON_EYES);
				
			} else if (entitylivingbaseIn.getEyeType() == 7) {
				
				stoneGolemRenderer.bindTexture(RES_BLUE_WHITE_RIGHT_POSSESSED_BOXER_SKELETON_EYES);
				
			} else if (entitylivingbaseIn.getEyeType() == 8) {
				
				stoneGolemRenderer.bindTexture(RES_GREEN_BLUE_LEFT_POSSESSED_BOXER_SKELETON_EYES);
				
			} else if (entitylivingbaseIn.getEyeType() == 9) {
				
				stoneGolemRenderer.bindTexture(RES_GREEN_BLUE_RIGHT_POSSESSED_BOXER_SKELETON_EYES);
				
			} else if (entitylivingbaseIn.getEyeType() == 10) {
				
				stoneGolemRenderer.bindTexture(RES_GREEN_RED_LEFT_POSSESSED_BOXER_SKELETON_EYES);
				
			} else if (entitylivingbaseIn.getEyeType() == 11) {
				
				stoneGolemRenderer.bindTexture(RES_GREEN_RED_RIGHT_POSSESSED_BOXER_SKELETON_EYES);
				
			} else if (entitylivingbaseIn.getEyeType() == 12) {
				
				stoneGolemRenderer.bindTexture(RES_GREEN_WHITE_LEFT_POSSESSED_BOXER_SKELETON_EYES);
				
			} else if (entitylivingbaseIn.getEyeType() == 13) {
				
				stoneGolemRenderer.bindTexture(RES_GREEN_WHITE_RIGHT_POSSESSED_BOXER_SKELETON_EYES);
				
			}
			
		}
		GlStateManager.enableBlend();
		GlStateManager.disableAlpha();
		GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
		GlStateManager.disableLighting();
		GlStateManager.depthMask(!entitylivingbaseIn.isInvisible());
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 61680.0F, 0.0F);
		GlStateManager.enableLighting();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		if (entitylivingbaseIn.getItemStackFromSlot(EntityEquipmentSlot.HEAD).isEmpty()) {
			((ModelPossessedSkeleton) stoneGolemRenderer.getMainModel()).changeBipedHeadwearVisibility(false);
		} else {
			((ModelPossessedSkeleton) stoneGolemRenderer.getMainModel()).changeBipedHeadwearVisibility(true);
		}
		Minecraft.getMinecraft().entityRenderer.setupFogColor(true);
		stoneGolemRenderer.getMainModel().render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		Minecraft.getMinecraft().entityRenderer.setupFogColor(false);
		stoneGolemRenderer.setLightmap(entitylivingbaseIn);
		GlStateManager.depthMask(true);
		GlStateManager.disableBlend();
		GlStateManager.enableAlpha();
		
	}
	
	@Override
	public boolean shouldCombineTextures() {
		
		return false;
		
	}
}