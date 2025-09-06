package io.github.RPG_game.ui.models;

import io.github.RPG_game.domain.entities.Entity;
import io.github.RPG_game.domain.entities.Player;
import io.github.RPG_game.domain.shared.Position;

public abstract class EntityModel {

    private Entity entity;

    public EntityModel(Entity entity){
        this.entity = entity;
    }
    public void updateFromModel(Entity entity){
        this.entity = entity;
    }
    public Position getPosition(){
        return entity.getPosition();
    }
    public int getDirection(){
        return entity.getCurrentDirection();
    }
    public boolean isMoving(){
        return entity.isMoving();
    }
}
