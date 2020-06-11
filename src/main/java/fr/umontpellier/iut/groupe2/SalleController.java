package fr.umontpellier.iut.groupe2;

import fr.umontpellier.iut.groupe2.inventaire.ItemId;
import fr.umontpellier.iut.groupe2.view.StepID;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.*;
import javafx.util.Duration;

import java.nio.file.Paths;


public class SalleController {


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

    private Media gemmePlacePillier = new Media(Paths.get("src/main/resources/sound/groupe2/salle/gemmePlace.mp3").toUri().toString());
    private MediaPlayer soundPilierTombe = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe2/salle/soundPilierTombe.mp3").toUri().toString()));
    private Media soundCasseJarre = new Media(Paths.get("src/main/resources/sound/groupe2/salle/casseJarre.mp3").toUri().toString());

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

    public void bouttonRajoute(){
        if(MainSalleGroupe2.stepManager.getInventaire().getItemIdSelection() == ItemId.boutonLumiere){
            if(fondSombre.isVisible()){
                fondSombre.setVisible(false);
                new MediaPlayer(gemmePlacePillier).play();
                buttonMissing.setOpacity(1);
                MainSalleGroupe2.stepManager.getInventaire().retirerItem(ItemId.boutonLumiere);
            }
        }
    }


    public void recupItem(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() == gemmeVerte) {
            MainSalleGroupe2.stepManager.getInventaire().ajouterItem(ItemId.gemmeVerte);
            gemmeVerte.setVisible(false);
        }  else if (mouseEvent.getSource() == jarreGemmePlein) {
            MainSalleGroupe2.stepManager.getInventaire().ajouterItem(ItemId.gemmeViolette);
            jarreGemmePlein.setVisible(false);
            jarreGemmeVide.setVisible(true);
        } else if (mouseEvent.getSource() == piece25Taquin){
            MainSalleGroupe2.stepManager.getInventaire().ajouterItem(ItemId.taquinPiece12);
            piece25Taquin.setVisible(false);
        } else if (mouseEvent.getSource() == jarreMarteauOuvert){
            MainSalleGroupe2.stepManager.getInventaire().ajouterItem(ItemId.marteau);
            jarreMarteauOuvert.setVisible(false);
            jarreMarteauVide.setVisible(true);
        }
    }


    public boolean estGagnant() {
        if (itemPilierVert == ItemId.gemmeVerte && itemPilierRouge == ItemId.gemmeRouge && itemPilierBleu == ItemId.gemmeBleue && itemPilierViolet == ItemId.gemmeViolette) {
            gemmeVerteEmplacement.setDisable(true);
            gemmeVioletteEmplacement.setDisable(true);
            gemmeBleuEmplacement.setDisable(true);
            gemmeRougeEmplacement.setDisable(true);
            System.out.println("C'est gagné");
            return true;
        }
        return false;
    }

    public boolean contientGemme (){
        return MainSalleGroupe2.stepManager.getInventaire().getItemIdSelection() == ItemId.gemmeVerte || MainSalleGroupe2.stepManager.getInventaire().getItemIdSelection() == ItemId.gemmeViolette || MainSalleGroupe2.stepManager.getInventaire().getItemIdSelection() == ItemId.gemmeBleue || MainSalleGroupe2.stepManager.getInventaire().getItemIdSelection() == ItemId.gemmeRouge;
    }

    public void putGemme(MouseEvent mouseEvent) {

        if ((mouseEvent.getSource() == socleVert || mouseEvent.getSource() == gemmeVerteEmplacement )){
            itemPilierVert = changeEtatPilier(gemmeVerteEmplacement, itemPilierVert);
        } else if ((mouseEvent.getSource() == socleViolet || mouseEvent.getSource() == gemmeVioletteEmplacement )) {
            itemPilierViolet = changeEtatPilier(gemmeVioletteEmplacement, itemPilierViolet);
        } else if (( mouseEvent.getSource() == socleBleu || mouseEvent.getSource() == gemmeBleuEmplacement )) {
            itemPilierBleu = changeEtatPilier(gemmeBleuEmplacement, itemPilierBleu);
        } else if (( mouseEvent.getSource() == socleRouge || mouseEvent.getSource() == gemmeRougeEmplacement )) {
            itemPilierRouge = changeEtatPilier(gemmeRougeEmplacement, itemPilierBleu);
        }
        changeEtatLumiere();
    }

    private ItemId changeEtatPilier(ImageView imageItemPilier, ItemId itemPilier){
        if (imageItemPilier.getImage() == null  && contientGemme()) {
            ItemId selected = MainSalleGroupe2.stepManager.getInventaire().getItemIdSelection();
            MainSalleGroupe2.stepManager.getInventaire().retirerItem(selected);
            imageItemPilier.setImage(selected.getImage());
            new MediaPlayer(gemmePlacePillier).play();
            return selected;
        } else {
            MainSalleGroupe2.stepManager.getInventaire().ajouterItem(itemPilier);
            imageItemPilier.setImage(null);
            return null;
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
        ParallelTransition parallelPorte = new ParallelTransition(translateTransition(porteGauche, -180,0, 1.1), translateTransition(porteDroite, 180,0, 1.1));
        parallelPorte.playFromStart();
    }

    private TranslateTransition translateTransition(ImageView porte, double x, double y, double temps){
        TranslateTransition tranlateTransition = new TranslateTransition(Duration.seconds(temps), porte);
        tranlateTransition.setByX(x);
        tranlateTransition.setByY(y);
        return tranlateTransition;
    }

    private void animationPilierTremblement() {
        ParallelTransition parallelPilier = new ParallelTransition(translateTransition(pilierGrand,-2,-2,0.1), translateTransition(gemmeTropHaute,-2,-2,0.1));
        parallelPilier.setCycleCount(2);
        parallelPilier.setAutoReverse(true);
        parallelPilier.play();
    }


    public void animationPilier() {
        compteur ++;
        animationPilierTremblement();
        if (compteur >= 3){
            animationPilierTombe();
        }
    }



    private void animationPilierTombe() {

        RotateTransition rotatePilierTombe = new RotateTransition(Duration.seconds(1), pilierGrand);
        rotatePilierTombe.setByAngle(-39.8);

        ScaleTransition scalePilierTombe = new ScaleTransition(Duration.seconds(1), pilierGrand);
        scalePilierTombe.setByX(-0.1);
        scalePilierTombe.setByY(-0.1);

        ParallelTransition parallelPilierTombe = new ParallelTransition(translateTransition(pilierGrand,-232,44,1), rotatePilierTombe, scalePilierTombe);
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



        parallelPilierTombe.setOnFinished(event -> {
            Path path = new Path(
                    new MoveTo(0, 0),
                    new QuadCurveTo(-10, 50, -300, 200)
                    );

            PathTransition pathTransition = new PathTransition(Duration.seconds(1),path,gemmeTropHaute);
            pathTransition.play();

            gemmeVerte.setVisible(true);
            piece25Taquin.setVisible(true);
        });

        parallelPilierTombe.play();

        soundPilierTombe.play();
        textfield.setVisible(false);
        textfield.setDisable(true);
        pilierGrand.setDisable(true);
        //gemmeTropHaute.setVisible(false);
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
