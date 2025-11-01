// Pokemon Fighter 
// Created by Ayaan Jilani 
// Last Modified: 1/20/2025 
// Creates a pokemon fighting game
import hsa.Console;      //Console Package
import java.awt.*;       //Graphics Package
import java.io.*;        //Package with code for working with files
import javax.imageio.*;  //Package with code to import an image

public class PokemonFighter
{
  static Console c;
 
  public static void main (String[] args) 
  { 
    c = new Console();                      // Console for output
    
    Image titleScreenBackground = null;     // Background image for the title screen 
    Image battleScreenBackground = null;    // Background image for the battle screen 
    Image titleScreenText = null;           // Title text for the title screen 
    Image inputBox = null;                  // A box that will display output and get input
    String startOrExit;                     // Will store if the user enters Start or Exit
    Image selectionScreenBackground = null; // Background image for the selection screen
    Image selectionScreenText = null;       // Text for the selection screen
    int pokemonSelected;                    // Stores how which pokemon the user selected
    int computerSelction;                   // Stores which pokemon was given to the computer
    String computerSelectionName;           // Stores the name of the pokemon the computer chose 
    String userSelectionName;               // Stores the name of the pokemon the user chose
    int speedTieBreaker;                    // Will determine who goes first if there is a speed tie
    int moveSelection = 0;                  // Stores user input for what move they picked 
    int computerHp;                         // Stores how much health points the computer has
    int playerHp;                           // Stores how much health points the player has 
    String winner;                          // Stores who won the battle
    String playAgain = "yes";               // Stores if the player wants to play again or not
    // A drawing object that will be used to draw text for the title and selection sreens
    Drawing text = new Drawing(c, 120, 0, titleScreenText, "title.png");
    // A new drawing object that will be used to draw backgrounds 
    Drawing background = new Drawing(c, 15, 15, titleScreenBackground, "background.jpg"); 
    // A new drawing object that will be used to draw a box where the user will see output and where data is inputed 
    Drawing inputOutputBox = new Drawing(c, 160, 305, inputBox, "inputBox.png"); 
    Pokemon pokemon1;               // A new pokemon object for the player's first option 
    Pokemon pokemon2;               // A new pokemon object for the player's second option 
    Pokemon pokemon3;               // A new pokemon object for the player's third option 
    Pokemon computerPokemon = null; // A new pokemon object for the computer to play as 
    Pokemon userPokemon = null;     // A new pokemon object that the user will play as
    
    // Draw the titlescreen
    drawTitleScreen(text, background, inputOutputBox); 
    
    // Get input from user 
    c.setCursor(18, 22);
    startOrExit = c.readString();
    
    // Create a while loop if the player wants to play again
    while(playAgain.equals("yes"))
    {
    // An If statement that decides what to do depending on what the user enters 
    if(startOrExit.equals("START"))
    {
      // Clear the console 
      c.clear(); 
      
      // Draw selection screen 
      background = new Drawing(c, 25, 100, selectionScreenBackground, "selectionBackground.png");
      background.drawImage(); 
      text = new Drawing(c, 80, 0, selectionScreenText, "selectionText.png");
      text.drawImage(); 
      inputOutputBox = new Drawing(c, 160, 420, inputBox, "inputBox.png");
      inputOutputBox.drawImage(); 
    }
    else // If the user enters anything other that "START" or "EXIT", get the user to try again 
    { 
      c.setCursor(19, 22);
      c.print("Invalid Input, try again: "); 
      startOrExit = c.readString();
    }
    
    // Spawn the 3 pokemon that the user can select
    pokemon1 = new Pokemon("Kyogre", c, 100, 250); 
    pokemon2 = new Pokemon("Groudon", c, 250, 250); 
    pokemon3 = new Pokemon("Rayquaza", c, 400, 250);
    
    // Get the user's input
    c.drawString("Enter 1, 2, or 3 to choose the first, second or third pokemon: ", 170, 450);
    c.setCursor(24, 22);
    pokemonSelected = c.readInt(); 
    
    // Set user's pokemon based on input 
    if(pokemonSelected == 1)
    {
      userSelectionName = "Kyogre"; 
    }
    else if(pokemonSelected == 2)
    {
      userSelectionName = "Groudon";
    }
    else 
    {
      userSelectionName = "Rayquaza";
    } 
    
    // Randomly select the computer's pokemon
    computerSelction = (int)(Math.random()* 3 + 1); 
    if(computerSelction == 1)
    {
      computerSelectionName = "Mega Steelix"; 
    }
    else if(computerSelction == 2)
    {
      computerSelectionName = "Incineroar";
    }
    else 
    {
      computerSelectionName = "Deoxys";
    } 
    
    // give the pokemon to the trainers
    userPokemon = new Pokemon(userSelectionName, c, 100, 250); 
    computerPokemon = new Pokemon(computerSelectionName, c, 450, 150);
    
    // Draw the battle screen 
    drawBattleScreen(background, inputOutputBox, battleScreenBackground, inputBox, computerPokemon, userPokemon, 
                     computerSelectionName, userSelectionName);  
    
    // assign values for the computer and player's health 
    computerHp = computerPokemon.healthPoints; 
    playerHp = userPokemon.healthPoints; 
    
    // Start the battle with turns 
    while(true)
    {
      // Determine whos turn goes first based on speed
      if(computerPokemon.speed > userPokemon.speed)
      {
        // do computer's turn 
        computerTurn(computerSelectionName, computerPokemon, userPokemon);  
        drawBattleScreen(background, inputOutputBox, battleScreenBackground, inputBox, computerPokemon, userPokemon, 
                     computerSelectionName, userSelectionName);
        
        // Do players turn and get input
        playerTurn(userSelectionName, userPokemon, computerPokemon, moveSelection);
        c.setCursor(20, 25);
        moveSelection = c.readInt();
        
        // reset secreen to show updated health points
        drawBattleScreen(background, inputOutputBox, battleScreenBackground, inputBox, computerPokemon, userPokemon, 
                     computerSelectionName, userSelectionName);
      }
      else if(computerPokemon.speed < userPokemon.speed)
      {
        // Do players turn and get input
        c.setCursor(20, 25);
        moveSelection = c.readInt(); 
        playerTurn(userSelectionName, userPokemon, computerPokemon, moveSelection); 
        drawBattleScreen(background, inputOutputBox, battleScreenBackground, inputBox, computerPokemon, userPokemon, 
                     computerSelectionName, userSelectionName);
        
        // do computer's turn
        computerTurn(computerSelectionName, computerPokemon, userPokemon); 
        
         // reset secreen to show updated health points
        drawBattleScreen(background, inputOutputBox, battleScreenBackground, inputBox, computerPokemon, userPokemon, 
                     computerSelectionName, userSelectionName);
      }
      else 
      {
        speedTieBreaker = (int)(Math.random()*2 + 1);
        if(speedTieBreaker == 1)
        {
          // Do players turn and get input
          c.setCursor(20, 25);
          moveSelection = c.readInt();
          playerTurn(userSelectionName, userPokemon, computerPokemon, moveSelection); 
          drawBattleScreen(background, inputOutputBox, battleScreenBackground, inputBox, computerPokemon, userPokemon, 
                     computerSelectionName, userSelectionName);
          
          // do computer's turn
          computerTurn(computerSelectionName, computerPokemon, userPokemon);  
          
          // reset secreen to show updated health points
          drawBattleScreen(background, inputOutputBox, battleScreenBackground, inputBox, computerPokemon, userPokemon, 
                     computerSelectionName, userSelectionName);
        }
        else 
        {
          // do computer's turn 
        computerTurn(computerSelectionName, computerPokemon, userPokemon);  
        drawBattleScreen(background, inputOutputBox, battleScreenBackground, inputBox, computerPokemon, userPokemon, 
                     computerSelectionName, userSelectionName);
        
        // Do players turn and get input
        playerTurn(userSelectionName, userPokemon, computerPokemon, moveSelection);
        c.setCursor(20, 25);
        moveSelection = c.readInt();
        
        // reset secreen to show updated health points
        drawBattleScreen(background, inputOutputBox, battleScreenBackground, inputBox, computerPokemon, userPokemon, 
                     computerSelectionName, userSelectionName);
        } 
      }
      
      // reassign values for the computer and player's health 
      computerHp = computerPokemon.healthPoints; 
      playerHp = userPokemon.healthPoints; 
      
      // Determine winner and break the loop 
      if(userPokemon.healthPoints <= 0)
      {
        winner = "Computer"; 
        break;
      }
      else if(computerPokemon.healthPoints <= 0)
      {
        winner = "Player"; 
        break;
      }
    }
    
    // Make an input box, output the winner, and ask user if they want to play again 
    inputOutputBox = new Drawing(c, 100, 150, inputBox, "inputBox.png");
    inputOutputBox.drawImage(); 
    c.drawString((winner+ " wins!"), 130, 180); 
    c.drawString("Do you want to play again? Enter 'yes' or 'no':", 130, 210); 
    c.setCursor(10, 20); 
    playAgain = c.readString();
  } 
    c.close();
  }//rethgiFnomekoP
  
