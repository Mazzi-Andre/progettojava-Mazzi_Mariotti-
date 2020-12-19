package Stats_Filter;


public class Date_Filter {
	
	public Date_Filter () {}
	
	public boolean check (int o1[], int o []) {   
			
		if (o1[0]==o[0] && o1[1]==o[1] && o1[2]==o[2]) return false;		
		else return true;
	}
}
