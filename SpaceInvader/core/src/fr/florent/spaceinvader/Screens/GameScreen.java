package fr.florent.spaceinvader.Screens;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import fr.florent.spaceinvader.SpaceInvader;

/**
 * Created by julienvillegas on 17/01/2017.
 */
public class GameScreen implements Screen {

    private Stage stage;
    private Game game;
    float vitesseVaisseau = 4 ;
    Image vaisseau ;

    public GameScreen(Game aGame) {
        game = aGame;
        stage = new Stage(new ScreenViewport());

        Label title = new Label("Playing Screen", SpaceInvader.gameSkin,"big-black");
        title.setAlignment(Align.center);
        title.setY(Gdx.graphics.getHeight()*2/3);
        title.setWidth(Gdx.graphics.getWidth());
        stage.addActor(title);

        TextButton backButton = new TextButton("Back",SpaceInvader.gameSkin);
        backButton.setWidth(Gdx.graphics.getWidth()/2);
        backButton.setPosition(Gdx.graphics.getWidth()/2-backButton.getWidth()/2,Gdx.graphics.getHeight()/4-backButton.getHeight()/2);
        backButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new TitleScreen(game));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(backButton);
        
        System.out.println("Ecran : largeur : "+Gdx.graphics.getWidth() + "Hauteur : " + Gdx.graphics.getHeight());

        vaisseau = new Image(new Texture("Vaisseau.png"));
        System.out.println("Vaisseau : largeur : "+ vaisseau.getWidth() + "Hauteur : " + vaisseau.getHeight());

        vaisseau.scaleBy(3f);
        vaisseau.setPosition(Gdx.graphics.getWidth()/3-vaisseau.getWidth()/2,Gdx.graphics.getHeight()*2/3-vaisseau.getHeight()/2);
        System.out.println("Vaisseau : largeur : "+ vaisseau.getWidth()*vaisseau.getScaleX() + "Hauteur : " + vaisseau.getHeight()*vaisseau.getScaleY());
        stage.addActor(vaisseau);
    }

    @Override
    public void show() {
        Gdx.app.log("MainScreen","show");
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float delta) {
    	float posX ;
    	Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        posX = vaisseau.getX() + vitesseVaisseau ;
        if ((posX < Gdx.graphics.getWidth()/10) || (posX > (9*Gdx.graphics.getWidth()/10 - vaisseau.getWidth()*vaisseau.getScaleX() ))) vitesseVaisseau = -vitesseVaisseau ;
        vaisseau.setPosition(posX, vaisseau.getY()) ;
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}