package fr.umontpellier.iut.groupe2;

import fr.umontpellier.iut.groupe1.Main;
import fr.umontpellier.iut.groupe1.data.ImageLoader;
import fr.umontpellier.iut.groupe2.inventaire.ItemId;
import fr.umontpellier.iut.groupe2.view.StepID;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.nio.file.Paths;


public class SalleController {


    public StackPane allSalle;
    @FXML
    private ImageView retour, taquinImage;
    @FXML
    private Button lightoutButton;
    @FXML
    private ImageView fondSalle, fondSombre;
    @FXML
    private ImageView jarreGemme, jarreGemmePlein, jarreGemmeVide, jarreVideUn, jarreVideUnCassee, jarreMarteau, jarreMarteauOuvert, jarreMarteauVide, jarreVideDeux, jarreVideDeuxCassee;
    @FXML
    private ImageView porteGauche, porteDroite;
    @FXML
    private ImageView socleVert, gemmeVerteEmplacement, socleViolet, gemmeVioletteEmplacement, socleRouge, gemmeRougeEmplacement, socleBleu, gemmeBleuEmplacement;
    @FXML
    private ImageView lumiereUn, lumiereDeux, lumiereTrois, lumiereQuatre, lumiereCinq;
    @FXML
    private ImageView piece25Taquin;
    @FXML
    private ImageView gemmeVerte, gemmeTropHaute;
    @FXML
    private ImageView pilierGrand;
    @FXML
    private ImageView buttonMissing;
    @FXML
    private TextField textfield;

    private ItemId itemPilierVert = ItemId.gemmeRouge, itemPilierRouge, itemPilierBleu, itemPilierViolet;
    private int compteur = 0;

    private final Media soundGemmeOnPilar = new Media(Paths.get("src/main/resources/sound/groupe2/salle/soundGemmeOnPilar.mp3").toUri().toString());
    private final MediaPlayer soundPilierTombe = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe2/salle/soundPilierTombe.mp3").toUri().toString()));
    private final MediaPlayer soundOpenDoor = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe2/salle/soundOpenDoor.mp3").toUri().toString()));
    private final Media soundCasseJarre = new Media(Paths.get("src/main/resources/sound/groupe2/salle/soundCasseJarre.mp3").toUri().toString());
    private final MediaPlayer soundPilierMouv1 = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe2/salle/pilierBouge1.mp3").toUri().toString()));
    private final MediaPlayer soundPilierMouv2 = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe2/salle/pilierBouge2.mp3").toUri().toString()));
    private final Media soundPoussePorte = new Media(Paths.get("src/main/resources/sound/groupe2/salle/soundPoussePorte.mp3").toUri().toString());



    //private MediaPlayer mediaPlayer = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe2/musique/silenceRoom.mp3").toUri().toString()));


    public void changeScene(MouseEvent event) {
        if (event.getSource() == taquinImage) {
            MainSalleGroupe2.stepManager.openStep(StepID.TAQUIN);
        } else if (event.getSource() == lightoutButton) {
            MainSalleGroupe2.stepManager.openStep(StepID.LIGHTSOUT);
        } else if (event.getSource() == retour){
            MainSalleGroupe2.stepManager.openStep(StepID.START);
        }
    }

    public void gemmeTropHaute() {
        textfield.setVisible(true);
    }

    public void bouttonAllumer(){
        if(MainSalleGroupe2.stepManager.getInventaire().getItemIdSelection() == ItemId.boutonLumiere){
            if(fondSombre.isVisible()){
                fondSombre.setVisible(false);
                fondSombre.setDisable(true);
                new MediaPlayer(soundGemmeOnPilar).play();
                buttonMissing.setImage(ImageLoader.getImage("groupe2/lightsout/BRIQUE_1.png"));
                buttonMissing.setOpacity(1);
                MainSalleGroupe2.stepManager.getInventaire().retirerItem(ItemId.boutonLumiere);
            }
        }
    }


