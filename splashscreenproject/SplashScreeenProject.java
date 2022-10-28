package splashscreenproject;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SplashScreeenProject extends Application {
    
    private static final int COUNT_LIMIT = 3;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    
      @Override
    public void init() throws Exception {       
        
        // Perform some heavy lifting (i.e. database start, check for application updates, etc. )
        for (int i = 1; i <= COUNT_LIMIT; i++) {
            double progress =(double) i/3;
            System.out.println("progress: " +  progress);            
            LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(progress));
            Thread.sleep(2000);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        LauncherImpl.launchApplication(SplashScreeenProject.class, MyPreloader.class, args);
    }
    
}
