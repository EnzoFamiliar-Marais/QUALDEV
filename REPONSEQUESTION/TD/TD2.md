# TD2 : Gérer un dépôt de code

## Les méthodes de gestion
Définissez au mieux les méthodes de gestion suivantes :
(Aidez-vous du CM2 et des outils de recherche)
- Git Trunk
- Git Flow

- Indiquez les cas d’usage typique de chaque méthode et leurs avantages et inconvénients.

Les deux méthodes de gestion de code source, Git Trunk et Git Flow, sont utilisées pour organiser le développement logiciel, mais elles ont des approches différentes.

Deux approches fondamentales pilotent la gestion du code source via Git : Git Trunk et Git Flow. Quoiqu'elles visent à structurer le développement logiciel, leurs principes et démarches s'opposent radicalement.

Git Trunk est une méthode où tous les développeurs intègrent fréquemment leurs modifications dans une branche principale unique (trunk). Cette méthode est idéale pour les équipes qui pratiquent l’intégration continue et le déploiement continu (CI/CD). Les avantages incluent une réduction des conflits de fusion, une livraison plus rapide des fonctionnalités, et une meilleure collaboration entre les membres de l’équipe. Cependant, elle peut être difficile à gérer pour les grandes équipes ou les projets complexes, car elle nécessite une discipline rigoureuse pour maintenir la stabilité du code.
Git Trunk représente une stratégie de fusion immédiate : chaque contributeur transmet régulièrement ses altérations au sein d'une unique branche maîtresse (trunk). Cette approche bénéficie aux structures pratiquant l'intégration continue et la distribution automatisée (CI/CD). Elle génère des profits appréciables : diminution prononcée des frictions lors des mariages de branches, accélération de la mise en œuvre des capacités nouvelles, et cohésion accrue du personnel. En contrepartie, son déploiement demeure épineux pour les organismes volumineux ou les projets considérables, exigeant une constance inflexible pour garantir la solidité du code.
Git Flow, en revanche, utilise plusieurs branches pour organiser le développement, y compris des branches pour les fonctionnalités, les releases, et les hotfixes. Cette méthode est adaptée aux projets avec des cycles de développement plus longs et des équipes plus grandes. Les avantages de Git Flow incluent une meilleure organisation du code, une gestion claire des versions, et la possibilité de travailler sur plusieurs fonctionnalités en parallèle. Cependant, elle peut entraîner des conflits de fusion plus fréquents et une complexité accrue dans la gestion des branches.

Git Flow procède par antagonisme en tirant parti d'un assemblage multi-ramifié : des sections destinées aux capacités inédites, d'autres pour la maturation des éditions, et des tronçons pour les réparations d'urgence. Ce système s'avère approprié pour les entreprises opérant sur des délais étendus et disposant d'équipes étoffées. Il apporte des bénéfices considérables : organisation hiérarchisée du code, administration rigoureuse des versions, et aptitude à progresser en parallèle sur diverses capacités. Son principal revers : l'accroissement des frictions lors des mariages et une manipulation des ramifications plus laborieuse.


## Git Trunk

- Définissez le feature-flags (aussi appelé feature-toggles)

Les feature-flags forment un dispositif de basculement permettant d'enclencher ou d'interrompre sélectivement certains éléments fonctionnels d'une application, exempt de tout renouvellement du code déployé. Cet appareil procure aux organismes de conception la possibilité de produire des modules inachevés ou en phase de validation en milieu opérationnel, tout en disposant du contrôle pour en moduler la disponibilité selon les besoins.

- Indiquez les moyens usuels d’implémenter du feature-flags
1. Recourir à des frameworks spécialisés tel que LaunchDarkly ou Unleash.
2. Recourir à des paramètres d'exploitation ou à des dossiers d'optimisation.
3. Placer la condition des feature-flags dans un entrepôt informatique.

- Décrire le flux de travail du Trunk-Based Repository

Le Trunk-Based Development (TBD) gravite autour d'une méthode dans laquelle chaque agent pousse périodiquement ses perfectionnements en direction d'une ramification primaire singulière, appellation "trunk" ou "main". Cette démarche s'établit sur la livraison d'ajustements restreints à cadence rapide (maintes occasions par jour calendaire) et s'assoit sur un ensemble de vérifications programmées pour éprouver la fiabilité du système. Les feature-flags endossent une fonction décisive en facilitant l'offre de fonctionnels partiels sans affecter les bénéficiaires ultimes.

## Git flow

- Décrire le flux de travail du Git Flow

Le Git Flow expose un système d'organisation du répertoire de code s'organisant autour de nomenclatures branchées plurielles : la ramification de gouvernance (main/master) hébergeant le système opérationnel, une ramification de progressement (develop) contenant les évolutions en chantier, des tronçons pour les capacités inédites (feature branches) destinés à l'édification de nouveaux modules, des ramifications de rectification pour l'ajustement des insuffisances, et des canaux de réparation pour l'intervention immédiate des défectuosités graves en service effectif. Ces sections fusionnent en conformité à des procédures établies afin de sauvegarder la sûreté et la pérennité du système d'ingénierie.

