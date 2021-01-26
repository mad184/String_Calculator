import org.junit.Test;

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
                if (s.isBlank()){
                    return 0;
                }else {
                    totalSum += Integer.parseInt(s);
                }
            }
            return totalSum;
        }
    }

    /**
     * A test that compares the values expected with the actual value return by the method add()
     */
    @Test
    public void rightSumTest(){
        String numberTest_1 = "1,2,5";
        String numberTest_2 = "1,1,1";
        String numberTest_3 = "0,75,5";
        String numberTest_4 = "";
        String numberTest_5 = " ";

        if (add(numberTest_1) != 8){
            System.out.println("The expected result was 8, instead it was "+ add(numberTest_1));
        }
        if (add(numberTest_2) != 3){
            System.out.println("The expected result was 3, instead it was "+ add(numberTest_2));
        }
        if (add(numberTest_3) != 80){
            System.out.println("The expected result was 80, instead it was "+ add(numberTest_3));
        }
        if (add(numberTest_4) != 0){
            System.out.println("The expected result was 0, instead it was "+ add(numberTest_4));
        }
        if (add(numberTest_5) != 0){
            System.out.println("The expected result was 0, instead it was "+ add(numberTest_5));
        }
    }

    public static void main(String[] args) {

        String numberTest_1 = "1,2,5";
        String numberTest_2 = "1,1,1";
        String numberTest_3 = "0,75,5";
        String numberTest_4 = "";
        String numberTest_5 = " ";

        int result1 = add(numberTest_1);
        int result2 = add(numberTest_2);
        int result3 = add(numberTest_3);
        int result4 = add(numberTest_4);
        int result5 = add(numberTest_5);

        System.out.println("The outputs from each entries are: \n" +
                "Sum for string numberTest_1 = " + result1 +
                "\nSum for string numberTest_2 = " + result2 +
                "\nSum for string numberTest_3 = " + result3 +
                "\nSum for string numberTest_4 = " + result4 +
                "\nSum for string numberTest_5 = " + result5);
    }
}
