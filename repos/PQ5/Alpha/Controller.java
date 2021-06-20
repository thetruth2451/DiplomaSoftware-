package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;


public class Controller
{

    //Tasks variables
    @FXML
    private TextField txtSubmit;
    public static ObservableList<String> itemsTasks = FXCollections.observableArrayList();
    public static ObservableList<String> itemsTodo = FXCollections.observableArrayList();


    @FXML
    private Button btnSubmit;
    @FXML
    private ListView<String> lbTasks;
    @FXML
    private ImageView img;

    @FXML
    void clickSubmit(ActionEvent event)
    {
        itemsTasks.add(txtSubmit.getText());
        lbTasks.setItems(itemsTasks);
    }

    @FXML
    void clickDeleteTask(ActionEvent event)
    {
        int index = lbTasks.getSelectionModel().getSelectedIndex();
        if(index != -1){lbTasks.getItems().remove(index);}
    }

    @FXML
    void imgDrag(MouseEvent event)
    {
        Dragboard db = img.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        content.putString("test");
        db.setContent(content);
        event.consume();
    }

    //to-do variables
    @FXML
    private TextField txtSubmitTodo;
    @FXML
    private Button btnSubmitTodo;
    @FXML
    private ListView<String> lbTasksTodo;
    @FXML
    private ImageView imgTodo;

    @FXML
    void clickSubmitTodo(ActionEvent event)
    {
        itemsTodo.add(txtSubmitTodo.getText());
        lbTasksTodo.setItems(itemsTodo);
    }

    @FXML
    void clickDeleteTodo(ActionEvent event)
    {
        int index = lbTasksTodo.getSelectionModel().getSelectedIndex();
        if(index != -1){lbTasksTodo.getItems().remove(index);}
    }

    @FXML
    void imgDragOver(DragEvent event)
    {
        Dragboard db = event.getDragboard();
        String valid = db.getString();
        if(valid.equals("test")){event.acceptTransferModes(TransferMode.COPY_OR_MOVE);}
        event.consume();
    }

    @FXML
    void imgDragDropped(DragEvent event)
    {
        Dragboard db = event.getDragboard();
        String valid = db.getString();
        int check = itemsTasks.size();
        if(valid.equals("test"))
        {
            for(int index = 0; index < itemsTasks.size(); index++)
            {
                itemsTodo.addAll(itemsTasks.get(index).toString());
            }
            //lbTasksTodo.setItems(itemsTodo);
            lbTasksTodo.setItems(itemsTodo);

        }
    }




}
