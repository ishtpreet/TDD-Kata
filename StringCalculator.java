class StringCalculator{
    public static int Add(String numbers){
        if(numbers == ""){
          //Empty String
          return 0;
        }
        //For one and two Numbers in the String
        int commaCount = 0;
        //Counter Number of Occurences of Comma 
        for(int i=0;i<numbers.length();i++){
          if(numbers.charAt(i) == ',' || numbers.charAt(i) == '\n'){
            commaCount++;
          }
        }
        //Single Interger in the String
        if(commaCount == 0){
          return Integer.parseInt(numbers);
        }
        //Two or more Numbers in the String
        //Replacing \n with comma
        numbers = numbers.replace('\n',',');
        String[] strNumbers = numbers.split(",");
        int Sum=0;
        for(int i=0;i<strNumbers.length;i++){
        Sum += Integer.parseInt(strNumbers[i]);
        }
        return Sum;
        
      }
    public static void main(String[] args){
        System.out.println(Add(""));
        System.out.println(Add("1"));
        System.out.println(Add("2,3"));
        System.out.println(Add("2\n3\n6,4,3,1,3,2,332,3"));
    }
}