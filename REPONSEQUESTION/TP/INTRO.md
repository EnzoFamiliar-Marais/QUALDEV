# Rapport

## 1. Configuration de l'environnement de développement

Le projet fonctionne dans un environnement conteneurisé. Pour intégrer le devcontainer :

1. Charger le répertoire principal du projet dans **VS Code**
2. Accéder au widget **Dev Container** positionné dans le coin inférieur gauche
3. Choisir l'option **Reopen in Container** pour transférer le projet

## 2. Construction et configuration initiale

Après avoir accédé au devcontainer, compiler l'ensemble du projet avec la commande suivante :

```bash
gradle build
```

### 2.1. Initialisation du système de données

L'infrastructure PostgreSQL doit être configurée en accédant au conteneur pour exécuter les scripts d'installation.

1. En utilisant la machine hôte, afficher la liste des conteneurs actifs :

```bash
docker ps
```

Trouver et identifier l'instance PostgreSQL désignée par `orderflow_devcontainer-postgresql-1`.

2. Établir une session shell à l'intérieur du conteneur :

```bash
docker exec -it <container_id> bash
```

3. Ouvrir une session interactive avec PostgreSQL :

```bash
psql -U postgres
```

4. Mettre en place les schémas de base de données et l'utilisateur associé à l'application :

```sql
-- Create main application database
CREATE DATABASE order_flow;

-- Create user for application
CREATE USER order_flow WITH PASSWORD '${POSTGRES_ORDERFLOW_PASSWORD}';
GRANT ALL PRIVILEGES ON DATABASE order_flow TO order_flow;
```

Consulter le fichier `.devcontainer/.env` pour connaître la valeur à substituer à `${POSTGRES_ORDERFLOW_PASSWORD}`.

### 2.2. Configuration des allocations mémoire

Au préalable du lancement des services, procéder à l'affectation des ressources mémoire requises. Saisir la commande ci-dessous dans le terminal du devcontainer :

```bash
export GRADLE_OPTS="-Xmx512m"
```

## 3. Lancement des composants applicatifs

Il est nécessaire de lancer chaque service dans un terminal dédié et indépendant.

### 3.1. Service métier - Registre produit (écriture)

```bash
gradle -Dorg.gradle.jvmargs=-Xmx200m :apps:product-registry-domain-service:quarkusDev
```

### 3.2. Service métier - Registre produit (consultation)

```bash
gradle -Dorg.gradle.jvmargs=-Xmx200m :apps:product-registry-read-service:quarkusDev
```

### 3.3. Couche de médiation - API Backend

```bash
gradle -Dorg.gradle.jvmargs=-Xmx200m :apps:store-back:quarkusDev
```

### 3.4. Couche de présentation - Frontend

```bash
pnpm run --filter apps-store-front start
```

## 4. Mappage des ports

Accéder à l'interface de gestion du devcontainer, sélectionner **Add Port** et renseigner la configuration suivante :

```
127.0.0.1:8080
```

Cette configuration crée un pont de communication entre le port exposé par le conteneur et celui disponible sur le poste de travail.

## 5. Connexion à l'application

Après le démarrage complet de l'ensemble des services, accéder à l'application via l'URL ci-dessous :

[http://localhost:4200](http://localhost:4200)
