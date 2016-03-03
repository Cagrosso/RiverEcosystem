/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riverecosystem;

/**
 *
 * @author Cagrosso
 */
public class RiverEcosystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        River ecosystem = new River(10);
        for(int i = 0; i < 50; i++){
            ecosystem.updateRiver();
            //System.out.println("After cycle " + i + ": ");
            System.out.println(ecosystem.toString());
            //System.out.println();
        }
    }
    
}
