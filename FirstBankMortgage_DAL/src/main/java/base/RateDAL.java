package base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.RateDomainModel;
import domain.StudentDomainModel;
import util.HibernateUtil;

public class RateDAL {


	public static double getRate(int GivenCreditScore) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		RateDomainModel rate = null;	
		double interestRate = 0;
		
		try {
			tx = session.beginTransaction();	
									
			Query query = session.createQuery("from RateDomainModel where MinCreditScore = :score ");
			query.setParameter("score", Integer.toString(findMinScore(GivenCreditScore)));
			
			List<?> list = query.list();
			rate = (RateDomainModel)list.get(0);
			interestRate = rate.getInterestRate();
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return interestRate;
	}
	
	public static int findMinScore(int score) {
		if (score >= 800) { return 800; }
		else if (score >= 750) { return 750; }
		else if (score >= 700) { return 700; }
		else if (score >= 650) { return 650; }
		else if (score >= 600) { return 600; }
		else return 0;
	}
	
	
	public static ArrayList<RateDomainModel> getRates() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;		
		ArrayList<RateDomainModel> rates = new ArrayList<RateDomainModel>();
		
		try {
			tx = session.beginTransaction();	
			
			List lrates = session.createQuery("FROM RateDomainModel").list();
			for (Iterator iterator = lrates.iterator(); iterator.hasNext();) {
				RateDomainModel rate = (RateDomainModel) iterator.next();
				rates.add(rate);

			}
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return rates;
	}
	

}