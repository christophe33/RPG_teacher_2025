package io.github.RPG_game.ui.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.RPG_game.domain.entities.Entity;
import io.github.RPG_game.domain.entities.Player;
import io.github.RPG_game.domain.shared.Position;
import io.github.RPG_game.ui.controllers.PlayerController;
import io.github.RPG_game.ui.models.EntityModel;
import io.github.RPG_game.ui.models.PlayerModel;
import io.github.RPG_game.ui.views.EntityView;
import io.github.RPG_game.ui.views.MapView;
import io.github.RPG_game.ui.views.PlayerView;

public class GameScreen implements Screen {
    private final OrthographicCamera camera;
    private final MapView mapView;
    private EntityModel  playerModel;
    private Entity player;
    private float playerX;
    private float playerY;
    private PlayerController playerController;
    private EntityView playerView;
    private SpriteBatch batch;
    // Vitesse de déplacement du joueur/caméra
    private final float speed = 200f;

    public GameScreen() {
        // Récupérer les dimensions de la map
        mapView = new MapView();
        int tileWidth = (int) mapView.getMap().getProperties().get("tilewidth");
        int tileHeight = (int) mapView.getMap().getProperties().get("tileheight");
        int mapWidth = (int) mapView.getMap().getProperties().get("width");
        int mapHeight = (int) mapView.getMap().getProperties().get("height");

        // Taille du monde
        float worldWidth = mapWidth * tileWidth;
        float worldHeight = mapHeight * tileHeight;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 900, 900);

        // Position initiale du joueur
        playerX = worldWidth / 3f;
        playerY = worldHeight / 3f;
        this.player = new Player(new Position(playerX, playerY));
        this.playerModel = new PlayerModel(player.getPosition());
        playerView = new PlayerView("player.png");
        playerController = new PlayerController(playerModel);
        batch = new SpriteBatch();

    }

    @Override
    public void render(float delta) {
        //delta correspond au temps écoulé depuis le dernier appel de render (en secondes)
        playerController.update(speed, delta);

        // Effacer l'écran
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Centrer la caméra sur le joueur
        camera.position.set(player.getPosition().x(), player.getPosition().y(), 0);
        camera.update();
        mapView.render(camera);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        playerView.render(batch, (PlayerModel)playerModel, delta); // dessine le joueur
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.update();
    }

    @Override
    public void dispose() {
        mapView.dispose();
        playerView.dispose();
        batch.dispose();
    }

    @Override public void show() {}
    @Override public void hide() {}
    @Override public void pause() {}
    @Override public void resume() {}
}
