package io.github.RPG_game.domain.entities;

import io.github.RPG_game.domain.shared.Position;

public abstract class Entity {

    private Position position;
    private int currentDirection; // 0=down,1=left,2=up,3=right
    private boolean moving;
    private int health;

    public Entity(Position position){

        this.position = position;
        this.currentDirection = 0;
        this.moving = false;
        this.health = 100;
    }
    public void setPosition(Position position){

        this.position = new Position(position.x(), position.y());
    }
    public Position getPosition(){
        return this.position;
    }
    public int getCurrentDirection(){
        return this.currentDirection;
    }

    public void setDirection(int direction){
        this.currentDirection = direction;
    }
    public boolean isMoving(){
        return this.moving;
    }

    public void setMoving(boolean moving){
        this.moving = moving;
    }
}
