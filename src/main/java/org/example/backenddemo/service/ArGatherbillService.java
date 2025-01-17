package org.example.backenddemo.service;

import org.example.backenddemo.entity.ArGatherbill;

import java.util.Map;

public interface ArGatherbillService {

    String inputValidate(Map<String, Object> arGatherbill);

    ArGatherbill getGatherbillByPk(String pk_gatherbill);

    boolean isGatherbillExist(String pk_gatherbill);


}
