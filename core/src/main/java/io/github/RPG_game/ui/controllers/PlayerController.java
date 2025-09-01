package io.github.RPG_game.ui.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import io.github.RPG_game.domain.entities.Entity;
import io.github.RPG_game.domain.shared.Position;
import io.github.RPG_game.ui.models.EntityModel;

public class PlayerController {

    private final EntityModel playerModel;
    public PlayerController(EntityModel playerModel) {
        this.playerModel = playerModel;
    }

    public void update(float speed, float delta){
        playerModel.setMoving(false);
        float x = playerModel.getPosition().x();
        float y = playerModel.getPosition().y();

        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            y += speed * delta;
            playerModel.setDirection(2);
            playerModel.setMoving(true);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            y -= speed * delta;
            playerModel.setDirection(0);
            playerModel.setMoving(true);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            x -= speed * delta;
            playerModel.setDirection(1);
            playerModel.setMoving(true);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            x += speed * delta;
            playerModel.setDirection(3);
            playerModel.setMoving(true);
        }
        playerModel.setPosition(new Position(x, y));
    }
    public int getDirection(){
        return playerModel.getDirection();
    }
    public boolean isMoving() {
        return playerModel.isMoving();
    }
}
