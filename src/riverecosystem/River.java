/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riverecosystem;

import java.util.Random;

/**
 *
 * @author Cagrosso
 */
public class River {
    
    public Animal[] array;
    public int length;
    public int numEmpty;
    public Random rd;
    
    public River(int length){
        rd = new Random();
        array = new Animal[length];
        this.length = length;
        this.numEmpty = length;
        
        for(int i = 0; i < length; i++){
            int type = rd.nextInt(3);
            switch (type){
                case 0:
                    array[i] = null;
                    break;
                case 1:
                    Bear bear = new Bear(rd.nextInt(Bear.MAX_AGE + 1), Animal.Gender.getRandom());
                    array[i] = bear;
                    numEmpty--;
                    break;
                case 2:
                    Fish fish = new Fish(rd.nextInt(Fish.MAX_AGE + 1), Animal.Gender.getRandom());
                    array[i] = fish;
                    numEmpty--;
                    break;
            }
                    
        }
    }
    
    public int getLength(){
        return length;
    }
    
    public int numEmpty(){
        return numEmpty;
    }
    
    public boolean addRandom(Animal animal){
        if(numEmpty == 0){
            return false;
        }else{
            numEmpty--;
            if(animal instanceof Bear){
                Bear bear = new Bear(0, Animal.Gender.getRandom());
                boolean isValid = false;
                while(!isValid){
                    int index = rd.nextInt(length);
                    if(array[index] == null){
                        array[index] = bear;
                        isValid = true;
                    }   
                }
            }else{
                Fish fish = new Fish(0, Animal.Gender.getRandom());
                boolean isValid = false;
                while(!isValid){
                    int index = rd.nextInt(length);
                    if(array[index] == null){
                        array[index] = fish;
                        isValid = true;
                    }
                }
            }
            return true;
        }
    }
    
    public void updateCell(int i){
        Animal animal = array[i];
        // if an animal occupies the spot
        if(animal != null){
            // if the animal is older than its max age, remove
            if(!animal.incrAge()){
                array[i] = null;
            }else{
                int move = rd.nextInt(3) + 1;
                switch(move){
                    case 0:
                        // don't move
                        break;
                    case 1:
                        // move left
                        // check to make sure in bounds
                        if(i == 0){
                            break;
                        }
                        if(array[i - 1] != null){
                            // check if bear vs fish
                            if(array[i - 1] instanceof Bear && animal instanceof Fish){
                                array[i] = null;
                            // check if fish vs fish
                            }else if(array[i - 1] instanceof Fish && animal instanceof Fish){
                                // check if fish vs fish is male and female before reproduce
                                if(animal.gender != array[i - 1].gender){
                                    addRandom(animal);
                                }
                            // check if bear vs bear   
                            }else if(array[i - 1] instanceof Bear && animal instanceof Bear){
                                // check if bear vs bear is male and femal before reproduce
                                if(animal.gender != array[i - 1].gender){
                                    addRandom(animal);
                                }
                            }
                        }else{
                            array[i - 1] = animal;
                            array[i] = null;
                        }
                        break;
                    case 2:
                        // move right
                        // check to make sure in bounds
                        if(i  == length - 1){
                            break;
                        }
                        if(array[i + 1] != null){
                            // check if bear vs fish
                            if(array[i + 1] instanceof Bear && animal instanceof Fish){
                                array[i + 1] = null;
                            // check if fish vs fish
                            }else if(array[i + 1] instanceof Fish && animal instanceof Fish){
                                // check if fish vs fish is male and female before reproduce
                                if(animal.gender != array[i + 1].gender){
                                    addRandom(animal);
                                }
                            // check if bear vs bear   
                            }else if(array[i + 1] instanceof Bear && animal instanceof Bear){
                                // check if bear vs bear is male and femal before reproduce
                                if(animal.gender != array[i + 1].gender){
                                    addRandom(animal);
                                }
                            }
                        }else{
                            array[i + 1] = animal;
                            array[i] = null;
                        }
                        break;
                }
            } 
        }
    }
    
    public void updateRiver(){
        for(int i = 0; i < length; i++){
            updateCell(i);
        }
    }
    
    @Override
    public String toString(){
        String output = "";
        
        for(int i = 0; i < length; i++){
            Animal animal = array[i];
            if(animal == null){
                output = output + "--- ";
            }else{
                output = output + animal.toString() + " ";
            }
        }
        
        return output;
    }
    
}
