package com.example.dsignapi.controller;

import com.example.dsignapi.entity.User;
import com.example.dsignapi.entity.WorkFlow;
import com.example.dsignapi.entity.WorkFlowMembers;
import com.example.dsignapi.entity.dtos.LoginDTO;
import com.example.dsignapi.entity.dtos.WorkFlowDTO;
import com.example.dsignapi.service.UserService;
import com.example.dsignapi.service.WorkFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkFlowController {

    @Autowired
    private WorkFlowService workFlowService;

    @PostMapping("/addWorkFlow")
    public WorkFlow addWorkFlow(@RequestBody WorkFlow workFlow){
        return workFlowService.saveWorkFlow(workFlow);
    }

    @PostMapping("/addMember")
    public WorkFlowDTO addMemberByEmail(@RequestBody WorkFlowDTO dto){
        User user = workFlowService.workFlow1(dto);
        WorkFlow workFlow = workFlowService.workFlow2(dto);
        WorkFlowMembers workFlowMembers = workFlowService.workFlow3(dto);

        return new WorkFlowDTO(user.getEmail(),workFlow.getWid(),workFlowMembers.getWfId());

    }

    @GetMapping("/workflows")
    public List<WorkFlow> findAllWorkFlow(){
        return workFlowService.getWorkFlows();
    }

    @GetMapping("/workflow/{workflowId}")
    public WorkFlow findWorkFlowById(@PathVariable int userId){
        return workFlowService.getWorkFlowByWid(userId);
    }

    @DeleteMapping("/delete/{Wid}")
    public String deleteWorkFlow(@PathVariable int Wid){
        return workFlowService.deleteWorkFlow(Wid);
    }




}
