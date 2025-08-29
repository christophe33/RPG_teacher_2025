package io.github.RPG_game.domain.entities;

import io.github.RPG_game.domain.shared.Position;

public abstract class Entity {

    private Position position;
    public Entity(Position position){
        this.position = position;
    }
    public void setPosition(Position position){
        this.position = new Position(position.x(), position.y());
    }
    public Position getPosition(){
        return this.position;
    }
}
