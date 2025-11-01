// The Pokemon class 
// Created by Ayaan Jilani 
// Last Modified: 1/20/2025 
// Creates the pokemon with their moves and stats 

import hsa.Console;      //Console Package
import java.awt.*;       //Graphics Package
import java.io.*;        //Package with code for working with files
import javax.imageio.*;  //Package with code to import an image 

public class Pokemon 
{
  public int healthPoints;    // The pokemon's health points 
  public int attackPoints;    // The pokemon's atttack points 
  public int defensePoints;   // The pokemon's defense points
  public int specialAttack;   // The pokemon's special attack 
  public int specialDefense;  // The pokemon's special defense 
  public int speed;           // The pokemon's speed
  public String type1;        // The pokemon's first type 
  public String type2;        // The pokemon's second type
  public String name;         // The name of the pokemon
  public Console userConsole; // The console where the pokemon will be drawn on 
  public Image sprite;        // The pokemon's sprite
  public int xPosition;       // X position of the pokemon sprite
  private int yPosition;      // Y position of the pokemon sprite 
  
  // Constructor that allows the user to create a pokemon 
  // c - Console to create the image on 
  // x = x position
  // y - y position
  // pokemon - name of the pokemon being made
  public Pokemon(String pokemon, Console c, int x, int y)
  {
    // Set variables 
    userConsole = c; 
    xPosition = x; 
    yPosition = y; 
    name = pokemon;
    // If statement to assign stats based on which pokemon is being made
    if(name.equals("Kyogre")) 
    { 
      // Set stats for Kyogre 
      healthPoints = 100; 
      attackPoints = 100; 
      defensePoints = 90; 
      specialAttack = 150; 
      specialDefense = 140; 
      speed = 90; 
      type1 = "Ground";
      
      // Create Kyogre Sprite 
      try 
      {
        sprite = ImageIO.read(new File("Kyogre.png"));
      }
      catch(IOException e) 
      {
        sprite = null; 
      }
      userConsole.drawImage(sprite,xPosition,yPosition,null);
    }
    else if(name.equals("Groudon"))
    {
      // Set stats for Groudon 
      healthPoints = 100; 
      attackPoints = 150; 
      defensePoints = 140; 
      specialAttack = 100; 
      specialDefense = 90; 
      speed = 90; 
      type1 = "Ground";
      
      // Create Groudon Sprite 
      try 
      {
        sprite = ImageIO.read(new File("Groudon.png"));
      }
      catch(IOException e) 
      {
        sprite = null; 
      }
      userConsole.drawImage(sprite,xPosition,yPosition,null);
    }
    else if(name.equals("Rayquaza"))
    {
      // Set stats for Rayquaza 
      healthPoints = 105; 
      attackPoints = 150; 
      defensePoints = 90; 
      specialAttack = 150; 
      specialDefense = 90; 
      speed = 95; 
      type1 = "Dragon";
      type2 = "Flying";
      
      // Create Rayquaza Sprite 
      try 
      {
        sprite = ImageIO.read(new File("Rayquaza.png"));
      }
      catch(IOException e) 
      {
        sprite = null; 
      }
      userConsole.drawImage(sprite,xPosition,yPosition,null);
    }
    else if(name.equals("Mega Steelix"))
    {
      // Set stats for Mega Steelix 
      healthPoints = 75; 
      attackPoints = 125; 
      defensePoints = 230; 
      specialAttack = 55; 
      specialDefense = 95; 
      speed = 30; 
      type1 = "Steel";
      type2 = "Ground";
      
      // Create Mega Steelix Sprite 
      try 
      {
        sprite = ImageIO.read(new File("megaSteelix.png"));
      }
      catch(IOException e) 
      {
        sprite = null; 
      }
      userConsole.drawImage(sprite,xPosition,yPosition,null);
    }
    else if(name.equals("Incineroar"))
    {
      // Set stats for Incineroar 
      healthPoints = 95; 
      attackPoints = 115; 
      defensePoints = 90; 
      specialAttack = 80; 
      specialDefense = 90; 
      speed = 60; 
      type1 = "Fire";
      type2 = "Dark";
      
      // Create Incineroar Sprite 
      try 
      {
        sprite = ImageIO.read(new File("incineroar.png"));
      }
      catch(IOException e) 
      {
        sprite = null; 
      }
      userConsole.drawImage(sprite,xPosition,yPosition,null);
    }
    else if(name.equals("Deoxys"))
    {
      // Set stats for Deoxys 
      healthPoints = 50; 
      attackPoints = 150; 
      defensePoints = 50; 
      specialAttack = 150; 
      specialDefense = 50; 
      speed = 150; 
      type1 = "Psychic";
      
      // Create Deoxys Sprite 
      try 
      {
        sprite = ImageIO.read(new File("deoxys.png"));
      }
      catch(IOException e) 
      {
        sprite = null; 
      }
      userConsole.drawImage(sprite,xPosition,yPosition,null);
    }
  }
  
