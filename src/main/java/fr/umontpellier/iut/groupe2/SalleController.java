package fr.umontpellier.iut.groupe2;

import fr.umontpellier.iut.groupe2.handlers.StepChangeRequest;
import fr.umontpellier.iut.groupe2.inventaire.ItemId;
import fr.umontpellier.iut.groupe2.lightsout.LightsOutController;
import fr.umontpellier.iut.groupe2.view.StepID;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.nio.file.Paths;


public class SalleController {

    public ImageView cinqTrait;
    public ImageView quatreTrait;
    public ImageView troisTrait;
    public ImageView deuxTrait;
    public ImageView premierTrait;
    public ImageView porte;
    @FXML
    private ImageView gemmeVerteEmplacement, gemmeVioletteEmplacement,gemmeRougeEmplacement, gemmeBleuEmplacement;
    @FXML
    private ImageView gemmeRouge, gemmeViolette, gemmeVerte, gemmetropHaute;
    @FXML
    private ImageView pilierGrand, pilierTombe;

    private ItemId itemPilierVert, itemPilierRouge, itemPilierBleu, itemPilierViolet;
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

    private final LightsOutController lightsOutController = new LightsOutController();

    public SalleController() {
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(Paths.get("src/main/resources/raw/groupe2/silenceRoom.mp3").toUri().toString()));
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
        if (itemPilierVert == ItemId.gemmeVerte && itemPilierRouge == ItemId.gemmeRouge && itemPilierBleu == ItemId.gemmeBleue && itemPilierViolet == ItemId.gemmeViolette) {
            gemmeVerteEmplacement.setDisable(true);
            gemmeVioletteEmplacement.setDisable(true);
            gemmeBleuEmplacement.setDisable(true);
            gemmeRougeEmplacement.setDisable(true);
            TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(2.0), porte);
            translateTransition.setByY(-500);
            translateTransition.play();
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
            itemPilierVert = changeEtatPilier(selected, gemmeVerteEmplacement,true);
            allumeToi();
        } else if (mouseEvent.getSource()==gemmeVerteEmplacement && gemmeVerteEmplacement.getImage()!=null ){
            itemPilierVert = changeEtatPilier(itemPilierVert, gemmeVerteEmplacement,false);
            eteinsToi();
        }  else if (mouseEvent.getSource() == gemmeVioletteEmplacement && gemmeVioletteEmplacement.getImage() == null && contientGemme() ) {
            itemPilierViolet = changeEtatPilier(selected, gemmeVioletteEmplacement, true);
            allumeToi();
        } else if (mouseEvent.getSource()==gemmeVioletteEmplacement && gemmeVioletteEmplacement.getImage()!=null ){
            itemPilierViolet = changeEtatPilier(itemPilierViolet, gemmeVioletteEmplacement, false);
            eteinsToi();
        } else if (mouseEvent.getSource() == gemmeBleuEmplacement && gemmeBleuEmplacement.getImage() == null && contientGemme() ) {
            itemPilierBleu = changeEtatPilier(selected, gemmeBleuEmplacement, true);
            allumeToi();
        } else if (mouseEvent.getSource()==gemmeBleuEmplacement && gemmeBleuEmplacement.getImage()!=null ){
            itemPilierBleu = changeEtatPilier(itemPilierBleu, gemmeBleuEmplacement, false);
            eteinsToi();
        }else if (mouseEvent.getSource() == gemmeRougeEmplacement && gemmeRougeEmplacement.getImage() == null && contientGemme()) {
            itemPilierRouge = changeEtatPilier(selected, gemmeRougeEmplacement,true);
            allumeToi();
        } else if (mouseEvent.getSource()==gemmeRougeEmplacement && gemmeRougeEmplacement.getImage()!=null ) {
            itemPilierRouge = changeEtatPilier(itemPilierRouge, gemmeRougeEmplacement, false);
        }
        System.out.println(estGagnant());
    }

    public ItemId changeEtatPilier(ItemId itemAddInventaire, ImageView imageViewPilier, boolean ajoutItem){
        if (!ajoutItem) {
            MainSalleGroupe2.stepManager.getInventaire().ajouterItem(itemAddInventaire);
            imageViewPilier.setImage(null);
            return null;
        } else {
            MainSalleGroupe2.stepManager.getInventaire().retirerItem(itemAddInventaire);
            imageViewPilier.setImage(itemAddInventaire.getImage());
            return itemAddInventaire;
        }
    }

    public void allumeToi(){

        if(premierTrait.isVisible() && itemPilierVert == ItemId.gemmeVerte){
            deuxTrait.setVisible(true);
            if (itemPilierViolet == ItemId.gemmeViolette){
                troisTrait.setVisible(true);
                if (itemPilierBleu == ItemId.gemmeBleue){
                    quatreTrait.setVisible(true);
                    if(itemPilierRouge == ItemId.gemmeRouge){
                        cinqTrait.setVisible(true);
                    }
                }
            }
        }
    }

    public void eteinsToi(){

        if (troisTrait.isVisible() && itemPilierBleu != ItemId.gemmeBleue){
            quatreTrait.setVisible(false);
        }
        if(deuxTrait.isVisible() && itemPilierViolet != ItemId.gemmeViolette){
            troisTrait.setVisible(false);
            quatreTrait.setVisible(false);
        }
        if(premierTrait.isVisible() && itemPilierVert != ItemId.gemmeVerte){
            deuxTrait.setVisible(false);
            troisTrait.setVisible(false);
            quatreTrait.setVisible(false);
        }
    }




    public void tombage() {
       compteur ++;
       if (compteur >= 3){
           pilierGrand.setImage(null);
           pilierTombe.setVisible(true);
           gemmetropHaute.setVisible(false);
           gemmetropHaute.setDisable(true);
           textfield.setVisible(false);
           textfield.setDisable(true);
           gemmeVerte.setDisable(false);
           gemmeVerte.setVisible(true);
           premierTrait.setVisible(true);
       }
    }



}
