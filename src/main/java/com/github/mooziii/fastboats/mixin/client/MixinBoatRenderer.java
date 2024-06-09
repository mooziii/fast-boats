package com.github.mooziii.fastboats.mixin.client;

import com.github.mooziii.fastboats.FastBoats;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(BoatRenderer.class)
public class MixinBoatRenderer {

    @Inject(
        method = "render(Lnet/minecraft/world/entity/vehicle/Boat;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/model/ListModel;renderToBuffer(Lcom/mojang/blaze3d/vertex/PoseStack;Lcom/mojang/blaze3d/vertex/VertexConsumer;IIFFFF)V",
            shift = At.Shift.AFTER
        ),
        locals = LocalCapture.CAPTURE_FAILSOFT
    )
    private void injected(Boat entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight, CallbackInfo ci, Pair<ResourceLocation, ListModel<Boat>> pair, ResourceLocation resourceLocation, ListModel<Boat> listModel, VertexConsumer vertexConsumer) {
        if (FastBoats.WAVE_RIDER.get(entity).value() > 0) {
            VertexConsumer enchant = buffer.getBuffer(RenderType.entityGlint());
            listModel.renderToBuffer(poseStack, enchant, packedLight, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0f);
        }
    }
}
