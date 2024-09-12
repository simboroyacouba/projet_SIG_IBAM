# Application de localisation des services affiliés au Misnistère des Sports et des loisirs
Elle fonctionne avec springboot, postgres, postgis


## Prérequis

- Java 17
- Postgresql (14)
- Postgis (3.4.2)

## Installation

1. Clonez le dépôt :

   ```bash
   git clone https://github.com/simboroyacouba/projet_SIG_IBAM.git
   ```

2. Crééz la base de donnée :
   
   Crééz un utilisateur
   ```bash
      user_geoapp_groupe7
    ```
   avec le pot de passe
   ```bash
      pass22
   ```
   Crééz la base de donnée "geoapp_groupe7" ajoutez l'extension postgis et faite de l'utilisateur "user_geoapp_groupe7" le owner de la DB
  
   
4. Accédez au répertoire du projet :

   ```bash
   cd projet_SIG_IBAM
   ```

5. Lancez l'application avec Docker Compose :

   ```bash
       téléchargez les dépendances avec:
      "mvn install"
       Lancez l'application avec:
      "java -jar target/geoapp-0.0.1-SNAPSHOT.jar"
   ```

   Cela démarre l'application sur le port 5534.

6. Lancez l'application avec Docker Compose :
  
   ```bash
       Ouvrez votre navigateur et accedez à l'adresse:
       http://localhost:5534/
   ```

