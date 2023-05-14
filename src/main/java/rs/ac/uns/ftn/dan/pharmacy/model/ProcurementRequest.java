package rs.ac.uns.ftn.dan.pharmacy.model;

import rs.ac.uns.ftn.dan.pharmacy.model.enums.ReqStatus;

import java.sql.Timestamp;


public class ProcurementRequest {
    private Long id;
    private String reqReason;
    private int amount;
    private Vaccine vaccine;
    private Timestamp timestamp;
    private ReqStatus reqStatus;
    private String reqUnfulfillmentReason;
}
