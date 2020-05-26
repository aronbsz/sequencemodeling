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
- Select **Model** as *Model Object*, then hit *Finish*
- Open the *representations.aird* file, in the Models tab, right click on the *Model* object under *<filename>.graphical* -> *New Child* -> *Interaction*
- In the *Representations* tab select the *Automaton Sequence Diagram* element (under *Interaction Modeling*)
- Hit *New* -> select *Automaton Sequence Diagram* -> *Next* -> select (the previously created) *Interaction* -> *Finish* -> choose a name for the representation 
- Open the newly created representation
- Happy Modeling ;)

### Modeling tips
- You can create new interaction models as described in the previous section (in the .aird file right click on *Model* -> ...)
- You can create representations for each Interaction, but not the Model itself (that represents the system modeled through all the sequence diagrams)
- Each sequence diagram has a node (initially in the top left corner) that represents the diagram itself. You can change its name through this element but should not delete it.
- *Interactions* can refer to (use) other interactions under the same *Model* element using their names in *Interaction Use* elements.

### M2M Setup
- Prerequisites: "hu.bme.mit.sequencediagram.graphical", "hu.bme.mit.sequencediagram.traceto.lpt.trace" and "hu.bme.mit.automatalearning.lpt" should all have their *Model*, *Edit* and *Editor* codes generated.
- Run hu.bme.mit.sequencediagram.m2m in eclipse runtime (*Run*->*Eclipse application*)
- Follow the instruction seen in *Example Model Setup* to create sequences. Once done, create a new resource project, and copy the .graphical file (the root of which should be a *Model* object) into its directory.
- Create and empty Trace (root: TraceRoot) and LPT (root: LPTRootNode) file in the same resource project.
- Open the *.graphical* file, on the Model object: *Right click*->*Transform*. The same resource project should have a new, <name>-gen.lpt generated file containing the output.
 - Happy transforming! =)
