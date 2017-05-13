package logic;

import model.SumResult;

import java.util.List;

/**
 * Created by Eugene on 29-Mar-17.
 */
public class BusinessLogic {


    public SumResult calculate(List<Integer> args){
        Integer sum = 0;
        if (args.size()<2)
            return new SumResult(null);
        for (Integer arg : args) {

            sum+=arg;
        }
        System.out.println(sum);
        return new SumResult(sum);
    }
}
