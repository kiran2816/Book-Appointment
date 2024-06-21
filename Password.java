public class Password {
    
    public static void main(String[] args){
       Registration obj1 = new Registration();
       Password obj = new Password();
         String str = new String(obj1.passwordfield.getPassword())  ;
        System.out.println(obj.password(str));
    }
      boolean password(String str){
        boolean[] b = new boolean[4];

        if(str.length() < 8){
            return false;
        }
        else{
            for(int i=0; i < str.length(); i++){
                if((str.charAt(i) >= 33 && str.charAt(i) <= 47) || (str.charAt(i) >= 58 && str.charAt(i) <= 64) || (str.charAt(i) >=91 && str.charAt(i) <= 96) || (str.charAt(i) >= 123 && str.charAt(i) <= 126) && b[0]== false){
                    b[0] = true; 
                    continue;
                }
               else if(Character.isUpperCase(str.charAt(i)) && b[1]== false){
                    b[1] = true;
                   // continue;
                }
               else if(Character.isLowerCase(str.charAt(i))&& b[2]== false){
                    b[2] = true;
                   // continue;
                }
               else if(Character.isDigit(str.charAt(i))&& b[3]== false){
                    b[3] = true;
                   // continue;
                }
        }

        }
        for(int i=0; i<4; i++){
            if(b[i] == false){
                return false;
            }
        }

        return true;
    }
}
