package com.propertymanagement.Controller;

import com.propertymanagement.DTO.PropertyDto;
import com.propertymanagement.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    public PropertyService propertyService;

    @GetMapping("/property")
    public ResponseEntity<List<PropertyDto>> getAll()
    {
        try
        {
            List<PropertyDto>list=propertyService.getALl();
            if(list.isEmpty())
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(list);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/property/{id}")
    public ResponseEntity<PropertyDto> getById(@PathVariable("id") long id) {
        try {
            PropertyDto entity = propertyService.getById(id);
            if (entity == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/property")
    public ResponseEntity<PropertyDto> saveId(@RequestBody PropertyDto dto)
    {
        try {
            PropertyDto dto1 = propertyService.saveId(dto);
                return ResponseEntity.status(HttpStatus.CREATED).body(dto1);
            }

        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/property/{id}")
    public ResponseEntity<PropertyDto> editId(@RequestBody PropertyDto dto, @PathVariable ("id") long id)
    {
        try {
            PropertyDto entity1 = propertyService.editId(dto,id);
            return ResponseEntity.status(HttpStatus.CREATED).body(entity1);
        }

        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/property/{id}")
    public ResponseEntity<Void> delById(@PathVariable ("id") long id)
    {
        try {
            propertyService.delId(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }





}
