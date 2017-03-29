package logic;

import model.SumResult;

import java.util.List;

/**
 * Created by Eugene on 29-Mar-17.
 */
public class BusinessLogic {


    public SumResult calculate(List<Integer> args){
        int sum = 0;
        for (Integer arg : args) {
            sum+=arg;
        }
        return new SumResult(sum);
    }
}
