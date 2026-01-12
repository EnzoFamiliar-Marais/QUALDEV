# TP Exercice 1: Analyser l'application

## Tâche 1 : Questions

1. Quels sont les principaux domaines métiers de l'application Order flow ?

L'application Order flow s'articule autour d'un domaine primaire **OnlineShoppingDomain** qui facilite les transactions commerciales en ligne. Ce domaine central se subdivise en plusieurs sous-domaines spécialisés :

- **ProductCatalogDomain** : Gestion et organisation du catalogue de produits disponibles
- **ProductRegistryDomain** : Maintien d'un registre global des produits
- **StockDomain** : Gestion des inventaires et réservation des articles
- **CustomerDomain** : Gestion des profils et comptes clients
- **CustomerNotificationDomain** : Envoi de notifications personnalisées aux clients
- **NotificationDomain** : Système générique d'envoi de messages
- **ShoppingCartDomain** : Gestion des paniers et sessions d'achat
- **OrderProcessingDomain** : Traitement et suivi des commandes
- **BillingDomain** : Gestion de la facturation et des invoices

2. Comment les services sont-ils conçus pour implémenter les domaines métiers ?

L'architecture repose sur une approche hybride combinant microservices et bibliothèques partagées :

**Microservices domaine-spécifiques** (`apps/`) :
- `product-registry-domain-service` : Traite les opérations d'écriture sur le registre des produits
- `product-registry-read-service` : Gère les requêtes de lecture du registre
- `store-back` : API backend interrogeant les services métiers
- `store-front` : Interface utilisateur Angular

**Bibliothèques transversales** (`libs/`) :
- `kernel` : Fournit les primitives de base (entités, agrégats, value objects)
- `bom-platform` : Centralise et harmonise les dépendances
- `cqrs-support` : Implémente les patterns de commande et événement
- `sql` : Abstractions et migrations de base de données

3. Quelles sont les responsabilités des modules ?

Chaque composant de l'architecture remplit un rôle spécifique :

- `apps/store-back` : Orchestrateur central qui agrège les données des services spécialisés pour fournir des APIs cohérentes aux clients
- `apps/store-front` : Couche de présentation développée en Angular
- `libs/kernel` : Définit les concepts fondamentaux du domaine (entités, agrégats, règles métier)
- `apps/product-registry-domain-service` : Service maître pour les modifications du registre produit
- `apps/product-registry-read-service` : Service optimisé pour les consultations
- `libs/bom-platform` : Gestionnaire de dépendances assurant l'homogénéité des versions
- `libs/cqrs-support` : Framework facilitant la séparation commande/requête et la gestion d'événements
- `libs/sql` : Gestion déclarative des schémas et des évolutions de base de données

## Tâche 2 : Questions

1. Quels sont les concepts principaux utilisés dans l'application Order flow ?

L'application repose sur trois piliers architecturaux fondamentaux :

- **Domain-Driven Design (DDD)** : L'ensemble de la structure reflète une décomposition claire en domaines métier avec leurs propres entités, agrégats et processus
- **Communication asynchrone et API REST** : Les services interagissent via des interfaces HTTP standardisées
- **Gestion structurée des erreurs** : Un système cohérent de gestion des exceptions et cas d'erreur

2. Comment les concepts principaux sont-ils implémentés dans les différents modules ?

Ces concepts architecturaux trouvent leur expression concrète à travers :

- **Structure modulaire par domaine** : Chaque métier métier dispose d'une unité de code autonome, reflétant l'univers métier qu'elle représente
- **Primitives partagées** : Les abstractions DDD (entités, agrégats) sont centralisées dans `libs/kernel` et réutilisées systématiquement
- **Patterns de communication** : Les appels REST via `apps/store-back` orchestrent les échanges entre domaines de manière découplée

3. Que fait la bibliothèque `libs/cqrs-support` ? Comment est-elle utilisée dans les autres modules (relation entre métier et structure du code) ?

`libs/cqrs-support` implémente le pattern CQRS (Command Query Responsibility Segregation). Elle découple clairement les flux de modification (commandes) des flux de consultation (requêtes), en isolant la logique applicative de sa persistance et de la propagation d'événements. Cette séparation permet aux autres modules de traiter les mutations métier indépendamment de leur projection en lecture. 

4. Que fait la bibliothèque `libs/bom-platform` ?

`libs/bom-platform` fonctionne comme un gestionnaire centralisé de dépendances. Elle définit et maintient les versions compatibles de toutes les bibliothèques du projet, garantissant que chaque module utilise les mêmes itérations et évitant les incompatibilités de versions. 

5. Comment l'implémentation actuelle du CQRS et du Kernel assure-t-elle la fiabilité des états internes de l'application ?

La fiabilité est garantie par plusieurs mécanismes complémentaires :

- **Validation métier stricte** : `libs/kernel` impose des règles de validation rigoureuses au niveau des entités et agrégats, empêchant les états invalides dès leur création
- **Gestion transactionnelle d'événements** : Les commandes et événements orchestrent les mutations d'état de manière atomique, assurant la cohérence des changements
- **Isolation lecture-écriture** : La séparation CQRS limite les interférences entre les opérations, réduisant les risques de race conditions et d'incohérences