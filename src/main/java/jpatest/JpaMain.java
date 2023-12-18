package jpatest;

import jakarta.persistence.*;
import jpaBook.jpashop.domain.Member;
import jpatest.jpatestdomain.TestMember;
import jpatest.jpatestdomain.TestTeam;

import java.util.List;

public class JpaMain {

    public static void main(String[] args){

        /**
         * JPA의 모든 데이터 변경은 트랜잭션 안에서 실행!!! 매우 중요!!
         */

        //애플리케이션 로딩 시점에 딱!!! 하나만 만들어 놓아야 함.
        //META-INF -> persistence.xml -> <persistence-unit name="jpa">의 name을 참조해서 사용
        //EntityManagerFactory -> EntityManager -> EntityTransaction
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");

        //트랜잭션 단위마다.
        //쓰레드간에 공유 절대 안됨!!!
        //사용하고 버려야 함
        EntityManager em = emf.createEntityManager();
        //트랜잭션 시작
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            /*
            생성
            Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");

            em.persist(member);
            */

            /*
            조회
            Member findMember = em.find(Member.class, 1L);
            */

            /*
            삭제
            Member findMember = em.find(Member.class, 1L);
            em.remove(findMember);
             */

            /*
            수정
            //가져오는 순간 JPA가 가지고 있으면서 트랜잭션이 끝나기 전까지 관리 함
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA");
             */

            //JPQL -- 맴버 객체를 대상 (테이블 아님)
            //JPQL -- JPA는 SQL을 추상화한 JPQL이라는 객체 지향 쿼리 언어 제공 (방언 제공)
            /*
            List<Member> result =  em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();

            for(int i=0; i<result.size(); i++){
                System.out.println("member.name : "+ result.get(i).getName());
            }*/

            //준영속성 컨텍스트
            //em.detach(member);

            //완전 초기화
            //em.clear();

            //저장

            TestTeam team = new TestTeam();
            team.setName("TeamA");
            em.persist(team);

            TestMember member = new TestMember();
            member.setUsername("member1");
            member.changeTeam(team); // 팀과 맴버를 같이 저장하는 메서드
            em.persist(member);

            //em.flush();
            //em.clear();

            TestTeam findTeam = em.find(TestTeam.class, team.getId());  //1차 캐시
            List<TestMember> members = findTeam.getTestMembers();

            System.out.println("members : "+findTeam.toString());

            //커밋
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            //트랜잭션을 사용하고 나면 꼭!!! 닫아 주어야 한다.
            em.close();
        }
        //was가 내려가면 닫아야 함
        //끝나면 팩토리를 닫아줘야 함
        emf.close();
    }
}
