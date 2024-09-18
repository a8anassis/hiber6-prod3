package gr.aueb.cf;

import gr.aueb.cf.model.Branch;
import gr.aueb.cf.model.BranchCategory;
import gr.aueb.cf.model.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school1PU");
        EntityManager em = emf.createEntityManager();

        Teacher androutsos = new Teacher(null, "Αθανάσιος", "Ανδρούτσος", true, null, null, null);
        BranchCategory pe = new BranchCategory(null, "ΠΕ", null, null);
        Branch pe80 = new Branch(null, "ΠΕ80", pe, null);

        pe80.addTeacher(androutsos);    // to do
        pe.addTeacher(androutsos);

        em.getTransaction().begin();

        em.persist(androutsos);
        em.persist(pe);
        em.persist(pe80);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
