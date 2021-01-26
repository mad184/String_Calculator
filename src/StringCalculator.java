import org.junit.Test;


public class StringCalculator {

    /**
     * A string calculator that receive as input a String with numbers separated
     *   by a delimiter that is in between "//" and "\n". The function add the numbers and return it as int.
     *
     * @param numbers - The String with numbers separated by ","
     * @return the sum of the numbers
     */
    public static int add(String numbers) throws Exception {

        if (numbers.isEmpty()){
            return 0;
        }else {
            String[] halfSplit = numbers.split("\n");

            String delimiter = halfSplit[0].substring(2);

            if (halfSplit.length > 2){
                String joinSplit = "";
                for (int i = 1; i < halfSplit.length; i++){
                    joinSplit += halfSplit[i];
                }
                halfSplit[1] = joinSplit;
            }

            String[] splitString = halfSplit[1].split("["+delimiter+"]");

            int totalSum = 0;

            for (String s : splitString) {
                if (s.isBlank()){
                    return 0;

                }else if (s.contains("\n")){
                    s = s.trim();
                    if (Integer.parseInt(s) < 0){
                        throw new Exception("Negatives not allowed, number " + s + " is negative, therefore not allowed");
                    }

                    totalSum += Integer.parseInt(s);

                } else if(s.length()==4) {
                    if (Integer.parseInt(s) < 0){
                        throw new Exception("Negatives not allowed, number " + s + " is negative, therefore not allowed");
                    }

                    int firstNumber = Integer.parseInt(String.valueOf(s.charAt(0)));
                    int lastNumber = Integer.parseInt(String.valueOf(s.charAt(s.length()-1)));

                    if (firstNumber == 1 && lastNumber == 0){
                        totalSum += Integer.parseInt(s);
                    }else if (firstNumber == 0){
                        totalSum += Integer.parseInt(s);
                    }

                } else if (s.length() < 4){

                    if (Integer.parseInt(s) < 0){
                        throw new Exception("Negatives not allowed, number " + s + " is negative, therefore not allowed");
                    }
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
    public void rightSumTest() throws Exception {
        String numberTest_1 = "//;\n1;1001;0";
        String numberTest_2 = "//@\n2@3@009998";
        String numberTest_3 = "///\n0/75/5";
        String numberTest_4 = "// \n1 0 1000";
        String numberTest_5 = "//*\n1*\n2*3";
        String numberTest_6 = "//+\n5+0+-1000";

        if (add(numberTest_1) != 1){
            System.out.println("The expected result was 1, instead it was "+ add(numberTest_1));
        }
        if (add(numberTest_2) != 5){
            System.out.println("The expected result was 5, instead it was "+ add(numberTest_2));
        }
        if (add(numberTest_3) != 80){
            System.out.println("The expected result was 80, instead it was "+ add(numberTest_3));
        }
        if (add(numberTest_4) != 1001){
            System.out.println("The expected result was 1001, instead it was "+ add(numberTest_4));
        }
        if (add(numberTest_5) != 6){
            System.out.println("The expected result was 6, instead it was "+ add(numberTest_5));
        }
        if (add(numberTest_6) != 5){
            System.out.println("The expected result was 5, instead it was "+ add(numberTest_6));
        }

        try {
            String negativeNumberTest1 = "//;\n-101;3;-4";
            add(negativeNumberTest1);
        }catch (Exception e){
            System.out.println("Exception - "+ e + " - caught");
        }

        try{
            String negativeNumberTest2 = "//@\n2@\n-3@8";
            add(negativeNumberTest2);
        }catch (Exception e){
            System.out.println("Exception - "+ e + " - caught");
        }

    }

    public static void main(String[] args) throws Exception {

        String numberTest_1 = "//;\n1;09099";
        String numberTest_2 = "//@\n2@3@8";
        String numberTest_3 = "///\n0/75/\n5";
        String numberTest_4 = "// \n0 0 30";
        String numberTest_5 = "//*\n1\n*2*3";

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
