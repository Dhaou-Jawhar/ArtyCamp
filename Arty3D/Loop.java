package Arty3D;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.AmbientLight;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class Loop extends Application {

  private static final float WIDTH = 800;
  private static final float HEIGHT = 600;

  private double anchorX, anchorY;
  private double anchorAngleX = 0;
  private double anchorAngleY = 0;
  private final DoubleProperty angleX = new SimpleDoubleProperty(0);
  private final DoubleProperty angleY = new SimpleDoubleProperty(0);
  private final PointLight pointLight = new PointLight();

  @Override
  public void start(Stage primaryStage) {
    Box box = prepareBox();

    SmartGroup group = new SmartGroup();
    group.getChildren().add(box);
    group.getChildren().add(prepareSecondBox());
    group.getChildren().add(new AmbientLight());

    Camera camera = new PerspectiveCamera(true);
    camera.setNearClip(1);
    camera.setFarClip(1000);
    camera.translateZProperty().set(-200);

    Scene scene = new Scene(group, WIDTH, HEIGHT, true);
    scene.setFill(Color.SILVER);
    scene.setCamera(camera);

    group.translateXProperty().set(0);
    group.translateYProperty().set(0);
    group.translateZProperty().set(0);

    initMouseControl(group, scene, primaryStage);

    primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
      switch (event.getCode()) {
        case W:
          group.translateZProperty().set(group.getTranslateZ() + 100);
          break;
        case S:
          group.translateZProperty().set(group.getTranslateZ() - 100);
          break;
        case Q:
          group.rotateByX(10);
          break;
        case E:
          group.rotateByX(-10);
          break;
        case NUMPAD6:
          group.rotateByY(10);
          break;
        case NUMPAD4:
          group.rotateByY(-10);
          break;
      }
    });

    primaryStage.setTitle("Genuine Coder");
    primaryStage.setScene(scene);
    primaryStage.show();

    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(long now) {
        pointLight.setRotate(pointLight.getRotate() + 1);
      }
    };
    timer.start();
  }
   

  private Node prepareSecondBox() {
    PhongMaterial material = new PhongMaterial();
    material.setDiffuseMap(new Image(getClass().getResourceAsStream("/resource/wood.jpg")));
    Box box = new Box(20, 100, 100);
    box.setMaterial(material);
    return box;
  }

  private Box prepareBox() {
    PhongMaterial material = new PhongMaterial();
    material.setDiffuseMap(new Image(getClass().getResourceAsStream("/resource/wood.jpg")));
    Box box = new Box(100, 20, 50);
    box.setMaterial(material);
    return box;
  }

  private void initMouseControl(SmartGroup group, Scene scene, Stage stage) {
    Rotate xRotate;
    Rotate yRotate;
    group.getTransforms().addAll(
        xRotate = new Rotate(0, Rotate.X_AXIS),
        yRotate = new Rotate(0, Rotate.Y_AXIS)
    );
    xRotate.angleProperty().bind(angleX);
    yRotate.angleProperty().bind(angleY);

    scene.setOnMousePressed(event -> {
      anchorX = event.getSceneX();
      anchorY = event.getSceneY();
      anchorAngleX = angleX.get();
      anchorAngleY = angleY.get();
    });

    scene.setOnMouseDragged(event -> {
      angleX.set(anchorAngleX - (anchorY - event.getSceneY()));
      angleY.set(anchorAngleY + anchorX - event.getSceneX());
    });

    stage.addEventHandler(ScrollEvent.SCROLL, event -> {
      double delta = event.getDeltaY();
      group.translateZProperty().set(group.getTranslateZ() + delta);
    });
  }

  

        
  public static void main(String[] args) {
    launch(args);
    System.out.println("Hi im 3D Model");
  }

  class SmartGroup extends Group {

    Rotate r;
    Transform t = new Rotate();

    void rotateByX(int ang) {
      r = new Rotate(ang, Rotate.X_AXIS);
      t = t.createConcatenation(r);
      this.getTransforms().clear();
      this.getTransforms().addAll(t);
    }

    void rotateByY(int ang) {
      r = new Rotate(ang, Rotate.Y_AXIS);
      t = t.createConcatenation(r);
      this.getTransforms().clear();
      this.getTransforms().addAll(t);
    }
  }
}
