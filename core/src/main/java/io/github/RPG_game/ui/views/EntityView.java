package io.github.RPG_game.ui.views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.RPG_game.domain.entities.Entity;

public abstract class EntityView {


    private final Texture entityTexture;
    public EntityView(String spritePath){
        entityTexture = new Texture(spritePath);
    }

    public void render(SpriteBatch batch, Entity entity){
        batch.draw(entityTexture, entity.getPosition().x(), entity.getPosition().y());
    }

    public void dispose(){
        entityTexture.dispose();
    }
}
