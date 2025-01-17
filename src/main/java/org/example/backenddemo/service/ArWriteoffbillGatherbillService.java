package org.example.backenddemo.service;

import org.example.backenddemo.entity.ArWriteoffbillGatherbill;

import java.util.Map;

public interface ArWriteoffbillGatherbillService {

    ArWriteoffbillGatherbill inputValidate(Map<String, Object> arWriteoffbillGatherbill);

    String insertArWriteoffbillGatherbill(ArWriteoffbillGatherbill arWriteoffbillGatherbill);
}
