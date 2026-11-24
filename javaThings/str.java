import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.zip.DataFormatException;

void main () {
    String name;
    String email;
    String age;
    do {
        name = IO.readln("Enter your name: ");

        if (name.equals("peanutButter")) {
            
            IO.println("enter ur email agent");
            email = IO.readln("Enter an email: ");
            
            if(email.contains("@")){
                IO.print("Your name is ");
                for (int j = 0; j < email.indexOf("@"); j++){
                    IO.print(email.charAt(j));
                }  
                IO.println("");
                IO.print("Under: ");
                for (int h = email.indexOf("@")+1; h < email.length(); h++){
                    
                    IO.print(email.charAt(h));
                }  
                 IO.println(""); 
                 break;
            }   else {
                IO.println("Error missing @");
                break;
            }
            

        } else if (name.equals("quit")){
            IO.println("");
        } else {
            IO.println("Welcome to this fyn establishment");
            
            for (int i = 0; i < name.length(); i++){
            
                IO.println(name.charAt(i));

            }

            IO.println("---backwards---");

            for (int i = name.length() - 1; i >= 0; i--){
            
                IO.println(name.charAt(i));

            }

            age = IO.readln("what year were u born?(dd/MMMM/yyyy)");
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MMMM/yyyy");
            try {
                LocalDate birthday = LocalDate.parse(age ,format);
                LocalDate today = LocalDate.now();
                
                long totalDays = ChronoUnit.DAYS.between(birthday, today);
                Period years = Period.between(birthday, today);
                
                IO.println("You are " + totalDays + " days old and " + years.getYears() + " years old");
            } catch (DateTimeParseException e) {
                IO.println("Enter proper format!");
            }

        } 
    } while (name.equals("quit") == false);


}