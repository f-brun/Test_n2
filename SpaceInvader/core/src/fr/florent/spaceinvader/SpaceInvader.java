package fr.florent.spaceinvader;

//import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.Game;
//import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import fr.florent.spaceinvader.Screens.TitleScreen;

public class SpaceInvader extends Game {

	static public Skin gameSkin;

	public void create () {
		gameSkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
		this.setScreen(new TitleScreen(this));
	}

	public void render () {
		super.render();
	}
	

	public void dispose () {
	}
}