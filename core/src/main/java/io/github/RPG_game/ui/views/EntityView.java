package io.github.RPG_game.ui.views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import io.github.RPG_game.ui.models.EntityModel;

public abstract class EntityView {

    private final Texture spriteTexture;
    private final TextureRegion[][] spriteSheet;
    private Animation<TextureRegion>[] animations;
    private float stateTime;
    protected int currentDirection; // 0=down,1=left,2=up,3=right


    public EntityView(String spriteSheetPath, int frameCols, int frameRows) {
        spriteTexture = new Texture(spriteSheetPath);
        spriteSheet = TextureRegion.split(
            spriteTexture,
            spriteTexture.getWidth() / frameCols,
            spriteTexture.getHeight() / frameRows
        );
        animations = new Animation[frameRows];
        for(int row=0; row < frameRows; row++){
            TextureRegion[] frames = new TextureRegion[frameCols];
            for(int col=0; col < frameCols; col++){
                frames[col] = spriteSheet[row][col];
            }
            animations[row] = new Animation<>(0.1f, frames);
        }
        stateTime = 0f;
        currentDirection = 0;
    }

    public void render(SpriteBatch batch, EntityModel model, float delta){
        if(model.isMoving()){
            stateTime += delta;
        } else {
            stateTime = 0f; // reset sur frame idle
        }
        currentDirection = model.getDirection();
        TextureRegion currentFrame;
        Animation<TextureRegion> anim = animations[currentDirection];//récupère la bonne ligne pour le déplacement
        if(model.isMoving()){
            currentFrame = anim.getKeyFrame(stateTime, true);
        }
        else{
            currentFrame = anim.getKeyFrame(0);
        }
        batch.draw(currentFrame, model.getPosition().x(), model.getPosition().y(), 48, 48);
    }

    public void dispose(){
        spriteTexture.dispose();
    }
}
