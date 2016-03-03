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
public class Bear extends Animal{
    
    public static final int MAX_AGE = 9;
    
    public Bear(){
        Random rd = new Random();
        super.age = rd.nextInt(MAX_AGE + 1);
        super.gender = Gender.getRandom();
    }
    
    public Bear(int age, Gender gender){
        super(age, gender);
    }

    @Override
    boolean maxAge() {
        if(super.age >= MAX_AGE){
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
    
    public int getStrength(){
        return 9 - super.age;
    }
    
    public String toString(){
        String output = "B";
        
        if(gender == Gender.MALE){
            output = output + "M";
        }else{
            output = output + "F";
        }
        
        output = output + age;
        
        
        return output;
    }
}
