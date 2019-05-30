package domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class RunningCharacter extends Character {

    public RunningCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();

    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();


//        for (int i = 0; i < 1480; i++) {

            sprite.add(new Image(new FileInputStream("src/Assets/Running0.png")));
            sprite.add(new Image(new FileInputStream("src/Assets/Running1.png")));
            sprite.add(new Image(new FileInputStream("src/Assets/Running2.png")));
            sprite.add(new Image(new FileInputStream("src/Assets/Running3.png")));
            sprite.add(new Image(new FileInputStream("src/Assets/Running4.png")));
            sprite.add(new Image(new FileInputStream("src/Assets/Running5.png")));
            sprite.add(new Image(new FileInputStream("src/Assets/Running6.png")));
            sprite.add(new Image(new FileInputStream("src/Assets/Running7.png")));
            sprite.add(new Image(new FileInputStream("src/Assets/Run0.png")));
            sprite.add(new Image(new FileInputStream("src/Assets/Run1.png")));
            sprite.add(new Image(new FileInputStream("src/Assets/Run2.png")));
            sprite.add(new Image(new FileInputStream("src/Assets/Run3.png")));
            sprite.add(new Image(new FileInputStream("src/Assets/Run4.png")));
            sprite.add(new Image(new FileInputStream("src/Assets/Run5.png")));
            sprite.add(new Image(new FileInputStream("src/Assets/Run6.png")));
            sprite.add(new Image(new FileInputStream("src/Assets/Run7.png")));
        
        super.setSprite(sprite);

    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        super.setImage(sprite.get(0));
        int j = 0;
        int a=8;
        while (true) {
            try {

                for (int i = 1; i <= 740; i = i + 10) {
                    if (j < 8) {
                        super.setImage(sprite.get(j));

                        super.setX(i);
                        Thread.sleep(75);
                        j++;
                    } else {
                        j = 0;
                    }
                }
                for (int h = 740; h >= 1; h = h - 10) {
                    if (a < 16) {
                        super.setImage(sprite.get(a));

                        super.setX(h);
                        Thread.sleep(75);
                        a++;
                    } else {
                        a = 8;
                    }
                }
                
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