  // A method that draws the title screen 
  // title - title drawing 
  // background - background drawing 
  // inputBox - inputBox drawing
  public static void drawTitleScreen(Drawing title, Drawing background, Drawing inputBox)
  {
    // Draw the images that consist of the title screen  
    background.drawImage(); 
    title.drawImage();
    inputBox.drawImage(); 
    
    // Output prompt
    c.drawString("Enter 'START' to begin the game", 230, 330); 
  }//neercSeltiTward
  
  // A method that draws that will clear and then draw the battle screen 
  // background - drawing for the battle screen background 
  // inputBox - drawing for the input boxes 
  // battleScreen - image for background drawing 
  // box - image for the inputBox 
  // aiPokemon - computer's pokemon 
  // playerPokemon - player's pokemon 
  // compSelection - name of pokemon that computer selected 
  // playerSelection - name of pokemon that user selected
  public static void drawBattleScreen(Drawing background, Drawing inputBox, Image battleScreen, 
                                      Image box, Pokemon aiPokemon, Pokemon playerPokemon, 
                                      String compSelection, String playerSelection)
  {
    // clear the screen 
    c.clear(); 
    
    // Draw the battle screen background 
    background = new Drawing(c, 0, 25, battleScreen, "battleBackground.png"); 
    background.drawImage(); 
    
    // Draw the battling pokemon 
    aiPokemon.drawPokemon(compSelection, c, 450, 150); 
    playerPokemon.drawPokemon(playerSelection, c, 100, 250);
    
    // Draw the input boxes
    inputBox = new Drawing(c, 0, 50, box, "inputBox.png");
    inputBox.drawImage(); 
    inputBox = new Drawing(c, 320, 250, box, "inputBox.png");
    inputBox.drawImage(); 
    
    // Write player pokemon's health and name
    c.drawString(playerSelection, 50, 75);
    c.drawString("Health: " + playerPokemon.healthPoints, 50, 100);
    
    // Write computer pokemon's health and name
    c.drawString(compSelection, 370, 275);
    c.drawString("Health: " + aiPokemon.healthPoints, 370, 300); 
    
    // Write prompt for user input 
    if(playerSelection.equals("Kyogre"))
    {
      c.drawString("Enter 1 to use Body Slam", 50, 350); 
      c.drawString("Enter 2 to use Origin Pulse", 50, 375); 
      c.drawString("Enter 3 to use Aqua Tail", 50, 400); 
      c.drawString("Enter 4 to use Aqua Ring", 50, 425); 
    }
    else if(playerSelection.equals("Groudon"))
    {
      c.drawString("Enter 1 to use Precipice Blades", 50, 350); 
      c.drawString("Enter 2 to use Earthquake", 50, 375); 
      c.drawString("Enter 3 to use Eruption", 50, 400); 
      c.drawString("Enter 4 to use Earth Power", 50, 425); 
    }
    else if(playerSelection.equals("Rayquaza"))
    {
      c.drawString("Enter 1 to use Hyper Beam", 50, 350); 
      c.drawString("Enter 2 to use Dragon Dance", 50, 375); 
      c.drawString("Enter 3 to use Air Slash", 50, 400); 
      c.drawString("Enter 4 to use Crunch", 50, 425); 
    }
  }// neercSelttaBward
  