- Décrire la méthode préférée pour gérer plusieurs versions majeures/mineures en parallèle

Afin de diriger concurremment plusieurs générations substantielles et secondaires au travers du Git Flow, l'approche conseillée s'établit sur l'institution de ramifications d'affinement propres à chaque génération et de tronçons de réparation vouées aux interventions pressantes. Tout génération dispose de sa propre ramification d'acheminement, tandis que les actes essentiels se manifestent dans des ramifications de réparation émanant de la ramification gouvernante. Une fois finalisées, ces générations se regroupent au sein de la ramification de gouvernance (main ou master conformément aux dispositions) et de la ramification de progressement, pourvues d'une désignation manifeste pour chaque génération.

## Noms de branche (GitFlow)

Donnez les noms de branches correspondant aux situations suivantes :

- Une fonctionnalité « Gestion des utilisateurs – suppression » (ticket n°B-768) :
`feature/B-768-gestion-des-utilisateurs-suppression`

- Un fix « Mauvaise redirection après ajout d’un email à l’utilisateur » (ticket A-46) :
`fix/A-46-mauvaise-redirection-apres-ajout-email`

- L’ajout d’une configuration « devcontainer » pour l’environnement de développement :
`feature/devcontainer-configuration`

- Un hotfix pour préparer un patch depuis une version 1.3.1 :
`hotfix/1.3.1-patch`

- Une release mineure après 1.4.17 :
`release/1.4.18`

- Une branche support après release 12.5.6 (support version mineure) :
`support/12.5`

## Commit messages

Exposez les données essentielles qu'un message de commit doit communiquer instantanément
(composantes fondamentales et souhaitées).

Voici plusieurs messages de commit :

```
feat[B-658]: side-menu statistics page link

+ adding a side menu item
+ adding a static link to the stats page
~ making various minor fixes on CSS

Co-author : Kamel Debbiche
Refs: https://doc.myapp.acompany.net/gui-rules/
```

```
docs[A-245]: C4 modeling – books micro-service

+ init structurizr file (..books.service.structurizr)
- removing outdated ADL and documentation
```

```
chore!: drop support of PHP 7

BREAKING CHANGE: use PHP features not available in PHP 7
```

```
feat: add French language support with i18n
```

Identifier les éléments un à un et déterminer leur caractère obligatoire ou optionnel. Enfin, déterminez une structure générale applicable à cet ensemble.

Un libellé de commit productif doit englober les constituants suivants :
1. Catégorie du commit (fondamental) : Classe la nature de l'intervention (illustrations : feature, fix, release, etc.) 
2. Renvoi au ticket (accessoire) : Rattache le commit à une mission précise 
3. Énoncé abrégé (fondamental) : Synthétise l'intervention effectuée 
4. Approfondissements (accessoire) : Augmente le contexte de l'intervention 
5. Co-contributeur (accessoire) : Identifie les collaborateurs supplémentaires 
6. Connexions (accessoire) : Pointeurs vers les ressources documentaires ou les missions afférentes 
7. Signalement de rupture (accessoire) : Avertit si le commit apporte des évolutions incompatibles 

Énumérez les catégories de commit accessibles et présentez leur application.

Les catégories de commit disponibles regroupent :
- feature : destinée aux capacités inédites 
- fix : réservée aux remédiation de défaillances 
- release : affectée aux préparatifs de nouvelles éditions 
- hotfix : appropriée aux interventions pressantes en environnement live 

Qu’est qu’un breaking-change ?

Un breaking change symbolise une transformation au sein du code incompatible avec les éditions antérieures, pouvant engendrer des anomalies ou des défaillances pour les utilisateurs ou les contributeurs se référant à l'ancienne édition.

## Semantic versioning

REF : https://semver.org/lang/fr/

Exposez en français les numérotations de version en fonction des éditions proposées :
- 1.1.0 : `Édition secondaire initiale succédant à la version primaire 1.0.0, comprenant des capacités inédites demeurant compatibles avec l'édition antérieure`
- 1.0.0-RC.2 : `Deuxième édition candidate (Release Candidate) pour la version primaire 1.0.0, prédessinée à l'expérimentation préalable au lancement officiel`
- 1.0.0-snapshot+build.9cbd45f6 : `Édition fugitive (snapshot) de la version 1.0.0, englobant un marqueur de compilation singulier`
- 3.0.0-beta.1 : `Édition béta initiale pour la version primaire 3.0.0, prédessinée à l'expérimentation antérieure au lancement officiel`
- 2.3.1+nightly.230524.0114 : `Édition 2.3.1 adjointe d'une compilation nocturne (intégration continue) horodatée du 24 mai 2023 à 01:14`


