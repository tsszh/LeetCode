package Medium2;

import java.util.*;

public class LT115 {
	public static void main ( String[] args ) {
		System.out.println(numDistinct(
				"xslledayhxhadmctrliaxqpokyezcfhzaskeykchkmhpyjipxtsuljkwkovmvelvwxzwieeuqnjozrfwmzsylcwvsthnxujvrkszqwtglewkycikdaiocglwzukwovsghkhyidevhbgffoqkpabthmqihcfxxzdejletqjoxmwftlxfcxgxgvpperwbqvhxgsbbkmphyomtbjzdjhcrcsggleiczpbfjcgtpycpmrjnckslrwduqlccqmgrdhxolfjafmsrfdghnatexyanldrdpxvvgujsztuffoymrfteholgonuaqndinadtumnuhkboyzaqguwqijwxxszngextfcozpetyownmyneehdwqmtpjloztswmzzdzqhuoxrblppqvyvsqhnhryvqsqogpnlqfulurexdtovqpqkfxxnqykgscxaskmksivoazlducanrqxynxlgvwonalpsyddqmaemcrrwvrjmjjnygyebwtqxehrclwsxzylbqexnxjcgspeynlbmetlkacnnbhmaizbadynajpibepbuacggxrqavfnwpcwxbzxfymhjcslghmajrirqzjqxpgtgisfjreqrqabssobbadmtmdknmakdigjqyqcruujlwmfoagrckdwyiglviyyrekjealvvigiesnvuumxgsveadrxlpwetioxibtdjblowblqvzpbrmhupyrdophjxvhgzclidzybajuxllacyhyphssvhcffxonysahvzhzbttyeeyiefhunbokiqrpqfcoxdxvefugapeevdoakxwzykmhbdytjbhigffkmbqmqxsoaiomgmmgwapzdosorcxxhejvgajyzdmzlcntqbapbpofdjtulstuzdrffafedufqwsknumcxbschdybosxkrabyfdejgyozwillcxpcaiehlelczioskqtptzaczobvyojdlyflilvwqgyrqmjaeepydrcchfyftjighntqzoo", 
				"rwmimatmhydhbujebqehjprrwfkoebcxxqfktayaaeheys"
				));
	}
	public static int numDistinct(String s, String t) {
        if ( s==null || t==null || s.length() < t.length() || t.length() == 0 ) return 0;
        int[] prev = new int[s.length()+1];
        Arrays.fill(prev, 1);
        int[] curr = new int[prev.length];
        for ( int i = 0; i < t.length() && prev[prev.length-1]!=0; i++ ) {
        	char tch = t.charAt(i);
        	curr[i]=0;
        	for ( int j = i+1; j < curr.length; j++ ) {
        		if ( s.charAt(j-1) == tch ) {
        			curr[j] = curr[j-1]+prev[j-1];
        		} else {
        			curr[j] = curr[j-1];
        		}
        	}
        	int[] temp = curr;
        	curr = prev;
        	prev = temp;
        }
        return (int)prev[prev.length-1];
    }
}
