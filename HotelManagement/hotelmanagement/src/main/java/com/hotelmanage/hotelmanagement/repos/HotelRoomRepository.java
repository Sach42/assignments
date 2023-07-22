package com.hotelmanage.hotelmanagement.repos;

import com.hotelmanage.hotelmanagement.model.HotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HotelRoomRepository extends JpaRepository<HotelRoom, Long> {

    boolean existsByRoomno(Integer roomno);

}
