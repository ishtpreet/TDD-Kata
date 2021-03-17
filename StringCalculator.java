class StringCalculator{
    public static int Add(String numbers){
        if(numbers == ""){
          //Empty String
          return 0;
        }
        //Finding delimiter
        String delimiterS;
        char delimiter;
        delimiterS = numbers.substring(2, numbers.indexOf("\n"));
        delimiter = delimiterS.charAt(0);
        // System.out.println("Delimeter: "+delimiter);
        //Counting occurence of delimiter
        String numberString;
        numberString = numbers.substring(numbers.indexOf("\n")+1,numbers.length());
        // System.out.println("New String: "+numberString);
        
        // For one and two Numbers in the String
        int delimerCount = 0;
        //Counter Number of Occurences of Delimeter 
        for(int i=0;i<numberString.length();i++){
          if(numberString.charAt(i) == delimiter){
            delimerCount++;
          }
        }
        // System.out.println("Delimeter Count: "+delimerCount);
        //Single Interger in the String
        if(delimerCount == 0){
          return Integer.parseInt(numberString);
        }

        //Two or more Numbers in the String
        //Pushing numbers to array
        String[] strNumbers = numberString.split(delimiterS);
        int Sum=0;
        for(int i=0;i<strNumbers.length;i++){
        Sum += Integer.parseInt(strNumbers[i]);
        // System.out.println(strNumbers[i]);
        }
        return Sum;        
      }

    public static void main(String[] args){
      //Empty String
        System.out.println(Add(""));
        //one and more numbers
        System.out.println(Add("//,\n1"));
        System.out.println(Add("//;\n2;3"));
        System.out.println(Add("//,\n2,3,6,4,3,1,3,2,332,3"));
    }
}