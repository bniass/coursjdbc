package cours.ugb.ccos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main2 {
    public static void main( String[] args )
    {
        try {
            //connexion à la base de données
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jdbc_ugb";
            Connection cnx = DriverManager.getConnection(url,"root","");
            //Disposer d'un objet me permettant d'executer des requetes sql
            Statement psmt = cnx.createStatement();
            Scanner sc = new Scanner(System.in);
            System.out.print("saisir la date de naissance du formateur à rechercher: ");
            String date = sc.nextLine();
            String sql = "SELECT * FROM formateur WHERE dateNaissance = '"+date+"'";
            ResultSet rs = psmt.executeQuery(sql);
            //executer les requettes sql
            int id = 0;
            if(rs.next()){
                id = rs.getInt(1);
            }
            rs.close();
            if(id != 0){
                System.out.print("saisir le nom : ");
                String nom = sc.nextLine();
                System.out.print("saisir le prenom : ");
                String prenom = sc.nextLine();
                System.out.print("saisir l'email : ");
                String email = sc.nextLine();
                System.out.print("saisir le salaire : ");
                int salaire = sc.nextInt();
                sc.nextLine();

                sql = "UPDATE formateur SET nom='"+nom+"',prenom='"+prenom+"',email='"+email+"',salaire ="+salaire+" WHERE dateNaissance='"+date+"'";
                psmt.executeUpdate(sql);
            }
            else{
                System.out.println("Aucun formateur avec cette date n'a été trouvé !");
            }
            //fermer la connexion
            psmt.close();
            cnx.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
