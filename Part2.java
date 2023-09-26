
/**
 * @author (Nesma Abouzaid) 
 * @version (6/20/2023)
 */
public class Part2 {    
    public int howMany(String stringa, String stringb){
        int numOfOcc = 0;
        int index1 = stringb.indexOf(stringa);
        if(index1 > -1){
                numOfOcc++;
                while (stringb.indexOf(stringa, index1) != -1 && index1 !=-1){
                       numOfOcc++; 
                       index1 = stringb.indexOf(stringa, index1+stringa.length());
                }
                numOfOcc = numOfOcc -1;
                } else {
                    numOfOcc = 0;
                }
                return numOfOcc;
        
        }
             

   
    public void testing(){
        System.out.println(howMany("GAA","ATGAACGAATTGAATC"));
        System.out.println(howMany("AA","ATAAAA"));
        
        
    }

}
