package fr.umontpellier.iut.commun.exceptions;

import java.io.IOException;

public class LayoutNotFoundException extends IOException {

    public LayoutNotFoundException(String layoutPath) {
        super("Le layout " + layoutPath + " n'a pas pu être chargé !");
    }
}
