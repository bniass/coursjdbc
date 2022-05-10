package cours.ugb.ccos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Main1
{
    public static void main( String[] args )
    {
        try {
           //connexion à la base de données
            String url = "jdbc:mysql://localhost:3306/jdbc_ugb";
            Connection cnx = DriverManager.getConnection(url,"root","");
           //Disposer d'un objet me permettant d'executer des requetes sql
            Statement psmt = cnx.createStatement();
           //executer les requettes sql
            Scanner sc = new Scanner(System.in);
            System.out.print("saisir le nom : ");
            String nom = sc.nextLine();
            System.out.print("saisir le prenom : ");
            String prenom = sc.nextLine();
            System.out.print("saisir l'email : ");
            String email = sc.nextLine();
            System.out.print("saisir le salaire : ");
            int salaire = sc.nextInt();
            sc.nextLine();
            System.out.print("saisir la date de naissance : ");
            String date = sc.nextLine();

            String sql = "INSERT INTO formateur values(null, '"+nom+"','"+prenom+"','"+email+"',"+salaire+",'"+date+"')";
            psmt.executeUpdate(sql);
           //fermer la connexion
            psmt.close();
            cnx.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
