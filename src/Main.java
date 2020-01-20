import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application
{

    private static ObservableList<Node> child;
    //
    private static final String title = "JellyBeanci";
    public static final int width = 800;
    public static final int height = 800;
    private static Color backcolor = Color.rgb(51, 51, 51);

    private static Timeline update;

    @Override
    public void start(Stage stage) throws Exception
    {
        Pane root = new Pane();
        child = root.getChildren();
        //
        Sierpinski sierpinski = new Sierpinski();
        for (Dot dot : sierpinski.getDots())
        {
            child.add(dot.getNode());
        }

        root.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY)
            {
                //Dot d = new Dot(e.getSceneX(), e.getSceneY());
                //System.out.printf("x: %3.1f, y: %3.1f\n", e.getSceneX(), e.getSceneY());
                //child.addAll(d.getNode());
                sierpinski.insertADot(e.getSceneX(), e.getSceneY());
            }
        });


        root.setOnKeyPressed(e -> {
            switch (e.getCode())
            {
                case F1:
                {
                    //PLAY
                    update.play();
                    break;
                }
                case F2:
                {
                    //PAUSE
                    update.pause();
                    break;
                }
                case F3:
                {
                    //Show Child Count
                    System.out.println("Child Count: " + child.size());
                    break;
                }
            }
        });
        update = new Timeline(new KeyFrame(Duration.millis(16), e -> {
            //60 fps
            System.out.println("loop test");

        }));
        update.setCycleCount(Timeline.INDEFINITE);
        update.setRate(1);
        update.setAutoReverse(false);
        //update.play(); //uncomment for play when start
        //
        stage.setTitle(title);
        stage.setResizable(false);
        stage.setScene(new Scene(root, width - 10, height - 10, backcolor));
        stage.show();
        root.requestFocus();
    }

    public static void addNode(Node node)
    {
        child.add(node);
    }

    public static void removeNode(Node node)
    {
        child.remove(node);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}