package io.github.RPG_game.ui.views;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class MapView {

    private final TiledMap map;
    private final OrthogonalTiledMapRenderer mapRenderer;
    public MapView(){
        map = new TmxMapLoader().load("map_demo.tmx");
        mapRenderer = new OrthogonalTiledMapRenderer(map);
    }

    public void render(OrthographicCamera camera){
        mapRenderer.setView(camera);
        mapRenderer.render();
    }

    public TiledMap getMap(){
        return map;
    }

    public void dispose(){
        map.dispose();
        mapRenderer.dispose();
    }
}
