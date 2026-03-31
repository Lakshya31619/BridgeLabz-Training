public class OtpGeneration {
    public static void main(String[] args) {
        //Array to store 10 OTP numbers
        int[] otps = new int[10];
        //Generate 10 OTPs
        for(int i = 0; i < otps.length; i++){
            //Calling method generateOTP
            otps[i] = generateOTP();
        }
        //Display generated OTPs
        for(int i = 0; i < otps.length; i++){
            System.out.println("OTP " + (i + 1) + ": " + otps[i]);
        }
        //Calling method isUnique
        boolean unique = isUnique(otps);
        //Output result
        if(unique){
            System.out.println("All generated OTPs are unique");
        }else{
            System.out.println("Generated OTPs are not unique");
        }
    }
    //Method to generate 6-digit OTP
    public static int generateOTP(){
        int otp = (int)(Math.random() * 900000) + 100000;
        return otp;
    }
    //Method to check if OTPs are unique
    public static boolean isUnique(int[] otps){
        for(int i = 0; i < otps.length; i++){
            for(int j = i + 1; j < otps.length; j++){
                if(otps[i] == otps[j]){
                    return false;
                }
            }
        }
        return true;
    }
}