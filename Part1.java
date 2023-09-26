
/**
 * @author (Nesma Abouzaid) 
 * @version (6/20/2023)
 */
public class Part1 {
    public String findGene(String dna){
        //Set the method that find the gene start with ATG, and has any of the 3 stop codons
        //Find 1st occurance of "ATG", startIndex
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1){
            return "";
        }else{
            int taaIndex = findStopCodon(dna, startIndex, "TAA");
            int tagIndex = findStopCodon(dna, startIndex, "TAG");      
            int tgaIndex = findStopCodon(dna, startIndex, "TGA"); 
            
            int minIndex = 0;
            if(taaIndex == -1 || (tagIndex != -1 && tagIndex < taaIndex)){
                minIndex = tagIndex;
            } else {
                minIndex = taaIndex;
            }
            
            if(minIndex == -1 || (tgaIndex != -1 && tgaIndex < minIndex)){
                minIndex = tgaIndex;
            } 
            
            if(minIndex == -1){
                return "";
            }
            
            return dna.substring(startIndex, minIndex +3);
        }
        
        
        //if startIndex == -1, return ""
        //use taaIndex to store findStopCodon(dna, startIndex, "TAA");
        //use tagIndex to store findStopCodon(dna, startIndex, "TAG");
        //use tgaIndex to store findStopCodon(dna, startIndex, "TGA");
        //Store in minIndex the samallest of three values
        //If minIndex is dna.length()? nothing found, return "";
        //otherwise answer is text from startIndex to minIndex  
    }
    
    public void testFindGene(){
    		String one = "ATFxxxyyyzzzTAAxxxTAGxxx";
		String two = "xxxATGxxxyyyxxTAGxTAAxxx";
		String three = "xyyATGxxxyyyuuuTGAxxxTAGxxx";
		String four = "xyyATGxxxyyxxxyuuuTGAxxxTAGxxx"; 
		
	        System.out.println("Gene is: " + one + " " + findGene(one));
		System.out.println("Gene is: " + two + " " + findGene(two));
		System.out.println("Gene is: " + three + " " + findGene(three));
		System.out.println("Gene is: " + four + " " + findGene(four));    
    }
    

    
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        //find stopCodon starting from (startIndex+3), currIndex
        int currIndex = dna.indexOf(stopCodon, startIndex+3);
        //as long as currIndex is not equal -1
        while (currIndex != -1){
           //check if currIndex - startIndex is multiple of 3
            if( (currIndex - startIndex)%3 ==0 ){
                //if so, currIndex is answer, return it
                return currIndex;
            }else{
           //if not, update currIndex, looking for stopCodon 
           currIndex = dna.indexOf(stopCodon, currIndex+1);
           //starting from currIndex+1
        }
        }
        //as long as currIndex is not equal -1
           //check if currIndex - startIndex is multiple of 3
           //if so, currIndex is answer, return it
           //if not, update currIndex, looking for stopCodon 
           //starting from currIndex+1
        //if we exit loop, we didn't find stopCodon
        //so return dna.length()
        return dna.length();
    }
    
    public void testFindStop(){
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxxy";
        int dex = findStopCodon(dna, 0, "TAA");
        System.out.println(dex);
        
        dex = findStopCodon(dna, 9,"TAA");
        System.out.println(dex);

        dex = findStopCodon(dna, 1,"TAA");
        System.out.println(dex);
        
        dex = findStopCodon(dna, 0,"TAG");
        System.out.println(dex);        
    }
    
    public void printAllGenes(String dna){
        while (true){
            String gene = findGene(dna);
            if (gene.isEmpty()){
                break;
            } else {
                System.out.println(gene);
            }
        }
    }
   


}
