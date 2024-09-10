package repository;

import dto.Cust;
import frame.Db;

import java.util.ArrayList;
import java.util.List;

public class CustDb implements Db<String, Cust> {

    @Override
    public void insert(Cust cust) throws  Exception {
        System.out.println("Insert cust" + cust.getName());
    }

    @Override
    public void update(Cust cust) throws  Exception {
        System.out.println("Update cust" + cust.getName());
    }

    @Override
    public void delete(String s) throws  Exception {
        System.out.println("Delete cust" + s);
    }

    @Override
    public Cust select(String s) throws  Exception {
        Cust cust = new Cust();
        cust = new Cust(s,"pw", "최태산");
        return cust;
    }

    @Override
    public List<Cust> select() throws  Exception {
        List<Cust> custs = new ArrayList<Cust>();
        custs.add(new Cust("111","pw","장태산"));
        custs.add(new Cust("222","pw","김태산"));
        custs.add(new Cust("333","pw","박태산"));
        custs.add(new Cust("444","pw","이태산"));
        return custs;
    }

    @Override
    public List<Cust> searchByName(String name) throws Exception {
        List<Cust> custs = new ArrayList<Cust>();
        custs.add(new Cust("111","pw","장태산"));
        custs.add(new Cust("222","pw","장태산"));
        custs.add(new Cust("333","pw","장태산"));
        custs.add(new Cust("444","pw","장태산"));
        return custs;
    }
}
