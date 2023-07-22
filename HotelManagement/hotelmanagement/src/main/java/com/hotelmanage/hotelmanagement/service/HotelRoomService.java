package com.hotelmanage.hotelmanagement.service;

import com.hotelmanage.hotelmanagement.model.HotelRoom;
import com.hotelmanage.hotelmanagement.repos.HotelRoomRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class HotelRoomService {

    private final HotelRoomRepository hotelRoomRepository;

    public HotelRoomService(final HotelRoomRepository hotelRoomRepository) {
        this.hotelRoomRepository = hotelRoomRepository;
    }

    public List<HotelRoom> findAll() {
        final List<HotelRoom> hotelRooms = hotelRoomRepository.findAll(Sort.by("id"));
        return hotelRooms.stream()
                .map(hotelRoom -> mapToDTO(hotelRoom, new HotelRoom()))
                .toList();
    }

    public Optional<Object> get(final Long id) {
        Optional<Object> o = hotelRoomRepository.findById(id)
                .map(hotelRoom -> mapToDTO(hotelRoom, new HotelRoom()));
        return o;
                
    }

    public Long create(final HotelRoom hotelroom) {
        final HotelRoom hotelRoom = new HotelRoom();
        mapToEntity(hotelroom, hotelRoom);
        return hotelRoomRepository.save(hotelRoom).getId();
    }

    public void update(final Long id, final HotelRoom hotelroom) {
        final HotelRoom hotelRoom;
        hotelRoom = hotelRoomRepository.findById(id).orElse(null);

        mapToEntity(hotelroom, hotelRoom);
        hotelRoomRepository.save(hotelRoom);
    }

    public void delete(final Long id) {
        hotelRoomRepository.deleteById(id);
    }

    private HotelRoom mapToDTO(final HotelRoom hotelRoom, final HotelRoom hotelroom) {
        hotelroom.setId(hotelRoom.getId());
        hotelroom.setRoomno(hotelRoom.getRoomno());
        hotelroom.setRoomPrice(hotelRoom.getRoomPrice());
        hotelroom.setRoomStatus(hotelRoom.getRoomStatus());
        hotelroom.setRoomType(hotelRoom.getRoomType());
        return hotelroom;
    }

    private HotelRoom mapToEntity(final HotelRoom hotelroom, final HotelRoom hotelRoom) {
        hotelRoom.setRoomno(hotelroom.getRoomno());
        hotelRoom.setRoomPrice(hotelroom.getRoomPrice());
        hotelRoom.setRoomStatus(hotelroom.getRoomStatus());
        hotelRoom.setRoomType(hotelroom.getRoomType());
        return hotelRoom;
    }

    public boolean roomnoExists(final Integer roomno) {
        return hotelRoomRepository.existsByRoomno(roomno);
    }

}
