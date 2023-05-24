package com.nest.strykerwebappbackend.controller;

import com.nest.strykerwebappbackend.entity.ToolSet;
import com.nest.strykerwebappbackend.exception.ResourceNotFoundException;
import com.nest.strykerwebappbackend.repository.ToolSetRepository;
import com.nest.strykerwebappbackend.service.MyTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ToolSetController {

    @Autowired
    private ToolSetRepository toolSetRepository;

    @Autowired
    private MyTaskService myTaskService;

//    view toolset
    @GetMapping("/toolset")
    public List<ToolSet> viewToolset(){
        return myTaskService.view();
    }

//    add new toolset
    @PostMapping(value = "/toolset", produces = "application/json")
    public String createToolset(@RequestBody ToolSet toolSet) throws ParseException {
        myTaskService.createToolset(toolSet);
        return "success";    }

//    get toolset by id
    @GetMapping("/toolset/{id}")
    public ToolSet getById(@PathVariable Long id){
        return myTaskService.getById(id);
    }

//    update toolset
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces= "application/json",  consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateToolset(@PathVariable Long id, @RequestBody ToolSet toolSetDetails){
        ToolSet existingToolSet = myTaskService.getById(id);
        ToolSet updateToolset = myTaskService.updateTool(existingToolSet,toolSetDetails);
        return "Updated Successfully";
    }

//    delete toolset
    @DeleteMapping("/toolset/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteToolset(@PathVariable Long id){
        ToolSet tst = myTaskService.getById(id);
        myTaskService.delete(tst.getId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/toolset/category")
    public List<String> category(){
        return myTaskService.category();
    }


    @GetMapping("/check/{name}")
    public ResponseEntity<?> checkIfUserExists(@PathVariable("name") String name) {
        boolean toolsetExists = toolSetRepository.existsByName(name);
        return ResponseEntity.ok(toolsetExists);
    }


}
