package fr.umontpellier.iut.groupe2;

import fr.umontpellier.iut.groupe2.handlers.StepChangeRequest;
import fr.umontpellier.iut.groupe2.inventaire.ItemId;
import fr.umontpellier.iut.groupe2.lightsout.LightsOutController;
import fr.umontpellier.iut.groupe2.view.StepID;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;


public class SalleController {

    @FXML
    public static ImageView dark_Id;
    public ImageView gemmeVerteEmplacement;
    public ImageView gemmeVioletteEmplacement;
    public ImageView gemmeRougeEmplacement;
    public ImageView gemmeRouge;
    public ImageView gemmeBleuEmplacement;
    @FXML
    private Button buttonBackTaquin, taquinButton, lightoutButton, Gvh;
    @FXML
    private TextField textfield;
    @FXML
    private Button pillier;
    @FXML
    private ImageView gemme;
    @FXML
    private ImageView gemmeVerte;

    private LightsOutController lightsOutController = new LightsOutController();
    private final MediaPlayer mediaPlayer;

    public SalleController() {
        this.mediaPlayer = new MediaPlayer(new Media(Paths.get("src/main/resources/raw/groupe2/silenceRoom.mp3").toUri().toString()));
        mediaPlayer.setAutoPlay(true);
    }


    public void handleButton(ActionEvent event) {

        if (event.getSource() == taquinButton) {
            //mediaPlayer.setAutoPlay(true);
            taquinButton.setOnAction(new StepChangeRequest(StepID.TAQUIN, null));
        } else if (event.getSource() == lightoutButton) {
            lightoutButton.setOnAction(new StepChangeRequest(StepID.LIGHTSOUT, null));
        } else if (event.getSource() == buttonBackTaquin) {
            buttonBackTaquin.setOnAction(new StepChangeRequest(StepID.START, null));
        }


    }

    @FXML
    public void onClick(){
        textfield.setOpacity(1.0);

        /*
        if(LightsOutController.gagne) {//il faut faire un getstep == Start
            dark_Id.setVisible(false); // Pour l'instant, renvoie nullpointerexception, peut etre pck on clique deux fois dessus mais marche
        }
        */
    }

    public void allumeSalle (){
        dark_Id.setVisible(false);
    }

    public Boolean estAllume (){
        return dark_Id.isVisible();
    }

    public void recupGemme(MouseEvent mouseEvent) {
        if (mouseEvent.getSource()== gemmeVerte){
            MainSalleGroupe2.stepManager.getInventaire().ajouterItem(ItemId.gemmeVerte);
            gemmeVerte.setVisible(false);
        } else if (mouseEvent.getSource()==gemmeRouge) {
            MainSalleGroupe2.stepManager.getInventaire().ajouterItem(ItemId.gemmeRouge);
            gemmeRouge.setVisible(false);
        }
    }

    public void putGemme(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() == gemmeVerteEmplacement && MainSalleGroupe2.stepManager.getInventaire().getItemIdSelection() == ItemId.gemmeVerte) {
            gemmeVerteEmplacement.setImage(ItemId.gemmeVerte.getImage());
            MainSalleGroupe2.stepManager.getInventaire().retirerItem(ItemId.gemmeVerte);
        } else if (mouseEvent.getSource() == gemmeRougeEmplacement && MainSalleGroupe2.stepManager.getInventaire().getItemIdSelection() == ItemId.gemmeRouge) {
            gemmeRougeEmplacement.setImage(ItemId.gemmeRouge.getImage());
            MainSalleGroupe2.stepManager.getInventaire().retirerItem(ItemId.gemmeRouge);
        } else if (mouseEvent.getSource() == gemmeBleuEmplacement && MainSalleGroupe2.stepManager.getInventaire().getItemIdSelection() == ItemId.gemmeBleue) {
            gemmeBleuEmplacement.setImage(ItemId.gemmeBleue.getImage());
            MainSalleGroupe2.stepManager.getInventaire().retirerItem(ItemId.gemmeBleue);
        }
    }
}