    public void recupItem(MouseEvent mouseEvent) {
        if (MainSalleGroupe2.stepManager.getInventaire().inventairePasPlein()){
            if (mouseEvent.getSource() == gemmeVerte) {
                MainSalleGroupe2.stepManager.getInventaire().ajouterItem(ItemId.gemmeVerte);
                gemmeVerte.setVisible(false);
            } else if (mouseEvent.getSource() == jarreGemmePlein) {
                MainSalleGroupe2.stepManager.getInventaire().ajouterItem(ItemId.gemmeViolette);
                jarreGemmePlein.setVisible(false);
                jarreGemmeVide.setVisible(true);
            } else if (mouseEvent.getSource() == piece25Taquin) {
                MainSalleGroupe2.stepManager.getInventaire().ajouterItem(ItemId.taquinPiece12);
                piece25Taquin.setVisible(false);
            } else if (mouseEvent.getSource() == jarreMarteauOuvert) {
                MainSalleGroupe2.stepManager.getInventaire().ajouterItem(ItemId.marteau);
                jarreMarteauOuvert.setVisible(false);
                jarreMarteauVide.setVisible(true);
            }
        }
    }


    public boolean estGagnant() {
        if (itemPilierVert == ItemId.gemmeVerte && itemPilierRouge == ItemId.gemmeRouge && itemPilierBleu == ItemId.gemmeBleue && itemPilierViolet == ItemId.gemmeViolette) {
            gemmeVerteEmplacement.setDisable(true);
            socleVert.setDisable(true);
            gemmeVioletteEmplacement.setDisable(true);
            socleViolet.setDisable(true);
            gemmeBleuEmplacement.setDisable(true);
            socleBleu.setDisable(true);
            gemmeRougeEmplacement.setDisable(true);
            socleRouge.setDisable(true);
            System.out.println("C'est gagné");
            return true;
        }
        return false;
    }

    public boolean contientGemme (){
        return MainSalleGroupe2.stepManager.getInventaire().getItemIdSelection() == ItemId.gemmeVerte || MainSalleGroupe2.stepManager.getInventaire().getItemIdSelection() == ItemId.gemmeViolette || MainSalleGroupe2.stepManager.getInventaire().getItemIdSelection() == ItemId.gemmeBleue || MainSalleGroupe2.stepManager.getInventaire().getItemIdSelection() == ItemId.gemmeRouge;
    }

    public void putGemme(MouseEvent mouseEvent) {


            if ((mouseEvent.getSource() == socleVert || mouseEvent.getSource() == gemmeVerteEmplacement)) {
                itemPilierVert = changeEtatPilier(gemmeVerteEmplacement, itemPilierVert);
            } else if ((mouseEvent.getSource() == socleViolet || mouseEvent.getSource() == gemmeVioletteEmplacement)) {
                itemPilierViolet = changeEtatPilier(gemmeVioletteEmplacement, itemPilierViolet);
            } else if ((mouseEvent.getSource() == socleBleu || mouseEvent.getSource() == gemmeBleuEmplacement)) {
                itemPilierBleu = changeEtatPilier(gemmeBleuEmplacement, itemPilierBleu);
            } else if ((mouseEvent.getSource() == socleRouge || mouseEvent.getSource() == gemmeRougeEmplacement)) {
                itemPilierRouge = changeEtatPilier(gemmeRougeEmplacement, itemPilierRouge);
            }
            changeEtatLumiere();

    }

    private ItemId changeEtatPilier(ImageView imageItemPilier, ItemId itemPilier){
        if (itemPilier == null  && contientGemme()) {
            ItemId selected = MainSalleGroupe2.stepManager.getInventaire().getItemIdSelection();
            MainSalleGroupe2.stepManager.getInventaire().retirerItem(selected);
            imageItemPilier.setImage(selected.getImage());
            new MediaPlayer(soundGemmeOnPilar).play();
            return selected;
        } else if (MainSalleGroupe2.stepManager.getInventaire().inventairePasPlein()) {
            MainSalleGroupe2.stepManager.getInventaire().ajouterItem(itemPilier);
            imageItemPilier.setImage(null);
            return null;
        } else {
            return itemPilier;
        }
    }

    private void changeEtatLumiere(){

        if (lumiereUn.isVisible() && itemPilierVert == ItemId.gemmeVerte){
            lumiereDeux.setVisible(true);
                if (itemPilierViolet == ItemId.gemmeViolette){
                    lumiereTrois.setVisible(true);
                        if (itemPilierBleu == ItemId.gemmeBleue){
                            lumiereQuatre.setVisible(true);
                                if (itemPilierRouge == ItemId.gemmeRouge){
                                    lumiereCinq.setVisible(true);
                                    animationPorte();
                                }
                        } else {
                            lumiereQuatre.setVisible(false);
                            lumiereCinq.setVisible(false);
                        }
                } else {
                    lumiereTrois.setVisible(false);
                    lumiereQuatre.setVisible(false);
                    lumiereCinq.setVisible(false);
                }
        } else {
            lumiereDeux.setVisible(false);
            lumiereTrois.setVisible(false);
            lumiereQuatre.setVisible(false);
            lumiereCinq.setVisible(false);
        }
    }

