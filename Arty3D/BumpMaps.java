//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Arty3D;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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

public class BumpMaps extends Application {
    private static final float WIDTH = 1400.0F;
    private static final float HEIGHT = 1000.0F;
    private final PointLight pointLight = new PointLight();
    private double anchorX;
    private double anchorY;
    private double anchorAngleX = 0.0;
    private double anchorAngleY = 0.0;
    private final DoubleProperty angleX = new SimpleDoubleProperty(0.0);
    private final DoubleProperty angleY = new SimpleDoubleProperty(0.0);

    public BumpMaps() {
    }

    public void start(Stage primaryStage) {
        Box box = this.prepareBox();
        SmartGroup group = new SmartGroup();
        group.getChildren().add(box);
        group.getChildren().addAll(this.prepareLightSource());
        Camera camera = new PerspectiveCamera(true);
        camera.setNearClip(1.0);
        camera.setFarClip(1000.0);
        camera.translateZProperty().set(-200.0);
        Scene scene = new Scene(group, 1400.0, 1000.0);
        scene.setFill(Color.SILVER);
        scene.setCamera(camera);
        group.translateXProperty().set(0.0);
        group.translateYProperty().set(0.0);
        group.translateZProperty().set(0.0);
        this.initMouseControl(group, scene, primaryStage);
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, (event) -> {
            switch (event.getCode()) {
                case W:
                    group.translateZProperty().set(group.getTranslateZ() + 100.0);
                    break;
                case S:
                    group.translateZProperty().set(group.getTranslateZ() - 100.0);
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
            }

        });
        primaryStage.setTitle("Genuine Coder");
        primaryStage.setScene(scene);
        primaryStage.show();
        AnimationTimer timer = new AnimationTimer() {
            public void handle(long now) {
                BumpMaps.this.pointLight.setRotate(BumpMaps.this.pointLight.getRotate() + 1.0);
            }
        };
        timer.start();
    }

    private Node[] prepareLightSource() {
        this.pointLight.setColor(Color.RED);
        this.pointLight.getTransforms().add(new Translate(0.0, -50.0, 100.0));
        this.pointLight.setRotationAxis(Rotate.X_AXIS);
        Sphere sphere = new Sphere(2.0);
        sphere.getTransforms().setAll(this.pointLight.getTransforms());
        sphere.rotateProperty().bind(this.pointLight.rotateProperty());
        sphere.rotationAxisProperty().bind(this.pointLight.rotationAxisProperty());
        return new Node[]{this.pointLight, sphere};
    }

    private Box prepareBox() {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(this.getClass().getResourceAsStream("/resource/artycmp.png")));
        material.setBumpMap(new Image(this.getClass().getResourceAsStream("/resource/exit.png")));
        Box box = new Box(100.0, 20.0, 50.0);
        box.setMaterial(material);
        return box;
    }

    private void initMouseControl(SmartGroup group, Scene scene, Stage stage) {
        Rotate xRotate;
        Rotate yRotate;
        group.getTransforms().addAll(new Transform[]{xRotate = new Rotate(0.0, Rotate.X_AXIS), yRotate = new Rotate(0.0, Rotate.Y_AXIS)});
        xRotate.angleProperty().bind(this.angleX);
        yRotate.angleProperty().bind(this.angleY);
        scene.setOnMousePressed((event) -> {
            this.anchorX = event.getSceneX();
            this.anchorY = event.getSceneY();
            this.anchorAngleX = this.angleX.get();
            this.anchorAngleY = this.angleY.get();
        });
        scene.setOnMouseDragged((event) -> {
            this.angleX.set(this.anchorAngleX - (this.anchorY - event.getSceneY()));
            this.angleY.set(this.anchorAngleY + this.anchorX - event.getSceneX());
        });
        stage.addEventHandler(ScrollEvent.SCROLL, (event) -> {
            double delta = event.getDeltaY();
            group.translateZProperty().set(group.getTranslateZ() + delta);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    class SmartGroup extends Group {
        Rotate r;
        Transform t = new Rotate();

        SmartGroup() {
        }

        void rotateByX(int ang) {
            this.r = new Rotate((double)ang, Rotate.X_AXIS);
            this.t = this.t.createConcatenation(this.r);
            this.getTransforms().clear();
            this.getTransforms().addAll(new Transform[]{this.t});
        }

        void rotateByY(int ang) {
            this.r = new Rotate((double)ang, Rotate.Y_AXIS);
            this.t = this.t.createConcatenation(this.r);
            this.getTransforms().clear();
            this.getTransforms().addAll(new Transform[]{this.t});
        }
    }
}
