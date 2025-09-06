package io.github.RPG_game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.RPG_game.ui.screens.GameScreen;


public class Main extends Game {
    private SpriteBatch batch;
    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(new GameScreen());
    }
    @Override
    public void dispose() {
        if (getScreen() != null) getScreen().dispose();
        batch.dispose();
    }
}
