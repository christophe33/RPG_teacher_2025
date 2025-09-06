package io.github.RPG_game.ui.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import io.github.RPG_game.domain.entities.Entity;
import io.github.RPG_game.domain.entities.Player;
import io.github.RPG_game.facade.EntityFacade;
import io.github.RPG_game.domain.shared.Position;
import io.github.RPG_game.ui.models.EntityModel;

public class PlayerController {

    private final EntityFacade playerFacade;
    private final EntityModel playerModel;
    private final Entity player;

    public PlayerController(EntityFacade playerFacade, EntityModel playerModel, Entity player) {
        this.playerFacade = playerFacade;
        this.playerModel = playerModel;
        this.player = player;
    }

    public void update(float speed, float delta){
        playerFacade.setMoving(false);
        float x = playerFacade.getPosition().x();
        float y = playerFacade.getPosition().y();

        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            y += speed * delta;
            playerFacade.setDirection(2);
            playerFacade.setMoving(true);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            y -= speed * delta;
            playerFacade.setDirection(0);
            playerFacade.setMoving(true);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            x -= speed * delta;
            playerFacade.setDirection(1);
            playerFacade.setMoving(true);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            x += speed * delta;
            playerFacade.setDirection(3);
            playerFacade.setMoving(true);
        }
        playerFacade.setPosition(new Position(x, y));
        playerModel.updateFromModel(this.player);
    }

}
