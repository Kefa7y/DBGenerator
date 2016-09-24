
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
	
	private static final int MAX_CUP = 2680;
	private static final int MAX_PLAYED = 22;
	private static ArrayList<Integer> pele = new ArrayList <Integer>();
	private static int count =0;
	private static final String [] ROUND = {"32nd", "16th", "quarter_final","SemiFinal", "Final"};
	private static final String DEL = ",";
	private static final String [] NAMES = {"messi", "ronaldinho", "ronaldo","pirlo", "valdes","beckham","zico",
			"maradona","zidan","neymar","gomaa","rooney","nani","saha","giggs","carlos","scholes","robin","ibrahimovic",
			"schweinsteiger","dida","buffon","marcelo","hadary","abotreika","shenawy","neuer","ferdinand","carick",
			"bale","isco","pique","puyol","ramos","pepe","evra","zambrotta","modiric","krus","mata","iniesta","xavi",
			"ozil","kefahy","shokr","baha","eyes","sayedov","rabeea","tharwat","baher","soli","rady","wael","shahwar",
			"haswaka","badr","hoda","keemo","tolba","kahraba","shikabata","salah","neni","shaarawy","gedo","khafagy",
			"shanawany"};
	
	public static void main(String[] args) throws IOException {
		FileWriter cup = new FileWriter("CUP_MATCHES.txt");
		FileWriter play = new FileWriter("PLAYED_IN.txt");		
		
		for(int i =0;i<118;i++){
			int r;
			boolean f;
			do{
				f=false;
				r = (int) (Math.random()*58960);
				int start =r-(r%22);
				for(int j =0;j<22;j++)
					if(pele.contains(start+j)){
						f=true;
						break;
					}
						
			}while(f);
			pele.add(r);
			System.out.println(i);
		}
		
		for(int i = 0 ; i<MAX_CUP;i++){
			int year= randomYear();
			cup.append(""+i+DEL+randomRound()+DEL+year+DEL+randomNumRating()+DEL+randomRating()+"\n");
			HashSet<String> x = new HashSet<String>();
			for(int j =0;j<MAX_PLAYED;j++){
				play.append(""+i+DEL+randomName(x)+DEL+year+DEL+randomPosition()+"\n");
			}
		}
		
		cup.flush();
		play.flush();
		cup.close();
		play.close();
	}
	
	public static int randomYear(){
		return (int)(Math.random()*30 + 1986);
	}
	
	public static String randomRound(){
		return ROUND[(int)(Math.random()*ROUND.length)];
	}
	
	public static int randomNumRating(){
		return (int)(Math.random()*2000 + 51);
	}
	
	public static Double randomRating(){
		Double d = Math.random()*10 + 1;
		DecimalFormat df = new DecimalFormat("####0.00");
		return Double.parseDouble(df.format(d));
	}
	
	public static String randomName(HashSet<String> x){
		if(pele.contains(count++))
			return "pele";
		String s;
		do{ 
			s =NAMES[(int)(Math.random()*NAMES.length)];
				}while(!x.add(s));
		return s;
	}
	
	public static int randomPosition(){
		return (int)(Math.random()*10 + 1);
	}
	
}
