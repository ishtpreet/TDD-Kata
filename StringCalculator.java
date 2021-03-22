class NegativeNumberException extends RuntimeException{
  NegativeNumberException(String s){
    super(s);
  }
}

class StringCalculator{
    public static int Add(String numbers) throws NegativeNumberException{
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
          try{
            if(Integer.parseInt(numberString)<0){
              throw new NegativeNumberException("negatives not allowed");
            }
            else{
              return Integer.parseInt(numberString);
            }
          }
          catch(NegativeNumberException e){
            System.out.println(e.getMessage()+": "+numberString);
            return -1;
          }
        }

        //Two or more Numbers in the String
        //Pushing numbers to array
        String[] strNumbers = numberString.split(delimiterS);
        int Sum=0;
        boolean negatives = false;
        for(int i=0;i<strNumbers.length;i++){
          try{
            if(Integer.parseInt(strNumbers[i])<0){
              throw new NegativeNumberException("negatives not allowed");
            }
            else{
              // System.out.println(strNumbers[i]);
              Sum += Integer.parseInt(strNumbers[i]);
            }
          } catch (NegativeNumberException e) {
            System.out.println(e.getMessage()+": "+strNumbers[i]);
            negatives = true;
            continue;
          }
        }
        if(negatives){
          return -1;
        }
        return Sum;        
      }

    public static void main(String[] args){
      //Empty String
        int result=0; 
        result = Add("");
        if(result!=-1){
          System.out.println(result);
        }
        //one and more numbers
        result = Add("//,\n-1");
        if(result!=-1){
          System.out.println(result);
        }
        result = Add("//;\n-2;-3");
        if(result!=-1){
          System.out.println(result);
        }
        result = Add("//,\n2,3,6,4,3,1,3,2,332,3");
        if(result!=-1){
          System.out.println(result);
        }
    }
}