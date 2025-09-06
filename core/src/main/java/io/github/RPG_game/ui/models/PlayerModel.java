package io.github.RPG_game.ui.models;

import io.github.RPG_game.domain.entities.Entity;

public class PlayerModel extends EntityModel {
    private final Entity player;
    public PlayerModel(Entity entity){
        super(entity);
        this.player = entity;
    }
    @Override
    public int getDirection(){
        return this.player.getCurrentDirection();
    }
    @Override
    public boolean isMoving(){
        return this.player.isMoving();
    }
}
