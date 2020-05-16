## Sequence Diagram Formalism for Modeling the Behavior of Automata
### Plugin Setup
- Clone the repo
- Import the projects in the */plugins* folder into eclipse
- (Reload the .genmodel file in the *hu.bme.mit.sequencediagram.graphical.model/model* folder)
- Generate Model Code (on the root element in *graphical.genmodel*)
- Generate Edit Code (on the root element in *graphical.genmodel*)
- Generate Editor Code (on the root element in *graphical.genmodel*)
- Launch a Runtime Eclipse by starting the *hu.bme.mit.sequencediagram.graphical.design* project as an Eclipse Application
- Have Fun!

Pro tip: delete the generated files and folders before re-generating them.

### Example Model Setup
- In the *Runtime Eclipse* create a new *Sirius Modeling Project* (*File -> New -> Other -> Sirius -> Modeling Project*)
- Create a corresponding EMF model in that project (*File -> New ->  Other -> Example EMF Model Creation Wizards -> Graphical Model*)
- Choose a file name and select the previously created (project) folder
- Select **Interaction** as *Model Object*, then hit *Finish*
- Open the *representations.aird* file, and in the *Representations* tab select the *Automaton Sequence Diagram* element (under *Interaction Modeling*)
- Hit *New* -> select *Automaton Sequence Diagram* -> *Next* -> select *Interaction* -> *Finish* -> choose a name for the representation 
- Open the newly created representation
- Happy Modeling ;)

