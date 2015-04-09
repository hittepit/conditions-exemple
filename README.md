## Packages

Noms indicatifs

existing = objets existants (je sais, ce n'est pas comme ça que Prestation est implmentée, mais ça n'est que pour démontrer le fonctionnement)

toImplement = comme son nom l'indique. C'est ce qui manque à part PrestationMapper qui existe déjà

## Spring

Je pense que le PrestationMapper existant est déjà créé par Spring. J'ai donc utilisé Spring pour générer les factories.

Par contre, pour les nouveaux mappers, comme il n'y a pas d'injection, c'est une instanciation directe (rester simple).

## Patterns

### AbstractFactory

Définit 3 factory de mapper. On peut demander à Spring de récupérer la bonne factory en fonction de la CP. Faire simple!

- PrestationMapperFactory = de base
- PrestationMapperCP14001Factory = pour la CP140.01
- PrestationMapperCP14003Factory = pour la CP140.03

J'ai définit une classe PrestationMapperFactoryFactory qui permet d'obtenir la bonne factory juste à partir de la CP (elle doit sans doute être améliorée).

**Avantages**

Extensible si d'autres cas particuliers arrivaient (autres CP).

### Composite

Déjà expliqué (voir Jira).

Objet de base = Condition, laquelle peut référencer un mapper.

En général, elle est composée de and, or ou not et de conditions de base (SimplePrestationCondition).

Classe utilitaire Combinaisons (noter le _s_) permet de créer les conditions avec un DSL-like si ses méthodes sont importées en static.

Voir PrestationMapperCP14001Factory pour un exemple d'utilisation.

La NotPrestationConditionCombinaison permet de s'affranchir de la classe Clause qui ne servait finalement qu'à dire si on voulait que la condition soit true ou false. Ici, une condition est true, sauf si elle est encapsulée dans un NotPrestationConditionCombinaison.  

**Avantages**

- Finalement assez clair et reste assez simple.
- Extensible

### Strategy

Comme déjà discuté, conforme au schéma présenté initialement lors du grooming.

**Avantages**

Extensible !