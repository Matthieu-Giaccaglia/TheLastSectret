# The Last Secret



The Last Secret est un escape game réalisé par une classe d'étudiant en 1er année à l'IUT Informatique de Montpellier.

## Projects Status

Le projet est terminé.

## Contexte

Lors du 2ème semestre à l'IUT Informatique (de Montpellier), en classe entière, nous avons dû réaliser un escape game afin de mettre en oeuvre des concepts d'ergonomie.

Pour faciliter la création du jeu, nous nous sommes réparti en trois groupes et chaque une d'entre elles devait créer une salle avec des énigmes. Malheureusement, la dernière salle n'a pas pu être terminée à temps, c'est pourquoi la fin est assez spéciale.

## Documents et autres

Le .jar peut être lancé en téléchargeant Java JRE 1.8. Il se peut que sur Ubuntu que l'énigme avec la Boule a déplacer dans un labyrhinte ne fonctionne pas car l'OS a certains problème avec la 3D de JavaFX.
- [Le .jar](/target/TheLastSecret.jar) (>100 Mo)

## Installation

- [Java](https://www.java.com/fr/)
- Java 11 (Pour le développement)
- JavaFX 11 (Pour le développement)


## Installation avec IntellJ

*Nous avions utilisé que cet IDE pour le développement*

- Dans **File>Project Structure>Librairies**, ajouter le chemin du répertoire "lib" de javaFX 11
- Dans **File>Settings>Appearance & Behavior>Path Variables**, créer la variable PATH_TO_FX et y mettre le chemin du répertoire "lib" de javaFX.
- Dans la configuration du **RUN**, dans la section **VM options**, mettre **--module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml,javafx.media**

## Licence

Copyright [2020] [Beaucoup de personnes]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
