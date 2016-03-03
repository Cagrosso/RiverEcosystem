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
public class Fish extends Animal{
    
    public static final int MAX_AGE = 4;
    
    public Fish(){
        Random rd = new Random();
        super.age = rd.nextInt(MAX_AGE + 1);
        super.gender = Gender.getRandom();
    }
    
    public Fish(int age, Gender gender){
        super(age, gender);
    }

    @Override
    boolean maxAge() {
        if(super.getAge() >= MAX_AGE){
            return true;
        }else{
            return false;
        }
    }

    @Override
    boolean incrAge() {
        if(maxAge()){
            return false;
        }else{
            super.age++;
            return true;
        }
    }
    
    public String toString(){
        String output = "F";
        
        if(gender == Gender.MALE){
            output = output + "M";
        }else{
            output = output + "F";
        }
        
        output = output + age;
        
        
        return output;
    }
    
}
