# Application de localisation des services affiliés au Misnistère des Sports et des loisirs
Elle fonctionne avec springboot, postgres, postgis


## Prérequis

- Java 17
- maven 3.9
- Postgresql (14)
- Postgis (3.4.2)

## Installation

1. Clonez le dépôt :

   ```bash
   git clone https://github.com/simboroyacouba/projet_SIG_IBAM.git
   ```

2. Crééz la base de donnée :
   
   - Crééz un utilisateur
   ```bash
      user_geoapp_groupe7
    ```
   avec le mot de passe
   ```bash
      pass22
   ```
   - Crééz la base de donnée
   ```bash
      geoapp_groupe7 
   ```
   - ajoutez l'extension postgis et faite de l'utilisateur "user_geoapp_groupe7" le owner de la DB
  
   
3. Accédez au répertoire du projet :

   ```bash
      cd projet_SIG_IBAM
   ```

4. Lancez l'application avec Docker Compose :

   - Téléchargez les dépendances avec:
   ```bash
      mvn install
   ```
   - Lancez l'application avec:
   ```bash
      java -jar target/geoapp-0.0.1-SNAPSHOT.jar
   ```
   Cela démarre l'application sur le port 5534.

6. Lancez l'application :
  
   Ouvrez votre navigateur et accedez à l'adresse:
   
   ```bash
       http://localhost:5534/
   ```

