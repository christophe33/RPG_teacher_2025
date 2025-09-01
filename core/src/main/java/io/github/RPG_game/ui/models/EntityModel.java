package io.github.RPG_game.ui.models;

import io.github.RPG_game.domain.shared.Position;

public abstract class EntityModel {

    private Position position;

    public EntityModel(Position position){
        this.position = new Position(position.x(), position.y());
    }

    public Position getPosition() {
        return new Position(position.x(), position.y());
    }

    public void setPosition(Position position) {
        this.position = new Position(position.x(), position.y());
    }
    public abstract void setDirection(int direction);
    public abstract int getDirection();
    public abstract boolean isMoving();
    public abstract void setMoving(boolean moving);
}
