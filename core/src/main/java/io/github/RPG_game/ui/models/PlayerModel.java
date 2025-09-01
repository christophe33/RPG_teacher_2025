package io.github.RPG_game.ui.models;

import io.github.RPG_game.domain.shared.Position;

public class PlayerModel extends EntityModel {

    private int currentDirection; // 0=down,1=left,2=up,3=right
    private boolean moving;
    public PlayerModel(Position position){
        super(position);
        this.currentDirection = 0;
        this.moving = false;
    }
    @Override
    public int getDirection() {
        return currentDirection;
    }
    public void setDirection(int currentDirection){
        this.currentDirection = currentDirection;
    }
    @Override
    public boolean isMoving() {
        return moving;
    }

    @Override
    public void setMoving(boolean moving){
        this.moving = moving;
    }

}
