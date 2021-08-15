import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DB {

    public static ArrayList<Integer> numbersSequence;
    public static final ArrayList<Integer> reservedNumberSequence = new ArrayList<>();
    public static final Map<Integer, Integer> numbersCount = new HashMap<>();
    static { //14.08.21
        numbersCount.put(1, 328);
        numbersCount.put(2, 326);
        numbersCount.put(3, 340);
        numbersCount.put(4, 289);
        numbersCount.put(5, 305);
        numbersCount.put(6, 329);
        numbersCount.put(7, 298);
        numbersCount.put(8, 342);
        numbersCount.put(9, 312);
        numbersCount.put(10, 330);
        numbersCount.put(11, 346);
        numbersCount.put(12, 333);
        numbersCount.put(13, 316);
        numbersCount.put(14, 296);
        numbersCount.put(15, 303);
        numbersCount.put(16, 306);
        numbersCount.put(17, 322);
        numbersCount.put(18, 309);
        numbersCount.put(19, 298);
        numbersCount.put(20, 330);
        numbersCount.put(21, 338);
        numbersCount.put(22, 326);
        numbersCount.put(23, 307);
        numbersCount.put(24, 323);
        numbersCount.put(25, 332);
        numbersCount.put(26, 334);
        numbersCount.put(27, 311);
        numbersCount.put(28, 330);
        numbersCount.put(29, 328);
        numbersCount.put(30, 317);
        numbersCount.put(31, 303);
        numbersCount.put(32, 305);
        numbersCount.put(33, 310);
        numbersCount.put(34, 313);
        numbersCount.put(35, 229);
        numbersCount.put(36, 207);
        numbersCount.put(37, 225);
        numbersSequence = createSequence();
        copyArray(numbersSequence);
    }
//    public static final ArrayList<Integer> numbersSequence = createSequence();

    private static ArrayList<Integer> createSequence() {
        ArrayList<Integer> localNumbersSequence = new ArrayList<>();
        for (int key : DB.numbersCount.keySet()) {
            for (int i = 0; i < DB.numbersCount.get(key); i++) {
                localNumbersSequence.add(key);
            }
        }
        return localNumbersSequence;
    }
    private static void copyArray(ArrayList<Integer> numbersSequence) {
        String temp = String.valueOf(numbersSequence).replace("[","").replace("]","");
        String tempArray[] = temp.split(",");
        for (String number:tempArray) {
            reservedNumberSequence.add(Integer.parseInt(number.trim()));
        }
    }
}