  // Method that allows the user to use all of Kyogre's moves 
  // userInput - gets the input from the user to determine which move is being used 
  public void kyogreMoves(Console c, int userInput, Pokemon enemyPokemon)
  {
    // Decide which move to do based on input
    if(userInput == 1)
    {
      // Body Slam  
      
      // Determine what to do depending if damage done is positive or negative 
      if((85) - enemyPokemon.defensePoints < 0)
      {
        enemyPokemon.healthPoints -= (85/4); 
      } 
      else 
      {
        enemyPokemon.healthPoints -= (85) - enemyPokemon.defensePoints;
      } 
      
      // Output text 
      c.setCursor(20, 20); 
      c.print("Kyogre used body slam.");
    }
    else if(userInput == 2)
    {
      // Origin Pulse 
      
      // Determine what to do depending if damage done is positive or negative 
      if((110) - enemyPokemon.defensePoints < 0)
      {
        enemyPokemon.healthPoints -= (110/4); 
      } 
      else 
      {
        enemyPokemon.healthPoints -= (110) - enemyPokemon.specialDefense;
      }
      
      // Output text 
      c.setCursor(20, 20); 
      c.print("Kyogre used Origin Pulse.");
    } 
    else if(userInput == 3)
    {
      // Aqua Tail
      
      // Determine what to do depending if damage done is positive or negative 
      if((90) - enemyPokemon.defensePoints < 0)
      {
        enemyPokemon.healthPoints -= (90/4); 
      } 
      else 
      {
        enemyPokemon.healthPoints -= (90) - enemyPokemon.defensePoints;
      }
      
      // Output text 
      c.setCursor(20, 20); 
      c.print("Kyogre used Aqua Tail."); 
    }
    else if(userInput == 4)
    {
      // Aqua Ring
      healthPoints += (healthPoints*0.16); 
      
      // Output text 
      c.setCursor(20, 20); 
      c.print("Kyogre used Aqua Ring.");
    }
  } 
  
  // Method that allows the user to use all of Groudon's moves 
  // userInput - gets the input from the user to determine which move is being used 
  public void groudonMoves(Console c, int userInput, Pokemon enemyPokemon)
  {
    int randomChance; // used when there is a chance for something to happen(10% chance for effect to happen)
    
    if(userInput == 1)
    {
      // Precipice Blades 
      
      // Determine what to do depending if damage done is positive or negative 
      if((120) - enemyPokemon.defensePoints < 0)
      {
        enemyPokemon.healthPoints -= (120/4); 
      } 
      else 
      {
        enemyPokemon.healthPoints -= (120) - enemyPokemon.defensePoints;
      } 
      
      // Output text 
      c.setCursor(20, 20); 
      c.print("Groudon used Precipice Blades.");
    }
    else if(userInput == 2)
    {
      // Earthquake 
      
      // Determine what to do depending if damage done is positive or negative 
      if((100) - enemyPokemon.defensePoints < 0)
      {
        enemyPokemon.healthPoints -= (100/4); 
      } 
      else 
      {
        enemyPokemon.healthPoints -= (100) - enemyPokemon.defensePoints;
      }  
      
      // Output text 
      c.setCursor(20, 20); 
      c.print("Groudon used Earthquake.");
    } 
    else if(userInput == 3)
    {
      // Eruption 
      
      // Determine what to do depending if damage done is positive or negative 
      if((150) - enemyPokemon.defensePoints < 0)
      {
        enemyPokemon.healthPoints -= (150/4); 
      } 
      else 
      {
        enemyPokemon.healthPoints -= (150) - enemyPokemon.specialDefense;
      }  
      
      // Output text 
      c.setCursor(20, 20); 
      c.print("Groudon used Eruption.");
    }
    else if(userInput == 4)
    {
      // Earth Power 
      
      // Determine what to do depending if damage done is positive or negative 
      if((90) - enemyPokemon.defensePoints < 0)
      {
        enemyPokemon.healthPoints -= (int)(90/4); 
      } 
      else 
      {
        enemyPokemon.healthPoints -= (90) - enemyPokemon.specialDefense;
      }  
      
      // Randomly determine if the enemy's defense is decreased or not
      randomChance = (int)(Math.random()* 10 + 1); 
      if(randomChance == 1)
      {
        enemyPokemon.defensePoints = (int)(enemyPokemon.defensePoints*0.66);
      } 
      
      // Output text 
      c.setCursor(20, 20); 
      c.print("Groudon used Earth Power.");
    }
  } 
  
