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
    public void setDirection(int direction){
        this.entity.setDirection(direction);
    }
    public void setMoving(boolean moving) {
        this.entity.setMoving(moving);
    }
    public void setPosition(Position position){
        this.entity.setPosition(position);
    }
}
