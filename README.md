
# Cell2

This is the cell2 branch of the cell project. It is a cleaned up and working version of the cell project.

The program works as a simulation of cells in petri dish. There are 2 types of cells and resources at work in the simulation. 1 cell consumes 1 type of resource and puts out the other resource, and visa versa for the other cell type. As the cells consume more of each resource they will begin to split into new cell depending on how much resource they have stored. Once the cells reach a certain age they will die off leaving any unconsumed resource at the position they occupy. The cells will also die off if they run out of stored resources.

As the simulation plays out the program also counts the number of cells that have been created, and destroyed and calculates the total number of cells on the board at any given time.

COLORS:
The colors of each resource get expressed more depending on the amount of resource in each position. 
1 resource has a base color of yellow, and the other has a base color of cyan. 
The cell colors have a constant of red which is diluted into the resource colors and comes out as blue when in cyan, and redish yellow in yellow.

INTERFACE:

A user can click on positions to add cells to the board. The cell type that is added is shown by the bolded text next to the Cell Type button.

The interface has 11 buttons in 2 grids. 
Reset: resets the board without any cells inside
ResetR: resets the board with a random 10% of the positions occupied by random cell types
Change Cell: changes the cell type added when clicking on the board
Change Sized: changes the size of the board to an nxn with side length of the number in the textbox next to the button
Add Random Cell: adds a random cell to the board
Print Cells: prints cell and board information into the console
Confirm Stats: a nonfuctional button that used to allow the user to change the parameters of a single cell (I may add that back in later)
Play: starts the simulation
Pause: pauses the simulation
Change Speed: changes the delay time of the thread in accending order (1, 10, 100, 250, 500)ms
Check Integrity: displays the number of cells that are counted in the board as well as the number of cells that the simulation has calculated it has

The interface also contains 2 labels and a text box
Text Label below ResetR: the calculated number of cells within the simulation
Text Label next to Change Cell: the cell type that will be added to the board when clicked
Text Box next to Change Size: the side lenth of the board when change size is clicked

Known Bugs:

When the simulation is reset multiple time the cell calulation will not acutally be equal to the number of cells on the board
When the simulation is run at high speed the image drawer will fall behind and display black instead of the board
A cell will be made null but will not be deleted from the board
