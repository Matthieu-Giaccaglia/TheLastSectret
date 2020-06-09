package fr.umontpellier.iut.groupe2;

import fr.umontpellier.iut.groupe2.handlers.StepChangeRequest;
import fr.umontpellier.iut.groupe2.inventaire.ItemId;
import fr.umontpellier.iut.groupe2.lightsout.LightsOutController;
import fr.umontpellier.iut.groupe2.view.StepID;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.nio.file.Path;
import java.nio.file.Paths;


public class SalleController {

    @FXML
    private ImageView premierTrait, deuxTrait, troisTrait, quatreTrait, cinqTrait;
    @FXML
    private ImageView porte;
    @FXML
    private ImageView piece25Taquin;
    @FXML
    private ImageView gemmeVerteEmplacement, gemmeVioletteEmplacement,gemmeRougeEmplacement, gemmeBleuEmplacement;
    @FXML
    private ImageView gemmeRouge, gemmeViolette, gemmeVerte, gemmeTropHaute;
    @FXML
    private ImageView pilierGrand;
    @FXML
    private ImageView buttonMissing;
    @FXML
    private ImageView dark_Id;
    @FXML
    private Button buttonRetour, taquinButton, lightoutButton;
    @FXML
    private TextField textfield;

    private Media gemmePlacePillier = new Media(Paths.get("src/main/resources/sound/groupe2/salle/gemmePlace.mp3").toUri().toString());

    private ItemId itemPilierVert, itemPilierRouge, itemPilierBleu, itemPilierViolet;
    private int compteur = 0;

    private MediaPlayer soundPilierTombe = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe2/salle/soundPilierTombe.mp3").toUri().toString()));




    public SalleController() {
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe2/musique/silenceRoom.mp3").toUri().toString()));
        mediaPlayer.setAutoPlay(true);
    }


    public void handleButton(ActionEvent event) {

        System.out.println("ok");
        if (event.getSource() == taquinButton) {
            MainSalleGroupe2.stepManager.openStep(StepID.TAQUIN);
        } else if (event.getSource() == lightoutButton) {
            MainSalleGroupe2.stepManager.openStep(StepID.LIGHTSOUT);
        } else if (event.getSource() == buttonRetour){
            MainSalleGroupe2.stepManager.openStep(StepID.START);
        }
    }

    @FXML
    public void onClick() {
        textfield.setVisible(true);
    }

    public void bouttonRajoute(){
        if(MainSalleGroupe2.stepManager.getInventaire().getItemIdSelection() == ItemId.boutonLumiere){
            if(dark_Id.isVisible()){
                dark_Id.setVisible(false);
                buttonMissing.setOpacity(1);
                MainSalleGroupe2.stepManager.getInventaire().retirerItem(ItemId.boutonLumiere);
            }
        }
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
            System.out.println("C'est gagné");
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

    private ItemId changeEtatPilier(ItemId itemAddInventaire, ImageView imageViewPilier, boolean ajoutItem){
        if (!ajoutItem) {
            MainSalleGroupe2.stepManager.getInventaire().ajouterItem(itemAddInventaire);
            imageViewPilier.setImage(null);
            return null;
        } else {
            MainSalleGroupe2.stepManager.getInventaire().retirerItem(itemAddInventaire);
            imageViewPilier.setImage(itemAddInventaire.getImage());
            new MediaPlayer(gemmePlacePillier).play();
            return itemAddInventaire;
        }
    }

    private void allumeToi(){

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

    private void eteinsToi(){

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


    public void animationPilier() {
        compteur ++;
        animationPilierTremblement();
        if (compteur >= 3){
            animationPilierTombe();
        }
    }



    private void animationPilierTombe() {
        TranslateTransition translatePilierTombe = new TranslateTransition(Duration.seconds(1.3),pilierGrand);
        translatePilierTombe.setByX(-232);
        translatePilierTombe.setByY(44);

        RotateTransition rotatePilierTombe = new RotateTransition(Duration.seconds(1.3), pilierGrand);
        rotatePilierTombe.setByAngle(-39.8);

        ScaleTransition scalePilierTombe = new ScaleTransition(Duration.seconds(1.3), pilierGrand);
        scalePilierTombe.setByX(-0.1);
        scalePilierTombe.setByY(-0.1);

        ParallelTransition parallelPilierTombe = new ParallelTransition(translatePilierTombe, rotatePilierTombe, scalePilierTombe);
        parallelPilierTombe.setInterpolator(new Interpolator() {

            private double factor = 1.25;
            private final double min = 0;
            private final double max = (1 - Math.sin(Math.PI / 2d + factor * Math.PI)) / 2d;

            @Override
            protected double curve(double v) {
                double sin = Math.sin(Math.PI / 2d + v * factor * Math.PI);
                sin = (1 - sin) / 2d;
                sin = sin / (max - min);
                return sin;
            }
        });
        parallelPilierTombe.setRate(-1);


        parallelPilierTombe.setOnFinished(event -> {
            gemmeVerte.setVisible(true);
            piece25Taquin.setVisible(true);
        });



        parallelPilierTombe.playFromStart();

        soundPilierTombe.play();
        textfield.setVisible(false);
        textfield.setDisable(true);
        pilierGrand.setDisable(true);
        gemmeTropHaute.setVisible(false);
        gemmeTropHaute.setDisable(true);
        gemmeVerte.setDisable(false);
        premierTrait.setVisible(true);
    }

    private void animationPilierTremblement() {
        TranslateTransition translatePilier = new TranslateTransition(Duration.seconds(0.1),pilierGrand);
        translatePilier.setByX(-2);
        translatePilier.setByY(-2);

        TranslateTransition translateGemmeVerte = new TranslateTransition(Duration.seconds(0.1),gemmeTropHaute);
        translateGemmeVerte.setByX(-2);
        translateGemmeVerte.setByY(-2);

        ParallelTransition parallelPilier = new ParallelTransition(translatePilier, translateGemmeVerte);
        parallelPilier.setCycleCount(2);
        parallelPilier.setAutoReverse(true);
        parallelPilier.play();
    }


    public void recupPieceTaquin() {

        MainSalleGroupe2.stepManager.getInventaire().ajouterItem(ItemId.taquinPiece12);
        piece25Taquin.setVisible(false);
    }
}
