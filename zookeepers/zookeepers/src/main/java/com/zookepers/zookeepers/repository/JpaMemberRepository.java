// package com.zookepers.zookeepers.repository;

// import javax.persistence.EntityManager;
// import javax.persistence.EntityManagerFactory;
// import javax.persistence.EntityTransaction;
// import javax.persistence.Persistence;

// import org.springframework.stereotype.Repository;

// import com.zookepers.zookeepers.domain.Member;

// @Repository
// public class JpaMemberRepository implements MemberRepository{
    
//     @Override
//     public Member save(Member member){
//         EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
//         EntityManager em = emf.createEntityManager();
//         EntityTransaction tx = em.getTransaction();

//         try{
//             System.out.println("됐을지도?");
//             tx.begin();
//             em.persist(member);
//             tx.commit();
//         } catch(Exception ex){
//             System.out.println("안댐omg;;");
//             tx.rollback();
//             throw ex;
//         } finally {
//             em.close();
//         }
//         return member;
//     }
// }
