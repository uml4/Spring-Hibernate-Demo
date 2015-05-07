
import com.pnv.models.Departments;
import com.pnv.utils.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class test {
     
    
    
    public static void main(String[] args) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
//       List<Employees> employees = session.createQuery("from Employees ").list();
//        for (Iterator<Employees> iterator = employees.iterator(); iterator.hasNext();) {
//            Employees next = iterator.next();
//            System.out.println(next.getEmpName());
//        }
      
       
//        
//        List<Titles> titles = session.createQuery("from Titles ").list();
//        for (Iterator<Titles> iterator = titles.iterator(); iterator.hasNext();) {
//            Titles next = iterator.next();
//            if (next.getEmployees().size() >0 ) {
//                System.out.println( next.getTitleName() + "----"+  next.getEmployees().get(0).getEmpName() );
//            }
//           
//        }
        
             List<Departments> departments = session.createQuery("from Departments ").list();
                      
        for (Iterator<Departments> iterator = departments.iterator(); iterator.hasNext();) {
            Departments next = iterator.next();
            if (next.getEmployees().size() >0 ) {
                System.out.println( next.getDepName() + "----"+  next.getEmployees().get(0).getEmpName() );
            }
           
        }
        
        
        session.close();
    }
}
