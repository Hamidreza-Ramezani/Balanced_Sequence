/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems;

/**
 *
 * @author hamid
 */

import java.util.ArrayList;

public interface OptimizationProblem {

    State initialState();

    ArrayList<Action> actions(State s);

    ArrayList<State> result(State s,Action a);

    int eval(State s);

}
