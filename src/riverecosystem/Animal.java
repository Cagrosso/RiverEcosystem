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
public abstract class Animal {
    protected enum Gender{
        FEMALE, MALE;
        
        // allows to select random gender
        public static Gender getRandom(){
            return values()[(int) (Math.random() * values().length)];
        }
    }
    
    protected Gender gender;
    protected int age;
    
    public Animal(){
        Random rd = new Random();
        gender = Gender.getRandom();
        age = rd.nextInt(4);
    }  
    
    public Animal(int age, Gender gender){
        this.age = age;
        this.gender = gender;
    }
    
    public int getAge(){
        return age;
    }
    
    abstract boolean maxAge();
    
    abstract boolean incrAge();
    
}
