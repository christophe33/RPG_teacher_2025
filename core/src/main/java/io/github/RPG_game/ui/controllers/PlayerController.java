package io.github.RPG_game.ui.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import io.github.RPG_game.domain.entities.Entity;
import io.github.RPG_game.domain.shared.Position;

public class PlayerController {

    private final Entity player;
    public PlayerController(Entity player){
        this.player = player;
    }

    public void update(float speed, float delta){
        float x = player.getPosition().x();
        float y = player.getPosition().y();
        // Déplacement clavier (ZQSD ou flèches)
        if(Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.Z)) y += speed * delta;
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) y -= speed * delta;
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.Q)) x -= speed * delta;
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) x += speed * delta;
        player.setPosition(new Position(x, y));
    }
}
