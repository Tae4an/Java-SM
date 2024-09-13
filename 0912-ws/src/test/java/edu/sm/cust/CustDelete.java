package edu.sm.cust;

import edu.sm.dto.Cust;
import edu.sm.exception.NotFoundException;
import edu.sm.service.CustService;

public class CustDelete {
    public static void main(String[] args) {
        CustService custService = new CustService();
        String id = "id111";
        try {
            custService.remove(id);
        } catch (NotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}