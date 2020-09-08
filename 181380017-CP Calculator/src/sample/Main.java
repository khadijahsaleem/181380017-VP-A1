package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Main extends Application {
    private Label label1 , lbl2 , lbl3;
    private DatePicker Date;
    private TextField marks;
    private Button button;
    private VBox vBox;
    private HBox hBox1 , hBox , hlbl , bhbox;
    @Override
    public void start(Stage primaryStage) throws Exception{
        //label
        label1 = new Label();
        label1.setText("My CP Tracker");
       label1.setFont(new Font("Times New Roman" , 22));
        label1.setPadding(new Insets(10));
        hlbl = new HBox(40 , label1);
        hlbl.setAlignment(Pos.CENTER);

        //date
        lbl2  =new Label("Date: ");
        lbl2.setPrefWidth(40);
        Date =new DatePicker();
        Date.setPrefWidth(Double.valueOf(180));
        Date.setMaxWidth(Double.MAX_VALUE);
        hBox= new HBox( 10,lbl2, Date);
        hBox.setPadding(new Insets(20));
        hBox.setAlignment(Pos.CENTER);


        //marks
        marks = new TextField();
        lbl3 = new Label();
        lbl3.setText("Marks : ");
        lbl3.setPrefWidth(40);
        marks.setPrefColumnCount(15);
        marks.setMaxWidth(Double.MAX_VALUE);
        hBox1 = new HBox(10);
        hBox1.getChildren().addAll(lbl3 , marks);
        hBox1.setPadding(new Insets(20));
        hBox1.setAlignment(Pos.CENTER);



        //button
        button = new Button();
        button.setText("Save Data");;
        bhbox = new HBox(40);
        bhbox.getChildren().add(button);
        bhbox.setAlignment(Pos.CENTER_RIGHT);
        bhbox.setPadding(new Insets(0 , 80,0,0));

        button.setOnAction(event -> {
           save();

        });

        //vBOX
        vBox = new VBox();
        vBox.getChildren().addAll(hlbl , hBox , hBox1 , bhbox);

        //Scene
        Scene scene = new Scene(vBox , 300, 300);
        primaryStage.setTitle("181380017 CP Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void save(){
        try(PrintWriter writer=new PrintWriter(new FileWriter("cp.txt",true))){
            String data="----- CP Marks on "+Date.getValue().toString()+" ----------\n";
            data+=" Marks: "+marks.getText();
            writer.println(data);
            alert(data);
        }
        catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }

    private void alert(String data){
        Alert a=new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("CP Data Saved");
        a.setHeaderText("Your CP data is saved successfully");
        a.setContentText(data);
        a.showAndWait();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
;