  // Method that allows the user to use all of Rayquaza's moves 
  // userInput - gets the input from the user to determine which move is being used 
  public void rayquazaMoves(Console c, int userInput, Pokemon enemyPokemon)
  {
    int randomChance; // used when there is a chance for something to happen(10% chance for effect to happen)
    
    if(userInput == 1)
    {
      // Hyper Beam  
      
      // Determine what to do depending if damage done is positive or negative 
      if((150) - enemyPokemon.defensePoints < 0)
      {
        enemyPokemon.healthPoints -= (int)(150/4); 
      } 
      else 
      {
        enemyPokemon.healthPoints -= (150) - enemyPokemon.specialDefense;
      } 
      
      // Output text 
      c.setCursor(20, 20); 
      c.print("Rayquaza used Hyper Beam.");
    }
    else if(userInput == 2)
    {
      // Dragon Dance 
      attackPoints += (attackPoints*1.5);
      speed += speed*1.5;
      
      // Output text 
      c.setCursor(20, 20); 
      c.print("Rayquaza used Dragon Dance.");
    } 
    else if(userInput == 3)
    {
      // Air Slash  
      
      // Determine what to do depending if damage done is positive or negative 
      if((75) - enemyPokemon.defensePoints < 0)
      {
        enemyPokemon.healthPoints -= (int)(75/4); 
      } 
      else 
      {
        enemyPokemon.healthPoints -= (75) - enemyPokemon.specialDefense;
      } 
      
      // Output text 
      c.setCursor(20, 20); 
      c.print("Rayquaza used Air Slash.");
    }
    else if(userInput == 4)
    {
      // Crunch  
      
      // Determine what to do depending if damage done is positive or negative 
      if((80) - enemyPokemon.defensePoints < 0)
      {
        enemyPokemon.healthPoints -= (int)(80/4); 
      } 
      else 
      {
        enemyPokemon.healthPoints -= (80) - enemyPokemon.defensePoints;
      } 
      
      // randomly determine if defense points will be lowered
      randomChance = (int)(Math.random()* 10 + 1); 
      if(randomChance <= 2)
      {
        enemyPokemon.defensePoints = (int)(enemyPokemon.defensePoints*0.66);
      } 
      
      // Output text 
      c.setCursor(20, 20); 
      c.print("Rayquaza used Crunch.");
    }
  } 
  