  // method decides what the computer will do on its turn 
  // aiSelection - the name of the pokemon that the computer selected 
  // aiPokemon - computer's pokemon 
  // enemyPokemon - player's pokemon
  public static void computerTurn(String aiSelection, Pokemon aiPokemon, Pokemon enemyPokemon)
  {
    int selectMove; // generates a random number that selects the ai's move 
    
    if(aiSelection.equals("Mega Steelix"))
    {
      selectMove = (int)(Math.random()*4 + 1);
      aiPokemon.megaSteelixMoves(c, selectMove, enemyPokemon);
    }
    else if(aiSelection.equals("Incineroar"))
    {
      selectMove = (int)(Math.random()*4 + 1);
      aiPokemon.incineroarMoves(c, selectMove, enemyPokemon);
    }
    else if(aiSelection.equals("Deoxys"))
    {
      selectMove = (int)(Math.random()*4 + 1);
      aiPokemon.deoxysMoves(c, selectMove, enemyPokemon);
    }
  }// nruTretupmoc 
  
  // methond decides what the player will do on their turn 
  // playerSelection - name of pokemon that player selected 
  // playerPokemon - player's pokemon 
  // enemyPokemon - the computer's pokemon
  // playerInput - the player's input 
  public static void playerTurn(String playerSelection, Pokemon playerPokemon, Pokemon enemyPokemon, int playerInput)
  {
    if(playerSelection.equals("Kyogre"))
    {
      playerPokemon.kyogreMoves(c, playerInput, enemyPokemon);
    }
    else if(playerSelection.equals("Groudon"))
    {
      playerPokemon.groudonMoves(c, playerInput, enemyPokemon);
    }
    else if(playerSelection.equals("Rayquaza"))
    {
      playerPokemon.rayquazaMoves(c, playerInput, enemyPokemon);
    }
  }
}