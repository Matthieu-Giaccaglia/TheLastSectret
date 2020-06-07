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


    public ImageView gemmeVerteEmplacement;
    public ImageView gemmeVioletteEmplacement;
    public ImageView gemmeRougeEmplacement;
    public ImageView gemmeRouge;
    public ImageView gemmeBleuEmplacement;
    public ImageView gemmeViolette;
    public ImageView tropHaut;
    public ImageView pilierGrand;
    public ImageView pilierTombe;
    private ItemId pillierVert ;
    private ItemId pillierRouge ;
    private ItemId pillierBleu ;
    private ItemId pillierViolet ;
    private int compteur = 0;



    @FXML
    public static ImageView dark_Id;
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
        if (mouseEvent.getSource() == gemmeVerte) {
            MainSalleGroupe2.stepManager.getInventaire().ajouterItem(ItemId.gemmeVerte);
            gemmeVerte.setVisible(false);
        } else if (mouseEvent.getSource() == gemmeRouge) {
            MainSalleGroupe2.stepManager.getInventaire().ajouterItem(ItemId.gemmeRouge);
            gemmeRouge.setVisible(false);
        } else if (mouseEvent.getSource() == gemmeViolette) {
            MainSalleGroupe2.stepManager.getInventaire().ajouterItem(ItemId.gemmeViolette);
            gemmeViolette.setVisible(false);
        }
    }

    public boolean estGagnant() {
        if (pillierVert == ItemId.gemmeVerte && pillierRouge == ItemId.gemmeRouge && pillierBleu == ItemId.gemmeBleue && pillierViolet == ItemId.gemmeViolette) {
            gemmeVerteEmplacement.setDisable(true);
            gemmeVioletteEmplacement.setDisable(true);
            gemmeBleuEmplacement.setDisable(true);
            gemmeRougeEmplacement.setDisable(true);
            System.out.println("C gagné");
            return true;
        }
        return false;
    }

    public boolean contientGemme (){
        return MainSalleGroupe2.stepManager.getInventaire().getItemIdSelection() == ItemId.gemmeVerte || MainSalleGroupe2.stepManager.getInventaire().getItemIdSelection() == ItemId.gemmeViolette || MainSalleGroupe2.stepManager.getInventaire().getItemIdSelection() == ItemId.gemmeBleue || MainSalleGroupe2.stepManager.getInventaire().getItemIdSelection() == ItemId.gemmeRouge;
    }

    public void putGemme(MouseEvent mouseEvent) {
        ItemId selected = MainSalleGroupe2.stepManager.getInventaire().getItemIdSelection();
        if (mouseEvent.getSource() == gemmeVerteEmplacement && gemmeVerteEmplacement.getImage() == null && contientGemme()){
                gemmeVerteEmplacement.setImage(ItemId.gemmeVerte.getImage());
            pillierVert=selected;
            MainSalleGroupe2.stepManager.getInventaire().retirerItem(selected);
        }

        else if (mouseEvent.getSource()==gemmeVerteEmplacement && gemmeVerteEmplacement.getImage()!=null ){
            MainSalleGroupe2.stepManager.getInventaire().ajouterItem(pillierVert);
            gemmeVerteEmplacement.setImage(null);
            pillierVert=null;
        }

        else if (mouseEvent.getSource() == gemmeRougeEmplacement && gemmeRougeEmplacement.getImage() == null && contientGemme() ) {
            gemmeRougeEmplacement.setImage(ItemId.gemmeRouge.getImage());
            pillierRouge= selected;
            MainSalleGroupe2.stepManager.getInventaire().retirerItem(selected);
        }

        else if (mouseEvent.getSource()==gemmeRougeEmplacement && gemmeRougeEmplacement.getImage()!=null ){
            MainSalleGroupe2.stepManager.getInventaire().ajouterItem(pillierRouge);
            gemmeRougeEmplacement.setImage(null);
            pillierRouge=null;
        }

        else if (mouseEvent.getSource() == gemmeBleuEmplacement && gemmeBleuEmplacement.getImage() == null && contientGemme() ) {
            gemmeBleuEmplacement.setImage(ItemId.gemmeBleue.getImage());
            pillierBleu= selected;
            MainSalleGroupe2.stepManager.getInventaire().retirerItem(selected);
        }

        else if (mouseEvent.getSource()==gemmeBleuEmplacement && gemmeBleuEmplacement.getImage()!=null ){
            MainSalleGroupe2.stepManager.getInventaire().ajouterItem(pillierBleu);
            gemmeBleuEmplacement.setImage(null);
            pillierBleu=null;
        }

        else if (mouseEvent.getSource() == gemmeVioletteEmplacement && gemmeVioletteEmplacement.getImage() == null && contientGemme() ) {
            gemmeVioletteEmplacement.setImage(ItemId.gemmeViolette.getImage());
            pillierViolet=selected;
            MainSalleGroupe2.stepManager.getInventaire().retirerItem(selected);
        }

        else if (mouseEvent.getSource()==gemmeVioletteEmplacement && gemmeVioletteEmplacement.getImage()!=null ){
            MainSalleGroupe2.stepManager.getInventaire().ajouterItem(pillierViolet);
            gemmeVioletteEmplacement.setImage(null);
            pillierViolet=null;
        }
        System.out.println(estGagnant());
    }

    public void tombage() {
       compteur ++;
       if (compteur >= 3){
           pilierGrand.setImage(null);
           pilierTombe.setVisible(true);
           tropHaut.setVisible(false);
           tropHaut.setDisable(true);
           textfield.setVisible(false);
           textfield.setDisable(true);
           gemmeVerte.setDisable(false);
           gemmeVerte.setVisible(true);
       }
    }

}
