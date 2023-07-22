package com.hotelmanage.hotelmanagement.controller;



import com.hotelmanage.hotelmanagement.model.HotelRoom;
import com.hotelmanage.hotelmanagement.service.HotelRoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hotelrooms")
public class HotelRoomController {

    private final HotelRoomService hotelRoomService;

    public HotelRoomController(HotelRoomService hotelRoomService) {
        this.hotelRoomService = hotelRoomService;
    }

    @GetMapping
    public ResponseEntity<List<HotelRoom>> getAllHotelRooms() {
        List<HotelRoom> hotelRooms = hotelRoomService.findAll();
        return new ResponseEntity<>(hotelRooms, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getHotelRoom(@PathVariable Long id) {
        Optional<Object> hotelRoom = hotelRoomService.get(id);
        if (hotelRoom.isPresent()) {
            return new ResponseEntity<>(hotelRoom.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Long> createHotelRoom(@RequestBody HotelRoom hotelRoom) {
        if (hotelRoomService.roomnoExists(hotelRoom.getRoomno())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        Long createdHotelRoomId = hotelRoomService.create(hotelRoom);
        return new ResponseEntity<>(createdHotelRoomId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateHotelRoom(@PathVariable Long id, @RequestBody HotelRoom hotelRoom) {
        if (!hotelRoomService.roomnoExists(hotelRoom.getRoomno())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        hotelRoomService.update(id, hotelRoom);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotelRoom(@PathVariable Long id) {
        hotelRoomService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
