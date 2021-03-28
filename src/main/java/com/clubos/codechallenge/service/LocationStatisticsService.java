package com.clubos.codechallenge.service;

import com.clubos.codechallenge.model.*;
import com.clubos.codechallenge.repository.MemberAgreementRepo;
import com.clubos.codechallenge.repository.MemberCheckinsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.*;


// TODO: Implement service logic for statistics
public class LocationStatisticsService {


  @Autowired
  private MemberCheckinsRepository memberCheckinsRepository;

  @Autowired
  private MemberAgreementRepo memberAgreementRepo;



  public List<String> resolveBusiestDaysOfWeek(final List<MemberCheckin> memberCheckins) throws IOException {

    List<String> list = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<String, Integer>();

    for (int i = 0; i < memberCheckins.size(); i++) {

      ZonedDateTime zonedDateTime = memberCheckins.get(i).getDate();
      String value = zonedDateTime.getDayOfWeek().toString();

      if (!map.containsKey(value)) {
        map.put(value, 1);
      } else {
        map.put(value, map.get(value) + 1);
      }
    }
    int maxValueInMap = (Collections.max(map.values()));
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() == maxValueInMap) {
        if (!list.contains(entry.getKey())) {
          list.add(entry.getKey());
        }
      }
    }

    return list;
  }

  public List<String> resolveMostPopularAgreements( final List<MemberAgreements> memberAgreements) {


    List<String> memberTypes = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();


    for (int i = 0; i < memberAgreements.size(); i++) {


      if (!map.containsKey(memberAgreements.get(i).getAgreementType())) {
        map.put(memberAgreements.get(i).getAgreementType(), 1);
      } else {
        map.put(memberAgreements.get(i).getAgreementType(), map.get(memberAgreements.get(i).getAgreementType()) + 1);
      }
    }

    int maxValueInMap = Collections.max(map.values());
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() == maxValueInMap) {
        if (!memberTypes.contains(entry.getKey())) {
          memberTypes.add(entry.getKey());
        }
      }
    }

    return memberTypes;
  }


  public List<String> resolveMostPopularAgreementsOnBd(final List<MemberAgreements> memberAgreements, final List<MemberCheckin> memberCheckins) throws IOException {

    List<String> list = resolveBusiestDaysOfWeek(memberCheckins);
    List<Integer> memberIdCorrespondece = new ArrayList<>();
    HashMap<String,Integer> map = new HashMap<String, Integer>();
    List<String> finalList = new ArrayList<>();
    List<String> memberAgreeCorrespondence = new ArrayList<>();

    for(MemberCheckin memberCheckin: memberCheckins){
      ZonedDateTime zonedDateTime = memberCheckin.getDate();
      String value = zonedDateTime.getDayOfWeek().toString();
      if(list.contains(value)){

        memberIdCorrespondece.add(memberCheckin.getMemberId());
      }
    }

    for(MemberAgreements memberAgreements1: memberAgreements){
      if(memberIdCorrespondece.contains(memberAgreements1.getMemberId())){
        memberAgreeCorrespondence.add(memberAgreements1.getAgreementType());
      }
    }

    for(String a: memberAgreeCorrespondence){
      if(!map.containsKey(a)){
        map.put(a,1);
      }
      else{
        map.put(a, map.get(a)+1);
      }
    }

    int maxValueInMap = Collections.max(map.values());
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() == maxValueInMap) {
        if (!finalList.contains(entry.getKey())) {
          finalList.add(entry.getKey());
        }
      }
    }

    return finalList;

  }
}





