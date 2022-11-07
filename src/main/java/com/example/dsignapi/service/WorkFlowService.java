package com.example.dsignapi.service;

import com.example.dsignapi.entity.User;
import com.example.dsignapi.entity.WorkFlow;
import com.example.dsignapi.entity.WorkFlowMembers;
import com.example.dsignapi.entity.dtos.WorkFlowDTO;
import com.example.dsignapi.repository.UserRepository;
import com.example.dsignapi.repository.WorkFlowMembersRepository;
import com.example.dsignapi.repository.WorkFlowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkFlowService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WorkFlowRepository workFlowRepository;
    @Autowired
    private WorkFlowMembersRepository workFlowMemberRepository;

    public WorkFlow saveWorkFlow(WorkFlow workFlow){
        return (WorkFlow) workFlowRepository.save(workFlow);
    }

    public List<WorkFlow> getWorkFlows(){
        return workFlowRepository.findAll();
    }
    public WorkFlow getWorkFlowByWid(int Wid){
        return (WorkFlow) workFlowRepository.findById(Wid).orElse(null);
    }

//    public User getUserByEmail(String Email, User user){
//        return repository.findByEmail(Email);
//    }


//    public User updateUser(int userId){
//        return (User) repository.findById(userId).orElse(null);
//    }

    public String deleteWorkFlow(int Wid){
        workFlowRepository.deleteById(Wid);
        return "Work Flow removed ||"+Wid;
    }
    public WorkFlow deleteAll() {
        workFlowRepository.deleteAll();
        return null;
    }

    public User workFlow1(WorkFlowDTO workFlowDTO) {
        User wf1 = userRepository.findByEmail(workFlowDTO.getEmail());

        if(wf1==null) {
//            throw  new RuntimeException("User not found");
            System.out.print("user not found!");
            return null;
        }
        else {
            return wf1;
        }
    }

    public WorkFlow workFlow2(WorkFlowDTO workFlowDTO) {
//        User workFlow1 = workFlowRepository.findByEmail(workFlowDTO.getEmail());
        WorkFlow wf2 = workFlowRepository.findByWid(workFlowDTO.getWid());
//        WorkFlowMembers workFlowMembers = workFlowService.findByWfId(workFlowDTO.getWfId());

        if(wf2==null) {
//            throw  new RuntimeException("User not found");
            System.out.print("user not found!");
            return null;
        }
        else {
            return wf2;
        }
    }

    public WorkFlowMembers workFlow3(WorkFlowDTO workFlowDTO) {
        WorkFlowMembers wf3 = workFlowMemberRepository.findByWfId(workFlowDTO.getWfId());

        if(wf3==null) {
//            throw  new RuntimeException("User not found");
            System.out.print("user not found!");
            return null;
        }
        else {
            return wf3;
        }
    }

}
