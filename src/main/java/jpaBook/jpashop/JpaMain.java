package jpaBook.jpashop;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jpaBook.jpashop.domain.*;
import org.hibernate.Hibernate;

import javax.swing.plaf.metal.MetalMenuBarUI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");

        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        et.begin();

        try {

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Member> query = cb.createQuery(Member.class);

            Root<Member> m = query.from(Member.class);

            CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("name"),"kim"));
            List<Member> resultList = em.createQuery(cq).getResultList();



            et.commit();
        }catch (Exception e){
            et.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();


    }

    private static void printMember(Member member) {
        System.out.println("member = "+member.getName());
    }

    private static void printMemberAndTeam(Member member) {

        String memberName = member.getName();
        System.out.println("memberName : "+memberName);

        Team team = member.getTeam();
        System.out.println("teamName = "+ team.getName());

    }
}
