/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems;

import java.util.ArrayList;

/**
 *
 * @author hamid
 */
public class Balanced_Sequence implements OptimizationProblem {

    int k;
    ArrayList<Integer> sequence = new ArrayList<>();

    public Balanced_Sequence(int k, int[] array) {
        this.k = k;
        for (int i = 0; i < 3 * k; i++) {
            sequence.add(array[i]);
        }
    }

    @Override
    public State initialState() {
        return new Balanced_Sequence_State(k, sequence);
    }

    @Override
    public ArrayList<Action> actions(State s) {
        Balanced_Sequence_State balanced_Sequence_State = (Balanced_Sequence_State) s;
        ArrayList<Action> actions = new ArrayList<>();
        int a = balanced_Sequence_State.arrayList.size();
        for (int i = 0; i < a; i++) {
            for (int j = i + 1; j < a; j++) {
                //add all possible actions
                actions.add(new Balanced_Sequence_Action(i, j));
            }
        }
        return actions;
    }

    @Override
    public ArrayList<State> result(State s, Action a) {
        Balanced_Sequence_State bss = (Balanced_Sequence_State) s;
        Balanced_Sequence_Action bsa = (Balanced_Sequence_Action) a;
        Balanced_Sequence_State newState = new Balanced_Sequence_State(k, bss.arrayList);
        int i1 = bss.gett(bsa.firstIndex);
        int i2 = bss.gett(bsa.secondIndex);
        newState.set(bsa.firstIndex, i2);
        newState.set(bsa.secondIndex, i1);
        ArrayList<State> singleState = new ArrayList<>();
        singleState.add(newState);
        return singleState;
    }

    @Override
    public int eval(State s) {
        Balanced_Sequence_State balanced_Sequence_State = (Balanced_Sequence_State) s;

        ArrayList<Integer> arr1 = balanced_Sequence_State.arrayList;
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int i = 0; i < arr1.size() - 2; i += 3) {
            arr2.add(arr1.get(i) + arr1.get(i + 1) + arr1.get(i + 2));
        }

        int max = -1000000;
        for (int i = 0; i < arr2.size(); i++) {
            max = Math.max(max, arr2.get(i));
        }

        return max;
    }

}

class Balanced_Sequence_State implements State {

    private int k;
    public ArrayList<Integer> arrayList = new ArrayList<>();

    public Balanced_Sequence_State(int k, ArrayList<Integer> a) {
        this.k = k;
        for (int i = 0; i < a.size(); i++) {
            arrayList.add(a.get(i));
        }
    }

    public int gett(int i) {
        return arrayList.get(i);
    }

    public void set(int i, int val) {
        arrayList.set(i, val);
    }

    @Override
    public boolean isEquals(State s) {
        if (s instanceof Balanced_Sequence_State) {
            Balanced_Sequence_State balanced_Sequence_State = (Balanced_Sequence_State) s;
            boolean b = (k == balanced_Sequence_State.k);
            for (int i = 0; i < 3 * k; i++) {
                b = b && (arrayList.get(i) == balanced_Sequence_State.arrayList.get(i));
            }
            return b;
        } else {
            return false;
        }
    }

}

class Balanced_Sequence_Action extends Action {

    int firstIndex;
    int secondIndex;

    public Balanced_Sequence_Action(int firstIndex, int secondIndex) {
        super(firstIndex * 10 + secondIndex);
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
    }

}
