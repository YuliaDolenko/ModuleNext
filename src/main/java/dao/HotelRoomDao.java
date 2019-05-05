package dao;

import entity.HotelRoom;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class HotelRoomDao {

    public HotelRoom getHotelRoom(int id) {
        Transaction transaction = null;
        HotelRoom hotelRoom = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            hotelRoom = session.get(HotelRoom.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return hotelRoom;
    }


    public void updateHotelRoom(HotelRoom hotelRoom) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(hotelRoom);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

}