  // Method that allows the user to use all of Mega Steelix's moves 
  // computerInput - gets the input from the computer to determine which move is being used 
  public void megaSteelixMoves(Console c, int computerInput, Pokemon enemyPokemon)
  {
    int randomChance; // used when there is a chance for something to happen(10% chance for effect to happen)
    
    if(computerInput == 1)
    {
      // Iron Tail  
      
      // Determine what to do depending if damage done is positive or negative 
      if((100) - enemyPokemon.defensePoints < 0)
      {
        enemyPokemon.healthPoints -= (int)(100/4); 
      } 
      else 
      {
        enemyPokemon.healthPoints -= (100) - enemyPokemon.defensePoints;
      } 
      
      // Randomly determine if defense points are decreased
      randomChance = (int)(Math.random()* 10 + 1); 
      if(randomChance <= 3)
      {
        enemyPokemon.defensePoints = (int)(enemyPokemon.defensePoints*0.66);
      } 
      
      // Output text 
      c.setCursor(20, 21); 
      c.print("Mega Steelix used Iron Tail.");
    }
    else if(computerInput == 2)
    {
      // Rock Polish 
      speed = speed*2; 
      
      // Output text 
      c.setCursor(20, 21); 
      c.print("Mega Steelix used Rock Polish.");
    } 
    else if(computerInput == 3)
    {
      // Slam  
      
      // Determine what to do depending if damage done is positive or negative 
      if((80) - enemyPokemon.defensePoints < 0)
      {
        enemyPokemon.healthPoints -= (int)(80/4); 
      } 
      else 
      {
        enemyPokemon.healthPoints -= (80) - enemyPokemon.defensePoints;
      }
      
      // Output text 
      c.setCursor(20, 21); 
      c.print("Mega Steelix used Slam.");
    }
    else if(computerInput == 4)
    {
      // Fire fang  
      
      // Determine what to do depending if damage done is positive or negative 
      if((65) - enemyPokemon.defensePoints < 0)
      {
        enemyPokemon.healthPoints -= (int)(65/4); 
      } 
      else 
      {
        enemyPokemon.healthPoints -= (65) - enemyPokemon.defensePoints;
      }
      
      // randomly determine if a burn damage is added
      randomChance = (int)(Math.random()* 10 + 1); 
      if(randomChance == 1)
      {
        enemyPokemon.healthPoints -= (int)(enemyPokemon.healthPoints*0.15);
      } 
      
      // Output text 
      c.setCursor(20, 21); 
      c.print("Mega Steelix used Fire fang.");
    }
  } 
  
  // Method that allows the user to use all of Incineroar's moves 
  // computerInput - gets the input from the computer to determine which move is being used 
  public void incineroarMoves(Console c, int computerInput, Pokemon enemyPokemon)
  {
    int damageDone; // Stores amount of damage done for the Flare Blitz move 
    int randomChance; // used when there is a chance for something to happen(10% chance for effect to happen) 
    
    if(computerInput == 1)
    {
      // Bulk Up
      defensePoints = (int)(defensePoints*1.5); 
      attackPoints = (int)(attackPoints*1.5); 
      
      // Output text 
      c.setCursor(20, 21); 
      c.print("Incineroar used Bulk Up.");
    }
    else if(computerInput == 2)
    {
      // Double Kick 
      
      // Determine what to do depending if damage done is positive or negative 
      for(int x = 0; x <= 2; ++x)
      {
        if((30) - enemyPokemon.defensePoints < 0)
        {
         enemyPokemon.healthPoints -= (int)(30/2); 
        } 
        else 
        {
         enemyPokemon.healthPoints -= (30) - enemyPokemon.defensePoints;
        }
      }
      
      // Output text 
      c.setCursor(20, 21); 
      c.print("Incineroar used Double Kick.");
    } 
    else if(computerInput == 3)
    {
      // Flare Blitz  
      
      // Determine what to do depending if damage done is positive or negative
      if((120) - enemyPokemon.defensePoints < 0)
      {
        enemyPokemon.healthPoints -= (int)(120/4); 
      } 
      else 
      {
        enemyPokemon.healthPoints -= (120) - enemyPokemon.defensePoints;
      }
      
      // Set damage done and see if burn effect applies
      damageDone = (120) - enemyPokemon.defensePoints;
      randomChance = (int)(Math.random()* 10 + 1); 
      if(randomChance == 1)
      {
        enemyPokemon.healthPoints -= (int)(enemyPokemon.healthPoints*0.15);
      }
      healthPoints -= damageDone;  
      
      // Output text 
      c.setCursor(20, 21); 
      c.print("Incineroar used Flare Blitz.");
    }
    else if(computerInput == 4)
    {
      // Flamethrower 
      
      // Determine what to do depending if damage done is positive or negative
      if((90) - enemyPokemon.defensePoints < 0)
      {
        enemyPokemon.healthPoints -= (int)(90/4); 
      } 
      else 
      {
        enemyPokemon.healthPoints -= (90) - enemyPokemon.specialDefense;
      }
      // determine if burn effect applies 
      randomChance = (int)(Math.random()* 10 + 1); 
      if(randomChance == 1)
      {
        enemyPokemon.healthPoints -= (int)(enemyPokemon.healthPoints*0.15);
      } 
      
      // Output text 
      c.setCursor(20, 21); 
      c.print("Incineroar used Flamethrower.");
    }
  } 
  
