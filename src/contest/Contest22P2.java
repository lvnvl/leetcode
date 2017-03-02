package contest;

public class Contest22P2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] pic = {
				{'W','W','B'},
				{'W','B','W'},
				{'B','W','W'}};
		System.out.println(Contest22P2.findLonelyPixel(pic));
	}
	public static int findLonelyPixel(char[][] picture) {
		int i = 0, j = 0, z = 0;
		int result = 0;
        for(i = 0; i < picture.length; i++){
        	for(j = 0; j < picture[i].length; j++){
        		if(picture[i][j] == 'B'){
        			boolean found = false;
        			for(z = 0; z < picture[i].length; z ++){
        				if(picture[i][z] == 'B' && z != j){
        					found = true;
        					break;
        				}
        			}
        			for(z = 0; z < picture.length; z ++){
        				if(picture[z][j] == 'B' && z != i){
        					found = true;
        					break;
        				}
        			}
        			if(!found){
        				result ++;
        			}
        		}
        	}
        }
        return result;
    }
}
