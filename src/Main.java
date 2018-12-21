
import algorithms.HillClimbing;
import algorithms.HillClimbingStrategy;
import problems.Balanced_Sequence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hamid
 */
public class Main {

    public static void main(String[] args) {

        int[] arr = {2, 8, 6, 5, 2, 0};
        Balanced_Sequence balanced_Sequence = new Balanced_Sequence(2,arr);
        HillClimbing HC = new HillClimbing();
        HC.solve(balanced_Sequence, HillClimbingStrategy.FIRST_CHOICE, false, 5);


        /*
        NQueenProblem Q = new NQueenProblem(8);
        SimulatedAnnealing SA = new SimulatedAnnealing();
        SA.solve(Q,SimulatedAnnealingStrategy.LINEAR_TEMPERATURE,false,100000);
         */
    }

}