  // Method that allows the user to use all of Deoxys's moves
  // computerInput - gets the input from the computer to determine which move is being used 
  // enemyPokemon - the pokemon that will take damage
  public void deoxysMoves(Console c, int computerInput, Pokemon enemyPokemon)
  {
    if(computerInput == 1)
    {
      // Psycho Boost   
      
      // Determine what to do depending if damage done is positive or negative
      if((140) - enemyPokemon.defensePoints < 0)
      {
        enemyPokemon.healthPoints -= (int)(140/4); 
      } 
      else 
      {
        enemyPokemon.healthPoints -= (140) - enemyPokemon.specialDefense; 
      }
      specialAttack = (int)(specialAttack*0.5); 
      
      // Output text 
      c.setCursor(20, 21); 
      c.print("Deoxys used Psycho Boost.");
    }
    else if(computerInput == 2)
    {
      // Cosmic Power 
      defensePoints = (int)(defensePoints*1.5); 
      specialDefense = (int)(specialDefense*1.5); 
      
      // Output text 
      c.setCursor(20, 21); 
      c.print("Deoxys used Cosmic Power.");
    } 
    else if(computerInput == 3)
    {
      // Hyper Beam  
      if((150) - enemyPokemon.defensePoints < 0)
      {
        enemyPokemon.healthPoints -= (int)(150/4); 
      } 
      else 
      {
        enemyPokemon.healthPoints -= (150) - enemyPokemon.specialDefense;
      } 
      
      // Output text 
      c.setCursor(20, 21); 
      c.print("Deoxys used Hyper Beam.");
    }
    else if(computerInput == 4)
    {
      // Psyshock 
      
      if((80) - enemyPokemon.defensePoints < 0)
      {
        enemyPokemon.healthPoints -= (int)(80/4); 
      } 
      else 
      {
        enemyPokemon.healthPoints -= (80) - enemyPokemon.defensePoints;
      }  
      
      // Output text 
      c.setCursor(20, 21); 
      c.print("Deoxys used Psyshock.");
    }
  }
  
  // A method that only draws the pokemon sprite 
  // pokemon - name of the pokemon 
  // c - console to draw on 
  // x - x position of the image
  // y - y position of the image
  public void drawPokemon(String pokemon, Console c, int x, int y)
  {
    if(name.equals("Kyogre")) 
    { 
      // Create Kyogre Sprite 
      try 
      {
        sprite = ImageIO.read(new File("Kyogre.png"));
      }
      catch(IOException e) 
      {
        sprite = null; 
      }
      userConsole.drawImage(sprite,xPosition,yPosition,null);
    }
    else if(name.equals("Groudon"))
    {
      // Create Groudon Sprite 
      try 
      {
        sprite = ImageIO.read(new File("Groudon.png"));
      }
      catch(IOException e) 
      {
        sprite = null; 
      }
      userConsole.drawImage(sprite,xPosition,yPosition,null);
    }
    else if(name.equals("Rayquaza"))
    {
      // Create Rayquaza Sprite 
      try 
      {
        sprite = ImageIO.read(new File("Rayquaza.png"));
      }
      catch(IOException e) 
      {
        sprite = null; 
      }
      userConsole.drawImage(sprite,xPosition,yPosition,null);
    }
    else if(name.equals("Mega Steelix"))
    {
      // Create Mega Steelix Sprite 
      try 
      {
        sprite = ImageIO.read(new File("megaSteelix.png"));
      }
      catch(IOException e) 
      {
        sprite = null; 
      }
      userConsole.drawImage(sprite,xPosition,yPosition,null);
    }
    else if(name.equals("Incineroar"))
    {
      // Create Incineroar Sprite 
      try 
      {
        sprite = ImageIO.read(new File("incineroar.png"));
      }
      catch(IOException e) 
      {
        sprite = null; 
      }
      userConsole.drawImage(sprite,xPosition,yPosition,null);
    }
    else if(name.equals("Deoxys"))
    {
      // Create Deoxys Sprite 
      try 
      {
        sprite = ImageIO.read(new File("deoxys.png"));
      }
      catch(IOException e) 
      {
        sprite = null; 
      }
      userConsole.drawImage(sprite,xPosition,yPosition,null);
    }
  }
} 