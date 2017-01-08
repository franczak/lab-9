package poslowie;

public class OptionParser {
	private String[] args;
	private String firstName="0";
	private String lastName;
	private String cadency="0";
	private String option;
	private boolean bool=false;
	private String name;
	public OptionParser(String[] args){
		this.args=args;
	}
	
	public void ParseOptions() throws Exception{
		for(int i=0; i<args.length; i++){
				if(args[i].equals("-n")){
					firstName=args[i+1];
					lastName=args[i+2];
				}
				if(args[i].equals("-c")){
					cadency=args[i+1];
					if(!cadency.equals("7") && !cadency.equals("8")){
						System.err.println("You enter wrong cadency!");
						break;
					}
				}
				
				if(args[i].equals("-h")){
					System.out.println("Available options:");
					System.out.println("-c + enter a cadency");
					System.out.println("-n + enter firstname and lastname");
					System.out.println("-o + enter an option");
					System.out.println("s - total expenses of one member");
					System.out.println("d - incidental expenses");
					System.out.println("A - average spendings");
					System.out.println("nd - most days in travel");
					System.out.println("me - most expensive travel");
					System.out.println("i - Italy visitors");
					System.out.println("mt - most travels");
				}
				
				if(args[i].equals("-o")){
					option=args[i+1];
					bool=true;
				}
			}
			if(bool && !cadency.equals("0")){
				if(option.equals("A")){
					AvgExpenses avg = new AvgExpenses(cadency);
					System.out.println("The average expenses of "+cadency+" cadency is "+avg.AverageExpenses());
				}
				if(option.equals("nd")){
					MostDaysInTravel most=new MostDaysInTravel();
					System.out.println(most.FindName(cadency) + " had the most days in travel in "+cadency+" cadency");
				}
				if(option.equals("me")){
					MostExpensiveTravel travel=new MostExpensiveTravel();
					System.out.println(travel.FindMostExpensive(Integer.parseInt(cadency))+" had the most expensive travel in "+cadency+" cadency");
				}
				if(option.equals("i")){
					ItalyVisitors italy=new ItalyVisitors();
					System.out.println("Italy visitors in "+cadency+" cadency:");
					italy.FindVisitors(Integer.parseInt(cadency));
				}
				if(option.equals("mt")){
					FindMostQuantity find= new FindMostQuantity();
					System.out.println(find.FindName(cadency)+" had the most travels in "+cadency+" cadency");
				}
			}else
			if(bool && !firstName.equals("0")){
			if(option.equals("s")){
				AllExpenses all=new AllExpenses();
				FindId id=new FindId();
				name=id.IdFromName(firstName,lastName);
				if(!name.equals("0"))
				System.out.println("Sum of expenses of "+firstName+" "+lastName+": " +all.AllExp(name));
				else System.err.println("Wrong name!");
			}
			
			if(option.equals("d")){
				IncidentalExpenses exp=new IncidentalExpenses();
				FindId id=new FindId();
				name=id.IdFromName(firstName,lastName);
				if(!name.equals("0"))
				System.out.println("Incidental expenses of "+firstName+" "+lastName+": " +exp.InciExp(name));
				else System.err.println("Wrong name!");
			}
			}
			else{
				System.err.println("You entered wrong option!");
				System.err.println("Check option -h!");
			}

		
		}
			
}