    private void animationPorte() {
        estGagnant();
        ParallelTransition parallelPorte = new ParallelTransition(translateTransition(porteGauche, -180,0, 9), translateTransition(porteDroite, 180,0, 9));
        soundOpenDoor.play();
        parallelPorte.playFromStart();
    }

    public void openDoorTry(){
        ParallelTransition parrelPorte = new ParallelTransition(translateTransition(porteGauche, -20,0, 6.5), translateTransition(porteDroite, 20,0, 6.5));
        new MediaPlayer(soundPoussePorte).play();
        allSalle.setDisable(true);
        parrelPorte.setOnFinished(event -> {
            allSalle.setDisable(false);
            ParallelTransition parrelPorte2 = new ParallelTransition(translateTransition(porteGauche, 20,0, 0.1), translateTransition(porteDroite, -20,0, 0.1));
            parrelPorte2.playFromStart();
        });
        parrelPorte.playFromStart();
    }

    private TranslateTransition translateTransition(ImageView porte, double x, double y, double temps){
        TranslateTransition tranlateTransition = new TranslateTransition(Duration.seconds(temps), porte);
        tranlateTransition.setByX(x);
        tranlateTransition.setByY(y);
        return tranlateTransition;
    }

    private void animationPilierTremblement(double x, double y) {
        ParallelTransition parallelPilier = new ParallelTransition(translateTransition(pilierGrand,x,y,0.5), translateTransition(gemmeTropHaute,x,y,0.5));
        parallelPilier.setCycleCount(2);
        parallelPilier.setAutoReverse(true);
        parallelPilier.play();
    }


    public void animationPilier() {
        compteur ++;
        if (compteur == 1){
            soundPilierMouv1.play();
            animationPilierTremblement(-2, -2);
        } else if(compteur == 2){
            soundPilierMouv2.play();
            animationPilierTremblement(-6, -6);
        } else if (compteur >= 3){
            animationPilierTombe();
        }
    }



    private void animationPilierTombe() {

        RotateTransition rotatePilierTombe = new RotateTransition(Duration.seconds(1.2), pilierGrand);
        rotatePilierTombe.setByAngle(-58);

        ScaleTransition scalePilierTombe = new ScaleTransition(Duration.seconds(1.2), pilierGrand);
        scalePilierTombe.setByX(-0.15);
        scalePilierTombe.setByY(-0.15);

        ParallelTransition parallelPilierTombe = new ParallelTransition(translateTransition(pilierGrand,-198,44,1), rotatePilierTombe, scalePilierTombe);
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



        parallelPilierTombe.setOnFinished(event -> gemmeVerte.setVisible(true));

        parallelPilierTombe.play();

        soundPilierTombe.play();
        textfield.setVisible(false);
        textfield.setDisable(true);
        pilierGrand.setDisable(true);
        gemmeTropHaute.setVisible(false);
        gemmeTropHaute.setDisable(true);
        gemmeVerte.setDisable(false);
        lumiereUn.setVisible(true);
    }


    public void casseJarre(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() == jarreGemme) {
            new MediaPlayer(soundCasseJarre).play();
            jarreGemme.setVisible(false);
            jarreGemmePlein.setVisible(true);
        } else if (mouseEvent.getSource() == jarreMarteau){
            new MediaPlayer(soundCasseJarre).play();
            jarreMarteau.setVisible(false);
            jarreMarteauOuvert.setVisible(true);
        } else if (mouseEvent.getSource() == jarreVideUn){
            new MediaPlayer(soundCasseJarre).play();
            jarreVideUn.setVisible(false);
            jarreVideUnCassee.setVisible(true);
        } else if (mouseEvent.getSource() == jarreVideDeux){
            new MediaPlayer(soundCasseJarre).play();
            jarreVideDeux.setVisible(false);
            jarreVideDeuxCassee.setVisible(true);
        }
    }


}
