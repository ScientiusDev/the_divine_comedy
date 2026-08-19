package net.scientius.divinecomedy.entity.client.crawler;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.scientius.divinecomedy.DivineComedy;
import net.scientius.divinecomedy.entity.client.ModModelLayerLocations;
import net.scientius.divinecomedy.entity.client.rockroller.RockRollerModel;
import net.scientius.divinecomedy.entity.client.rockroller.RockRollerRenderState;
import net.scientius.divinecomedy.entity.custom.CrawlerEntity;
import net.scientius.divinecomedy.entity.custom.RockRollerEntity;

public class CrawlerRenderer extends MobRenderer<CrawlerEntity, CrawlerRenderState, CrawlerModel> {
    public CrawlerRenderer(EntityRendererProvider.Context context) {
        super(context, new CrawlerModel(context.bakeLayer(ModModelLayerLocations.CRAWLER)), 0.75f);
    }

    @Override
    public Identifier getTextureLocation(CrawlerRenderState crawlerRenderState) {
        return Identifier.fromNamespaceAndPath(DivineComedy.MODID, "textures/entity/crawler/crawler.png");
    }

    @Override
    public CrawlerRenderState createRenderState() {return new CrawlerRenderState();}

    @Override
    public void extractRenderState(CrawlerEntity entity, CrawlerRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.idleAnimationState.copyFrom(entity.idleAnimationState);
    }
}
