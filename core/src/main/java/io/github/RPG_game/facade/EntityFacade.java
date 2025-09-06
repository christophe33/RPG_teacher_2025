package io.github.RPG_game.facade;

import io.github.RPG_game.domain.entities.Entity;
import io.github.RPG_game.domain.shared.Position;

public class EntityFacade {
    /**
     * We expose only attributes that are relevant to the view.
     */
    private Entity entity;
    public EntityFacade(Entity entity){
        this.entity = entity;
    }

    public int getDirection(){
        return this.entity.getCurrentDirection();
    }

    public void setDirection(int direction){
        this.entity.setDirection(direction);
    }
    public void setMoving(boolean moving) {
        this.entity.setMoving(moving);
    }
    public boolean isMoving(){
        return entity.isMoving();
    }
    public Position getPosition(){
        return entity.getPosition();
    }
    public void setPosition(Position position){
        this.entity.setPosition(position);
    }
}
