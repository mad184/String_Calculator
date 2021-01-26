public class StringCalculator {

    /**
     * A string calculator that receive as input a String with numbers separated
     *   by a ",". The function add the numbers and return it as int.
     *
     * @param numbers - The String with numbers separated by ","
     * @return the sum of the numbers
     */
    public static int add(String numbers){

        if (numbers.isEmpty()){
            return 0;
        }else {
            String[] splitString = numbers.split(",");
            int totalSum = 0;

            for (String s : splitString) {
                totalSum += Integer.parseInt(s);
            }
            return totalSum;
        }
    }

    public static void main(String[] args) {

    }
}
