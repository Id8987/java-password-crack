# java-password-crack

Ce projet GitHub propose l'implémentation d'un crackeur de mots de passe utilisant le pattern Factory. Il comprend deux classes principales, **BruteForceCracker** et **DictionnaryCracker**, qui implémentent l'interface **PasswordInterface**. Une fabrique, **PasswordCrackerFactory**, est également fournie pour la création d'objets de type **DictionnaryCracker** ou **BruteForceCracker**.

## Fonctionnalités

- **PasswordInterface** : Cette interface définit les méthodes communes aux classes **BruteForceCracker** et **DictionnaryCracker**. Elle est utilisée dans l'application principale.

- **BruteForceCracker** : Cette classe implémente **PasswordInterface** et représente un crackeur de mot de passe par force brute. Elle utilise l'algorithme de force brute pour essayer toutes les combinaisons possibles de mots de passe.

- **DictionnaryCracker** : Cette classe implémente **PasswordInterface** et représente un crackeur de mot de passe basé sur un dictionnaire. Elle utilise un dictionnaire de mots pour essayer de trouver le mot de passe.

- **PasswordCrackerFactory** : Cette fabrique permet de créer des objets de type **DictionnaryCracker** ou **BruteForceCracker**, en fonction des besoins de l'application.

## Utilisation

L'application principale utilise **PasswordCracker** pour effectuer le crackage des mots de passe. Vous pouvez exécuter l'application en exécutant la fonction `main()` dans cette classe.

Le projet utilise également les classes **MD5** et **CombinaisonsCaracteres** pour une architecture propre. Ces classes contiennent des méthodes utilisées dans certaines des autres classes pour faciliter les opérations de hachage MD5 et la génération de combinaisons de caractères.

N'hésitez pas à explorer le code source pour plus de détails sur l'implémentation et les fonctionnalités offertes.

## Membres du projet

- Issakha Diouf
- Mor Talla Ba
