import java.util.*;

public class RepeatingNumbers0{

    public static ArrayList<Integer> numbers = new ArrayList<Integer>();
    public static HashMap<String,Integer> patterncounts = new HashMap<String,Integer>();
    public static ArrayList<String> patterns = new ArrayList<String>();
	
    public static void main(String[] args){

	    Scanner keyb = new Scanner(System.in);

	    System.out.println("Enter number to check is there are repeated numbers in it:");
	    String num  = keyb.nextLine();
	    
	    // break the number down
	    char[] nums = num.toCharArray();

	    // collect patterns into arraylist
	    for (int i=0; i < nums.length;i++){
		patterns.add(0,Character.toString(nums[i]));
		for (int j=i+1; j<nums.length;j++){
		    String number = combine(patterns.get(0)
					    ,Character.toString(nums[j]));
		    if (patterns.contains(number)) continue;
		    patterns.add(0,number);
		}
	    }

	    /*
	    for (int i=0; i<patterns.size();i++){
		System.out.println(patterns.get(i));
       
	    }
	    */
	    
	    
	    // print out patterns
	    for (int i=0; i<patterns.size();i++){
		String pat = patterns.get(i);
	        int count = contains(pat,num);
		patterncounts.put(pat,count);
       
	    }

	    for(String number: patterncounts.keySet()){
		if ((patterncounts.get(number)>1)
		    && (number.length()>=2)){
		    System.out.println(number+":"+(patterncounts.get(number)));
		}
	    }
	    
	    
    }

    public static String combine(String a, String b){
	return a+b;
    }

    public static int numberLength(int number){
	int count = 0;
	while(number>0){
	    number = (number - number%10)/10;
	    count++;
	}
	return count;
    }
    
    public static int contains(String pattern, String number){
	int count = 0;
	int lengthPat = pattern.length();

	//System.out.println(pattern+":"+number);
	
	for (int i=0; i<number.length();i++){
	    if (i+lengthPat>number.length()) continue;
	    String snum  = number.substring(i,i+lengthPat);
	    //System.out.println("snum is:"+snum+"\npat is:"+pattern);
	    if (snum.equals(pattern))
		count++;
	    else
		continue;
	}
	return count;
    }
}
