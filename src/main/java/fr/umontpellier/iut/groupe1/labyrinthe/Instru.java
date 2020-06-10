package fr.umontpellier.iut.groupe1.labyrinthe;



import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Instru {
    public int volume = 100;

    private Synthesizer synthetiseur;
    private final MidiChannel canal;

    public Instru(){

        try {
            //On récupère le synthétiseur, on l'ouvre et on obtient un canal
            synthetiseur = MidiSystem.getSynthesizer();
            synthetiseur.open();
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(Instru.class.getName()).log(Level.SEVERE,null,ex);
        }

        canal = synthetiseur.getChannels()[0];

        //On initialise l'instrument 0 (le piano) pour le canal
        canal.programChange(0);
    }
    //note_on : Joue la note dont le numéro est en paramètre
    public void note_on(int note){canal.noteOn(note,volume);}
    //note_off : Stop la note dont le numéro est en paramètre
    public void note_off(int note){canal.noteOff(note,volume);}
    //Set le type d'instrument joué avec le code MIDI
    public void set_instrument(int instru) {canal.programChange(instru);}
}

