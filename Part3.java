
/**
 * @author (Nesma Abouzaid) 
 * @version (6/26/2023)
 */
public class Part3 {
        public int findStopCodon(String dna, int startIndex, String stopCodon) {
		int currIndex = dna.indexOf(stopCodon, startIndex + 3);
		while(currIndex != -1) {
			int diff = currIndex - startIndex;
			if(diff % 3 == 0) {
				return currIndex;
			} else {
				currIndex = dna.indexOf(stopCodon, currIndex + 1);
			}
		}

		return -1;
	}

	public String findGene(String dna, int where) {
		int startIndex = dna.indexOf("ATG", where);
		if(startIndex == -1 || where == -1) {
			return "";
		}

		int taaIndex = findStopCodon(dna, startIndex, "TAA");
		int tagIndex = findStopCodon(dna, startIndex, "TAG");
		int tgaIndex = findStopCodon(dna, startIndex, "TGA");

		int minIndex = 0;

		if(taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)) {
			minIndex = tgaIndex;
		} else {
			minIndex = taaIndex;
		}

		if(minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)) {
			minIndex = tagIndex;
		}

		if(minIndex == -1) {
			return "";
		}

		return dna.substring(startIndex, minIndex + 3);
	}
	
	public int countGenes (String dna){
	    int noOfGenes = 0;
	    int startIndex = 0;
	    while(true){
	        String wholeGene = findGene(dna, startIndex);
	        if(wholeGene.isEmpty()){
	            break;
	           }
	           System.out.println("Gene found: " + wholeGene);
	           startIndex = dna.indexOf(wholeGene, startIndex)+wholeGene.length();
	       }   
	    return noOfGenes;
	   }
	   
    public void testLast(){
        String dna = "ATGATCTAATTTATGaaaaaaaaaTGAAGA";
        System.out.println("Testing printGenes here " + dna);
        countGenes(dna);
    }


}
