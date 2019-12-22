    package com.example.test.controller;

import com.example.test.dto.LaptopDto;
import com.example.test.model.Laptop;
import org.modelmapper.ModelMapper;

import com.example.test.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/laptop")
public class LaptopController {

    @Autowired
    private LaptopRepository repo;

    private ModelMapper modelMapper = new ModelMapper();

    private static final String CONST_DATA		= "data";
    private static final String CONST_STATUS	= "status";
    private static final String CONST_MSG		= "message";

    @GetMapping("/list")
    public ResponseEntity<HashMap<String, Object>> getData() throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        try {
            List<Laptop> list = repo.findAll();
            data.put(CONST_DATA, list);
            data.put(CONST_STATUS, HttpStatus.OK);
            data.put(CONST_MSG, "List Of Laptop");
        } catch (Exception e) {
            data.put(CONST_STATUS, HttpStatus.INTERNAL_SERVER_ERROR);
            data.put(CONST_MSG, e.getMessage());
        }
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<HashMap<String, Object>> insertData(@RequestBody LaptopDto dto) throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        Laptop laptop = modelMapper.map(dto, Laptop.class);
        try {
            repo.save(laptop);
            data.put(CONST_DATA, laptop);
            data.put(CONST_STATUS, HttpStatus.OK);
            data.put(CONST_MSG, "Success Insert Data");
        } catch (Exception e) {
            data.put(CONST_STATUS, HttpStatus.INTERNAL_SERVER_ERROR);
            data.put(CONST_MSG, e.getMessage());
        }
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<HashMap<String, Object>> updateData(@RequestBody LaptopDto dto) throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        try {
            Optional<Laptop> list = repo.findById(dto.getId());
            if (list.isPresent()) {

                list.get().setLaptopName(dto.getLaptopName() != null ? dto.getLaptopName() : list.get().getLaptopName());
                list.get().setBrand(dto.getBrand() != null ? dto.getBrand() : list.get().getBrand());
                list.get().setModel(dto.getModel() != null ? dto.getModel() : list.get().getModel());
                list.get().setColor(dto.getColor() != null ? dto.getColor() : list.get().getColor());
                list.get().setProcessor(dto.getProcessor() != null ? dto.getProcessor() : list.get().getProcessor());
                list.get().setClockSpeed(dto.getClockSpeed() != null ? dto.getClockSpeed() : list.get().getClockSpeed());
                list.get().setVga(dto.getVga() != null ? dto.getVga() : list.get().getVga());
                list.get().setRamCapacity(dto.getRamCapacity() != null ? dto.getRamCapacity() : list.get().getRamCapacity());
                list.get().setHddCapacity(dto.getHddCapacity() != null ? dto.getHddCapacity() : list.get().getHddCapacity());
                list.get().setPrice(dto.getPrice() != null ? dto.getPrice() : list.get().getPrice());

                repo.save(list.get());
                data.put(CONST_DATA, list.get());
                data.put(CONST_STATUS, HttpStatus.OK);
                data.put(CONST_MSG, "Success Update Data");
            }
        } catch (Exception e) {
            data.put(CONST_STATUS, HttpStatus.INTERNAL_SERVER_ERROR);
            data.put(CONST_MSG, e.getMessage());
        }
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<HashMap<String, Object>> deleteData(@RequestBody LaptopDto dto) throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        long id	= Long.parseLong(dto.getId().toString());
        try {
            Optional<Laptop> list = repo.findById(id);
            if (list.isPresent()) {
                repo.delete(list.get());
                data.put(CONST_DATA, list.get());
                data.put(CONST_STATUS, HttpStatus.OK);
                data.put(CONST_MSG, "Success Delete Data");
            }
        } catch (Exception e) {
            data.put(CONST_STATUS, HttpStatus.INTERNAL_SERVER_ERROR);
            data.put(CONST_MSG, e.getMessage());
        }
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
