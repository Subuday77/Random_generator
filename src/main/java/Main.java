import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        boolean useSmartGeneration = false;
        boolean generate = true;
        ArrayList<Integer> roundRes = new ArrayList<>();
        int numberOfRounds;
        int numberOfLines;
        int numberOfRoundsToTake;
        int expectedValue = 114;
        int range = 8;
        int maxBound = 37;
        int minBound = 1;
        int maxSum = expectedValue + range;
        int minSum = expectedValue - range;
        if (useSmartGeneration) {
            numberOfRoundsToTake = 20000;
        } else {
            numberOfRoundsToTake = 2324784;
        }
        if (!generate) {
            numberOfRounds = 10;
        } else {
            numberOfRounds = 1;
        }
        while (numberOfRounds > 0) {
            if (!generate) {
                numberOfLines = numberOfRoundsToTake;
            } else {
                numberOfLines = 40;
            }
            ArrayList<Integer> numbersSequence = new ArrayList<>();
            ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
            ArrayList<Integer> exact = new ArrayList<>();
            HashMap<Integer, Integer> result = new HashMap<>();
            result.put(0, 0);
            result.put(1, 0);
            result.put(2, 0);
            result.put(3, 0);
            result.put(4, 0);
            result.put(5, 0);
            result.put(6, 0);
            while (numberOfLines > 0) {
                ArrayList<Integer> combination = new ArrayList<>();
                while (combination.size() < 6) {
                    int temp = getRandomNumber(maxBound, minBound, useSmartGeneration);
                    if (!combination.contains(temp)) {
                        combination.add(temp);
                    }
                }
                combination.sort(null);
                int sum = 0;
                for (int number : combination) {
                    sum = sum + number;
                }
                if (sum <= maxSum && sum >= minSum) {
                    if (!generate) {
                        int fits = checkCombination(combination);
                        if (fits == 6) {
                            exact.add(numberOfRoundsToTake - numberOfLines);
                        }
                        result.replace(fits, result.get(fits) + 1);
                    } else {
                        combinations.add(combination);
                    }
                    numberOfLines--;
//                    System.out.println(numberOfLines);
                }
                if (useSmartGeneration) {
                    DB.numbersSequence = (ArrayList<Integer>) DB.reservedNumberSequence.clone();
                }
            }
            if (!generate) {
                roundRes.add(exact.size());
                printResults(result, exact, roundRes);
            } else {
                printCombinations(combinations);
            }
            numberOfRounds--;
        }
    }

    private static int getRandomNumber(int max, int min, boolean smartGeneration) {
        if (!smartGeneration) {
            return (int) (Math.random() * ((max + 1) - min) + min);
        }
        int res = DB.numbersSequence.get((int) (Math.random() * DB.numbersSequence.size()));
        DB.numbersSequence.removeIf(x -> x == res);
        return res;
    }

    private static void printCombinations(ArrayList<ArrayList<Integer>> combinations) {
        System.out.println("Number\t1\t2\t3\t4\t5\t6");
        int i = 1;
        for (ArrayList<Integer> combination : combinations) {
            String combString = String.valueOf(combination).replace("[", "").replace("]", "").replace(",", "\t");
            System.out.println(i + "\t" + combString);
            i++;
        }
    }

    private static void printResults(HashMap<Integer, Integer> result, ArrayList<Integer> exact, ArrayList<Integer> roundRes) {
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println(exact);
        System.out.println(String.valueOf(roundRes).replace("[", "").replace("]", "").replace(",", "\t"));
    }

    private static int checkCombination(ArrayList<Integer> combination) {
        int[] combinationToCatch = {2,	12,	13,	23,	25,	30,}; //105
        int fits = 0;
        for (int number : combinationToCatch) {
            if (combination.stream().anyMatch(x -> x.equals(number))) {
                fits++;
            }
        }
        return fits;
    }

//    private static ArrayList<Integer> createSequence() {
//        ArrayList<Integer> numbersSequence = new ArrayList<>();
//        for (int key : DB.numbersCount.keySet()) {
//            for (int i = 0; i < DB.numbersCount.get(key); i++) {
//                numbersSequence.add(key);
//            }
//        }
//        return numbersSequence;
//    }
}
