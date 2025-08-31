package io.github.RPG_game.ui.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import io.github.RPG_game.domain.entities.Entity;
import io.github.RPG_game.domain.shared.Position;

public class PlayerController {

    private final Entity player;
    private int direction;
    private boolean moving;
    public PlayerController(Entity player){

        this.player = player;
        this.moving = false;
        this.direction = 0;
    }

    public void update(float speed, float delta){
        moving = false;
        float x = player.getPosition().x();
        float y = player.getPosition().y();

        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            y += speed * delta;
            direction = 2;
            moving = true;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            y -= speed * delta;
            direction = 0;
            moving = true;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            x -= speed * delta;
            direction = 1;
            moving = true;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            x += speed * delta;
            direction = 3;
            moving = true;
        }
        player.setPosition(new Position(x, y));
    }
    public int getDirection(){
        return direction;
    }
    public boolean isMoving() {
        return moving;
    }
}
